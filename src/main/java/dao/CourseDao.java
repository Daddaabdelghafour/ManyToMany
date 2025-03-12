package dao;

import models.Course;

import java.util.List;

public interface CourseDao {
public void save(Course course);
public Course findById(int id);
public List<Course> findAll();
public void update(Course course);
public void delete(Course course);
}
