package com.me.luckymoney.service;

import com.me.luckymoney.domain.Luckymoney;
import com.me.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckmoneyService {
    @Autowired
    private LuckymoneyRepository repository;
    @Transactional
    public void creatTwo() {
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("***");
        luckymoney1.setMoney(new BigDecimal(520));
        repository.save(luckymoney1);
        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("***");
        luckymoney2.setMoney(new BigDecimal(1314));
        repository.save(luckymoney2);
    }
}
