package api.controllers;

import api.models.*;
import api.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/gift")
public class GiftRestController {
    @Autowired
    IGiftService iGiftService;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IGuestService iGuestService;
    @Autowired
    IWalletService iWalletService;

    /*
            Created by TamHT
            Role: GUEST
            Time: 15:00 25/06/2022
    */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Gift>> listGift(@PageableDefault(value = 8) Pageable pageable,
                                               @RequestParam(value = "categoryId", defaultValue = "1", required = false) Integer categoryId) {
        Page<Gift> giftPage = iGiftService.getAllGift(pageable, categoryId);
        if (giftPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(giftPage, HttpStatus.OK);
    }

    @GetMapping(value = "category")
    public ResponseEntity<List<CategoryGift>> category() {
        List<CategoryGift> categoryGiftList = iGiftService.categoryList();
        if (categoryGiftList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryGiftList, HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/update")
    public ResponseEntity<Void> updateWallet(@RequestBody GiftGuest giftGuest) {
        Account account = iAccountService.getAccountByUserName(giftGuest.getSender());
        Guest guestSender = iGuestService.findGuestById(account.getGuest().getId());
        Wallet walletSender = iWalletService.findById(guestSender.getWallet().getId());
        double totalCoinSender = walletSender.getCoin();
        walletSender.setCoin(totalCoinSender - Double.parseDouble(giftGuest.getGift().getAmountCoin()));
        guestSender.setWallet(walletSender);
        iGuestService.update(guestSender);

//        set for guest receive
        Guest guest = iGuestService.findGuestById(giftGuest.getGuest().getId());
        Wallet wallet = iWalletService.findById(guestSender.getWallet().getId());
        double totalCoinReceive = walletSender.getCoin();
        wallet.setCoin(totalCoinReceive - Double.parseDouble(giftGuest.getGift().getAmountCoin()));
        guest.setWallet(wallet);
        iGuestService.update(guest);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
