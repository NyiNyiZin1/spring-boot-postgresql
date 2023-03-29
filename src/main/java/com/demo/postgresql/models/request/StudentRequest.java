package com.demo.postgresql.models.request;

import lombok.*;
import org.json.simple.JSONObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
	private Long id;
	private String name;
	private Long classRoomId;
	private String jsonObj;
}
