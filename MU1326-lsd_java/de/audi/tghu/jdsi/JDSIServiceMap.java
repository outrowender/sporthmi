/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIManager$DSIInstance;
import de.audi.tghu.jdsi.JDSIServiceMap$DSINameComparer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JDSIServiceMap
extends HashMap {
    private static final int INITIAL_INSTANCE_COUNT;
    private static final int DISTINCTNAME_ITEMS;
    private static final int ALL_ITEMS;
    private static final int PENDING_ITEMS;

    public JDSIServiceMap(int n) {
        super(n);
    }

    void ensureCapacity(JDSIManager$DSIInstance jDSIManager$DSIInstance) {
        int n;
        JDSIManager$DSIInstance[] jDSIManager$DSIInstanceArray = (JDSIManager$DSIInstance[])this.get(jDSIManager$DSIInstance.getServiceName());
        for (n = 4; jDSIManager$DSIInstance.getInstanceID() >= n; n *= 2) {
        }
        if (jDSIManager$DSIInstanceArray == null) {
            jDSIManager$DSIInstanceArray = new JDSIManager$DSIInstance[n];
            this.put(jDSIManager$DSIInstance.getServiceName(), jDSIManager$DSIInstanceArray);
        } else if (n > jDSIManager$DSIInstanceArray.length) {
            JDSIManager$DSIInstance[] jDSIManager$DSIInstanceArray2 = new JDSIManager$DSIInstance[n];
            System.arraycopy((Object)jDSIManager$DSIInstanceArray, 0, (Object)jDSIManager$DSIInstanceArray2, 0, jDSIManager$DSIInstanceArray.length);
            this.put(jDSIManager$DSIInstance.getServiceName(), jDSIManager$DSIInstanceArray2);
        }
    }

    void mapDSIInstance(JDSIManager$DSIInstance jDSIManager$DSIInstance) {
        if (jDSIManager$DSIInstance != null) {
            this.ensureCapacity(jDSIManager$DSIInstance);
            ((JDSIManager$DSIInstance[])this.get((Object)jDSIManager$DSIInstance.getServiceName()))[jDSIManager$DSIInstance.getInstanceID()] = jDSIManager$DSIInstance;
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
                    if (((JDSIManager$DSIInstance)objectArray[i2]).getPendingDSIHandler() == null) continue;
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
            JDSIManager$DSIInstance jDSIManager$DSIInstance = null;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                jDSIManager$DSIInstance = (JDSIManager$DSIInstance)list.get(i2);
                if (jDSIManager$DSIInstance == null) continue;
                stringArray[i2][0] = jDSIManager$DSIInstance.getServiceName();
                stringArray[i2][1] = Integer.toString(jDSIManager$DSIInstance.getInstanceID());
            }
        }
        return stringArray;
    }

    public String[][] getDSIInstanceVersionInfo() {
        List list = this.getDSIInstances(0);
        String[][] stringArray = null;
        if (list != null) {
            stringArray = new String[list.size()][2];
            JDSIManager$DSIInstance jDSIManager$DSIInstance = null;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                String string;
                jDSIManager$DSIInstance = (JDSIManager$DSIInstance)list.get(i2);
                if (jDSIManager$DSIInstance == null) continue;
                String string2 = jDSIManager$DSIInstance.getServiceName();
                try {
                    Field field = jDSIManager$DSIInstance.getService().getClass().getField("VERSION");
                    string = (String)field.get(null);
                }
                catch (Exception exception) {
                    string = "-";
                }
                stringArray[i2][0] = string2.substring(string2.lastIndexOf(46) + 1);
                stringArray[i2][1] = string;
            }
            Arrays.sort((Object[])stringArray, new JDSIServiceMap$DSINameComparer(null));
        }
        if (stringArray == null) {
            stringArray = new String[0][0];
        }
        return stringArray;
    }

    JDSIManager$DSIInstance getDSIInstance(String string, int n) {
        JDSIManager$DSIInstance[] jDSIManager$DSIInstanceArray = (JDSIManager$DSIInstance[])this.get(string);
        if (jDSIManager$DSIInstanceArray != null && jDSIManager$DSIInstanceArray.length > n) {
            return jDSIManager$DSIInstanceArray[n];
        }
        return null;
    }
}

