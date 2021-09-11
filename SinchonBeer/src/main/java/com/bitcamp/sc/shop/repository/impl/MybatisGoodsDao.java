package com.bitcamp.sc.shop.repository.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.shop.domain.GoodsVO;
import com.bitcamp.sc.shop.repository.GoodsDao;

@Repository
public class MybatisGoodsDao implements GoodsDao {

	private static final String NAME_SPACE = "GoodsMapper";
	
	private final SqlSessionTemplate template;
	
	@Autowired
	public MybatisGoodsDao(SqlSessionTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public GoodsVO insertGoods(GoodsVO vo) {
		template.insert(NAME_SPACE + ".insertGoods", vo);
		return vo;
	}


	@Override
	public void deleteGoods(int idx) {
		template.delete(NAME_SPACE + ".deleteGoods", idx);
		
	}


	

	

	
}
