/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.intellicall.AbstractIntellicallCallListModelHandler;
import de.audi.app.phone.evo.intellicall.IntellicallReducedCallListHandler$1;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class IntellicallReducedCallListHandler
extends AbstractIntellicallCallListModelHandler {
    private boolean intellicallReducedConnected;
    private final Object mutex = new Object();

    public IntellicallReducedCallListHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getPopupScreenStateDispatcher().addScreenStateListener(-426572800, new IntellicallReducedCallListHandler$1(this));
    }

    @Override
    public void updateCallList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        super.updateCallList(iGlobalTelephoneStateStruct);
        CallStateStruct callStateStruct2 = callStateStruct = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
        if (callStateStruct != null && !callStateStruct.isIdle()) {
            this.getChoiceModel(513213440).setValue(1);
        }
    }

    @Override
    protected BaseListModelApp getCallListList() {
        return this.getBaseListModel(479659008);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void updateCallStateIdle(BaseListModelApp baseListModelApp) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.intellicallReducedConnected) {
                this.log.log(1078071040, "[IntellicallReducedCallListHandler#updateCallStateIdle] waiting for faded out before removing calls.");
            } else {
                this.log.log(1078071040, "[IntellicallReducedCallListHandler#updateCallStateIdle] not in Intellicall reduced, removing calls from list.");
                super.updateCallStateIdle(baseListModelApp);
                this.getChoiceModel(513213440).setValue(0);
            }
        }
    }

    static /* synthetic */ Object access$000(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        return intellicallReducedCallListHandler.mutex;
    }

    static /* synthetic */ boolean access$102(IntellicallReducedCallListHandler intellicallReducedCallListHandler, boolean bl) {
        intellicallReducedCallListHandler.intellicallReducedConnected = bl;
        return intellicallReducedCallListHandler.intellicallReducedConnected;
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$200(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        return intellicallReducedCallListHandler.state;
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$300(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        return intellicallReducedCallListHandler.state;
    }

    static /* synthetic */ IGlobalTelephoneStateStruct access$400(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        return intellicallReducedCallListHandler.state;
    }

    static /* synthetic */ LogChannel access$500(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        return intellicallReducedCallListHandler.log;
    }

    static /* synthetic */ ChoiceModelApp access$600(IntellicallReducedCallListHandler intellicallReducedCallListHandler, int n) {
        return intellicallReducedCallListHandler.getChoiceModel(n);
    }

    static /* synthetic */ LogChannel access$700(IntellicallReducedCallListHandler intellicallReducedCallListHandler) {
        return intellicallReducedCallListHandler.log;
    }
}

