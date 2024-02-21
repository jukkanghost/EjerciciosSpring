package com.bananaapps.bananamusic.persistence.music;

import com.bananaapps.bananamusic.domain.music.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrder, Long>, PurchaseOrderRepository {
    public default PurchaseOrder getById(Long id){
        return getById(id);
    }

    public default List<PurchaseOrder> findAll(){
        return findAll();
    }

    public default PurchaseOrder save(PurchaseOrder order){
        return save(order);
    }

    public default void delete(PurchaseOrder order){
        delete(order);
    }
}
