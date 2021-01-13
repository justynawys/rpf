package pl.juswys.rpf.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.juswys.rpf.users.role.Role;
import pl.juswys.rpf.users.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Users findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    @Override
    public void saveUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        users.setRoles(new HashSet<>(Arrays.asList(userRole)));
        usersRepository.save(users);
    }
}
