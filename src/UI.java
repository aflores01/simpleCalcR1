public class UI {

    public String addInput(String operation, String newValue) {
        if (operation.contains("=") || operation.contains("+") || operation.contains("*") || operation.contains("-") || operation.contains("/")) {
            return newValue;
        }
        else {
            return operation.concat(newValue);
        }
    }
}
