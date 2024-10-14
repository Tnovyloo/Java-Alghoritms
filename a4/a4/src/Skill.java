public class Skill {
    private String name;

    public Skill() {
        System.out.println("No parameter Skill constructor (default)");
    }

    public Skill(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
