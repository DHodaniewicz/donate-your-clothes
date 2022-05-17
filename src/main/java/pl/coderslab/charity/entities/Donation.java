package pl.coderslab.charity.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Podaj liczbę worków!")
    @Min(value = 1, message = "Liczba worków musi być większa 0!")
    private Integer quantity;
    @ManyToMany
    @NotEmpty(message = "Należy wybrać co najmniej jedną kategorię!")
    private Set<Category> categories;
    @ManyToOne
    @NotNull(message = "Należy wybrać instytucję!")
    private Institution institution;
    @NotBlank(message = "Pole nie może być puste!")
    private String street;
    @NotBlank(message = "Pole nie może być puste!")
    private String city;
    @NotBlank(message = "Pole nie może być puste!")
    @Pattern(regexp = "^\\d\\d-\\d\\d\\d$", message = "Kod pocztowy musi mieć format XX-XXX")
    private String zipCode;
    @Future(message = "Podana data musi być datą z przyszłości!")
    @NotNull(message = "Należy podać date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull(message = "Należy podać godzinę odbioru!")
    private LocalTime pickUpTime;
    @Size(max = 1000, message = "Komentarz nie może przekroczyć 1000 znaków")
    private String pickUpComment;
}
