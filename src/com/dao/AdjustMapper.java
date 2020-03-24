package com.dao;
/***
*评论信息
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface AdjustMapper  {
	public int addAdjust(AdjustModel model);
	public int delAdjust(AdjustModel model);
	public int updAdjust(AdjustModel model);
	public Map findAdjustById(AdjustModel model);
	public List<Map<String,Object>> findAdjustByCondition(AdjustModel model);
	public int findAdjustByConditionCount(AdjustModel model);
}