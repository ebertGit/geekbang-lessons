package org.geektimes.projects.user.web.listener;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * 测试用途
 */
@Deprecated
public class TestingListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ComponentContext context = ComponentContext.getInstance();
        DBConnectionManager dbConnectionManager = context.getComponent("bean/DBConnectionManager");
        dbConnectionManager.getConnection();
        testPropertyFromServletContext(sce.getServletContext());
        testPropertyFromJNDI(context);
        testUser(dbConnectionManager.getEntityManager());
        logger.info("所有的 JNDI 组件名称：[");
        context.getComponentNames().forEach(logger::info);
        logger.info("]");
    }

    private void testPropertyFromServletContext(ServletContext servletContext) {
        String propertyName = "application.name";
        logger.info("ServletContext Property[" + propertyName + "] : "
                + servletContext.getInitParameter(propertyName));
    }

    private void testPropertyFromJNDI(ComponentContext context) {
        String propertyName = "maxValue";
        logger.info("JNDI Property[" + propertyName + "] : "
                + context.lookupComponent(propertyName));
    }

    private void testUser(EntityManager entityManager) {
        String CREATE_USERS_TABLE_DDL_SQL = "CREATE TABLE users(" +
                "id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                "name VARCHAR(16) NOT NULL, " +
                "password VARCHAR(64) NOT NULL, " +
                "email VARCHAR(64) NOT NULL, " +
                "phoneNumber VARCHAR(64) NOT NULL" +
                ")";

        User user = new User();
        user.setName("小马哥");
        user.setPassword("******");
        user.setEmail("mercyblitz@gmail.com");
        user.setPhoneNumber("abcdefg");
        try {
            entityManager.find(User.class, 1L);
        } catch (Exception e) {
            logger.warning(e.getMessage());
            logger.warning("Create Table (users).");
            try {
                String databaseURL = "jdbc:derby:db/user-platform;create=true";
                Connection connection = DriverManager.getConnection(databaseURL);

                Statement statement = connection.createStatement();
                statement.execute(CREATE_USERS_TABLE_DDL_SQL);
                logger.info("Table created!");
            } catch (Exception ex) {
                logger.warning(ex.getMessage());
                ex.printStackTrace();
                return;
            }
        }
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        System.out.println(entityManager.find(User.class, user.getId()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
