package com.smc.location.entity;

import com.smc.location.model.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationEntity extends CrudRepository<Location, Long> {

    @Query("select type, count(type) from location group by type")
    public List<Object[]> findTypeAndTypeCount();
}
