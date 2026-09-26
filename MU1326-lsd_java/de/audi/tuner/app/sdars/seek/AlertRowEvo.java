/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AlertRow;
import org.dsi.ifc.sdars.SeekEntry;

public class AlertRowEvo
extends AlertRow {
    public AlertRowEvo(StationInfoExt stationInfoExt, SeekEntry seekEntry, String string, String string2) {
        super(stationInfoExt, seekEntry, string, string2);
        this.setPropertyCell(8, new PropertyListCell(673103840, new int[0]));
    }
}

