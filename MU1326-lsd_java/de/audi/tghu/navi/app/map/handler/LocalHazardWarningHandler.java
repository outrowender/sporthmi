/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import java.util.Vector;
import org.dsi.ifc.tmc.LocalHazardInformation;

public class LocalHazardWarningHandler {
    private static final int MAX_COLUMNS;
    private static final int CELL_LGI_EVENT_TYPE;
    private final LogChannel logChannel;
    private LocalHazardInformation[] localHazardWarnings;

    public LocalHazardWarningHandler(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getMapMainLogChannel();
    }

    public LocalHazardInformation[] getLocalHazardWarnings() {
        return this.localHazardWarnings;
    }

    public void setLocalHazardWarnings(LocalHazardInformation[] localHazardInformationArray) {
        this.localHazardWarnings = localHazardInformationArray;
    }

    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
        if (localHazardInformationArray == null) {
            this.logChannel.log(-2137614336, "LocalHazardWarningHandler#updateLocalHazardInformation( null )");
            return;
        }
        this.logChannel.log(-2137614336, "LocalHazardWarningHandler#updateLocalHazardInformation( %1 )", (long)localHazardInformationArray.length);
        this.setLocalHazardWarnings(localHazardInformationArray);
        this.updateLgiListModel(localHazardInformationArray);
    }

    private void updateLgiListModel(LocalHazardInformation[] localHazardInformationArray) {
        LocalHazardInformation[] localHazardInformationArray2 = this.filterForRelevantWarnings(localHazardInformationArray);
        for (int i2 = 0; i2 < localHazardInformationArray2.length; ++i2) {
            LocalHazardInformation localHazardInformation = localHazardInformationArray2[i2];
            BaseListRow baseListRow = new BaseListRow(new ListCell[1]);
            baseListRow.setCell(0, IntegerListCell.create(localHazardInformation.getEventType()));
        }
    }

    private LocalHazardInformation[] filterForRelevantWarnings(LocalHazardInformation[] localHazardInformationArray) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 < localHazardInformationArray.length; ++i2) {
            LocalHazardInformation localHazardInformation = localHazardInformationArray[i2];
            if (localHazardInformation == null || localHazardInformation.getEventType() == 0 || localHazardInformation.getEventType() == 1 || localHazardInformation.getEventType() == 3) continue;
            vector.add(localHazardInformation);
        }
        return (LocalHazardInformation[])vector.toArray(new LocalHazardInformation[vector.size()]);
    }
}

