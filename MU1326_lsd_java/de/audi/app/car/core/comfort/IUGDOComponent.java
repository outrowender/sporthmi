/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.UGDOViewOptions;

public interface IUGDOComponent {
    public DSICarComfort getDSICarComfort();

    public UGDOViewOptions getCurrentViewOptionsObject();

    public int getLearningHMIPopupID();

    public int getSyncHMIPopupID();

    public int getStandbyHMIPopupID();

    public LogChannel getDSILogChannel();

    public LogChannel getDefaultLogChannel();

    public ArrayList getInternalButtonList();

    public int getCurrentVisiblePopupPrio();

    public void learningResultChanged(int var1, int var2);

    public void syncResultChanged(int var1, int var2);
}

