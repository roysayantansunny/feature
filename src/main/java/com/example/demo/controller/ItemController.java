package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@GetMapping("/items/{id}")
	public Item getItem(@PathVariable Integer id){
		return itemService.getItem(id);
	}
	
	@PostMapping("/items")
	public void addItem(@RequestBody Item item){
		itemService.addItem(item);
	}
	
	@PutMapping("/items/{id}")
	public void updateItem(@RequestBody Item item, @PathVariable Integer id){
		itemService.updateItem(id, item);
	}
	
	@DeleteMapping("items/{id}")
	public void deleteItem(@PathVariable Integer id) {
		itemService.deleteItem(id);
	}
	
}
