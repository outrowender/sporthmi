/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.vps;

import de.audi.app.earlyfunc.core.parking.vps.AbstractParkingSystemVPSComponent;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.DefaultButtonListener;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;

class AbstractParkingSystemVPSComponent$VPSCameraCleaningButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractParkingSystemVPSComponent this$0;

    public AbstractParkingSystemVPSComponent$VPSCameraCleaningButtonListener(AbstractParkingSystemVPSComponent abstractParkingSystemVPSComponent) {
        this.this$0 = abstractParkingSystemVPSComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        Object object;
        if (AbstractParkingSystemVPSComponent.access$100(this.this$0)) {
            this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingSystemVPSComponent.VPSCameraCleaningButtonListener#keyPressed] Cleaning already active - ignoring");
        } else {
            this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingSystemVPSComponent.VPSCameraCleaningButtonListener#keyPressed] Activating cleaning: getDSI().setVPSCameraCleaning ");
            object = new VPSCameraCleaning(true);
            this.this$0.getDSI().setVPSCameraCleaning((VPSCameraCleaning)object);
        }
        object = AbstractParkingSystemVPSComponent.access$200(this.this$0).getFrameworkAccess().getHMIService();
        DrawerEvent drawerEvent = new DrawerEvent(object.getRootWindow(0), 2);
        object.getEventDispatcher().postEvent(drawerEvent);
    }
}

