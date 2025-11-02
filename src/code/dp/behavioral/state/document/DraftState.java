package code.dp.behavioral.state.document;

public class DraftState extends DocumentState {

    public DraftState() {
        super("DRAFT");
    }

    @Override
    public void switchToDraftState(DocumentContext documentContext) {
        System.out.println("✏️  Editing documentContext in DRAFT state");
        documentContext.setContent(documentContext.getContent() + " [Edited]");
        System.out.println("Content updated: " + documentContext.getContent());
    }

    @Override
    public void switchToReviewState(DocumentContext documentContext) {
        System.out.println("📋 Sending documentContext for REVIEW");
        logStateChange("DRAFT", "REVIEW");
        documentContext.setState(new ReviewState());
    }

    @Override
    public void switchToPublishState(DocumentContext documentContext) {
        System.out.println("❌ Cannot publish directly from DRAFT. Must review first.");
        throw new IllegalStateException("Cannot publish directly from DRAFT");
    }

    @Override
    public void switchToArchiveState(DocumentContext documentContext) {
        System.out.println("🗄️  Archiving DRAFT documentContext");
        logStateChange("DRAFT", "ARCHIVED");
        documentContext.setState(new ArchivedState());
    }

}