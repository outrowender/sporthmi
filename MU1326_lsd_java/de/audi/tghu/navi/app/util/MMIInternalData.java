/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class MMIInternalData {
    private static final String MMI_INTERNAL_DATA_SEPARATOR;
    private static final String MMI_INTERNAL_DATA_KEY_VALUE_SEPARATOR;
    public static final String KEY_ONLINEPOI;
    public static final String KEY_TITLE;
    public static final String KEY_MYSCREEN;
    public static final String KEY_FAVORITE_NAME;
    public static final String KEY_PETROL;
    public static final String KEY_URL;
    public static final String KEY_PHONE;
    public static final String KEY_GEOPOS;
    public static final String VALUE_BOOLEAN_TRUE;
    public static final String KEY_ONLINE_POI_ID;
    public static final String KEY_AREA;
    private final Map internalData = new HashMap();

    public void init(String string) {
        this.initializeHashMap(string);
    }

    public void init(NavLocation navLocation) {
        String string = null;
        if (navLocation != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            string = iMyLocationAccessor.getMmiInternalData();
        }
        if (Util.isEmpty(string)) {
            this.internalData.clear();
        } else {
            this.initializeHashMap(string);
        }
    }

    public boolean isKeyAvailable(NavLocation navLocation, String string) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && (iMyLocationAccessor = Util.getLocationAccessor(navLocation)) != null && !Util.isEmpty(iMyLocationAccessor.getMmiInternalData())) {
            this.init(iMyLocationAccessor.getMmiInternalData());
            return this.isKeyAvailable(string);
        }
        return false;
    }

    public String getValue(NavLocation navLocation, String string) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && (iMyLocationAccessor = Util.getLocationAccessor(navLocation)) != null && !Util.isEmpty(iMyLocationAccessor.getMmiInternalData())) {
            this.init(iMyLocationAccessor.getMmiInternalData());
            return this.getValue(string);
        }
        return null;
    }

    public boolean isKeyAvailable(String string) {
        return this.internalData.containsKey(string);
    }

    public String setValue(String string, String string2) {
        if (Util.isEmpty(string2)) {
            return this.removeKeyValuePair(string);
        }
        return (String)this.internalData.put(string, string2);
    }

    public String removeKeyValuePair(String string) {
        return (String)this.internalData.remove(string);
    }

    public String getValue(String string) {
        return (String)this.internalData.get(string);
    }

    public void setInLocation(NavLocation navLocation) {
        if (navLocation != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            iMyLocationAccessor.setMmiInternalData(MMIInternalData.hashMapToMmiInternalData(this.internalData));
        }
    }

    private void initializeHashMap(String string) {
        this.internalData.clear();
        String string2 = null;
        String string3 = null;
        int n = 0;
        int n2 = 0;
        while (true) {
            n2 = string.indexOf("=", n);
            if (n >= string.length() || n2 < n || n2 < 0) break;
            string2 = string.substring(n, n2);
            n = n2 + "=".length();
            if ((n2 = string.indexOf("@@", n)) < 0) {
                n2 = string.length();
            }
            if (n >= string.length() || n2 < n || n2 < 0) break;
            string3 = string.substring(n, n2);
            this.internalData.put(string2, string3);
            n = n2 + "@@".length();
        }
    }

    private static String hashMapToMmiInternalData(Map map) {
        Buffer buffer = new Buffer();
        int n = 0;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            String string = (String)map.get(object);
            if (Util.isEmpty(string)) continue;
            if (n++ > 0) {
                buffer.append("@@");
            }
            buffer.append(object);
            buffer.append("=");
            buffer.append(string);
        }
        return buffer.toString();
    }
}

