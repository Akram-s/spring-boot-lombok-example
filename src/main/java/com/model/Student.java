package com.model;


import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Data;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	@Id
	@NonNull
	@Field
	private Long id;

	@NonNull
	@Field
	private String firstName;

	@NonNull
	@Field
	private String lastName;

	@NonNull
	@Field
	private Integer age;
}
