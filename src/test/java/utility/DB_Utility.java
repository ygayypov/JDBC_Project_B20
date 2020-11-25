package utility;

import java.sql.*;

public class DB_Utility {

    static Connection conn ; // make it static field so we can reuse in every methods we write
    static Statement stmt ;
    static ResultSet rs ;

    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@3.86.188.174:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        try {
            conn = DriverManager.getConnection(connectionStr,username,password) ;
            System.out.println("CONNECTION SUCCESSFUL !! ");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED !!! " +  e.getMessage() );
        }

    }
    // Create a method called runQuery that accept a SQL Query
    // and return ResultSet Object
    public static ResultSet runQuery(String query){

//        ResultSet rs  = null;
        // reusing the connection built from previous method
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query) ;

        } catch (SQLException e) {
            System.out.println("Error while getting resultSet " + e.getMessage());
        }

        return rs ;

    }
    // create a method to clean up all the connection statement and resultSet
    public static void destroy(){

        try {

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException throw_ables) {
            throw_ables.printStackTrace();
        }


    }



    public static void main(String[] args) throws SQLException {

        createConnection();

        ResultSet rs =  runQuery("SELECT * FROM REGIONS");

        // print out second column first row
        rs.next();
        System.out.println(" rs.getString(2) = " + rs.getString(2)   );


    }


}