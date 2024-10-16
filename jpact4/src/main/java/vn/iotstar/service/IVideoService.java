package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.dao.impl.VideoDao;
import vn.iotstar.entity.Video;

public interface IVideoService {

	Video findByTitle(String title);
	void update(Video video);
	void delete(String vidid) throws Exception;
	Video findById(String vidid);
	List<Video> findAll();
	List<Video> searchByTitle(String title);
	List<Video> findAll(int page, int pagesize);
	int count();
	void insert(Video video);
	IVideoDao viddao = new VideoDao();
}
