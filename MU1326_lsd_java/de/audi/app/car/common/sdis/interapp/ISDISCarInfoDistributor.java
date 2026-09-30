/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis.interapp;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import java.util.HashMap;

public interface ISDISCarInfoDistributor
extends CarServiceTrackerListener {
    public static final int VIN_VISIBILITY = 0;
    public static final int OIL_VISIBILITY = 1;
    public static final int SIA_SERVICE_VISIBILITY = 2;
    public static final int SIA_OIL_VISIBILITY = 3;
    public static final int KEY_VISIBILITY = 4;
    public static final int SPORTCHRONO_VISIBILITY = 101;
    public static final int ZEROEMISSION_VISIBILITY = 102;
    public static final int VIN_CONTENT = 4000;
    public static final int OIL_CONTENT = 4001;
    public static final int SIA_SERVICE_CONTENT = 4002;
    public static final int SIA_OIL_CONTENT = 4003;
    public static final int KEY_CONTENT = 4004;
    public static final int SPORTCHRONO_COMPONENT_CONTENT = 4101;
    public static final int SPORTCHRONO_RECORD_MODE_CONTENT = 4102;
    public static final int SPORTCHRONO_ACTIVE_RECORD_CONTENT = 4103;
    public static final int SPORTCHRONO_ACTIVE_RECORD_DATA_CONTENT = 4104;
    public static final int SPORTCHRONO_TRACK_LIST_CONTENT = 4105;
    public static final int SPORTCHRONO_TRANSFER_STATE_CONTENT = 4106;
    public static final int ZEROEMISSION_ACCESS_CONTENT = 4200;
    public static final int ZEROEMISSION_CURRENT_BARGRAPH_CONTENT = 4201;
    public static final int ZEROEMISSION_HISTORY_BARGRAPH_CONTENT = 4202;

    public void init(HashMap var1);

    public void sendContent(int var1, Object var2);
}

