import java.util.ArrayList;

/**
 * Created by Justin on 12/1/2014.
 */
public class CacheDB implements IDatabase
{
    final int SIZE = 5;
    ArrayList<String> cache = null;
    IDatabase db = null;

    public CacheDB(IDatabase db)
    {
        this.db = db;
        cache = new ArrayList<String>();
    }

    public String getID()
    {
        return this.db.getID();
    }

    public boolean exists(String key)
    {
        for(String str: cache)
        {
            String[] line = str.trim().split(" +");
            if(line.length > 0)
                if(line[0].equals(key))
                    return true;
        }

        return db.exists(key);
    }

    public String get(String key)
    {
        for(String str: cache)
        {
            String[] line = str.trim().split(" +");
            if(line.length > 0)
                if(line[0].equals(key))
                {
                    updateCache(str);
                    String value = extractValue(line);
                    System.out.println("retrieving \""+ value +"\" from cache");
                    return value;
                }
        }
        String value = db.get(key);
        updateCache(key+" "+value);
        return value;
    }

    private void updateCache(String line)
    {
        ArrayList<String> newCache = new ArrayList<String>();
        this.cache.remove(line);
        newCache.add(line);
        int count = 2;
        for(String str : this.cache)
        {
            if(count <= 5)
            {
                newCache.add(str);
                count++;
            }
        }
        this.cache = newCache;
    }

    private String extractValue(String[] line)
    {
        String val = "";
        for(int i = 1; i < line.length; i++)
        {
            val +=line[i]+" ";
        }

        val = val.trim();
        return val;
    }

    @Override
    public String toString()
    {
        String print = "Cache Contents:\n";
        for(String str: this.cache)
        {
            print +="\t"+str+"\n";
        }
        return print;
    }
}
