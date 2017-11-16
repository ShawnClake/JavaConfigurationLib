

import java.util.*;
//import java.system.*;


public class Base
{

private static HashMap<String, String> configs = new HashMap<>();

public static void main (String[] args)
{
configs.put("one", "BOB");
configs.put("two", "this is a string");
configs.put("three", "109");
configs.put("four", "200.789");
configs.put("five", "false");
configs.put("six", "-1");

Config config = new Config(configs);

config.add(new Prop1());
config.add(new Prop2());
config.add(new Prop3());
config.add(new Prop4());
config.add(new Prop5());
config.add(new Prop6());

config.load();

System.out.println(config.get(Prop1.class).getProperty()+"");
System.out.println(config.get(Prop2.class).getProperty()+"");
System.out.println(config.get(Prop3.class).getProperty()+"");
System.out.println(config.get(Prop4.class).getProperty()+"");
System.out.println(config.get(Prop5.class).getProperty()+"");
System.out.println(config.get(Prop6.class).getProperty()+"");

if(config.get(Prop1.class).getBoolean())
{
System.out.println("success");
}

if(config.get(Prop3.class).getInt() >= 100)
{
System.out.println(">=");
}

if(config.get(Prop3.class).getInt() < 100)
{
System.out.println("<");
}


System.out.println("end");

}





}
