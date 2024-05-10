package model;

public class Book {

    private String code;
    private String title;
    private String author;
    private int yearPublish;

    public Book(String code, String title, String author, int yearPublish) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.yearPublish = yearPublish;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        Book that = (Book) obj;
        return getCode().equals(that.getCode());
    }

    @Override
    public String toString() {
        return "Book{" + "code=" + code + ", title=" + title + ", author=" + author + ", yearPublish=" + yearPublish + '}';
    }

}
