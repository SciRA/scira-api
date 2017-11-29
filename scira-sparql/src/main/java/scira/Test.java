package scira;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.Node_URI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import virtuoso.jdbc4.VirtuosoConnectionPoolDataSource;

/**
 * Created by SilviuG on 26.11.2017.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/scira.sparql/applicationContext.xml");
        VirtuosoConnectionPoolDataSource virtuosoConnectionPoolDataSource = applicationContext.getBean(VirtuosoConnectionPoolDataSource.class);

    }
}
