package code.dp.behavioral.state.document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Document {

    private String id;
    private String title;
    private String content;
    private int version;
    private DocumentState currentState;
    private List<String> stateHistory;
    private LocalDateTime lastModified;

    public Document(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.version = 1;
        this.currentState = new DraftState();
        this.stateHistory = new ArrayList<>();
        this.lastModified = LocalDateTime.now();

        stateHistory.add("DRAFT - " + lastModified);
    }

    // State operations
    public void edit() {
        currentState.edit(this);
        updateLastModified();
    }

    public void review() {
        currentState.review(this);
        updateLastModified();
    }

    public void publish() {
        currentState.publish(this);
        updateLastModified();
    }

    public void archive() {
        currentState.archive(this);
        updateLastModified();
    }

    // State management
    public void setState(DocumentState state) {
        this.currentState = state;
        stateHistory.add(state.getStateName() + " - " + LocalDateTime.now());
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getVersion() { return version; }
    public void incrementVersion() { this.version++; }

    public DocumentState getCurrentState() { return currentState; }
    public String getCurrentStateName() { return currentState.getStateName(); }

    public List<String> getStateHistory() { return new ArrayList<>(stateHistory); }
    public LocalDateTime getLastModified() { return lastModified; }

    private void updateLastModified() {
        this.lastModified = LocalDateTime.now();
    }

    // Display methods
    public void displayInfo() {
        System.out.println("\n📄 DOCUMENT INFORMATION");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Version: " + version);
        System.out.println("Current State: " + getCurrentStateName());
        System.out.println("Content: " + content);
        System.out.println("Last Modified: " + lastModified);
    }

    public void displayStateHistory() {
        System.out.println("\n📊 STATE HISTORY");
        for (int i = 0; i < stateHistory.size(); i++) {
            System.out.println((i + 1) + ". " + stateHistory.get(i));
        }
    }

}
