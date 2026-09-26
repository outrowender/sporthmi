/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public interface IAirconNozzleState {
    public static final int PROPERTY_AIRFLOW;
    public static final int PROPERTY_POSITION_HORIZONTAL;
    public static final int PROPERTY_POSITION_VERTICAL;
    public static final int PROPERTY_STYLE;
    public static final int NUMBER_OF_OPTIONS;

    default public int getUniqueID() {
    }

    default public String getName() {
    }

    default public int getRow() {
    }

    default public int getPos() {
    }

    default public int getHorizontalLocation() {
    }

    default public int getVerticalLocation() {
    }

    default public int getAirflow() {
    }

    default public int getHorizontalPosition() {
    }

    default public int getVerticalPosition() {
    }

    default public AirconNozzleListStyles getStyle() {
    }

    default public void setAirflow(int n) {
    }

    default public void setAirflow(int n, boolean bl) {
    }

    default public void setHorizontalPosition(int n) {
    }

    default public void setHorizontalPosition(int n, boolean bl) {
    }

    default public void setVerticalPosition(int n) {
    }

    default public void setVerticalPosition(int n, boolean bl) {
    }

    default public void setPosition(int n, int n2) {
    }

    default public void setPosition(int n, int n2, boolean bl) {
    }

    default public void setStyle(AirconNozzleListStyles airconNozzleListStyles) {
    }

    default public void setStyle(AirconNozzleListStyles airconNozzleListStyles, boolean bl) {
    }

    default public int getCurrentAirflow() {
    }

    default public int getCurrentHorizontalPosition() {
    }

    default public int getCurrentVerticalPosition() {
    }

    default public AirconNozzleListStyles getCurrentStyle() {
    }

    default public boolean isWaitingForAcknowledge(int n) {
    }
}

