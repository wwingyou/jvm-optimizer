package com.example.tester_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tester_v2.entity.Title;

/**
 * TitleRepository
 */
public interface TitleRepository extends JpaRepository<Title, Title.PK> {
}
