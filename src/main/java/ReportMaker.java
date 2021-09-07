public class ReportMaker {
    StringBuilder sb;

    public ReportMaker () {
        sb = new StringBuilder();
    }

    public <T> ReportMaker addBlock(String title, T value) {
        sb.append(title).append(":\n").append(value).append('\n');
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
