/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.setup;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.RouteCriteriaSequence;
import de.audi.tghu.navi.app.util.Util;

public abstract class RouteCriteriaCoreHMIListener
implements ChoiceListener,
ButtonListener,
ListListener {
    protected final NavigationEnv env;
    protected final RouteCriteriaSequence sequence;

    public RouteCriteriaCoreHMIListener(NavigationEnv navigationEnv, RouteCriteriaSequence routeCriteriaSequence) {
        this.env = navigationEnv;
        this.sequence = routeCriteriaSequence;
        this.initTrailerModeAvailableModel();
    }

    protected void setListeners() {
        this.configureWayChoiceBitMask();
        this.env.getChoiceModel(874317312).setChoiceListener(this);
        this.env.getChoiceModel(907871744).setChoiceListener(this);
        this.env.getChoiceModel(823985664).setChoiceListener(this);
        this.env.getChoiceModel(891094528).setChoiceListener(this);
        this.env.getChoiceModel(790431232).setChoiceListener(this);
        this.env.getChoiceModel(1042089472).setChoiceListener(this);
        this.env.getChoiceModel(924648960).setChoiceListener(this);
        this.env.getChoiceModel(1025312256).setChoiceListener(this);
        this.env.getChoiceModel(857540096).setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaCoreHMIListener#itemSelected(%1,%2)", (long)n, (long)n2);
        if (n == 874317312) {
            this.tollSelected(n2);
        } else if (n == 924648960) {
            this.vignetteSelected(n2);
        } else if (n == 857540096) {
            this.hovLanesSelected(n2);
        } else if (n == 1025312256) {
            this.routeOptionSelected(n2);
        } else if (n == 907871744) {
            this.tunnelSelected(n2);
        } else if (n == 823985664) {
            this.ferrySelected(n2);
        } else if (n == 891094528) {
            this.railSelected(n2);
        } else if (n == 790431232) {
            this.timerestrictedSelected(n2);
        } else if (n == 1042089472) {
            this.seasonalRestrictedSelected(n2);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#keyPressed - modelID - %1 for keyID - %2", (long)n, (long)n2);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#keyReleased - modelID - %1 for keyID - %2", (long)n, (long)n2);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected void seasonalRestrictedSelected(int n) {
        this.env.getChoiceModel(1042089472).setValue(n);
    }

    protected void routeOptionSelected(int n) {
        if (n == 1 || n == 5) {
            this.sequence.setRouteOption(0);
        } else if (n == 2) {
            this.sequence.setRouteOption(1);
        } else if (n == 0) {
            this.sequence.setRouteOption(7);
        } else if (n == 4) {
            this.sequence.setTollRoads(2);
            this.sequence.setRouteOption(5);
        } else if (n == 3) {
            this.sequence.setTollRoads(1);
            this.sequence.setRouteOption(5);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#routeOptionSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(1025312256).setValue(n);
    }

    protected void timerestrictedSelected(int n) {
        if (n == 1) {
            this.sequence.setTimeRestrictedRoads(1);
        } else if (n == 2) {
            this.sequence.setTimeRestrictedRoads(2);
        } else if (n == 0) {
            this.sequence.setTimeRestrictedRoads(3);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#timerestrictedSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(790431232).setValue(n);
    }

    protected void railSelected(int n) {
        if (n == 0) {
            this.sequence.setMotorrail(1);
        } else if (n == 1) {
            this.sequence.setMotorrail(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#railSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(891094528).setValue(n);
    }

    protected void ferrySelected(int n) {
        if (n == 0) {
            this.sequence.setFerries(1);
        } else if (n == 1) {
            this.sequence.setFerries(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#ferrySelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(823985664).setValue(n);
    }

    protected void ferryRailSelected(int n) {
        if (n == 0) {
            this.sequence.setFerries(1);
            this.sequence.setMotorrail(1);
        } else if (n == 1) {
            this.sequence.setFerries(2);
            this.sequence.setMotorrail(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#ferrySelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(891094528).setValue(n);
        this.env.getChoiceModel(823985664).setValue(n);
    }

    protected void tunnelSelected(int n) {
        if (n == 0) {
            this.sequence.setTunnels(1);
        } else if (n == 1) {
            this.sequence.setTunnels(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#itemSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(907871744).setValue(n);
    }

    protected void vignetteSelected(int n) {
        if (n == 0) {
            this.sequence.setVignettes(1);
        } else if (n == 1) {
            this.sequence.setVignettes(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#vignetteSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(924648960).setValue(n);
    }

    protected void hovLanesSelected(int n) {
        if (n == 0) {
            this.sequence.setHovLanes(1);
        } else if (n == 1) {
            this.sequence.setHovLanes(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#hovLanesSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(857540096).setValue(n);
    }

    protected void tollSelected(int n) {
        if (n == 0) {
            this.sequence.setTollRoads(1);
        } else if (n == 1) {
            this.sequence.setTollRoads(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#tollSelected - invalid itemID - %1", (long)n);
        }
        if (this.isTollalsoTogglingVignettes()) {
            this.vignetteSelected(n);
        }
        this.env.getChoiceModel(874317312).setValue(n);
    }

    protected void configureWayChoiceBitMask() {
        if (!Util.isHURegionAsia()) {
            return;
        }
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1025312256);
        choiceModelApp.resetHints();
        if (Util.isHURegionJP() || Util.isHURegionKR()) {
            choiceModelApp.addHint(56);
        } else {
            choiceModelApp.addHint(7);
        }
    }

    private void initTrailerModeAvailableModel() {
        int n = this.isTrailerModeAvailable() ? 1 : 0;
        this.env.getChoiceModel(0x66220600).setValue(n);
    }

    protected abstract boolean isTrailerModeAvailable() {
    }

    protected boolean isTollalsoTogglingVignettes() {
        return false;
    }
}

