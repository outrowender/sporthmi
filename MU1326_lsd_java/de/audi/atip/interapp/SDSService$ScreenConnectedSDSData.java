/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SDSService$ScreenConnectedSDSData {
    private int smallStageType;
    private static final Map SMALL_STAGE_TYPE_TO_STR = SDSService$ScreenConnectedSDSData.createSmallStageTypeToStrMap();

    private static Map createSmallStageTypeToStrMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(new Integer(0), "Abbreviating");
        hashMap.put(new Integer(1), "Omission");
        hashMap.put(new Integer(2), "Replacing");
        hashMap.put(new Integer(3), "Screenshot");
        hashMap.put(new Integer(4), "Canceling");
        hashMap.put(new Integer(6), "No Change");
        hashMap.put(new Integer(7), "Wrap");
        return Collections.unmodifiableMap(hashMap);
    }

    public int getSmallStageType() {
        return this.smallStageType;
    }

    public void setSmallStageType(int n) {
        this.smallStageType = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("{ ");
        buffer.append("smallStageType: ").append(SMALL_STAGE_TYPE_TO_STR.get(new Integer(this.smallStageType))).append(" (").append(this.smallStageType).append(")");
        buffer.append(" }");
        return buffer.toString();
    }
}

