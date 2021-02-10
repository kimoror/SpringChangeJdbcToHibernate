package ChangeJdbcToHibernate.MODEL.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Outcomes")
public class Outcomes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @JsonProperty("ship")
    private String ship;
    @JsonProperty("battle")
    private String battle;
    @JsonProperty("result")
    private String result;

    public Outcomes(){};

    @JsonCreator
    public Outcomes(@JsonProperty("ship") String ship,
                    @JsonProperty("battle") String battle,
                    @JsonProperty("result") String result) {
        this.ship = ship;
        this.battle = battle;
        this.result = result;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getBattle() {
        return battle;
    }

    public void setBattle(String battle) {
        this.battle = battle;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
