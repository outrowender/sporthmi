/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.pictureserver;

import de.audi.app.combi.bap.dsi.pictureserver.IDSIKombiPictureServerController;
import de.audi.app.combi.bap.dsi.pictureserver.NullDSIKombiPictureServerService;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

public class DSIKombiPictureServerController
implements IDSIKombiPictureServerController {
    private static final String LOG_CLASS = "DSIKombiPictureServerController";
    private DSIKombiPictureServer dsi;
    private final LogChannel dsiLogChannel = CombiLogger.getPicServerDSILog();
    static /* synthetic */ Class class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController;

    public DSIKombiPictureServerController() {
        this.dsi = new NullDSIKombiPictureServerService(this.dsiLogChannel);
    }

    public void setDSI(DSIBase dSIBase) {
        this.dsiLogChannel.log(10000000, "[%1#setDSI] called (dsi=%2)", (Object)LOG_CLASS, (Object)dSIBase);
        if (dSIBase == null) {
            this.dsiLogChannel.log(10000000, "[%1#setDSI] DSI is being deregistered", (Object)LOG_CLASS);
        }
        this.dsi = (DSIKombiPictureServer)dSIBase;
    }

    public DSIBase getDSI() {
        return this.dsi;
    }

    public void deregisterDSI() {
        this.dsi = new NullDSIKombiPictureServerService(this.dsiLogChannel);
    }

    public Class getDSIClass() {
        return class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController == null ? (class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController = DSIKombiPictureServerController.class$("de.audi.app.combi.bap.dsi.pictureserver.DSIKombiPictureServerController")) : class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController;
    }

    public void setKombiHmiReady() {
        this.dsiLogChannel.log(10000000, "[%1#setKombiHmiReady]", (Object)LOG_CLASS);
        this.dsi.setKombiHmiReady();
    }

    public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(10000000, "[%1#responseCoverArt] address: %2, addressType: %3", (Object)LOG_CLASS, l, (long)n);
        this.dsiLogChannel.log(10000000, "[%1#responseCoverArt] ... sourceType: %2, coverArtType: %3", (Object)LOG_CLASS, (long)n2, (long)n3);
        this.dsiLogChannel.log(10000000, "[%1#responseCoverArt] ... coverArtResource: %2", (Object)LOG_CLASS, (Object)resourceLocator);
        this.dsi.responseCoverArt(l, n, n2, n3, resourceLocator);
    }

    public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(10000000, "[%1#responseStationArt] address: %2, addressType: %3", (Object)LOG_CLASS, l, (long)n);
        this.dsiLogChannel.log(10000000, "[%1#responseStationArt] ... sourceType: %2, stationArtType: %3", (Object)LOG_CLASS, (long)n2, (long)n3);
        this.dsiLogChannel.log(10000000, "[%1#responseStationArt] ... stationArtResource: %2", (Object)LOG_CLASS, (Object)resourceLocator);
        this.dsi.responseStationArt(l, n, n2, n3, resourceLocator);
    }

    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(10000000, "[%1#responseActiveCallPicture] callID: %2, activeCallPictureType: %3", (Object)LOG_CLASS, (long)n, (long)n2);
        this.dsiLogChannel.log(10000000, "[%1#responseActiveCallPicture] ... resource: %2", (Object)LOG_CLASS, (Object)resourceLocator);
        this.dsi.responseActiveCallPicture(n, n2, resourceLocator);
    }

    public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(10000000, "[%1#responseAdbContactPicture] address: %2, addressType: %3", (Object)LOG_CLASS, l, (long)n);
        this.dsiLogChannel.log(10000000, "[%1#responseAdbContactPicture] ... adbContactPictureType: %2", (Object)LOG_CLASS, (long)n2);
        this.dsiLogChannel.log(10000000, "[%1#responseAdbContactPicture] ... resource: %2", (Object)LOG_CLASS, (Object)resourceLocator);
        this.dsi.responseAdbContactPicture(l, n, n2, resourceLocator);
    }

    public void responseInternalAddressID(long l, int n, int n2) {
        this.dsiLogChannel.log(10000000, "[%1#responseInternalAddressID] address: %2, addressType: %3", (Object)LOG_CLASS, l, (long)n);
        this.dsiLogChannel.log(10000000, "[%1#responseInternalAddressID] ... idType: %2", (Object)LOG_CLASS, (long)n2);
        this.dsi.responseInternalAddressID(l, n, n2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

