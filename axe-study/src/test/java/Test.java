import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 15/11/19 下午12:09
 * @version: V1.0
 */
public class Test {
    /**
     *
     * @param id id
     * @param queueCount work数
     * @param curQueue work号
     * @return
     */
    public static boolean isMyTask(int id, int queueCount, Integer curQueue) {
        int mod = Math.abs(id % queueCount);
        return mod == curQueue.intValue();
    }
    public static  void main(String[]args){
        for(int j=1;j<=6;j++){
            List<Integer> list =new ArrayList<>();
            for(int i=0;i<64;i++){
                if(isMyTask(i,6,j-1)){
                    list.add(i+1);
                }
            }
            System.out.println("j="+j+new Gson().toJson(list));
        }



    }

}
