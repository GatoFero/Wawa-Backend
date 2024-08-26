package com.wawa.wawa_educational_materials.repositories;

import com.wawa.wawa_educational_materials.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
}
