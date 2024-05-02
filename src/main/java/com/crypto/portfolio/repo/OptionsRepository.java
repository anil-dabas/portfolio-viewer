package com.crypto.portfolio.repo;

import com.crypto.portfolio.model.SecurityDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OptionsRepository extends JpaRepository<SecurityDefinition,String> {

}
