/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractGoodbyeComponent;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carhybrid.DSICarHybrid;

public class ChargePopupHandler
implements IPopupStateListener {
    private AbstractGoodbyeComponent component;
    private LogChannel logChannel;
    private ICarApplication app;

    public ChargePopupHandler(ICarApplication iCarApplication, AbstractGoodbyeComponent abstractGoodbyeComponent, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.app = iCarApplication;
        this.component = abstractGoodbyeComponent;
    }

    public void init() {
        if (this.component.getPopUpID() != -1) {
            this.app.getScreenStateDispatcher().addPopupStateListener(this.component.getPopUpID(), this);
        }
    }

    public void deinit() {
        if (this.component.getPopUpID() != -1) {
            this.app.getScreenStateDispatcher().removePopupStateListener(this.component.getPopUpID(), this);
        }
    }

    private DSICarHybrid getDSI() {
        return this.component.getDSI();
    }

    public void notifyPopupVisible(int n) {
    }

    public void notifyPopupHidden(int n) {
    }

    public void notifyPopupRemoved(int n) {
    }

    public void requestChargePopup(int n, boolean bl) {
        this.app.getFrameworkAccess().getHmiServiceApp().showPopup(this.component.getPopUpID());
    }

    public void removePopup() {
        this.app.getFrameworkAccess().getHmiServiceApp().removePopup(this.component.getPopUpID());
    }
}

