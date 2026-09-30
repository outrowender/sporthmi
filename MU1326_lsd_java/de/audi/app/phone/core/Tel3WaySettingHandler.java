/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ChoiceListener;

public class Tel3WaySettingHandler
extends AbstractPhoneComponent
implements ChoiceListener {
    public Tel3WaySettingHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getChoiceModel(300387).setChoiceListener(this);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getChoiceModel(300387).resetListener();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 65545) {
            this.getChoiceModel(300387).setValue(iGlobalTelephoneStateStruct.isCdmaThreeWayCallingSetting() ? 1 : 0);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[Tel3WaySettingHandler#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[Tel3WaySettingHandler#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedChoice(n, n2, n3, n4));
        }
        boolean bl = n2 == 1;
        this.log.log(10000000, "[Tel3WaySettingHandler#itemSelected] setting via DSI to %1", bl);
        this.getApplication().getTelephoneDSIAccess().requestSetCDMAThreeWayCallingSetting(bl, n4);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

