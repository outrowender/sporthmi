/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sfa;

import org.dsi.ifc.base.DSIListener;

public interface DSISFAListener
extends DSIListener {
    public void updateAudioRequest(int var1, int var2);

    public void updateDisplayRequest(int var1, int var2);

    public void responseKeyTouchEvaluation(int var1, int var2);

    public void responseDisplayNotVisible(int var1);
}

