/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class ListStateEnumeration
extends Enum {
    public static final ListStateEnumeration READY = new ListStateEnumeration("READY", 0);
    public static final ListStateEnumeration LOADING = new ListStateEnumeration("LOADING", 1);
    public static final ListStateEnumeration NO_DATA = new ListStateEnumeration("NO_DATA", 2);

    protected ListStateEnumeration(String string, int n) {
        super(string, n);
    }

    public static ListStateEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return READY;
            }
            case 1: {
                return LOADING;
            }
            case 2: {
                return NO_DATA;
            }
        }
        return null;
    }
}

