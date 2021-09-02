package com.bitcamp.sc.order.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.stereotype.Repository;

import com.bitcamp.sc.order.domain.OrderInfo;
import com.bitcamp.sc.order.repository.OrderDao;

//@Repository
public class MemoryOrderDao implements OrderDao {
	
	private static Map<Integer, OrderInfo> store = new HashMap<>();
	private static int index;

	@Override
	public int save(OrderInfo orderInfo) {
		orderInfo.setIdx(index++);
		store.put(orderInfo.getIdx(), orderInfo);
		return 1;
	}

	@Override
	public OrderInfo findByIdx(int idx) {
		return store.get(idx);
	}

	@Override
	public List<OrderInfo> findByMemberIdx(int memberIdx) {
		List<OrderInfo> orderInfos = new ArrayList<>();
		for (int key : store.keySet()) {
			if (store.get(key).getMemberIdx() == memberIdx) {
				orderInfos.add(store.get(key));
			}
		}
		return orderInfos;
	}

	@Override
	public List<OrderInfo> findByCategoryAndMemberIdx(String category, int memberIdx) {
		List<OrderInfo> orderInfos = new ArrayList<>();
		for (int key : store.keySet()) {
			if (store.get(key).getCategory().equals(category) && store.get(key).getMemberIdx() == memberIdx) {
				orderInfos.add(store.get(key));
			}
		}
		return orderInfos;
	}
	
	public void clearStore() {
		store.clear();
		index = 0;
	}

}
