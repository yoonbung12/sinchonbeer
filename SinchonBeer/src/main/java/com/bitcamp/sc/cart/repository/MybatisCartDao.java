package com.bitcamp.sc.cart.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.cart.domain.CartVO;

@Repository
public class MybatisCartDao implements CartDao{

	private static final String NAME_SPACE = "CartMapper";
	
	private final SqlSessionTemplate template;
	
	public MybatisCartDao(SqlSessionTemplate template) {
		this.template = template;
	}

	//	장바구니 추가
	@Override
	public CartVO insertCart(CartVO vo) {
		template.insert(NAME_SPACE + ".insertCart" , vo);
		return vo;
	}

	// 장바구니 목록
	@Override
	public List<CartVO> listCart(int memberIdx) {
		return template.selectOne(NAME_SPACE + ".listCart" , memberIdx);
	}

	// 장바구니 삭제
	@Override
	public void deleteCart(int idx) {
		template.delete(NAME_SPACE + ".deleteCart", idx);
		
	}

	// 장바구니 수정
	@Override
	public void modifyCart(CartVO vo) {
		template.update(NAME_SPACE + ".modifyCart" , vo);
		
	}

	// 장바구니 금액 합계
	@Override
	public int sumMoney(String memberIdx) {
		template.selectOne(NAME_SPACE + ".sumMoney" , memberIdx);
		return template.selectOne(NAME_SPACE + ".sumMoney", memberIdx);
	}

	// 장바구니 상품 확인
	@Override
	public int countCart(int goodsIdx, int memberIdx) {
		Map<String, Object> param = new HashMap<>();
		param.put("goodsIdx", goodsIdx);
		param.put("memberIdx", memberIdx);
		return template.selectOne(NAME_SPACE+ ".countCart", param);
	}
	
	// 장바구니 상품 수량 변경
	@Override
	public void updateCart(CartVO vo) {
		template.update(NAME_SPACE + ".updateCart", vo);
		
	}
	
	
	
}
