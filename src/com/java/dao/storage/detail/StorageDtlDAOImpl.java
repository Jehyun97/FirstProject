package com.java.dao.storage.detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.storage.detail.StorageDtlVO;

public class StorageDtlDAOImpl implements StorageDtlDAO {

	private DataSource dataSource = DataSource.getInstance();

	@Override
	public List<StorageDtlVO> selectStorageDtlList(String s_num) throws SQLException {
		List<StorageDtlVO> storageDtlList = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String sql = "select f.f_name, s.* from storage_dtl s, food f where s.f_code = f.f_code and s_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_num);

			ResultSet rs = pstmt.executeQuery();
			storageDtlList = toStorageDtlList(rs);
			
			return storageDtlList;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
		

	}
	
	@Override
	public List<StorageDtlVO> selectStorageDtlByCri(Criteria cri,String s_num) throws SQLException {
		List<StorageDtlVO> storageDtlList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "select s.*,f.f_name from storage_dtl s, food f"
					    +" where f.f_code = s.f_code and s.s_num='"+s_num+"' and";
			
			switch(cri.getSearchType()) {
			case "n" :
				sql+=" f.f_name like '%"+cri.getKeyword()+"%'";
				break;
			case "i" :
				sql+=" s.sd_num like '%' ||'"+cri.getKeyword()+"'||'%'";
				break;
			}
			
			rs = stmt.executeQuery(sql);
			
			storageDtlList = toStorageDtlList(rs);
			return storageDtlList;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		
	}

	@Override
	public StorageDtlVO selectStorageDtlBySdnum(String sd_num) throws SQLException {
		StorageDtlVO storageDtl = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from storage_dtl where sd_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sd_num);
			
			ResultSet rs = pstmt.executeQuery();
			List<StorageDtlVO> storageDtlList = toStorageDtlList(rs);
			if(storageDtlList.size()>0) storageDtl = storageDtlList.get(0);
			return storageDtl;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
		
	}

	@Override
	public void insertStorageDtl(StorageDtlVO storagedtl) throws SQLException {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into"
						+" storage_dtl(sd_num,s_num,f_code,sd_qty,sd_standard,sd_section)"
					    +" values(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storagedtl.getSd_num());
			pstmt.setString(2, storagedtl.getS_num());
			pstmt.setString(3, storagedtl.getF_code());
			pstmt.setInt(4, storagedtl.getSd_qty());
			pstmt.setInt(5, storagedtl.getSd_standard());
			pstmt.setString(6, storagedtl.getSd_section());
			//pstmt.setString(7, storagedtl.getSd_date());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
		
	}

	@Override
	public void updateStorageDtl(StorageDtlVO storagedtl) throws SQLException {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update storage_dtl "
						+" set"
						+" sd_num=?, f_code=?, sd_qty=?, sd_standard=?, sd_section=?, sd_date=?"
					    +" where s_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storagedtl.getSd_num());
			pstmt.setString(2, storagedtl.getF_code());
			pstmt.setInt(3, storagedtl.getSd_qty());
			pstmt.setInt(4, storagedtl.getSd_standard());
			pstmt.setString(5, storagedtl.getSd_section());
			pstmt.setString(6, storagedtl.getSd_date());
			pstmt.setString(7, storagedtl.getS_num());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
	}

	@Override
	public void deleteStorageDtl(String sd_num) throws SQLException {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "delete from storage_dtl where sd_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sd_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}

	}

	
	
	private List<StorageDtlVO> toStorageDtlList(ResultSet rs) throws SQLException {
		List<StorageDtlVO> storageDtlList = new ArrayList<StorageDtlVO>();

		while (rs.next()) {
			StorageDtlVO storageDtl = new StorageDtlVO();

			storageDtl.setF_code(rs.getString("f_code"));
			storageDtl.setS_num(rs.getString("s_num"));
			storageDtl.setSd_date(rs.getString("sd_date"));
			storageDtl.setSd_num(rs.getString("sd_num"));
			storageDtl.setSd_qty(rs.getInt("sd_qty"));
			storageDtl.setSd_standard(rs.getInt("sd_standard"));
			storageDtl.setSd_section(rs.getString("sd_section"));
			storageDtl.setF_name(rs.getString("f_name"));

			storageDtlList.add(storageDtl);

		}

		return storageDtlList;
	}

	
}
