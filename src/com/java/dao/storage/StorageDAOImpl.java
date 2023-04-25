package com.java.dao.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.storage.StorageVO;

public class StorageDAOImpl implements StorageDAO{

	private DataSource dataSource = DataSource.getInstance();
	
	
	@Override
	public List<StorageVO> selectStorageList(Criteria cri) throws SQLException {
		List<StorageVO> storageList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "select * from Storage";
			
			switch(cri.getSearchType()) {
			case "n" :
				sql+=" where s_num like '%' ||'"+cri.getKeyword()+"'||'%'";
				break;
			case "i" :
				sql+=" where id like '%' ||'"+cri.getKeyword()+"'||'%'";
				break;
			}
			
			rs = stmt.executeQuery(sql);
			
			storageList = toStorageList(rs);
			
			return storageList;
			
			
			
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
	public StorageVO selectStorageBySnum(String s_num) throws SQLException {
		StorageVO storage = null;
		Connection conn = null;
		
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from storage where s_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_num);
			
			ResultSet rs = pstmt.executeQuery();
			List<StorageVO> storageList = toStorageList(rs);
			if(storageList.size()>0) storage = storageList.get(0);
			
			return storage;
			
			} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
		
	}

	@Override
	public void insertStorage(StorageVO storage) throws SQLException {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into "
						+" storage(s_num, id, re_num, s_loc)"
						+" values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storage.getS_num());
			pstmt.setString(2, storage.getId());
			pstmt.setInt(3, storage.getRe_num());
			pstmt.setString(4, storage.getS_loc());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
		
	}

	@Override
	public void updateStorage(StorageVO storage) throws SQLException {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update storage "
						+" set"
						+" s_loc=?"
						+" where s_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1,storage.getId());
			pstmt.setString(1, storage.getS_loc());
			pstmt.setString(2, storage.getS_num());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
				
		
	}

	@Override
	public void deleteStorage(String s_num) throws SQLException {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "delete from storage where s_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn!=null)conn.close();
		}
	}
	
	
	private List<StorageVO> toStorageList(ResultSet rs)throws SQLException{
		List<StorageVO> storageList = new ArrayList<StorageVO>();
		
		while(rs.next()) {
			StorageVO storage = new StorageVO();
			
			storage.setId(rs.getString("id"));
			storage.setS_num(rs.getString("s_num"));
			storage.setS_loc(rs.getString("s_loc"));
			storage.setRe_num(rs.getInt("re_num"));
			
			storageList.add(storage);
		}
		return storageList;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
