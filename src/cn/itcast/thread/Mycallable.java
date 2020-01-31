package cn.itcast.thread;

import java.util.Date;
import java.util.concurrent.Callable;

public class Mycallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {
			System.out.println("MyCallable执行："+new Date().getTime());
		}
		return "MyCallable接口执行完成！";
	}

}
