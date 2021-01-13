package pl.juswys.rpf.users;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.customers.Customers;
import pl.juswys.rpf.magazine.Magazine;
import pl.juswys.rpf.users.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String userName;

    private String name;
    private String surname;
    @Email
    @Column(unique = true)
    private String email;
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}")
    private String password;
    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany
    private List<Customers> customers;

    @OneToMany
    private List<Magazine> magazines;


}
