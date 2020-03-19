package vist_database;

import java.sql.*;

/**
 * @author ：Gary Wu
 * @date ：Created in 16:43 2020/3/5
 * @description :使用JDBC访问数据库
 * @version: $
 */

public class SimpleJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded...");

        // 2. 加载连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/javabook","scott","tiger");
        System.out.println("Connection created...");

        // 3. 创建语句
        Statement statement = connection.createStatement();

        // 4. 执行语句
        ResultSet resultSet = statement.executeQuery(
                "select firstName, mi, lastName from student where lastName " +
                        " = 'Smith'");

        // 4.1 循环获取结果
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" +
                    resultSet.getString(3));
        }

        connection.close();
    }
}
