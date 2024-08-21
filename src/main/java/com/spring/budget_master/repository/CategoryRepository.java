package com.spring.budget_master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.budget_master.modal.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
