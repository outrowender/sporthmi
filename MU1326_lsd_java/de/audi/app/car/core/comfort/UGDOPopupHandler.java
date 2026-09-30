/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.car.core.comfort.IUGDOComponent;
import de.audi.app.car.core.comfort.IUGDOLearningHandler;
import de.audi.app.car.core.comfort.IUGDOSynchronizationHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carcomfort.UGDOContent;

public class UGDOPopupHandler
implements IPopupStateListener,
ButtonListener {
    protected final LogChannel logChannel;
    protected final LogChannel dsiLogChannel;
    protected final IUGDOComponent ugdoComponent;
    protected final ICarApplication application;
    private final IUGDOLearningHandler learningHandler;
    private final IUGDOSynchronizationHandler syncHandler;
    private PowerEventListener powerEventListener;
    protected static final short POPUP_NONE = -1;
    protected volatile int currentVisiblePopup = -1;
    protected volatile UGDOContent requestedContent = new UGDOContent();
    protected static final short REMOVE_REASON_NONE = 0;
    protected static final short REMOVE_REASON_CANCEL_USER = 1;
    protected static final short REMOVE_REASON_CANCEL_FSG = 2;
    protected static final short REMOVE_REASON_CANCEL_BUTTONPRESSED = 3;
    protected static final short REMOVE_REASON_HIGHER_PRIOR_POPUP = 4;
    protected static final short REMOVE_REASON_OTHER_UGDO_POPUP = 5;
    protected volatile short removeReason = 0;
    protected volatile int currHardkey = 0;
    private final Object mutex = new Object();
    protected UGDOContent acknowledgeContent;

    public UGDOPopupHandler(ICarApplication iCarApplication, IUGDOComponent iUGDOComponent, IUGDOLearningHandler iUGDOLearningHandler, IUGDOSynchronizationHandler iUGDOSynchronizationHandler, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.ugdoComponent = iUGDOComponent;
        this.dsiLogChannel = this.ugdoComponent.getDSILogChannel();
        this.application = iCarApplication;
        this.learningHandler = iUGDOLearningHandler;
        this.syncHandler = iUGDOSynchronizationHandler;
        this.powerEventListener = new PowerEventListener();
        iCarApplication.getPowerEventDispatcher().addPowerEventListener(this.powerEventListener);
    }

    public void init() {
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600435).setButtonListener(this);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600520).setButtonListener(this);
    }

    public void deinit() {
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600435).resetListener();
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600520).resetListener();
        this.currentVisiblePopup = -1;
        this.requestedContent = new UGDOContent();
        this.removeReason = 0;
        this.currHardkey = 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[UGDOPopupHandler#keyPressed] modelID='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            switch (n) {
                case 600435: {
                    this.logChannel.log(1000000, "[UGDOPopupHandler#keyPressed] user wants to start the learning process...");
                    this.triggerUgdoMenuJump(true);
                    this.removePopupByUser();
                    this.setLearningSystemModel(2);
                    break;
                }
                case 600520: {
                    this.logChannel.log(1000000, "[UGDOPopupHandler#keyPressed] user wants to start the sync process...");
                    this.triggerUgdoMenuJump(false);
                    this.removePopupByUser();
                    this.setLearningSystemModel(3);
                    break;
                }
            }
        }
    }

    private void setLearningSystemModel(int n) {
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600428).setValue(n);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void updateUGDOContent(UGDOContent uGDOContent) {
    }

    private void setHardkey(int n) {
        this.currHardkey = n;
        this.application.getFrameworkAccess().getHmiServiceApp().getLabelModel(600518).setText(this.convertToRomanNumber(this.currHardkey));
    }

    private String convertToRomanNumber(int n) {
        switch (n) {
            case 1: {
                return "I";
            }
            case 2: {
                return "II";
            }
            case 3: {
                return "III";
            }
        }
        return "I";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestUGDOPopup(UGDOContent uGDOContent) {
        this.logChannel.log(1000000, "[UGDOPopupHandler#requestUGDOContent] content: %1", (Object)uGDOContent);
        if (!this.contentCheckOK(uGDOContent)) {
            return;
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.isStandbyMode()) {
                this.logChannel.log(1000000, "[UGDOPopupHandler#requestUGDOContent] standby popup is visible -> refusing ugdo popup");
                this.refusePopupDisplay();
            } else {
                switch (uGDOContent.getContent()) {
                    case 0: {
                        if (this.currentVisiblePopup == -1) break;
                        this.logChannel.log(1000000, "[UGDOPopupHandler#requestUGDOContent] UGDOCONTENT_IDLE, popup is visible: %1", (long)this.currentVisiblePopup);
                        this.removePopup(this.currentVisiblePopup, (short)2);
                        break;
                    }
                    case 2: 
                    case 3: {
                        this.requestedContent = uGDOContent;
                        this.setHardkey(this.requestedContent.getHardkey());
                        this.showPopupLearning();
                        break;
                    }
                    case 4: {
                        this.requestedContent = uGDOContent;
                        this.setHardkey(this.requestedContent.getHardkey());
                        this.showPopupSynchronize();
                        break;
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
        Object object = this.mutex;
        synchronized (object) {
            switch (uGDOContent.getContent()) {
                case 0: {
                    this.evaluateReason();
                    break;
                }
                case 2: 
                case 3: 
                case 4: {
                    this.acknowledgeContent = uGDOContent;
                    break;
                }
                default: {
                    this.logChannel.log(1000000, "[UGDOPopupHandler#acknowledgeUGDOPopup] content not supported: %1", (long)uGDOContent.getContent());
                }
            }
        }
    }

    private void evaluateReason() {
        if (this.removeReason == 3) {
            int n = this.acknowledgeContent.getContent();
            switch (n) {
                case 2: 
                case 3: {
                    this.learningHandler.startLearningButton(this.currHardkey, 0);
                    break;
                }
                case 4: {
                    this.syncHandler.startSync(this.currHardkey);
                    break;
                }
                default: {
                    this.logChannel.log(1000000, "[UGDOPopupHandler#evaluateReason] content not supported: %1", (long)n);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPopupVisible(int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPopupVisible] id='%1'", (Object)this.getPopupForLogging(n));
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.isPopupExpectedContent(n, this.requestedContent.getContent())) {
                this.currentVisiblePopup = n;
                this.commitPopupDisplay();
                this.removeReason = 1;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPopupHidden(int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPopupHidden] id='%1' standby %2 hmiOnMute %3", (Object)this.getPopupForLogging(n), (Object)(this.powerEventListener.isInStandby() ? "true" : "false"), (Object)(this.powerEventListener.isHMIOnMute() ? "true" : "false"));
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.isPopupExpectedContent(n, this.requestedContent.getContent())) {
                if (!this.isStandbyPopupVisible()) {
                    this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPopupHidden] id='%1' requestedContent='%2' ugdo popup hidden: other popup in display.", (Object)this.getPopupForLogging(n), (long)this.requestedContent.getContent());
                    this.removePopup(n, (short)4);
                } else {
                    this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPopupHidden] **standby: show ugdo popup id='%1' requestedContent='%2' ***standby***", (Object)this.getPopupForLogging(n), (long)this.requestedContent.getContent());
                }
            } else {
                this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPopupHidden] id='%1' requestedContent='%2' ugdo popup replaced by another ugdo popup.", (Object)this.getPopupForLogging(n), (long)this.requestedContent.getContent());
                this.removePopup(n, (short)5);
            }
        }
    }

    public boolean isStandbyMode() {
        return this.powerEventListener.isInStandby() || this.powerEventListener.isHMIOnMute() || this.isStandbyPopupVisible();
    }

    public boolean isStandbyPopupVisible() {
        return this.getCurrentVisibiblePopupId() == this.ugdoComponent.getStandbyHMIPopupID();
    }

    private int getCurrentVisibiblePopupId() {
        return this.application.getFrameworkAccess().getHmiServiceApp().getCurrentPopup();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPopupRemoved(int n) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPopupRemoved] id='%1', currentRemoveReason='%2'", (Object)this.getPopupForLogging(n), (long)this.removeReason);
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.removeReason == 0 || this.removeReason == 1) {
                this.cancelPopupDisplayWithContent();
            }
            this.currentVisiblePopup = -1;
            this.removeReason = 0;
        }
    }

    protected void showPopupLearning() {
        this.logChannel.log(1000000, "[UGDOPopupHandler#showPopupLearning] called");
        this.application.getFrameworkAccess().getHmiServiceApp().showPopup(this.ugdoComponent.getLearningHMIPopupID());
    }

    protected void showPopupSynchronize() {
        this.logChannel.log(1000000, "[UGDOPopupHandler#showPopupSynchronize] called");
        this.application.getFrameworkAccess().getHmiServiceApp().showPopup(this.ugdoComponent.getSyncHMIPopupID());
    }

    protected void removePopup(int n, short s) {
        this.logChannel.log(1000000, "[UGDOPopupHandler#removePopup] called for ID='%1', reason='%2'", (long)n, (long)s);
        this.removeReason = s;
        this.application.getFrameworkAccess().getHmiServiceApp().removePopup(n);
        if (this.removeReason == 4) {
            this.refusePopupDisplay();
        } else if (this.removeReason == 2 || this.removeReason == 1) {
            this.cancelPopupDisplayWithContent();
        }
    }

    protected void removePopupByUser() {
        this.logChannel.log(1000000, "[UGDOPopupHandler#removePopupByUser] called for ID='%1', reason='%2'", (long)this.currentVisiblePopup, 1L);
        this.cancelPopupDisplayWithContent();
        this.removeReason = (short)3;
        this.application.getFrameworkAccess().getHmiServiceApp().removePopup(this.currentVisiblePopup);
    }

    protected void refusePopupDisplay() {
        this.dsiLogChannel.log(1000000, "[UGDOPopupHandler#refusePopupDisplay] ---> DSI.showUGDOPopup(): HMI can not display popup.");
        this.ugdoComponent.getDSICarComfort().showUGDOPopup(new UGDOContent());
    }

    private void cancelPopupDisplay() {
        this.dsiLogChannel.log(1000000, "[UGDOPopupHandler#cancelPopupDisplay] ---> DSI.cancelUGDOPopup() called (with default content)");
        this.ugdoComponent.getDSICarComfort().cancelUGDOPopup(new UGDOContent());
    }

    protected void cancelPopupDisplayWithContent() {
        this.dsiLogChannel.log(1000000, "[UGDOPopupHandler#cancelPopupDisplayWithContent] ---> DSI.cancelUGDOPopup('%1') called", (Object)this.acknowledgeContent);
        this.ugdoComponent.getDSICarComfort().cancelUGDOPopup(this.acknowledgeContent);
    }

    protected void commitPopupDisplay() {
        this.dsiLogChannel.log(1000000, "[UGDOPopupHandler#notifyPopupVisible] ---> DSI.showUGDOPopup(%1) called", (Object)this.requestedContent);
        this.ugdoComponent.getDSICarComfort().showUGDOPopup(this.requestedContent);
    }

    private void triggerUgdoMenuJump(boolean bl) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[UGDOPopupHandler#triggerUgdoMenuJump] trigger jump to '%1'", (Object)(bl ? "Learning" : "Sync"));
        }
        ChoiceModelApp choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(48);
        choiceModelApp.setStatus(bl ? 0 : 1);
        choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
    }

    private boolean contentCheckOK(UGDOContent uGDOContent) {
        if (uGDOContent.getContent() != 0 && (uGDOContent.getHardkey() < 1 || uGDOContent.getHardkey() > 3)) {
            this.logChannel.log(100000, "[UGDOPopupHandler#contentCheckOK] hardkey is '%1'; 1-3 supported only; call will be ignored", (long)uGDOContent.getHardkey());
            return false;
        }
        if (uGDOContent.getContent() != 2 && uGDOContent.getContent() != 3 && uGDOContent.getContent() != 0 && uGDOContent.getContent() != 4) {
            this.logChannel.log(100000, "[UGDOPopupHandler#contentCheckOK] content '%1' not supported; call will be ignored", (long)uGDOContent.getContent());
            return false;
        }
        return true;
    }

    private String getContentForLogging(int n) {
        switch (n) {
            case 0: {
                return "IDLE";
            }
            case 2: {
                return "LEARN NEW DOOR";
            }
            case 3: {
                return "RE-LEARN DOOR";
            }
            case 4: {
                return "SYNCHRONIZE";
            }
        }
        return Integer.toString(n);
    }

    protected String getPopupForLogging(int n) {
        if (n == this.ugdoComponent.getLearningHMIPopupID()) {
            return "LearningPopup";
        }
        if (n == this.ugdoComponent.getSyncHMIPopupID()) {
            return "SyncPopup";
        }
        return "unknown Popup";
    }

    protected boolean isPopupExpectedContent(int n, int n2) {
        if (n == this.ugdoComponent.getLearningHMIPopupID() && n2 == 2 || n == this.ugdoComponent.getLearningHMIPopupID() && n2 == 3 || n == this.ugdoComponent.getSyncHMIPopupID() && n2 == 4) {
            return true;
        }
        this.logChannel.log(1000000, "[UGDOPopupHandler#isPopupExpectedContent] expected popup '%2' (content) and received ID '%1' is not identical", (Object)this.getPopupForLogging(n), (Object)this.getContentForLogging(n2));
        return false;
    }

    private class PowerEventListener
    implements IPowerEventListener {
        private volatile boolean isInStandby;
        private volatile boolean isHMIonMute;

        private PowerEventListener() {
        }

        public void notifyPowerListenerOnEnterState(int n) {
            UGDOPopupHandler.this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPowerListenerOnEnterState] Powerevent: '%1'", (long)n);
            switch (n) {
                case 2: 
                case 3: {
                    this.isInStandby = true;
                    break;
                }
                case 4: {
                    this.isHMIonMute = true;
                    break;
                }
            }
        }

        public void notifyPowerListenerOnExitState(int n) {
            UGDOPopupHandler.this.logChannel.log(1000000, "[UGDOPopupHandler#notifyPowerListenerOnExitState] Powerevent: '%1'", (long)n);
            switch (n) {
                case 2: 
                case 3: {
                    this.isInStandby = false;
                    break;
                }
                case 0: 
                case 1: 
                case 4: {
                    this.isHMIonMute = false;
                    break;
                }
            }
        }

        public void notifyPowerTriggerAction(int n) {
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        }

        public boolean isInStandby() {
            return this.isInStandby;
        }

        public boolean isHMIOnMute() {
            return this.isHMIonMute;
        }
    }
}

