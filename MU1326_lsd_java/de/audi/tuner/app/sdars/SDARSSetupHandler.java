/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.AbstractSetupHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.storage.TunerStorage;

public class SDARSSetupHandler
extends AbstractSetupHandler {
    static final int SDARS_SETUP_ACTIVATION = 0;
    static final int SDARS_SETUP_UNUSED_II = 1;
    static final int SDARS_SETUP_STATION_SORT_ORDER_ALGO = 2;
    static final int SDARS_SETUP_MUSIC_ALERT = 3;
    static final int SDARS_SETUP_GAME_ALERT = 4;
    private static final int SDARS_SETUP_UNUSED_III = 5;
    private static final int SDARS_SETUP_SIZE = 6;
    private final TunerStorage storage;

    SDARSSetupHandler(Logger logger, TunerStorage tunerStorage) {
        super("SDARS", logger, tunerStorage);
        this.storage = tunerStorage;
    }

    protected int[] loadSetup() {
        return this.storage.loadSDARSSetup();
    }

    protected void storeSetup(int[] nArray) {
        this.storage.storeSDARSSetup(nArray);
    }

    public static int[] getDefaultSetup() {
        int[] nArray = new int[]{1, 0, 0, 1, 1, 0};
        return nArray;
    }

    protected int[] checkSetupByVariant(int[] nArray) {
        if (nArray.length < 6) {
            return SDARSSetupHandler.getDefaultSetup();
        }
        if (nArray[0] < 0 || nArray[0] > 1) {
            nArray[0] = 1;
        }
        if (nArray[2] < 1 || nArray[2] > 4) {
            nArray[2] = 0;
        }
        return nArray;
    }
}

