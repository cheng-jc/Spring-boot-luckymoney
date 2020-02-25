package com.me.luckymoney.controller;

import com.me.luckymoney.service.LuckmoneyService;
import com.me.luckymoney.domain.Luckymoney;
import com.me.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    @Autowired
    private LuckymoneyRepository repository;
    @Autowired
    private LuckmoneyService service;

    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }
    @PostMapping("/luckymoneys")
    /**
     * 创建红包
     */
    public Luckymoney creat(@RequestParam("producer") String producer,
                            @RequestParam("money")BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }
    /**
     * 通过ID查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }
    /**
     * 更新红包
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional =  repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        else {
            return null;
        }

    }
    @PostMapping("/luckymoneys/two")
    public void doubleLuckymoney() {
        service.creatTwo();

    }
}
