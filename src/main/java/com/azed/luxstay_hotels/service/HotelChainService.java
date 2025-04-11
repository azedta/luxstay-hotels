package com.azed.luxstay_hotels.service;
import com.azed.luxstay_hotels.model.HotelChain;

import java.util.List;
import java.util.Optional;

public interface HotelChainService {

    List<HotelChain> findAllHotelChains();

    Optional<HotelChain> findHotelChainById(Long id);

    Optional<HotelChain> findHotelChainByName(String name);

    HotelChain addHotelChain(HotelChain hotelChain);

    void deleteHotelChain(Long id);

}
