package com.azed.luxstay_hotels.service;

import com.azed.luxstay_hotels.model.HotelChain;
import com.azed.luxstay_hotels.repository.HotelChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelChainServiceImpl implements HotelChainService {

    private final HotelChainRepository hotelChainRepository;

    @Autowired
    public HotelChainServiceImpl(HotelChainRepository hotelChainRepository) {
        this.hotelChainRepository = hotelChainRepository;
    }

    @Override
    public List<HotelChain> findAllHotelChains() {
        return hotelChainRepository.findAll();
    }

    @Override
    public Optional<HotelChain> findHotelChainById(Long id) {
        return hotelChainRepository.findById(id);
    }

    @Override
    public Optional<HotelChain> findHotelChainByName(String name) {
        return hotelChainRepository.findAll()
                .stream()
                .filter(chain -> chain.getHotelChainName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public HotelChain addHotelChain(HotelChain hotelChain) {
        return hotelChainRepository.save(hotelChain);
    }

    @Override
    public void deleteHotelChain(Long id) {
        hotelChainRepository.deleteById(id);
    }


}
