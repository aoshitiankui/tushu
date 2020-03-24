package com.dao;
/***
*系统字典
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface CodesMapper  {
	public int addCodes(CodesModel model);
	public int delCodes(CodesModel model);
	public int updCodes(CodesModel model);
	public Map findCodesById(CodesModel model);
	public List<Map<String,Object>> findCodesByCondition(CodesModel model);
	public int findCodesByConditionCount(CodesModel model);
}