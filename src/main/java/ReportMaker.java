import java.util.Map;
import java.util.TreeMap;

public class ReportMaker {
    StringBuilder sb;

    public ReportMaker () {
        sb = new StringBuilder();
    }

    public <T> ReportMaker addBlock(String title, T value) {
        sb.append(title).append(":\n").append(value).append('\n');
        return this;
    }

    public <K, V> ReportMaker addBlock(String title, Map<K, V> value) {
        sb.append(title).append(":\n");
        new TreeMap<>(value).forEach((key, value1) ->
                sb.append(key).append(": ").append(value1).append('\n'));
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
