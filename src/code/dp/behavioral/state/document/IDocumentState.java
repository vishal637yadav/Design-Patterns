package code.dp.behavioral.state.document;

public interface IDocumentState {
    void switchToDraftState(DocumentContext documentContext);

    void switchToReviewState(DocumentContext documentContext);

    void switchToPublishState(DocumentContext documentContext);

    void switchToArchiveState(DocumentContext documentContext);

    // For logging and debugging purposes
    String getDocumentState();
}
