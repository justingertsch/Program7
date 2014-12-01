
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * Created by Justin on 10/27/2014.
 */
public class Database implements IDatabase
{
    private RandomAccessFile dbFile = null;
    private String id = null;

    public Database(String id)
    {
        this.id = id;
        try
        {
            this.dbFile = new RandomAccessFile(id, "r");
        }
        catch (FileNotFoundException e)
        {
           System.out.println(id+" does not exist");
        }

    }

    public String getID()
    {
        return this.id;
    }

    public boolean exists(String key)
    {
        try
        {
            this.dbFile.seek(0);
            while(this.dbFile.getFilePointer() < this.dbFile.length())
            {
                String[] line = this.dbFile.readLine().trim().split(" +");
                if(line.length > 0)
                    if(line[0].equals(key))
                        return true;
            }

        }
        catch (IOException e)
        {
            System.out.println("File error");
        }
        return false;
    }

    public String get(String key)
    {
        try
        {
            this.dbFile.seek(0);
            while(this.dbFile.getFilePointer() < this.dbFile.length())
            {
                String[] line = this.dbFile.readLine().trim().split(" +");
                if(line.length > 0)
                    if(line[0].equals(key))
                        return extractValue(line);
            }
            throw new RuntimeException("No such record "+key);
        }
        catch (IOException e)
        {
            System.out.println("File error");
        }
        return null;
    }

    private String extractValue(String[] line)
    {
        String val = "";
        for(int i = 1; i < line.length; i++)
        {
            val +=line[i]+" ";
        }
        if(val != null)
            val.trim();
        return val;
    }

}
