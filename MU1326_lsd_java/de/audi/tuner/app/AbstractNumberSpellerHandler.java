/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public abstract class AbstractNumberSpellerHandler {
    private SimpleIntObjectMap validKeys;

    public AbstractNumberSpellerHandler() {
        this.initMap();
    }

    protected final void initMap() {
        this.validKeys = new SimpleIntObjectMap(30);
        this.validKeys.add(0, new SimpleIntIntMap(10));
    }

    protected void addNumber(int n) {
        SimpleIntIntMap simpleIntIntMap;
        int n2 = n % 10;
        for (int i2 = n / 10; i2 != 0; i2 /= 10) {
            simpleIntIntMap = (SimpleIntIntMap)this.validKeys.get(i2);
            if (simpleIntIntMap == null) {
                simpleIntIntMap = new SimpleIntIntMap(10);
                this.validKeys.add(i2, simpleIntIntMap);
            }
            simpleIntIntMap.add(n2, 0);
            n2 = i2 % 10;
        }
        simpleIntIntMap = (SimpleIntIntMap)this.validKeys.get(0);
        simpleIntIntMap.add(n2, 0);
    }

    protected int[] getValidNextDigitsForPrefix(int n) {
        SimpleIntIntMap simpleIntIntMap = (SimpleIntIntMap)this.validKeys.get(n);
        if (simpleIntIntMap == null) {
            return new int[0];
        }
        return simpleIntIntMap.getKeys();
    }

    protected String getValidNextDigitsForPrefixAsString(int n) {
        int[] nArray = this.getValidNextDigitsForPrefix(n);
        Buffer buffer = new Buffer(10);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            buffer.append(String.valueOf(nArray[i2]));
        }
        return buffer.toString();
    }
}

