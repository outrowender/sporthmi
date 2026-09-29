/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.as;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.as.TelInitPhoneNotFuncAssociatedHandler$1;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class TelInitPhoneNotFuncAssociatedHandler
extends AbstractPhoneComponent {
    private final TelEvoPopupHandler popupHandler;

    public TelInitPhoneNotFuncAssociatedHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.popupHandler = new TelEvoPopupHandler(iTelApplication, -242023424);
        this.addSubPhoneComponent(this.popupHandler);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(0x3000200, (IGlobalTelephoneStateListener)this);
        this.getApplication().addDiagnosisComponent(new TelInitPhoneNotFuncAssociatedHandler$1(this));
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(0x3000200, (IGlobalTelephoneStateListener)this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x3000200 && iGlobalTelephoneStateStruct != null) {
            ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationStateAssociated();
            if (activationStateStruct != null && activationStateStruct.getTelActivationState() == 9) {
                this.popupHandler.requestShowPopup();
            } else {
                this.popupHandler.requestRemovePopup();
            }
        } else {
            this.log.log(-1601830656, "[TelInitPhoneNotFuncAssociatedHandler#updateGlobalTelephoneStateProperty] received update for %1 --> NOP!", (Object)GlobalTelephoneState.getAttributeName(n));
        }
    }

    static /* synthetic */ TelEvoPopupHandler access$000(TelInitPhoneNotFuncAssociatedHandler telInitPhoneNotFuncAssociatedHandler) {
        return telInitPhoneNotFuncAssociatedHandler.popupHandler;
    }
}

