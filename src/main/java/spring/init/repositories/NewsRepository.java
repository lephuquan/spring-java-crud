package spring.init.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.init.entities.NewsEntity;

@Repository
public interface NewsRepository extends CrudRepository<NewsEntity, Integer>{

	
	@Query("select n from NewsEntity n where n.title like %:keyword% or n.summary like %:keyword% or n.categoriesEntity.cateName like %:keyword%")
	public List<NewsEntity> findByKeyword(@Param("keyword") String keyword);
}
