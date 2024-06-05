package com.mfi.love_microfinance.repository;

import ch.qos.logback.core.model.INamedModel;
import com.mfi.love_microfinance.entity.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Integer> {
}
