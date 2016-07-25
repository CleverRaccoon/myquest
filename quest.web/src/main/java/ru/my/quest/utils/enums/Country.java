package ru.my.quest.utils.enums;

/**
 * Created by Maksim Zagorodskiy on 6/18/2016.
 */
public enum Country {

    RUSSIA(1), UNKNOWN(0);

    int index;
    Country(int index){
        this.index = index;
    }
    Country getByIndex(Integer index){
        if(index != null && index != 0){
            for(Country country :  Country.values()){
                if(country.getIndex() == index ){
                    return country;
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
