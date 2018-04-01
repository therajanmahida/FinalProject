package VO;

import java.util.LinkedList;

public class StateCity {
    String stateName;
    LinkedList<String> cityName;

    public StateCity(){
        this.stateName = new String();
        this.cityName = new LinkedList<>();
    }



    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public LinkedList<String> getCityName() {
        return cityName;
    }

    public void setCityName(LinkedList<String> cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "StateCity{" +
                "stateName='" + stateName + '\'' +
                ", cityName=" + cityName +
                '}';
    }
}
