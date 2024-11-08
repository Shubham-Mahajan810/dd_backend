package com.iet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iet.custom_exceptions.CategoryNotFoundException;
import com.iet.dao.CategoryRepository;
import com.iet.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private IProductService prodService;
	
	@Override
	public Category addOrEditCategory(Category cat) {
		return catRepo.save(cat);
	}

	@Override
	public List<Category> getAllCategories() {
		return catRepo.findAll();
	}

	@Override
	public String deleteCategoryById(Integer cid) {
		Category categoryToDelete = catRepo.findById(cid).get();
		String catName = categoryToDelete.getName();
		categoryToDelete.getProducts().forEach(product -> {
			prodService.deleteProduct(product.getId());
		});
		catRepo.deleteById(cid);
		return catName+" Category deleted successfully!";
	}

	@Override
	public Category findByName(String categoryName) {
		return catRepo.findByName(categoryName).orElseThrow( () -> new CategoryNotFoundException("No such category available"));
	}
	
}
