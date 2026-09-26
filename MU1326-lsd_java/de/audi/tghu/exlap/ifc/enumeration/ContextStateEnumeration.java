/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class ContextStateEnumeration
extends Enum {
    public static final ContextStateEnumeration UNAVAILABLE = new ContextStateEnumeration("UNAVAILABLE", 0);
    public static final ContextStateEnumeration INITIALIZING = new ContextStateEnumeration("INITIALIZING", 1);
    public static final ContextStateEnumeration READY = new ContextStateEnumeration("READY", 2);
    public static final ContextStateEnumeration TEMPORARILY_UNAVAILABLE = new ContextStateEnumeration("TEMPORARILY_UNAVAILABLE", 3);
    public static final ContextStateEnumeration ERROR = new ContextStateEnumeration("ERROR", 4);
    public static final ContextStateEnumeration SUSPENDED = new ContextStateEnumeration("SUSPENDED", 5);

    protected ContextStateEnumeration(String string, int n) {
        super(string, n);
    }

    public static ContextStateEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return UNAVAILABLE;
            }
            case 1: {
                return INITIALIZING;
            }
            case 2: {
                return READY;
            }
            case 3: {
                return TEMPORARILY_UNAVAILABLE;
            }
            case 4: {
                return ERROR;
            }
            case 5: {
                return SUSPENDED;
            }
        }
        return null;
    }
}

