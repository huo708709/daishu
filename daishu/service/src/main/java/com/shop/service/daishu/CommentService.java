package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Comment;
import com.shop.data.mapper.daishu.CommentMapper;
import com.shop.service.AbstractService;

@Service
public class CommentService extends AbstractService<Comment> {

	@Autowired
	private CommentMapper commentMapper;
	
	public CommentService() {
		super(Comment.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.commentMapper;
	}

}
