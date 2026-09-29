/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

public class MixedListConstants$TollgateType_enum {
    private int type;
    public static final MixedListConstants$TollgateType_enum ETC_UNKNOWN = new MixedListConstants$TollgateType_enum(0);
    public static final MixedListConstants$TollgateType_enum ETC_DEDICATED = new MixedListConstants$TollgateType_enum(1);
    public static final MixedListConstants$TollgateType_enum ETC_AND_GENERAL_COMBINED = new MixedListConstants$TollgateType_enum(2);
    public static final MixedListConstants$TollgateType_enum ETC_GENERAL_ONLY = new MixedListConstants$TollgateType_enum(3);
    public static final MixedListConstants$TollgateType_enum ETC_LANE_OMIT = new MixedListConstants$TollgateType_enum(4);
    public static final MixedListConstants$TollgateType_enum ETC_LANE_CLOSED = new MixedListConstants$TollgateType_enum(5);
    public static final MixedListConstants$TollgateType_enum ETC_LANE_THROUGH = new MixedListConstants$TollgateType_enum(6);

    public int getType() {
        return this.type;
    }

    private MixedListConstants$TollgateType_enum(int n) {
        this.type = n;
    }
}

