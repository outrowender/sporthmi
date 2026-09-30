/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.pictureserver;

import de.audi.app.bap.dsi.IDSIController;
import org.dsi.ifc.global.ResourceLocator;

public interface IDSIKombiPictureServerController
extends IDSIController {
    public void setKombiHmiReady();

    public void responseCoverArt(long var1, int var3, int var4, int var5, ResourceLocator var6);

    public void responseStationArt(long var1, int var3, int var4, int var5, ResourceLocator var6);

    public void responseActiveCallPicture(int var1, int var2, ResourceLocator var3);

    public void responseAdbContactPicture(long var1, int var3, int var4, ResourceLocator var5);

    public void responseInternalAddressID(long var1, int var3, int var4);
}

