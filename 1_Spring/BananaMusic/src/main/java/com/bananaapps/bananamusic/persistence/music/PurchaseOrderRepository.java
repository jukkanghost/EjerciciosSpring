package com.bananaapps.bananamusic.persistence.music;

import com.bananaapps.bananamusic.domain.music.PurchaseOrder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface PurchaseOrderRepository {

    public PurchaseOrder getById(Long id);

    public Collection<PurchaseOrder> findAll();

    public PurchaseOrder save(PurchaseOrder order);

    public void delete(PurchaseOrder order);
}
