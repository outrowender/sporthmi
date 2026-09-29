/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.tm.UserInputModeHandler$1;
import de.audi.tv.app.tm.UserInputModeHandler$BackVirtualButtonListener;
import de.audi.tv.app.tm.UserInputModeHandler$HkSelectionVirtualButtonListener;
import de.audi.tv.app.tm.UserInputModeHandler$JoystickWestVirtualButtonListener;

public class UserInputModeHandler {
    private final TVEventDispatcher eventDispatcher;
    private final TVEnv env;
    public static final int MODE_PANEL;
    public static final int MODE_TOUCH;
    private int currentMode = 0;
    private final ChoiceModelApp operationalPanelVisibleChoice;

    protected UserInputModeHandler(TVEnv tVEnv, TVEventDispatcher tVEventDispatcher) {
        this.eventDispatcher = tVEventDispatcher;
        this.env = tVEnv;
        this.operationalPanelVisibleChoice = tVEnv.getChoiceModel(-424925440);
        this.operationalPanelVisibleChoice.setValue(1);
        tVEnv.getChoiceModel(-374593792).setChoiceListener(new UserInputModeHandler$1(this, tVEnv));
        tVEnv.getVirtualButtonModelModel(-240376064).setVirtualButtonListener(new UserInputModeHandler$BackVirtualButtonListener(this, null));
        tVEnv.getVirtualButtonModelModel(-55826688).setVirtualButtonListener(new UserInputModeHandler$HkSelectionVirtualButtonListener(this, null));
        tVEnv.getVirtualButtonModelModel(78456576).setVirtualButtonListener(new UserInputModeHandler$JoystickWestVirtualButtonListener(this, null));
    }

    protected final synchronized void changeUserInputMode(int n) {
        if (n == 0) {
            this.currentMode = 0;
            this.operationalPanelVisibleChoice.setValue(1);
        } else if (n == 1) {
            this.currentMode = 1;
            this.operationalPanelVisibleChoice.setValue(0);
        }
        this.eventDispatcher.updateTerminalModeInputMode(n);
    }

    protected final synchronized int getCurrentMode() {
        return this.currentMode;
    }

    static /* synthetic */ TVEnv access$300(UserInputModeHandler userInputModeHandler) {
        return userInputModeHandler.env;
    }
}

