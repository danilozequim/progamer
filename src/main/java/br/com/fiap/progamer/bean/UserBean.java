package br.com.fiap.progamer.bean;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import br.com.fiap.progamer.dao.UserDao;
import br.com.fiap.progamer.model.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();
	private List<User> list;

	public UserBean() {
		this.list = list();
	}

	public void save() {
		System.out.println(user);
		new UserDao().create(user);
	}

	public List<User> list() {
		UserDao dao = new UserDao();
		List<User> list = dao.listAll();
		return list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

}
