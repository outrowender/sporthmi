/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.PredictiveNavListRowEvo;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavListRow;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class PredictiveNavModelAccessEvo
extends PredictiveNavModelAccess {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public PredictiveNavModelAccessEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
        this.likelyDestinationsList = navigationEnv.getBaseListModel(402078);
    }

    public void updateOperationModeModels(boolean bl) {
        if (bl) {
            this.env.getChoiceModel(402079).setValue(1);
            this.env.getChoiceModel(4500).setValue(1);
        } else {
            this.env.getChoiceModel(402079).setValue(0);
            this.env.getChoiceModel(4500).setValue(0);
        }
    }

    protected PredictiveNavListRow createNewListRow(LikelyDestination likelyDestination) {
        return new PredictiveNavListRowEvo(this.env, likelyDestination);
    }
}

