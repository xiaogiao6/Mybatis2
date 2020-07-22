import com.dao.IAccountDao;
import com.dao.IUserDao;
import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */

public class mybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao account;
    @Before
    public void init() throws Exception{
        //1.读取配置文件
         in=Resources.getResourceAsStream("com/SqlMapConfig.xml");
        //2.创建sqlsessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //3.使用工厂生产ssqlSession对象
         sqlSession=factory.openSession();
        // 4.使用sqlSession创建接口代理对象
         userDao=sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws Exception{
        //6。释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public  void testFandall() {
        //5.使用代理对象释放资源
        List<User> users=userDao.findAll();
        for( User user:users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
         }
    @Test
    public void testSave() {
        User user =new User();
        user.setUsername("gao123456");
        user.setAddress("树人大学");
        user.setSex("女");
        user.setBirthday(new Date());
             //5.使用代理对象释放资源
             userDao.saveUser(user);
             //提交事务
             System.out.println(user);
         }
    @Test
    public void testUpdate(){
        User user =new User();
        user.setId(49);
        user.setUsername("gao11");
        user.setAddress("浙江");
        user.setSex("男");
        user.setBirthday(new Date());
        //5.使用代理对象释放资源
        userDao.updateUser(user);
        sqlSession.commit();

    }
    @Test
    public void testDelete(){

        userDao.deleteUser(49);
        sqlSession.commit();
    }
    @Test
    public void testFindOne(){

       User user= userDao.findOneUser(50);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){


        List<User> users=userDao.findByname("%王%");
        for( User user:users){
            System.out.println(user);
        }
    }
 @Test
    public void testFindbyCondition(){
        User user=new User();
        user.setUsername("老王");
        user.setSex("男");
        List<User> users=userDao.findByCondition(user);
     for( User user1:users){
         System.out.println(user1);
     }
 }
    @Test
    public void testFindbyId(){
        QueryVo vo=new QueryVo();
        List<Integer>list=new ArrayList<Integer>() ;
        list.add(41);
        list.add(42);
        list.add(45);
        vo.setIds(list);
        List<User> users=userDao.findUserInIds(vo);
        for( User user1:users){
            System.out.println(user1);
        }

    }
}
