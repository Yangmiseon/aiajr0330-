package com.aia.it.board.dao;

import java.util.List;

import com.aia.it.board.model.Board;

public interface BoardDaoInterface {
	
	public List<Board> selectTotalList();

	public int totalCnt();

	public List<Board> selectList();

	int insertBoard(Board board);
	
	

}
