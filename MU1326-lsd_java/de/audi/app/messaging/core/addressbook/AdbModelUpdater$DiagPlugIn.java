/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.messaging.core.addressbook.AdbModelUpdater;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

final class AdbModelUpdater$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ AdbModelUpdater this$0;

    AdbModelUpdater$DiagPlugIn(AdbModelUpdater adbModelUpdater) {
        this.this$0 = adbModelUpdater;
    }

    public void cmdSetMessageAdbContact() {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.entryId = 0;
        adbEntry.entryType = 1;
        adbEntry.combinedName = "William Shakespeare";
        adbEntry.preferredNumberIdx = 1;
        adbEntry.voiceTagId = -1;
        adbEntry.phoneData = new PhoneData[]{new PhoneData("0815 47 11 58", 4, -1), new PhoneData("0199 4711 4711", 64, -1)};
        adbEntry.addressData = new AddressData[0];
        adbEntry.emailData = new EmailData[0];
        adbEntry.urlData = new String[0];
        adbEntry.personalData = new PersonalData();
        this.this$0.updateMessageOptions(adbEntry);
    }
}

