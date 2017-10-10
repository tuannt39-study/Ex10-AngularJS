package vn.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.its.connect.DatabaseConnect;
import vn.its.model.BaiViet;

public class BaiVietDAOImp implements BaiVietDAO {
	
	private Connection conn;

	public BaiVietDAOImp() {
		super();
		this.conn = DatabaseConnect.getConnection();
	}

	@Override
	public ArrayList<BaiViet> getAllBaiViet() {
		ArrayList<BaiViet> list = new ArrayList<BaiViet>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getAllBaiViet = "SELECT MaBV, TieuDe, DanhMuc, ChiTiet, LichDang, TrangThai, Nhan "
					+ "FROM TUAN.BaiViet";
			pstm = conn.prepareStatement(getAllBaiViet);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int maBV = rs.getInt("maBV");
				String tieuDe = rs.getString("tieuDe");
				String danhMuc = rs.getString("danhMuc");
				String chiTiet = rs.getString("chiTiet");
				Date lichDang = rs.getDate("lichDang");
				String trangThai = rs.getString("trangThai");
				String nhan = rs.getString("nhan");
				BaiViet baiViet = new BaiViet(maBV, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan);
				list.add(baiViet);
			}
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return list;
	}

	@Override
	public ArrayList<BaiViet> getAllByPages(int firstResult, int maxResult) {
		ArrayList<BaiViet> list = new ArrayList<BaiViet>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getAllByPages = "select * from ( select a.*, rownum rnum from ( SELECT * FROM TUAN.BAIVIET order by MaBV ) a where rownum <= "
					+ maxResult + " ) where rnum >= " + firstResult;
			pstm = conn.prepareStatement(getAllByPages);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int maBV = rs.getInt("maBV");
				String tieuDe = rs.getString("tieuDe");
				String danhMuc = rs.getString("danhMuc");
				String chiTiet = rs.getString("chiTiet");
				Date lichDang = rs.getDate("lichDang");
				String trangThai = rs.getString("trangThai");
				String nhan = rs.getString("nhan");
				BaiViet baiViet = new BaiViet(maBV, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan);
				list.add(baiViet);
			}
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return list;
	}

	@Override
	public BaiViet getBaiVietByMaBV(int maBV) {
		BaiViet baiViet = new BaiViet();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getBaiVietByMaBV = "SELECT MaBV, TieuDe, DanhMuc, ChiTiet, LichDang, TrangThai, Nhan FROM TUAN.BaiViet "
					+ "WHERE maBV = ?";
			pstm = conn.prepareStatement(getBaiVietByMaBV);
			pstm.setInt(1, maBV);
			rs = pstm.executeQuery();
			if (rs.next()) {
				maBV = rs.getInt("maBV");
				String tieuDe = rs.getString("tieuDe");
				String danhMuc = rs.getString("danhMuc");
				String chiTiet = rs.getString("chiTiet");
				Date lichDang = rs.getDate("lichDang");
				String trangThai = rs.getString("trangThai");
				String nhan = rs.getString("nhan");
				baiViet = new BaiViet(maBV, tieuDe, danhMuc, chiTiet, lichDang, trangThai, nhan);
			}
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return baiViet;
	}

	@Override
	public int countAllBaiViet() {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String countAllBaiViet = "SELECT COUNT(MaBV) FROM TUAN.BAIVIET";
			pstm = conn.prepareStatement(countAllBaiViet);
			rs = pstm.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return count;
	}

	@Override
	public void create(BaiViet baiViet) {
		PreparedStatement pstm = null;
		try {
			String create = "INSERT INTO TUAN.BaiViet (TieuDe, DanhMuc, ChiTiet, LichDang, TrangThai, Nhan) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(create);
			String tieuDe = baiViet.getTieuDe();
			String danhMuc = baiViet.getDanhMuc();
			String chiTiet = baiViet.getChiTiet();
			String trangThai = baiViet.getTrangThai();
			String nhan = baiViet.getNhan();
			pstm.setString(1, tieuDe);
			pstm.setString(2, danhMuc);
			pstm.setString(3, chiTiet);
			pstm.setTimestamp(4, new Timestamp(baiViet.getLichDang().getTime()));
			pstm.setString(5, trangThai);
			pstm.setString(6, nhan);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void update(BaiViet baiViet) {
		PreparedStatement pstm = null;
		try {
			String update = "UPDATE TUAN.BaiViet "
					+ "SET TieuDe = ?, DanhMuc = ?, ChiTiet = ?, LichDang = ?, TrangThai = ?, Nhan = ? "
					+ "WHERE maBV = ?";
			pstm = conn.prepareStatement(update);
			String tieuDe = baiViet.getTieuDe();
			String danhMuc = baiViet.getDanhMuc();
			String chiTiet = baiViet.getChiTiet();
			String trangThai = baiViet.getTrangThai();
			String nhan = baiViet.getNhan();
			int maBV = baiViet.getMaBV();
			pstm.setString(1, tieuDe);
			pstm.setString(2, danhMuc);
			pstm.setString(3, chiTiet);
			pstm.setTimestamp(4, new Timestamp(baiViet.getLichDang().getTime()));
			pstm.setString(5, trangThai);
			pstm.setString(6, nhan);
			pstm.setInt(7, maBV);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void delete(int maBV) {
		PreparedStatement pstm = null;
		try {
			String delete = "DELETE FROM TUAN.BaiViet " + "WHERE maBV = ?";
			pstm = conn.prepareStatement(delete);
			pstm.setInt(1, maBV);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void duyet(int maBV) {
		PreparedStatement pstm = null;
		try {
			String duyet = "UPDATE TUAN.BaiViet " + "SET TRANGTHAI = 'Duyệt' WHERE maBV = ?";
			pstm = conn.prepareStatement(duyet);
			pstm.setInt(1, maBV);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void chan(int maBV) {
		PreparedStatement pstm = null;
		try {
			String chan = "UPDATE TUAN.BaiViet " + "SET TRANGTHAI = 'Chặn' WHERE maBV = ?";
			pstm = conn.prepareStatement(chan);
			pstm.setInt(1, maBV);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
