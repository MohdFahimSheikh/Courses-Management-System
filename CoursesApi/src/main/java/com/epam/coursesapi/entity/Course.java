package com.epam.coursesapi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="courses")
public class Course {
    @Id
    private Long id;
    private String Title;
    private String Description;
}
