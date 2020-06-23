package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(items::add);
		return items;
	}

	public Item getItem(Integer id) {
		return itemRepository.findById(id).get();
	}

	public void addItem(Item item) {
		itemRepository.save(item);
	}

	public void updateItem(Integer id, Item item) {
		itemRepository.save(item);
	}

	public String deleteItem(Integer id) {
		if(null!=itemRepository.findById(id).get())
		{
			itemRepository.deleteById(id);
			if(null!=itemRepository.findById(id).get()) {
				return "Success";
			}
		}
		return "ItemNotFound";
	}

}
