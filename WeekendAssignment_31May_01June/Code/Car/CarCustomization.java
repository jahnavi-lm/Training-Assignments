package WeekendAssignment_31May_01June.Car;
import java.util.*;

public class CarCustomization {
    public static String getInput(Scanner sc, String prompt, List<String> validOptions ){
        String input;
        while(true){
            System.out.print(prompt);
            input = sc.nextLine().trim();

            if(validOptions.contains(input)){
                return input;
            }
            else{
                System.out.println("Invalid input, Please choose one in the following options: "+validOptions);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CarData cd = new CarData();

        List<String> manufacturers = new ArrayList<>();
        manufacturers.add("Mahindra");
        manufacturers.add("Tata");
        manufacturers.add("Maruti");
        List<String> mahindraModels = new ArrayList<>();
        mahindraModels.add("Scorpio");
        mahindraModels.add("Thar");
        mahindraModels.add("Scorpio N");
        mahindraModels.add("XUV 700");
        List<String> tataModels = new ArrayList<>();
        tataModels.add("Nexon");
        tataModels.add("Harrier");
        tataModels.add("Safari");
        List<String> marutiModels = new ArrayList<>();
        marutiModels.add("Swift");
        marutiModels.add("Baleno");
        marutiModels.add("Vitara Brezza");
        List<String> transmissionOptions = new ArrayList<>();
        transmissionOptions.add("Manual");
        transmissionOptions.add("Automatic");
        List<String> fuelTypes = new ArrayList<>();
        fuelTypes.add("Diesel");
        fuelTypes.add("Petrol");
        fuelTypes.add("CNG");
        List<String> colors = new ArrayList<>();
        colors.add("Silver");
        colors.add("Blue");
        colors.add("Yellow");
        List<String> locations = new ArrayList<>();
        locations.add("Delhi");
        locations.add("Bangalore");
        locations.add("Hyderabad");
        locations.add("Chennai");

        String manufacturer = getInput(sc, "Choose manufacturer" +manufacturers+ ": ", manufacturers);
        cd.setManufacturer(manufacturer);

        List<String> models;
        if(manufacturer.equals("Mahindra")){
            models = mahindraModels;
        }
        else if(manufacturer.equals("Tata")){
            models = tataModels;
        }
        else{
            models = marutiModels;
        }

        String model = getInput(sc, "Choose model of " + manufacturer + " " +models+ ": ", models);
        cd.setModel(model);
        String transmission = getInput(sc, "Choose transmission" +transmissionOptions+ ": ", transmissionOptions);
        cd.setTransmission(transmission);
        String fuelType = getInput(sc, "Choose fuel type" +fuelTypes+": ", fuelTypes);
        cd.setfuelType(fuelType);
        String color = getInput(sc, "Choose color" +colors+": ", colors);
        cd.setColor(color);
        String location = getInput(sc, "Choose location " +locations+ ": ", locations);
        cd.setLocation(location);
        cd.carSelections();
        sc.close();
    }
}
