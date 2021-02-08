package ChangeJdbcToHibernate.MODEL.serivce.impl;

import ChangeJdbcToHibernate.MODEL.entity.Outcomes;
import ChangeJdbcToHibernate.MODEL.repository.OutcomesRepository;
import ChangeJdbcToHibernate.MODEL.serivce.OutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class OutcomesServiceImpl implements OutcomesService {
    @Autowired
    OutcomesRepository outcomesRepository;

    @Override
    public Outcomes save(Outcomes outcomes) {
        return outcomesRepository.saveAndFlush(outcomes);
    }

    @Override
    public ArrayList<Outcomes> getAll() {
        ArrayList<Outcomes> outcomes = new ArrayList<Outcomes>();
        for(Outcomes o: outcomesRepository.findAll()){
            outcomes.add(o);
        }
        return outcomes;
    }
}
