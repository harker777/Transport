package ua.kpi.transport.db.entities;

import java.util.Comparator;

/**
 *
 * @author harker777
 */
public class TransportTypeBean extends BaseBean {

    private String name;
    private Integer id;

    public TransportTypeBean(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    public static Comparator getNameComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportTypeBean b1 = (TransportTypeBean) o1;
                TransportTypeBean b2 = (TransportTypeBean) o2;
                return b1.getName().compareTo(b2.getName());
            }
        };
    }

    public static Comparator getIdComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TransportTypeBean b1 = (TransportTypeBean) o1;
                TransportTypeBean b2 = (TransportTypeBean) o2;
                return b1.getId().compareTo(b2.getId());
            }
        };
    }
}
