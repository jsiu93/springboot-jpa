package com.xzh;

import com.xzh.pojo.Film;
import com.xzh.repository.FilmRepository;
import com.xzh.utils.FastJsonConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.SysexMessage;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Autowired
    private FilmRepository filmRepository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testJpa(){
        List<Film> all = filmRepository.findAll();

        System.err.println(FastJsonConvertUtil.convertObjectToJSON(all));
    }

    @Test
    public void testPage(){

        Pageable pageable = PageRequest.of(1, 5);
        Page<Film> paged = filmRepository.findAll(pageable);
        System.err.println("total" + paged.getTotalElements());
        System.err.println("pages" + paged.getTotalPages());
        for (Film film : paged) {
            System.err.println(FastJsonConvertUtil.convertObjectToJSON(film));
        }

    }

}
