/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;

public class AlternativeRouteChoiceModelListener
implements ChoiceListener {
    private final int choiceModel;
    private final IAlternativeRouteStateManager alternativeRouteState;
    private final NavigationEnv env;

    public AlternativeRouteChoiceModelListener(IAlternativeRouteStateManager iAlternativeRouteStateManager, int n, NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.choiceModel = n;
        this.alternativeRouteState = iAlternativeRouteStateManager;
        navigationEnv.getChoiceModel(n).setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.choiceModel) {
            int n5 = this.alternativeRouteState.getAlternativeRouteState() == 0 ? 1 : 0;
            this.alternativeRouteState.setAlternativeRouteState(n5);
        } else {
            this.env.getLogChannel().log(-2137614336, "AlternativeRouteChoiceModelListener#itemSelected - Not a valid ModelID");
        }
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "AlternativeRouteChoiceModelListener#keyTyped");
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "AlternativeRouteChoiceModelListener#keyPressed");
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "AlternativeRouteChoiceModelListener#keyReleased");
    }
}

