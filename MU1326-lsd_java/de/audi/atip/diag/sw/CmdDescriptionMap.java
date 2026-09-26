/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag.sw;

import java.util.HashMap;

public class CmdDescriptionMap {
    private final HashMap map;

    public CmdDescriptionMap() {
        this.map = new HashMap();
    }

    public CmdDescriptionMap(int n) {
        this.map = new HashMap(n);
    }

    public CmdDescriptionMap(String[] stringArray, String[] stringArray2) {
        if (stringArray != null && stringArray2 != null) {
            this.map = new HashMap(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length && i2 != stringArray2.length; ++i2) {
                this.map.put(stringArray[i2], stringArray2[i2]);
            }
        } else {
            this.map = new HashMap();
        }
    }

    public void put(String string, String string2) {
        this.map.put(string, string2);
    }

    public String get(String string) {
        return (String)this.map.get(string);
    }

    public String[] getKeys() {
        Object[] objectArray = this.map.keySet().toArray();
        String[] stringArray = new String[objectArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = (String)objectArray[i2];
        }
        return stringArray;
    }
}

