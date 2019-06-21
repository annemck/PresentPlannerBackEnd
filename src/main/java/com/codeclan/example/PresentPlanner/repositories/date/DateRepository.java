package com.codeclan.example.PresentPlanner.repositories.date;

import com.codeclan.example.PresentPlanner.models.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long>, DateRepositoryCustom {
}
