package herokuapp;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbTest {

    @Test
    public void test1() throws SQLException {
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet = connection.selectFrom("students");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int group_id = resultSet.getInt("group_id");
            System.out.println("Id: " + id + " Name: " + name + " group_Id: " + group_id);
        }
        connection.close();
    }

    @Test
    public void test2() throws SQLException {
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet = connection.select("SELECT * FROM qa14.groups");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("Id: " + id + " Name: " + name);
        }
        connection.close();
    }

    @Test
    public void test3() throws SQLException {
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.addStudent("DSFGDFF", 3);
        connection.close();
    }
}
