package model;

import static model.utilityModel.getRandomNumber;
import static model.utilityModel.isInValidName;
import static model.number.BASE_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class racingGameModel {
    public ArrayList<racingCarInfo> racingCarInfos;
    public racingGameModel(String[] carNamesArray) {
        racingCarInfos = new ArrayList<racingCarInfo>();
        int idx = 0;
        for(String name : carNamesArray){
            isInValidName(name);
            racingCarInfo carInfo = new racingCarInfo(name, idx);
            racingCarInfos.add(carInfo);
            idx++;
        }
    }
    public void updateRaceStatus(){
        for(racingCarInfo carInfo : racingCarInfos){
            int randomNumber = getRandomNumber();
            if(randomNumber >= BASE_NUMBER){
                carInfo.moveCount+=1;
            }
        }
    }
    public List<String> getWinnerNames() {
        int max = findMaxCountOfCarInfos();
        List<String> winnerNames = new ArrayList<>();

        for (racingCarInfo carInfo : racingCarInfos) {
            addWinnerIfMaxCount(winnerNames, carInfo, max);
        }

        return winnerNames;
    }
    private void addWinnerIfMaxCount(List<String> winnerNames, racingCarInfo carInfo, int max) {
        if (carInfo.moveCount == max) {
            winnerNames.add(carInfo.name);
        }
    }
    private int findMaxCountOfCarInfos(){
        int maxCount = 0;
        for(racingCarInfo carInfo : racingCarInfos){
            maxCount=Math.max(maxCount,carInfo.moveCount);
        }
        return maxCount;
    }
}

