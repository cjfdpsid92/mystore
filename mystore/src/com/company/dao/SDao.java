package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.dbmanager.DBmanager;
import com.company.dto.SDto;

public class SDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	
	public ArrayList<SDto> search(String keyword, String cnation, String cbig, String csmall) {
		ArrayList<SDto> list = new ArrayList<SDto>();
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select a.* , b.cnation, c.cbig, d.csmall from storebooks a, category1 b, category2 c, category3 d where "
				+ "a.bscate1=b.cno and a.bscate2=c.cno and a.bscate3=d.cno;";
		if (keyword != null) { sql += " and (a.bstitle like '%?%' or a.bswriter like '%?%' or a.bspublisher like '%?%')"; }
		if (cnation != null) { sql += " and b.cnation=?"; }
		if (cbig != null) { sql += " and c.cbig=?"; }
		if (csmall != null) { sql += " and d.cnation=?"; }
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new SDto(rset.getInt("bsno"), rset.getString("bstitle"), rset.getString("bswriter"),
						rset.getString("bspublisher"), rset.getString("bsdate"), rset.getInt("bspage"),
						rset.getString("bsisbn13"),rset.getString("bsimg"),rset.getInt("bsprice"),
						rset.getString("cnation"), rset.getString("cbig"), rset.getString("csmall"), 
						rset.getString("bscontent")));
			}
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return list;
	}

}
