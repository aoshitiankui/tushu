package com.dao;
/***
*部门信息
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface DeptMapper  {
	public int addDept(DeptModel model);
	public int delDept(DeptModel model);
	public int updDept(DeptModel model);
	public Map findDeptById(DeptModel model);
	public List<Map<String,Object>> findDeptByCondition(DeptModel model);
	public int findDeptByConditionCount(DeptModel model);
}