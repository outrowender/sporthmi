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
    private static final int COL_SERVICE_NAME;
    public static final int COL_COUNT;
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

    public abstract void makeFavorite(boolean bl) {
    }

    public abstract void evaluateProgramInfo(ProgramInfo programInfo) {
    }

    public void resetProgramInfo() {
    }

    public abstract void setStationStatus(StationStatus stationStatus) {
    }

    public abstract StationStatus getState() {
    }

    public abstract PropertyListCell getProperties() {
    }

    public abstract void updateLogo(ResourceLocator resourceLocator) {
    }

    protected static int getServiceClassification(int n) {
        if ((n & 0xE0) == 224) {
            return n & 0xF;
        }
        return 0;
    }
}

