package com.wawa.wawa.entity;

import com.wawa.wawa.entity.superclass.EducationalMaterial;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Table(name = "course")
@Entity
public class Course extends EducationalMaterial implements Serializable {
}