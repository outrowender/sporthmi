/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public interface IAirconNozzleState {
    public static final int PROPERTY_AIRFLOW = 0;
    public static final int PROPERTY_POSITION_HORIZONTAL = 1;
    public static final int PROPERTY_POSITION_VERTICAL = 2;
    public static final int PROPERTY_STYLE = 3;
    public static final int NUMBER_OF_OPTIONS = 4;

    public int getUniqueID();

    public String getName();

    public int getRow();

    public int getPos();

    public int getHorizontalLocation();

    public int getVerticalLocation();

    public int getAirflow();

    public int getHorizontalPosition();

    public int getVerticalPosition();

    public AirconNozzleListStyles getStyle();

    public void setAirflow(int var1);

    public void setAirflow(int var1, boolean var2);

    public void setHorizontalPosition(int var1);

    public void setHorizontalPosition(int var1, boolean var2);

    public void setVerticalPosition(int var1);

    public void setVerticalPosition(int var1, boolean var2);

    public void setPosition(int var1, int var2);

    public void setPosition(int var1, int var2, boolean var3);

    public void setStyle(AirconNozzleListStyles var1);

    public void setStyle(AirconNozzleListStyles var1, boolean var2);

    public int getCurrentAirflow();

    public int getCurrentHorizontalPosition();

    public int getCurrentVerticalPosition();

    public AirconNozzleListStyles getCurrentStyle();

    public boolean isWaitingForAcknowledge(int var1);
}

