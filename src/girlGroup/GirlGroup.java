package girlGroup;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GirlGroup {
    private int g_id;
    private String name;
    private LocalDate debut;

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }
}
