package brainacad.org.autobase_hw.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Request")
public class Request
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_point", nullable = false, length = 100)
    private String startPoint;

    @Column(name = "end_point", nullable = false, length = 100)
    private String endPoint;

    @Column(name = "cargo_weight", nullable = false)
    private double cargoWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_type_id",referencedColumnName = "id", nullable = false)
    private CargoType cargoType;
}
