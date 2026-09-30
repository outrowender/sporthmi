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
            navigationEnv.getButtonModel(400868).setButtonListener(this);
        }
        catch (NullPointerException nullPointerException) {
            navigationEnv.getLogChannel().log(100000, "StartupHMIListener#constructor EXCEPTION: %1", (Throwable)nullPointerException);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == 400868) {
            this.operationManager.proceedWithoutCalibration();
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

