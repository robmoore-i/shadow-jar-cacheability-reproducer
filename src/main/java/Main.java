import com.google.common.base.Joiner;

public class Main {
    public String words() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        return joiner.join("Harry", null, "Ron", "Hermione");
    }
}
