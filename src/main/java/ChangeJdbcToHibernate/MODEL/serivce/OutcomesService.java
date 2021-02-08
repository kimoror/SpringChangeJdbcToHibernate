package ChangeJdbcToHibernate.MODEL.serivce;

import ChangeJdbcToHibernate.MODEL.entity.Outcomes;

import java.util.ArrayList;

public interface OutcomesService {
   public Outcomes save(Outcomes outcomes);

   public ArrayList<Outcomes> getAll();
}
