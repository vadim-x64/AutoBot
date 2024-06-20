package project.ua.autobot.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypesImages> images;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VideoPaths> videos;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}