package ua.com.alevel.util;

import ua.com.alevel.entity.Access;

import java.util.List;
import java.util.UUID;

public final class GenerateAccessIdUtil {

    private GenerateAccessIdUtil() { }

    public static String generate(List<Access> accesses, int nextAccessId) {
        String id = UUID.randomUUID().toString();
        if (nextAccessId > 0) {
            for (Access access : accesses) {
                if (access.getId().equals(id)) {
                    return generate(accesses, nextAccessId);
                }
            }
        }
        return id;
    }

    public static String generate() {
        String id = UUID.randomUUID().toString();

        return id;
    }
}
