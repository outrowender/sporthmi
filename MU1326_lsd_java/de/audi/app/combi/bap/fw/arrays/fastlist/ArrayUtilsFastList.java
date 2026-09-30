/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays.fastlist;

import org.dsi.ifc.kombifastlist.ArrayHeader;

public class ArrayUtilsFastList {
    private static final int ARRAY_HEADER_MODE_SHIFT = 1;
    private static final int ARRAY_HEADER_MODE_DIRECTION_BACKWARD = 2;
    private static final int ARRAY_HEADER_MODE_ARRAY_POSITION_TRANSMITTED = 4;
    private static final int ARRAY_HEADER_MODE_INDEX_SIZE_16BIT = 8;
    private static final int ARRAY_HEADER_MODE_ARRAY_POSITION_CENTERED = 16;

    public static ArrayHeader createFullRangeUpdateArrayHeader(boolean bl) {
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.mode = bl ? 8 : 0;
        arrayHeader.recordAddress = 15;
        arrayHeader.start = 0L;
        arrayHeader.relativeJump = 0;
        arrayHeader.elements = 65535;
        arrayHeader.jobModification = 0;
        arrayHeader.jobID = 0;
        arrayHeader.jobPriority = 0;
        return arrayHeader;
    }
}

