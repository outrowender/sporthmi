/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc;

import java.lang.reflect.Field;

public final class VersionInfo {
    static /* synthetic */ Class class$java$lang$String;

    public static String getDSIServiceVersion(Class clazz) {
        try {
            Field field = clazz.getField("VERSION");
            if ((class$java$lang$String == null ? (class$java$lang$String = VersionInfo.class$("java.lang.String")) : class$java$lang$String).equals(field.getType())) {
                return (String)field.get(null);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return null;
    }

    public static String getName() {
        return "MIB_DSI_2017_KW13";
    }

    public static String getNickname() {
        return "B2.69";
    }

    public static String getVersion() {
        return "17.13.0";
    }

    public static String getBuildDate() {
        return "28.03.2017 15:20";
    }

    public static String getVendor() {
        return "Volkswagen AG";
    }

    public static String asString() {
        return "DSI-17.13.0.E20170328-b2_69";
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }
}

