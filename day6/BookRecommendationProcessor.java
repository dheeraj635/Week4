
import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
}

class BookRecommendation {
    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return "Title: " + title + ", Rating: " + rating;
    }
}

class BookRecommendationProcessor {

    public static List<BookRecommendation> getTopBooks(List<Book> books, int page, int pageSize) {
        return books.stream()
                .filter(b -> "Science Fiction".equalsIgnoreCase(b.getGenre()) && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())  // Sort by rating
                .limit(10)
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.1),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.4),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.6),
                new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.0),
                new Book("Blindsight", "Peter Watts", "Science Fiction", 4.2),
                new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.3),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.7),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.1)
        );

        int page = 1;
        int pageSize = 5;

        System.out.println("📘 Page " + page);
        List<BookRecommendation> recommendationsPage1 = getTopBooks(books, page, pageSize);
        recommendationsPage1.forEach(System.out::println);

        System.out.println("\n📘 Page " + (page + 1));
        List<BookRecommendation> recommendationsPage2 = getTopBooks(books, page + 1, pageSize);
        recommendationsPage2.forEach(System.out::println);
    }
}
