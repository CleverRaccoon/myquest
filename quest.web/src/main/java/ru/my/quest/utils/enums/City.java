package ru.my.quest.utils.enums;

/**
 * Created by Maksim Zagorodskiy on 6/18/2016.
 */

public enum  City {

    SAINT_PETERSBURG(1), UNKNOWN(0);

    int index;
    City(int index){
        this.index = index;
    }
    City getByIndex(Integer index){
        if(index != null && index != 0){
            for(City city :  City.values()){
                if(city.getIndex() == index ){
                    return city;
                }
            }
            return UNKNOWN;
        }else {
            return UNKNOWN;
        }
    }

    int getIndex(){
        return index;
    }

}
