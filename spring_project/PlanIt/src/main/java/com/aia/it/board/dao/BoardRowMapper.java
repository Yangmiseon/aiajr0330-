package com.aia.it.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aia.it.board.model.Board;


public class BoardRowMapper implements RowMapper<Board>{

	@Override
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Board board = new Board();
		board.setBidx(rs.getInt("bidx"));
		board.setUidx(rs.getInt("uidx"));
		board.setBtitle(rs.getString("btitle"));
		board.setPidx(rs.getInt("pidx"));
		board.setBmsg(rs.getString("bmsg"));
		board.setBphoto1(rs.getString("bphoto1"));
		board.setBphoto2(rs.getString("bphoto2"));
		
		
		return board;
	}

}
