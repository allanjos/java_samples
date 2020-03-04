package br.com.olivum.materials.service;

import java.util.List;

import br.com.olivum.materials.model.Material;

public interface MaterialsService {
    public List<Material> getList();

    public Boolean saveMaterial(Material material);

    public Boolean updateMaterial(Material material);

    public Material getItem(long id);

    public Boolean deleteItem(long id);
}