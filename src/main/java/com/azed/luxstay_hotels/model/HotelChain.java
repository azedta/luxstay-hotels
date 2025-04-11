package com.azed.luxstay_hotels.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel_chain")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelChain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelChainId;

    private String hotelChainName;

    private Integer nbrOfHotels = 0;

    private String logo;

    // Relationships
    @OneToMany(mappedBy = "hotelChain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotel> hotels = new ArrayList<>();
}
