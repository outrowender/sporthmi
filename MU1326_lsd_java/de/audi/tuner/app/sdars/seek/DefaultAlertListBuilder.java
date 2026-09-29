/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.sdars.seek.AlertRow;
import de.audi.tuner.app.sdars.seek.IAlertListBuilder;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;

public class DefaultAlertListBuilder
implements IAlertListBuilder {
    @Override
    public void alertStarted(BaseListModelApp baseListModelApp, SeekAlert seekAlert, SeekEntry seekEntry, AlertRow alertRow) {
        if (baseListModelApp.getLength() > 0) {
            long l = baseListModelApp.getRow(0).getUniqueID();
            baseListModelApp.insertBefore(l, alertRow);
        } else {
            baseListModelApp.append(alertRow);
        }
    }

    @Override
    public void alertEnded(BaseListModelApp baseListModelApp, SeekAlert seekAlert, SeekEntry seekEntry) {
        baseListModelApp.remove(seekAlert.sID);
    }

    @Override
    public void alertUpdated(BaseListModelApp baseListModelApp, SeekAlert seekAlert, SeekEntry seekEntry, int n, AlertRow alertRow) {
        baseListModelApp.setRow(n, alertRow);
    }
}

