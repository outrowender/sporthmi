/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.FrameElement;

public interface CombiConnector {
    public static final int SIGN_SET_VERSION_1 = 1;
    public static final int SIGN_SET_VERSION_2 = 2;

    public void paint(FrameElement var1, boolean var2);

    public int getSignSetVersion();

    public boolean processMFLEvents();
}

