package guru.springframework.controller;

import guru.springframework.model.Category;
import guru.springframework.model.UnitOfMeasure;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> american = categoryRepository.findByCategoryName("Iranian");
        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Cup");
        if (american.isPresent()&&pinch.isPresent()){
            System.out.println("Category is id:"+american.get().getId());
            System.out.println("UOM is id:"+pinch.get().getId());
        }
        return "index";
    }
}