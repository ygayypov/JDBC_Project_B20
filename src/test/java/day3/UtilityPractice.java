package day3;

import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityPractice {

    public static void main(String[] args)  {
        DB_Utility.createConnection();

        ResultSet jobRS = DB_Utility.runQuery("Select * from Jobs");

        /*
        Get the row count of the ResultSet
        Move the pointer to the last row and get the row number
         */

        //jobRS.last();
        //int rowCount = jobRS.getRow();// getRow is getting the current row number
        //System.out.println("rowCount = " + rowCount);
        int rowCount = DB_Utility.getRowCount();
        System.out.println("rowCount = " + rowCount);

        int colCount = DB_Utility.getColumnCount();
        System.out.println("colCount = " + colCount);


        System.out.println("All Column Names " +  DB_Utility.getColumnNames());


        DB_Utility.destroy();
    }
}
