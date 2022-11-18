package com.simplyatul.springdatademo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplyatul.springdatademo.entities.Officer;
import com.simplyatul.springdatademo.entities.Rank;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer>{
                                            // JpaRepository <ClassName, PrimaryKey>
    List<Officer> findByRank(@Param("rank") Rank rank);
    List<Officer> findByName(@Param("name") String name);

}
