package vn.its.dao;

import java.util.ArrayList;

import vn.its.model.BaiViet;

public interface BaiVietDAO {

	ArrayList<BaiViet> getAllBaiViet();
	
	ArrayList<BaiViet> getAllByPages(int firstResult, int maxResult);

	BaiViet getBaiVietByMaBV(int maBV);
	
	int countAllBaiViet();

	void create(BaiViet baiViet);

	void update(BaiViet baiViet);

	void delete(int maBV);
	
	void duyet(int maBV);
	
	void chan(int maBV);
}
