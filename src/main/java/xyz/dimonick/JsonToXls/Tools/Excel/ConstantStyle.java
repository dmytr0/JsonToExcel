package xyz.dimonick.JsonToXls.Tools.Excel;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Map;

/*
    Prepared style for excel cell.
*/

public class ConstantStyle {

    private Font font12;
    private Font font10;
    private Map<Integer, String> enumVisitorDetails;
    private XSSFWorkbook wb;
    private CellStyle borderTop;
    private CellStyle borderBot;
    private CellStyle borderLeft;
    private CellStyle borderRight;
    private CellStyle borderTR;
    private CellStyle borderTL;
    private CellStyle borderBR;
    private CellStyle borderBL;
    private CellStyle borderLR;
    private CellStyle borderLBR;

    ConstantStyle (XSSFWorkbook wb){
        this.wb = wb;
        fillFonts();
        fillenumVisitorDetails();
        fillBorders();
    }

    private void fillBorders() {
        borderTop = wb.createCellStyle();
        borderBot = wb.createCellStyle();
        borderLeft = wb.createCellStyle();
        borderRight = wb.createCellStyle();
        borderTR = wb.createCellStyle();
        borderTL = wb.createCellStyle();
        borderBR = wb.createCellStyle();
        borderBL = wb.createCellStyle();
        borderLR = wb.createCellStyle();
        borderLBR = wb.createCellStyle();

        borderBot.setBorderBottom(CellStyle.BORDER_THIN);
        borderLeft.setBorderLeft(CellStyle.BORDER_THIN);
        borderRight.setBorderRight(CellStyle.BORDER_THIN);
        borderTop.setBorderTop(CellStyle.BORDER_THIN);
        borderTR.setBorderTop(CellStyle.BORDER_THIN);
        borderTR.setBorderRight(CellStyle.BORDER_THIN);
        borderTL.setBorderTop(CellStyle.BORDER_THIN);
        borderTL.setBorderLeft(CellStyle.BORDER_THIN);
        borderBR.setBorderBottom(CellStyle.BORDER_THIN);
        borderBR.setBorderRight(CellStyle.BORDER_THIN);
        borderBL.setBorderBottom(CellStyle.BORDER_THIN);
        borderBL.setBorderLeft(CellStyle.BORDER_THIN);
        borderLR.setBorderLeft(CellStyle.BORDER_THIN);
        borderLR.setBorderRight(CellStyle.BORDER_THIN);
        borderLBR.setBorderLeft(CellStyle.BORDER_THIN);
        borderLBR.setBorderRight(CellStyle.BORDER_THIN);
        borderLBR.setBorderBottom(CellStyle.BORDER_THIN);

        borderBL.setFont(getFont10());
        borderBR.setFont(getFont10());
        borderLeft.setFont(getFont10());
        borderRight.setFont(getFont10());
        borderTop.setFont(getFont10());
        borderBot.setFont(getFont10());
        borderTR.setFont(getFont10());
        borderTL.setFont(getFont10());
        borderLR.setFont(getFont10());
        borderLBR.setFont(getFont10());

        borderBL.setWrapText(true);
        borderBR.setWrapText(true);
        borderLeft.setWrapText(true);
        borderRight.setWrapText(true);
        borderTop.setWrapText(true);
        borderBot.setWrapText(true);
        borderTR.setWrapText(true);
        borderTL.setWrapText(true);

        borderBL.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderBR.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderLeft.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderRight.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderTop.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderBot.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderTR.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        borderTL.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        XSSFFont hlinkfont = wb.createFont();
        hlinkfont.setUnderline(XSSFFont.U_SINGLE);
        hlinkfont.setColor(HSSFColor.BLUE.index);
        borderLBR.setFont(hlinkfont);
        borderLR.setFont(hlinkfont);

}

    private void fillFonts(){
        font12 = wb.createFont();
        font12.setFontHeightInPoints((short)12);
        font12.setFontName("Arial");
        font12.setColor(IndexedColors.WHITE.getIndex());

        font10 = wb.createFont();
        font10.setFontHeightInPoints((short)10);
        font10.setFontName("Arial");
    }

    private void fillenumVisitorDetails(){
        enumVisitorDetails = new HashMap<Integer, String>();
        enumVisitorDetails.put(2,"First name");
        enumVisitorDetails.put(3,"Last Name");
        enumVisitorDetails.put(4,"MAC address");
        enumVisitorDetails.put(5,"Gender");
        enumVisitorDetails.put(6,"Date of birth");
        enumVisitorDetails.put(7,"Email");
        enumVisitorDetails.put(8,"Phone");
        enumVisitorDetails.put(9,"Country");
        enumVisitorDetails.put(10,"City");
        enumVisitorDetails.put(11,"Device type/OS");
        enumVisitorDetails.put(12,"Vk ID");
        enumVisitorDetails.put(13,"Facebook ID");
        enumVisitorDetails.put(14,"Comment");
        enumVisitorDetails.put(17,"Occupation");
    }


    public Font getFont12() {
        return font12;
    }

    public void setFont12(Font font12) {
        this.font12 = font12;
    }

    public Font getFont10() {
        return font10;
    }

    public void setFont10(Font font10) {
        this.font10 = font10;
    }

    public Map<Integer, String> getEnumVisitorDetails() {
        return enumVisitorDetails;
    }

    public CellStyle getBorderTop() {
        return borderTop;
    }

    public CellStyle getBorderBot() {
        return borderBot;
    }

    public CellStyle getBorderLeft() {
        return borderLeft;
    }

    public CellStyle getBorderRight() {
        return borderRight;
    }

    public CellStyle getBorderTR() {
        return borderTR;
    }

    public CellStyle getBorderTL() {
        return borderTL;
    }

    public CellStyle getBorderBR() {
        return borderBR;
    }

    public CellStyle getBorderBL() {
        return borderBL;
    }

    public CellStyle getBorderLR() {
        return borderLR;
    }

    public CellStyle getBorderLBR() {
        return borderLBR;
    }
}
