package br.com.nava.demo.controller;

import br.com.nava.demo.model.CategoryModel;
import br.com.nava.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryModel> listAll() {
        return categoryService.listAll();
    }

    @GetMapping("/{catId}")
    public CategoryModel getById(@PathVariable Integer catId) {
        CategoryModel category = categoryService.getById(catId);
        return category;
    }

    @PostMapping("/")
    public void save(@RequestBody CategoryModel category) {
        categoryService.save(category);
    }

    @PostMapping("/{catId}")
    public void update(@RequestBody CategoryModel category, @PathVariable Integer catId) {
        categoryService.update(category, catId);
    }

    @DeleteMapping("/{catId}")
    public void delete(@PathVariable Integer catId) {
        categoryService.delete(catId);
    }
}
