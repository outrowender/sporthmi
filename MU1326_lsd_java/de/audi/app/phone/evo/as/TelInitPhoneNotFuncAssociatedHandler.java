/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.as;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.screen.TelEvoPopupHandler;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class TelInitPhoneNotFuncAssociatedHandler
extends AbstractPhoneComponent {
    private final TelEvoPopupHandler popupHandler;

    public TelInitPhoneNotFuncAssociatedHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.popupHandler = new TelEvoPopupHandler(iTelApplication, 300017);
        this.addSubPhoneComponent(this.popupHandler);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(131075, (IGlobalTelephoneStateListener)this);
        this.getApplication().addDiagnosisComponent(new IPhoneDiagComponent(){

            public void cmdShowTelInitPhoneNotFuncAssociatedPopup(boolean bl) {
                if (bl) {
                    TelInitPhoneNotFuncAssociatedHandler.this.popupHandler.requestShowPopup();
                } else {
                    TelInitPhoneNotFuncAssociatedHandler.this.popupHandler.requestRemovePopup();
                }
            }
        });
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(131075, (IGlobalTelephoneStateListener)this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 131075 && iGlobalTelephoneStateStruct != null) {
            ActivationStateStruct activationStateStruct = iGlobalTelephoneStateStruct.getActivationStateAssociated();
            if (activationStateStruct != null && activationStateStruct.getTelActivationState() == 9) {
                this.popupHandler.requestShowPopup();
            } else {
                this.popupHandler.requestRemovePopup();
            }
        } else {
            this.log.log(100000, "[TelInitPhoneNotFuncAssociatedHandler#updateGlobalTelephoneStateProperty] received update for %1 --> NOP!", (Object)GlobalTelephoneState.getAttributeName(n));
        }
    }
}

