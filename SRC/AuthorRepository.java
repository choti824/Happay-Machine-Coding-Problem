package SRC;

public class AuthorRepository 
{
    List<Author> authorCatalogue = new ArrayList<Author>();
    public string addAnAuthor(author a1){
        authorCatalogue.add(a1);
        system.out.printIn("Success");
    }
    public string[] getAllAuthorName(){
        for(int i = 0; i < authorCatalogue.size(); i++)
        {
            author a = new author(authorCatalogue.get(i));
            System.out.println(a.name());
        }
}   
   
    public string  getBooksByAuthor(string aId){
        for(int i = 0; i < authorCatalogue.size(); i++)
        {
            author a = new author(authorCatalogue.get(i));
        }

    }


}
