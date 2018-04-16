package com.bjgoodwill.insurance.util;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


public class PageInfoUtil {
	public static  <T> PageInfo<T>  getPageInfo(List<T> l, int pageNum, int pageSize) {
		
		if(pageNum==0){
			pageNum=1;
		}
		Page <T> p = new Page<T>();
		p.setPageNum(pageNum);
		p.setPageSize(pageSize);
		for(int i=(pageNum-1)*pageSize;i<(pageNum*pageSize);i++){
			if(l.size()>i){
				p.add(l.get(i));
			}
		}
		p.setTotal(l.size());
		int pages =0;
		if(l.size()%pageSize==0){
			pages = l.size()/pageSize;
		}else{
			pages = l.size()/pageSize+1;
		}
		p.setPages(pages);
		PageInfo<T> pageInfo = new PageInfo<T>(p);
		return pageInfo;
	}

}
