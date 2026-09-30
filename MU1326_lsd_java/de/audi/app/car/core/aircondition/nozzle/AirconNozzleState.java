/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.core.aircondition.nozzle.IAirconNozzleState;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public class AirconNozzleState
implements IAirconNozzleState {
    private final int uniqueID;
    private final String name;
    private final int row;
    private final int pos;
    private final int horizontalLocation;
    private final int verticalLocation;
    private volatile int airflow;
    private volatile int horizontalPosition;
    private volatile int verticalPosition;
    private volatile AirconNozzleListStyles style;
    private volatile int currentAirflow;
    private volatile int currentHorizontalPosition;
    private volatile int currentVerticalPosition;
    private volatile AirconNozzleListStyles currentStyle = new AirconNozzleListStyles();
    private final boolean[] waitingForAcknowledge = new boolean[4];

    public AirconNozzleState(int n, String string, int n2, int n3, int n4, int n5) {
        this.uniqueID = n;
        this.name = string;
        this.row = n2;
        this.pos = n3;
        this.horizontalLocation = n4;
        this.verticalLocation = n5;
    }

    public int getUniqueID() {
        return this.uniqueID;
    }

    public String getName() {
        return this.name;
    }

    public int getRow() {
        return this.row;
    }

    public int getPos() {
        return this.pos;
    }

    public int getHorizontalLocation() {
        return this.horizontalLocation;
    }

    public int getVerticalLocation() {
        return this.verticalLocation;
    }

    public int getAirflow() {
        return this.airflow;
    }

    public int getHorizontalPosition() {
        return this.horizontalPosition;
    }

    public int getVerticalPosition() {
        return this.verticalPosition;
    }

    public AirconNozzleListStyles getStyle() {
        return this.style;
    }

    public void setAirflow(int n) {
        this.setAirflow(n, false);
    }

    public void setAirflow(int n, boolean bl) {
        this.currentAirflow = n;
        this.waitingForAcknowledge[0] = bl;
        if (!this.waitingForAcknowledge[0]) {
            this.airflow = n;
        }
    }

    public void setHorizontalPosition(int n) {
        this.setHorizontalPosition(n, false);
    }

    public void setHorizontalPosition(int n, boolean bl) {
        this.currentHorizontalPosition = n;
        this.waitingForAcknowledge[1] = bl;
        if (!this.waitingForAcknowledge[1]) {
            this.horizontalPosition = n;
        }
    }

    public void setVerticalPosition(int n) {
        this.setVerticalPosition(n, false);
    }

    public void setVerticalPosition(int n, boolean bl) {
        this.currentVerticalPosition = n;
        this.waitingForAcknowledge[2] = bl;
        if (!this.waitingForAcknowledge[2]) {
            this.verticalPosition = n;
        }
    }

    public void setPosition(int n, int n2) {
        this.setPosition(n, n2, false);
    }

    public void setPosition(int n, int n2, boolean bl) {
        this.currentHorizontalPosition = n;
        this.currentVerticalPosition = n2;
        this.waitingForAcknowledge[1] = bl;
        if (!this.waitingForAcknowledge[1]) {
            this.horizontalPosition = n;
        }
        if (!(this.waitingForAcknowledge[2] = bl)) {
            this.verticalPosition = n2;
        }
    }

    public void setStyle(AirconNozzleListStyles airconNozzleListStyles) {
        this.setStyle(airconNozzleListStyles, false);
    }

    public void setStyle(AirconNozzleListStyles airconNozzleListStyles, boolean bl) {
        this.currentStyle = airconNozzleListStyles;
        this.waitingForAcknowledge[3] = bl;
        if (!this.waitingForAcknowledge[3]) {
            this.style = airconNozzleListStyles;
        }
    }

    public int getCurrentAirflow() {
        return this.currentAirflow;
    }

    public int getCurrentHorizontalPosition() {
        return this.currentHorizontalPosition;
    }

    public int getCurrentVerticalPosition() {
        return this.currentVerticalPosition;
    }

    public AirconNozzleListStyles getCurrentStyle() {
        return this.currentStyle;
    }

    public boolean isWaitingForAcknowledge(int n) {
        return 0 <= n && 4 > n ? this.waitingForAcknowledge[n] : false;
    }
}

