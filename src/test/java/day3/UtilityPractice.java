package day3;

import utility.DB_Utility;

import java.sql.ResultSet;

public class UtilityPractice {

    public static void main(String[] args) {
        DB_Utility.createConnection();

       ResultSet jobRS = DB_Utility.runQuery("Select * from Jobs");




    }
}
