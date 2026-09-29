/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.UGDOViewOptions;

public interface IUGDOComponent {
    default public DSICarComfort getDSICarComfort() {
    }

    default public UGDOViewOptions getCurrentViewOptionsObject() {
    }

    default public int getLearningHMIPopupID() {
    }

    default public int getSyncHMIPopupID() {
    }

    default public int getStandbyHMIPopupID() {
    }

    default public LogChannel getDSILogChannel() {
    }

    default public LogChannel getDefaultLogChannel() {
    }

    default public ArrayList getInternalButtonList() {
    }

    default public int getCurrentVisiblePopupPrio() {
    }

    default public void learningResultChanged(int n, int n2) {
    }

    default public void syncResultChanged(int n, int n2) {
    }
}

