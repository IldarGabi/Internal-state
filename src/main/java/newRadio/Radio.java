package newRadio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Radio {
    private long currentRadioStationNumber;
    private long maxRadioStation = 10;
    private long minRadioStation = 0;
    private long maxVolume = 100;
    private long minVolume = 0;
    private long currentVolume;

    public Radio(long currentRadioStationNumber, long currentVolume) {
        this.currentRadioStationNumber = currentRadioStationNumber;
        this.currentVolume = currentVolume;
    }

    // change stations
    public void changeOnNextRadioStations() {
        if (currentRadioStationNumber == maxRadioStation) {
            currentRadioStationNumber = minRadioStation;
        } else currentRadioStationNumber++;
        if (currentRadioStationNumber > maxRadioStation) {
            currentRadioStationNumber = maxRadioStation;
        }
    }

    public void changeOnPrevRadioStations() {
        if (currentRadioStationNumber == minRadioStation) {
            currentRadioStationNumber = maxRadioStation;
        } else currentRadioStationNumber--;
        if (currentRadioStationNumber < minRadioStation) {
            currentRadioStationNumber = minRadioStation;
        }
    }

    // change volume

    public void changeVolumeIncrease() {
        if (currentVolume >= maxVolume) {
            currentVolume = maxVolume;
        } else currentVolume++;
    }

    public void changeVolumeDecrease() {
        if (currentVolume <= minVolume) {
            currentVolume = minVolume;
        } else currentVolume--;
    }
}