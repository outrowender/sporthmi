/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JDSIServiceMap
extends HashMap {
    private static final int INITIAL_INSTANCE_COUNT = 4;
    private static final int DISTINCTNAME_ITEMS = 0;
    private static final int ALL_ITEMS = 1;
    private static final int PENDING_ITEMS = 2;

    public JDSIServiceMap(int n) {
        super(n);
    }

    void ensureCapacity(JDSIManager.DSIInstance dSIInstance) {
        int n;
        JDSIManager.DSIInstance[] dSIInstanceArray = (JDSIManager.DSIInstance[])this.get(dSIInstance.getServiceName());
        for (n = 4; dSIInstance.getInstanceID() >= n; n *= 2) {
        }
        if (dSIInstanceArray == null) {
            dSIInstanceArray = new JDSIManager.DSIInstance[n];
            this.put(dSIInstance.getServiceName(), dSIInstanceArray);
        } else if (n > dSIInstanceArray.length) {
            JDSIManager.DSIInstance[] dSIInstanceArray2 = new JDSIManager.DSIInstance[n];
            System.arraycopy((Object)dSIInstanceArray, 0, (Object)dSIInstanceArray2, 0, dSIInstanceArray.length);
            this.put(dSIInstance.getServiceName(), dSIInstanceArray2);
        }
    }

    void mapDSIInstance(JDSIManager.DSIInstance dSIInstance) {
        if (dSIInstance != null) {
            this.ensureCapacity(dSIInstance);
            ((JDSIManager.DSIInstance[])this.get((Object)dSIInstance.getServiceName()))[dSIInstance.getInstanceID()] = dSIInstance;
        }
    }

    List getPendingDSIInstances() {
        return this.getDSIInstances(2);
    }

    private List getDSIInstances(int n) {
        ArrayList arrayList = new ArrayList(this.size() * (n == 1 ? 3 : 1));
        Iterator iterator = this.keySet().iterator();
        block0: while (iterator.hasNext()) {
            Object[] objectArray = (Object[])this.get(iterator.next());
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (objectArray[i2] == null) continue;
                if (n == 2) {
                    if (((JDSIManager.DSIInstance)objectArray[i2]).getPendingDSIHandler() == null) continue;
                    arrayList.add(objectArray[i2]);
                    continue;
                }
                arrayList.add(objectArray[i2]);
                if (n == 0) continue block0;
            }
        }
        return arrayList;
    }

    public String[][] getDSIInstanceInfo() {
        List list = this.getDSIInstances(1);
        String[][] stringArray = null;
        if (list != null) {
            stringArray = new String[list.size()][2];
            JDSIManager.DSIInstance dSIInstance = null;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                dSIInstance = (JDSIManager.DSIInstance)list.get(i2);
                if (dSIInstance == null) continue;
                stringArray[i2][0] = dSIInstance.getServiceName();
                stringArray[i2][1] = Integer.toString(dSIInstance.getInstanceID());
            }
        }
        return stringArray;
    }

    public String[][] getDSIInstanceVersionInfo() {
        List list = this.getDSIInstances(0);
        String[][] stringArray = null;
        if (list != null) {
            stringArray = new String[list.size()][2];
            JDSIManager.DSIInstance dSIInstance = null;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                String string;
                dSIInstance = (JDSIManager.DSIInstance)list.get(i2);
                if (dSIInstance == null) continue;
                String string2 = dSIInstance.getServiceName();
                try {
                    Field field = dSIInstance.getService().getClass().getField("VERSION");
                    string = (String)field.get(null);
                }
                catch (Exception exception) {
                    string = "-";
                }
                stringArray[i2][0] = string2.substring(string2.lastIndexOf(46) + 1);
                stringArray[i2][1] = string;
            }
            Arrays.sort((Object[])stringArray, new DSINameComparer());
        }
        if (stringArray == null) {
            stringArray = new String[0][0];
        }
        return stringArray;
    }

    JDSIManager.DSIInstance getDSIInstance(String string, int n) {
        JDSIManager.DSIInstance[] dSIInstanceArray = (JDSIManager.DSIInstance[])this.get(string);
        if (dSIInstanceArray != null && dSIInstanceArray.length > n) {
            return dSIInstanceArray[n];
        }
        return null;
    }

    private static class DSINameComparer
    implements Comparator {
        private DSINameComparer() {
        }

        public int compare(Object object, Object object2) {
            int n = 0;
            if (object == null && object2 == null) {
                n = 0;
            } else if (object == null) {
                n = 1;
            } else if (object2 == null) {
                n = -1;
            } else {
                try {
                    String string = ((String[])object)[0];
                    String string2 = ((String[])object)[0];
                    n = string.compareToIgnoreCase(string2);
                }
                catch (ClassCastException classCastException) {
                    n = 0;
                }
            }
            return n;
        }
    }
}

