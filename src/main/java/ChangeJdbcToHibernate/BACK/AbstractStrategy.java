package ChangeJdbcToHibernate.BACK;

import ChangeJdbcToHibernate.MODEL.entity.Outcomes;

import java.util.ArrayList;
//TODO Сделать контекст, нужно туда будет передавать ссылку на репозиторий, он должен, содержать настройки (в string для jdbc(url и т.д.))
public abstract class AbstractStrategy {
    public abstract boolean refresh(ArrayList date);

    public abstract boolean addToDataBase(Outcomes outcomes);


}
