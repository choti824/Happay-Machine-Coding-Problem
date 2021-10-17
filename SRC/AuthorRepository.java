package SRC;

import java.util.HashMap;
import java.util.Map;

public class AuthorRepository {
    
    private static HashMap<String, Author> authors = new HashMap<String, Author>();
    
    public static void addAnAuthor(Author a){
        if (authors.containsKey(a.getAuthorId())) {
            System.out.println("Invalid Author ID");
            return;
        }
        authors.put(a.getAuthorId(), a);
        System.out.println("Success");
    }

    public static void getAllAuthorName(){
        for (Map.Entry<String, Author> entry : authors.entrySet()) {
            System.out.println(entry.getValue().getName());
        }
    }

    public static String getAuthorNameById(String aId) {
        Author author = authors.get(aId);
        if (author != null) {
            return author.getName();
        }
        return null;
    }

    public static boolean checkAuthorIdExists (String aId) {
        return authors.containsKey(aId);
    }

}
