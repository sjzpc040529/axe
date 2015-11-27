package org.lzh.framework.axe.study.quartz;

import com.google.gson.Gson;
import org.lzh.framework.common.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:任务类 不继承QuartzJobBean
 * @author: lizhaohua
 * @date: 15/11/16 下午3:37
 * @version: V1.0
 */
public class Job1  {
    static {

    }
    public void doJob() throws InterruptedException {
        System.out.println("不继承QuartzJobBean方式-调度进行中..."+
                StringUtils.dateFormat(new Date())+
                "==>name:"+Thread.currentThread().getName()+
                " ==>threadId:"+Thread.currentThread().getId());
        getJson(Thread.currentThread().getName(),Integer.valueOf(Thread.currentThread().getName().split("-")[1]));
        Thread.sleep(10000);
//        if(Integer.parseInt(Thread.currentThread().getName().split("-")[1])%2==0){
//            data2(Thread.currentThread().getName());
//        }else {
//            data1(Thread.currentThread().getName());
//        }

    }

    private String data1(String name){
        System.out.println(name+"单数");
        return null ;
    }
    /**
     *
     * @param id id
     * @param queueCount work数
     * @param curQueue work号
     * @return
     */
    private  boolean isMyTask(int id, int queueCount, Integer curQueue) {
        int mod = Math.abs(id % queueCount);
//        if(mod==0) return true ;
        return mod == curQueue.intValue();
    }

    private void data2(String name){
        System.out.println(name+"双数");
    }

    private synchronized void getJson(String name,Integer curQueue){

            List<Integer> list =new ArrayList<>();
            for(int i=0;i<MaxRegionCount;i++){
                    if(isMyTask(i,5,curQueue-1)){
                        list.add(i+1);
                    }



        }
        System.out.println(name + "==>curQueue==>" + curQueue + "==>" + new Gson().toJson(list));
    }
    public static int MaxRegionCount = 64;
    private static AtomicLong region_id = new AtomicLong(0L);
    public static int getRegionNo() {
        boolean regionNo = false;
        long id = region_id.addAndGet(1L);
        int regionNo1 = (int)id % MaxRegionCount;
        if(id > 9223372036854775707L) {
            region_id.set(0L);
        }

        return regionNo1;
    }
}
