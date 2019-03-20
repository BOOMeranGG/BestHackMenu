package com.example.mireamenu.controller;

import com.example.mireamenu.controller.jsonParser.JsonEatParser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonFoodListParserTest {
    private JsonEatParser parser;

    @Before
    public void setUp() {
        parser = new JsonEatParser();
    }

    @Test
    public void checkParsingDish() {
//        MainActivity act = new MainActivity();
//        FirstDishList resultDish = (FirstDishList) parser.doParse(act.getBaseContext(),
//                "mgupi", "firstDish",
//                FirstDishList.class
//        );
//        assertEquals(2, resultDish.list.size());
//
//        FirstDish expectedDish = new FirstDish();
//        expectedDish.id = ;
//        expectedDish.id = ;
//        expectedDish.id = ;
//        expectedDish.id = ;
//        expectedDish.id = ;
//        expectedDish.id = ;
//        expectedDish.id = ;
//        expectedDish.id = ;
    }
}
