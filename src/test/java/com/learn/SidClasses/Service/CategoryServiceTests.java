package com.learn.SidClasses.Service;

import com.learn.SidClasses.Entities.Category;
import com.learn.SidClasses.Repository.CategoryRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CategoryServiceTests {
    @Autowired
    private CategoryRepo crepo;
    @Test
    public void byTitle(){
        assertNotNull(crepo.findByTitleIgnoreCase("Fullstack Courses"));
        assertTrue(crepo.existsByTitle("Fullstack Courses"));
    }

    //for disabling the test
    //@Disabled
    //this is for parameterised test
    @ParameterizedTest
    @CsvSource({
            "3,1,2",
            "7,4,3",
            "22,11,11"
    })
    public void add(int expected,int a,int b){
        assertEquals(expected,a+b);
    }
}
