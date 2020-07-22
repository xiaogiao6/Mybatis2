import com.dao.IAccountDao;
import com.dao.IUserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao account;
    private SqlSessionFactory factory;
    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in=Resources.getResourceAsStream("com/SqlMapConfig.xml");
        //2.创建sqlsessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        //3.使用工厂生产ssqlSession对象
        sqlSession=factory.openSession();
        // 4.使用sqlSession创建接口代理对象
        account=sqlSession.getMapper(IAccountDao.class);
        userDao =sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws Exception{
        //6。释放资源
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFirstLevelCache(){
        User oneUser1 = userDao.findOneUser(41);
        System.out.println(oneUser1);
        sqlSession.close();
        //再次获取sqlSession
        sqlSession=factory.openSession();
        userDao=sqlSession.getMapper(IUserDao.class);
        User oneUser2 = userDao.findOneUser(41);
        System.out.println(oneUser2);
        System.out.println(oneUser1==oneUser2);
    }
    @Test
    public void testClearCache(){
        User oneUser1 = userDao.findOneUser(41);
        System.out.println(oneUser1);
        oneUser1.setUsername("new name");
        oneUser1.setAddress("浙江杭州");
        userDao.updateUser(oneUser1);
        User oneUser2 = userDao.findOneUser(41);
        System.out.println(oneUser2);
        System.out.println(oneUser1 == oneUser2);
    }


    @Test
    public void test(){
        User oneUser = userDao.findOneUser(42);
        System.out.println(oneUser);
    }

}
