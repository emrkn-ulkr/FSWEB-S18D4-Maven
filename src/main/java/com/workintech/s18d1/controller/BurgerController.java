package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workintech/burgers")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @GetMapping("{id}")
    public Burger findById(@PathVariable int id){
        return burgerDao.findById(id);
    }

    @PutMapping("/{id}")
    public Burger update(@PathVariable int id,@RequestBody Burger burger){
        burger.setId(id);
        return burgerDao.save(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable int id){
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody Double price){
return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger>findByBreadType(@RequestBody String breadType){
        return burgerDao.findByBreadType(BreadType.valueOf(breadType.toUpperCase()));
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content){
        return burgerDao.findByContent(content);
    }

}
