package vip.itellyou.ui.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import vip.itellyou.pojo.User;
import vip.itellyou.service.UserService;
import vip.itellyou.service.impl.UserServiceImpl;

public class OffLineListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		User user = (User)session.getAttribute(User.SESSION_NAME);
        //ÐÞ¸ÄÏÂÏß×´Ì¬
		UserService userService = new UserServiceImpl();
		userService.online(user,false);
	}

}
