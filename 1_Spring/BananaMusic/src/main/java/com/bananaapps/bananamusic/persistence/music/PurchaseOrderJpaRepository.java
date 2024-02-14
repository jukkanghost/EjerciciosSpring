package com.bananaapps.bananamusic.persistence.music;

import com.bananaapps.bananamusic.domain.music.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrder, Long>, PurchaseOrderRepository {


}
