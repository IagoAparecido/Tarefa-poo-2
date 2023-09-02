package com.apicomsqlite.aula003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

import com.apicomsqlite.aula003.enity.Animal;

// @Repository
public interface AnimalRespository extends JpaRepository<Animal, Integer> {

    public boolean existsById(int id);

    public List<Animal> findByNome(String nome);

    @Query("select max(s.id) from Animal s")
    public Integer findMaxId();
}