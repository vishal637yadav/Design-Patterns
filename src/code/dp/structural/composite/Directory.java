package code.dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements File {

    private final String directoryName;
    private final List<File> children;

    public Directory(String directoryName, List<File> children) {
        this.directoryName = directoryName;
        this.children = new ArrayList<>(children);
    }

    public void addChild(File file) {
        this.children.add(file);
    }

    public void removeChild(File file) {
        this.children.add(file);
    }

    public File getChild(int position) {
        if (position < 0 || position >= children.size()) {
            throw new RuntimeException("Invalid position " + position);
        }
        return children.get(position);
    }

    private int getTotalNumberOfChildren() {
        return children.size();
    }

    @Override
    public void print() {
        System.out.println("Printing the contents of the directory - " + directoryName);
        children.forEach(File::print);
        System.out.println("Done printing the contents of the directory - " + directoryName);
    }
}
