package com.crypto.portfolio.cache;

import com.crypto.portfolio.model.SecurityDefinition;
import com.crypto.portfolio.repo.OptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SecurityDerivativesCache {

    @Autowired
    OptionsRepository repository;

    public static Map<String, SecurityDefinition> derivativeCache;

    public void initCache(){
        derivativeCache = repository.findAll().stream().collect(Collectors.toMap(SecurityDefinition::getCode, secDef->secDef));
    }
}
