/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.Strings;

public final class Classes {
    public static String getShortClassName(Class clazz) {
        String string;
        String string2 = clazz.getName();
        String string3 = "";
        Package package_ = clazz.getPackage();
        if (package_ != null && !Strings.isNullOrEmpty(string = package_.getName())) {
            string3 = new StringBuffer().append(string).append(".").toString();
        }
        String string4 = !Strings.isNullOrEmpty(string3) && string2.startsWith(string3) ? string2.substring(string3.length()) : string2;
        return string4;
    }
}

