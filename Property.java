import java.util.*;

public class Property<T>
{

    private T property;
    private T defaultValue;

    private String key;

    private boolean saved = true;

    private boolean observable = true;
    private boolean editable = true;


    // These are for the returns
    int rint;
    float rfloat;
    double rdouble;
    long rlong;
    char rchar;
    byte rbyte;
    short rshort;
    boolean rboolean;


    public Property(String key, T defaultValue) {
        this.defaultValue = defaultValue;
        this.key = key;
    }

    public Property(String key, T defaultValue, boolean saved) {
        this.defaultValue = defaultValue;
        this.key = key;
        this.saved = saved;
    }

    public T getProperty() {
        return property;
    }

    public void setProperty(T property) {
        if(this.property != null && (!editable || !observable))
            return;

        if(property == null)
        {
            this.property = this.defaultValue;
        }
        else
            this.property = property;

        this.setPrim();
    }

    public void setPrim()
    {
        if(property instanceof Integer)
           rint = ((Integer)property).intValue();
        else if(property instanceof Float)
           rfloat = ((Float)property).floatValue();
        else if(property instanceof Double)
           rdouble = ((Double)property).doubleValue();
        else if(property instanceof Long)
           rlong = ((Long)property).longValue();
        else if(property instanceof Character)
           rchar = ((Character)property).charValue();
        else if(property instanceof Byte)
           rbyte = ((Byte)property).byteValue();
        else if(property instanceof Short)
           rshort = ((Short)property).shortValue();
        else if(property instanceof Boolean)
           rboolean = ((Boolean)property).booleanValue();
    }

    public boolean getBoolean()
    {
	return rboolean;
    }

    public int getInt() { return rint; }

    public short getShort() { return rshort; }
	

    public long getLong() {return rlong;}


    public float getFloat() {return rfloat;}

    public double getDouble() {return rdouble;}

    public char getChar() {return rchar;}

    public byte getByte() {return rbyte;}


    public T getDefaultValue() {
        return defaultValue;
    }

    public String getKey() {
        return key;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setObservable(boolean observable) {
        this.observable = observable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
        
}
