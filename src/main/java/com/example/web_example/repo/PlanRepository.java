package com.example.web_example.repo;

import com.example.web_example.models.Plans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends CrudRepository<Plans, Long> {

}