package com.dao;
/***
*用户信息
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface UserMapper  {
	public int addUser(UserModel model);
	public int delUser(UserModel model);
	public int updUser(UserModel model);
	public Map findUserById(UserModel model);
	public List<Map<String,Object>> findUserByCondition(UserModel model);
	public int findUserByConditionCount(UserModel model);
}