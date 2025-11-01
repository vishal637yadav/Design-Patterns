package code.dp.behavioral.state.document;

public class ArchivedState extends DocumentState{
    public ArchivedState() {
        super("ARCHIVED");
    }

    @Override
    public void edit(Document document) {
        System.out.println("📝 Restoring document from ARCHIVE to DRAFT");
        logStateChange("ARCHIVED", "DRAFT");
        document.setState(new DraftState());
    }

    @Override
    public void review(Document document) {
        System.out.println("❌ Cannot review archived document");
    }

    @Override
    public void publish(Document document) {
        System.out.println("❌ Cannot publish archived document");
    }

    @Override
    public void archive(Document document) {
        System.out.println("ℹ️  Document is already ARCHIVED");
    }

}
