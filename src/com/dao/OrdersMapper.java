package com.dao;
/***
*订单
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface OrdersMapper  {
	public int addOrders(OrdersModel model);
	public int delOrders(OrdersModel model);
	public int updOrders(OrdersModel model);
	public Map findOrdersById(OrdersModel model);
	public List<Map<String,Object>> findOrdersByCondition(OrdersModel model);
	public int findOrdersByConditionCount(OrdersModel model);
}