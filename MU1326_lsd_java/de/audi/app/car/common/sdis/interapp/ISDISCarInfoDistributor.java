/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis.interapp;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import java.util.HashMap;

public interface ISDISCarInfoDistributor
extends CarServiceTrackerListener {
    public static final int VIN_VISIBILITY;
    public static final int OIL_VISIBILITY;
    public static final int SIA_SERVICE_VISIBILITY;
    public static final int SIA_OIL_VISIBILITY;
    public static final int KEY_VISIBILITY;
    public static final int SPORTCHRONO_VISIBILITY;
    public static final int ZEROEMISSION_VISIBILITY;
    public static final int VIN_CONTENT;
    public static final int OIL_CONTENT;
    public static final int SIA_SERVICE_CONTENT;
    public static final int SIA_OIL_CONTENT;
    public static final int KEY_CONTENT;
    public static final int SPORTCHRONO_COMPONENT_CONTENT;
    public static final int SPORTCHRONO_RECORD_MODE_CONTENT;
    public static final int SPORTCHRONO_ACTIVE_RECORD_CONTENT;
    public static final int SPORTCHRONO_ACTIVE_RECORD_DATA_CONTENT;
    public static final int SPORTCHRONO_TRACK_LIST_CONTENT;
    public static final int SPORTCHRONO_TRANSFER_STATE_CONTENT;
    public static final int ZEROEMISSION_ACCESS_CONTENT;
    public static final int ZEROEMISSION_CURRENT_BARGRAPH_CONTENT;
    public static final int ZEROEMISSION_HISTORY_BARGRAPH_CONTENT;

    default public void init(HashMap hashMap) {
    }

    default public void sendContent(int n, Object object) {
    }
}

