/**
 * Created by Justin on 12/1/2014.
 */
public class TestDriver
{
    public static void main(String[] args)
    {
        Database db = new Database("db.dat");
        test(db);
    }

    public static void test(IDatabase db)
    {
        System.out.println(db.get("one"));
        System.out.println(db.get("two"));
        System.out.println(db.get("three"));
        System.out.println(db.get("four"));
        System.out.println(db.get("five"));
        System.out.println(db.get("six"));
        System.out.println(db.get("seven"));
    }
}
