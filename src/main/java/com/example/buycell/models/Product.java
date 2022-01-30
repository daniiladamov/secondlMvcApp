package com.example.buycell.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private int price;
    private String city;
    private String author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY
    , mappedBy = "product")
        private List<Image> images=new ArrayList<>();
        private Long previewImageId;
        private LocalDateTime dateOfCreated;

@PrePersist
private void init(){
    dateOfCreated=LocalDateTime.now();
}

public void addImage(Image image){
    image.setProduct(this);
    images.add(image);

}
}
