package even_forest;

import java.io.IOException;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void main(String[] args) throws IOException {
        solve(10.25, 17, 5);
    }


    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here
        double finalCost = meal_cost;
        finalCost += mealCost(meal_cost, tip_percent); //Tip Cost
        finalCost += mealCost(meal_cost, tax_percent); // Tax Cost
        System.out.println(Math.round(finalCost));
    }

    private static double mealCost(double cost, int percent) {
        return cost * percent / 100;
    }

}