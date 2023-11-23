package id.ac.unp.ft.informatika.proyekdabble;

public class Answer {
    private int id;
    private String content;
    private String author;

    // Constructor
    public Answer(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    // Getter untuk ID
    public int getId() {
        return id;
    }

    // Getter untuk konten jawaban
    public String getContent() {
        return content;
    }

    // Getter untuk penulis jawaban
    public String getAuthor() {
        return author;
    }
}