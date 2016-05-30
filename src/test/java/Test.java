import xyz.dimonick.JsonToXls.POJO.Visitor;
import xyz.dimonick.JsonToXls.Tools.DB.VisitorStorage;
import xyz.dimonick.JsonToXls.Tools.Json.JSONConverter;
import xyz.dimonick.JsonToXls.Tools.Excel.VisitorToExcel;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"visitor\": {\n" +
                "    \"images\": [\n" +
                "      \"https://pp.vk.me/c7003/v7003978/1ed9/yoeGXOWmW-M\",\n" +
                "      \"https://cs7058.vk.me/c540107/v540107859/2db60/Db-kBdt2GJQ.jpg\",\n" +
                "\t  \"https://pp.vk.me/c7011/v7011852/40bb5/w-sRUUGU4ik.jpg\"\n" +
                "    ],\n" +
                "    \"macAddress\": \"ab-cd-ef-01-23-45\",\n" +
                "    \"firstName\": \"Dmytro\",\n" +
                "    \"lastName\": \"Polishchuk\",\n" +
                "    \"birthDate\": {\n" +
                "      \"day\": 25,\n" +
                "      \"month\": 5,\n" +
                "      \"year\": 1990\n" +
                "    },\n" +
                "    \"email\": \"dimonick@bk.ru\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"phoneNumber\": \"+380936667771\",\n" +
                "    \"country\": \"Ukraine\",\n" +
                "    \"city\": \"Kiev\",\n" +
                "    \"device\": \"mobile\",\n" +
                "    \"OS\": \"Android\",\n" +
                "    \"facebookProfile\": \"https://www.facebook.com/dmitriy.polishchuk.94\",\n" +
                "    \"vkontakteProfile\": \"https://vk.com/polya90\",\n" +
                "    \"comment\": \",kf ,fksdf ,sadf asdkf ,sdfkkasdf, aksdf ,kads,kij , ,sdk,f asidfjiruhiuwhfW FWFYUWG YUW kjdhjs fheq fb sjhfreq fyuw\t k\",\n" +
                "    \"occupation\": [\n" +
                "      \"student\",\n" +
                "      \"freelance\",\n" +
                "      \"school\",\n" +
                "\t  \"house\",\n" +
                "\t  \"work\",\n" +
                "\t  \"projects\",\n" +
                "\t  \"other\",\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";

        Visitor visitor = JSONConverter.convert(json);
        VisitorToExcel.convert("visitor.xlsx", visitor);
        VisitorStorage visitorStorage = new VisitorStorage();
        try {
            visitorStorage.save(visitor);
        } catch (SQLException e) {
            System.err.println("Sql exception! " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("It can be loaded JDBC driver! " + e);;
        }

    }
}
