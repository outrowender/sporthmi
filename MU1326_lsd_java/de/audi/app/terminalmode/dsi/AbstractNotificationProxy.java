/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.atip.util.Util;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractNotificationProxy
implements DSIBase {
    private final GCopyOnWriteList<Integer> attributeList = Generics.newCopyOnWriteArrayList();

    protected abstract DSIBase getDSI();

    protected abstract DSIListener getDSIListener();

    protected void newDSIAvailable() {
        int[] nArray = TerminalModeUtils.getArrayFromList(this.attributeList);
        this.getDSI().setNotification(nArray, this.getDSIListener());
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.attributeList.addIfAbsent(Util.createInteger(nArray[i2]));
        }
        this.getDSI().setNotification(TerminalModeUtils.getArrayFromList(this.attributeList), this.getDSIListener());
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.attributeList.addIfAbsent(Util.createInteger(n));
        this.getDSI().setNotification(TerminalModeUtils.getArrayFromList(this.attributeList), this.getDSIListener());
    }

    public void setNotification(DSIListener dSIListener) {
        this.getDSI().setNotification(this.getDSIListener());
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.attributeList.remove(Util.createInteger(nArray[i2]));
        }
        this.getDSI().clearNotification(nArray, this.getDSIListener());
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.attributeList.remove(Util.createInteger(n));
        this.getDSI().clearNotification(n, this.getDSIListener());
    }

    public void clearNotification(DSIListener dSIListener) {
        this.attributeList.clear();
        this.getDSI().clearNotification(this.getDSIListener());
    }
}

