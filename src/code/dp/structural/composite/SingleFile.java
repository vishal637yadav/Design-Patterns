package code.dp.structural.composite;

public class SingleFile implements File {

    private final String fileName;

    public SingleFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print() {
        System.out.println(fileName);
    }
}
