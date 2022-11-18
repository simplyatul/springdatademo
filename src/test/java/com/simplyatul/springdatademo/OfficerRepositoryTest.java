package com.simplyatul.springdatademo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.simplyatul.springdatademo.entities.Officer;
import com.simplyatul.springdatademo.entities.Rank;
import com.simplyatul.springdatademo.repos.OfficerRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
class OfficerRepositoryTest {
    @Autowired
    @Qualifier("officerRepository")
    /*
     * @Qualifier not necessary, but if I have 2 or more repos of
     * same type then I can specify which one I want exactly 
     */
    private OfficerRepository repo;
    
    @Test
    public void testSave() {
        Officer officer = new Officer(Rank.ADMIRAL, "Soham");
        officer = repo.save(officer);
        System.out.println("Id: " + officer.getId());
        assertNotNull(officer.getId());
        assertEquals(Rank.ADMIRAL, officer.getRank());
    }

    @Test
    public void count() throws Exception {
        System.out.println("Repo Count: " + repo.count());
        //assertEquals(2, repo.count());
    }
}
