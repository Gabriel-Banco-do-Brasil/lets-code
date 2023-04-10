public class CalculatorRefactored {
    private double total = 0;
    private Calculate operator = null;

    void pressButtonHandler(String keyPressed) throws Exception {

        // handler dos inputs

        if (keyPressed.equals("=")) {
            Sum sum = new Sum();
            sum.DisplaySum(total);

        } else if (keyPressed.equals("+")) {
            this.operator = new Add();
        } else if (keyPressed.equals("-")) {
            this.operator = new Sub();
        } else if (keyPressed.equals("/")) {
            this.operator = new Div();
        } else if (keyPressed.equals("*")) {
            this.operator = new Mult();

        } else {

            try {

                if (this.operator == null) {

                    this.total = Double.parseDouble(keyPressed);

                } else {

                    // resultado da operação
                    this.total = operator.operate(total, Double.parseDouble(keyPressed));

                    // reseta a operação
                    this.operator = null;

                }

            } catch (NumberFormatException e) {

                System.out.println("Botão digitado não valido");

            }
        }

    }
}
