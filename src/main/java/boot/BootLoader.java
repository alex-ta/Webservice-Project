package boot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BootLoader implements ServletContextListener{
	
	private Database base;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 base.closeDatabase();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		base = Database.getDatabase();
	}
   
}