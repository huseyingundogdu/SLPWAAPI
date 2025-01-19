package org.canwia.marketlist.controller;


import org.canwia.marketlist.dto.MarketListRequest;
import org.canwia.marketlist.model.MarketList;
import org.canwia.marketlist.repository.MarketListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/shoppingList")
@CrossOrigin
public class MarketListController {

    private final MarketListRepository marketListRepository;


    public MarketListController(MarketListRepository marketListRepository) {
        this.marketListRepository = marketListRepository;
    }


    @PostMapping
    public ResponseEntity<MarketList> createMarketList(@RequestBody MarketListRequest marketListRequest) {
        MarketList marketList = new MarketList();
        marketList.setTitle(marketListRequest.getTitle());

        marketListRepository.save(marketList);

        return ResponseEntity.ok(marketList);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MarketList>> getAllMarketList() {
        return ResponseEntity.ok(marketListRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketList> getMarketListById(@PathVariable Long id) {
        return ResponseEntity.ok(marketListRepository.findById(id).orElse(new MarketList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarketListById(@PathVariable Long id) {

        marketListRepository.deleteById(id);

        return ResponseEntity.ok("Deletion is successful");

    }
}
