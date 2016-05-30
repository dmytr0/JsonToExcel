package xyz.dimonick.JsonToXls.Tools.Excel;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/*
    Create and work with a template excel.
*/

public class Excel {

    private String filepath;
    private XSSFWorkbook wb;
    private ConstantStyle constSt;
    private Sheet visitor;
    private Sheet images;
    private String visDetailsLable = "Visitor details";
    private String imagesLable = "Image links";
    private String imgLable = "Images";
    private String occupLable = "Occupation";
    private String usrImgLable = "User image";

    public Excel (String filepath){
        this.filepath = filepath;
        createPattern();
    }

    // Сreating excel pattern.
    private void createPattern(){
        wb =  new XSSFWorkbook();
        constSt = new ConstantStyle(wb);
        visitor = wb.createSheet(visDetailsLable);
        images = wb.createSheet(imgLable);
        fillHeaders();
        createTableTwoColumn(2, 14);
        createTableTwoColumn(17, 30);
        fillFieldsName();
        createImageTable();

    }

    // Filling images sheet.
    public void setImagesLinks(List<String> list){
        int startRow = 2;
        int endRow = startRow + list.size() - 1;
        if(list != null) {
            for (int i = startRow, j=0; i <= endRow; i++, j++) {
                Cell cell = images.createRow(i).createCell(1);
                cell.setCellValue(list.get(j));
                CreationHelper createHelper = wb.getCreationHelper();
                XSSFHyperlink link = (XSSFHyperlink)createHelper
                        .createHyperlink(Hyperlink.LINK_URL);
                link.setAddress(list.get(j));
                cell.setHyperlink(link);
                if(i != endRow) {
                    cell.setCellStyle(constSt.getBorderLR());
                }
                else{
                    cell.setCellStyle(constSt.getBorderLBR());
                }
            }
        }
    }

