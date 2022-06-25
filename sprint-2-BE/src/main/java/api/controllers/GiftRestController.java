package api.controllers;

import api.models.CategoryGift;
import api.models.Gift;
import api.models.ResponseObject;
import api.services.ICategoryGiftService;
import api.services.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/gift")
public class GiftRestController {
    @Autowired
    IGiftService iGiftService;

    /*
            Created by TamHT
            Role: GUEST
            Time: 15:00 25/06/2022
    */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Gift>> listGift(@PageableDefault(value = 8)Pageable pageable) {
        Page<Gift> giftPage = iGiftService.getAllGift(pageable);
        if (giftPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(giftPage,HttpStatus.OK);
    }
    @GetMapping(value ="category" )
    public ResponseEntity<List<CategoryGift>> category() {
        List<CategoryGift> categoryGiftList = iGiftService.categoryList();
        if (categoryGiftList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryGiftList,HttpStatus.OK);
    }

}
