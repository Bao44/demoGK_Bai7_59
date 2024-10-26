package vn.edu.iuh.fit.demogk_bai7_59.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private Connection connection;
    private static ConnectDB instance = null;

    public ConnectDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/tintuc?createDatabaseIfNotExist=true";
        connection = DriverManager.getConnection(url, "root", "root");
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectDB getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new ConnectDB();
        return instance;
    }
}
