package cat.itb.pixiv.ClassesModels;

public class ImatgesIllusMangaRanking {
    private String title;
    private String user;
    private int imageUser;
    private int image;

    public ImatgesIllusMangaRanking(String title, String user, int imageUser, int image) {
        this.title = title;
        this.user = user;
        this.imageUser = imageUser;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


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

}
