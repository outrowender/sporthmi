/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.IndexInformation;

public class CombiADBDSIDefaultListener
extends ADBDSIDefaultListener {
    private CombiADBHandler appAdr;

    public CombiADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, CombiADBHandler combiADBHandler) {
        super(logChannel, aDBStartupHandler, combiADBHandler);
        this.appAdr = combiADBHandler;
    }

    @Override
    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
        if (n == 1) {
            this.appAdr.getStateHandler().updateDownloadCountMe(downloadInfo);
        }
    }

    @Override
    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
        if (n == 1) {
            this.appAdr.getStateHandler().updateDownloadCountSim(downloadInfo);
        }
    }

    @Override
    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        if (n == 1) {
            this.appAdr.updateAlphabeticalIndex(indexInformationArray);
        }
    }
}

