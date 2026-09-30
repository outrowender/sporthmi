/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.interapp.ADBHMIAppServiceListener;
import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationCommandList;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.organizer.AdbEntry;

public abstract class AbstractOnlineDestinationCommand
extends Command
implements DSIDestinationImportListener,
ADBHMIAppServiceListener {
    OnlineDestinationController application;

    public AbstractOnlineDestinationCommand() {
        this((String)null);
    }

    public AbstractOnlineDestinationCommand(String string) {
        super(null, string);
    }

    public void setCommandList(ICommandList iCommandList) {
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof OnlineDestinationCommandList)) {
            throw new ClassCastException("Expected OnlineDestinationCommandList!");
        }
        this.init(((OnlineDestinationCommandList)iCommandList).getApplication());
    }

    private void init(OnlineDestinationController onlineDestinationController) {
        this.application = onlineDestinationController;
    }

    public DSIDestinationImport getDSI() {
        return this.application.getDSI();
    }

    public IOnlineSDSMyAudiServiceListener getSdsServiceListener() {
        return this.application.getSdsServiceListener();
    }

    public NaviMyAudiImport getNaviMyAudiService() {
        return this.application.getNaviMyAudiService();
    }

    public PortalADBEntry[] getAllPortalEntrtiesList() {
        return this.application.getModelHandler().getAllPortalEntries();
    }

    public PortalADBEntry[] getImportPortalEntrtiesList() {
        return this.application.getModelHandler().getImportPortalEntries();
    }

    public int getDownloadResult() {
        return this.application.getModelHandler().getDownloadResult();
    }

    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
    }

    public void stopActionResult(int n) {
    }

    public void updateEntries(int n, int n2) {
    }

    public void responseParseVCards(int n, AdbEntry[] adbEntryArray) {
    }

    public void responseInsertEntry(int n) {
    }
}

