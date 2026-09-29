/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.AbstractSetupHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.storage.TunerStorage;

public class AMFMSetupHandler
extends AbstractSetupHandler {
    static final int AMFM_SETUP_STATION_SORT_AM_INDEX;
    static final int AMFM_SETUP_STATION_TRACE_INDEX;
    static final int AMFM_SETUP_STATION_TRACE_REG_INDEX;
    static final int AMFM_SETUP_RECP_PREF_MODE_INDEX;
    static final int AMFM_SETUP_HD_ON_OFF_INDEX;
    static final int AMFM_SETUP_STATION_NAME_FIXVAR_INDEX;
    static final int AMFM_SETUP_STATION_NAME_ONOFF_INDEX;
    static final int AMFM_SETUP_STATION_SORT_FM_INDEX;
    static final int AMFM_SETUP_HD_ON_OFF_FM_INDEX;
    static final int AMFM_SETUP_HD_ON_OFF_AM_INDEX;
    private static final int AMFM_SETUP_SIZE;

    AMFMSetupHandler(Logger logger, TunerStorage tunerStorage) {
        super("AMFM", logger, tunerStorage);
    }

    @Override
    protected int[] loadSetup() {
        return this.storage.loadAMFMSetup();
    }

    @Override
    protected void storeSetup(int[] nArray) {
        if (nArray.length == 10) {
            this.storage.storeAMFMSetup(nArray, true);
        } else {
            this.logger.main.log(10000, "[AMFMSetupHandler#storeSetup], Not storing setup, wrong size (is %1, expected %2)", (long)nArray.length, (long)0);
        }
    }

    public static int[] getDefaultSetup() {
        int[] nArray = new int[10];
        nArray[1] = Utilities.isPiIgnore() ? 0 : 1;
        nArray[2] = 1;
        nArray[4] = Utilities.isHdDefaultOn() ? 1 : 0;
        nArray[5] = 0;
        nArray[6] = 1;
        nArray[7] = Utilities.isPiIgnore() ? 2 : 0;
        nArray[0] = 2;
        nArray[8] = Utilities.isHdDefaultOn() ? 1 : 0;
        nArray[9] = Utilities.isHdDefaultOn() ? 1 : 0;
        return nArray;
    }

    @Override
    protected int[] checkSetupByVariant(int[] nArray) {
        if (nArray.length != 10) {
            nArray = AMFMSetupHandler.getDefaultSetup();
        }
        nArray[6] = 1;
        if (Utilities.isSinglePiMode()) {
            nArray[5] = 0;
            if (nArray[7] == 2) {
                nArray[7] = 0;
            }
        } else {
            nArray[7] = 2;
            nArray[1] = 0;
        }
        if (!Utilities.isPGen1OrBentley()) {
            nArray[0] = 2;
        }
        if (!Utilities.isNARBuild()) {
            nArray[8] = 0;
            nArray[9] = 0;
        }
        return nArray;
    }
}

