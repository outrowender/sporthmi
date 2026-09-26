/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.tghu.navi.app.util.Util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import org.dsi.ifc.global.NavLocation;

public class FavoriteLocation
implements Serializable {
    private static final long serialVersionUID;
    public static final String COUNTRY;
    public static final String STATE;
    public static final String ZIPCODE;
    public static final String COUNTRY_ABBREVIATION;
    public static final String CITY;
    public static final String CITY_PART;
    public static final String STREET;
    public static final String STREET2;
    public static final String HOUSENUMBER;
    public static final String NAME;
    private Integer key;
    private Map values;
    int longitude;
    int latitude;
    static /* synthetic */ Class class$java$lang$Integer;

    public FavoriteLocation() {
    }

    public FavoriteLocation(int n) {
        this.key = new Integer(n);
    }

    public int getLongitude() {
        return this.longitude;
    }

    public void setLongitude(int n) {
        this.longitude = n;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int n) {
        this.latitude = n;
    }

    public String getField(String string) {
        return (String)this.values.get(string);
    }

    public void setKey(Integer n) {
        this.key = n;
    }

    public Integer getKey() {
        return this.key;
    }

    public void setField(String string, Object object) {
        this.getValues().put(string, object);
    }

    public Set getAvailableFields() {
        return this.getValues().keySet();
    }

    private Map getValues() {
        if (this.values == null) {
            this.values = new HashMap();
        }
        return this.values;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.key == null ? 0 : this.key.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = FavoriteLocation.class$("java.lang.Integer")) : class$java$lang$Integer)) {
            Integer n = (Integer)object;
            if (this.key == null ? n != null : !this.key.equals(n)) {
                return false;
            }
        } else if (object.getClass() == super.getClass()) {
            FavoriteLocation favoriteLocation = (FavoriteLocation)object;
            if (this.key == null ? favoriteLocation.key != null : !this.key.equals(favoriteLocation.key)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public String getSpeakableName() {
        String string = this.getField("NAME");
        if (Util.isEmpty(string)) {
            string = Util.isEmpty(this.getField("STREET")) ? this.getField("CITY") : (Util.isEmpty(this.getField("HOUSENUMBER")) ? (Util.isEmpty(this.getField("STREET2")) ? new StringBuffer().append(this.getField("STREET")).append(" ").append(this.getField("CITY")).toString() : new StringBuffer().append(this.getField("STREET")).append(" ").append(this.getField("STREET2")).append(" ").append(this.getField("CITY")).toString()) : new StringBuffer().append(this.getField("STREET")).append(" ").append(this.getField("HOUSENUMBER")).append(" ").append(this.getField("CITY")).toString());
        }
        return string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(Util.getClassNameFromPackageName(super.getClass()));
        stringBuffer.append("(key=").append(this.getKey());
        Iterator iterator = this.getValues().entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            stringBuffer.append(map$Entry.getKey()).append("=").append(map$Entry.getValue()).append(", ");
        }
        stringBuffer.append("longitude =").append(this.longitude).append(", ");
        stringBuffer.append("latitude =").append(this.latitude).append(")");
        return stringBuffer.toString();
    }

    public void update(NavLocation navLocation) {
        this.setLatitude(navLocation.latitude);
        this.setLongitude(navLocation.longitude);
        this.setField("NAME", Util.getFavoriteNameFromLocation(navLocation));
        this.setField("COUNTRY", navLocation.getCountry());
        this.setField("COUNTRY_ABBREVIATION", navLocation.getCountryAbbreviation());
        this.setField("STATE", Util.getStateAbbreviation(navLocation));
        this.setField("CITY", navLocation.getTown());
        this.setField("ZIPCODE", navLocation.getZipCode());
        this.setField("STREET", navLocation.getStreet());
        this.setField("STREET2", navLocation.getJunction());
        this.setField("HOUSENUMBER", navLocation.getHousenumber());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

