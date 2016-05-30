package xyz.dimonick.JsonToXls.Tools.DB;

import xyz.dimonick.JsonToXls.POJO.Visitor;

import java.sql.*;

/*
    Saving the visitor database.
*/

public class VisitorStorage {

    private Connection connection = null;
    private Visitor visitor;

    public void save(Visitor visitor) throws SQLException, ClassNotFoundException {
        this.visitor = visitor;
        getConnection();
        saveVisitor();
        saveImages();
        saveOccupation();
        closeConnection();
    }

    // Save data to visitor table
    private void saveVisitor(){

        String insertVisitor = "INSERT INTO visitors (firstname, lastname, macaddress, gender, dateofbirth, email, phone," +
                " country, city, devicetype, os, vkid, facebookid, comment)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ;";
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement(insertVisitor, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, visitor.getFirstName());
            preparedStatement.setString(2, visitor.getLastName());
            preparedStatement.setString(3, visitor.getMacAddress());
            preparedStatement.setString(4, visitor.getGender());
            preparedStatement.setString(5, visitor.getDateOfBirth().toString());
            preparedStatement.setString(6, visitor.getEmail());
            preparedStatement.setString(7, visitor.getPhone());
            preparedStatement.setString(8, visitor.getCountry());
            preparedStatement.setString(9, visitor.getCity());
            preparedStatement.setString(10, visitor.getDeviceType());
            preparedStatement.setString(11, visitor.getOs());
            preparedStatement.setString(12, visitor.getVkID());
            preparedStatement.setString(13, visitor.getFacebookID());
            preparedStatement.setString(14, visitor.getComment());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                visitor.setId(generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("Creating visitor failed, no ID obtained.");
            }
        } catch (SQLException e) {
            System.err.println("SQL error! " + e);
        }
    }

    // Save data to images table
    private void saveImages(){

        String insertImages = "INSERT INTO images (visitor_id, url) VALUES (?, ?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertImages)){
            for (int i = 0; i < visitor.getImages().size(); i++){
                preparedStatement.setLong(1, visitor.getId());
                preparedStatement.setString(2, visitor.getImages().get(i));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Save occupation
    private void saveOccupation() {
        long occupationId;
        String insertOccupation = "INSERT INTO occupation (occupation)\n" +
                "VALUES (?) ; ";
        String insertVisitorOccupation = "INSERT INTO visitor_occupation (visitor_id, occupation_id)\n" +
                "VALUES (?, ?) ;";

        try(PreparedStatement stmntOccupation =
                    connection.prepareStatement(insertOccupation, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stmntVisitorOccupation = connection.prepareStatement(insertVisitorOccupation)){
            for(int i = 0; i < visitor.getOccupation().size(); i++) {
                stmntOccupation.setString(1, visitor.getOccupation().get(i));
                stmntOccupation.executeUpdate();
                ResultSet generatedKeys = stmntOccupation.getGeneratedKeys();
                if (generatedKeys.next()) {
                    occupationId = generatedKeys.getLong(1);
                    stmntVisitorOccupation.setLong(1, visitor.getId());
                    stmntVisitorOccupation.setLong(2, occupationId);
                    stmntVisitorOccupation.executeUpdate();
                }
                else {
                    throw new SQLException("Creating visitor failed, no ID obtained.");
                }

            }
            if(stmntOccupation != null) {
                stmntOccupation.close();
            }
            if(stmntVisitorOccupation!= null) {
                stmntVisitorOccupation.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/visitors";
        String name = "postgres";
        String password = "1111";
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, name, password);
    }
    private void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Connection is not closed! " + e);
            }
        }
    }

}
