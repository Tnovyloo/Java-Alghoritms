import java.util.ArrayList;

public class Cosmonaut {
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    private String name;

    public Cosmonaut(ArrayList<Skill> skills, String name) {
        this.skills = skills;
        this.name = name;
        System.out.println(this.name + ": " + this.skills);
    }

    public Cosmonaut() {}


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + ": " + this.skills;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
