package br.com.olivum.materials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.olivum.materials.model.Material;

public interface MaterialsRepository extends JpaRepository<Material, Long> { 
    Material findByName(String name);
}