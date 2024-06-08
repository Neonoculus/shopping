package utils;

import java.util.ArrayList;
import java.util.List;

public class PhotoUtil {
    static public List<String> getPhotoList(String photos)
    {
        List<String> photoList = new ArrayList<>();
        String[] imageArray = photos.split("#");
        for (String imagePath : imageArray) {
            photoList.add(imagePath);
        }
        return photoList;
    }
}
