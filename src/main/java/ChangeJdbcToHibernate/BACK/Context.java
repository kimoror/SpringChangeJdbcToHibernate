package ChangeJdbcToHibernate.BACK;

import org.springframework.beans.factory.annotation.Autowired;

public class Context {
    HibernateStrategy hibernateStrategy;
    public AbstractStrategy strategy;
    JDBCStrategy jdbcStrategy = new JDBCStrategy();
    boolean flag;//if flag = true then strategy == jdbc, else strategy == hibernate

    public Context(HibernateStrategy hibernateStrategy){
        strategy = jdbcStrategy;
        flag = true;
        this.hibernateStrategy = hibernateStrategy;
    }

    private void changeToHibernate(){
        strategy = hibernateStrategy;
    }

    private void changeToJdbc(){
        strategy = jdbcStrategy;
    }

    public void changeStrategy(){
        if(flag) {
            this.changeToHibernate();
            flag = false;
        }
        else {
            this.changeToJdbc();
            flag = true;
        }
    }
}
