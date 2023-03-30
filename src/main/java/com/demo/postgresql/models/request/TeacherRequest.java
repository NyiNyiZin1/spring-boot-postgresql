package com.demo.postgresql.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    private Long id;
    private String teacherName;
    private Long classRoomId;
}
