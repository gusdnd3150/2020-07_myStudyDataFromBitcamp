package com.springbook.biz.common;

import java.util.HashMap;
import java.util.Map;

import com.springbook.biz.board.DeleteBoardController;
import com.springbook.biz.board.GetBoardController;
import com.springbook.biz.board.GetBoardListController;
import com.springbook.biz.board.InsertBoardController;
import com.springbook.biz.board.UpdateBoardController;
import com.springbook.biz.user.LoginController;
import com.springbook.biz.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());		
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());		
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}
}

