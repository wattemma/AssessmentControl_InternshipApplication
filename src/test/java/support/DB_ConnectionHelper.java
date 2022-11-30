package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.sql.PreparedStatement;

/*
NOTES:
1) define the DB url
format:
jdbc:mysql://dbIPaddress:dbPortNumber/dbName?autoReconnect=true&useSSL=false
ex: jdbc:mysql://44.198.158.182:3306/application?autoReconnect=true&useSSL=false
2) define the db username
3) define the db password
4) Create a method that with a String as a parameter, we will pass the user email as the parameter
5) Establish the connection:
- use the Connection object. It creates a connection with a specific database
- use the db url, username and password defined earlier
6) after, create a try/catch that will throw a SQLException
 */


public class DB_ConnectionHelper {

    // Constant for Database URL, contains db ip
    static final String DB_URL = "jdbc:mysql://44.198.158.182:3306/application?autoReconnect=true&useSSL=false";
    //Database Username
    static final String USER = "appuser";
    // Database Password
    static final String PASS = "Portnov321";


    public static String getAccessToken(String userEmail) throws SQLException {
        String result = "No data";

        //establish the connection
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        //try-catch statement = try getting data from the db, if not throw error


        /*
        - As the parameter of the "try" part, initialize the PreparedStatement Object
        - to it, pass the "con" Connection object, and use the method .prepareStatement("sql query here");
         */
        try (PreparedStatement pstmt = con.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?");) {
            //.setString accepts int parameterIndex, String x
            //in our db email is in the second column, so index of 1, then we want that to be called userEmail
            pstmt.setString(1, userEmail);
            //execute the query and store the results
            ResultSet rs = pstmt.executeQuery();

//loop through the results
            while (rs.next()) {
                //we need to get the id as well, to later use it to activate the right user
                result = rs.getString("id") + ";" + rs.getString("activationCode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void activateUser(int userId, String activationCode) throws IOException, IOException {
        URL url = new URL("http://ask-internship.portnov.com/api/v1/activate/" + userId + "/" + activationCode);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "USER_AGENT");
        int responseCode = con.getResponseCode();
        System.out.println("Activation request response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);
        } else {
            System.out.println("Error occurred while trying to send get request");
        }
    }

}


