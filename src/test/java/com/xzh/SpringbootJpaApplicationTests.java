package com.xzh;

import com.xzh.pojo.Film;
import com.xzh.pojo.User;
import com.xzh.repository.FilmRepository;
import com.xzh.repository.UserRepository;
import com.xzh.utils.FastJsonConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.n3r.idworker.Id;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testJpa() {
        List<Film> all = filmRepository.findAll();

        System.err.println(FastJsonConvertUtil.convertObjectToJSON(all));
    }

    @Test
    public void testPage() {

        Sort s = Sort.by(Sort.Order.asc("ctime"));
        Pageable pageable = PageRequest.of(1, 5, s);
        Page<Film> paged = filmRepository.findAll(pageable);
        System.err.println("total" + paged.getTotalElements());
        System.err.println("pages" + paged.getTotalPages());
        for (Film film : paged) {
            System.err.println(film.getCtime());
            System.err.println(FastJsonConvertUtil.convertObjectToJSON(film));


        }

    }

    @Test
    public void testInsert() {

        Film film = new Film();

        film.setId(Sid.nextShort());
        film.setTitle("测试");


        Film sa = filmRepository.save(film);
    }

    @Test
    public void testQuery() {
        Date date = new Date();
        List<Film> allByStarsAndYear = filmRepository.findAllByStarsAndYear("a", "b");
        List<Film> all = filmRepository.findAllByStarsAndYear("40", "2017");
        System.err.println("size" + all.size());
        System.err.println(FastJsonConvertUtil.convertObjectToJSON(all));
        all.forEach(item -> {
            System.err.println(item.getStars());
            System.err.println(item.getYear());
        });

    }

    @Test
    public void testUser() {
        User user = new User();
        user.setId(Sid.next());
        user.setName("test");
        user.setPhone("13800138000");
        userRepository.save(user);
    }

    @Test
    public void testUsers() {
        List<User> list = new ArrayList<>();
        for (int i = 10; i < 21; i++) {
            User user = new User();
            user.setId(Sid.next());
            user.setName("test" + i);
            user.setPhone(Sid.nextShort());
            user.setCtime(new Date());
            list.add(user);

        }

        userRepository.saveAll(list);
    }

}
