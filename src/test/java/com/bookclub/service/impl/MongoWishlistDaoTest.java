package com.bookclub.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bookclub.model.WishlistItem;

@SpringBootTest
public class MongoWishlistDaoTest {

	 @Mock
    private MongoTemplate mongoTemplate;

	 @InjectMocks
    private MongoWishlistDao mongoWishlistDao;

    @Test
    public void testList() {
        // Arrange
        String username = "username";
        WishlistItem item1 = new WishlistItem("1234567890", "Book 1", username);
        WishlistItem item2 = new WishlistItem("0987654321", "Book 2", username);
        List<WishlistItem> expectedItems = Arrays.asList(item1, item2);

        Query expectedQuery = new Query();
        expectedQuery.addCriteria(Criteria.where("username").is(username));

        when(mongoTemplate.find(expectedQuery, WishlistItem.class)).thenReturn(expectedItems);


        List<WishlistItem> actualItems = mongoWishlistDao.list(username);

        assertEquals(expectedItems, actualItems);
        verify(mongoTemplate, times(1)).find(expectedQuery, WishlistItem.class);

    }
    
    @Test
    public void testRemove() {
        String key = "123456";

        Query expectedQuery = new Query();
        expectedQuery.addCriteria(Criteria.where("id").is(key));

        boolean result = mongoWishlistDao.remove(key);

        verify(mongoTemplate).remove(expectedQuery, WishlistItem.class);
        assertTrue(result);
    }
}
