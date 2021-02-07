package ChangeJdbcToHibernate.BACK;

import ChangeJdbcToHibernate.MODEL.entity.Outcomes;
import ChangeJdbcToHibernate.MODEL.serivce.impl.OutcomesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HibernateStrategy extends AbstractStrategy{
    @Autowired
    OutcomesServiceImpl outcomesService;

    @Override
    public boolean refresh(ArrayList date) {
        date.clear();
        for(Outcomes o: outcomesService.getAll()){
            date.add(o);
        }
        return true;
    }

    @Override
    public boolean addToDataBase(Outcomes outcomes) {
        outcomesService.save(outcomes);
        return true;
    }
}
