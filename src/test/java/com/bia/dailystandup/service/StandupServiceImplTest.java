/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.dailystandup.service;

import com.bia.dailystandup.entity.Standup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mdshannan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:spring/*.xml"})
@Transactional
public class StandupServiceImplTest {
    
    @Autowired
    protected StandupService standupService;
    
    public StandupServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchByHashTag method, of class StandupServiceImpl.
     */
    //@Test
    //@Rollback(false)
    public void testSearchByHashTag() {
        System.out.println("searchByHashTag");
        Standup expResult = standupService.create();
        Standup result = standupService.searchByHashTag(expResult.getHashtag());
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class StandupServiceImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Standup result = standupService.create();
        assertNotNull(result);
    }
}