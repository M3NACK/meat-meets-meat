package Models;

import java.util.HashMap;

public class AvatarMapping {


    private static HashMap<String, Integer> avatarMapping;

    static {
        avatarMapping = new HashMap<>();
        avatarMapping.put("Walrus", 1);
        avatarMapping.put("Panda", 2);
        avatarMapping.put("Manatee", 3);
        avatarMapping.put("Lemur", 4);
        avatarMapping.put("Giraffe", 5);
    }

    public static Integer getMapping(String avatar) {
        return avatarMapping.get(avatar);
    }

}
