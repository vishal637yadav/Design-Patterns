package code.dp.behavioral.interpreter.expr;

import code.dp.behavioral.interpreter.Employee;

public interface Expression {

    boolean interpret(Employee context);

}
