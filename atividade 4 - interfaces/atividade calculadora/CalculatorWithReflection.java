import java.lang.reflect.Method;
import java.util.HashMap;

// para implementar alguma classe funcional nova basta mapear no hashmap, na condicional do input e ter implementado a interface Calculate

public class CalculatorWithReflection {

    private double total = 0;
    private Class<?> operator = null;

    private Sum sum = new Sum();
    private Add add = new Add();
    private Sub sub = new Sub();
    private Div div = new Div();
    private Mult mult = new Mult();

    HashMap<String, Class<?>> map = new HashMap<>() {
        {
            put("+", add.getClass());
            put("-", sub.getClass());
            put("/", div.getClass());
            put("*", mult.getClass());
        }
    };

    HashMap<Class<?>, Object> map2 = new HashMap<>() {
        {
            put(add.getClass(), add);
            put(sub.getClass(), sub);
            put(div.getClass(), div);
            put(mult.getClass(), mult);
        }
    };

    void pressButtonHandler(String keyPressed) throws Exception {

        // handler dos inputs

        if (keyPressed.equals("=")) {

            sum.DisplaySum(total);

        } else if (keyPressed.equals("+") || keyPressed.equals("-") || keyPressed.equals("/")
                || keyPressed.equals("*")) {

            this.operator = map.get(keyPressed);

        } else {

            try {

                if (this.operator == null) {

                    this.total = Double.parseDouble(keyPressed);

                } else {

                    // utilizando reflection para invocar metodos da interface Calculate
                    Method methodCall = Calculate.class.getDeclaredMethod("operate",
                            new Class[] { double.class, double.class });

                    // faz a operação operate da classe definida em operator
                    Object value = methodCall.invoke(map2.get(this.operator), total, Double.parseDouble(keyPressed));

                    // resultado da operação
                    this.total = (double) value;

                    // reseta a operação
                    this.operator = null;

                }

            } catch (NumberFormatException e) {

                System.out.println("Botão digitado não valido");

            }
        }

    }

}
