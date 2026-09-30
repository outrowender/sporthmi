/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.IUGDOComponent;
import de.audi.app.car.core.comfort.IUGDOSynchronizationHandler;
import de.audi.app.car.core.comfort.UGDOHelper;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public class UGDOSynchronizationHandler
implements IUGDOSynchronizationHandler,
ButtonListener {
    protected final LogChannel logChannel;
    protected final IUGDOComponent ugdoComponent;
    protected final ICarApplication application;
    public static final int SYNC_STATE_IDLE = 0;
    public static final int SYNC_STATE_ERROR = 1;
    public static final int SYNC_STATE_SUCCESS = 2;
    public static final int SYNC_STATE_WAIT_USER_PRESS_BUTTON = 3;
    public static final int SYNC_STATE_WAIT_RESET_RECEIVER = 4;
    public static final int SYNC_STATE_WAIT_RESET_RECEIVER_SECOND = 5;
    public static final int SYNC_STATE_WRONG_BUTTON = 6;
    public static final int SYNC_STATE_CHECK_MOVEMENT = 7;
    public static final int SYNC_STATE_ABORT = 8;
    private static final String[] SYNC_STATES = new String[]{"IDLE", "ERROR", "SUCCESS", "WAIT_USER_PRESS_BUTTON", "WAIT_RESET_RECEIVER", "WAIT_RESET_RECEIVER_SECOND", "WRONG_BUTTON", "CHECK_MOVEMENT", "ABORT"};
    private volatile int currentSoftkey = 0;
    private volatile boolean syncRunning;

    public UGDOSynchronizationHandler(ICarApplication iCarApplication, IUGDOComponent iUGDOComponent, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.ugdoComponent = iUGDOComponent;
        this.application = iCarApplication;
    }

    protected void init() {
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600431).setButtonListener(this);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600432).setButtonListener(this);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(601194).setButtonListener(this);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600433).setButtonListener(this);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(602708).setButtonListener(this);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(601827).setButtonListener(this);
        this.setInitValueOfRollingCodeState();
    }

    protected void deinit() {
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600431).resetListener();
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600432).resetListener();
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600433).resetListener();
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(601194).resetListener();
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(601827).resetListener();
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(602708).resetListener();
    }

    public void setInitValueOfRollingCodeState() {
        this.setSyncStatus(3);
    }

    public void startSync(int n) {
        this.logChannel.log(1000000, "[UGDOSynchronizationHandler#startSync] syncRunning: true");
        this.syncRunning = true;
        this.currentSoftkey = n;
        this.setSyncStatus(0);
        UGDOSynchronisation uGDOSynchronisation = new UGDOSynchronisation();
        uGDOSynchronisation.state = 0;
        uGDOSynchronisation.doorMovement = 0;
        uGDOSynchronisation.softkey = this.currentSoftkey;
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[UGDOSynchronizationHandler#startSync] dsi.setUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
        }
        this.ugdoComponent.getDSICarComfort().setUGDOSynchronisation(uGDOSynchronisation);
    }

    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.changeStatus(uGDOSynchronisation.getState());
    }

    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        int n = uGDOSynchronisation.getState();
        this.changeStatus(n);
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 6: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#response] dsi.responseUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
                this.ugdoComponent.getDSICarComfort().responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 5: 
            case 7: {
                this.ugdoComponent.getDSICarComfort().responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 4: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#] requestUGDOSynchronisation(UGDOSYNCSTATE_SUCCESSFUL)");
                break;
            }
            case 255: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#] requestUGDOSynchronisation(UGDOSYNCSTATE_INIT) ignored");
                break;
            }
            default: {
                this.logChannel.log(100000, "[UGDOSynchronizationHandler#request] unexpected state %1 of dsi.requestUGDOSynchronisation, not supported and specified.", (long)n);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[UGDOSynchronizationHandler#keyPressed] modelID='%1'", (long)n);
        switch (n) {
            case 600431: {
                UGDOSynchronisation uGDOSynchronisation = new UGDOSynchronisation();
                uGDOSynchronisation.state = 6;
                uGDOSynchronisation.doorMovement = 1;
                uGDOSynchronisation.softkey = this.currentSoftkey;
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#keyPressed] dsi.setUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
                this.ugdoComponent.getDSICarComfort().setUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 600432: {
                UGDOSynchronisation uGDOSynchronisation = new UGDOSynchronisation();
                uGDOSynchronisation.state = 6;
                uGDOSynchronisation.doorMovement = 2;
                uGDOSynchronisation.softkey = this.currentSoftkey;
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#keyPressed] dsi.setUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
                this.ugdoComponent.getDSICarComfort().setUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 600433: {
                this.logChannel.log(1000000, "YES button in screen ***_UGDO_LEARN_BUTTON_ROLL_CANCEL has been pressed");
                this.syncRunning = true;
                this.application.getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                break;
            }
            case 601194: {
                UGDOSynchronisation uGDOSynchronisation = new UGDOSynchronisation();
                uGDOSynchronisation.state = 0;
                uGDOSynchronisation.doorMovement = 0;
                uGDOSynchronisation.softkey = this.currentSoftkey;
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#keyPressed] abort learning roll system -> dsi.setUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
                this.ugdoComponent.getDSICarComfort().setUGDOSynchronisation(uGDOSynchronisation);
                this.application.getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                break;
            }
            case 601827: {
                this.syncRunning = true;
                this.logChannel.log(1000000, "NO button in screen ***_UGDO_LEARN_BUTTON_ROLL_ERROR has been pressed");
                this.application.getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                break;
            }
            case 602708: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#keyPressed] UGDO_LEARN_ROLL_NOT_CANCEL_BUTTON has been pressed");
                this.application.getFrameworkAccess().getHMIService().getButtonModel(602708).fireEvent(0);
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void setSyncStatus(int n) {
        this.logChannel.log(1000000, "[UGDOSynchronizationHandler#setSyncStatus] state='%1'", (Object)SYNC_STATES[n]);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600427).setValue(n);
    }

    private void changeStatus(int n) {
        switch (n) {
            case 255: {
                break;
            }
            case 4: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#changeStatus] syncRunning: false");
                this.syncRunning = false;
                this.setSyncStatus(2);
                break;
            }
            case 5: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#changeStatus] syncRunning: false");
                this.syncRunning = false;
                this.setSyncStatus(1);
                break;
            }
            case 7: {
                this.logChannel.log(1000000, "[UGDOSynchronizationHandler#changeStatus] syncRunning: false");
                this.syncRunning = false;
                this.setSyncStatus(8);
                break;
            }
            case 0: {
                this.setSyncStatus(3);
                break;
            }
            case 1: {
                this.setSyncStatus(4);
                break;
            }
            case 2: {
                this.setSyncStatus(5);
                break;
            }
            case 6: {
                this.setSyncStatus(7);
                break;
            }
            case 3: {
                this.setSyncStatus(6);
                break;
            }
            default: {
                this.setSyncStatus(0);
            }
        }
    }

    public int getInternalSyncState(int n) {
        switch (n) {
            case 255: {
                return 0;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 1;
            }
            case 7: {
                return 8;
            }
            case 0: {
                return 3;
            }
            case 1: {
                return 4;
            }
            case 2: {
                return 5;
            }
            case 6: {
                return 7;
            }
            case 3: {
                return 6;
            }
        }
        return 0;
    }

    public boolean isSyncRunning() {
        return this.syncRunning;
    }

    public void abortSync(int n) {
        UGDOSynchronisation uGDOSynchronisation = new UGDOSynchronisation();
        uGDOSynchronisation.state = 7;
        uGDOSynchronisation.doorMovement = 0;
        uGDOSynchronisation.softkey = n;
        this.ugdoComponent.getDSILogChannel().log(1000000, "[***AbstractUGDOComponent#abortUgdoSync] -> dsi.setUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
        this.getDSICarComfort().setUGDOSynchronisation(uGDOSynchronisation);
        this.setInitValueOfRollingCodeState();
    }

    protected DSICarComfort getDSICarComfort() {
        return this.ugdoComponent.getDSICarComfort();
    }

    public int getCurrentSoftkeyButton() {
        return this.currentSoftkey;
    }
}

