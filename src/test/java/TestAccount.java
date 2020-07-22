import com.dao.IAccountDao;
import com.dao.IUserDao;
import com.domain.Account;
import com.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 *
 */

public class TestAccount {
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
        account=sqlSession.getMapper(IAccountDao.class);
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
        List<Account> accounts=account.findAll();
        for( Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    @Test
    public  void testFindAllaccount(){
        //5.使用代理对象释放资源
        List<AccountUser> accountUsers=account.findAllAccount();
        for( AccountUser accountUser:accountUsers){
            System.out.println(accountUser);
        }
    }

}
