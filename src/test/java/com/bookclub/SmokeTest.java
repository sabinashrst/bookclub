package com.bookclub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookclub.web.AdminController;
import com.bookclub.web.HomeController;
import com.bookclub.web.WishlistController;
import com.bookclub.web.WishlistRestController;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private HomeController homeController;
	
	@Autowired
	private AdminController adminController;
	
	@Autowired
	private WishlistController wishListController;
	
	@Autowired
	private WishlistRestController wishListRestController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		assertThat(adminController).isNotNull();
		assertThat(wishListController).isNotNull();
		assertThat(wishListRestController).isNotNull();
	}
}
