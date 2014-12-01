/**
 * Created by Justin on 12/1/2014.
 */
public interface IDatabase
{
    public String getID();
    public boolean exists(String key);
    public String get(String key);
}
