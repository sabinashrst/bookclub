package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao {

	List<WishlistItem> wishlist;

	public MemWishlistDao() {
		this.wishlist = new ArrayList<WishlistItem>();
		this.wishlist.add(new WishlistItem("10987654321", "Harry Potter and the Philosopher's Stone"));
		this.wishlist.add(new WishlistItem("0316531286", "The Island"));
		this.wishlist.add(new WishlistItem("9569852323", "Drifted"));
	}

	@Override
	public List<WishlistItem> list() {
		return this.wishlist;
	}

	@Override
	public WishlistItem find(String key) {
		for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
	}

}
