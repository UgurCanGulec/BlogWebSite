package com.j4v4code.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
@Data
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username" , nullable = false)
    private String userName;

    @Column(name = "password" , nullable = false)
    private String password;

}
