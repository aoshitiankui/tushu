package com.dao;
/***
*订单商品
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface OrderbooksMapper  {
	public int addOrderbooks(com.model.OrdersModel model);
	public int delOrderbooks(OrderbooksModel model);
	public int updOrderbooks(OrderbooksModel model);
	public Map findOrderbooksById(OrderbooksModel model);
	public List<Map<String,Object>> findOrderbooksByCondition(OrderbooksModel model);
	public int findOrderbooksByConditionCount(OrderbooksModel model);
}