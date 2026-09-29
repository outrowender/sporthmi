/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

final class SDSDebugMsgQueueVisibleSizeEnum {
    private static final int VALUE_SMALL;
    private static final int VALUE_MEDIUM;
    private static final int VALUE_LARGE;
    private static final int VALUE_XL;
    static final SDSDebugMsgQueueVisibleSizeEnum SMALL;
    static final SDSDebugMsgQueueVisibleSizeEnum MEDIUM;
    static final SDSDebugMsgQueueVisibleSizeEnum LARGE;
    static final SDSDebugMsgQueueVisibleSizeEnum XL;
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

    static {
        SMALL = new SDSDebugMsgQueueVisibleSizeEnum("SMALL", 3);
        MEDIUM = new SDSDebugMsgQueueVisibleSizeEnum("MEDIUM", 8);
        LARGE = new SDSDebugMsgQueueVisibleSizeEnum("LARGE", 13);
        XL = new SDSDebugMsgQueueVisibleSizeEnum("XL", 18);
    }
}

