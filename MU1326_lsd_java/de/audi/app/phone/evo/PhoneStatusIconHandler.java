/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.AbstractEvoPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;
import java.util.Map;
import org.dsi.ifc.telephoneng.RegisterStateStruct;

public class PhoneStatusIconHandler
extends AbstractEvoPhoneComponent
implements IActionProxyListener {
    public PhoneStatusIconHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(4, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(4, this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        int n2 = this.resolveMode(iGlobalTelephoneStateStruct);
        this.log.log(14808325, "PhoneStatusIconHandler#updateGlobalTelephoneStateProperty(): choiceValue: %1", (long)n2);
        this.setValueToStatusbarChoice(n2);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 4) {
            this.log.log(-2137614336, "[PhoneStatusIconHandler#actionProxyCallPerformed] INTELLICALL_FULL_VIEW_ENTERED: resetting missed call indicator via DSIMobileEquipment.");
            this.getApplication().getTelephoneDSIAccess().resetMissedCallIndicator(0);
        }
    }

    private void setValueToStatusbarChoice(int n) {
        this.getChoiceModel(3836).setValue(n);
    }

    private int getRegisterState(RegisterStateStruct registerStateStruct) {
        return registerStateStruct != null ? registerStateStruct.getTelRegisterState() : 0;
    }

    private boolean isRegisterStateDenied(RegisterStateStruct registerStateStruct) {
        return this.getRegisterState(registerStateStruct) == 5;
    }

    private int resolveMode(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        int n = 0;
        boolean bl = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isPhoneReady();
        boolean bl2 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.hasMissedCalls();
        this.log.log(-2137614336, "[PhoneStatusIconHandler#resolveMode] phoneReady=%1, missedCalls=%2, ", bl, bl2);
        if (iGlobalTelephoneStateStruct != null && this.isRegisterStateDenied(iGlobalTelephoneStateStruct.getRegisterState())) {
            n = 5;
        } else if (bl && bl2) {
            n = 2;
        } else if (bl && iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getTelMode() == 3) {
            n = 1;
        }
        return n;
    }
}

