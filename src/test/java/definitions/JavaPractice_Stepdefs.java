package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class JavaPractice_Stepdefs {
    private final double cm = 30.48;
    private final double liter = 3.7854;

    @Given("I convert {int} foot to centimeters")
    public void iConvertFootToCentimeters(int unit) {
        System.out.println(footToCm(unit,cm));
    }

public double footToCm (int foot, double cm){
    double result = foot * liter;
    return result;
}

    @And("I convert {int} US gallon to liters")
    public void iConvertUSGallonToLiters(int unit) {
        System.out.println(gallonToLiter(unit,liter));
    }
    public double gallonToLiter (int gallon, double liter){
        double result = gallon * liter;
        return result;
    }

    @And("I convert {int} Celsius to Fahrenheit")
    public void iConvertCelsiusToFahrenheit(int unit) {
        celsiusToFahrenheit(unit);
    }
    //(Formula C to F: (0°C × 9/5) + 32 = 32°F)
    public int celsiusToFahrenheit (int celsius){
        int result = (celsius * 9/5) + 32;
        return result;
    }

    @And("I check if number {int} is odd or even")
    public void iCheckIfNumberIsOddOrEven(int num) {
        isEven(num);
    }
    public void isEven (int num){
        if(num % 2 == 0) {
            System.out.println( "Number "+num+" is even");
        }
        else{
            System.out.println("Number "+num+" is odd");
        }
    }
    /*
    Grade	Percentage
    A	90–100 %
    B	80–89 %
    C	70–79 %
    D	60–69 %
    F	≤59 %
            */
    @Given("I got {int} percent on my test")
    public void iGotPercentOnMyTest(int percent) {
        getTestResult(percent);
    }
    public void getTestResult(int percent){
        if(percent >= 90 && percent <=100){
            System.out.println("You passed with Grade A");
        }
        else if(percent >= 80 && percent <=89){
            System.out.println("You passed with Grade B");
        }
        else if(percent >= 70 && percent <=79){
            System.out.println("You passed with Grade C");
        }
        else if(percent >= 60 && percent <=69){
            System.out.println("You passed with Grade D");
        }
        else if(percent <=59){
            System.out.println("You passed with Grade D");
        }
        else {
            System.out.println("invalid percentage");
        }
    }


    /*
    #4. Use switch to calculate and print the cost of the following products:
#“apples”, “cherries”, “plums”, “grapefruit”, “oranges”.
#Assign price per pound for every product as double.
#
#Expected result:
#Cost of grapefruit = $ 6.0
#or
#This product is unavailable.
     */
    @Given("I find the cost of {int} pounds of {string}")
    public void iFindTheCostOfPoundsOf(int pounds, String fruitType) {
        getCost(pounds,fruitType);
    }
    public void getCost(int pounds, String fruit){
        double appleCost = 3.01;
        double cherryCost = 4.02;
        double plumCost = 2.03;
        double grapefruitCost = 100.3;
        double orangeCost = 7.04;

        switch (fruit){
            case "apples":
                System.out.println("The cost of " +fruit+" = $ "+ pounds * appleCost);
                break;
            case "cherries":
                System.out.println("The cost of " +fruit+" = $ "+pounds * cherryCost);
                break;
            case "plums":
                System.out.println("The cost of " +fruit+" = $ "+pounds * plumCost);
                break;
            case "grapefruit":
                System.out.println("The cost of " +fruit+" = $ "+pounds * grapefruitCost);
                break;
            case "oranges":
                System.out.println("The cost of " +fruit+" = $ "+pounds * orangeCost);
                break;
            default:
                System.out.println("Sorry, this product is unavailable.");

        }
    }

    @Given("I print out all elements in the array")
    public void iPrintOutAllElementsInTheArray() {
        String[] week = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        loopDays(week);
    }
    public void loopDays(String [] strArr){
        for(int i =0; i<strArr.length; i++){
            System.out.println(strArr[i]);
        }
    }
}
