
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.BeanFactory; 
import org.springframework.beans.factory.xml.XmlBeanFactory; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.
              support.FileSystemXmlApplicationContext;
public class springDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Resource rs = 
	            new FileSystemResource("beans-config.xml"); 
	        BeanFactory factory = 
	            new XmlBeanFactory(rs); 
	        
	        HelloWord hello = 
	            (HelloWord) factory.getBean("HelloWord"); 
	        System.out.println(hello.getHelloWord()); */
		
		ApplicationContext context = 
	            new FileSystemXmlApplicationContext(
	                    "beans-config.xml");
		
		IRaytestDAO raytestDAO = 
	            (IRaytestDAO) context.getBean("RaytestDAO");
	        
	        Raytest raytest = new Raytest();
	        raytest.setFirstname("caterpillar");
	        raytest.setPhone("+8862602368");
	        
	        raytestDAO.insert(raytest);
		    
	        raytest = raytestDAO.find();
	        
	        System.out.println(raytest.getFirstname());
		
		/*Configuration configuration = new Configuration();  
	       configuration.configure().addClass(Raytest.class);
	       //configuration.configure("hibernate.cfg.xml");
	       StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();  
	       
	       ServiceRegistry serviceRegistry = serviceRegistryBuilder.applySettings(configuration.getProperties()).build();
	       SessionFactory sf=configuration.buildSessionFactory(serviceRegistry);  
	                
	       Raytest ray = new Raytest();
	       ray.setAddress("taoyun");
	       ray.setFirstname("Jiahunghsu");
	       ray.setLastname("Hsu");
	       ray.setPhone("0956196159");
	       // 
	       Session ss=sf.openSession();  
	       ss.beginTransaction();
	       
	       ////saving objects to session  
	       ss.save(ray);  
	       ss.getTransaction().commit();  
	       ss.close();*/
	}

}
