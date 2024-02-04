package code.dp.behavioral.interpreter.expr;

import code.dp.behavioral.interpreter.Employee;

public class AndExpression implements Expression {

    protected Expression left;
    protected Expression right;

    public AndExpression(Expression left, Expression right) {
        super();
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Employee context) {
        return left.interpret(context) && right.interpret(context);
    }

    @Override
    public String toString() {
        return "AndExpression [left=" + left + ", right=" + right + "]";
    }

}
