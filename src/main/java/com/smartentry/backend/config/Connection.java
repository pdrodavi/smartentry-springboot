package com.smartentry.backend.config;

import lombok.extern.slf4j.Slf4j;

import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Connection {

    private static Connection getRemoteConnection() {
        if (System.getenv("RDS_HOSTNAME") != null) {
            try {
                Class.forName("org.postgresql.Driver");
                String dbName = System.getenv("RDS_DB_NAME");
                String userName = System.getenv("RDS_USERNAME");
                String password = System.getenv("RDS_PASSWORD");
                String hostname = System.getenv("RDS_HOSTNAME");
                String port = System.getenv("RDS_PORT");
                String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
                log.trace("Getting remote connection with connection string from environment variables.");
                Connection con = (Connection) DriverManager.getConnection(jdbcUrl);
                log.info("Remote connection successful.");
                return con;
            }
            catch (ClassNotFoundException e) { log.warn(e.toString());}
            catch (SQLException e) { log.warn(e.toString());}
        }
        return null;
    }

}
