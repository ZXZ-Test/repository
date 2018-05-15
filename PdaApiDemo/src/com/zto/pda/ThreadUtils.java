package com.zto.pda;

import java.text.NumberFormat;
import java.util.concurrent.ConcurrentHashMap;  
import java.util.concurrent.CountDownLatch;  
import java.util.concurrent.ExecutorService;   
import java.util.concurrent.Executors;   

import net.sf.json.JSONObject;

/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................* 
 * 						<p>
 * 			 服务接口多线程并发测试工具类
 * 						</p>
 * 						<p>
 * 		 	Copyright: Copyright (c) 2018
 * 						</p>
 * 						<p>
 *            佛系代码          BUG随缘
 * 						</p>
 * 			 	   @author MoonLo
 * 	  	   @version 1.0 2018-4-12 09:07:08
 *
 */
public class ThreadUtils {
	static int count = 0;  
    //总访问量是client_num，并发量是thread_num  
    int thread_num = 10;  
    int client_num = 1000;  
      
    float avg_exec_time = 0;  
    float sum_exec_time = 0;  
    long first_exec_time = Long.MAX_VALUE;  
    long last_done_time = Long.MIN_VALUE;  
    float total_exec_time = 0;  
      
    String url = "";  
    Integer postData = 99990000;  
    
    /**
     * 静态初始方法
     * @param thread_num 线程池数量
     * @param client_num 每个线程池线程数量
     * @param url 需要测试的服务地址
     */
    public ThreadUtils(int thread_num, int client_num, String url, Integer hewbStart){  
          
        this.thread_num = thread_num;  
        this.client_num = client_num;  
        this.url = url;  
        this.postData = hewbStart;  
    }  
      
    /**
     * 线程池任务添加/运行  
     * <p>
     * </p>
     * @author MoonLo
     * @version 2018-4-12 上午9:08:22
     */
    public void run() {  
          
        final ConcurrentHashMap<Integer, ThreadRecord> records = new ConcurrentHashMap<Integer, ThreadRecord>();  
  
        // 建立ExecutorService线程池  
        ExecutorService exec = Executors.newFixedThreadPool(thread_num);  
        // thread_num个线程可以同时访问   
        // 模拟client_num个客户端访问  
        final CountDownLatch doneSignal = new CountDownLatch(client_num);  
        
        JSONObject stayinfo = new JSONObject();
		//p1
		stayinfo.put("operationBy", "5510000007");
		//p1
		stayinfo.put("ewbNo", "201822220131");
		//p1
		stayinfo.put("ewbsListNo","71887190218041301");
          
        for (int i = 0; i < client_num; i++) {  
        	
        	postData ++;
        	
        	String hewbNo = "201822220131" + postData;
        	
        	//p1
			stayinfo.put("hewbNo", hewbNo);
			
			final String params = stayinfo.toString();
              
            Runnable run = new Runnable() {  
                  
                public void run() {  
                      
                    int index = getIndex();  
                    long st = System.currentTimeMillis();  
                      
                    try {  
                        String result = ApiDemo.post(params, url);
                        System.out.println("返回参数：" + result);
                    } catch (Exception e) {   
                        e.printStackTrace();   
                    }  
                      
                    records.put(index, new ThreadRecord(st, System.currentTimeMillis()));  
                    doneSignal.countDown();//每调用一次countDown()方法，计数器减1  
                }   
            };   
            exec.execute(run);   
        }  
          
        try {  
            //计数器大于0 时，await()方法会阻塞程序继续执行  
            doneSignal.await();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
          
        /** 
         * 获取每个线程的开始时间和结束时间 
         */  
        for(int i : records.keySet()){  
            ThreadRecord r = records.get(i);  
            sum_exec_time += ((double)(r.et - r.st))/1000;  
              
            if(r.st < first_exec_time){  
                first_exec_time = r.st;  
            }  
            if(r.et > last_done_time){  
                this.last_done_time = r.et;  
            }  
        }  
          
        this.avg_exec_time = this.sum_exec_time / records.size();  
        this.total_exec_time = ((float)(this.last_done_time - this.first_exec_time)) / 1000;  
        NumberFormat nf=NumberFormat.getNumberInstance();  
        nf.setMaximumFractionDigits(4);  
          
          
        System.out.println("======================================================");  
        System.out.println("Thread Num: " + thread_num + ", Client Count: "+ client_num +".");  
        System.out.println("Avg Exec Time:   " + nf.format(this.avg_exec_time) + " s");  
        System.out.println("Total Exec Time: " + nf.format(this.total_exec_time) + " s");  
        System.out.println("Throughput:      " + nf.format(this.client_num /this.total_exec_time)+ " /s");  
    
        exec.shutdown();
    }  
      
    public static int getIndex(){  
        return ++count;  
    }  
      
    public static void main(String[] args) {  
    	
    	//要测试的URL  
        String url="http://183.134.7.6:9050/apps/pdaService";  
        
        
		Integer hewbStart = 99990000;
        //总访问量和并发量两重循环，依次增大访问  
        for(int j=10; j<20; j+= 10){  
            for(int i=5; i<25; i+=5){ 
            	hewbStart += j ; 
                new ThreadUtils(i, j, url, hewbStart).run();  
            }  
        }  
        System.out.println("finished!");  
    }  
}  

/**
 * <p>
 * 线程记录
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: UD
 * </p>
 * @author MoonLo
 * @version 2018-4-12 上午9:10:49
 */
class ThreadRecord {  
    long st;  
    long et;  
    public ThreadRecord(long st, long et){  
        this.st = st;  
        this.et = et;  
    }  	
}
