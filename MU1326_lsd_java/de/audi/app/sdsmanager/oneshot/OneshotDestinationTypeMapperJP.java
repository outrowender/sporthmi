/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;

public class OneshotDestinationTypeMapperJP
implements IOneshotDestinationTypeMapper {
    protected int[][] oneshotDestinationTypeMapping = new int[][]{{32, 0}, {3, 1}, {12, 1}, {33, 2}, {34, 3}, {15, 3}, {13, 3}, {7, 4}};

    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotDestinationTypeMapping);
    }
}

