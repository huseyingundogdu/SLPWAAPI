package org.canwia.marketlist.controller;

import org.canwia.marketlist.dto.ItemDto;
import org.canwia.marketlist.model.Item;
import org.canwia.marketlist.model.MarketList;
import org.canwia.marketlist.repository.ItemRepository;
import org.canwia.marketlist.repository.MarketListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    private final ItemRepository itemRepository;
    private final MarketListRepository marketListRepository;

    public ItemController(ItemRepository itemRepository, MarketListRepository marketListRepository) {
        this.itemRepository = itemRepository;
        this.marketListRepository = marketListRepository;
    }


    @GetMapping("/{id}")//ShoppingListId
    public ResponseEntity<List<Item>> findAll(@PathVariable Long id) {
        MarketList marketList = marketListRepository.findById(id).orElse(new MarketList());
        return ResponseEntity.ok(itemRepository.findAllByMarketList(marketList));
    }

    @PostMapping("/saveAll/{id}")
    public ResponseEntity<List<Item>> saveAll(@PathVariable Long id, @RequestBody List<ItemDto> itemDtoList) {
        MarketList marketList = marketListRepository.findById(id).orElse(new MarketList());
        List<Item> items = new ArrayList<>();
        for (ItemDto itemDto : itemDtoList) {
            Item item = new Item();
            item.setMarketList(marketList);
            item.setName(itemDto.getName());
            item.setQuantity(itemDto.getQuantity());
            item.setType(itemDto.getType());
            items.add(item);
        }

        itemRepository.saveAll(items);

        return ResponseEntity.ok(items);

    }




}
