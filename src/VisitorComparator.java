import java.util.Comparator;

//The VisitorComparator class is used to compare Visitor objects
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        //Firstly, compare the ages
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if(ageCompare != 0){
            return ageCompare;
            //If the ages are different, return the age comparison result
        }
        //If the age is the same, compare the names
        return v1.getName().compareTo(v2.getName());
    }
}
