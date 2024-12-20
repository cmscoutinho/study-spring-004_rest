package med.voll.api.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "User")
@Table(name = "user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
}
