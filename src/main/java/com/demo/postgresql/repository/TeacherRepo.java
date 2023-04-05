package com.demo.postgresql.repository;

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
    //UPDATE table_name SET attrs = jsonb_set(cast(attrs as jsonb), '{key}', '"new_value"', true) WHERE id = 'some_id';
    @Query(value = "UPDATE teacher t SET t.student = jsonb_set(t.student as jsonb, '{name}', 'haha', true) "
            + "WHERE t.student ->> 'id' = ?1",
            nativeQuery = true)
    public Teacher updateTeacher(long id);

}
