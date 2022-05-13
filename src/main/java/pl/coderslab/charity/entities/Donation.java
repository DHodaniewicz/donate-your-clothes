package pl.coderslab.charity.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToMany
    private Set<Category> categories;
    @ManyToOne
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donation)) return false;
        Donation donation = (Donation) o;
        return Objects.equals(getId(), donation.getId()) && Objects.equals(getQuantity(), donation.getQuantity()) && Objects.equals(getCategories(), donation.getCategories()) && Objects.equals(getInstitution(), donation.getInstitution()) && Objects.equals(getStreet(), donation.getStreet()) && Objects.equals(getCity(), donation.getCity()) && Objects.equals(getZipCode(), donation.getZipCode()) && Objects.equals(getPickUpDate(), donation.getPickUpDate()) && Objects.equals(getPickUpTime(), donation.getPickUpTime()) && Objects.equals(getPickUpComment(), donation.getPickUpComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuantity(), getCategories(), getInstitution(), getStreet(), getCity(), getZipCode(), getPickUpDate(), getPickUpTime(), getPickUpComment());
    }

}
