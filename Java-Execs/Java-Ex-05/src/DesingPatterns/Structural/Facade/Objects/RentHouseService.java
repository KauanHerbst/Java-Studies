package DesingPatterns.Structural.Facade.Objects;

public class RentHouseService implements  IRentHouseService{

    @Override
    public void rentAHouse() {
        if(searchHouse() && payHouse() && getHouseKey()){
            System.out.println("Rented house");
        }else {
            System.out.println("House not rented");
        }

    }

    private Boolean searchHouse() {
        return true;
    }

    private Boolean payHouse(){
        return true;
    }

    private Boolean getHouseKey(){
        return true;
    }
}
