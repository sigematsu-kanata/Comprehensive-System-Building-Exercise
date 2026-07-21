package gakusei.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続情報を一元管理するクラス。
 * ★環境に合わせて URL / USER / PASS を書き換えてください。
 * ★MySQL Connector/J のjarを WebContent/WEB-INF/lib に配置してください。
 *   https://dev.mysql.com/downloads/connector/j/
 */
public class DBManager {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/korotok?useSSL=false&serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "kcsf";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBCドライバのロードに失敗しました。WEB-INF/libにmysql-connector-jのjarを配置してください。", e);
        }
    }

    private DBManager() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
