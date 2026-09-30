/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavListRow;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class PredictiveNavListRowEvo
extends PredictiveNavListRow {
    private static final int ICON_SELENA = 1;

    public PredictiveNavListRowEvo(NavigationEnv navigationEnv, LikelyDestination likelyDestination) {
        super(navigationEnv, likelyDestination);
    }

    public PredictiveNavListRowEvo(PredictiveNavListRow predictiveNavListRow) {
        super(predictiveNavListRow);
    }

    public void updateInformation(LikelyDestination likelyDestination) {
        super.updateInformation(likelyDestination);
        this.setPropertyCell(10, new PropertyListCell(-352643848, new int[0]));
        this.setInteger(1, 1);
    }

    public EvoListRow copy() {
        return new PredictiveNavListRowEvo(this);
    }
}

