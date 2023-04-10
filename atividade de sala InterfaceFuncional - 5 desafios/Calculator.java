import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private double firstValue;
    private double secondValue;

    private List<CalculadoraOperation> operations = new ArrayList<>();

    private CalculadoraOperation add = (d1, d2) -> d1 + d2;
    private CalculadoraOperation sub = (d1, d2) -> d1 - d2;
    private CalculadoraOperation div = (d1, d2) -> d1 / d2;
    private CalculadoraOperation mult = (d1, d2) -> d1 * d2;

    public Calculator() {
        this.operations.add(this.add);
        this.operations.add(this.sub);
        this.operations.add(this.div);
        this.operations.add(this.mult);
    }

    void testCalculatorOperations() {
        this.operations.forEach(operation -> System.out.println(operation.operate(this.firstValue, this.secondValue)));
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public List<CalculadoraOperation> getOperations() {
        return operations;
    }

    public CalculadoraOperation getAdd() {
        return add;
    }

    public CalculadoraOperation getSub() {
        return sub;
    }

    public CalculadoraOperation getDiv() {
        return div;
    }

    public CalculadoraOperation getMult() {
        return mult;
    }

}
