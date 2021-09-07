import java.util.HashMap;
import java.util.Map;

public class DataUtils {

    // Уровень. Педагоги: 0 - Педагог дошкольного образования; 1 - Педагог начального общего образования;
    //  2 - Педагог основного общего образования; 3 - Педагог среднего общего образования;
    // Родители детей в возрасте: 0 - от 0 до 3 лет; 1 - от 3 до 7 лет; 2 - от 7 до 12 лет; 3 - от 12 до 18 лет
    private static final
        Map<String, Map<String, String>> subgroupCategoriesMapping = new HashMap<>();
    static {
        Map<String, String> groupMapping = new HashMap<>();
        groupMapping.put("0", "Педагог дошкольного образования");
        groupMapping.put("1", "Педагог начального общего образования");
        groupMapping.put("2", "Педагог основного общего образования");
        groupMapping.put("3", "Педагог среднего общего образования");

        subgroupCategoriesMapping.put("Педагоги", groupMapping);

        groupMapping = new HashMap<>();

        groupMapping.put("0", "Родители детей в возрасте от 0 до 3 лет");
        groupMapping.put("1", "Родители детей в возрасте от 3 до 7 лет");
        groupMapping.put("2", "Родители детей в возрасте от 7 до 12 лет");
        groupMapping.put("3", "Родители детей в возрасте от 12 до 18 лет");

        subgroupCategoriesMapping.put("Родители", groupMapping);

    }

    public static Map<String, Map<String, String>> getSubgroupCategoriesMapping() {
        return subgroupCategoriesMapping;
    }
}
