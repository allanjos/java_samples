package br.com.olivum.materials.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olivum.materials.model.Material;
import br.com.olivum.materials.repository.MaterialsRepository;
import br.com.olivum.materials.service.MaterialsService;

@Service
class MaterialsServiceImpl implements MaterialsService {
   @Autowired
   MaterialsRepository materialsRepository;

   private static final Logger logger = LogManager.getLogger(MaterialsServiceImpl.class);

   public List<Material> getList() {
      logger.debug("getList()");

      return materialsRepository.findAll();
   }

   public Boolean saveMaterial(Material material) {
      logger.debug("saveMaterial()");

      logger.debug("material: id=" + material.getId() + ", name=" + material.getName());

      materialsRepository.save(material);

      return true;
   }

   public Boolean updateMaterial(Material material) {
      logger.debug("updateMaterial()");

      logger.debug("material: id=" + material.getId() + ", name=" + material.getName());

      Optional<Material> materialToUpdate = materialsRepository.findById(material.getId());

      if (!materialToUpdate.isPresent()) {
         logger.error("Trying to update a nonexistent material record.");

         return false;
      }

      materialsRepository.save(material);

      return true;
   }

   public Material getItem(long id) {
      logger.debug("getItem()");

      logger.debug("id: " + id);

      Optional<Material> material = materialsRepository.findById(id);

      return material.isPresent() ? material.get() : null;
   }

   public Boolean deleteItem(long id) {
      logger.debug("deleteMaterial()");

      logger.debug("id: " + id);

      Optional<Material> material = materialsRepository.findById(id);

      if (!material.isPresent()) {
         logger.debug("The material for ID " + id + " entry does not exist.");

         return false;
      }

      materialsRepository.deleteById(id);

      material = materialsRepository.findById(id);

      return material.isPresent() ? false : true;
   }
}