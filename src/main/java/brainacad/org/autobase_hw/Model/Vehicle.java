package brainacad.org.autobuse_.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Vehicle")
public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "max_load", nullable = false)
    private double maxLoad;

    @Column(name = "available", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean available;

    @Column(name = "broken", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean broken;
}
