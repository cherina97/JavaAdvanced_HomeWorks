package hw3;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authors {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String address;

    public static Authors of(ResultSet resultSet) {
        Authors authors = new Authors();
        try {
            authors.setId(resultSet.getInt("id"));
            authors.setName(resultSet.getString("name_of_author"));
            authors.setSurname(resultSet.getString("sername_of_author"));
            authors.setEmail(resultSet.getString("email_of_author"));
            authors.setAddress(resultSet.getString("adress"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
