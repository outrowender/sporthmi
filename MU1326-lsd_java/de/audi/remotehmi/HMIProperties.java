/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.remotehmi;

import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Set;

public class HMIProperties {
    public static final int SKEY_NE;
    public static final int SKEY_NW;
    public static final int SKEY_SE;
    public static final int SKEY_SW;
    public static final int SKEY_NONE;
    public static final int UPDATING_DISABLED;
    public static final int UPDATING_ENABLED_A;
    public static final int SCROLL_MODE_6_LINES;
    public static final int SCROLL_MODE_5_LINES;
    public static final int SCROLL_MODE_NEXT_LINK;
    public static final int SCROLL_MODE_6_STEPS;
    public static final int SCROLL_MODE_5_STEPS;
    public static final int ITEMTYPE_EDITFIELD;
    public static final int ITEMTYPE_CHECKBOX;
    public static final int ITEMTYPE_ACTION;
    public static final int ITEMTYPE_PULLDOWN;
    public static final String PREFIX_ORIGINAL_PROPERTIES;
    private Hashtable myProps;
    private static final List RESOURCE_PROPERTIES;
    public static final String PROP_NAVLOCATION_INITIAL;

    public HMIProperties() {
        this.myProps = new Hashtable(20);
    }

    public HMIProperties(HMIProperties hMIProperties) {
        this.myProps = (Hashtable)hMIProperties.myProps.clone();
    }

    public void clear() {
        this.myProps.clear();
    }

    public void put(String string, Object object) {
        this.myProps.put(string, object);
    }

    public void putInt(String string, int n) {
        this.put(string, new Integer(n));
    }

    public void putLong(String string, long l) {
        this.put(string, new Long(l));
    }

    public void putIntArray(String string, int[] nArray) {
        Integer[] integerArray = new Integer[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            integerArray[i2] = new Integer(nArray[i2]);
        }
        this.put(string, integerArray);
    }

    public void putDouble(String string, double d2) {
        this.put(string, new Double(d2));
    }

    public void putDoubleArray(String string, double[] dArray) {
        Double[] doubleArray = new Double[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            doubleArray[i2] = new Double(dArray[i2]);
        }
        this.put(string, doubleArray);
    }

    public void putString(String string, String string2) {
        this.put(string, string2);
    }

    public void putStringArray(String string, String[] stringArray) {
        this.put(string, stringArray);
    }

    public void putBoolean(String string, boolean bl) {
        this.put(string, bl);
    }

