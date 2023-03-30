package com.demo.postgresql.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teacherName;
    private Long classRoomId;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Student student;//This is call Json object=> in Student.class jsonObj is json String
}
