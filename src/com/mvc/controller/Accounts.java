package com.mvc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Accounts {

    private int CARDNO;
    private int OWNERID;
    private String TYPE;
    private String EXPIRATIONDATE;//shouldn't this be date so it can be checked against current date to make sure it's not expired???
    private String OWNERNAME;
    private int CSC;

    //container for stuff related to queries
    static Statement stmt = null;
    static ResultSet rs = null;
    static Connection con = null;
    static PreparedStatement pstmt = null;
    private static final String TEST = "jdbc:mysql://127.0.01:3306/e-booking?user=root&password=password";

    public Accounts(){
        this.CARDNO = 0;//should be invalid
        this.OWNERID = 0;//should be invalid
        this.TYPE = null;
        this.EXPIRATIONDATE = null;
        this.OWNERNAME = null;
        this.CSC = 0;//should be invalid
    }

    public Accounts(int cardnumber, int ownerID, String type, String expiration, String ownername, int csc) {
        this.CARDNO = cardnumber;
        this.OWNERID = ownerID;
        this.TYPE = type;
        this.EXPIRATIONDATE = expiration;
        this.OWNERNAME = ownername;
        this.CSC = csc;
    }

    public int returnCardNo(int ownerID) {
        int cardNo = 0;//should be invalid
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "SELECT cardNo FROM Account WHERE ownerID = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, ownerID);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                cardNo = rs.getInt("cardNo");
            }

            rs.close();
            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return cardNo;
    }

    public void retrieveAccountInfo(int ownerID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "SELECT cardNo, type, expirationDate, ownerName, csc FROM Accounts WHERE ownerID = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, ownerID);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                this.CARDNO = rs.getInt("cardNo");
                this.OWNERID = ownerID;
                this.TYPE = rs.getString("type");
                this.EXPIRATIONDATE = rs.getString("expirationDate");
                this.OWNERNAME = rs.getString("ownerName");
                this.CSC = rs.getInt("csc");
            }

            rs.close();
            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void addAccountToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);//change later to different URL if needed
            String query = "INSERT into Accounts(cardNo, ownerID, type, expirationDate, ownerName, csc) values(?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1, CARDNO);
            pstmt.setInt(2,  OWNERID);
            pstmt.setString(3,  TYPE);
            pstmt.setString(4,  EXPIRATIONDATE);
            pstmt.setString(5,  OWNERNAME);
            pstmt.setInt(6, CSC);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();

            //System.out.println("ADDED to DB successfully");
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void deleteAccountFromDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "DELETE FROM Accounts WHERE cardNo = ?";
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1, CARDNO);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        //clears the attributes to allow same object to be used.
        reset();
    }

    private void reset() {
        this.CARDNO = 0;
        this.OWNERID = 0;
        this.TYPE = null;
        this.EXPIRATIONDATE = null;
        this.OWNERNAME = null;
        this.CSC = 0;
    }

    public void deleteAccountsTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "SET FOREIGN_KEY_CHECKS=0";//Truncate resets AUTO_INCREMENT to 1 unlike DELETE which does not reset AUTO_INCREMENT and will resume at last digit.
            pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();

            query = "TRUNCATE TABLE Accounts";
            pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();

            query = "SET FOREIGN_KEY_CHECKS=1";
            pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public int getAccountID() {
        return CARDNO;
    }

    public int getOwnerID() {
        return OWNERID;
    }

    public String getType() {
        return TYPE;
    }

    public String getExpirationDate() {
        return EXPIRATIONDATE;
    }

    public String getOwnerName() {
        return OWNERNAME;
    }
    //should this even be allowed? Huge security issue
    public int getCSC() {
        return CSC;
    }

    public void setOwnerID(int ownerID) {
        this.OWNERID = ownerID;
    }

    public void setType(String type) {
        this.TYPE = type;
    }

    public void setExpirationDate(String expiration) {
        this.EXPIRATIONDATE = expiration;
    }

    public void setOwnerName(String ownerName) {
        this.OWNERNAME = ownerName;
    }

    public void setCSC(int csc) {
        this.CSC = csc;
    }

    @Override
    public String toString(){
        return "Current Account Info(CC):\n"
                + "CARD NO: \t" + CARDNO + "\n"
                + "OWNER ID: \t" + OWNERID + "\n"
                + "TYPE: \t" + TYPE + "\n"
                + "EXPIRATION DATE: \t" + EXPIRATIONDATE + "\n"
                + "OWNER NAME: \t" + OWNERNAME + "\n"
                + "CSC: \t" + CSC + "\n";
    }
}