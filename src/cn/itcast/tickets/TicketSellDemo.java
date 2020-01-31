package cn.itcast.tickets;

public class TicketSellDemo {
	public static void main(String[] args) {
		
		//创建电影票对象
		Ticket ticket = new Ticket();
		//创建Thread对象
		Thread thread1 = new Thread(ticket,"1号窗口");
		Thread thread2 = new Thread(ticket,"2号窗口");
		Thread thread3 = new Thread(ticket,"3号窗口");
		//执行售卖
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		
		
	}
}
