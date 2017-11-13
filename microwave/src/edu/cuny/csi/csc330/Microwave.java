package edu.cuny.csi.csc330.lab4;

public class Microwave {
    private long deviceSerialNumber;
    private double temperature;
    private double power;
    private boolean powerState;
    private String options[];
    private String type;
    private int selectedOption;
    private int timer;

    /**
     * Microwave constructor, set the data members to it's set default values
     */
    public Microwave() {
        deviceSerialNumber = 23275673;
        temperature = 0.00;
        powerState = false;
        options = new String[]{"Low", "medium", "Medium High", "Hot"};
        selectedOption = 0;
        type = "Touch Pad";
        power = 1000;
        timer = 0;
    }

    /**
     * @param id
     */
        public void selectOption(int id) {
        if (id > 0 && id < 5) {
            selectedOption = id;
        }
    }

    /**
     * Set the Micowave temperature
     *
     * @param temp
     */
    public void setTemperature(double temp) {
        temperature = temp;
    }

    /**
     * Check if the Microwave is on
     *
     * @return
     */
    public boolean isOn() {
        return powerState;
    }

    /**
     * Check power state
     *
     * @return
     */
    public boolean isOff() {
        return powerState;
    }

    /**
     * To check the if the temperature is set
     *
     * @return
     */
    public boolean isTemperatureSet() {
        if (temperature > 0)
            return true;
        else return false;
    }

    /**
     * Turn on the Microwave
     */
    public void turnOn() {
        powerState = true;
    }

    /**
     * Turn off the Microwave
     */
    public void turnOff() {
        powerState = false;
    }

    /**
     * Set the temperature to Zero
     */
    public void resetTemperature() {
        temperature = 0.00;
    }

    /**
     * Increase the temperature
     *
     * @param addtemp
     */
    public void incrementTemperature(double addtemp) {
        temperature += addtemp;
    }

    /**
     * Set Timer
     *
     * @param time
     */
    public void setTimer(int time) {
        timer = time;
    }

    /**
     * Check if the timer is set
     *
     * @return
     */
    public boolean isTimerSet() {
        if (timer > 0)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        String value = "\nMicrowave Instance: [deviceSerialNumber=" + deviceSerialNumber + ", \nPowerState=" + powerState + ",\nTemperature="
                + temperature + ",\nSelectedOption=" + options[selectedOption] + ",\nType=" + type + ",\nPower=" + power
                + "\nTimer=" + timer + "]";
        return value;
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String args[]) {
        Microwave HouseMicrowave = new Microwave();
        System.out.println("House Microwave\n" + HouseMicrowave + "\n");
        System.out.print("\nTurn on the House Microwave\n");
        HouseMicrowave.turnOn();
        HouseMicrowave.setTimer(2);
        HouseMicrowave.setTemperature(100);
        System.out.println("\n\nHouseMicrowave\nSetting the Timer and the setTemperature" + HouseMicrowave + "\n");
        HouseMicrowave.selectOption(2);
        System.out.println("\n\nHouseMicrowave\nHeating up the food" + HouseMicrowave + "\n");
    }
}
