package com.codejr.schedule.application;

import com.codejr.schedule.dao.ContactDAO;
import com.codejr.schedule.model.Contact;

import java.sql.Date;

public class Main {
    public static void main(String[] args){
        ContactDAO contactDAO = new ContactDAO();

        Contact contact = new Contact("Kayan", 20, new Date(0));

        contactDAO.save(contact);

        for (Contact c : contactDAO.getAll()){
            System.out.println(c.toString());
        }
    }
}