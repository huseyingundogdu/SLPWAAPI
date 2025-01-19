package org.canwia.marketlist.repository;

import org.canwia.marketlist.model.Item;
import org.canwia.marketlist.model.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketListRepository extends JpaRepository<MarketList, Long> {
}


