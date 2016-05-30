package xyz.dimonick.JsonToXls.Tools.Excel;


import xyz.dimonick.JsonToXls.POJO.Visitor;

import java.text.SimpleDateFormat;

/*
   Converter visitors in excel file
*/

public class VisitorToExcel {

    public static void convert(String filepath, Visitor visitor){
        Excel excel = new Excel(filepath);
        excel.setFirstName(visitor.getFirstName());
        excel.setLastName(visitor.getLastName());
        excel.setMACAddress(visitor.getMacAddress());
        excel.setGender(visitor.getGender());
        excel.setEmail(visitor.getEmail());
        excel.setPhone(visitor.getPhone());
        excel.setCountry(visitor.getCountry());
        excel.setCity(visitor.getCity());
        excel.setDeviceTypeOs(visitor.getDeviceType() + "/" + visitor.getOs());
        excel.setVk(visitor.getVkID());
        excel.setFacebook(visitor.getFacebookID());
        excel.setComment(visitor.getComment());
        excel.setOccupation(visitor.getOccupation());
        excel.setPictures(visitor.getImages().get(0));
        excel.setImagesLinks(visitor.getImages());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(visitor.getDateOfBirth());
        excel.setDateOfBirth(date);
        excel.saveToFile();
    }
}
