package com.dao;
/***
*购物车
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface CartMapper  {
	public int addCart(CartModel model);
	public int delCart(CartModel model);
	public int updCart(CartModel model);
	public Map findCartById(CartModel model);
	public List<Map<String,Object>> findCartByCondition(CartModel model);
	public int findCartByConditionCount(CartModel model);
	public CartModel checkaddCart(CartModel model);
	
	public int updCartThrothAdd(CartModel model);
	
	public Map findCartOfMini(CartModel model);
	public int deleteCausBuybooks(com.model.OrdersModel model);
	
}