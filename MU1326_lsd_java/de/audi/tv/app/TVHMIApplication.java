/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.IScreenActionListener;
import de.audi.tv.app.base.TVEnv;

public class TVHMIApplication
implements HMIApplication {
    public static final int HMI_APP_ID = 26;
    private final TVEnv env;
    private final LogChannel log;
    private IScreenActionListener[] listeners = new IScreenActionListener[0];

    public TVHMIApplication(TVEnv tVEnv) {
        this.env = tVEnv;
        this.log = tVEnv.lcHMI;
    }

    public void addListeners(IScreenActionListener[] iScreenActionListenerArray) {
        IScreenActionListener[] iScreenActionListenerArray2 = new IScreenActionListener[iScreenActionListenerArray.length + this.listeners.length];
        System.arraycopy((Object)this.listeners, 0, (Object)iScreenActionListenerArray2, 0, this.listeners.length);
        System.arraycopy((Object)iScreenActionListenerArray, 0, (Object)iScreenActionListenerArray2, this.listeners.length, iScreenActionListenerArray.length);
        this.listeners = iScreenActionListenerArray2;
    }

    public int getId() {
        return 26;
    }

    public ButtonModelApp getVirtualButton(int n) {
        ButtonModelApp buttonModelApp = null;
        switch (n) {
            case 0: {
                buttonModelApp = this.env.getButtonModel(2600052);
                break;
            }
            case 1: {
                buttonModelApp = this.env.getButtonModel(2600051);
                break;
            }
            case 13: {
                buttonModelApp = this.env.getButtonModel(2600205);
                break;
            }
            default: {
                int n2 = this.env.getVarExt().getVirtualButtonModelId(n);
                if (n2 == -1) break;
                buttonModelApp = this.env.getButtonModel(n2);
            }
        }
        return buttonModelApp;
    }

    public void popupVisible(int n, int n2) {
        this.log.log(10000000, "Popup %1 is visible ", (long)n);
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].popupVisible(n, n2);
        }
    }

    public void popupHidden(int n, int n2) {
        this.log.log(10000000, "Popup %1 is hidden ", (long)n);
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].popupHidden(n, n2);
        }
    }

    public void popupRemoved(int n, int n2) {
        this.log.log(10000000, "Popup %1 is removed ", (long)n);
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].popupRemoved(n, n2);
        }
    }

    public void screenVisible(int n, int n2) {
        this.log.log(10000000, "[TVHMIApplication.screenVisible] screen:%1", (long)n);
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].screenVisible(n, n2);
        }
    }

    public void screenHidden(int n, int n2) {
        this.log.log(10000000, "[TVHMIApplication.screenHidden] screen:%1", (long)n);
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].screenHidden(n, n2);
        }
    }

    public void screenFadedOut(int n, int n2) {
        this.log.log(10000000, "[TVHMIApplication.screenFadedOut] screen:%1", (long)n);
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].screenFadedOut(n, n2);
        }
    }

    public void screenConnected(int n, int n2) {
    }
}

