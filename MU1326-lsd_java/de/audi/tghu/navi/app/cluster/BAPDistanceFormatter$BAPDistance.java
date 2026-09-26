/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.tghu.navi.app.cluster.BAPDistanceFormatter$1;
import de.esolutions.fw.util.commons.Buffer;

public class BAPDistanceFormatter$BAPDistance {
    private final int value;
    private final int unit;
    private final int meters;
    public static final BAPDistanceFormatter$BAPDistance INVALID = new BAPDistanceFormatter$BAPDistance(0, 0, 0);
    public static final BAPDistanceFormatter$BAPDistance INVALID_HANDELED_BY_APPCOMBIBAP = new BAPDistanceFormatter$BAPDistance(-1, 0, -1);

    private BAPDistanceFormatter$BAPDistance(int n, int n2, int n3) {
        this.value = n;
        this.unit = n2;
        this.meters = n3;
    }

    public int getValue() {
        return this.value;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("BAPDistance[value = ");
        buffer.append(this.value);
        buffer.append(", unit = ");
        buffer.append(this.unit);
        buffer.append("]");
        return buffer.toString();
    }

    public static BAPDistanceFormatter$BAPDistance invalid() {
        return INVALID;
    }

    public boolean isMaximumMapScale() {
        return this.value == -16842752;
    }

    static /* synthetic */ int access$000(BAPDistanceFormatter$BAPDistance bAPDistanceFormatter$BAPDistance) {
        return bAPDistanceFormatter$BAPDistance.meters;
    }

    /* synthetic */ BAPDistanceFormatter$BAPDistance(int n, int n2, int n3, BAPDistanceFormatter$1 bAPDistanceFormatter$1) {
        this(n, n2, n3);
    }
}

