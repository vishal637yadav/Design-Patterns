package code.dp.behavioral.state.document;

public class PublishedState extends DocumentState {
    public PublishedState() {
        super("PUBLISHED");
    }

    @Override
    public void switchToDraftState(DocumentContext documentContext) {
        System.out.println("📝 Creating new version - Moving to DRAFT");
        documentContext.incrementVersion();
        logStateChange("PUBLISHED", "DRAFT");
        documentContext.setState(new DraftState());
    }

    @Override
    public void switchToReviewState(DocumentContext documentContext) {
        System.out.println("❌ Published documentContext cannot be reviewed again");
        throw new IllegalStateException("Published DocumentContext Cannot be Reviewed!!");
    }

    @Override
    public void switchToPublishState(DocumentContext documentContext) {
        System.out.println("ℹ️  DocumentContext is already PUBLISHED");
    }

    @Override
    public void switchToArchiveState(DocumentContext documentContext) {
        System.out.println("🗄️  Archiving PUBLISHED documentContext");
        logStateChange("PUBLISHED", "ARCHIVED");
        documentContext.setState(new ArchivedState());
    }

}