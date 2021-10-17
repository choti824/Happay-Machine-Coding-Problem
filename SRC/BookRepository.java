package SRC;

public class BookRepository 
{
    ArrayList<Book> bookCatalague = new ArrayList<book>();
    public book addBookToCatalog(book b){
        bookCatalague.add(b);
           
    }
    public int  getMostBooksSoldByAuthor(string aId){
        int maxCount = 0;
        for(int i = 0; i < bookCatalogue.size(); i++)
        {
            book b = new book(bookCatalogue.get(i));
            if(b.authorId == aId)
            maxCount = max(maxCount, b.soldCount);
        }
      return maxCount;
}
    public int  getMostBooksSoldByCategory(string catId){
        int maxCount = 0;
        for(int i = 0; i < bookCatalogue.size(); i++)
        {
            book b = new book(bookCatalogue.get(i));
            if(b.categoryId == cId)
            maxCount = max(maxCount, b.soldCount);
        }
        return maxCount;

    }

    
}
