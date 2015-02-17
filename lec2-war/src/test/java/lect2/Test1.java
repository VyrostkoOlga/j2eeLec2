package lect2;


	import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.*;

import impls.SimpleWarehouse;
import interfaces.IWarehouse;

	import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.vyrostkoolga.j2eelec2.lec3.jndi.MaxNumEl;
import excs.NoSuchGoodException;

	public class Test1 {
		
		private ApplicationContext ctx;
		private Hashtable<String, String> env;
		
		public Test1()
		{
			env = new Hashtable<String, String>(2);
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
			  //this configuration is required for binding
			env.put(Context.PROVIDER_URL, "file:/Users/OlgaVyrostko/GitHub/lec3Adds");
			
			try {
				Context ctx = new InitialContext(env);
				MaxNumEl mNum = (MaxNumEl) ctx.lookupLink("maxNumEl");
				System.out.println(mNum);
				//MaxNumEl maxNumEl = new MaxNumEl("defs://max-num-el", 10);
				//ctx.unbind("Config/maxNumEl");
				//ctx.bind("Config/MaxNumEl", maxNumEl);
				System.out.println("after Binding");
				// Check that it is bound
				
				//Object ref = ctx.lookup("maxNumEl");
				//System.out.println("MaxNumEl" + ref);
				//RefAddr addr = ref.get("ref");
				//RefAddr num = ref.get("num");
				//MaxNumEl new_fruit = new MaxNumEl((String) addr.getContent(), Integer.parseInt(num.toString()));;
				//System.out.println(new_fruit);
				
				// Close the context when we're done
				ctx.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					System.out.println("Exc " + e.getMessage());
				}
		     	//ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
			}

		@Test
		public void testCreatingBeans() 
		{
			try {
				Context ctx = new InitialContext(env);
				MaxNumEl mNum = (MaxNumEl) ctx.lookupLink("Config/maxNumEl");
				System.out.println(mNum);
				//IWarehouse wh = (SimpleWarehouse)ctx.getBean("WH1");
				//System.out.println(wh.getInfo());
				((AbstractApplicationContext) ctx).close();
			}
			catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		
		/*
		@Test
		public void testGettingGood1()
		{
			ApplicationContext ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
			IWarehouse wh = (SimpleWarehouse)ctx.getBean("WH1");
			try 
			{
				wh.getOneGood("apple", 10);
			} catch (NoSuchGoodException e) 
			{
				fail(e.getMessage());
			}
			int qty = wh.getCtgs().get(0).getGoods().get(0).getQty();
			assertEquals(qty, 0);
		}
		
		@Test
		public void testGettingGood2()
		{
			ApplicationContext ctx = new ClassPathXmlApplicationContext( "/beans.xml" );
			IWarehouse wh = (SimpleWarehouse)ctx.getBean("WH1");
			try 
			{
				wh.getOneGood("strowberries", 3);
			} catch (NoSuchGoodException e) 
			{
				fail(e.getMessage());
			}
			System.out.println("After going some work");
			System.out.println(wh.getInfo());
		}
		*/

	}

