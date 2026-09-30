/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.hmi.KbdService;
import de.audi.atip.statemachine.sds.TTSASR;

public interface SMServices {
    public KbdService getKeyboardService();

    public TTSASR getSDSService();

    public void showPartialPopup(int var1);

    public void hidePartialPopup(int var1);

    public void enterJointUse(int var1, int var2);

    public void leaveJointUse(int var1, int var2);

    public int getJointUseCount();

    public void setJumpBackPoint(int var1);

    public void addContext(long var1);

    public void removeContext(long var1);

    public void pushDrawerIDs(long var1, long var3);

    public void popDrawerIDs();

    public void addScreenAnimation(int var1);

    public void setColor(int var1);

    public void setScreenMode(int var1);
}

