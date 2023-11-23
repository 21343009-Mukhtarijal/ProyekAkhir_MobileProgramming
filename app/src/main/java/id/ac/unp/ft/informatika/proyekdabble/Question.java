package id.ac.unp.ft.informatika.proyekdabble;

public class Question {
    private int id;
    private String title;
    private String description;

    // Constructor
    public Question(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getter untuk ID
    public int getId() {
        return id;
    }

    // Getter untuk judul pertanyaan
    public String getTitle() {
        return title;
    }

    // Getter untuk deskripsi pertanyaan
    public String getDescription() {
        return description;
    }
}