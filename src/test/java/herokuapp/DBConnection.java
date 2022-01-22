package herokuapp;

import java.sql.*;


public class DBConnection {

    private Connection connect = null;
    private Statement statement = null;

    public void connect() {
        try {
            // Statements allow to issue SQL queries to the database
            connect = DriverManager.getConnection("jdbc:mysql://localhost/qa14", "root", "");
            statement = connect.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement.executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet select(String query) {
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public ResultSet selectStudent(String studentName) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM qa14.students WHERE name = ?");
        preparedStatement.setString(1, studentName);
        return preparedStatement.executeQuery();
    }

    public boolean addStudent(String name, int groupId) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO qa14.students (name, group_id) VALUES (?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, groupId);
        return preparedStatement.execute();
    }


    public int updateStudent(int id, String name, int groupId) {
        return update(
                String.format("UPDATE qa14.students Set name = \"%s\", group_id = %s WHERE id = %s", name, groupId, id));
    }

    public void deleteStudent(int id) {
        delete(
                String.format("DELETE FROM qa14.students WHERE id = %s", id));
    }


    public void delete(String query) {
        try {
            statement
                    .execute(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public int update(String query) {
        try {
            return statement
                    .executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public boolean insert(String query) {
        try {
            return statement
                    .execute(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }


    // You need to close the resultSet
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }
}
