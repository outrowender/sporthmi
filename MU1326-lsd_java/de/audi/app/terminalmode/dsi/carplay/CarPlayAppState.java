/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractAppState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import org.dsi.ifc.carplay.AppState;

public class CarPlayAppState
extends AbstractAppState
implements IDSIAppState {
    public CarPlayAppState(AppState appState) {
        super(CarPlayAppState.mapAppIdCarplay2HMI(appState.getAppStateID()), CarPlayAppState.mapOwnerCarplay2HMI(appState.getOwner()), CarPlayAppState.mapSpeechModeCarplay2HMI(appState.getSpeechMode()));
    }

    public CarPlayAppState(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    @Override
    public int getDSIAppStateId() {
        return CarPlayAppState.mapAppIdHMI2Carplay(this.getAppStateId());
    }

    @Override
    public int getDSIOwner() {
        return CarPlayAppState.mapOwnerHMI2CarPlay(this.getOwner());
    }

    @Override
    public int getDSISpeechMode() {
        return CarPlayAppState.mapSpeechModeHMI2Carplay(this.getSpeechMode());
    }

    public static int mapAppIdCarplay2HMI(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    public static int mapOwnerCarplay2HMI(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    public static int mapSpeechModeCarplay2HMI(int n) {
        switch (n) {
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
        }
        return 0;
    }

    public static int mapAppIdHMI2Carplay(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    public static int mapOwnerHMI2CarPlay(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    public static int mapSpeechModeHMI2Carplay(int n) {
        switch (n) {
            case 2: {
                return 3;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }
}

