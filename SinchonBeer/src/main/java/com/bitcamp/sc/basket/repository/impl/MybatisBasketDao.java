package com.bitcamp.sc.basket.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.basket.domain.BasketDto;
import com.bitcamp.sc.basket.domain.BasketVo;
import com.bitcamp.sc.basket.repository.BasketDao;
@Repository
public class MybatisBasketDao implements BasketDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String NAME_SPACE = "BasketMapper";
	
	private SqlSessionTemplate template;
	
	@Autowired
	public MybatisBasketDao(SqlSessionTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public int createBasket(BasketDto bDto) {
		logger.info("장바구니 mybatis 진입"+bDto.toString());
		return template.insert(NAME_SPACE+".insertBasket", bDto);
	}

	@Override
	public List<BasketVo> getBasketList(int midx) {
		return template.selectList(NAME_SPACE+".getBasketList",midx);
	}

	@Override
	public int getTotalPay(int midx) {
		logger.info("mybatis 진입");
		Integer test = template.selectOne(NAME_SPACE+".getTotal",midx) ;
		test  = test == null ? 0 : test;
		logger.info(String.valueOf(test));
		return test;
	}

	@Override
	public int deleteRowByGidx(int gidx,int midx) {
		Map<String,Object> params = new HashMap<>();
		params.put("gidx", gidx);
		params.put("midx", midx);
		return template.delete(NAME_SPACE+".deleteRow",params);
	}

	@Override
	public void deleteAll(int midx) {
		template.delete(NAME_SPACE+".deleteAll",midx);
	}

	@Override
	public int checkBasket(int gidx, int midx) {
		logger.info("check mybatis 진입");
		logger.info(gidx+":"+midx);
		Map<String,Object> params = new HashMap<>();
		params.put("gidx", gidx);
		params.put("midx", midx);
		
		Integer test=template.selectOne(NAME_SPACE+".checkBasket", params);
		logger.info("test : " + test);
		int result = (test == null) ? 0 : test;
		logger.info("result int 변환 : " + result); 
		return result;
//		logger.info(String.valueOf(params.get("midx")));
		//  	변수

//		return (test == null) ? 0 : test;
	}

	@Override
	public void modifyAmount(BasketDto bDto) {
		template.update(NAME_SPACE+".updateBasket", bDto);
	}

	@Override
	public int changeBasketAmount(BasketDto bDto) {
		return template.update(NAME_SPACE+".changeAmount", bDto);
	}
	
	
}
