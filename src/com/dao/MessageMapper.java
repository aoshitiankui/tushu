package com.dao;
/***
*留言板
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface MessageMapper  {
	public int addMessage(MessageModel model);
	public int delMessage(MessageModel model);
	public int updMessage(MessageModel model);
	public Map findMessageById(MessageModel model);
	public List<Map<String,Object>> findMessageByCondition(MessageModel model);
	public int findMessageByConditionCount(MessageModel model);
}