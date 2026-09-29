/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class ImportGPXResultEnumeration
extends Enum {
    public static final ImportGPXResultEnumeration IMPORTED = new ImportGPXResultEnumeration("IMPORTED", 0);
    public static final ImportGPXResultEnumeration ABORTED = new ImportGPXResultEnumeration("ABORTED", 1);
    public static final ImportGPXResultEnumeration ERROR = new ImportGPXResultEnumeration("ERROR", 2);
    public static final ImportGPXResultEnumeration GUIDANCE_STARTED = new ImportGPXResultEnumeration("GUIDANCE_STARTED", 3);

    protected ImportGPXResultEnumeration(String string, int n) {
        super(string, n);
    }

    public static ImportGPXResultEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return IMPORTED;
            }
            case 1: {
                return ABORTED;
            }
            case 2: {
                return ERROR;
            }
            case 3: {
                return GUIDANCE_STARTED;
            }
        }
        return null;
    }
}

