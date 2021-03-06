import java.util.*;

public class Config
{

    private LinkedHashMap<String, Property> properties = new LinkedHashMap<>();
   
    private HashMap<String, String> config = new HashMap<>();
 
    public Config(HashMap<String, String> config)
    {  
	this.config = config;
    }  

    public Config() {}

    public boolean load()
    {
        for(Property property : this.properties.values())
        {
            String data = this.config.get(property.getKey());


            property.setProperty(data);
        }

        return true;
    }

    public void initializeConfigFile()
    {
        for(Property property : this.properties.values())
        {
            //this.config.put(property.getKey(), property.getDefaultValue());
        }
    }

    public void add(Property property)
    {
        this.properties.put(property.getKey(), property);
    }

    public void add(LinkedList<Property> properties)
    {
        for(Property property : properties)
        {
            this.properties.put(property.getKey(), property);
        }
    }

    public Property get(String key)
    {
        return this.properties.get(key);
    }

    public Property get(Class object)
    {
        for(Property property : this.properties.values())
        {
            if(property.getClass() == object)
                return property;
        }

        return null;
    }

}
