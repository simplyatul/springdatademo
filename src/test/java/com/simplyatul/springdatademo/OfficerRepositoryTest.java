package com.simplyatul.springdatademo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.simplyatul.springdatademo.entities.Officer;
import com.simplyatul.springdatademo.entities.Rank;
import com.simplyatul.springdatademo.repos.OfficerRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
/*
 * Transactional => after every tests, transactions rolled back
 * So you don't need to reset DB after every test
 */

class OfficerRepositoryTest {
    @Autowired
    @Qualifier("officerRepository")
    /*
     * @Qualifier not necessary, but if I have 2 or more repos of
     * same type then I can specify which one I want exactly 
     */
    private OfficerRepository repo;
    
    @Autowired
    private JdbcTemplate template;
    /*
     * way to pass already written SQL to DB and process the result
     * return by DB
     */
    
    
    @Test
    //@Disabled
    public void testSave() {
        Officer officer = new Officer(Rank.ADMIRAL, "Soham");
        officer = repo.save(officer);
        System.out.println("Id: " + officer.getId());
        assertNotNull(officer.getId());
        assertEquals(Rank.ADMIRAL, officer.getRank());
        System.out.println("Repo Count after insert: " + repo.count());
    }

    @Test
    public void count() throws Exception {
        System.out.println("Repo Count: " + repo.count());
        //assertEquals(2, repo.count());
    }
    
    @Test
    public void findAll() {
        List<String> names = repo.findAll().stream()
                .map(Officer::getName)
                .collect(Collectors.toList());
        //assertThat(names, containsInAnyOrder)
    }
}
