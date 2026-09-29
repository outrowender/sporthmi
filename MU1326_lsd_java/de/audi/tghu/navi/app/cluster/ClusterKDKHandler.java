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
    default public void updateKOMOViewEnabled(boolean bl) {
    }

    default public void updateKOMOViewVisible(boolean bl) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void setKDKVisibility(boolean bl) {
    }

    default public void cleanup() {
    }
}

