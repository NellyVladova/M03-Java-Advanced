package JavaAdvanced.E06DefiningClasses.P08FamilyTree;

public class Children {
    private String name;
    private String dateOfBirth;

    public Children(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return name + " " + dateOfBirth;
    }
}
