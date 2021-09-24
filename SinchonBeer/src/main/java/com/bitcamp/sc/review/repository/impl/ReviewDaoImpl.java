package com.bitcamp.sc.review.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.review.domain.Review;
import com.bitcamp.sc.review.domain.ReviewVO;
import com.bitcamp.sc.review.repository.ReviewDao;


@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	  private static final String NAME_SPACE = "com.bitcamp.sc.review.daoMapper";
	  
	  private final SqlSessionTemplate template;
	  
	  public ReviewDaoImpl(SqlSessionTemplate template) { 
		  this.template = template;
	  }
	
	
	@Autowired
	SqlSession SqlSession;
	
	// 01. 게시글 작성
	@Override
	public void create(ReviewVO vo) throws Exception {
    	SqlSession.insert(NAME_SPACE + "insertPost", vo);
	}
	
		
	
	// 02. 게시글 상세보기
	@Override
	public ReviewVO read(Integer idx) throws Exception {
    	return SqlSession.selectOne(NAME_SPACE + "viewPost", idx);
	}
    
	// 03. 게시글 수정
	@Override
	public void update(ReviewVO vo) throws Exception {
		SqlSession.update(NAME_SPACE + "updatePost", vo);

	}
    // 04. 게시글 삭제
    @Override
    public void delete(Integer idx) throws Exception {
        SqlSession.delete(NAME_SPACE + "deletePost",idx);
 
    }
    // 05. 게시글 전체 목록
    @Override
    public List<ReviewVO> listAll() throws Exception {
        return SqlSession.selectList(NAME_SPACE + "listAllPost");
    }
    // 게시글 조회수 증가
    @Override
    public void increaseViewcnt(Integer idx) throws Exception {
        SqlSession.update(NAME_SPACE + "increaseViewcnt", idx);
    }
 
}
