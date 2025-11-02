package code.dp.behavioral.state.document;

public abstract class DocumentState implements IDocumentState {
    protected final String stateName;

    protected DocumentState(String stateName) {
        this.stateName = stateName;
    }

    public final String getDocumentState() {
        return stateName;
    }

    protected void logStateChange(String from, String to) {
        System.out.println("DocumentContext State Changed: " + from + " --→> " + to);
    }
}
