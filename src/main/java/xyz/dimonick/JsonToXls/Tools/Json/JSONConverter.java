package xyz.dimonick.JsonToXls.Tools.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import xyz.dimonick.JsonToXls.POJO.Visitor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/*
   Converter from JSON to Visitor object.
*/
public class JSONConverter {


    public static Visitor convert(String json)

    {
        Visitor visitor = new Visitor();

        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(json);
        } catch (ParseException e) {
            System.err.println("Invalid json format " + e);
        }
        JSONObject jsonObj = (JSONObject) obj;
        JSONObject jvisitor = (JSONObject) jsonObj.get("visitor");
        JSONArray ocupation = (JSONArray) jvisitor.get("occupation");
        JSONArray images = (JSONArray) jvisitor.get("images");
        JSONObject birthday = (JSONObject) jvisitor.get("birthDate");
        long day = (Long)birthday.get("day");
        long month = (Long)birthday.get("month") - 1;
        long year = (Long)birthday.get("year");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, (int)year);
        cal.set(Calendar.MONTH, (int)month);
        cal.set(Calendar.DAY_OF_MONTH, (int)day);
        Date date = cal.getTime();

        visitor.setDateOfBirth(date);
        visitor.setFirstName((String)jvisitor.get("firstName"));
        visitor.setLastName((String)jvisitor.get("lastName"));
        visitor.setMacAddress((String)jvisitor.get("macAddress"));
        visitor.setEmail((String)jvisitor.get("email"));
        visitor.setGender((String)jvisitor.get("gender"));
        visitor.setPhone((String)jvisitor.get("phoneNumber"));
        visitor.setCountry((String)jvisitor.get("country"));
        visitor.setCity((String)jvisitor.get("city"));
        visitor.setDeviceType((String)jvisitor.get("device"));
        visitor.setOs((String)jvisitor.get("OS"));
        visitor.setFacebookID((String)jvisitor.get("facebookProfile"));
        visitor.setVkID((String)jvisitor.get("vkontakteProfile"));
        visitor.setComment((String)jvisitor.get("comment"));
        visitor.setOccupation(convertToArrayList(ocupation));
        visitor.setImages(convertToArrayList(images));

        return visitor;
    }

    private static ArrayList<String> convertToArrayList(JSONArray jArray){
        ArrayList<String> listdata = new ArrayList<String>();
        if (jArray != null) {
            for (int i=0;i < jArray.size(); i++){
                listdata.add(jArray.get(i).toString());
            }
        }
        return listdata;
    }
}
