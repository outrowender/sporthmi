/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public interface DSIKombiSyncListener
extends DSIListener {
    public void updateKombiCommunicationState(boolean var1, int var2);

    public void updateKombiMessageStateDisplayStatus(int var1, int var2);

    public void updateKombiMessageStateDisplayRequest(int var1, int var2);

    public void updateKombiMessageStatePopupStatus(int var1, int var2);

    public void responseKombiDisplayStatus(KombiDisplayStatus var1, int var2);

    public void responseKombiDisplayRequest(KombiDisplayRequest var1);

    public void responseKombiPopupStatus(KombiPopupStatus var1, int var2);
}

