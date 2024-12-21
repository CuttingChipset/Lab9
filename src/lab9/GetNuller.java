package lab9;

import java.util.List;

public class GetNuller {
    public static void main(String[] args) {
        try {
            ThrowEx.getExThrown();
        } catch (NullPointerException e) {
            System.out.println("\"" + e.toString() + "\" wywaliło");
            e.printStackTrace();
        }
    }
}

class ThrowEx {
    static void getExThrown() {
        List<Long> l = null;
        l.add(1L);
    }
}
