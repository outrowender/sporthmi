/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

final class SDSDebugMsgQueueVisibleSizeEnum {
    private static final int VALUE_SMALL = 3;
    private static final int VALUE_MEDIUM = 8;
    private static final int VALUE_LARGE = 13;
    private static final int VALUE_XL = 18;
    static final SDSDebugMsgQueueVisibleSizeEnum SMALL = new SDSDebugMsgQueueVisibleSizeEnum("SMALL", 3);
    static final SDSDebugMsgQueueVisibleSizeEnum MEDIUM = new SDSDebugMsgQueueVisibleSizeEnum("MEDIUM", 8);
    static final SDSDebugMsgQueueVisibleSizeEnum LARGE = new SDSDebugMsgQueueVisibleSizeEnum("LARGE", 13);
    static final SDSDebugMsgQueueVisibleSizeEnum XL = new SDSDebugMsgQueueVisibleSizeEnum("XL", 18);
    private static Map indexToEnumMap;
    private static int largestSizeValue;
    private final int index;
    private final String name;
    private final int value;

    private SDSDebugMsgQueueVisibleSizeEnum(String string, int n) {
        if (indexToEnumMap == null) {
            indexToEnumMap = new HashMap();
            largestSizeValue = 0;
        }
        this.index = indexToEnumMap.size();
        this.name = string;
        this.value = n;
        largestSizeValue = Math.max(largestSizeValue, this.value);
        indexToEnumMap.put(new Integer(this.index), this);
    }

    static int getLargestSizeValue() {
        return largestSizeValue;
    }

    int getSizeValue() {
        return this.value;
    }

    SDSDebugMsgQueueVisibleSizeEnum getNextSize() {
        Integer n = new Integer((this.index + 1) % indexToEnumMap.size());
        return indexToEnumMap.containsKey(n) ? (SDSDebugMsgQueueVisibleSizeEnum)indexToEnumMap.get(n) : MEDIUM;
    }

    public String toString() {
        return new Buffer().append(this.name).append(" (").append(this.value).append(')').toString();
    }
}

