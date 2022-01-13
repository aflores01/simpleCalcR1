public class Math {

    public String operation(String firstValue, String operator, String secondValue) {
        String result = null;
        Double firstVal = Double.parseDouble(firstValue);
        Double secondVal = Double.parseDouble(secondValue);
        switch (operator) {
            case "+":
                result = String.valueOf(firstVal + secondVal);
                break;
            case "-":
                result = String.valueOf(firstVal - secondVal);
                break;
            case "*":
                result = String.valueOf(firstVal * secondVal);
                break;
            case "/":
                result = String.valueOf(firstVal / secondVal);
                break;
            default:
                result = "error!";
                break;
        }
        return result;
    }
}
