import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        // Dziedzina A - k1, k4
        // Dziedzina B - k2, k3, k4
        // Dziedzina C - k3, k5
        // Dziedzina D - k1, k2, k5
        Skill skill_a = new Skill("a");
        Skill skill_b = new Skill("b");
        Skill skill_c = new Skill("c");
        Skill skill_d = new Skill("d");

        // Przygotowujemy kosmonautę 1
        ArrayList<Skill> k1_skill_array_list = new ArrayList<>(Arrays.asList(skill_a, skill_d));
        Cosmonaut k1 = new Cosmonaut(k1_skill_array_list, "k1");
        
        // Przygotowujemy kosmonatę 2 
        ArrayList<Skill> k2_skill_array_list = new ArrayList<>(Arrays.asList(skill_a, skill_d));
        Cosmonaut k2 = new Cosmonaut(k2_skill_array_list, "k2");

        // Przygotowujemy kosmonaute 3
        ArrayList<Skill> k3_skill_array_list = new ArrayList<>(Arrays.asList(skill_b, skill_c));
        Cosmonaut k3 = new Cosmonaut(k3_skill_array_list, "k3");
        
        // Przygotowujemy kosmonaute 4
        ArrayList<Skill> k4_skill_array_list = new ArrayList<>(Arrays.asList(skill_a, skill_b));
        Cosmonaut k4 = new Cosmonaut(k4_skill_array_list, "k4");

        // Przygotowujemy kosmonaute 5
        ArrayList<Skill> k5_skill_array_list = new ArrayList<>(Arrays.asList(skill_c, skill_d));
        Cosmonaut k5 = new Cosmonaut(k5_skill_array_list, "k5");

        // Zbierzemy ich do kupy
        ArrayList<Cosmonaut> cosmonauts = new ArrayList<Cosmonaut>(Arrays.asList(k1, k2, k3, k4, k5));

        // Algorytm:
        // Na początek utworzę listę wymaganych umiejętności
        Set<Skill> required_skills = new LinkedHashSet<>(Arrays.asList(skill_a, skill_c, skill_b, skill_d));

        // System.out.println(cosmonauts);
        
        // Metoda brute force gdy wiem ze rozwiazania sa dwa 
        for (int i = 0; i < cosmonauts.size(); i++) {
            // System.out.println(cosmonauts.get(i));
            Cosmonaut ki = cosmonauts.get(i); 
            for (int j = i + 1; j < cosmonauts.size(); j++) {
                System.out.println(cosmonauts.get(i) + " " + cosmonauts.get(j));
                Cosmonaut kj = cosmonauts.get(j);

                Set<Skill> skills_of_this_cosmonauts = new LinkedHashSet<>();
                for (Skill skill : ki.getSkills()) {
                    skills_of_this_cosmonauts.add(skill);
                }

                for (Skill skill : kj.getSkills()) {
                    skills_of_this_cosmonauts.add(skill);
                }
                
                System.out.println("Skills of " + ki + " and " + kj + " is: " + skills_of_this_cosmonauts);
                if (skills_of_this_cosmonauts.equals(required_skills)) {
                    System.out.println("Bingo! Skills of " + ki + " and " + kj + " is: " + skills_of_this_cosmonauts + " of needed: " + required_skills);
                }
            }
        }
    }
}
