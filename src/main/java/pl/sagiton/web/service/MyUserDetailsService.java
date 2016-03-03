package pl.sagiton.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sagiton.web.model.MyUser;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by szymon on 03.03.16.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser user = userService.listUser().get(0);

        if(user == null) throw new UsernameNotFoundException("MyUser doesn't exist (" + username +")");

        List authList = new ArrayList();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(user.getUsername(),user.getPassword(), authList);
    }
}
