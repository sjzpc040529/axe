package org.lzh.framework.axe.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzh.framework.axe.domain.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Courser on 2015/11/8.
 */

public class UserMapperTest extends BaseMapperTest {
    @Resource
    private UserMapper userMapper ;

    @Test
    public void saveTest(){
        User user = new User( );
        user.setAge("32");
        user.setUserName("李赵华1");
        userMapper.save(user);
    }


    public  static  void main(String[]arg0){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        User user = new User( );
        user.setAge("32");
        user.setUserName("李赵华");
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        userMapper.save(user);
    }
}
