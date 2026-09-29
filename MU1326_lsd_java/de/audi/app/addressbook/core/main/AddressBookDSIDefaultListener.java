/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DownloadInfo;

public class AddressBookDSIDefaultListener
extends ADBDSIDefaultListener {
    private AbstractAddressBookApplication appAdr;

    public AddressBookDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, AbstractAddressBookApplication abstractAddressBookApplication) {
        super(logChannel, aDBStartupHandler, abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
    }

    @Override
    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
        if (n == 1) {
            this.appAdr.getUserProfileUpdater().updateDownloadCountMe(downloadInfo);
        }
    }

    @Override
    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
        if (n == 1) {
            this.appAdr.getUserProfileUpdater().updateDownloadCountSim(downloadInfo);
        }
    }

    @Override
    public void newDeviceConnected(String string) {
        this.log.log(1078071040, "AddressBookDSIDefaultListener#newDeviceConnected(): name: %1", (Object)string);
    }

    @Override
    public void updateDeviceConnected(boolean bl, int n) {
        if (n == 1) {
            this.appAdr.getUserProfileUpdater().updateDeviceConnected(bl);
        }
    }

    @Override
    public void updateSortOrder(int n, int n2) {
        this.log.log(ADBDbgUtils.getLLInfo(n2), "AddressBookDSIDefaultListener#updateSortOrder(): sortOrder: %2, validFlag: %1", (Object)ADBDbgUtils.dbgValidFlag(n2), (Object)ADBDbgUtils.dbgSortOrder(n));
        if (n2 == 1) {
            this.appAdr.getHMIService().getChoiceModel(1320159744).setValue(ADBModelUtils.getHMISortOrderValue(n));
        }
    }

    @Override
    public void updateMaxPhoneEntries(int n, int n2) {
        this.log.log(ADBDbgUtils.getLLDbg(n2), "AddressBookDSIDefaultListener#updateMaxPhoneEntries(): maxPhoneEntries: %2, validFlag: %1", (Object)ADBDbgUtils.dbgValidFlag(n2), (long)n);
        if (n2 == 1) {
            this.appAdr.getUserProfileUpdater().updateMaxPhoneEntries(n);
        }
    }

    @Override
    public void updateMaxLocalEntries(int n, int n2) {
        this.log.log(ADBDbgUtils.getLLDbg(n2), "AddressBookDSIDefaultListener#updateMaxLocalEntries(): maxLocalEntries: %2, validFlag: %1", (Object)ADBDbgUtils.dbgValidFlag(n2), (long)n);
        if (n2 == 1) {
            this.appAdr.getUserProfileUpdater().updateMaxLocalEntries(n);
        }
    }

    @Override
    public void updateMaxTopDestEntries(int n, int n2) {
        this.log.log(ADBDbgUtils.getLLDbg(n2), "AddressBookDSIDefaultListener#updateMaxTopDestEntries(): maxTopDestEntries: %2, validFlag: %1", (Object)ADBDbgUtils.dbgValidFlag(n2), (long)n);
        if (n2 == 1 && 20 != 2 * n) {
            this.log.log(10000, "AddressBookDSIDefaultListener#updateMaxTopDestEntries(): 2 * maxTopDestEntries received via DSI (%1) differs from maxTopDestEntries configured in HMI (%2)!", (long)(2 * n), (long)0);
        }
    }
}

