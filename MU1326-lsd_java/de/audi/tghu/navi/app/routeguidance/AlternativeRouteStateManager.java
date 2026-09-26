/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.AlternativeRouteStatePersitenceHelper;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;

public class AlternativeRouteStateManager
implements IAlternativeRouteStateManager {
    private final NavigationEnv env;
    private final int modelID;
    private final AlternativeRouteStatePersitenceHelper persitenceHelper;

    public AlternativeRouteStateManager(NavigationEnv navigationEnv, int n, AlternativeRouteStatePersitenceHelper alternativeRouteStatePersitenceHelper) {
        this.env = navigationEnv;
        this.modelID = n;
        this.persitenceHelper = alternativeRouteStatePersitenceHelper;
        this.setAlternativeRouteState(alternativeRouteStatePersitenceHelper.loadAlternativeRouteState());
    }

    @Override
    public int getAlternativeRouteState() {
        return this.env.getChoiceModel(this.modelID).getValue();
    }

    @Override
    public final void setAlternativeRouteState(int n) {
        if (n != this.env.getChoiceModel(this.modelID).getValue()) {
            this.env.getLogChannel().log(-2137614336, "AlternativeRouteState#setAlternativeRouteState - change model state from Model = %1 to %2", (Object)new StringBuffer().append(this.modelID).append("").toString(), (long)n);
            this.env.getChoiceModel(this.modelID).setValue(n);
            this.persitenceHelper.persistAlternativeRouteState(n);
        } else {
            this.env.getLogChannel().log(-2137614336, "AlternativeRouteState#setAlternativeRouteState - model has already the given state");
        }
    }

    @Override
    public void resetSettings() {
        this.env.getLogChannel().log(-2137614336, "AlternativeRouteState#resetSettings() - set default settings");
        this.setAlternativeRouteState(this.env.getFramework().getSysConst(4479));
    }
}

