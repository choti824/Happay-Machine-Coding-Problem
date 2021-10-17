package SRC;

import java.util.HashMap;
import java.util.Map;

public class BookRepository 
{
    private static HashMap<String, Book> bookCatalog = new HashMap<String, Book>();

    public static void addBookToCatalog(Book b){
        if (bookCatalog.containsKey(b.getBookId())) {
            System.out.println("Invalid Book ID");
            return;
        }
        if (AuthorRepository.checkAuthorIdExists(b.getAuthorId())) {
            System.out.println("Invalid Author ID");
            return;
        }
        if (CategoryRepository.checkCategoryIdExists(b.getCategoryId())) {
            System.out.println("Invalid Category ID");
            return;
        }
        bookCatalog.put(b.getBookId(), b);
        System.out.println("Success");       
    }

    public static void getMostBooksSoldByAuthor(String aId){
        String authorName = AuthorRepository.getAuthorNameById(aId);
        int maxCount = 0;
        Book maxBook = null;
        for (Map.Entry<String, Book> entry : bookCatalog.entrySet()) {
            if (entry.getValue().getAuthorId().equals(aId)) {
                if (maxCount < entry.getValue().getSoldCount()) {
                    maxCount = entry.getValue().getSoldCount();
                    maxBook = entry.getValue();
                }
            }
        }
        if (maxBook == null || authorName == null) {
            System.out.println("Invalid Author ID");
            return;
        }
        String cName = CategoryRepository.getCategoryNameById(maxBook.getCategoryId());
        System.out.println(maxBook.getBookId());
        System.out.println(maxBook.getTitle());
        System.out.println(authorName);
        System.out.println(maxBook.getAuthorId());
        System.out.println(maxBook.getPublisher());
        System.out.println(maxBook.getPublishedDate());
        System.out.println(maxBook.getCategoryId());
        System.out.println(cName);
        System.out.println(maxBook.getPrice());
        System.out.println(maxBook.getSoldCount());
    }

    public static void getMostBooksSoldByCategory(String cId){
        String cName = CategoryRepository.getCategoryNameById(cId);
        int maxCount = 0;
        Book maxBook = null;
        for (Map.Entry<String, Book> entry : bookCatalog.entrySet()) {
            if (entry.getValue().getAuthorId().equals(cId)) {
                if (maxCount < entry.getValue().getSoldCount()) {
                    maxCount = entry.getValue().getSoldCount();
                    maxBook = entry.getValue();
                }
            }
        }
        if (maxBook == null || cName == null) {
            System.out.println("Invalid Category ID");
            return;
        }
        String authorName = AuthorRepository.getAuthorNameById(maxBook.getAuthorId());
        System.out.println(maxBook.getBookId());
        System.out.println(maxBook.getTitle());
        System.out.println(authorName);
        System.out.println(maxBook.getAuthorId());
        System.out.println(maxBook.getPublisher());
        System.out.println(maxBook.getPublishedDate());
        System.out.println(maxBook.getCategoryId());
        System.out.println(cName);
        System.out.println(maxBook.getPrice());
        System.out.println(maxBook.getSoldCount());
    }

    public static void getBooksByAuthor(String aId) {
        for (Map.Entry<String, Book> entry : bookCatalog.entrySet()) {
            if (entry.getValue().getAuthorId().equals(aId)) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getTitle());
            }
        }
    }

    public static void getBooksBySearch (String searchString) {
        String lowerSearchString = searchString.toLowerCase();
        for (Map.Entry<String, Book> entry : bookCatalog.entrySet()) {
            if (entry.getValue().getTitle().contains(lowerSearchString) || AuthorRepository.getAuthorNameById(entry.getValue().getAuthorId()).contains(lowerSearchString)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
