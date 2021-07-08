package spring.init.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.init.entities.NewsEntity;
import spring.init.repositories.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	public List<NewsEntity> getAllNews(){
		return (List<NewsEntity>) newsRepository.findAll();
	}
	
	public void saveNews(NewsEntity newsEntity) {
		newsRepository.save(newsEntity);
	}
	
	public Optional<NewsEntity> getNewsById(int id) {
		return newsRepository.findById(id);
	}
	
	public void deleteNews(int id) {
		newsRepository.deleteById(id);
	}
	
	public List<NewsEntity> findByKeyword(String keyword){
		return (List<NewsEntity>) newsRepository.findByKeyword(keyword);
	}
}
