/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.asia.warning;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateManager;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;

public class AsiaWarningsStateSetupListener
extends DefaultChoiceListener {
    private NavigationEnv env;
    private AsiaWarningsStateManager state;
    private Navigation navigation;

    public AsiaWarningsStateSetupListener(NavigationEnv navigationEnv, AsiaWarningsStateManager asiaWarningsStateManager, Navigation navigation) {
        this.env = navigationEnv;
        this.state = asiaWarningsStateManager;
        this.navigation = navigation;
        this.registerChoiceModelListener();
        this.initModels(this.state);
    }

    private void registerChoiceModelListener() {
        this.env.getChoiceModel(1461782016).setChoiceListener(this);
        this.env.getChoiceModel(1512113664).setChoiceListener(this);
        this.env.getChoiceModel(1445004800).setChoiceListener(this);
        this.env.getChoiceModel(1478559232).setChoiceListener(this);
        this.env.getChoiceModel(1495336448).setChoiceListener(this);
    }

    public void initModels(AsiaWarningsStateManager asiaWarningsStateManager) {
        this.env.getChoiceModel(1461782016).setValue(asiaWarningsStateManager.getLowFuelWarningState());
        this.env.getChoiceModel(1512113664).setValue(asiaWarningsStateManager.getMergingTrafficState());
        this.env.getChoiceModel(1445004800).setValue(asiaWarningsStateManager.getLaneWarningState());
        this.env.getChoiceModel(1478559232).setValue(asiaWarningsStateManager.getRailwayCrossingWarningState());
        this.env.getChoiceModel(1495336448).setValue(asiaWarningsStateManager.getSpeedCameraWarningState());
    }

    public void makeInitialDSICalls(DSITrafficRegulation dSITrafficRegulation) {
        this.setWarningStatus(1512113664, 1 == this.state.getMergingTrafficState(), dSITrafficRegulation);
        this.setWarningStatus(1445004800, 1 == this.state.getLaneWarningState(), dSITrafficRegulation);
        this.setWarningStatus(1478559232, 1 == this.state.getRailwayCrossingWarningState(), dSITrafficRegulation);
        this.setWarningStatus(1495336448, 1 == this.state.getSpeedCameraWarningState(), dSITrafficRegulation);
    }

    protected static int getWarningType(int n) {
        switch (n) {
            case 401754: {
                return 4;
            }
            case 401750: {
                return 3;
            }
            case 401752: {
                return 2;
            }
            case 401753: {
                return 6;
            }
        }
        return 0;
    }

    private void setWarningStatus(int n, boolean bl, DSITrafficRegulation dSITrafficRegulation) {
        if (null != dSITrafficRegulation) {
            int n2 = AsiaWarningsStateSetupListener.getWarningType(n);
            dSITrafficRegulation.setWarningStatus(n2, bl, true, 0);
            this.env.getLogChannel().log(1078071040, "AsiaWarningsStateSetupListener#itemSelected#informTrafficRegulationDsi warningType=%2 warningOnOffState=%1", bl, (long)n2);
        } else {
            this.env.getLogChannel().log(-1601830656, "AsiaWarningsStateSetupListener#itemSelected#informTrafficRegulationDsi null == getTrafficRegulationDsi()");
        }
    }

    private int toggleCheckbox(int n) {
        ChoiceModelApp choiceModelApp = this.env.getFramework().getHMIService().getChoiceModel(n);
        int n2 = 0 == choiceModelApp.getValue() ? 1 : 0;
        choiceModelApp.setValue(n2);
        DSITrafficRegulation dSITrafficRegulation = this.navigation.getTrafficRegulationService().getTrafficRegulationDsi();
        this.setWarningStatus(n, 1 == n2, dSITrafficRegulation);
        return n2;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.getLogChannel().log(1078071040, "AsiaWarningsStateSetupListener#itemSelected model=%1 item=%2", (long)n, (long)n2);
        switch (n) {
            case 401751: {
                this.state.setLowFuelWarningState(this.toggleCheckbox(n));
                break;
            }
            case 401754: {
                this.state.setMergingTrafficState(this.toggleCheckbox(n));
                break;
            }
            case 401750: {
                this.state.setLaneWarningState(this.toggleCheckbox(n));
                break;
            }
            case 401752: {
                this.state.setRailwayCrossingWarningState(this.toggleCheckbox(n));
                break;
            }
            case 401753: {
                this.state.setSpeedCameraWarningState(this.toggleCheckbox(n));
                break;
            }
        }
        this.state.saveWarningStates();
    }

    public void resetSettings() {
        this.env.getLogChannel().log(1078071040, "AsiaWarningsStateSetupListener#resetSettings()");
        this.state.restoreDefault();
        this.initModels(this.state);
        this.state.saveWarningStates();
    }
}

