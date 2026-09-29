/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.constants;

public class PropertyEnum {
    public static final PropertyEnum MapType = new PropertyEnum("MapType");
    public static final PropertyEnum MapOrientation = new PropertyEnum("MapOrientation");
    public static final PropertyEnum TrafficFlow = new PropertyEnum("TrafficFlow");
    public static final PropertyEnum MapViewType = new PropertyEnum("MapViewType");
    public final String name;

    private PropertyEnum(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

