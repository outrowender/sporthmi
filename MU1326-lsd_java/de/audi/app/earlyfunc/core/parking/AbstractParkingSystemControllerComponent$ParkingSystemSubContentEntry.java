/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import java.util.LinkedList;
import java.util.List;

class AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry {
    private final int popup;
    private final boolean parkingSystemAPS;
    private final boolean parkingSystemOPS;
    private final boolean parkingSystemVPS;
    private final boolean parkingSystemARA;
    private final boolean parkingSystemPLA;
    private final boolean parkingSystemSETTINGS;
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    public AbstractParkingSystemControllerComponent$ParkingSystemSubContentEntry(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.this$0 = abstractParkingSystemControllerComponent;
        this.popup = n;
        this.parkingSystemAPS = bl;
        this.parkingSystemOPS = bl2;
        this.parkingSystemVPS = bl3;
        this.parkingSystemARA = bl4;
        this.parkingSystemPLA = bl5;
        this.parkingSystemSETTINGS = bl6;
    }

    public int getPopup() {
        return this.popup;
    }

    public List getInvolvedParkingSystems() {
        LinkedList linkedList = new LinkedList();
        if (this.parkingSystemAPS) {
            linkedList.add(new Integer(1));
        }
        if (this.parkingSystemOPS) {
            linkedList.add(new Integer(2));
        }
        if (this.parkingSystemVPS) {
            linkedList.add(new Integer(4));
        }
        if (this.parkingSystemARA) {
            linkedList.add(new Integer(8));
        }
        if (this.parkingSystemPLA) {
            linkedList.add(new Integer(16));
        }
        if (this.parkingSystemSETTINGS) {
            linkedList.add(new Integer(32));
        }
        return linkedList;
    }
}

