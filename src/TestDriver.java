import java.util.ArrayList;

/**
 * Created by Justin on 12/1/2014.
 */
public class TestDriver
{
    public static void main(String[] args)
    {
        //Database db = new Database("db.dat");
        //test(db);
        ArrayList<String> tester = new ArrayList<String>();
        tester.add("one");
        tester.add("two");
        tester.add("three");
        tester.add("four");

        for(String a : tester)
        {
            System.out.println(a);
        }
        tester.remove("three");
        for(String a : tester)
        {
            System.out.println(a);
        }

        System.out.println(tester.get(2));

    }

    public static void test(IDatabase db)
    {
        try
        {
            System.out.println(db.get("one"));
            System.out.println(db.get("two"));
            System.out.println(db.get("three"));
            System.out.println(db.get("four"));
            System.out.println(db.get("five"));
            System.out.println(db.get("six"));
            System.out.println(db.get("seven"));
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
