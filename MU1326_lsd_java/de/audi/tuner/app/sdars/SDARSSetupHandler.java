/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.AbstractSetupHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.storage.TunerStorage;

public class SDARSSetupHandler
extends AbstractSetupHandler {
    static final int SDARS_SETUP_ACTIVATION;
    static final int SDARS_SETUP_UNUSED_II;
    static final int SDARS_SETUP_STATION_SORT_ORDER_ALGO;
    static final int SDARS_SETUP_MUSIC_ALERT;
    static final int SDARS_SETUP_GAME_ALERT;
    private static final int SDARS_SETUP_UNUSED_III;
    private static final int SDARS_SETUP_SIZE;
    private final TunerStorage storage;

    SDARSSetupHandler(Logger logger, TunerStorage tunerStorage) {
        super("SDARS", logger, tunerStorage);
        this.storage = tunerStorage;
    }

    @Override
    protected int[] loadSetup() {
        return this.storage.loadSDARSSetup();
    }

    @Override
    protected void storeSetup(int[] nArray) {
        this.storage.storeSDARSSetup(nArray);
    }

    public static int[] getDefaultSetup() {
        int[] nArray = new int[]{1, 0, 0, 1, 1, 0};
        return nArray;
    }

    @Override
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

