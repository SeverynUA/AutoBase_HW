package brainacad.org.autobase_hw.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Driver")
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "experience", nullable = false)
    private int experience;

    @Column(name = "pay_by_km", nullable = false)
    private double payByKm;

    @Column(name = "available", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean available;
}

