package com.example.springbootstudentcrud.model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "family")
    private String family;

    @Column(name = "email")
    private String email;
    
    @Column(name = "image",nullable = true,length = 64)
    private String photos;


    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;

        return "/student-photos/" + id + "/" + photos;
    }



}
