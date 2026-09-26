/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays.fastlist;

import org.dsi.ifc.kombifastlist.ArrayHeader;

public class ArrayUtilsFastList {
    private static final int ARRAY_HEADER_MODE_SHIFT;
    private static final int ARRAY_HEADER_MODE_DIRECTION_BACKWARD;
    private static final int ARRAY_HEADER_MODE_ARRAY_POSITION_TRANSMITTED;
    private static final int ARRAY_HEADER_MODE_INDEX_SIZE_16BIT;
    private static final int ARRAY_HEADER_MODE_ARRAY_POSITION_CENTERED;

    public static ArrayHeader createFullRangeUpdateArrayHeader(boolean bl) {
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.mode = bl ? 8 : 0;
        arrayHeader.recordAddress = 15;
        arrayHeader.start = 0L;
        arrayHeader.relativeJump = 0;
        arrayHeader.elements = -65536;
        arrayHeader.jobModification = 0;
        arrayHeader.jobID = 0;
        arrayHeader.jobPriority = 0;
        return arrayHeader;
    }
}

