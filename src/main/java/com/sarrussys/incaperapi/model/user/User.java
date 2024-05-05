package com.sarrussys.incaperapi.model.user;

import com.sarrussys.incaperapi.model.device.Device;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "user_data")
@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Device> ownedDevices;

    public User(RequestUser user) {
        this.userId = user.id();
        this.name = user.name();
        this.password = user.password();
        this.email = user.email();
    }
}
