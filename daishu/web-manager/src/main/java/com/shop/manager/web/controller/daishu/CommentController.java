package com.shop.manager.web.controller.daishu;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Comment;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.CommentService;

@Controller
@RequestMapping("ds/comment")
public class CommentController extends AbstractController<Comment> {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/comment/comment");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Comment comment) {
		comment.setCreateTime(new Date());
		this.getAbstractService().insert(comment);
		return this.response("添加评论成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Comment> getAbstractService() {
		return this.commentService;
	}

}
