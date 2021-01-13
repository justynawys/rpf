package pl.juswys.rpf.users;

public interface UserService {
    Users findByUserName(String userName);

    void saveUser(Users users);
}
