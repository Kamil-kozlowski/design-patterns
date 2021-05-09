import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        CompoundLogicalOperation operations = new CompoundLogicalOperation(
                Operator.AND,
                Arrays.asList(
                        new CompoundLogicalOperation(
                                Operator.OR,
                                Arrays.asList(
                                        new SimpleLogicalOperation(1 == 1),
                                        new SimpleLogicalOperation(false)
                                )
                        ),
                        new SimpleLogicalOperation(true)
                )
        );

        boolean evaluationResult = operations.evaluate();
        System.out.println("This should be true: " + evaluationResult);
    }
}

interface LogicalOperation {
    boolean evaluate();
}

class SimpleLogicalOperation implements LogicalOperation {
    private final boolean value;

    public SimpleLogicalOperation(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }
}

class CompoundLogicalOperation implements LogicalOperation {
    private final Operator operator;
    private final List<LogicalOperation> logicalOperations; // enables tree structure

    public CompoundLogicalOperation(Operator operator, List<LogicalOperation> logicalOperations) {
        this.operator = operator;
        this.logicalOperations = logicalOperations != null ? logicalOperations : new ArrayList<>();
    }

    @Override
    public boolean evaluate() {
        switch (operator) {
            case OR:
                return logicalOperations.stream().anyMatch(LogicalOperation::evaluate);
            case AND:
                return logicalOperations.stream().allMatch(LogicalOperation::evaluate);
        }
        return false; //fallback
    }
}

enum Operator {
    AND, OR
}
