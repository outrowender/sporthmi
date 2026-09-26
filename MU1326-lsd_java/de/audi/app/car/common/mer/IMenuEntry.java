/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.mer.MenuEntryType;
import java.util.List;

public interface IMenuEntry {
    public static final int STATE_FUNCTIONAL;
    public static final int STATE_INVISIBLE;
    public static final int STATE_DISABLED_ERROR;
    public static final int STATE_DISABLED_CLAMP15;
    public static final int STATE_DISABLED_SPEED;
    public static final int STATE_DISABLED_ENGINE;
    public static final int STATE_DISABLED_BUS_NOT_ACTIVE;
    public static final int STATE_DISABLED_VEHICLE_STANDSTILL;
    public static final int STATE_DISABLED_SYSTEM_OFF;
    public static final int STATE_DISABLED_TRAILER_HITCHED;
    public static final int STATE_DISABLED_SPECIAL_ERROR;
    public static final int STATE_DISABLED_NO_VIN_RECEIVED;
    public static final int STATE_DISABLED_RESERVED_01;
    public static final int STATE_DISABLED_RESERVED_02;
    public static final int STATE_DISABLED_RESERVED_03;
    public static final int STATE_DISABLED_RESERVED_04;
    public static final int STATE_DISABLED_RESERVED_05;
    public static final int STATE_DISABLED_RESERVED_06;
    public static final int STATE_DISABLED_RESERVED_07;
    public static final int STATE_DISABLED_RESERVED_08;
    public static final int STATE_DISABLED_RESERVED_09;
    public static final int AVAILABLE_MODEL_STATE_NOT_FUNCTIONAL;
    public static final int AVAILABLE_MODEL_STATE_FUNCTIONAL;
    public static final int NO_VISIBILITY_CHOICEMODEL_ID;

    default public IMenuEntry getParent() {
    }

    default public void setChildren(IMenuEntry[] iMenuEntryArray) {
    }

    default public void setParent(IMenuEntry iMenuEntry) {
    }

    default public IMenuEntry[] getChildren() {
    }

    default public void init(IMenuEntryRegistry iMenuEntryRegistry) {
    }

    default public void deinit() {
    }

    default public void notifyComponentsInitialized() {
    }

    default public void register() {
    }

    default public void deregister() {
    }

    default public boolean isRegistered() {
    }

    default public void updateState(int n) {
    }

    default public int getState() {
    }

    default public boolean isTop() {
    }

    default public boolean isLeaf() {
    }

    default public int getID() {
    }

    default public MenuEntryType getType() {
    }

    default public boolean isType(MenuEntryType menuEntryType) {
    }

    default public boolean isRegistrable() {
    }

    default public void addChildrenToListRecursively(List list) {
    }

    default public void setFunctionalStateValues(int[] nArray) {
    }

    default public void updateStateViewOptions(int n) {
    }

    default public void updateStateMenuOperation(int n) {
    }

    default public int getStateViewOptionsForRegistration() {
    }
}

