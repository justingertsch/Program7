import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Created by Justin on 12/1/2014.
 */
public class TestDriver
{
    public static void main(String[] args)
    {
        Database db = new Database("db.dat");
        test(db);

        Database userdb = new Database("user.dat");
        SecureDB sdb = new SecureDB(db,userdb);
        test(sdb);

        CacheDB cdb = new CacheDB(db);
        test(cdb);


        Database db2 = new Database("noname.dat");


    }



    public static void test(IDatabase db)
    {
        try
        {
            System.out.println(db.get("one"));
            System.out.println(db.get("two"));
            System.out.println(db.get("two"));
            System.out.println(db.get("three"));
            System.out.println(db.get("four"));
            System.out.println(db.get("four"));
            System.out.println(db.get("five"));
            System.out.println(db.get("six"));
            System.out.println(db.get("seven"));
            System.out.println("\n");
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("\n");
        }
    }
}
