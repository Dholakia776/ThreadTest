package cn.itcast.tickets;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
	
	//初始化票数
	private int ticketNumber = 100;
	
	/*
	 * 同步代码块
	@Override
	public void run() {
		while(true) {
			synchronized (obj) {
				if(ticketNumber>0) {	//判断是否有票
					//有票，让线程休眠1000毫秒
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//打印当前初出售的票数和线程数
					String name = Thread.currentThread().getName();
					System.out.println(name+"销售第"+ticketNumber--+"张电影票");
					//票数减一
					
				}
			}
			
		}
	}
	*/
	/*
	 *同步方法
	@Override
	public void run() {
		while(true) {
			TicketSell();
		}
	}
	
	public synchronized void TicketSell() {
			if(ticketNumber > 0) {	//判断是否有票
				//有票，让线程休眠1000毫秒
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//打印当前初出售的票数和线程数
				String name = Thread.currentThread().getName();
				System.out.println(name+"销售第"+ticketNumber--+"张电影票");
				//票数减一			
		}
	}
	*/
	
	Lock lock = new ReentrantLock(true);
	@Override
	public void run() {
		while(true) {
				lock.lock();
				try {
				if(ticketNumber>0) {	//判断是否有票
					//有票，让线程休眠1000毫秒
					
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					//打印当前初出售的票数和线程数
					String name = Thread.currentThread().getName();
					System.out.println(name+"销售第"+ticketNumber--+"张电影票");
					//票数减一	
				}
				}finally {
					lock.unlock();
				}
			
		}
	}
	
	
	
}
