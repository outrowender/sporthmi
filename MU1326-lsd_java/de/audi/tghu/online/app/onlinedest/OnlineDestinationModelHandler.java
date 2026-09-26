/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.dsi.ifc.online.PortalADBEntry;

public class OnlineDestinationModelHandler {
    private LogChannel log;
    private int importMode;
    private int lastDownloadResult = -1;
    public static final int INDEX_CELL_COLUMN;
    private HashMap portalEntriesMap = new HashMap();
    private List portalAddressList = new ArrayList();
    private PortalADBEntry[] portalAllAddressEntries;
    private PortalADBEntry[] portalImportAddressEntries;

    public OnlineDestinationModelHandler(IHMIServiceApp iHMIServiceApp, LogChannel logChannel, OnlineDestinationController onlineDestinationController) {
        this.log = logChannel;
        this.log.log(1078071040, "OnlineDestinationModelUpdater#OnlineDestinationModelUpdater()");
    }

    public void setImportMode(int n) {
        this.log.log(-2137614336, "OnlineDestinationModelUpdater#setImportMode() %1", (long)n);
        this.importMode = n;
    }

    public int getImportMode() {
        this.log.log(1078071040, "OnlineDestinationModelUpdater#getImportMode()");
        return this.importMode;
    }

    public void updateErrorStateModels(int n) {
        this.log.log(1078071040, "OnlineDestinationModelUpdater#updateErrorStateModels() errorCode %1", (long)n);
        this.lastDownloadResult = n;
    }

    public List getPortalEntryList() {
        return this.portalAddressList;
    }

    public PortalADBEntry getPortalEntryById(long l) {
        return (PortalADBEntry)this.portalEntriesMap.get(new Long(l));
    }

    public PortalADBEntry[] getAllPortalEntries() {
        return this.portalAllAddressEntries;
    }

    public PortalADBEntry[] getImportPortalEntries() {
        return this.portalImportAddressEntries;
    }

    public int getDownloadResult() {
        return this.lastDownloadResult;
    }

    public void storeAllPortalEntries(PortalADBEntry[] portalADBEntryArray) {
        this.portalAllAddressEntries = portalADBEntryArray;
    }

    public void storePortalEntriesToImport(PortalADBEntry[] portalADBEntryArray) {
        this.portalImportAddressEntries = portalADBEntryArray;
    }
}

