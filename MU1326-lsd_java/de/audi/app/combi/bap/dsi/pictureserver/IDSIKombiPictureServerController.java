/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.pictureserver;

import de.audi.app.bap.dsi.IDSIController;
import org.dsi.ifc.global.ResourceLocator;

public interface IDSIKombiPictureServerController
extends IDSIController {
    default public void setKombiHmiReady() {
    }

    default public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void responseInternalAddressID(long l, int n, int n2) {
    }
}

