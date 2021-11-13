package com.cemaltuysuz.springRestApi.repository;

import com.cemaltuysuz.springRestApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
