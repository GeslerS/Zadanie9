package pl.sagiton.web.model;

import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by szymon on 03.03.16.
 */
@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;



    public List listUser(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM MyUser E WHERE E.username = '" +username + "'").list();
    }

}