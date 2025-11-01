package code.dp.behavioral.state.document;

public class ReviewState extends DocumentState{
    public ReviewState() {
        super("REVIEW");
    }

    @Override
    public void edit(Document document) {
        System.out.println("📝 Document sent back to DRAFT for editing");
        logStateChange("REVIEW", "DRAFT");
        document.setState(new DraftState());
    }

    @Override
    public void review(Document document) {
        System.out.println("🔍 Document is already under REVIEW");
    }

    @Override
    public void publish(Document document) {
        System.out.println("✅ Review approved - Publishing document");
        logStateChange("REVIEW", "PUBLISHED");
        document.setState(new PublishedState());
    }

    @Override
    public void archive(Document document) {
        System.out.println("🗄️  Archiving document from REVIEW");
        logStateChange("REVIEW", "ARCHIVED");
        document.setState(new ArchivedState());
    }
}
