/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class MediaPlayStateEnumeration
extends Enum {
    public static final MediaPlayStateEnumeration PLAY = new MediaPlayStateEnumeration("PLAY", 0);
    public static final MediaPlayStateEnumeration PAUSE = new MediaPlayStateEnumeration("PAUSE", 1);
    public static final MediaPlayStateEnumeration FAST_BACKWARD = new MediaPlayStateEnumeration("FAST_BACKWARD", 2);
    public static final MediaPlayStateEnumeration FAST_FORWARD = new MediaPlayStateEnumeration("FAST_FORWARD", 3);
    public static final MediaPlayStateEnumeration NO_TRACKS = new MediaPlayStateEnumeration("NO_TRACKS", 4);
    public static final MediaPlayStateEnumeration LOADING = new MediaPlayStateEnumeration("LOADING", 5);

    protected MediaPlayStateEnumeration(String string, int n) {
        super(string, n);
    }

    public static MediaPlayStateEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return PLAY;
            }
            case 1: {
                return PAUSE;
            }
            case 2: {
                return FAST_BACKWARD;
            }
            case 3: {
                return FAST_FORWARD;
            }
            case 4: {
                return NO_TRACKS;
            }
            case 5: {
                return LOADING;
            }
        }
        return null;
    }
}

