package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.entity.Video;
import vn.iotstar.service.IVideoService;

public class VideoServiceImpl implements IVideoService {

	@Override
	public void insert(Video video) {
		Video vid = this.findByTitle(video.getTitle());
		if (vid == null) {
			viddao.insert(video);
		}
	}

	@Override
	public int count() {
		return viddao.count();
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		return viddao.findAll(page, pagesize);
	}

	@Override
	public List<Video> searchByTitle(String title) {
		return viddao.searchByTitle(title);
	}

	@Override
	public List<Video> findAll() {
		return viddao.findAll();
	}

	@Override
	public Video findById(String vidid) {
		return viddao.findById(vidid);
	}

	@Override
	public void delete(String vidid) throws Exception {
		try {
			viddao.delete(vidid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Video video) {
		Video vid = this.findById(video.getVideoId());
		if (vid != null) {
			viddao.update(video);
		}
	}

	@Override
	public Video findByTitle(String title) {
		try {
			return viddao.findByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