    // Saving excel to file.
    public void saveToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            System.err.println("Error writing file. " + e);
        }
    }

    // Filling headers of tables.
    void fillHeaders(){
        XSSFCellStyle headerStyle = wb.createCellStyle();
        visitor.setColumnWidth(1, 8000);
        visitor.setColumnWidth(2, 8000);
        visitor.setColumnWidth(4, 3500);
        visitor.setColumnWidth(5, 3500);
        visitor.setColumnWidth(6, 3500);
        images.setColumnWidth(1, 15000);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        headerStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(28, 69, 135)));
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(constSt.getFont12());
        headerStyle.setBorderBottom(CellStyle.BORDER_THIN );
        headerStyle.setBorderLeft(CellStyle.BORDER_THIN );
        headerStyle.setBorderRight(CellStyle.BORDER_THIN );
        headerStyle.setBorderTop(CellStyle.BORDER_THIN );
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER );
        Row row1 = visitor.createRow(1);
        Row row16 = visitor.createRow(16);
        Row imgRow1 = images.createRow(1);
        row1.setHeight((short)500);
        row16.setHeight((short)500);
        Cell c11 = row1.createCell(1);
        Cell c12 = row1.createCell(2);
        Cell c14 = row1.createCell(4);
        Cell c15 = row1.createCell(5);
        Cell c16 = row1.createCell(6);
        Cell c161 = row16.createCell(1);
        Cell c162 = row16.createCell(2);
        Cell imgHeader = imgRow1.createCell(1);
        imgHeader.setCellValue(imagesLable);
        c11.setCellValue(visDetailsLable);
        c14.setCellValue(usrImgLable);
        c161.setCellValue(occupLable);
        imgHeader.setCellStyle(headerStyle);
        c11.setCellStyle(headerStyle);
        c12.setCellStyle(headerStyle);
        c15.setCellStyle(headerStyle);
        c16.setCellStyle(headerStyle);
        c14.setCellStyle(headerStyle);
        c161.setCellStyle(headerStyle);
        c162.setCellStyle(headerStyle);
        visitor.addMergedRegion(new CellRangeAddress(1,1,1,2));
        visitor.addMergedRegion(new CellRangeAddress(1,1,4,6));
        visitor.addMergedRegion(new CellRangeAddress(16,16,1,2));

    }

    // Create table with two columns.
    private void createTableTwoColumn(int startRow, int endRow){

        for(int i = startRow; i<= endRow; i++){
            Row row = visitor.getRow(i);
            if(row == null){
                row = visitor.createRow(i);
            }
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);
            if(i == endRow ){
                cell1.setCellStyle(constSt.getBorderBL());
                cell2.setCellStyle(constSt.getBorderBR());
            }else{
                cell1.setCellStyle(constSt.getBorderLeft());
                cell2.setCellStyle(constSt.getBorderRight());
            }
        }

    }

    // Filling the fields names
    private void fillFieldsName(){
        for(int i = 2 ; i<= 17; i++){
            Cell cell = null;
            try {
                cell = visitor.getRow(i).getCell(1);
            }
            catch (Exception e){

            }
            if(cell != null && constSt.getEnumVisitorDetails().get(i) != null){
                cell.setCellValue(constSt.getEnumVisitorDetails().get(i));
            }
        }
    }

    // Insert user images.
    private void createImageTable(){
        int startRow = 2;
        int endRow = 12;
        for(int i = startRow; i<= endRow; i++){
            Row row = visitor.getRow(i);
            Cell cell4 = row.createCell(4);
            Cell cell5 = row.createCell(5);
            Cell cell6 = row.createCell(6);
            if(i == endRow){
                cell4.setCellStyle(constSt.getBorderBL());
                cell5.setCellStyle(constSt.getBorderBot());
                cell6.setCellStyle(constSt.getBorderBR());
            }else{
                cell4.setCellStyle(constSt.getBorderLeft());
                cell6.setCellStyle(constSt.getBorderRight());
            }
        }
    }

    public void setPictures(String url){

        InputStream is = null;
        byte[] bytes = new byte[0];
        try {
            URL oracle = new URL(url);
            is = oracle.openStream();
            bytes = IOUtils.toByteArray(is);
        }
        catch (IOException e) {
            System.err.println("Invalid pictures! " + e);
        }
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreationHelper helper = wb.getCreationHelper();
        Drawing drawing = visitor.createDrawingPatriarch();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(4);
        anchor.setRow1(2);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize(3,11);
    }
    public void setParametr(String param, String value){
        if(!"Occupation".equals(param)){
            for(Map.Entry<Integer,String> entry: constSt.getEnumVisitorDetails().entrySet()){
                if(entry.getValue().equals(param)){
                    Cell cell = visitor.getRow(entry.getKey()).getCell(2);
                    cell.setCellValue(value);
                }
            }
        }
    }
    public void setOccupation(List<String> listOccupation){
        int startRow = 17;
        for(int i = startRow, j = 0; i < (startRow + listOccupation.size()); i++, j++){
            Row row = visitor.getRow(i);
            if(row == null) {
                row = visitor.createRow(i);
            }
            Cell cell = row.getCell(2);
            if(cell == null){
                cell = row.createCell(2);
            }
            cell.setCellValue(listOccupation.get(j));
        }
    }
    public void setFirstName(String value){
        setParametr("First name", value);
    }
    public void setLastName(String value){
        setParametr("Last Name", value);
    }
    public void setMACAddress(String value){
        setParametr("MAC address", value);
    }
    public void setGender(String value){
        setParametr("Gender", value);
    }
    public void setDateOfBirth(String value){
        setParametr("Date of birth", value);
    }
    public void setEmail(String value){
        setParametr("Email", value);
    }
    public void setCountry(String value){
        setParametr("Country", value);
    }
    public void setPhone(String value){
        setParametr("Phone", value);
    }
    public void setCity(String value){
        setParametr("City", value);
    }
    public void setDeviceTypeOs(String value){
        setParametr("Device type/OS", value);
    }
    public void setVk(String value){
        setParametr("Vk ID", value);
    }
    public void setFacebook(String value){
        setParametr("Facebook ID", value);
    }
    public void setComment(String value){
        setParametr("Comment", value);
    }



}
