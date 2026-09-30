/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.calllist.AbstractPhoneCallListHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawaerClosedStatusLineHandler;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawerModelHandler;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.atip.hmi.model.ModelGroup;
import java.util.Map;

public class EntertainmentDrawerHandlerNew
extends AbstractPhoneCallListHandler
implements IActionProxyListener {
    private EntertainmentDrawerModelHandler modelHandler;
    private IEntertainmentDrawerControllerNew drawerController;
    private Object updateMutex = new Object();

    public EntertainmentDrawerHandlerNew(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
        this.modelHandler = new EntertainmentDrawerModelHandler(iTelApplication);
        this.drawerController = ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController();
        this.addSubPhoneComponent(this.modelHandler);
        this.addSubPhoneComponent(new EntertainmentDrawaerClosedStatusLineHandler(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCallList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        Object object = this.updateMutex;
        synchronized (object) {
            if (iGlobalTelephoneStateStruct != null) {
                ModelGroup[] modelGroupArray = this.modelHandler.getEntertainmentDrawerModels(iGlobalTelephoneStateStruct);
                this.drawerController.computeNewDrawerState(modelGroupArray, iGlobalTelephoneStateStruct);
            }
        }
    }

    public void updateCallDurationList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    public void updateMicMuteState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.update(iGlobalTelephoneStateStruct);
    }

    public void updateHandsfreeModeState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.update(iGlobalTelephoneStateStruct);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 7) {
            this.getEntertainmentController().onTelAppEntered(this.state);
        } else if (n == 8) {
            this.getEntertainmentController().onTelAppLeft(this.state);
        } else {
            this.log.log(100000, "[EntertainmentDrawerHandler#actionProxyCallPerformed] unhandled methodID=%1", (long)n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void update(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        Object object = this.updateMutex;
        synchronized (object) {
            if (iGlobalTelephoneStateStruct != null) {
                ModelGroup[] modelGroupArray = this.modelHandler.getEntertainmentDrawerModels(iGlobalTelephoneStateStruct);
                for (int i2 = 0; i2 < modelGroupArray.length; ++i2) {
                    modelGroupArray[i2].flush();
                    modelGroupArray[i2].removeAll();
                }
            }
        }
    }

    private IEntertainmentDrawerControllerNew getEntertainmentController() {
        return ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController();
    }
}

