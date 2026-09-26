/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationModelHandler;
import java.util.List;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.organizer.AdbEntry;

public class OnlineDestinationSdsHandler
implements IOnlineSDSMyAudiService {
    private OnlineDestinationModelHandler models;
    private OnlineDestinationController application;

    public OnlineDestinationSdsHandler(OnlineDestinationModelHandler onlineDestinationModelHandler, OnlineDestinationController onlineDestinationController) {
        this.models = onlineDestinationModelHandler;
        this.application = onlineDestinationController;
    }

    @Override
    public AdbEntry selectContactById(long l) {
        PortalADBEntry portalADBEntry = this.models.getPortalEntryById(l);
        this.writeSDSModels(portalADBEntry);
        return null;
    }

    private void writeSDSModels(PortalADBEntry portalADBEntry) {
        HMIService hMIService = this.application.getFramework().getHMIService();
    }

    public static SDSListEntry[] convertPortalToSdsEntries(List list) {
        if (list == null) {
            return new SDSListEntry[0];
        }
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[list.size()];
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry;
            PortalADBEntry portalADBEntry = (PortalADBEntry)list.get(i2);
            sDSListEntryArray[i2] = sDSListEntry = new SDSListEntry(portalADBEntry.getGeneralDescription(), portalADBEntry.getEntryID(), 0);
        }
        return sDSListEntryArray;
    }
}

