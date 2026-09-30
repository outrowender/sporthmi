/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.ap;

import de.audi.app.data.core.IDataApplication;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class ConnectivityHMIApplicationImpl
implements HMIApplication {
    private static final int CONNECTIVITY_APPLICATION_ID = 25;
    private final IDataApplication data;

    public ConnectivityHMIApplicationImpl(IDataApplication iDataApplication) {
        this.data = iDataApplication;
    }

    public int getId() {
        return 25;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void popupVisible(int n, int n2) {
        if (n == 300013 && this.data != null) {
            this.data.getOnline().telUnlockEntered();
        }
    }

    public void popupHidden(int n, int n2) {
        if (n == 2500004 && this.data != null) {
            this.data.getLogChannel().log(1000000, "ConnectivityHMIApplicationImpl#popupHidden(): removing popup %1", (long)n);
            this.data.getFramework().getHmiServiceApp().removePopup(n);
        }
    }

    public void popupRemoved(int n, int n2) {
        if (n == 2500004 && this.data != null) {
            this.data.getOnline().onlinePopupRemoved();
        } else if (n == 300013 && this.data != null) {
            this.data.getOnline().telUnlockLeft();
        }
    }

    public void screenVisible(int n, int n2) {
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }
}

