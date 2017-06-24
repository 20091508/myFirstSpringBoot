package com.tian.controller;

import com.tian.domain.Girl;
import com.tian.domain.Result;
import com.tian.repository.GirlRepository;
import com.tian.service.GirlService;
import com.tian.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tianxf9 on 2017/5/13.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getGirls() {

        return girlRepository.findAll();

    }

    @PostMapping(value = "/girls")
    public Result addGirls(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.fail(1,bindingResult.getFieldError().getDefaultMessage());
        }
          return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girl/{id}")
    public Girl findOneGirl(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girl/{id}")
    public Girl updateGirl(@PathVariable("id")Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return  girlRepository.save(girl);
    }

    @DeleteMapping(value = "girl/{id}")
   public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
   }

   @GetMapping(value = "girls/age/{age}")
   public List<Girl> findGirlsByAge(@PathVariable("age")Integer age) {
        return girlRepository.findByAge(age);
   }

   @PostMapping(value = "/insert/girls")
    public void  saveGirls() {
        girlService.insertGrils();
   }

   @GetMapping(value = "girls/age/{id}")
   public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
   }

}
