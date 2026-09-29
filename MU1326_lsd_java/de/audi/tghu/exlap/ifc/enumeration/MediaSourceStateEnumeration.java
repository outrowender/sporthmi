/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class MediaSourceStateEnumeration
extends Enum {
    public static final MediaSourceStateEnumeration LOADING = new MediaSourceStateEnumeration("LOADING", 0);
    public static final MediaSourceStateEnumeration READY = new MediaSourceStateEnumeration("READY", 1);
    public static final MediaSourceStateEnumeration ACTIVE = new MediaSourceStateEnumeration("ACTIVE", 2);
    public static final MediaSourceStateEnumeration NO_PLAYABLE_FILE = new MediaSourceStateEnumeration("NO_PLAYABLE_FILE", 3);
    public static final MediaSourceStateEnumeration NO_MEDIA_INSERTED = new MediaSourceStateEnumeration("NO_MEDIA_INSERTED", 4);
    public static final MediaSourceStateEnumeration ERROR = new MediaSourceStateEnumeration("ERROR", 5);
    public static final MediaSourceStateEnumeration UNAVAILABLE = new MediaSourceStateEnumeration("UNAVAILABLE", 6);

    protected MediaSourceStateEnumeration(String string, int n) {
        super(string, n);
    }

    public static MediaSourceStateEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return LOADING;
            }
            case 1: {
                return READY;
            }
            case 2: {
                return ACTIVE;
            }
            case 3: {
                return NO_PLAYABLE_FILE;
            }
            case 4: {
                return NO_MEDIA_INSERTED;
            }
            case 5: {
                return ERROR;
            }
            case 6: {
                return UNAVAILABLE;
            }
        }
        return null;
    }
}

