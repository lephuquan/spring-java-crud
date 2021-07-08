package spring.init.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.init.entities.CategoriesEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoriesEntity, Integer>{

}
