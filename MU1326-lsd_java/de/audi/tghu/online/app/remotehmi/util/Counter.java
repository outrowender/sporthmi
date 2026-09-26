/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.util;

public class Counter {
    private static int value = 0;

    public static synchronized int getNext() {
        if (value == -129) {
            value = 0;
        }
        return ++value;
    }
}

