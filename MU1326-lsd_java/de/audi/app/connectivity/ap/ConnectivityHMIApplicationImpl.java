/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.ap;

import de.audi.app.data.core.IDataApplication;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class ConnectivityHMIApplicationImpl
implements HMIApplication {
    private static final int CONNECTIVITY_APPLICATION_ID;
    private final IDataApplication data;

    public ConnectivityHMIApplicationImpl(IDataApplication iDataApplication) {
        this.data = iDataApplication;
    }

    @Override
    public int getId() {
        return 25;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
        if (n == -309132288 && this.data != null) {
            this.data.getOnline().telUnlockEntered();
        }
    }

    @Override
    public void popupHidden(int n, int n2) {
        if (n == -1541069312 && this.data != null) {
            this.data.getLogChannel().log(1078071040, "ConnectivityHMIApplicationImpl#popupHidden(): removing popup %1", (long)n);
            this.data.getFramework().getHmiServiceApp().removePopup(n);
        }
    }

    @Override
    public void popupRemoved(int n, int n2) {
        if (n == -1541069312 && this.data != null) {
            this.data.getOnline().onlinePopupRemoved();
        } else if (n == -309132288 && this.data != null) {
            this.data.getOnline().telUnlockLeft();
        }
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
    }
}

