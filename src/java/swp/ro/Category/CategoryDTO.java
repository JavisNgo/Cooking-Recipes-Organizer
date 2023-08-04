
package swp.ro.Category;



public class CategoryDTO {
    private int categoryID;
    private String categoryName;
    private String imageCate;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public CategoryDTO(int categoryID, String categoryName, String imageCate) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.imageCate = imageCate;
    }

    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageCate() {
        return imageCate;
    }

    public void setImageCate(String imageCate) {
        this.imageCate = imageCate;
    }

    
    @Override
    public String toString() {
        return "CategoryDTO{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + '}';
    }
    
}
