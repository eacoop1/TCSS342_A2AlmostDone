import java.io.*;
import java.util.Scanner;


public class BookReader {
    public String book;
    public MyLinkedList<String> words;

    public BookReader(String filename) throws IOException {
        readBook(filename);
        parseWords();
    }

    public void readBook(String filename) throws IOException {
        File file = new File("WarAndPeace.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        StringBuilder builder = new StringBuilder(book);
        int character = reader.read();
        while(reader.read() != -1){
            builder.append((char) character);
            character = (char) reader.read();
        }
    }

    public void parseWords(){
        StringBuilder wordBuffer = new StringBuilder(book);
        int i = 0;
        char currChar = book.charAt(i);
        while (i <= book.length()){
            if ((currChar > 47 && currChar < 58) ||
                (currChar > 64 && currChar < 91) ||
                (currChar > 96 && currChar < 123)){
                wordBuffer.append(currChar);
            } else {
                words.addAfter(wordBuffer.toString());
                wordBuffer.setLength(0);
            }
            i++;
        }
    }

}
