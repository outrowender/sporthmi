/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import org.dsi.ifc.organizer.AdbEntry;

final class PhoneServices$4
implements Runnable {
    private final /* synthetic */ ITelService val$telService;
    private final /* synthetic */ AdbEntry val$adbEntry;
    private final /* synthetic */ String val$phoneNumber;
    private final /* synthetic */ int val$phoneDataIndex;
    private final /* synthetic */ LogChannel val$log;

    PhoneServices$4(ITelService iTelService, AdbEntry adbEntry, String string, int n, LogChannel logChannel) {
        this.val$telService = iTelService;
        this.val$adbEntry = adbEntry;
        this.val$phoneNumber = string;
        this.val$phoneDataIndex = n;
        this.val$log = logChannel;
    }

    @Override
    public void run() {
        try {
            this.val$telService.prepareDialing(this.val$adbEntry.getCombinedName(), this.val$phoneNumber, (short)this.val$adbEntry.phoneData[this.val$phoneDataIndex].getNumberType(), (short)this.val$adbEntry.getEntryType(), this.val$adbEntry.getEntryId(), this.val$adbEntry.getPersonalData().getContactPicture(), this.val$phoneDataIndex, ADBUtils.countPhoneNumbers(this.val$adbEntry), null);
        }
        catch (Exception exception) {
            Logs.logException(this.val$log, exception, "[PhoneServices#prepareMatchedNumber]");
        }
    }
}

