/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.pictureserver;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

public class NullDSIKombiPictureServerService
extends NullService
implements DSIKombiPictureServer {
    protected NullDSIKombiPictureServerService(LogChannel logChannel) {
        super(logChannel, "DSIKombiPictureServer");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void setKombiHmiReady() {
        this.log("setKombiHmiReady");
    }

    public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.log("responseCoverArt");
    }

    public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.log("responseStationArt");
    }

    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
        this.log("responseActiveCallPicture");
    }

    public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
        this.log("responseAdbContactPicture");
    }

    public void responseInternalAddressID(long l, int n, int n2) {
        this.log("responseInternalAddressID");
    }

    public void responsePictureServerAbilities(int n) {
        this.log("responsePictureServerAbilities");
    }

    public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) {
        this.log("responsePictureStream");
    }

    public void responseActiveCallPictureInstance(int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.log("responseActiveCallPictureInstance");
    }

    public void responseDynamicIcon(int n, int n2, boolean bl, ResourceLocator resourceLocator) {
        this.log("responseDynamicIcon");
    }
}

