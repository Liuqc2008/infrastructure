package infrastructure.test;
import org.junit.Test;

import infrastructure.thread.ThreadPoolProxyFactory;
import infrastructure.thread.test.*;

public class ThreadTest{

	 public static void main(String[] args) {
		 
		 ThreadPoolProxyFactory.getThreadPoolProxy().submit(new PrintOne());
		 ThreadPoolProxyFactory.getThreadPoolProxy().submit(new PrintSecond());
		 ThreadPoolProxyFactory.getThreadPoolProxy().submit(new PrintThree());
		 
		 
		 /*Hero gareen = new Hero();
		 gareen.name = "盖伦";
		 gareen.hp = 616;
		 gareen.damage = 50;
 
		 Hero teemo = new Hero();
		 teemo.name = "提莫";
		 teemo.hp = 300;
		 teemo.damage = 30;
         
		 Hero bh = new Hero();
		 bh.name = "赏金猎人";
		 bh.hp = 500;
		 bh.damage = 65;
         
		 Hero leesin = new Hero();
		 leesin.name = "盲僧";
		 leesin.hp = 455;
		 leesin.damage = 80;
         
		 Battle battle1 = new Battle(gareen,teemo);
         
		 ThreadPoolProxyFactory.getThreadPoolProxy().submit(battle1);
	 
		 Battle battle2 = new Battle(bh,leesin);

		 ThreadPoolProxyFactory.getThreadPoolProxy().submit(battle2);*/
        
	}

}
