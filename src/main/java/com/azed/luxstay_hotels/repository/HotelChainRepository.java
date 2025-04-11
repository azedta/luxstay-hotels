package com.azed.luxstay_hotels.repository;

import com.azed.luxstay_hotels.model.HotelChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelChainRepository extends JpaRepository<HotelChain, Long> {

}
