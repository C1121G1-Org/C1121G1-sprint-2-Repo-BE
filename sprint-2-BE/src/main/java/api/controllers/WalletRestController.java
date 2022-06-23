package api.controllers;

import api.dto.ChargeMoneyDto;
import api.models.ResponseObject;
import api.services.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/wallet")
public class WalletRestController {
    @Autowired
    IWalletService iWalletService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createWallet(){
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listWallet(){
        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateWallet(@PathVariable String id){
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deleteWallet(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
    //------------------------------
    //Son-DCM bd
    @PatchMapping(value = "/updateWallet/{chargeMoney}")
    public ResponseEntity<?> rechargeMoney(@RequestBody ChargeMoneyDto chargeMoney){
        if (iWalletService.findById(Long.parseLong(chargeMoney.getId())) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            iWalletService.chargeMoney(Double.parseDouble(chargeMoney.getValue()),Long.parseLong(chargeMoney.getId()));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
