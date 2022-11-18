package com.example.codingbat.service;

import com.example.codingbat.entity.Category;
import com.example.codingbat.entity.Language;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.CategoryDto;
import com.example.codingbat.repository.CategoryRepository;
import com.example.codingbat.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    LanguageRepository languageRepository;

    public ApiResponce addCategory(CategoryDto categoryDto){
        if (categoryRepository.existsByName(categoryDto.getName())){
            return new ApiResponce("Such a category exists",false);
        }
        Category category=new Category();
        category.setDiscription(categoryDto.getDiscription());
        category.setName(categoryDto.getName());
        List<Language> languageList = languageRepository.findAllById(categoryDto.getLanguages());
        category.setLanguages(languageList);
        return new ApiResponce("Category saved",true);
    }
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public Category getId(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);

    }
    public ApiResponce edit(CategoryDto categoryDto,Integer id){
        if (categoryRepository.existsByNameAndId(categoryDto.getName(), id)) {
            Optional<Category> optionalCategory = categoryRepository.findById(id);
            if (!optionalCategory.isPresent()){
                return new ApiResponce("Such a category not found",false);
            }
            Category category = optionalCategory.get();
            category.setDiscription(categoryDto.getDiscription());
            category.setName(categoryDto.getName());
            List<Language> allById = languageRepository.findAllById(categoryDto.getLanguages());
            category.setLanguages(allById);
            categoryRepository.save(category);
            return new ApiResponce("Successful edited",true);
        }
        return new ApiResponce("No such category exists",false);
    }
    public ApiResponce delete(Integer id){
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return new ApiResponce("Category deleted",true);
        }
       return new ApiResponce("No such category exists",false);
    }

}
