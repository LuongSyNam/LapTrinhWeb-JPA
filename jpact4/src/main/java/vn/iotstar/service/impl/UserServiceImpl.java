package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public void insert(User user) {
		User u = this.findByUsername(user.getUsername());
		if (u == null) {
			userDao.insert(user);
		}

	}

	public User login(String username, String password) {
		User user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;

	}
	@Override
	public User register(User user) {
		userDao.insert(user);
		return user;
	}
	
	
	@Override
	public int count() {
		return userDao.count();
	}

	
	@Override
	public List<User> findAll(int page, int pagesize) {
		return userDao.findAll(page, pagesize);
	}

	
	@Override
	public List<User> searchByName(String username) {
		return userDao.searchByName(username);
	}

	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	
	@Override
	public User findById(int userid) {
		return userDao.findById(userid);
	}

	
	@Override
	public void delete(int userid) throws Exception {
		try {
			userDao.delete(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void update(User user) {
		User u = this.findById(user.getUserid());
		if (u != null) {
			userDao.update(user);
		}

	}

	
	@Override
	public User findByUsername(String name) {
		try {
			return userDao.findByUsername(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public User findByPhone(String phone) {
	    try {
	        return userDao.findByPhone(phone);
	    } catch (Exception e) {
	        // Ghi log hoặc thông báo lỗi cụ thể
	        e.printStackTrace();  // Hoặc sử dụng hệ thống log tốt hơn
	        return null;  // Trả về null nếu có lỗi
	    }
	}
	public static void main(String[] args) {
	    UserServiceImpl a = new UserServiceImpl();
	    User b = a.findByEmail("phuong@123");
	    if (b != null) {
	        System.out.print(b.getFullname());
	    } else {
	        System.out.println("Không tìm thấy người dùng với số điện thoại này.");
	    }
	}


	@Override
	public User findByEmail(String email) {
		try {
			return userDao.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
