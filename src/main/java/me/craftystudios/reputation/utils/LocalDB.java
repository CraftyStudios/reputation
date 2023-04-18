package me.craftystudios.reputation.utils;

import java.sql.*;

public class LocalDB {
    public static void setData(String playerName, String key, Object value) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder().getAbsolutePath() + File.separator + "localdb.db");
            Statement stmt = conn.createStatement();
    
            // Check if the table exists, and create it if it doesn't
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS playerdata (id INTEGER PRIMARY KEY, name TEXT, data TEXT)");
    
            // Check if the player already has data in the database, and insert or update accordingly
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM playerdata WHERE name=?");
            ps.setString(1, playerName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Player data already exists, update the value of the key
                String data = rs.getString("data");
                JSONObject json = new JSONObject(data);
                json.put(key, value);
                PreparedStatement psUpdate = conn.prepareStatement("UPDATE playerdata SET data=? WHERE name=?");
                psUpdate.setString(1, json.toString());
                psUpdate.setString(2, playerName);
                psUpdate.executeUpdate();
            } else {
                // Player data doesn't exist, create a new row with the key-value pair
                JSONObject json = new JSONObject();
                json.put(key, value);
                PreparedStatement psInsert = conn.prepareStatement("INSERT INTO playerdata (name, data) VALUES (?, ?)");
                psInsert.setString(1, playerName);
                psInsert.setString(2, json.toString());
                psInsert.executeUpdate();
            }
    
            // Close the connection and statement objects
            rs.close();
            ps.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getData(String username, String data) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        int result = -1;
    
        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:sqlite:./localdb.db");
    
            // Prepare the SELECT statement with placeholders for username and data
            pstmt = conn.prepareStatement("SELECT " + data + " FROM players WHERE username = ?");
    
            // Set the username placeholder
            pstmt.setString(1, username);
    
            // Execute the SELECT statement and get the result set
            rs = pstmt.executeQuery();
    
            // If the result set has a row, get the value of the data field
            if (rs.next()) {
                result = rs.getInt(data);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all database resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return result;
    }
    
    
}
