/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.IUGDOComponent;
import de.audi.app.car.core.comfort.IUGDOLearningHandler;
import de.audi.app.car.core.comfort.IUGDOSynchronizationHandler;
import de.audi.app.car.core.comfort.UGDOButtonData;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;

public class UGDOLearningHandler
implements IUGDOLearningHandler {
    public static final int LEARN_RESULT_IDLE = 0;
    public static final int LEARN_RESULT_ERROR = 1;
    public static final int LEARN_RESULT_OK_FIXCODE_SYSTEM = 2;
    public static final int LEARN_RESULT_OK_ROLLING_SYSTEM = 3;
    public static final int LEARN_RESULT_ABORT_SUCCESSFUL = 4;
    private static final int UGDO_LEARN_POSITION_INSIDE = 3;
    private static final int STATE_FIXKIT = 0;
    private static final int STATE_DEFAULT_MODE = 1;
    private static final int NO_LEARNING_BUTTON = 0;
    private static final int HARDKEY_NOT_FOUND = -1;
    private static final int UGDO_DELETE_ERROR = 0;
    private static final int UGDO_DELETE_SUCCESS = 1;
    private static final int UGDO_BUTTON_1 = 1;
    private static final int UGDO_BUTTON_2 = 2;
    private static final int UGDO_BUTTON_3 = 3;
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
    private final DefaultButtonListener buttonListener = new DefaultButtonListener(){

        public void keyPressed(int n, int n2, int n3) {
            UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#keyPressed] modelID='%1'", (long)n);
            switch (n) {
                case 600417: {
                    UGDOLearningHandler.this.userInteractionRequired = true;
                    UGDOLearningHandler.this.startLearning(1);
                    break;
                }
                case 600418: {
                    UGDOLearningHandler.this.userInteractionRequired = true;
                    UGDOLearningHandler.this.startLearning(2);
                    break;
                }
                case 600420: {
                    UGDOLearningHandler.this.userInteractionRequired = true;
                    UGDOLearningHandler.this.startLearning(3);
                    break;
                }
                case 600415: {
                    UGDOLearningHandler.this.deleteAllButtons();
                    break;
                }
                case 600625: {
                    UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#] error during learning, retry yes");
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(600625).setPressed(true);
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(600624).setPressed(false);
                    UGDOLearningHandler.this.startLearningButton(UGDOLearningHandler.this.learningButton, UGDOLearningHandler.this.getButtonModelID());
                    break;
                }
                case 600624: {
                    UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#] error during learning, no retry, go back");
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(600625).setPressed(false);
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(600624).setPressed(true);
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                    break;
                }
                case 601785: {
                    UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#] leave learning process via HK_RETURN/back");
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                    break;
                }
                case 600423: {
                    UGDOLearningHandler.this.learningStarted = false;
                    UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#keyPressed] abort learning fixed learning system, learningStarted: false");
                    UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#startSync] dsi.abortUGDOLearning()");
                    UGDOLearningHandler.this.ugdoComponent.getDSICarComfort().abortUGDOLearning();
                    UGDOLearningHandler.this.application.getFrameworkAccess().getHMIService().getButtonModel(n).fireEvent(0);
                    break;
                }
                default: {
                    UGDOLearningHandler.this.logChannel.log(100000, "[UGDOLearningHandler#keyPressed] Key Pressed reached unknown state!");
                }
            }
        }
    };
    private final DefaultChoiceListener choiceListener = new DefaultChoiceListener(){

        public void itemSelected(int n, int n2, int n3, int n4) {
            UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#itemSelected] modelID='%1' itemID='%2'", (long)n, (long)n2);
            if (n == 602204) {
                switch (n2) {
                    case 0: {
                        UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#itemSelected] Fixkit selected.");
                        UGDOLearningHandler.this.userInteractionRequired = false;
                        UGDOLearningHandler.this.sendUGDOButtonListRA5(UGDOLearningHandler.this.focusedButton, 5);
                        break;
                    }
                    case 1: {
                        UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#itemSelected] DefaultMode selected.");
                        UGDOLearningHandler.this.userInteractionRequired = false;
                        UGDOLearningHandler.this.sendUGDOButtonListRA5(UGDOLearningHandler.this.focusedButton, 6);
                        break;
                    }
                    default: {
                        UGDOLearningHandler.this.logChannel.log(100000, "[UGDOLearningHandler#itemSelected] modelID='%1' not supported.", (long)n);
                    }
                }
            }
        }
    };
    private final MenuModelListener menuListener = new MenuModelListener(){

        public void itemFocused(int n, int n2, long l, int n3) {
            UGDOLearningHandler.this.logChannel.log(1000000, "[UGDOLearningHandler#itemFocused] modelID='%1' menuItemId: '%2'", (long)n2, (long)n);
            switch (n2) {
                case 602217: {
                    UGDOLearningHandler.this.setFocusedButtonNumber(n);
                    break;
                }
                default: {
                    UGDOLearningHandler.this.logChannel.log(100000, "[UGDOLearningHandler#itemFocused] modelID='%1' not supported (menuItemId: '%2')", (long)n2, (long)n);
                }
            }
        }
    };
    private volatile int currentLearningResult;

    public UGDOLearningHandler(ICarApplication iCarApplication, IUGDOComponent iUGDOComponent, IUGDOSynchronizationHandler iUGDOSynchronizationHandler, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.ugdoComponent = iUGDOComponent;
        this.syncHandler = iUGDOSynchronizationHandler;
        this.timerNoResponseOfDeleteButton = new Timer("TimerNoResponseOfDeleteButton", 3000L, true, new NoResponseTimerListener());
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
            this.startLearningButton(this.learningButton, 600417);
        }
    }

    private void deleteAllButtons() {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[UGDOLearningHandler#deleteAllButtons] dsi.deleteUGDOButton(UGDOSoftkeys)");
        }
        this.ugdoComponent.getDSICarComfort().deleteUGDOButton(new UGDOSoftkeys(true, true, true, false, false, false, false, false, false, false, false, false, false, false, false));
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600414).setStatus(0);
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(600415).fireEvent(0);
        this.timerNoResponseOfDeleteButton.start();
    }

    protected void init() {
        IHMIServiceApp iHMIServiceApp = this.application.getFrameworkAccess().getHmiServiceApp();
        iHMIServiceApp.getButtonModel(600417).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(600418).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(600420).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(600415).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(600625).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(600624).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(601785).setButtonListener(this.buttonListener);
        iHMIServiceApp.getButtonModel(600423).setButtonListener(this.buttonListener);
        iHMIServiceApp.getChoiceModel(602204).setChoiceListener(this.choiceListener);
        iHMIServiceApp.getMenuModel(602217).setListener(this.menuListener);
        this.setUGDOSensorPosition(3);
    }

    protected void deinit() {
        IHMIServiceApp iHMIServiceApp = this.application.getFrameworkAccess().getHmiServiceApp();
        iHMIServiceApp.getButtonModel(600417).resetListener();
        iHMIServiceApp.getButtonModel(600418).resetListener();
        iHMIServiceApp.getButtonModel(600420).resetListener();
        iHMIServiceApp.getButtonModel(600415).resetListener();
        iHMIServiceApp.getButtonModel(600625).resetListener();
        iHMIServiceApp.getButtonModel(600624).resetListener();
        iHMIServiceApp.getButtonModel(601785).resetListener();
        iHMIServiceApp.getButtonModel(600423).resetListener();
        iHMIServiceApp.getChoiceModel(602204).resetListener();
        iHMIServiceApp.getMenuModel(602217).resetListener();
    }

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
                this.logChannel.log(100000, "[UGDOLearningHandler#startLearningButtonFixkitDefaultMode] focused button id '%1' not supported: use NO_LEARNING_BUTTON(0).", (long)this.focusedButton);
                n = 0;
            }
        }
        this.learningButton = n;
        this.logChannel.log(1000000, "[UGDOLearningHandler#startLearningButtonFixkitDefaultMode] button: %1, model: %2", (long)this.focusedButton, (long)this.getButtonModelID());
        this.startLearningButton(n, this.getButtonModelID());
    }

    public void startLearningButton() {
        this.startLearningButton(this.learningButton, this.getButtonModelID());
    }

    public void startLearningButton(int n, int n2) {
        this.logChannel.log(10000000, "[UGDOLearningHandler#startLearningButton] learningStarted: true");
        this.learningStarted = true;
        this.setActiveButtonNumber(n);
        int n3 = this.determineSoftkey(n);
        if (n3 == -1) {
            this.ugdoComponent.getDSILogChannel().log(100000, "[Did not find selected hardkey %1 in button list! Use default values. ");
            this.ugdoComponent.getDSILogChannel().log(1000000, "[startLearningButton] dsi.startUGDOLearning(%1,%2)", (long)n, (long)n);
            this.ugdoComponent.getDSICarComfort().startUGDOLearning(n, n);
        } else {
            this.ugdoComponent.getDSILogChannel().log(1000000, "[startLearningButton] dsi.startUGDOLearning(%1,%2)", (long)n, (long)n3);
            this.ugdoComponent.getDSICarComfort().startUGDOLearning(n, n3);
        }
        this.setUGDOLearnResult(0);
        if (n2 != 0 && this.userInteractionRequired) {
            this.application.getFrameworkAccess().getHMIService().getModel(n2).fireEvent(0);
        }
    }

    public int getCurrentHardkeyButton() {
        return this.learningButton;
    }

    public int getCurrentSoftkeyButton() {
        return this.ackLearningSoftkey;
    }

    public boolean isLearningStarted() {
        return this.learningStarted;
    }

    public void resetLearningStartedState() {
        this.logChannel.log(10000000, "[UGDOLearningHandler#resetLearningStartedState] learningStarted: false");
        this.learningStarted = false;
    }

    public void acknowledgeUGDOLearning(int n, int n2) {
        this.logChannel.log(10000000, "[UGDOLearningHandler#acknowledgeUGDOLearning] Result:%1 Softkey:%2", (Object)this.getLearningResultToText(n), (long)n2);
        this.ackLearningSoftkey = n2;
        this.logChannel.log(10000000, "[UGDOLearningHandler#acknowledgeUGDOLearning] learningStarted: false");
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
                this.logChannel.log(100000, "[UGDOLearningHandler#acknowledgeUGDOLearning] result code unknown/not supported: %1", (long)n);
            }
        }
        this.application.getFrameworkAccess().getHMIService().getModel(602204).fireEvent(0);
    }

    public void acknowledgeUGDODeleteButton(boolean bl) {
        this.logChannel.log(1000000, "[UGDOLearningHandler] dsi.acknowledgeUGDODeleteButton(%1)", bl);
        this.timerNoResponseOfDeleteButton.cancel();
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600414).setValue(bl ? 1 : 0);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600414).setStatus(1);
    }

    private int getButtonModelID() {
        switch (this.learningButton) {
            case 1: {
                return 600417;
            }
            case 2: {
                return 600418;
            }
            case 3: {
                return 600420;
            }
        }
        return 0;
    }

    private int determineSoftkey(int n) {
        ArrayList arrayList = this.ugdoComponent.getInternalButtonList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            UGDOButtonData uGDOButtonData = (UGDOButtonData)iterator.next();
            this.logChannel.log(10000000, "UGDOLearningHandler#determineSoftkey:%1", (Object)uGDOButtonData.toString());
            if (uGDOButtonData.getHardkey() != n) continue;
            return uGDOButtonData.getSoftkey();
        }
        return -1;
    }

    private void setActiveButtonNumber(int n) {
        this.learningButton = n;
        String string = this.convertToRomanNumber(this.learningButton);
        this.logChannel.log(10000000, "UGDOLearningHandler, converting '%1' to '%2'", (Object)Integer.toString(n), (Object)string);
        this.application.getFrameworkAccess().getHmiServiceApp().getLabelModel(600518).setText(string);
    }

    private void setFocusedButtonNumber(int n) {
        this.focusedButton = n++;
        this.logChannel.log(10000000, "UGDOLearningHandler, setFocusedButtonNumber '%2' -> represents Button '%1'", (Object)this.convertToRomanNumber(n), (long)this.focusedButton);
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
        this.logChannel.log(100000, "UGDOLearningHandler, convertToRomanNumber button id '%1' not supported: return empty string.", (long)n);
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
        this.ugdoComponent.getDSILogChannel().log(1000000, "<-- dsi.setUGDOButtonListRA5(%1, %2)", (Object)uGDOButtonListUpdateInfo, (Object)uGDOButtonListRA5Array[0]);
        this.ugdoComponent.getDSICarComfort().setUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
    }

    private void setUGDOSensorPosition(int n) {
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600436).setValue(n);
    }

    private void setUGDOLearnResult(int n) {
        this.currentLearningResult = n;
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600428).setValue(n);
    }

    public void abortUgdoLearning() {
        if (this.isLearningStarted()) {
            this.logChannel.log(1000000, "[UGDOLearningHandler#abortUGDOLearning LEARN_RESULT_IDLE] dsi.abortUGDOLearning()");
            this.ugdoComponent.getDSICarComfort().abortUGDOLearning();
            this.resetLearningStartedState();
        } else {
            this.logChannel.log(1000000, "[UGDOLearningHandler#abortUGDOLearning learning not started");
        }
    }

    public int getLearningState() {
        return this.currentLearningResult;
    }

    class NoResponseTimerListener
    extends DefaultTimerListener {
        NoResponseTimerListener() {
        }

        public void fireTimer(Timer timer) {
            UGDOLearningHandler.this.logChannel.log(100000, "UGDOLearningHandler#DeleteButtonResponseMissingTimerListener#fireTimer: no response after 3000sec, switch to error screen");
            UGDOLearningHandler.this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600414).setValue(0);
            UGDOLearningHandler.this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600414).setStatus(1);
        }

        public void cancelTimer(Timer timer) {
            UGDOLearningHandler.this.logChannel.log(1000000, "UGDOLearningHandler#DeleteButtonResponseMissingTimerListener#cancelTimer: got response, cancel timer");
        }
    }
}

