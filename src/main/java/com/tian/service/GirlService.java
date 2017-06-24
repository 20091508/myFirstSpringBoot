package com.tian.service;

import com.tian.domain.Girl;
import com.tian.exception.ExceptionEnum;
import com.tian.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tian.exception.GirlException;

/**
 * Created by tianxf9 on 2017/5/14.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertGrils() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("B");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("CCCC");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = this.girlRepository.findOne(id);
        int age = girl.getAge();
        if(age<=10) {
            throw new GirlException(ExceptionEnum.XIAOXUE);
        }
        else if(age>10&&age<16) {
            throw new GirlException(ExceptionEnum.ZHONGXUE);
        }
    }
}
