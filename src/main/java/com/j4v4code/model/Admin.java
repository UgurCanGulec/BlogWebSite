package com.j4v4code.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
@Data
public class Admin implements Serializable {


    @Column(name = "userID")
    private Long userID;

    @Column(name = "password")
    private String password;

}
