package brainacad.org.autobase_hw.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ім'я не може бути порожнім")
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Min(value = 0, message = "Досвід не може бути менше 0")
    @Column(name = "experience", nullable = false)
    private Integer experience;  // Змінено з `int` на `Integer`

    @DecimalMin(value = "0.1", message = "Оплата за км має бути більше 0")
    @Column(name = "pay_by_km", nullable = false)
    private Double payByKm;  // Змінено з `double` на `Double`

    @Column(name = "available", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean available;
}

