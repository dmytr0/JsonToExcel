import org.junit.BeforeClass;
import org.junit.Test;
import xyz.dimonick.JsonToXls.POJO.Visitor;
import xyz.dimonick.JsonToXls.Tools.Json.JSONConverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class JSONCoverterTest {
    static String json;

    @Test
    public void converterTest(){

        Visitor visitor = JSONConverter.convert(json);
        assertNotNull(visitor);
    }




    @BeforeClass
    public static void readJson() {

        String fileName = "src//test//resources//json.txt";
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
        json = sb.toString();
    }
}
