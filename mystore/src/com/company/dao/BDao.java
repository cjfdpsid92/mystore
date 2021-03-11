package com.company.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.dbmanager.DBmanager;
import com.company.dto.BDto;


public class BDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	
	public BDao() {
		
	}

	public ArrayList<BDto> list() {
		ArrayList<BDto> list = new ArrayList<BDto>();
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select * from mystore order by bstep desc, bindent asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new BDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("bpass"),
						rset.getString("btitle"), rset.getString("bcontent"), rset.getString("bdate"),
						rset.getInt("bhit"), rset.getString("bip"), rset.getString("bimg"), 
						rset.getString("bcategory"), rset.getInt("bgroup"), rset.getInt("bstep"), rset.getInt("bindent")));
			}
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return list;
	}
	
	public int create_max() {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select max(bstep) from mystore";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch(Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}
	
	public int create (BDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		if (conn!=null) {System.out.println("CONNECTION");}
		String sql = "insert into mystore (bname, bpass, btitle, bcontent, bdate, bip, bimg, bgroup, bstep, bindent) values (?, ?, ?, ?, current_timestamp, ?, ?, ?, ?, ? )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBpass());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(6, dto.getBimg());
			pstmt.setInt(7, dto.getBgroup());
			pstmt.setInt(8, dto.getBstep());
			pstmt.setInt(9, dto.getBindent());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}
	
	public int update_hit (BDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "update mystore set bhit = bhit+1 where bno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}	
	
	public BDto read (BDto dto) {
		BDto dto2 = new BDto();
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select * from mystore where bno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				dto2 = new BDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("bpass"),
						rset.getString("btitle"), rset.getString("bcontent"), rset.getString("bdate"),
						rset.getInt("bhit"), rset.getString("bip"), rset.getString("bimg"), 
						rset.getString("bcategory"), rset.getInt("bgroup"), rset.getInt("bstep"), rset.getInt("bindent"));
			}
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return dto2;
	}

	public int update (BDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "update mystore set btitle=?, bcontent=?, bimg=? where bno=? and bpass=?";
		System.out.println(dto);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBimg());
			pstmt.setInt(4, dto.getBno());
			pstmt.setString(5, dto.getBpass());	
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}	
	
	public int update_re1(BDto dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		try {
			DBmanager db = new DBmanager();
			conn = db.connection();
		} catch(Exception e) { e.printStackTrace(); }
		
		try {
			pstmt = conn.prepareStatement("update mystore set bstep = bstep-1 where bstep between ? and ?");
			int curr = dto.getBstep();
			int prev = (int)(Math.ceil(dto.getBstep()/(float)1000*1000-1000));
			pstmt.setInt(1, prev);
			pstmt.setInt(2, curr);
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace();
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}
	
	public int update_re2(BDto dto) {
		int result = -1;
		Connection conn = null; PreparedStatement pstmt = null;
		try {
			DBmanager db = new DBmanager();
			conn = db.connection();
		} catch(Exception e) { e.printStackTrace(); }
		
		try {
			pstmt = conn.prepareStatement("insert into mystore (bno, bname, bpass, btitle, bcontent, bdate, bip, bimg, bgroup, bstep, bident) values (seq_mvcboard4.nextval, ?, ?, ?, ?, curren_timestamp, ?, ?, ?, ?)");
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBpass());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostName());
			pstmt.setString(6, dto.getBimg());
			pstmt.setInt(7, dto.getBgroup());
			pstmt.setInt(8, dto.getBstep()-1);
			pstmt.setInt(9, dto.getBindent()+1);
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace();
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}
	
	public int delete (BDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "delete from mystore where bno=? and bpass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			pstmt.setString(2, dto.getBpass());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}		
	
	public int listcnt() {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select count(*) cnt from mystore";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) { result = rset.getInt("cnt"); }
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
		}
		return result;
	}
	
	public ArrayList<BDto> list10(int pstartno) {
		ArrayList<BDto> list = new ArrayList<BDto>();
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		//String sql = "select * from (select rownum rnum, a.* from (select * from mvcboard4 order by bno desc) a ) b";
		String sql = "select * from mystore order by bstep desc, bindent asc limit ?, 10";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pstartno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new BDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("bpass"),
						rset.getString("btitle"), rset.getString("bcontent"), rset.getString("bdate"),
						rset.getInt("bhit"), rset.getString("bip"), rset.getString("bimg"), 
						rset.getString("bcategory"), rset.getInt("bgroup"), rset.getInt("bstep"), rset.getInt("bindent")));
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
