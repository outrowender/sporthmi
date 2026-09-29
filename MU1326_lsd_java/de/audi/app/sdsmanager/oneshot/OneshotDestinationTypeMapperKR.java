/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;

public class OneshotDestinationTypeMapperKR
implements IOneshotDestinationTypeMapper {
    protected int[][] oneshotDestinationTypeMapping = new int[][]{{38, 0}, {3, 1}, {12, 1}, {33, 2}, {15, 3}, {13, 3}, {40, 3}, {41, 3}, {7, 4}};

    @Override
    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotDestinationTypeMapping);
    }
}

