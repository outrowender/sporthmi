/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class NotPlayableReasonEnumeration
extends Enum {
    public static final NotPlayableReasonEnumeration PLAYABLE = new NotPlayableReasonEnumeration("PLAYABLE", 0);
    public static final NotPlayableReasonEnumeration DRM = new NotPlayableReasonEnumeration("DRM", 1);
    public static final NotPlayableReasonEnumeration CORRUPT = new NotPlayableReasonEnumeration("CORRUPT", 2);
    public static final NotPlayableReasonEnumeration DEADLINK = new NotPlayableReasonEnumeration("DEADLINK", 3);
    public static final NotPlayableReasonEnumeration IMPORT = new NotPlayableReasonEnumeration("IMPORT", 4);

    protected NotPlayableReasonEnumeration(String string, int n) {
        super(string, n);
    }

    public static NotPlayableReasonEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return PLAYABLE;
            }
            case 1: {
                return DRM;
            }
            case 2: {
                return CORRUPT;
            }
            case 3: {
                return DEADLINK;
            }
            case 4: {
                return IMPORT;
            }
        }
        return null;
    }
}

