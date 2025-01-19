package org.canwia.marketlist.repository;

import org.canwia.marketlist.model.Item;
import org.canwia.marketlist.model.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByMarketList(MarketList marketList);
}
