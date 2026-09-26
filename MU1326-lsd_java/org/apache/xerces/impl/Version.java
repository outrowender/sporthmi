/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

public class Version {
    public static String fVersion = "@@VERSION@@";
    private static final String fImmutableVersion;

    public static String getVersion() {
        return "@@VERSION@@";
    }

    public static void main(String[] stringArray) {
        System.out.println(fVersion);
    }
}

