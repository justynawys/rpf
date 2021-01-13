package pl.juswys.rpf.customers;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.project.Projects;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    @Column(unique = true)
    private String email;

    private int numberPhone;
    @NotBlank
    private String city;
    @NotBlank
    private String address;

    @OneToMany
    private List<Projects> projects;


}
