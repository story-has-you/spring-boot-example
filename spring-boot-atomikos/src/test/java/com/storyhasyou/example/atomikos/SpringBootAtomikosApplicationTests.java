package com.storyhasyou.example.atomikos;

import com.storyhasyou.example.atomikos.service.AtomikosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootAtomikosApplicationTests {

    @Autowired
    private AtomikosService atomikosService;

    @Test
    public void save() {
        atomikosService.save();
    }


}
