/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.sdars.seek.AlertRow;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;

public interface IAlertListBuilder {
    public void alertStarted(BaseListModelApp var1, SeekAlert var2, SeekEntry var3, AlertRow var4);

    public void alertEnded(BaseListModelApp var1, SeekAlert var2, SeekEntry var3);

    public void alertUpdated(BaseListModelApp var1, SeekAlert var2, SeekEntry var3, int var4, AlertRow var5);
}

