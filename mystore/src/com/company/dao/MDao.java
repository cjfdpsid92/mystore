package com.company.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.dbmanager.DBmanager;
import com.company.dto.MDto;

public class MDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	
	public int create (MDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		if (conn!=null) {System.out.println("CONNECTION");}
		String sql = "insert into mymember (mid, mname, mpass, memail, mdate, mip, mail_yes, sns, sms, usersex, postcode, address1, address2) values (?, ?, ?, ?, current_timestamp, ?, ?, ?, ?, ?, ?, ?, ? )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getMpass());
			pstmt.setString(4, dto.getMemail());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(6, dto.getMail_yes());
			pstmt.setString(7, dto.getSns());
			pstmt.setString(8, dto.getSms());
			pstmt.setString(9, dto.getUsersex());
			pstmt.setInt(10, dto.getPostcode());
			pstmt.setString(11, dto.getAddress1());
			pstmt.setString(12, dto.getAddress2());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		return result;
	}
		
	public MDto read (MDto dto) {
		MDto dto2 = new MDto();
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select * from mymember where mid=? and mpass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpass());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				dto2 = new MDto(rset.getInt("mno"), rset.getString("mid"), rset.getString("mname"), rset.getString("mpass"), rset.getString("memail"),
						rset.getString("mdate"), rset.getString("mip"), rset.getString("mail_yes"), rset.getString("sns"), rset.getString("sms"), rset.getString("usersex"),
						rset.getInt("postcode"), rset.getString("address1"), rset.getString("address2"));
			}
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		return dto2;
	}
	
	public MDto mypage (String id) {
		MDto dto2 = new MDto();
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select * from mymember where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				dto2 = new MDto(rset.getInt("mno"), rset.getString("mid"), rset.getString("mname"), rset.getString("mpass"), rset.getString("memail"),
						rset.getString("mdate"), rset.getString("mip"), rset.getString("mail_yes"), rset.getString("sns"), rset.getString("sms"), rset.getString("usersex"),
						rset.getInt("postcode"), rset.getString("address1"), rset.getString("address2"));
			}
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		return dto2;
	}
	
	public int update_mypage (MDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "update mymember set mname=?, memail=?, mail_yes=?, sns=?, sms=?, usersex=? where mid=?";
		System.out.println(dto);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getMemail());
			pstmt.setString(3, dto.getMail_yes());
			pstmt.setString(4, dto.getSns());
			pstmt.setString(5, dto.getSms());
			pstmt.setString(6, dto.getUsersex());
			pstmt.setString(7, dto.getMid());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		return result;
	}	
	
	public int update_pass (String mid, String old_pass, String new_pass) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "update mymember set mpass=? where mid=? and mpass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_pass);
			pstmt.setString(2, mid);
			pstmt.setString(3, old_pass);
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		return result;
	}	
	
	public int delete (MDto dto) {
		int result = -1;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "delete from mymember where mid=? and mpass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpass());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		return result;
	}
	
	public int idCheck(String id) {
		int cnt = 0;
		DBmanager db = new DBmanager();
		conn = db.connection(); pstmt = null; rset = null;
		String sql = "select count(*) cnt from mymember where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) { cnt = rset.getInt("cnt"); System.out.println("cnt : " + cnt); }
		} catch (Exception e) { e.printStackTrace();
		} finally {
			if(rset!=null) { try { rset.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null) { try { pstmt.close(); }  catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) { try { conn.close(); }  catch(Exception e) {e.printStackTrace();}}
		}
		
		return cnt;
	}

}
