package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private @NonNull Long id;
	private @NonNull String firstName;
	private @NonNull String lastName;
	private @NonNull Integer age;
}
