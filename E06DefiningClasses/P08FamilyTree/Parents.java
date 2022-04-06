package JavaAdvanced.E06DefiningClasses.P08FamilyTree;

public class Parents {
    private String name;
    private String dateOfBirth;

    public Parents(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return name + " " + dateOfBirth;
    }
}
