package pl.juswys.rpf.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final Users users;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       Users users) {
        super(username, password, authorities);
        this.users = users;
    }

    public Users getUser() {
        return users;
    }


}
