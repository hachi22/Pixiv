package cat.itb.pixiv.ClassesModels;

import android.os.Parcel;
import android.os.Parcelable;

public class FavoriteClass implements Parcelable {
    String ImgUrl;
    boolean favorite;
    private String key;

    protected FavoriteClass(Parcel in) {
        ImgUrl = in.readString();
        favorite = in.readByte() != 0;
        key = in.readString();
    }

    public static final Creator<FavoriteClass> CREATOR = new Creator<FavoriteClass>() {
        @Override
        public FavoriteClass createFromParcel(Parcel in) {
            return new FavoriteClass(in);
        }

        @Override
        public FavoriteClass[] newArray(int size) {
            return new FavoriteClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ImgUrl);
        dest.writeByte((byte) (favorite ? 1 : 0));
        dest.writeString(key);
    }
}
