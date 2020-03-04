package br.com.olivum.materials.repository;

import br.com.olivum.materials.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Material, Long> {
    Material findByName(String name);
}