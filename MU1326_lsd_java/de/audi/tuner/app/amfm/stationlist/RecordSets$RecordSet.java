/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;

interface RecordSets$RecordSet {
    default public int getFmRecordSet(AMFMStation aMFMStation) {
    }

    default public int getAmRecordSet(AMFMStation aMFMStation) {
    }

    default public void setNamesOnOff(boolean bl) {
    }
}

