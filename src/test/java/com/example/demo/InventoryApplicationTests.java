package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.service.ItemService;

import org.junit.runner.RunWith;
import com.example.demo.dao.Item;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class InventoryApplicationTests {
	
	 @Mock 
	 ItemService itemService;
	 
	 List<Item> mockItems = new ArrayList<>(Arrays.asList(
			 new Item(1,"book",true),
			 new Item(2,"pen",false),
			 new Item(8,"waterbottle",false)
			 ));
	 
	@Test
	void getItemByIdTest(List<Item> mockItems) {
		assertEquals(itemService.getItem(mockItems.get(0).getId()),mockItems.get(0));
	}
	
	@Test
	void deleteItemByIdTest(List<Item> mockItems) {
		String statusSuccess=itemService.deleteItem(mockItems.get(0).getId());
		assertEquals(statusSuccess,"Success");
		String statusNotFound=itemService.deleteItem(mockItems.get(2).getId());
		assertEquals(statusNotFound,"ItemNotFound");
	}
	
	@Test
	void updateItemTest(List<Item> mockItems) {
		mockItems.get(0).setProductName("NewItem");
		itemService.updateItem(mockItems.get(0).getId(),mockItems.get(0));
		assertEquals(itemService.getItem(mockItems.get(0).getId()),mockItems.get(0));
	}

}
