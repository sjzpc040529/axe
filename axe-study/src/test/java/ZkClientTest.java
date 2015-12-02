import org.lzh.framework.common.util.ZkGenerateSeqUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/30 下午1:37
 * @version: V1.0
 */
public class ZkClientTest {
        public static void main(String[] args) {
            ApplicationContext ac = new ClassPathXmlApplicationContext("spring-zkclient.xml");
            ZkGenerateSeqUtils generateSeqUtils=(ZkGenerateSeqUtils)ac.getBean("generateSeqUtils");
            final ExecutorService service = Executors.newFixedThreadPool(20);
//            for (int i = 0; i < 20; i++) {
//                service.execute(new Task1("[Concurrent-" + i + "]"));
//            }
            generateSeqUtils.generateZkSeq("/order",5,true);
        }

    }
//}
//class Task1 implements Runnable{
//
//    @Override
//    public void run() {
//
//    }
//}