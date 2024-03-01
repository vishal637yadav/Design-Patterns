package code.dp.creational.objectpool;

import java.sql.Connection;

public class MainDriverClass {

    public static void main(String[] args) {

        // Do something...
        //...
        // Create the ConnectionPool:
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:orcl",
                "brushup", "viks");
        System.out.println("pool ::" + pool);

        // Get a connection:
        Connection con = pool.checkOut();

        // Use the connection
        //...

        // Return the connection:
        pool.checkIn(con);

    }

}
