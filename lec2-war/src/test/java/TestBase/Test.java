package TestBase;

import static org.junit.Assert.*;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.vyrostkoolga.j2eelec2.lec4.entities.Product;
import ru.vyrostkoolga.j2eelec2.lec4.services.*;
import baseImpls.BaseWarehouse;

public class Test 
{
	@org.junit.Test
	public void test() 
	{
		ProductService ps = new ProductService();
		WarehouseService ws = new WarehouseService();
		CategoryService cs = new CategoryService();
		
		BaseWarehouse bw = null;
		try {
			bw = new BaseWarehouse(ws, cs, ps, 1);
			bw.addOneGood("pommes", 10, 80, 0, "", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
		System.out.println(bw.getInfo());
	}

}
