package ua.kpi.transport.db.entities;

import java.util.Comparator;

/**
 *
 * @author harker777
 */
public class RouteBean extends BaseBean {

    private Integer id;
    private String name;

    public RouteBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                RouteBean b1 = (RouteBean) o1;
                RouteBean b2 = (RouteBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }

    public static Comparator getNameComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                RouteBean b1 = (RouteBean) o1;
                RouteBean b2 = (RouteBean) o2;
                return b1.getName().compareTo(b2.getName());
            }
        };
    }
}
