/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class OPSViewModeHandler
implements IScreenStateListener {
    private static final int OPS_VIEW_MODE_OVER_TOPVIEW_FULL;
    private static final int OPS_VIEW_MODE_OVER_TOPVIEW_REDUCED;
    private static final int OPS_VIEW_MODE_STANDALONE;
    private static final int OPS_BACKGROUND_NONE;
    private static final int OPS_BACKGROUND_FULL;
    private static final int OPS_BACKGROUND_REDUCED;
    private static final int OPS_BACKGROUND_STANDALONE;
    private static final int OPS_BACKGROUND_STANDALONE_EMPTY;
    private ICarApplication application;
    private LogChannel logChannel;
    private int vpsView = -1;
    private int opsViewModeSetting = 0;
    private boolean opsActive = false;
    private boolean araActive = false;
    private int vpsScreenID;
    private volatile boolean vpsScreenConntected;
    private volatile int currentOpsViewMode;
    private int currentBackground = 0;

    public OPSViewModeHandler(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
    }

    public void init(int n) {
        this.vpsScreenID = n;
        this.application.getScreenStateDispatcher().addScreenStateListener(n, this);
    }

    public void deinit() {
        this.application.getScreenStateDispatcher().removeScreenStateListener(this.vpsScreenID, this);
    }

    public void updateVPSView(int n) {
        if (this.vpsView != n) {
            this.vpsView = n;
            this.updateOPSViewMode();
        }
    }

    public void updateOPSViewModeSetting(int n) {
        if (this.opsViewModeSetting != n) {
            this.opsViewModeSetting = n;
            this.updateOPSViewMode();
        }
    }

    public void updateOPSActive(boolean bl) {
        if (this.opsActive != bl) {
            this.opsActive = bl;
            this.updateOPSViewMode();
        }
    }

    public void updateARAActive(boolean bl) {
        if (this.araActive != bl) {
            this.araActive = bl;
            this.updateOPSViewMode();
        }
    }

    public void updateOPSViewMode() {
        ChoiceModelApp choiceModelApp;
        ChoiceModelApp choiceModelApp2 = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(822943744);
        choiceModelApp2.setValue(this.opsActive ? 1 : 0);
        ChoiceModelApp choiceModelApp3 = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1326194688);
        int n = choiceModelApp3.getValue();
        int n2 = 0;
        String string = "OPS_VIEW_MODE_OVER_TOPVIEW_FULL";
        int n3 = 1;
        boolean bl = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(-771022848).getValue() == 0;
        int n4 = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(-737468416).getValue();
        if (n4 == 0) {
            n3 = this.currentBackground;
            if (this.opsActive) {
                if (!this.araActive) {
                    n2 = 2;
                    string = "OPS_VIEW_MODE_STANDALONE";
                    n3 = 3;
                } else {
                    this.currentBackground = n3 = 1;
                }
            }
        } else if (n4 == 1) {
            n3 = this.currentBackground;
            if (this.opsActive) {
                if (this.vpsView == -1 && !this.araActive) {
                    n2 = 2;
                    string = "OPS_VIEW_MODE_STANDALONE";
                    n3 = 3;
                } else {
                    this.currentBackground = n3 = 1;
                }
            }
        } else if (this.vpsView != -1) {
            if (bl && this.vpsView != 4 && this.opsViewModeSetting == 0) {
                n2 = 1;
                string = "OPS_VIEW_MODE_OVER_TOPVIEW_REDUCED";
                if ((this.isVpsScreenConntected() || this.araActive) && this.opsActive) {
                    n3 = 2;
                }
            } else {
                n2 = 0;
                string = "OPS_VIEW_MODE_OVER_TOPVIEW_FULL";
                n3 = 1;
            }
        } else if (this.araActive) {
            n2 = 0;
            string = "OPS_VIEW_MODE_OVER_TOPVIEW_FULL";
            if (this.opsActive) {
                n3 = 1;
            }
        } else if (this.opsActive) {
            n2 = 2;
            string = "OPS_VIEW_MODE_STANDALONE";
            n3 = 3;
        } else {
            n2 = n;
        }
        if (choiceModelApp3.getValue() != n2) {
            this.logChannel.log(1078071040, "[OPSViewModeHandler#updateOPSViewMode] set model value to show %1: modelID='%2', value='%3'", (Object)string, (long)choiceModelApp3.getID(), (long)n2);
            choiceModelApp3.setValue(n2);
            this.setCurrentOpsViewMode(this.currentOpsViewMode);
        }
        if ((choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(-1257496576)).getValue() != n3) {
            this.logChannel.log(1078071040, "[OPSViewModeHandler#updateOPSViewMode] update background: modelID='%1', value='%2'", (long)choiceModelApp3.getID(), (long)n3);
            choiceModelApp.setValue(n3);
        }
    }

    public int getOPSViewModeSetting() {
        return this.opsViewModeSetting;
    }

    @Override
    public void notifyScreenVisible(int n) {
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
    public void notifyScreenConnected(int n) {
        if (n == this.vpsScreenID) {
            this.logChannel.log(-2137614336, "[CharismaComponentEvo#notifyScreenConnected] screenID='%1'", (long)n);
            this.setVpsScreenConntected(true);
            this.updateOPSViewMode();
        }
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        if (n == this.vpsScreenID) {
            this.logChannel.log(-2137614336, "[CharismaComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
            this.setVpsScreenConntected(false);
            this.updateOPSViewMode();
        }
    }

    private boolean isVpsScreenConntected() {
        return this.vpsScreenConntected;
    }

    private void setVpsScreenConntected(boolean bl) {
        this.vpsScreenConntected = bl;
    }

    private int getCurrentOpsViewMode() {
        return this.currentOpsViewMode;
    }

    private void setCurrentOpsViewMode(int n) {
        this.currentOpsViewMode = n;
    }

    public boolean isOpsActive() {
        return this.opsActive;
    }
}

