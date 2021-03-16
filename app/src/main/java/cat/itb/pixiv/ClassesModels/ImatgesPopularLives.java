package cat.itb.pixiv.ClassesModels;

public class ImatgesPopularLives {

    private String user;
    private int imageUser;
    private int image;
    private int numViews;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getImageUser() {
        return imageUser;
    }

    public void setImageUser(int imageUser) {
        this.imageUser = imageUser;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }

    public ImatgesPopularLives(String user, int imageUser, int image, int numViews) {
        this.user = user;
        this.imageUser = imageUser;
        this.image = image;
        this.numViews = numViews;
    }
}
