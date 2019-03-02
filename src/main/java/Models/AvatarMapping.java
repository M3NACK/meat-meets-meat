package Models;

import java.util.HashMap;

public class AvatarMapping {

    private static HashMap<String, Integer> avatarMapping = new HashMap<>();
    private static HashMap<Integer, String> reverseAvatarMapping = new HashMap<>();
    private static HashMap<String, String> avatarPhotoPaths = new HashMap<>();

    static {
        avatarMapping.put("Walrus", 1);
        avatarMapping.put("Panda", 2);
        avatarMapping.put("Manatee", 3);
        avatarMapping.put("Lemur", 4);
        avatarMapping.put("Giraffe", 5);
    }

    static {
        reverseAvatarMapping.put(1, "Walrus");
        reverseAvatarMapping.put(2, "Panda");
        reverseAvatarMapping.put(3, "Manatee");
        reverseAvatarMapping.put(4, "Lemur");
        reverseAvatarMapping.put(5, "Giraffe");
    }

    static {
        avatarPhotoPaths.put("Walrus", "Images/walrus.jpeg");
        avatarPhotoPaths.put("Panda", "Images/panda.jpg");
        avatarPhotoPaths.put("Manatee", "Images/manatee.jpg");
        avatarPhotoPaths.put("Lemur", "Images/lemur.jpg");
        avatarPhotoPaths.put("Giraffe", "Images/giraffe.jpeg");
    }

    public static Integer getMapping(String avatar) {
        return avatarMapping.get(avatar);
    }

    public static String getReverseMapping(Integer aid) {
        return reverseAvatarMapping.get(aid);
    }

    public static String getPhotoPathMapping(String avatar) {
        return avatarPhotoPaths.get(avatar);
    }

}