    public void putBooleanArray(String string, boolean[] blArray) {
        Boolean[] booleanArray = new Boolean[blArray.length];
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            booleanArray[i2] = blArray[i2];
        }
        this.put(string, booleanArray);
    }

    public boolean contains(String string) {
        return this.myProps.containsKey(string);
    }

    public Object get(String string) {
        return this.myProps.get(string);
    }

    public int getInt(String string) {
        try {
            Integer n = (Integer)this.get(string);
            if (n != null) {
                return n;
            }
            return 0;
        }
        catch (ClassCastException classCastException) {
            return 0;
        }
    }

    public long getLong(String string) {
        try {
            Long l = (Long)this.get(string);
            if (l != null) {
                return l;
            }
            return 0L;
        }
        catch (ClassCastException classCastException) {
            return 0L;
        }
    }

    public int[] getIntArray(String string) {
        Integer[] integerArray;
        Object[] objectArray;
        try {
            objectArray = (Integer[])this.get(string);
            integerArray = objectArray == null ? new Integer[]{} : objectArray;
        }
        catch (ClassCastException classCastException) {
            integerArray = new Integer[]{};
        }
        objectArray = new int[integerArray.length];
        for (int i2 = 0; i2 < integerArray.length; ++i2) {
            objectArray[i2] = integerArray[i2];
        }
        return objectArray;
    }

    public double getDouble(String string) {
        try {
            Double d2 = (Double)this.get(string);
            if (d2 != null) {
                return d2;
            }
            return 0.0;
        }
        catch (ClassCastException classCastException) {
            return 0.0;
        }
    }

    public double[] getDoubleArray(String string) {
        Double[] doubleArray;
        Object[] objectArray;
        try {
            objectArray = (Double[])this.get(string);
            doubleArray = objectArray == null ? new Double[]{} : objectArray;
        }
        catch (ClassCastException classCastException) {
            doubleArray = new Double[]{};
        }
        objectArray = new double[doubleArray.length];
        for (int i2 = 0; i2 < doubleArray.length; ++i2) {
            objectArray[i2] = doubleArray[i2];
        }
        return objectArray;
    }

    public String getString(String string) {
        try {
            String string2 = (String)this.get(string);
            if (string2 == null) {
                return "";
            }
            return string2;
        }
        catch (ClassCastException classCastException) {
            return "";
        }
    }

    public String[] getStringArray(String string) {
        try {
            String[] stringArray = (String[])this.get(string);
            if (stringArray == null) {
                return new String[0];
            }
            return stringArray;
        }
        catch (ClassCastException classCastException) {
            return new String[0];
        }
    }

    public boolean[] getBooleanArray(String string) {
        Boolean[] booleanArray;
        Object[] objectArray;
        try {
            objectArray = (Boolean[])this.get(string);
            booleanArray = objectArray == null ? new Boolean[]{} : objectArray;
        }
        catch (ClassCastException classCastException) {
            booleanArray = new Boolean[]{};
        }
        objectArray = new boolean[booleanArray.length];
        for (int i2 = 0; i2 < booleanArray.length; ++i2) {
            objectArray[i2] = booleanArray[i2];
        }
        return objectArray;
    }

    public boolean getBoolean(String string) {
        try {
            Boolean bl = (Boolean)this.get(string);
            if (bl != null) {
                return bl;
            }
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[Properties: ");
        Iterator iterator = this.myProps.entrySet().iterator();
        while (iterator.hasNext()) {
            int n;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            buffer.append("\"").append(map$Entry.getKey().toString()).append("\"");
            buffer.append("=");
            if (map$Entry.getValue() instanceof String[]) {
                String[] stringArray = this.getStringArray(map$Entry.getKey().toString());
                buffer.append("[");
                for (n = 0; n < stringArray.length; ++n) {
                    buffer.append(stringArray[n]);
                    buffer.append(",");
                }
                buffer.append("] ");
                continue;
            }
            if (map$Entry.getValue() instanceof Integer[]) {
                int[] nArray = this.getIntArray(map$Entry.getKey().toString());
                buffer.append("[");
                for (n = 0; n < nArray.length; ++n) {
                    buffer.append(nArray[n]);
                    buffer.append(",");
                }
                buffer.append("] ");
                continue;
            }
            if (map$Entry.getValue() instanceof Boolean[]) {
                boolean[] blArray = this.getBooleanArray(map$Entry.getKey().toString());
                buffer.append("[");
                for (n = 0; n < blArray.length; ++n) {
                    buffer.append(blArray[n]);
                    buffer.append(",");
                }
                buffer.append("] ");
                continue;
            }
            if (map$Entry.getValue() instanceof Double[]) {
                double[] dArray = this.getDoubleArray(map$Entry.getKey().toString());
                buffer.append("[");
                for (n = 0; n < dArray.length; ++n) {
                    buffer.append(Double.toString((double)dArray[n]));
                    buffer.append(",");
                }
                buffer.append("] ");
                continue;
            }
            if (map$Entry.getValue() instanceof Boolean) {
                boolean bl = this.getBoolean(map$Entry.getKey().toString());
                buffer.append(Boolean.toString(bl));
                buffer.append(" ");
                continue;
            }
            if (map$Entry.getValue() instanceof Double) {
                double d2 = this.getDouble(map$Entry.getKey().toString());
                buffer.append(Double.toString((double)d2));
                buffer.append(" ");
                continue;
            }
            if (map$Entry.getValue() instanceof Integer) {
                int n2 = this.getInt(map$Entry.getKey().toString());
                buffer.append(n2);
                buffer.append(" ");
                continue;
            }
            buffer.append("\"");
            buffer.append(map$Entry.getValue().toString());
            buffer.append("\" ");
        }
        buffer.append("]");
        return buffer.toString();
    }

    public boolean setGridListSender(String string) {
        Object object = this.get("gridList");
        if (!(object instanceof IGridList)) {
            return false;
        }
        IGridList iGridList = (IGridList)object;
        iGridList.addSender(string);
        return true;
    }

    public static List getResourceProperties() {
        return RESOURCE_PROPERTIES;
    }

    public boolean originalsContainStringValue(List list, String string) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            if (!this.containsStringValue(new StringBuffer().append("original_").append(string2).toString(), string)) continue;
            return true;
        }
        return false;
    }

    public boolean containsStringValue(String string, String string2) {
        if (string == null || string2 == null) {
            throw new NullPointerException(new StringBuffer().append("HMIProperties#containsStringValue: null given for propertyName ='").append(string).append("', stringValue='").append(string2).append("'").toString());
        }
        Object object = this.get(string);
        if (object instanceof String) {
            return string2.equals((String)object);
        }
        if (object instanceof String[]) {
            String[] stringArray = (String[])object;
            int n = stringArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!string2.equals(stringArray[i2])) continue;
                return true;
            }
        }
        return false;
    }

    public Set replaceStringValue(List list, List list2) {
        HashSet hashSet = new HashSet();
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            Set set = this.replaceStringValue(list, string);
            hashSet.addAll(set);
        }
        return hashSet;
    }

    public Set replaceStringValue(List list, String string) {
        HashSet hashSet = new HashSet();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            if (!this.replaceStringValue(string2, new StringBuffer().append("original_").append(string2).toString(), string)) continue;
            hashSet.add(string2);
        }
        return hashSet;
    }

    public boolean replaceStringValue(String string, String string2, String string3) {
        if (string == null || string2 == null || string3 == null) {
            throw new NullPointerException(new StringBuffer().append("HMIProperties#containsStringValue: null given for currentName ='").append(string).append("', originalName='").append(string2).append("', replacement='").append(string3).append("'").toString());
        }
        Object object = this.get(string2);
        Object object2 = this.get(string);
        if (object instanceof String) {
            String string4 = (String)object;
            String string5 = (String)object2;
            if (!string3.equals(string4) || string3.equals(string5)) {
                return false;
            }
            this.put(string, string3);
            return true;
        }
        if (object instanceof String[]) {
            String[] stringArray = (String[])object;
            String[] stringArray2 = (String[])object2;
            boolean bl = false;
            int n = stringArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                String string6 = stringArray[i2];
                String string7 = stringArray2[i2];
                if (!string3.equals(string6) || string3.equals(string7)) continue;
                stringArray2[i2] = string3;
                bl = true;
            }
            return bl;
        }
        return false;
    }

    public void deepCopyFromTo(String string, String string2) {
        Object object = this.get(string);
        if (object == null) {
            return;
        }
        if (object instanceof String || object instanceof Double || object instanceof Long || object instanceof Integer || object instanceof Boolean) {
            this.put(string2, object);
        } else if (object instanceof String[]) {
            String[] stringArray = (String[])object;
            String[] stringArray2 = new String[stringArray.length];
            System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, stringArray.length);
            this.put(string2, stringArray2);
        } else {
            throw new UnsupportedOperationException(new StringBuffer().append("deep copy not yet implemented for class").append(object.getClass().getName()).toString());
        }
    }

    static {
        RESOURCE_PROPERTIES = Collections.unmodifiableList(Arrays.asList(new String[]{"providerLogo", "titleIcon", "decoratorUrl", "mapOverlayPath"}));
    }
}

