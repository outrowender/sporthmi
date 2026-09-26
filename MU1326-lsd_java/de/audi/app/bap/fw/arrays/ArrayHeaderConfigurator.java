/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.vw.mib.bap.datatypes.ArrayHeader;

public final class ArrayHeaderConfigurator {
    public static final int POS_ID_FIRST_ELEMENT;
    public static final boolean DO_TRANSMIT_POS;
    public static final boolean DO_NOT_TRANSMIT_POS;
    private final ArrayHeader arrayHeader;

    public static ArrayHeaderConfigurator forThis(ArrayHeader arrayHeader) {
        return new ArrayHeaderConfigurator(arrayHeader);
    }

    private ArrayHeaderConfigurator(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public void getElements(int n, int n2, boolean bl) {
        this.arrayHeader.mode.arrayDirectionIsBackward = false;
        this.arrayHeader.mode.arrayPositionIsTransmitted = true;
        this.arrayHeader.mode.indexSize16BitForStartElements = bl;
        this.arrayHeader.mode.shift = false;
        this.arrayHeader.setRecordAddress(n2);
        this.arrayHeader.start = 0;
        this.arrayHeader.elements = n;
    }

    public void getFollowingElements(int n, int n2, int n3, boolean bl) {
        this.arrayHeader.mode.arrayDirectionIsBackward = false;
        this.arrayHeader.mode.arrayPositionIsTransmitted = true;
        this.arrayHeader.mode.indexSize16BitForStartElements = bl;
        this.arrayHeader.mode.shift = true;
        this.arrayHeader.setRecordAddress(n3);
        this.arrayHeader.start = n;
        this.arrayHeader.elements = n2;
    }

    public void makeSetGetRequest(int n, int n2, boolean bl, boolean bl2) {
        this.arrayHeader.mode.arrayDirectionIsBackward = false;
        this.arrayHeader.mode.arrayPositionIsTransmitted = bl2;
        this.arrayHeader.mode.indexSize16BitForStartElements = bl;
        this.arrayHeader.mode.shift = false;
        this.arrayHeader.setRecordAddress(n2);
        this.arrayHeader.start = n;
        this.arrayHeader.elements = 1;
    }
}

