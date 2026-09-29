/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.FrameElement;

public interface CombiConnector {
    public static final int SIGN_SET_VERSION_1;
    public static final int SIGN_SET_VERSION_2;

    default public void paint(FrameElement frameElement, boolean bl) {
    }

    default public int getSignSetVersion() {
    }

    default public boolean processMFLEvents() {
    }
}

