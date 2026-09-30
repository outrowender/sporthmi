/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.lists.StationStatus;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public abstract class AbstractTVStationRow
extends EvoListRow {
    private static final int COL_SERVICE_NAME = 0;
    public static final int COL_COUNT = 1;
    public final ServiceInfo service;
    final boolean tmpAdded;

    protected AbstractTVStationRow(AbstractTVStationRow abstractTVStationRow) {
        super(abstractTVStationRow);
        this.service = abstractTVStationRow.service;
        this.tmpAdded = abstractTVStationRow.tmpAdded;
    }

    AbstractTVStationRow(long l, ServiceInfo serviceInfo, int n) {
        this(l, serviceInfo, false, n);
    }

    AbstractTVStationRow(long l, ServiceInfo serviceInfo, boolean bl, int n) {
        super(l, n);
        this.service = serviceInfo;
        this.tmpAdded = bl;
        this.setText(0, serviceInfo.name);
    }

    public abstract void makeFavorite(boolean var1);

    public abstract void evaluateProgramInfo(ProgramInfo var1);

    public void resetProgramInfo() {
    }

    public abstract void setStationStatus(StationStatus var1);

    public abstract StationStatus getState();

    public abstract PropertyListCell getProperties();

    public abstract void updateLogo(ResourceLocator var1);

    protected static int getServiceClassification(int n) {
        if ((n & 0xE0) == 224) {
            return n & 0xF;
        }
        return 0;
    }
}

