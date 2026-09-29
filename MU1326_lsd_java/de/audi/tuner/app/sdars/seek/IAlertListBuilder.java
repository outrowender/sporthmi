/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.sdars.seek.AlertRow;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;

public interface IAlertListBuilder {
    default public void alertStarted(BaseListModelApp baseListModelApp, SeekAlert seekAlert, SeekEntry seekEntry, AlertRow alertRow) {
    }

    default public void alertEnded(BaseListModelApp baseListModelApp, SeekAlert seekAlert, SeekEntry seekEntry) {
    }

    default public void alertUpdated(BaseListModelApp baseListModelApp, SeekAlert seekAlert, SeekEntry seekEntry, int n, AlertRow alertRow) {
    }
}

