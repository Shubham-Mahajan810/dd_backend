package com.iet.service;

import java.util.List;

import com.iet.pojos.Category;

public interface ICategoryService {

	Category addOrEditCategory(Category cat);

	List<Category> getAllCategories();

	String deleteCategoryById(Integer cid);

	Category findByName(String categoryName);

}
