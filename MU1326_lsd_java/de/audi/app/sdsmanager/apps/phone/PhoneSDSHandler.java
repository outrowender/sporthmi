/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.phone.ITelServiceSDS;
import java.util.Map;

public interface PhoneSDSHandler
extends ISDSApplication {
    public static final byte SPELLER_PHONE_NUMBER = 0;
    public static final byte SPELLER_PIN_CODE = 1;
    public static final byte SPELLER_MAILBOX_NUMBER = 2;
    public static final int LIST_MODE_CALL_LIST = 0;
    public static final int LIST_MODE_CALL_LIST_NBEST = 1;
    public static final int LIST_MODE_CALL_LIST_DETAIL = 2;
    public static final int LIST_MODE_FAVORITES = 3;
    public static final int LIST_MODE_FAVORITES_DETAIL = 4;
    public static final int LIST_MODE_REDIAL_NUMBER = 5;
    public static final int LIST_MODE_MAILBOX = 7;
    public static final int LIST_MODE_FIRST_ENTRY = 8;
    public static final int LIST_MODE_CALL_LIST_TITLE = 0;
    public static final int LIST_MODE_FAVORITES_TITLE = 1;

    public void setPhoneService(ITelServiceSDS var1);

    public void unsetPhoneService();

    public ITelServiceSDS getPhoneService();

    public void setPhoneSpeller(byte var1, String var2, boolean var3);

    public String getCallStackNumber(int var1);

    public String getCallStackName(int var1);

    public int getCallStackLength();

    public int getFavoritesLength();

    public long getCallStackAdbId(int var1);

    public short getCallStackPhoneType(int var1);

    public int getCallStackIndexById(long var1);

    public int getCallStackIndexByADBId(long var1);

    public int getFavoriteIndexById(long var1);

    public String getFavoriteNumber(int var1);

    public String getFavoriteName(int var1);

    public Map getAdbToCallStackMapping();

    public void matchTextWithPINSequenceDirect(String var1);

    public void matchTextWithNumberSequenceDirect(String var1);

    public void matchTextWithMailboxSequenceDirect(String var1);
}

