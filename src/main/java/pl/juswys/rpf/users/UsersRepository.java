package pl.juswys.rpf.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.juswys.rpf.customers.Customers;
import pl.juswys.rpf.magazine.Magazine;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findByUserName(String userName);

    public Users findByMagazines(Magazine magazine);

    public Users findByCustomers(Customers customers);

    @Query("SELECT u.customers  FROM Users u where u.id = ?1 ")
    public List<Customers> findCustomers(Long id);

    @Query("SELECT p.deadline, p.description, p.name FROM Users u JOIN u.customers uc on u.id = uc.id JOIN Customers c on c.id = uc.id JOIN c.projects cp on c.id = cp.id JOIN Projects p on p.id = cp.id WHERE u.id = ?1")
    public List<Users> findByProjects(Long id);


}
