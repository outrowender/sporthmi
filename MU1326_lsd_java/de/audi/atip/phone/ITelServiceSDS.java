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
    public static final int PIN_MAX_LENGTH;
    public static final int NUMBER_MAX_LENGTH;

    default public boolean checkForSuppService(String string) {
    }

    default public String getNumberSpellerContent() {
    }

    default public void setNumberSpeller(String string) {
    }

    default public String getPINSpellerContent() {
    }

    default public void setPINSpeller(String string) {
    }

    default public String getMailboxSpellerContent() {
    }

    default public void setMailboxSpeller(String string) {
    }

    default public void setMailboxNumber(String string, ITelServiceSDSListener iTelServiceSDSListener) {
    }

    default public void unlockSIMWithPIN(String string, ITelServiceSDSListener iTelServiceSDSListener) {
    }

    default public String getMailboxNumber() {
    }

    default public TelServiceCallStackEntry getLastDialedNumber() {
    }

    default public byte fillCallstackPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillFavoritePickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public boolean isHfpPhoneConnected(boolean bl) {
    }

    default public boolean isBluetoothPhoneConnected() {
    }
}

