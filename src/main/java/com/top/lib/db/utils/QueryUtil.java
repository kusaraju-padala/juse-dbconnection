package com.top.lib.db.utils;

import java.util.ArrayList;
import java.util.List;

import com.top.lib.beans.query.QueryBean;
import com.top.lib.beans.query.QueryFieldBean;

public class QueryUtil {

//	private QueryUtil() {
//
//	}
	
	public static String getQuery(QueryBean query) {
		
		return null;
	}
	
	public static void main(String args[]) {
		QueryBean query = new QueryBean();
		query.setIsGet(true);
		query.setQueryTableName("thought");
		QueryFieldBean queryField = new QueryFieldBean();
		queryField.setTableName("thought");
		queryField.setFieldName("t_user_id");
		queryField.setAliasName("userid");
		List<QueryFieldBean> fields = new ArrayList<QueryFieldBean>();
		fields.add(queryField);
		System.out.println(getQuery(query));
	}
	
	
	
}
