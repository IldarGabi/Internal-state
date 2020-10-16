package newRadio;

public class Radio {
    private long currentRadioStationNumber;
    private long currentVolume;
    private long maxRadioStation;
    private long minRadioStation;
    private long maxVolume;
    private long minVolume;

    public Radio(long currentRadioStationNumber, long currentVolume, long maxRadioStation, long minRadioStation, long maxVolume, long minVolume) {
        this.currentRadioStationNumber = currentRadioStationNumber;
        this.currentVolume = currentVolume;
        this.maxRadioStation = maxRadioStation;
        this.minRadioStation = minRadioStation;
        this.maxVolume = maxVolume;
        this.minVolume = minVolume;
    }

    public long getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setCurrentRadioStationNumber(long currentRadioStationNumber) {
        this.currentRadioStationNumber = currentRadioStationNumber;
    }

    public long getMaxRadioStation() {
        return maxRadioStation;
    }

    public void setMaxRadioStation(long maxRadioStation) {
        this.maxRadioStation = maxRadioStation;
    }

    public long getMinRadioStation() {
        return minRadioStation;
    }

    public void setMinRadioStation(long minRadioStation) {
        this.minRadioStation = minRadioStation;
    }

    public long getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(long maxVolume) {
        this.maxVolume = maxVolume;
    }

    public long getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(long minVolume) {
        this.minVolume = minVolume;
    }

    public long getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(long currentVolume) {
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