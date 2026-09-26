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
    private static final String LOG_CLASS;
    private DSIKombiPictureServer dsi;
    private final LogChannel dsiLogChannel = CombiLogger.getPicServerDSILog();
    static /* synthetic */ Class class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController;

    public DSIKombiPictureServerController() {
        this.dsi = new NullDSIKombiPictureServerService(this.dsiLogChannel);
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsiLogChannel.log(-2137614336, "[%1#setDSI] called (dsi=%2)", (Object)"DSIKombiPictureServerController", (Object)dSIBase);
        if (dSIBase == null) {
            this.dsiLogChannel.log(-2137614336, "[%1#setDSI] DSI is being deregistered", (Object)"DSIKombiPictureServerController");
        }
        this.dsi = (DSIKombiPictureServer)dSIBase;
    }

    @Override
    public DSIBase getDSI() {
        return this.dsi;
    }

    @Override
    public void deregisterDSI() {
        this.dsi = new NullDSIKombiPictureServerService(this.dsiLogChannel);
    }

    @Override
    public Class getDSIClass() {
        return class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController == null ? (class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController = DSIKombiPictureServerController.class$("de.audi.app.combi.bap.dsi.pictureserver.DSIKombiPictureServerController")) : class$de$audi$app$combi$bap$dsi$pictureserver$DSIKombiPictureServerController;
    }

    @Override
    public void setKombiHmiReady() {
        this.dsiLogChannel.log(-2137614336, "[%1#setKombiHmiReady]", (Object)"DSIKombiPictureServerController");
        this.dsi.setKombiHmiReady();
    }

    @Override
    public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(-2137614336, "[%1#responseCoverArt] address: %2, addressType: %3", (Object)"DSIKombiPictureServerController", l, (long)n);
        this.dsiLogChannel.log(-2137614336, "[%1#responseCoverArt] ... sourceType: %2, coverArtType: %3", (Object)"DSIKombiPictureServerController", (long)n2, (long)n3);
        this.dsiLogChannel.log(-2137614336, "[%1#responseCoverArt] ... coverArtResource: %2", (Object)"DSIKombiPictureServerController", (Object)resourceLocator);
        this.dsi.responseCoverArt(l, n, n2, n3, resourceLocator);
    }

    @Override
    public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(-2137614336, "[%1#responseStationArt] address: %2, addressType: %3", (Object)"DSIKombiPictureServerController", l, (long)n);
        this.dsiLogChannel.log(-2137614336, "[%1#responseStationArt] ... sourceType: %2, stationArtType: %3", (Object)"DSIKombiPictureServerController", (long)n2, (long)n3);
        this.dsiLogChannel.log(-2137614336, "[%1#responseStationArt] ... stationArtResource: %2", (Object)"DSIKombiPictureServerController", (Object)resourceLocator);
        this.dsi.responseStationArt(l, n, n2, n3, resourceLocator);
    }

    @Override
    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(-2137614336, "[%1#responseActiveCallPicture] callID: %2, activeCallPictureType: %3", (Object)"DSIKombiPictureServerController", (long)n, (long)n2);
        this.dsiLogChannel.log(-2137614336, "[%1#responseActiveCallPicture] ... resource: %2", (Object)"DSIKombiPictureServerController", (Object)resourceLocator);
        this.dsi.responseActiveCallPicture(n, n2, resourceLocator);
    }

    @Override
    public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
        this.dsiLogChannel.log(-2137614336, "[%1#responseAdbContactPicture] address: %2, addressType: %3", (Object)"DSIKombiPictureServerController", l, (long)n);
        this.dsiLogChannel.log(-2137614336, "[%1#responseAdbContactPicture] ... adbContactPictureType: %2", (Object)"DSIKombiPictureServerController", (long)n2);
        this.dsiLogChannel.log(-2137614336, "[%1#responseAdbContactPicture] ... resource: %2", (Object)"DSIKombiPictureServerController", (Object)resourceLocator);
        this.dsi.responseAdbContactPicture(l, n, n2, resourceLocator);
    }

    @Override
    public void responseInternalAddressID(long l, int n, int n2) {
        this.dsiLogChannel.log(-2137614336, "[%1#responseInternalAddressID] address: %2, addressType: %3", (Object)"DSIKombiPictureServerController", l, (long)n);
        this.dsiLogChannel.log(-2137614336, "[%1#responseInternalAddressID] ... idType: %2", (Object)"DSIKombiPictureServerController", (long)n2);
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

