package org.spiderman.passkeeper.dao;

import org.junit.Test;
import org.spiderman.passkeeper.entity.PasswordEntry;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PasswordEntryDAOTest {
    PasswordEntryDAO passwordEntryDAO = new PasswordEntryDAO();

    @Test
    public void shouldFindAllPasswordEntries() {
        List<PasswordEntry> passwordEntries = passwordEntryDAO.findAll();
        System.out.println(passwordEntries);
    }

    @Test
    public void shouldSavePasswordEntry() {
        PasswordEntry entry = new PasswordEntry("meta", "Kamatchi" ,"makatchi");
        passwordEntryDAO.save(entry);
    }

    @Test
    public void shouldFindPasswordEntry() {
        PasswordEntry entry = passwordEntryDAO.findById(1);
        System.out.println(entry);
    }

    @Test
    public void shouldUpdatePasswordEntry() {
        PasswordEntry entry = new PasswordEntry(1L, "meta", "Kamatchi" ,"makamishi");
        passwordEntryDAO.update(entry);
    }

    @Test
    public void shouldDeletePasswordEntry() {
        PasswordEntryDAO dao = new PasswordEntryDAO();

        PasswordEntry entry = new PasswordEntry("google", "dodqoina", "qxaoinal");
        dao.save(entry);

        assertNotNull(dao.findById(entry.getId()));

        dao.delete(entry.getId());

        assertNull(dao.findById(entry.getId()));
    }
}
