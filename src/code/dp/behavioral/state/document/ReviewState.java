package code.dp.behavioral.state.document;

public class ReviewState extends DocumentState {
    public ReviewState() {
        super("REVIEW");
    }

    @Override
    public void switchToDraftState(DocumentContext documentContext) {
        System.out.println("📝 DocumentContext sent back to DRAFT for editing");
        logStateChange("REVIEW", "DRAFT");
        documentContext.setState(new DraftState());
    }

    @Override
    public void switchToReviewState(DocumentContext documentContext) {
        System.out.println("🔍 DocumentContext is already under REVIEW");
        throw new IllegalStateException("DocumentContext is already in REVIEW state");
    }

    @Override
    public void switchToPublishState(DocumentContext documentContext) {
        System.out.println("✅ Review approved - Publishing documentContext");
        logStateChange("REVIEW", "PUBLISHED");
        documentContext.setState(new PublishedState());
    }

    @Override
    public void switchToArchiveState(DocumentContext documentContext) {
        System.out.println("🗄️  Archiving documentContext from REVIEW");
        logStateChange("REVIEW", "ARCHIVED");
        documentContext.setState(new ArchivedState());
    }

}
