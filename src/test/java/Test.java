import xyz.dimonick.JsonToXls.POJO.Visitor;
import xyz.dimonick.JsonToXls.Tools.DB.VisitorStorage;
import xyz.dimonick.JsonToXls.Tools.Excel.VisitorToExcel;
import xyz.dimonick.JsonToXls.Tools.Json.JSONConverter;

import java.io.*;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {

        String json = read("src//test//resources//json.txt");
        if(json != null) {
            Visitor visitor = JSONConverter.convert(json);
            VisitorToExcel.convert("visitor.xlsx", visitor);
            VisitorStorage visitorStorage = new VisitorStorage();
            try {
                visitorStorage.save(visitor);
            } catch (SQLException e) {
                System.err.println("Sql exception! " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("It can be loaded JDBC driver! " + e);
                ;
            }
        }

    }

    public static String read(String fileName) {

        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                if(in != null) {
                    in.close();
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
