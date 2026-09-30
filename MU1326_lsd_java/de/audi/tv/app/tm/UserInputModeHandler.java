/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultVirtualButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDispatcher;

public class UserInputModeHandler {
    private final TVEventDispatcher eventDispatcher;
    private final TVEnv env;
    public static final int MODE_PANEL = 0;
    public static final int MODE_TOUCH = 1;
    private int currentMode = 0;
    private final ChoiceModelApp operationalPanelVisibleChoice;

    protected UserInputModeHandler(final TVEnv tVEnv, TVEventDispatcher tVEventDispatcher) {
        this.eventDispatcher = tVEventDispatcher;
        this.env = tVEnv;
        this.operationalPanelVisibleChoice = tVEnv.getChoiceModel(2600166);
        this.operationalPanelVisibleChoice.setValue(1);
        tVEnv.getChoiceModel(2600169).setChoiceListener(new DefaultChoiceListener(){

            public void keyTyped(int n, int n2, int n3) {
                tVEnv.lcHMI.log(10000000, "[UserInputModeHandler.keyTyped] key panel timout");
                UserInputModeHandler.this.changeUserInputMode(1);
            }
        });
        tVEnv.getVirtualButtonModelModel(2600177).setVirtualButtonListener(new BackVirtualButtonListener());
        tVEnv.getVirtualButtonModelModel(2600188).setVirtualButtonListener(new HkSelectionVirtualButtonListener());
        tVEnv.getVirtualButtonModelModel(2600196).setVirtualButtonListener(new JoystickWestVirtualButtonListener());
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

    private class BackVirtualButtonListener
    extends DefaultVirtualButtonListener {
        private BackVirtualButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            int n4 = UserInputModeHandler.this.getCurrentMode();
            ((UserInputModeHandler)UserInputModeHandler.this).env.lcHMI.log(10000000, "[UserInputModeHandler.keyTyped] HK back pressed, mode: %1", (long)n4);
            if (n4 == 0) {
                UserInputModeHandler.this.changeUserInputMode(1);
            } else {
                ((UserInputModeHandler)UserInputModeHandler.this).env.properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
                UserInputModeHandler.this.env.getVirtualButtonModelModel(n).fireEvent(n3);
            }
        }
    }

    private class HkSelectionVirtualButtonListener
    extends DefaultVirtualButtonListener {
        private HkSelectionVirtualButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            int n4 = UserInputModeHandler.this.getCurrentMode();
            ((UserInputModeHandler)UserInputModeHandler.this).env.lcHMI.log(10000000, "[UserInputModeHandler.keyTyped] HK selection pressed, mode: %1", (long)n4);
            ((UserInputModeHandler)UserInputModeHandler.this).env.properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
            UserInputModeHandler.this.env.getVirtualButtonModelModel(n).fireEvent(n3);
        }
    }

    private class JoystickWestVirtualButtonListener
    extends DefaultVirtualButtonListener {
        private JoystickWestVirtualButtonListener() {
        }

        public void stickW(int n, int n2) {
            int n3 = UserInputModeHandler.this.getCurrentMode();
            ((UserInputModeHandler)UserInputModeHandler.this).env.lcHMI.log(10000000, "[UserInputModeHandler.keyTyped] Joystick west pressed, mode: %1", (long)n3);
            ((UserInputModeHandler)UserInputModeHandler.this).env.properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
            UserInputModeHandler.this.env.getVirtualButtonModelModel(n).fireEvent(n2);
        }
    }
}

