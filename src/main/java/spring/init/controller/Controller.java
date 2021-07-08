package spring.init.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.init.entities.CategoriesEntity;
import spring.init.entities.NewsEntity;
import spring.init.service.CategoriesService;
import spring.init.service.NewsService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private NewsService newsService;

	@Autowired
	private CategoriesService categoriesService;

	@GetMapping(value = { "/", "home" })
	public String Home(Model model) {
		List<NewsEntity> newsEntities = newsService.getAllNews();
		model.addAttribute("news", newsEntities);
		return "home";
	}

	@GetMapping("/addNews")
	public String addNews(Model model) {
		List<CategoriesEntity> categoriesEntities = categoriesService.getAllCategories();
		model.addAttribute("categories", categoriesEntities);
		model.addAttribute("news", new NewsEntity());
		return "addNews";
	}

	@PostMapping("/postAddNews")
	public String postAddNews(Model model, @Valid @ModelAttribute(name = "news") NewsEntity newsEntity,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "add fail!");
			List<CategoriesEntity> categoriesEntities = categoriesService.getAllCategories();
			model.addAttribute("categories", categoriesEntities);
			return "addNews";
		}
		newsService.saveNews(newsEntity);
		return "redirect:/home";
	}

	@GetMapping("/updateNews")
	public String updateNews(Model model, @RequestParam("id") int id) {
		Optional<NewsEntity> news = newsService.getNewsById(id);
		model.addAttribute("news", news.get());
		List<CategoriesEntity> categoriesEntities = categoriesService.getAllCategories();
		model.addAttribute("categories", categoriesEntities);
		return "updateNews";
	}

	@PostMapping("/postUpdateNews")
	public String postUpdateNews(Model model, @Valid @ModelAttribute(name = "news") NewsEntity newsEntity,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "update fail!!");
			List<CategoriesEntity> categoriesEntities = categoriesService.getAllCategories();
			model.addAttribute("categories", categoriesEntities);
			return "updateNews";
		}
		newsEntity.getStaffsEntity().setStaffId(newsEntity.getNewId());
		newsService.saveNews(newsEntity);
		return "redirect:/home";
	}

	@GetMapping("/deleteNews")
	public String deleteNews(@RequestParam("id") int id) {
		newsService.deleteNews(id);
		return "redirect:/home";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam("keyword") String keyword) {
		List<NewsEntity> newsEntities = newsService.findByKeyword(keyword);
		model.addAttribute("news", newsEntities);
		return "home";
	}
}
