/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.setup;

import de.audi.app.navi.evo.setup.VignetteCountriesModelAccess;
import de.audi.app.navi.evo.setup.VignetteCountriesRowBuilder;
import de.audi.app.navi.setup.RouteCriteriaCoreHMIListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.RouteCriteriaSequence;
import de.audi.tghu.navi.app.util.Util;

public class RouteCriteriaHMIListener
extends RouteCriteriaCoreHMIListener {
    public RouteCriteriaHMIListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, RouteCriteriaSequence routeCriteriaSequence) {
        super(navigationEnv, routeCriteriaSequence);
        this.setListeners();
    }

    public void routeCriteriaScreenExited() {
        this.sequence.finishSequence();
    }

    @Override
    protected final void setListeners() {
        super.setListeners();
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-14875136);
        choiceModelApp.setChoiceListener(this);
        if (Util.isHURegionNAR()) {
            choiceModelApp.addHint(6);
        }
        if (!Util.isSemidynamicRgAvailable(this.env.getFramework())) {
            choiceModelApp.addHint(5);
        }
        this.env.getChoiceModel(-2145122816).setChoiceListener(this);
        this.env.getChoiceModel(1967616).setChoiceListener(this);
        this.env.getButtonModel(-1944123904).setButtonListener(this);
    }

    public void startVignetteSequence() {
        this.sequence.startCountriesSequence(new VignetteCountriesModelAccess(this.env, this, new VignetteCountriesRowBuilder()), true);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#itemSelected(%1,%2)", (long)n, (long)n2);
        super.itemSelected(n, n2, n3, n4);
        if (n == -14875136) {
            this.trafficReroutingSelected(n2);
        } else if (n == -2145122816) {
            this.freewaySelected(n2);
        } else if (n == 1967616) {
            this.trailerSelected(n2);
        }
        this.env.fireModelEvent(n, n4);
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
    public void keyTyped(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#keyTyped - modelID - %1 for keyID - %2", (long)n, (long)n2);
        if (n == -1944123904) {
            this.sequence.startSequence();
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    protected void seasonalRestrictedSelected(int n) {
        if (n == 1) {
            this.sequence.setSeasonRestricted(1);
        } else if (n == 2) {
            this.sequence.setSeasonRestricted(2);
        } else if (n == 0) {
            this.sequence.setSeasonRestricted(3);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#seasonalRestrictedSelected - invalid itemID - %1", (long)n);
        }
        super.seasonalRestrictedSelected(n);
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

    private void trailerSelected(int n) {
        this.sequence.startSequence();
        this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#trailerSelected - itemID - %1", (long)n);
        if (n == 1) {
            this.sequence.setTrailer(5);
        } else if (n == 0) {
            this.sequence.setTrailer(6);
        } else if (n == 2) {
            this.sequence.setTrailer(3);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#trailerSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(1967616).setValue(n);
    }

    private void freewaySelected(int n) {
        if (n == 0) {
            this.sequence.setFreeways(1);
        } else if (n == 1) {
            this.sequence.setFreeways(2);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#freewaySelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(-2145122816).setValue(n);
    }

    private void trafficReroutingSelected(int n) {
        if (n == 0) {
            this.sequence.setTrafficRerouting(3);
        } else if (n == 1) {
            this.sequence.setTrafficRerouting(4);
        } else if (n == 2) {
            this.sequence.setTrafficRerouting(6);
        } else {
            this.env.getLogChannel().log(-2137614336, "RouteCriteriaHMIListener#trafficReroutingSelected - invalid itemID - %1", (long)n);
        }
        this.env.getChoiceModel(-14875136).setValue(n);
    }

    @Override
    protected boolean isTrailerModeAvailable() {
        return !Util.isClusterMMI(this.env.getFramework());
    }
}

