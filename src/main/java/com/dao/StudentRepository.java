package com.dao;

import com.model.Student;

import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

public interface StudentRepository extends CouchbasePagingAndSortingRepository<Student, Long> {

}
