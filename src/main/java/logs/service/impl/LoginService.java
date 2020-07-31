package logs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logs.dao.ILoginDao;
import logs.entity.User;
import logs.service.ILoginService;

@Service
public class LoginService implements ILoginService {

    private ILoginDao dao;

    @Autowired
    public LoginService(ILoginDao dao) {
        this.dao = dao;
    }

    @Override
    public User login(User user) {
        return dao.login(user);
    }

}
