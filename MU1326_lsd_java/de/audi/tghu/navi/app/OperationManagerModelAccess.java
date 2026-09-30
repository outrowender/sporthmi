/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;

public class OperationManagerModelAccess {
    private static final int CHOICE_INIT_VALUE_NOTCALIBRATED = -1;
    private static final int CHOICE_INIT_VALUE_UNDEFINED = 0;
    private static final int CHOICE_INIT_VALUE_AVAILABLE = 1;
    private static final int CHOICE_ERROR_DEFAULT = 0;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final ChoiceModelApp initializationChoice;
    private final ChoiceModelApp initializationMediatorChoice;
    private final ChoiceModelApp errorChoice;
    private final ChoiceModelApp naviReady2navigateChoice;
    public static final int CHOICE_READY_TO_NAVIGATE_TRUE = 1;
    public static final int CHOICE_READY_TO_NAVIGATE_FALSE = 0;

    public OperationManagerModelAccess(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.initializationChoice = navigationEnv.getChoiceModel(167);
        this.initializationMediatorChoice = navigationEnv.getChoiceModel(4181);
        this.errorChoice = navigationEnv.getChoiceModel(161);
        this.naviReady2navigateChoice = navigationEnv.getChoiceModel(177);
    }

    public void onStart() {
        this.errorChoice.setValue(0);
        this.initializationChoice.setValue(0);
        Util.setModelStatus(this.initializationChoice, 1);
        this.initializationMediatorChoice.setValue(1);
        this.naviReady2navigateChoice.setValue(0);
    }

    public void onNavStateUpdated(int n, int n2) {
        int n3;
        int n4;
        int n5;
        if (n == 2) {
            n5 = 0;
            n4 = 1;
            n3 = 1;
        } else if (n == 4) {
            n5 = n2;
            n4 = 0;
            n3 = 2;
        } else if (n == 3) {
            n5 = 0;
            n4 = -1;
            n3 = 1;
        } else if (n == 1) {
            n5 = 0;
            n4 = 0;
            n3 = 0;
        } else {
            return;
        }
        this.errorChoice.setValue(n5);
        this.initializationChoice.setValue(n4);
        Util.setModelStatus(this.initializationChoice, n3);
        this.initializationMediatorChoice.setValue(n3);
    }

    public void onPropagateStateToOtherApps(boolean bl) {
        this.naviReady2navigateChoice.setValue(bl ? 1 : 0);
    }

    public ChoiceModelApp getInitializationChoice() {
        return this.initializationChoice;
    }
}

