package com.demo.postgresql.repository;

import com.demo.postgresql.entity.Student;
import com.demo.postgresql.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo  extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT t.* FROM teacher t "
            + "WHERE t.student ->> 'name' = ?1",
            nativeQuery = true)
    public Teacher findByStudentName(String name);

}
