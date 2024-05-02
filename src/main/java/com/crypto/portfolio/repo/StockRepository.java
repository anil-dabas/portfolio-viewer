package com.crypto.portfolio.repo;

import com.crypto.portfolio.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,String> {

    @Query("Select st.code FROM stock st")
    List<String> findAllStockCodes();

    List<Stock> findByCodeIn(List<String> codes);

}
