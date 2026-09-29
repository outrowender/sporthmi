/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.constants;

public class SwitchContextEnum {
    public static final SwitchContextEnum NoReason = new SwitchContextEnum("-");
    public static final SwitchContextEnum EnterMapScreen = new SwitchContextEnum("EnterMapScreen");
    public static final SwitchContextEnum ShowRouteBriefing = new SwitchContextEnum("ShowRouteBriefing");
    public static final SwitchContextEnum ShowInMap = new SwitchContextEnum("ShowInMap");
    public static final SwitchContextEnum ContextRefresh = new SwitchContextEnum("ContextRefresh");
    public static final SwitchContextEnum ShowLastTmc = new SwitchContextEnum("ShowLastTmc");
    public final String description;

    private SwitchContextEnum(String string) {
        this.description = string;
    }

    public String toString() {
        return this.description;
    }
}

