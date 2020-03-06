package hw4;

import hw3.Authors;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User{

//    public static User of(ResultSet resultSet) {
//        User user = new User();
//        try {
//            user.setId(resultSet.getInt("id"));
//            user.setFirstName(resultSet.getString("first_name"));
//            user.setLastName(resultSet.getString("last_name"));
//            user.setEmail(resultSet.getString("email"));
//            user.setPassword(resultSet.getString("password"));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}