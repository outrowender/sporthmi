/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$TogglePhonesOptionHandler;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.LabelModelApp;

class TelIntellicallHandler$TogglePhonesOptionHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ String val$currentAssociatedDeviceName;
    private final /* synthetic */ String val$currentPrimaryDeviceName;
    private final /* synthetic */ TelIntellicallHandler$TogglePhonesOptionHandler this$1;

    TelIntellicallHandler$TogglePhonesOptionHandler$1(TelIntellicallHandler$TogglePhonesOptionHandler telIntellicallHandler$TogglePhonesOptionHandler, String string, String string2) {
        this.this$1 = telIntellicallHandler$TogglePhonesOptionHandler;
        this.val$currentAssociatedDeviceName = string;
        this.val$currentPrimaryDeviceName = string2;
    }

    @Override
    public void responseChangeTopology(int n, int n2) {
        if (n == 0) {
            TelIntellicallHandler$TogglePhonesOptionHandler.access$1000(this.this$1).log(1078071040, "[TelIntellicallHandler.TogglePhonesOptionHandler#responseChangeTopology] Toggle phones key typed: reset Cursor, reset Truffle Search view");
            this.updateDeviceNames(this.val$currentAssociatedDeviceName, this.val$currentPrimaryDeviceName);
            TelIntellicallHandler$TogglePhonesOptionHandler.access$1100(this.this$1).getFrameworkAccess().getHmiServiceApp().showPartialPopup(0, 815072256);
        }
    }

    private void updateDeviceNames(String string, String string2) {
        ModelGroup modelGroup = new ModelGroup();
        LabelModelApp labelModelApp = TelIntellicallHandler$TogglePhonesOptionHandler.access$1200(this.this$1).getFrameworkAccess().getHMIService().getLabelModel(328729600);
        LabelModelApp labelModelApp2 = TelIntellicallHandler$TogglePhonesOptionHandler.access$1300(this.this$1).getFrameworkAccess().getHMIService().getLabelModel(999818240);
        modelGroup.add(labelModelApp);
        modelGroup.add(labelModelApp2);
        labelModelApp.setText(string);
        labelModelApp2.setText(string2);
        modelGroup.flush();
        modelGroup.removeAll();
    }
}

