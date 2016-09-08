import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzh.framework.axe.dao.UserMapper;
import org.lzh.framework.axe.domain.entities.User;
import org.lzh.framework.axe.manager.user.UserManager;
import org.lzh.framework.axe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class UserTest {

	@Autowired
	private UserMapper userMapper;
	@Resource
	private UserManager userManager ;
	@Resource
	private UserService userService ;

	@Test
	public void testAdd(){
		User user = new User(-1, "23", "jiuqiyuliang");
		userMapper.save(user);

	}

	@Test
	public void testFindAll(){
		List<User> findAllList = userMapper.findAll();
		System.out.println(findAllList.size());
	}

	@Test
	public void testFindById(){
		User user = userMapper.findById(2);
		System.out.println(user.getId());
		System.out.println(user.getUserName());
	}


	@Test
	public void testUpdate(){

		User user = new User(2, "23", "yuliang");
		userMapper.update(user);
	}

	@Test
	public void testDelete(){
		userMapper.delete(1);
	}
	@Test
	public void testAddService(){
		User user = new User(-1, "23", "jiuqiyuliang");
		userService.save(user);
	}
	@Test
	public void testAddBatchManager(){
		List<User> list = new ArrayList<>();
		for(int i=0 ; i<5; i++){

			User user = new User(i,"23","1111");
			if (i==4){
				user.setUserName("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
			}
			list.add(user);
		}
		userManager.batchSave(list);
	}
}
