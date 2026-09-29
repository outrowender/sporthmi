/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.ITelServiceSDSListener;
import de.audi.atip.phone.TelServiceCallStackEntry;
import org.dsi.ifc.global.ResourceLocator;

public class NullITelServiceSDS
extends NullService
implements ITelServiceSDS {
    public NullITelServiceSDS(LogChannel logChannel) {
        super(logChannel, "NullITelServiceSDS");
    }

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public boolean checkForSuppService(String string) {
        super.log();
        return false;
    }

    @Override
    public String getNumberSpellerContent() {
        super.log();
        return null;
    }

    @Override
    public void setNumberSpeller(String string) {
        super.log();
    }

    @Override
    public void dialNumber(String string, ITelServiceListener iTelServiceListener, boolean bl) {
        super.log();
    }

    @Override
    public void dialNumberFromADBEntry(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener, boolean bl) {
        super.log();
    }

    @Override
    public String getPINSpellerContent() {
        super.log();
        return null;
    }

    @Override
    public void setPINSpeller(String string) {
        super.log();
    }

    @Override
    public String getMailboxSpellerContent() {
        super.log();
        return null;
    }

    @Override
    public void setMailboxSpeller(String string) {
        super.log();
    }

    @Override
    public void setMailboxNumber(String string, ITelServiceSDSListener iTelServiceSDSListener) {
        super.log();
    }

    @Override
    public void unlockSIMWithPIN(String string, ITelServiceSDSListener iTelServiceSDSListener) {
        super.log();
    }

    @Override
    public String getMailboxNumber() {
        super.log();
        return null;
    }

    @Override
    public TelServiceCallStackEntry getLastDialedNumber() {
        super.log();
        return null;
    }

    @Override
    public byte fillCallstackPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 0;
    }

    @Override
    public byte fillFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 0;
    }

    @Override
    public void prepareDialing(String string, ITelServiceListener iTelServiceListener) {
        super.log();
    }

    @Override
    public void prepareDialing(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener) {
        super.log();
    }

    @Override
    public void dialNumber(ITelCallSession iTelCallSession, boolean bl) {
        super.log();
    }

    @Override
    public boolean isHfpPhoneConnected(boolean bl) {
        super.log();
        return false;
    }

    @Override
    public boolean isBluetoothPhoneConnected() {
        super.log();
        return false;
    }
}

