/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.mer.MenuEntryType;
import java.util.List;

public interface IMenuEntry {
    public static final int STATE_FUNCTIONAL = 0;
    public static final int STATE_INVISIBLE = 1;
    public static final int STATE_DISABLED_ERROR = 2;
    public static final int STATE_DISABLED_CLAMP15 = 3;
    public static final int STATE_DISABLED_SPEED = 4;
    public static final int STATE_DISABLED_ENGINE = 5;
    public static final int STATE_DISABLED_BUS_NOT_ACTIVE = 2;
    public static final int STATE_DISABLED_VEHICLE_STANDSTILL = 6;
    public static final int STATE_DISABLED_SYSTEM_OFF = 7;
    public static final int STATE_DISABLED_TRAILER_HITCHED = 8;
    public static final int STATE_DISABLED_SPECIAL_ERROR = 9;
    public static final int STATE_DISABLED_NO_VIN_RECEIVED = 10;
    public static final int STATE_DISABLED_RESERVED_01 = 11;
    public static final int STATE_DISABLED_RESERVED_02 = 12;
    public static final int STATE_DISABLED_RESERVED_03 = 13;
    public static final int STATE_DISABLED_RESERVED_04 = 14;
    public static final int STATE_DISABLED_RESERVED_05 = 15;
    public static final int STATE_DISABLED_RESERVED_06 = 16;
    public static final int STATE_DISABLED_RESERVED_07 = 17;
    public static final int STATE_DISABLED_RESERVED_08 = 18;
    public static final int STATE_DISABLED_RESERVED_09 = 19;
    public static final int AVAILABLE_MODEL_STATE_NOT_FUNCTIONAL = 0;
    public static final int AVAILABLE_MODEL_STATE_FUNCTIONAL = 1;
    public static final int NO_VISIBILITY_CHOICEMODEL_ID = -1;

    public IMenuEntry getParent();

    public void setChildren(IMenuEntry[] var1);

    public void setParent(IMenuEntry var1);

    public IMenuEntry[] getChildren();

    public void init(IMenuEntryRegistry var1);

    public void deinit();

    public void notifyComponentsInitialized();

    public void register();

    public void deregister();

    public boolean isRegistered();

    public void updateState(int var1);

    public int getState();

    public boolean isTop();

    public boolean isLeaf();

    public int getID();

    public MenuEntryType getType();

    public boolean isType(MenuEntryType var1);

    public boolean isRegistrable();

    public void addChildrenToListRecursively(List var1);

    public void setFunctionalStateValues(int[] var1);

    public void updateStateViewOptions(int var1);

    public void updateStateMenuOperation(int var1);

    public int getStateViewOptionsForRegistration();
}

