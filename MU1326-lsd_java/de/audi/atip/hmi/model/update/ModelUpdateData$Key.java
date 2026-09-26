/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.update;

public class ModelUpdateData$Key {
    public static final ModelUpdateData$Key INDEX = new ModelUpdateData$Key("KEY_INDEX");
    public static final ModelUpdateData$Key UNIQUEID = new ModelUpdateData$Key("KEY_UNIQUEID");
    public static final ModelUpdateData$Key PARENT_UNIQUEID = new ModelUpdateData$Key("KEY_PARENT_UNIQUEID");
    public static final ModelUpdateData$Key REQUESTID = new ModelUpdateData$Key("KEY_REQUESTID");
    public static final ModelUpdateData$Key COUNT = new ModelUpdateData$Key("KEY_COUNT");
    public static final ModelUpdateData$Key ITEMID = new ModelUpdateData$Key("KEY_ITEMID");
    public static final ModelUpdateData$Key FOCUS_ADVICE = new ModelUpdateData$Key("KEY_FOCUS_ADVICE");
    public static final ModelUpdateData$Key TRIGGER = new ModelUpdateData$Key("KEY_TRIGGER");
    private final String key;

    private ModelUpdateData$Key(String string) {
        this.key = string;
    }

    public String toString() {
        return this.key;
    }
}

