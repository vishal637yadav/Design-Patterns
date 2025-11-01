package code.dp.behavioral.state.document;

public abstract class DocumentState {
    protected String stateName;

    public DocumentState(String stateName) {
        this.stateName = stateName;
    }

    public abstract void edit(Document document);
    public abstract void review(Document document);
    public abstract void publish(Document document);
    public abstract void archive(Document document);

    public String getStateName() {
        return stateName;
    }

    protected void logStateChange(String from, String to) {
        System.out.println("Document state changed: " + from + " → " + to);
    }
}
