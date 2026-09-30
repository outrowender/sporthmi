/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceSDSListener;
import de.audi.atip.phone.TelServiceCallStackEntry;

public interface ITelServiceSDS
extends ITelService,
AbstractSDSApplicationService {
    public static final int PIN_MAX_LENGTH = 8;
    public static final int NUMBER_MAX_LENGTH = 40;

    public boolean checkForSuppService(String var1);

    public String getNumberSpellerContent();

    public void setNumberSpeller(String var1);

    public String getPINSpellerContent();

    public void setPINSpeller(String var1);

    public String getMailboxSpellerContent();

    public void setMailboxSpeller(String var1);

    public void setMailboxNumber(String var1, ITelServiceSDSListener var2);

    public void unlockSIMWithPIN(String var1, ITelServiceSDSListener var2);

    public String getMailboxNumber();

    public TelServiceCallStackEntry getLastDialedNumber();

    public byte fillCallstackPickList(SDSListEntry[] var1);

    public byte fillFavoritePickList(SDSListEntry[] var1);

    public boolean isHfpPhoneConnected(boolean var1);

    public boolean isBluetoothPhoneConnected();
}

