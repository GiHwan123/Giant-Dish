package com.example.demo.repository;

import com.example.demo.domain.Checklist;
import com.example.demo.domain.DeliveryStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChecklistRepository {
        EntityManager em;


        @Transactional
        public Checklist save(Checklist checklist) {
            em.persist(checklist);
            return checklist;
        }

        public void CheckOrder(Checklist checklist) {
        if (checklist.getStatus() == DeliveryStatus.SUCCESS) {
                em.remove(checklist);
            }
        }

    public List<Checklist> findAll() {
        return em.createQuery("select m from Checklist m" , Checklist.class )
                .getResultList();

    }

        @Transactional
        public void deleteAll(){

            for(Checklist element: findAll() )
                em.remove(element);
        }
}
