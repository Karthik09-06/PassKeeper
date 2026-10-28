package org.spiderman.passkeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "password_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String username;
    private String encryptedPassword;

    public PasswordEntry(String serviceName, String username, String encryptedPassword) {
        this.serviceName = serviceName;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }
}
