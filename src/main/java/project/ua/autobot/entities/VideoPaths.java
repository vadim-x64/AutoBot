package project.ua.autobot.entities;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "video_paths")
public class VideoPaths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "types_id")
    private Types types;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @Column(name = "video_path")
    private String videoPath;
}