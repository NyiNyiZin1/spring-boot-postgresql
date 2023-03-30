package com.demo.postgresql.repository;

import com.demo.postgresql.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.postgresql.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
//    @Query(value = "SELECT a.* FROM author a "
//            + "WHERE CAST(a.book ->> 'price' AS INTEGER) = ?1",
//            nativeQuery = true)
//    public Student findByBookPriceNativeQueryCast(int price);

    @Query(value = "SELECT s.* FROM student s "
            + "WHERE s.json_b ->> 'student' = ?1",
            nativeQuery = true)
    public Student findByStudentName(String name);

//    @Query(value = "SELECT a.* FROM author a "
//            + "WHERE a.book ->> 'isbn' = ?1",
//            nativeQuery = true)
//    public Student findByBookIsbnNativeQuery(String isbn);
}
