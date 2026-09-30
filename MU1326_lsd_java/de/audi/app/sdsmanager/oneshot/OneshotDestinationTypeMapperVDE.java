/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;

public class OneshotDestinationTypeMapperVDE
implements IOneshotDestinationTypeMapper {
    protected int[][] oneshotDestinationTypeMapping = new int[][]{{3, 0}, {12, 0}, {1, 0}, {22, 0}, {2, 1}, {15, 1}, {13, 1}, {10, 2}, {7, 2}};

    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotDestinationTypeMapping);
    }
}

