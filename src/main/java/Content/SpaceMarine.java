package Content;

import java.time.LocalDateTime;

public class SpaceMarine {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private AstartesCategory category; //Поле может быть null
    private Weapon weaponType; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(String name,
                       Coordinates coordinates,
                       Integer health,
                       AstartesCategory category,
                       Weapon weaponType,
                       MeleeWeapon meleeWeapon,
                       Chapter chapter) throws Exception {
        if (name == null) {
            throw new Exception("Значение name не может быть null.");
        } else if (health <= 0) {
            throw new Exception("Значение health должно быть больше 0.");
        } else if (coordinates == null) {
            throw new Exception("Значение coordinates не может быть null.");
        } else if (chapter == null) {
            throw new Exception("Значение chapter не может быть null");
        }
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
        this.creationDate = LocalDateTime.now();
        //this.id = this.creationDate.hashCode();
    }

    public int getID() {
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getCoordinateX() {
        return getCoordinates().getX();
    }

    public Integer getCoordinateY() {
        return getCoordinates().getY();
    }

    public void setCoordinates(int x, Integer y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public String getChapterName() {
        return chapter.getName();
    }

    public String getChapterWorld() {
        return chapter.getWorld();
    }

    public void setChapter(String name, String world) {
        chapter.setName(name);
        chapter.setWorld(world);
    }
}
