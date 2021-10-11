package pnt1001Utils;


import org.testng.annotations.Test;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DbManager {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    //    public static Properties config = new Properties();
    public static FileInputStream fis;
//    public static final String ORpath = System.getProperty("user.dir")+ "\\src\\test\\resources\\ExpediaRepo.properties";
    public static final String ORpath = "C:\\Users\\nahid\\IdeaProjects\\Team5WDESeleniumBootcamp\\com.expedia\\src\\test\\resources\\ExpediaRepo.properties";
    static String tableName = "team5bootcamp.expedialogin";
    static String columnName = "FIRST_NAME";


    public static Properties loadOR() {
        Properties prop = new Properties();
        try {
            InputStream ism = new FileInputStream(ORpath);
            prop.load(ism);
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/test/resources/ExpediaRepo.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Properties loadProperties(String fileName) throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/resources/" + fileName + ".properties");
        prop.load(ism);
        ism.close();
        return prop;
    }
    public static Properties loadProp(String fileName) {
        Properties prop = new Properties();
        try {
            InputStream ism = new FileInputStream("src/resources/" + fileName + ".properties");
            prop.load(ism);
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }




/*    public static Connection getDbInstance() throws ClassNotFoundException, SQLException, IOException {
        Properties config =loadProperties();

        String url = config.getProperty("MYSQLJDBC.url");
        String user = config.getProperty("MYSQLJDBC.userName");
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println("Database is connected");
        return connection;
    }*/

    public static Connection getDbInstance() throws ClassNotFoundException, SQLException, IOException {
        Properties config =loadOR();

        String url = config.getProperty("MYSQLJDBC.url");
        String user = config.getProperty("MYSQLJDBC.userName");
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println("Database is connected");
        return connection;
    }


    public static void getColumnData(String tableName, String columnName) {

        try {
            Connection connection = getDbInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from " + tableName + ";");

            while ((resultSet.next())) {
                System.out.println(resultSet.getString(columnName));
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void insertDataIntoTable(int employeeId){
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();
//            Scanner sc = new Scanner(System.in);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            int employee_id = employeeId;

            System.out.println("Enter the Employee name (String data):");
            String name = input.readLine();

            System.out.println("Enter the department of the Employee (HR/Tester/Developer):");
            String department = input.readLine();

            System.out.println("Enter the performance of the Employee (excellent/good/average):");
            String performance = input.readLine();

            System.out.println("Enter the salary of the Employee (Amount/yr. in number):");
            String sal = input.readLine();
            double salary = Double.parseDouble(sal);


            String query = "insert into employee values ("
                    + "'" + employee_id + "','" +  name + "','" +  department + "','" +  performance + "','" +  salary+ "')";

            System.out.println(query);
            int rows = stmt.executeUpdate(query);
            if(rows>0){
                System.out.println("Successfully inserted " + rows + " rows");
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeColumnDataType(String columnName, String newDataType){
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "ALTER TABLE employee MODIFY COLUMN " +  columnName + " " + newDataType;


            System.out.println(query);
            int rows = stmt.executeUpdate(query);
            if(rows>0){
                System.out.println("Successfully modified column data type");
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void changeColumnDataType(String tableName, String columnName, String newDataType){
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "ALTER TABLE " + tableName + " MODIFY COLUMN " +  columnName + " " + newDataType;


            System.out.println(query);
            int rows = stmt.executeUpdate(query);
            if(rows>0){
                System.out.println("Successfully modified column data type");
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getRowData(String tableName, int employeeID){
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT * FROM " + tableName + " WHERE USER_ID = " + employeeID;
            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);
            while ((resultSet.next())) {

                System.out.println(resultSet.getString("USER_ID") + "\t" +
                        resultSet.getString("FIRST_NAME")  + "\t" +
                        resultSet.getString("LAST_NAME")  + "\t" +
                        resultSet.getString("EMAIL")  + "\t" +
                        resultSet.getString("PASSWORD"));

            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String getDeptOfEmployee(String tableName, int employeeID){
        String departmentName = " ";
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT DEPARTMENT FROM " + tableName + " WHERE EMPLOYEE_ID = " + employeeID;
//            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);

            while ((resultSet.next())) {

//                System.out.println(resultSet.getString("DEPARTMENT"));
                departmentName = resultSet.getString("DEPARTMENT");

            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return departmentName;
    }


    public static String getEmployeePerformance(String tableName, int employeeID){
        String performance = " ";
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT PERFORMANCE FROM " + tableName + " WHERE EMPLOYEE_ID = " + employeeID;
//            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);

            while ((resultSet.next())) {

//                System.out.println(resultSet.getString("DEPARTMENT"));
                performance = resultSet.getString("PERFORMANCE");

            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return performance;
    }


    public static double getEmployeeSalary(String tableName, int employeeID){
        double salary =0.0;
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT SALARY FROM " + tableName + " WHERE EMPLOYEE_ID = " + employeeID;
//            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);

            while ((resultSet.next())) {

//                System.out.println(resultSet.getString("DEPARTMENT"));
                salary = resultSet.getDouble("SALARY");

            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salary;
    }

    public static String getEmail(String tableName, int USER_ID){
        String value = " ";
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT EMAIL FROM " + tableName + " WHERE USER_ID = " + USER_ID;
//            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);

            while ((resultSet.next())) {

                value = resultSet.getString("EMAIL");

            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);
        return value;
    }

    public static String getPassword(String tableName, int USER_ID){
        String value = " ";
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT PASSWORD FROM " + tableName + " WHERE USER_ID = " + USER_ID;
//            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);

            while ((resultSet.next())) {

                value = resultSet.getString("PASSWORD");

            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);
        return value;
    }

    public static String getFirstName(String tableName, int USER_ID){
        String value = " ";
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();

            String query = "SELECT FIRST_NAME FROM " + tableName + " WHERE USER_ID = " + USER_ID;
//            System.out.println(query);

            ResultSet resultSet = stmt.executeQuery(query);

            while ((resultSet.next())) {

                value = resultSet.getString("FIRST_NAME");

            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);
        return value;
    }

    public static void updateInfo(String tableName, String columnName, String value, int employeeID){
        try {
            Connection connection = DbManager.getDbInstance();
            Statement stmt = connection.createStatement();


            String query = "update " + tableName + " set " + columnName + "=\"" + value + "\" WHERE EMPLOYEE_ID=" + employeeID;
            System.out.println(query);

            int rows = stmt.executeUpdate(query);
            if(rows>0){
                System.out.println("Info updated Successfully! " + rows + " rows affected.");
            }

            connection.close();
//            System.out.println("DB connection is closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error executing SQL query");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




 /*   private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }*/

    @Test
    public void testDB(){
        getFirstName(tableName, 101);
        getEmail(tableName, 101);
        getPassword(tableName, 101);

    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        getColumnData(tableName, columnName);
    }
}

