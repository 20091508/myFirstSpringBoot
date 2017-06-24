package com.tian.repository;

/**
 * Created by tianxf9 on 2017/5/13.
 */

import com.tian.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{

    public List<Girl> findByAge(Integer age);
}
