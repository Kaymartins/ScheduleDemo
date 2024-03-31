package com.codejr.schedule.dao;

import com.codejr.schedule.factory.ConnectionFactory;
import com.codejr.schedule.model.Contact;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public void save(Contact contact){
        String sql = "INSERT INTO contacts (name, age, registrationDate) VALUES (?, ?, ?)";

        Connection conn = null;

        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.createConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, contact.getName());
            statement.setInt(2, contact.getAge());
            statement.setDate(3, new Date(contact.getRegisterDate().getTime()));

           statement.execute();

            System.out.println("Contact save successfully !");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(statement != null){
                    conn.close();
                }

                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Contact> getAll(){
        String sql = "SELECT * FROM contacts";

        List<Contact> contacts = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        ResultSet results = null;

        try{
            conn = ConnectionFactory.createConnection();
            statement = conn.prepareStatement(sql);
            results = statement.executeQuery();

            while(results.next()){
                String name = results.getString("name");
                int age = results.getInt("age");
                Date date = results.getDate("registrationDate");

                Contact contact = new Contact(name, age, date);
                contact.setId(results.getLong("id"));

                contacts.add(contact);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(results != null){
                    results.close();
                }

                if(statement != null){
                    statement.close();
                }

                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return contacts;
    }

    public void update(Contact contact){
        String sql = "UPDATE contacts SET name = ?, age = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try{
            conn = ConnectionFactory.createConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, contact.getName());
            statement.setInt(2, contact.getAge());
            statement.setLong(3, contact.getId());

            statement.execute();
            System.out.println("Contact updated successfully!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void delete(Contact contact){
        String sql = "DELETE FROM contacts WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try{
            conn = ConnectionFactory.createConnection();
            statement = conn.prepareStatement(sql);
            statement.setLong(1, contact.getId());

            statement.execute();
            System.out.println("Contact deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }

                if(statement != null){
                    statement.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
