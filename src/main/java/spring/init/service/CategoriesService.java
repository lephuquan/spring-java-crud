package spring.init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.init.entities.CategoriesEntity;
import spring.init.repositories.CategoryRepository;

@Service
public class CategoriesService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoriesEntity> getAllCategories(){
		return (List<CategoriesEntity>) categoryRepository.findAll();
	}
}
