package code.dp.behavioral.state.document;

public class PublishedState extends DocumentState{
    public PublishedState() {
        super("PUBLISHED");
    }

    @Override
    public void edit(Document document) {
        System.out.println("📝 Creating new version - Moving to DRAFT");
        document.incrementVersion();
        logStateChange("PUBLISHED", "DRAFT");
        document.setState(new DraftState());
    }

    @Override
    public void review(Document document) {
        System.out.println("❌ Published document cannot be reviewed again");
    }

    @Override
    public void publish(Document document) {
        System.out.println("ℹ️  Document is already PUBLISHED");
    }

    @Override
    public void archive(Document document) {
        System.out.println("🗄️  Archiving PUBLISHED document");
        logStateChange("PUBLISHED", "ARCHIVED");
        document.setState(new ArchivedState());
    }
}
