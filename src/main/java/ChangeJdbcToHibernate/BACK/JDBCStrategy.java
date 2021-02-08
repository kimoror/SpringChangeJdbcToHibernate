package ChangeJdbcToHibernate.BACK;

import ChangeJdbcToHibernate.MODEL.entity.Outcomes;

import java.sql.*;
import java.util.ArrayList;

public class JDBCStrategy extends AbstractStrategy {

    //Работаю с таблицей Outcomes
    @Override
    public boolean refresh(ArrayList data) {
        data.clear();
        try{
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                    "postgres",
                    "plami");
            Statement outcomesDb = c.createStatement();
            ResultSet resultOutcomesDb = outcomesDb.executeQuery("select ship, battle, result from Outcomes");
            while(resultOutcomesDb.next()){
                    data.add(new Outcomes(
                            resultOutcomesDb.getString("ship"),
                            resultOutcomesDb.getString("battle"),
                            resultOutcomesDb.getString("result")
                            ));
            }
            c.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean addToDataBase(Outcomes outcomes) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                    "postgres",
                    "plami");
            PreparedStatement stLog = c.prepareStatement("insert into Outcomes (ship, battle, result) values (?,?,?);");
            stLog.setString(1, outcomes.getShip());
            stLog.setString(2, outcomes.getBattle());
            stLog.setString(3, outcomes.getResult());
            //TODO try annother way: executeUpdate method
            stLog.execute();
            c.close();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
