/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.AbstractSDSApplicationService;
import org.dsi.ifc.global.ResourceLocator;

public interface PhoneService
extends AbstractSDSApplicationService {
    public static final int NUMBER_MAX_LENGTH = 40;
    public static final int CALLSTACK_NONE = -1;
    public static final int CALLSTACK_LAST_CALLS = 0;
    public static final int CALLSTACK_MISSED_CALLS = 1;
    public static final int CALLSTACK_RECEIVED_CALLS = 2;
    public static final int CALLSTACK_COMBINED_CALLS = 3;
    public static final int CALLSTACK_SMS = 4;
    public static final int CALL_STACK_SCREEN_SIZE = 5;
    public static final int POWERSTATE_OK = 0;
    public static final int POWERSTATE_NO_PHONE = 1;
    public static final int POWERSTATE_NO_SIM = 2;
    public static final int POWERSTATE_ERROR = 3;
    public static final int PIN_MAX_LENGTH = 8;

    public void dialNumber(String var1, String var2, boolean var3);

    public void dialNumber(String var1, String var2, long var3, long var5, long var7, ResourceLocator var9, int var10, int var11, boolean var12);

    public boolean isDefaultRingingActive();

    public void setMicGainLevel(int var1);

    public String getIMSI();

    public void fillCallStackList(ListModelApp var1, int var2);

    public String getCallStackNumber(ListModelApp var1, int var2);

    public int getCallStackLength(int var1);

    public String getLastDialedNumber();

    public boolean callLastDialedNumber();

    public String getCallStackNumber(int var1);

    public boolean dialMailboxNumber(boolean var1);

    public void setWaitForDialing(boolean var1);

    public int getPhonePowerState();

    public int getPhoneLockState();

    public boolean hasNetwork();

    public void setNumberSpeller(String var1);

    public String getNumberSpellerContent();

    public void setPINSpeller(String var1, boolean var2);

    public String getPINSpellerContent();

    public boolean checkForSuppService(String var1);

    public int getNumType(String var1);

    public boolean isPrivacyModeOn();

    public void unlock(int var1, String var2);

    public void setUserDefinedRingtone(String var1, String var2);

    public void updateConnectedBTProfiles(boolean var1);

    public String getFavoritesNumber(int var1);
}

