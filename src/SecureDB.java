import java.util.Scanner;

/**
 * Created by lucian on 12/1/14.
 */
public class SecureDB implements IDatabase
{
    private IDatabase db = null;
    private IDatabase userDB = null;
    private boolean authenticated = false;
    private Scanner input = null;

    public SecureDB(IDatabase db, IDatabase userDB)
    {
        this.db = db;
        this.userDB = userDB;
        this.input = new Scanner(System.in);
    }

    public String getID()
    {
        return this.db.getID();
    }

    public boolean exists(String key)
    {
        try
        {
            auth();
            return this.db.exists(key);
        }
        catch(RuntimeException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public String get(String key)
    {
        try
        {
            auth();
            return this.db.get(key);
        }
        catch(RuntimeException ex)
        {
            return ex.getMessage();
        }

    }

    private void auth()
    {
        String username;
        String password;
        String pass;
        if(this.authenticated == false)
        {
            System.out.print("Enter username: ");
            username = input.nextLine();
            System.out.print("Enter password: ");
            password = input.nextLine();

            try
            {
                pass = this.userDB.get(username);
            }
            catch(RuntimeException ex)
            {
                throw new RuntimeException("Authentication Failed");
            }
            if(!pass.equals(password))
                throw new RuntimeException("Authentication Failed");

            this.authenticated = true;
        }

    }
}
