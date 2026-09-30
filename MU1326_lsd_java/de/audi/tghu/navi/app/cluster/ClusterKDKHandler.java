/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.hmi.intercommunication.NaviMoKoKDKConstants;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.power.PowerEventListener;

public interface ClusterKDKHandler
extends NaviMoKoKDKConstants,
IViewSizeListener,
PowerEventListener {
    public void updateKOMOViewEnabled(boolean var1);

    public void updateKOMOViewVisible(boolean var1);

    public void updateRgActive(boolean var1);

    public void setKDKVisibility(boolean var1);

    public void cleanup();
}

