/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public interface DSITIMTunerListener
extends DSIListener {
    public void updateTIMMessageList(TIMMessage[] var1, int var2);

    public void updateTIMStatus(TIMStatus var1, int var2);

    public void updateTIMMemoUsage(TIMMemoUsage var1, int var2);

    public void updateTIMAvailable(int var1, int var2);

    public void playback(int var1);
}

