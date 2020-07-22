import com.dao.IRoleDao;
import com.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestRole {
    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;
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
        roleDao=sqlSession.getMapper(IRoleDao.class);
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
        List<Role> roles=roleDao.findAll();
        for( Role role:roles){
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
//    @Test
//    public  void testFindAllaccount(){
//        //5.使用代理对象释放资源
//        List<AccountUser> accountUsers=roleDao.findAllAccount();
//        for( AccountUser accountUser:accountUsers){
//            System.out.println(accountUser);
//        }
//    }

}
