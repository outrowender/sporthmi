/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.IUGDOComponent;
import de.audi.app.car.core.comfort.IUGDOLearningHandler;
import de.audi.app.car.core.comfort.IUGDOSynchronizationHandler;
import de.audi.app.car.core.comfort.UGDOButtonData;
import de.audi.app.car.core.comfort.UGDOLearningHandler$1;
import de.audi.app.car.core.comfort.UGDOLearningHandler$2;
import de.audi.app.car.core.comfort.UGDOLearningHandler$3;
import de.audi.app.car.core.comfort.UGDOLearningHandler$NoResponseTimerListener;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;

public class UGDOLearningHandler
implements IUGDOLearningHandler {
    public static final int LEARN_RESULT_IDLE;
    public static final int LEARN_RESULT_ERROR;
    public static final int LEARN_RESULT_OK_FIXCODE_SYSTEM;
    public static final int LEARN_RESULT_OK_ROLLING_SYSTEM;
    public static final int LEARN_RESULT_ABORT_SUCCESSFUL;
    private static final int UGDO_LEARN_POSITION_INSIDE;
    private static final int STATE_FIXKIT;
    private static final int STATE_DEFAULT_MODE;
    private static final int NO_LEARNING_BUTTON;
    private static final int HARDKEY_NOT_FOUND;
    private static final int UGDO_DELETE_ERROR;
    private static final int UGDO_DELETE_SUCCESS;
    private static final int UGDO_BUTTON_1;
    private static final int UGDO_BUTTON_2;
    private static final int UGDO_BUTTON_3;
    private final LogChannel logChannel;
    private final IUGDOComponent ugdoComponent;
    private final ICarApplication application;
    private final IUGDOSynchronizationHandler syncHandler;
    private volatile int learningButton = 0;
    private volatile int focusedButton;
    private volatile boolean learningStarted = false;
    private volatile int ackLearningSoftkey;
    private volatile boolean fixkitMode = false;
    private volatile boolean userInteractionRequired = true;
    private Timer timerNoResponseOfDeleteButton;
    private final DefaultButtonListener buttonListener = new UGDOLearningHandler$1(this);
    private final DefaultChoiceListener choiceListener = new UGDOLearningHandler$2(this);
    private final MenuModelListener menuListener = new UGDOLearningHandler$3(this);
    private volatile int currentLearningResult;

    public UGDOLearningHandler(ICarApplication iCarApplication, IUGDOComponent iUGDOComponent, IUGDOSynchronizationHandler iUGDOSynchronizationHandler, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.ugdoComponent = iUGDOComponent;
        this.syncHandler = iUGDOSynchronizationHandler;
        this.timerNoResponseOfDeleteButton = new Timer("TimerNoResponseOfDeleteButton", 0, true, new UGDOLearningHandler$NoResponseTimerListener(this));
    }

    public boolean isFixkitMode() {
        return this.fixkitMode;
    }

    public void setFixkitMode(boolean bl) {
        this.fixkitMode = bl;
    }

    private void startLearning(int n) {
        this.setActiveButtonNumber(n);
        if (this.isFixkitMode()) {
            this.setFocusedButtonNumber(n);
            this.sendUGDOButtonListRA5(this.learningButton, 5);
        } else {
            this.startLearningButton(this.learningButton, 1630079232);
        }
    }

    private void deleteAllButtons() {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[UGDOLearningHandler#deleteAllButtons] dsi.deleteUGDOButton(UGDOSoftkeys)");
        }
        this.ugdoComponent.getDSICarComfort().deleteUGDOButton(new UGDOSoftkeys(true, true, true, false, false, false, false, false, false, false, false, false, false, false, false));
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1579747584).setStatus(0);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(1596524800).fireEvent(0);
        this.timerNoResponseOfDeleteButton.start();
    }

    protected void init() {
        IHMIServiceApp iHMIServiceApp = this.application.getFrameworkAccess().getHmiServiceApp();
        iHMIServiceApp.getButtonModel(1630079232).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(1646856448).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(1680410880).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(1596524800).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(824838400).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(808061184).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(-1188165376).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(1730742528).setButtonListener(this.buttonListener);
        iHMIServiceApp.getChoiceModel(1546651904).setChoiceListener(this.choiceListener);
        iHMIServiceApp.getMenuModel(1764755712).setListener(this.menuListener);
        this.setUGDOSensorPosition(3);
    }

    protected void deinit() {
        IHMIServiceApp iHMIServiceApp = this.application.getFrameworkAccess().getHmiServiceApp();
        iHMIServiceApp.getButtonModel(1630079232).resetListener();
        iHMIServiceApp.getButtonModel(1646856448).resetListener();
        iHMIServiceApp.getButtonModel(1680410880).resetListener();
        iHMIServiceApp.getButtonModel(1596524800).resetListener();
        iHMIServiceApp.getButtonModel(824838400).resetListener();
        iHMIServiceApp.getButtonModel(808061184).resetListener();
        iHMIServiceApp.getButtonModel(-1188165376).resetListener();
        iHMIServiceApp.getButtonModel(1730742528).resetListener();
        iHMIServiceApp.getChoiceModel(1546651904).resetListener();
        iHMIServiceApp.getMenuModel(1764755712).resetListener();
    }

    @Override
    public void startLearningButtonFixkitDefaultMode() {
        int n;
        switch (this.focusedButton) {
            case 0: {
                n = 1;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "[UGDOLearningHandler#startLearningButtonFixkitDefaultMode] focused button id '%1' not supported: use NO_LEARNING_BUTTON(0).", (long)this.focusedButton);
                n = 0;
            }
        }
        this.learningButton = n;
        this.logChannel.log(1078071040, "[UGDOLearningHandler#startLearningButtonFixkitDefaultMode] button: %1, model: %2", (long)this.focusedButton, (long)this.getButtonModelID());
        this.startLearningButton(n, this.getButtonModelID());
    }

    @Override
    public void startLearningButton() {
        this.startLearningButton(this.learningButton, this.getButtonModelID());
    }

    @Override
    public void startLearningButton(int n, int n2) {
        this.logChannel.log(-2137614336, "[UGDOLearningHandler#startLearningButton] learningStarted: true");
        this.learningStarted = true;
        this.setActiveButtonNumber(n);
        int n3 = this.determineSoftkey(n);
        if (n3 == -1) {
            this.ugdoComponent.getDSILogChannel().log(-1601830656, "[Did not find selected hardkey %1 in button list! Use default values. ");
            this.ugdoComponent.getDSILogChannel().log(1078071040, "[startLearningButton] dsi.startUGDOLearning(%1,%2)", (long)n, (long)n);
            this.ugdoComponent.getDSICarComfort().startUGDOLearning(n, n);
        } else {
            this.ugdoComponent.getDSILogChannel().log(1078071040, "[startLearningButton] dsi.startUGDOLearning(%1,%2)", (long)n, (long)n3);
            this.ugdoComponent.getDSICarComfort().startUGDOLearning(n, n3);
        }
        this.setUGDOLearnResult(0);
        if (n2 != 0 && this.userInteractionRequired) {
            this.application.getFrameworkAccess().getHMIService().getModel(n2).fireEvent(0);
        }
    }

    @Override
    public int getCurrentHardkeyButton() {
        return this.learningButton;
    }

    @Override
    public int getCurrentSoftkeyButton() {
        return this.ackLearningSoftkey;
    }

    @Override
    public boolean isLearningStarted() {
        return this.learningStarted;
    }

    @Override
    public void resetLearningStartedState() {
        this.logChannel.log(-2137614336, "[UGDOLearningHandler#resetLearningStartedState] learningStarted: false");
        this.learningStarted = false;
    }

    public void acknowledgeUGDOLearning(int n, int n2) {
        this.logChannel.log(-2137614336, "[UGDOLearningHandler#acknowledgeUGDOLearning] Result:%1 Softkey:%2", (Object)this.getLearningResultToText(n), (long)n2);
        this.ackLearningSoftkey = n2;
        this.logChannel.log(-2137614336, "[UGDOLearningHandler#acknowledgeUGDOLearning] learningStarted: false");
        switch (n) {
            case 3: {
                this.learningStarted = false;
                this.setUGDOLearnResult(4);
                break;
            }
            case 244: {
                this.learningStarted = false;
                this.setUGDOLearnResult(1);
                break;
            }
            case 1: {
                this.learningStarted = false;
                this.setUGDOLearnResult(2);
                break;
            }
            case 2: {
                this.learningStarted = false;
                this.setUGDOLearnResult(3);
                break;
            }
            default: {
                this.learningStarted = false;
                this.setUGDOLearnResult(1);
                this.logChannel.log(-1601830656, "[UGDOLearningHandler#acknowledgeUGDOLearning] result code unknown/not supported: %1", (long)n);
            }
        }
        this.application.getFrameworkAccess().getHMIService().getModel(1546651904).fireEvent(0);
    }

    public void acknowledgeUGDODeleteButton(boolean bl) {
        this.logChannel.log(1078071040, "[UGDOLearningHandler] dsi.acknowledgeUGDODeleteButton(%1)", bl);
        this.timerNoResponseOfDeleteButton.cancel();
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1579747584).setValue(bl ? 1 : 0);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1579747584).setStatus(1);
    }

    private int getButtonModelID() {
        switch (this.learningButton) {
            case 1: {
                return 1630079232;
            }
            case 2: {
                return 1646856448;
            }
            case 3: {
                return 1680410880;
            }
        }
        return 0;
    }

    private int determineSoftkey(int n) {
        ArrayList arrayList = this.ugdoComponent.getInternalButtonList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            this.logChannel.log(-2137614336, "UGDOLearningHandler#determineSoftkey:%1", (Object)uGDOButtonData.toString());
            if (uGDOButtonData.getHardkey() != n) continue;
            return uGDOButtonData.getSoftkey();
        }
        return -1;
    }

    private void setActiveButtonNumber(int n) {
        this.learningButton = n;
        String string = this.convertToRomanNumber(this.learningButton);
        this.logChannel.log(-2137614336, "UGDOLearningHandler, converting '%1' to '%2'", (Object)Integer.toString(n), (Object)string);
        this.application.getFrameworkAccess().getHmiServiceApp().getLabelModel(-970389248).setText(string);
    }

    private void setFocusedButtonNumber(int n) {
        this.focusedButton = n++;
        this.logChannel.log(-2137614336, "UGDOLearningHandler, setFocusedButtonNumber '%2' -> represents Button '%1'", (Object)this.convertToRomanNumber(n), (long)this.focusedButton);
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
        this.logChannel.log(-1601830656, "UGDOLearningHandler, convertToRomanNumber button id '%1' not supported: return empty string.", (long)n);
        return "";
    }

    protected int getInternalLearningResult(int n) {
        switch (n) {
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 244: {
                return 1;
            }
        }
        return 1;
    }

    private String getLearningResultToText(int n) {
        switch (n) {
            case 1: {
                return "1:UGDOLEARNINGRESULT_FIXEDCODESYSTEM_SUCCESSFUL";
            }
            case 2: {
                return "2:UGDOLEARNINGRESULT_ROLLINGCODESYSTEM_SUCCESSFUL";
            }
            case 3: {
                return "3:UGDOLEARNINGRESULT_ABORT_SUCCESSFUL";
            }
            case 244: {
                return "244:UGDOLEARNINGRESULT_ABORT_NOTSUCCESSFUL";
            }
        }
        return "UGDOLEARNINGRESULT not supported/missing.";
    }

    private void sendUGDOButtonListRA5(int n, int n2) {
        UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = new UGDOButtonListUpdateInfo(4, 5, n, 1, 1, 1);
        UGDOButtonListRA5 uGDOButtonListRA5 = new UGDOButtonListRA5(n, n2);
        UGDOButtonListRA5[] uGDOButtonListRA5Array = new UGDOButtonListRA5[]{uGDOButtonListRA5};
        this.ugdoComponent.getDSILogChannel().log(1078071040, "<-- dsi.setUGDOButtonListRA5(%1, %2)", (Object)uGDOButtonListUpdateInfo, (Object)uGDOButtonListRA5Array[0]);
        this.ugdoComponent.getDSICarComfort().setUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
    }

    private void setUGDOSensorPosition(int n) {
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1948846336).setValue(n);
    }

    private void setUGDOLearnResult(int n) {
        this.currentLearningResult = n;
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(1814628608).setValue(n);
    }

    @Override
    public void abortUgdoLearning() {
        if (this.isLearningStarted()) {
            this.logChannel.log(1078071040, "[UGDOLearningHandler#abortUGDOLearning LEARN_RESULT_IDLE] dsi.abortUGDOLearning()");
            this.ugdoComponent.getDSICarComfort().abortUGDOLearning();
            this.resetLearningStartedState();
        } else {
            this.logChannel.log(1078071040, "[UGDOLearningHandler#abortUGDOLearning learning not started");
        }
    }

    @Override
    public int getLearningState() {
        return this.currentLearningResult;
    }

    static /* synthetic */ LogChannel access$000(UGDOLearningHandler uGDOLearningHandler) {
        return uGDOLearningHandler.logChannel;
    }

    static /* synthetic */ boolean access$102(UGDOLearningHandler uGDOLearningHandler, boolean bl) {
        uGDOLearningHandler.userInteractionRequired = bl;
        return uGDOLearningHandler.userInteractionRequired;
    }

    static /* synthetic */ void access$200(UGDOLearningHandler uGDOLearningHandler, int n) {
        uGDOLearningHandler.startLearning(n);
    }

    static /* synthetic */ void access$300(UGDOLearningHandler uGDOLearningHandler) {
        uGDOLearningHandler.deleteAllButtons();
    }

    static /* synthetic */ ICarApplication access$400(UGDOLearningHandler uGDOLearningHandler) {
        return uGDOLearningHandler.application;
    }

    static /* synthetic */ int access$500(UGDOLearningHandler uGDOLearningHandler) {
        return uGDOLearningHandler.learningButton;
    }

    static /* synthetic */ int access$600(UGDOLearningHandler uGDOLearningHandler) {
        return uGDOLearningHandler.getButtonModelID();
    }

    static /* synthetic */ boolean access$702(UGDOLearningHandler uGDOLearningHandler, boolean bl) {
        uGDOLearningHandler.learningStarted = bl;
        return uGDOLearningHandler.learningStarted;
    }

    static /* synthetic */ IUGDOComponent access$800(UGDOLearningHandler uGDOLearningHandler) {
        return uGDOLearningHandler.ugdoComponent;
    }

    static /* synthetic */ int access$900(UGDOLearningHandler uGDOLearningHandler) {
        return uGDOLearningHandler.focusedButton;
    }

    static /* synthetic */ void access$1000(UGDOLearningHandler uGDOLearningHandler, int n, int n2) {
        uGDOLearningHandler.sendUGDOButtonListRA5(n, n2);
    }

    static /* synthetic */ void access$1100(UGDOLearningHandler uGDOLearningHandler, int n) {
        uGDOLearningHandler.setFocusedButtonNumber(n);
    }
}

