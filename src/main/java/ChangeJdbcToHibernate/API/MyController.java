package ChangeJdbcToHibernate.API;

import ChangeJdbcToHibernate.BACK.Context;
import ChangeJdbcToHibernate.BACK.HibernateStrategy;
import ChangeJdbcToHibernate.BACK.JDBCStrategy;
import ChangeJdbcToHibernate.MODEL.entity.Outcomes;
import ChangeJdbcToHibernate.BACK.AbstractStrategy;
import ChangeJdbcToHibernate.MODEL.serivce.impl.OutcomesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MyController {

    Context context;
    ArrayList<Outcomes> data;

    public MyController(@Autowired HibernateStrategy hib) {
        data = new ArrayList<>();
        context = new Context(hib);
    }

        @RequestMapping(value = "/records", method = RequestMethod.POST)
    public String addDataToDb(@RequestBody() Outcomes outcomes){
        context.strategy.addToDataBase(outcomes);
        return "OK";
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ArrayList getData(){
        context.strategy.refresh(data);
        return data;
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String changeStrategy(){
        context.changeStrategy();
        return "Change completed";
    }
}
