package Content;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле не может быть null

    public Chapter(String name, String world) throws Exception {
        if (name == null || name.equals("")) {
            throw new Exception("Значение name не может быть null.");
        } else if (world == null) {
            throw new Exception("Значение world не может быть null.");
        } else {
            this.name = name;
            this.world = world;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}
