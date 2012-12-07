package ua.kpi.transport.db.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harker777
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        String result = "";
        result += classString();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (!field.getName().equals("serialVersionUID")) {
                result += fieldString(field);
            }
        }
        result += "\n";

        return result;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (anObject == this) {
            return true;
        }
        Class<? extends BaseBean> aClass = this.getClass();
        Object other = aClass.cast(anObject);

        for (Field field : this.getClass().getDeclaredFields()) {
            String name = field.getName();
            if (!name.equals("serialVersionUID")) {
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                try {
                    Method method = this.getClass().getMethod("get" + name, null);
                    Object ob1 = method.invoke(this, (Object[]) null);
                    Object ob2 = method.invoke(other, (Object[]) null);
                    if (!ob1.equals(ob2)) {
                        return false;
                    }
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return true;
    }

    private String classString() {
        String result = "";
        String name = this.getClass().getSimpleName();
        name = name.substring(0, name.indexOf("Bean"));
        result += "Entity : ";
        result += name + "\n";
        return result;
    }

    private String fieldString(Field field) {
        String result = "";
        String fieldName = field.getName();
        fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        result += fieldName + " - ";
        try {
            Method method = this.getClass().getMethod("get" + fieldName, null);
            result += method.invoke(this, (Object[]) null);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        result += "\n";
        return result;
    }

    //Just some utility, used to generate Comparator getters
    public String getComparators() {
        String result = "\n";
        String className = this.getClass().getSimpleName();

        for (Field field : this.getClass().getDeclaredFields()) {
            String name = field.getName();
            if (!name.equals("serialVersionUID")) {
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                result += "public static Comparator get";
                result += name;
                result += "Comparator(){\n";
                
                result += "return new Comparator(){\n"
                        + "@Override\n"
                        + "public int compare(Object o1, Object o2) {\n"
                        + " " + className + " b1 = (" + className + ")o1;\n"
                        + " " + className + " b2 = (" + className + ")o2;\n"
                        + " " + "return b1.get" + name + "().compareTo(b2.get" + name + "());\n"
                        + " " + "}\n"
                        + "};\n";
                
                result += "}\n\n";
            }
        }
        return result;
    }
}
