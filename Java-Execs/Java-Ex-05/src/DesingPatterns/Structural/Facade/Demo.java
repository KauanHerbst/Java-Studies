package DesingPatterns.Structural.Facade;

import DesingPatterns.Structural.Facade.Objects.IRentHouseService;
import DesingPatterns.Structural.Facade.Objects.RentHouseService;

public class Demo {
    public static void main(String[] args) {
        IRentHouseService houseService = new RentHouseService();
        houseService.rentAHouse();
    }
}
