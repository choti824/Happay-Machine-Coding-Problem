package SRC;

import java.util.HashMap;
import java.util.Map;

public class CategoryRepository {

    private static HashMap<String, Category> categories = new HashMap<String, Category>(); 
    
    public static void addCategory (String cId, String cName) {
        if (categories.containsKey(cId)) {
            System.out.println("Invalid Category ID");
            return;
        }
        Category category = new Category();
        category.setCategoryId(cId);
        category.setCategoryName(cName);
        categories.put(cId, category);
        System.out.println("Success");
    }

    public static String getCategoryNameById (String cId) {
        Category category = categories.get(cId);
        if (category != null) {
            return category.getCategoryName();
        }
        return null;
    }

    public static void getListOfCategories() {
        for (Map.Entry<String, Category> entry : categories.entrySet()) {
            System.out.println(entry.getValue().getCategoryName());
        }
    }

    public static boolean checkCategoryIdExists (String cId) {
        return categories.containsKey(cId);
    }

}
