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

	    if(property.getDefaultValue() instanceof Boolean)
		property.setProperty(Boolean.valueOf(data));
            else if(property.getDefaultValue() instanceof Integer)
                property.setProperty(Integer.valueOf(data));
            else if(property.getDefaultValue() instanceof Short)
                property.setProperty(Short.valueOf(data));
            else if(property.getDefaultValue() instanceof Byte)
                property.setProperty(Byte.valueOf(data));
            else if(property.getDefaultValue() instanceof Long)
                property.setProperty(Long.valueOf(data));
            else if(property.getDefaultValue() instanceof Character)
                property.setProperty(Character.valueOf(data.charAt(0)));
            else if(property.getDefaultValue() instanceof Float)
                property.setProperty(Float.valueOf(data));
            else if(property.getDefaultValue() instanceof Double)
                property.setProperty(Double.valueOf(data));
	    else
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
