/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.startup;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;

public class StartupHMIListener
implements ButtonListener {
    private final OperationManager operationManager;

    public StartupHMIListener(NavigationEnv navigationEnv, OperationManager operationManager) {
        this.operationManager = operationManager;
        try {
            navigationEnv.getButtonModel(-467859968).setButtonListener(this);
        }
        catch (NullPointerException nullPointerException) {
            navigationEnv.getLogChannel().log(-1601830656, "StartupHMIListener#constructor EXCEPTION: %1", (Throwable)nullPointerException);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -467859968) {
            this.operationManager.proceedWithoutCalibration();
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

