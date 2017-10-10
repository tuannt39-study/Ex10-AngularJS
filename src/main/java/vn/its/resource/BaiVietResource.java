package vn.its.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import vn.its.dao.BaiVietDAOImp;
import vn.its.model.BaiViet;

@Path("/baiviet")
public class BaiVietResource {

	// http://localhost:8080/Ex10/webresources/baiviet/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt() {
		return "Got it baiivet!";
	}

	// http://localhost:8080/Ex10/webresources/baiviet/all
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BaiViet> getAllBaiViet() {
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		ArrayList<BaiViet> baiViet = baiVietDAOImp.getAllBaiViet();
		return baiViet;
	}

	// http://localhost:8080/Ex10/webresources/baiviet/page?firstResult=2&maxResult=5
	@GET
	@Path("/page")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BaiViet> getAllByPages(@QueryParam("firstResult") String firstResult,
			@QueryParam("maxResult") String maxResult) {
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		ArrayList<BaiViet> baiViet = baiVietDAOImp.getAllByPages(Integer.parseInt(firstResult),
				Integer.parseInt(maxResult));
		return baiViet;
	}

	// http://localhost:8080/Ex10/webresources/baiviet/mabv/1
	@GET
	@Path("mabv/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BaiViet getBaiVietByMaBV(@PathParam("id") String id) {
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		BaiViet baiViet = baiVietDAOImp.getBaiVietByMaBV(Integer.parseInt(id));
		return baiViet;
	}

	// http://localhost:8080/Ex10/webresources/baiviet/count
	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public int countAllBaiViet() {
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		int baiViet = baiVietDAOImp.countAllBaiViet();
		return baiViet;
	}

	// http://localhost:8080/Ex10/webresources/baiviet/create
	// x-www-form-urlencoded
	// tieuDe:Hình ảnh thực tế về iPhone 7
	// danhMuc:Công nghệ
	// chiTiet:IPhone X là tương lai của điện thoại
	// lichDang:22-09-2017 12:03:03
	// trangThai:Duyệt
	// nhan:su-kien iphone apple
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Object create(@FormParam("tieuDe") String tieuDe, @FormParam("danhMuc") String danhMuc,
			@FormParam("chiTiet") String chiTiet, @FormParam("lichDang") String lich,
			@FormParam("trangThai") String trangThai, @FormParam("nhan") String nhan) {
		BaiViet baiViet = new BaiViet();
		baiViet.setTieuDe(tieuDe);
		baiViet.setDanhMuc(danhMuc);
		baiViet.setChiTiet(chiTiet);
		try {
			Date lichDang = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(lich);
			baiViet.setLichDang(lichDang);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		baiViet.setTrangThai(trangThai);
		baiViet.setNhan(nhan);
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		baiVietDAOImp.create(baiViet);
		return Response.ok().build();
	}

	// http://localhost:8080/Ex10/webresources/baiviet/update/29
	// x-www-form-urlencoded
	// tieuDe:Hình ảnh thực tế về iPhone 8
	// danhMuc:Công nghệ
	// chiTiet:IPhone X là tương lai của điện thoại
	// lichDang:22-09-2017 12:03:03
	// trangThai:Duyệt
	// nhan:su-kien iphone apple
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Object update(@PathParam("id") int id, @FormParam("tieuDe") String tieuDe,
			@FormParam("danhMuc") String danhMuc, @FormParam("chiTiet") String chiTiet,
			@FormParam("lichDang") String lich, @FormParam("trangThai") String trangThai,
			@FormParam("nhan") String nhan) {
		BaiViet baiViet = new BaiViet();
		baiViet.setMaBV(id);
		baiViet.getMaBV();
		baiViet.setTieuDe(tieuDe);
		baiViet.setDanhMuc(danhMuc);
		baiViet.setChiTiet(chiTiet);
		try {
			Date lichDang = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(lich);
			baiViet.setLichDang(lichDang);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		baiViet.setTrangThai(trangThai);
		baiViet.setNhan(nhan);
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		baiVietDAOImp.update(baiViet);
		return Response.ok().build();
	}

	// http://localhost:8080/Ex10/webresources/baiviet/delete/28
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Object delete(@PathParam("id") String id) {
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		baiVietDAOImp.delete(Integer.parseInt(id));
		;
		return Response.ok().build();
	}

}
