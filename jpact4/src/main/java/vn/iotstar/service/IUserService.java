package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;

public interface IUserService {

	User findByUsername(String name);

	void update(User user);

	void delete(int userid) throws Exception;

	User findById(int userid);

	List<User> findAll();
	void insert(User user);

	List<User> searchByName(String username);

	List<User> findAll(int page, int pagesize);

	int count();

	User findByEmail(String email);

	User findByPhone(String phone);

	User register(User user);

	User login(String username, String password);

	IUserDao userDao = new UserDao();
}
