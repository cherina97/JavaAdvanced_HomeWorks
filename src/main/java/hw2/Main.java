package hw2;

import org.apache.log4j.PropertyConfigurator;

public class Main {
    private static OrderLogic logic;

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/log4j.properties");

        logic = new OrderLogic();
        logic.doOrder();

    }
}
