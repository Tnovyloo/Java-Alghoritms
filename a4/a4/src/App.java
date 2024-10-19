import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
        // Na początek utworzę set wymaganych umiejętności (Set poniewaz lista w metodzie .equals() ktroej bedziemy uzywac pozniej uwzglednia rowniez kolejnosc obiektow w liscie)
        Set<Skill> requiredSkillsSet = new LinkedHashSet<>(Arrays.asList(skill_a, skill_c, skill_b, skill_d));

        // System.out.println(cosmonauts);
        
        // Metoda brute force gdy wiem ze rozwiazania sa dwa 
        // for (int i = 0; i < cosmonauts.size(); i++) {
        //     // System.out.println(cosmonauts.get(i));
        //     Cosmonaut ki = cosmonauts.get(i); 
        //     for (int j = i + 1; j < cosmonauts.size(); j++) {
        //         System.out.println(cosmonauts.get(i) + " " + cosmonauts.get(j));
        //         Cosmonaut kj = cosmonauts.get(j);
                
        //         Set<Skill> skillsOfThisCosmonauts = new LinkedHashSet<>();
        //         for (Skill skill : ki.getSkills()) {
        //             skillsOfThisCosmonauts.add(skill);
        //         }

        //         for (Skill skill : kj.getSkills()) {
        //             skillsOfThisCosmonauts.add(skill);
        //         }
                
        //         System.out.println("Skills of " + ki + " and " + kj + " is: " + skillsOfThisCosmonauts);
        //         if (skillsOfThisCosmonauts.equals(requiredSkillsSet)) {
        //             System.out.println("Bingo! Skills of " + ki + " and " + kj + " is: " + skillsOfThisCosmonauts + " of needed: " + required_skills);
        //         }
        //     }
        // }

        // Metoda madrzejsza:


        // bierzmy ich tylu ilu uzupelni ABCD, 
        // dopoki k1 nie uzupelni ABCD z X tam kx to ma szukac
        // for (int i = 0; i < cosmonauts.size(); i++) {
        //     Cosmonaut ki = cosmonauts.get(i);
        //     boolean coveredSkills = false;
        //     // Set<Cosmonaut> setOfCosmonautsThatCoversRequirements =
        //     ArrayList<ArrayList<Cosmonaut>> coveragingCosmonauts = new ArrayList<>();
        //     // temp sets dla ki i innych kx dopoki abcd nie bedzie zapewnione  
        //     while (!coveredSkills) {
   
        //     }
        // }

        // ODWROTNY SPOSOB NA SZUKANIE KOSMONAUTOW
        // Zbieranie mysli
        // jezeli k1, k2, k3, k4, k5 spelnianaja abcd to zostaw
        // usun teraz przykladowo k1 -> jesli zbior umiejetnosci kosmonatow nie spelnia umiejetnosci abcd -> zostaw k1
        // usun teraz przykladowo k2 -> jesli nie spelnia abcd (wszyscy kosmici) -> zostaw k2
        // usun teraz przykladowo k3 -> jesli nie spelnia abcd -> zostaw k3
        // usun teraz przykladowo k4 -> jesli spelnia abcd -> usun go
        
        // Tworze Set wszystkich kosmonautow, po kolei kazdego usuwam i sprawdzam czy skillSet ABCD jest dalej pokryty przez umiejetnosci zalogi
        ArrayList<Cosmonaut> coverageCosmonauts = new ArrayList<>(Arrays.asList(k1, k2, k3, k4, k5));
        for (int i = 0; i < cosmonauts.size(); i++) {
            // Usuwany przykladowy kosmonauta
            Cosmonaut ki = cosmonauts.get(i);
            // Jesli requiredSkillSets - ki skills = ABCD -> mozemy usunac ki

            // Wez requiredSkillSet
            Set<Skill> requiredSkillsSetCopy = new HashSet<>(requiredSkillsSet);
            System.out.println(requiredSkillsSetCopy);
            for (Skill skill : ki.getSkills()) {
                requiredSkillsSetCopy.remove(skill);
            }

            System.out.println("Set z usunietymi umiejetnosciami ki (" + ki + "): " + requiredSkillsSetCopy);
            // requiredSkillsSetCopy.remove(coverageCosmonauts)

            // Chwilowa lista z umiejetnosciami kosmonautow z coverageCosmonauts
            // ArrayList<Skill> temporarySkills = new ArrayList<>();
            // for (int j = 0; j < coverageCosmonauts.size(); j++) {
            //     Cosmonaut kj = cosmonauts.get(j);
            //     temporarySkills.addAll(kj.getSkills());
            // }

            // System.out.println(temporarySkills);
        }

        // MINIMUM JEDEN CZYLI MOZEMY ABCD - KOSMONAUTA UMIEJETNOSCI = [0] TO WTEDY IDEAL BIERZEMY GO 
        // A JESLI NIE TO RESZTE Z ODEJMOWANIA OD TEGO WYZSZEGO DZIALANIA BIERZEMY I SZUKAMY 
        // APROPOS TRZEBA JAKOS ZAPISYWAC TYCH WSZYSTKICH ASÓWU UMIEJETNOSCI ORAZ ICH JAK I ICH LICZBE, SZUKAMY JAK NAJMNIEJSZA, MOZE ZACZNIEMY OD ILOSCI TYCH KOSMONAUTOW.

        // CHYBA TRZEBA WYGENEROWAC WSZYSTKIE PERMUTACJE TEGO ZESPOLU I SPRAWDZAC NP
        // K1
        // K1, K2
        // K1, K3
        // K1, K4
        // K1, K5
        // K1, K2, K3
        // K1, K2, K4
        // K1, K2, K5
        // K1, K2, K3, K4
        // K1, K2, K3, K5
        // K1, K2, K3, K4, K5 sprawdzam czy tutaj sa spelnione wymagania abcd 
        // ILOSC KOMBINACJI GDZIE KOLEJNOSC NIE MA ZNACZENIA

        int MIN_TEAM = 1;

        for (int i = 0; i < cosmonauts.size(); i++) {
            Cosmonaut ki = cosmonauts.get(i);

            Set<Skill> diffrenceSet = new HashSet<>(requiredSkillsSet);
            for (Skill skill : ki.getSkills()) {
                diffrenceSet.remove(skill);
            }
            

            while (diffrenceSet.size() == 0) {
                for (int j = 0; j < cosmonauts.size(); j++) {
                    
                }
            }
            // if (diffrenceSet.size() == 0) {

            // }

        }

    }
}
