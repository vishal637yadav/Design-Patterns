package code.dp.behavioral.state.document;

public class ArchivedState extends DocumentState {
    public ArchivedState() {
        super("ARCHIVED");
    }

    @Override
    public void switchToDraftState(DocumentContext documentContext) {
        System.out.println("📝 Restoring documentContext from ARCHIVE to DRAFT");
        logStateChange("ARCHIVED", "DRAFT");
        documentContext.setState(new DraftState());
    }

    @Override
    public void switchToReviewState(DocumentContext documentContext) {
        System.out.println("❌ Cannot review archived documentContext");
        throw new IllegalStateException("Cannot review Archived documentContext");
    }

    @Override
    public void switchToPublishState(DocumentContext documentContext) {
        System.out.println("❌ Cannot publish archived documentContext");
        throw new IllegalStateException("Cannot publish Archived documentContext");
    }

    @Override
    public void switchToArchiveState(DocumentContext documentContext) {
        System.out.println("ℹ️  DocumentContext is already ARCHIVED");
        throw new IllegalStateException("Cannot archive already Archived documentContext");
    }

}
