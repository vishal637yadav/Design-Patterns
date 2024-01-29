package code.dp.structural.composite;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        File file1 = new SingleFile("file1.txt");
        File file2 = new SingleFile("file2.txt");
        File file3 = new SingleFile("file3.txt");
        File file4 = new SingleFile("file4.txt");
        File file5 = new SingleFile("file5.txt");

        Directory directory1 = new Directory("directory1", List.of(file3, file4));
        Directory directory2 = new Directory("directory2", List.of(file5));
        Directory data = new Directory("data", List.of(directory1, file1, file2, directory2));

        data.print();

    }
}
