package com.example.demo.repository;

import com.example.demo.domain.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class AddressRepository {
    private final EntityManager em;
    public void save(Address address) {
        em.persist(address);
    }

    public Address findOne(Long Id){return em.find(Address.class, Id);}

}
