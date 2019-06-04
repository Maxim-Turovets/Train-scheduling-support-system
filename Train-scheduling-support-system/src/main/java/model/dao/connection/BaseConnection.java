package model.dao.connection;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection  {


    private static final String CON_STR = "jdbc:sqlite:C:/Users/mturo/IdeaProjects/Train-scheduling-support-system/train_support_base.db";

    private static BaseConnection instance = null;


    public static synchronized BaseConnection getInstance() throws SQLException {
        if (instance == null)
            instance = new BaseConnection();
        return instance;
    }



    public Connection connection;

    private BaseConnection() throws SQLException {
        DriverManager.registerDriver(new JDBC());

        this.connection = DriverManager.getConnection(CON_STR);
    }

}
