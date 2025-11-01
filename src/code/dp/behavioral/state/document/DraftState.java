package code.dp.behavioral.state.document;

public class DraftState extends DocumentState{

    public DraftState() {
        super("DRAFT");
    }

    @Override
    public void edit(Document document) {
        System.out.println("✏️  Editing document in DRAFT state");
        document.setContent(document.getContent() + " [Edited]");
        System.out.println("Content updated: " + document.getContent());
    }

    @Override
    public void review(Document document) {
        System.out.println("📋 Sending document for REVIEW");
        logStateChange("DRAFT", "REVIEW");
        document.setState(new ReviewState());
    }

    @Override
    public void publish(Document document) {
        System.out.println("❌ Cannot publish directly from DRAFT. Must review first.");
    }

    @Override
    public void archive(Document document) {
        System.out.println("🗄️  Archiving DRAFT document");
        logStateChange("DRAFT", "ARCHIVED");
        document.setState(new ArchivedState());
    }

}
