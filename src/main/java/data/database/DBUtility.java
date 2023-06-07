package data.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    public static DBUtility connect(String url, String username, String password){
        return new DBUtility(url, username, password);
    }

    private String url;
    private String username;
    private String password;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    ResultSetMetaData rsmd;
    private String sql;

    private DBUtility(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<List<String>> getAsTable(String sql){
        List<List<String>> lists = new ArrayList<>();
        try {
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                List<String> rowList = new ArrayList<>();

                for (int i = 1; i <= columnCount; i++) {
                    rowList.add(rs.getString(i));
                }

                lists.add(rowList);
            }
            close();
            return lists;
        } catch (SQLException e) {
            close();
            throw new RuntimeException(e);
        }
    }

    public List<String> getColAsList(String sql){
        List<String> list = new ArrayList<>();
        try {
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            close();
            return list;
        } catch (SQLException e) {
            close();
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> getRowAsMap(String sql){
        Map<String, String> map = new LinkedHashMap<>();
        try {
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    map.put(rsmd.getColumnName(i), rs.getString(i));
                }
            }
            close();
            return map;
        } catch (SQLException e) {
            close();
            throw new RuntimeException(e);
        }
    }


    private void close(){
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
