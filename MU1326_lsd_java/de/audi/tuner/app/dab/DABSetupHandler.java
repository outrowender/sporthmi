/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.AbstractSetupHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.storage.TunerStorage;

public class DABSetupHandler
extends AbstractSetupHandler {
    static final int DAB_SETUP_LBAND_INDEX = 0;
    static final int DAB_SETUP_STATION_TRACE_INDEX = 1;
    static final int DAB_SETUP_STATION_SORT_INDEX = 2;
    public static final int DAB_SETUP_STATION_TRACE_REGIONAL_INDEX = 3;
    private static final int DAB_SETUP_SIZE = 4;

    DABSetupHandler(Logger logger, TunerStorage tunerStorage) {
        super("DAB", logger, tunerStorage);
    }

    public int[] loadSetup() {
        return this.storage.loadDABSetup();
    }

    public void storeSetup(int[] nArray) {
        if (nArray.length == 4) {
            this.storage.storeDABSetup(nArray, true);
        } else {
            this.logger.main.log(10000, "[DABSetupHandler#storeSetup], Not storing setup, wrong size (is %1, expected %2)", (long)nArray.length, 4L);
        }
    }

    public static int[] getDefaultSetup() {
        int[] nArray = new int[]{Utilities.getDAB1Bandsetting() == 3 ? 1 : 0, 1, Utilities.isPGen1OrBentley() ? 0 : 1, 0};
        return nArray;
    }

    protected int[] checkSetupByVariant(int[] nArray) {
        if (Utilities.getDAB1Bandsetting() == 3) {
            nArray[0] = 1;
        }
        return nArray;
    }
}

