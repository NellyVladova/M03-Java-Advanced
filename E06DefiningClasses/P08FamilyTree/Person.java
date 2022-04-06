package JavaAdvanced.E06DefiningClasses.P08FamilyTree;

import java.util.List;

public class Person {
    private String name;
    private String dateOfBirth;
    private List<Parents> parents;
    private List<Children> children;

    public Person(String name, String dateOfBirth,
                  List<Parents> parents, List<Children> children) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.parents = parents;
        this.children = children;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parents:\n");
        for (Parents parent : parents){
            sb.append(parent).append("\n");
        }
        sb.append("Children:\n");
        for (Children child : children){
            sb.append(child).append("\n");
        }
        return sb.toString();
    }
}
