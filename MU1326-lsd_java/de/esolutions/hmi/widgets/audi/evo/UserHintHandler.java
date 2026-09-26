/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;

public class UserHintHandler
implements IUserHintHandler {
    private static final int NONE;
    private static final int ARRAY_POS_TEL_HINT;
    private static final int ARRAY_POS_NAVI_HINT;
    private static final int ARRAY_POS_MAP_UNLOCKED_HINT;
    private static final int ARRAY_POS_MAP_LOCKED_HINT;
    private static final int[] DEFAULT_SPECIAL_HINT_CONFIG;
    private static final int USER_HINTS_CONFIG_MODEL;
    private static final int SLOT_FOR_HINTS;
    private HMITerminalImpl terminal;
    private IntList alreadyShownHints;
    private ChoiceModelGUI hintsActivatedModel;
    private int kbdType = 0;
    private int[] initialUserHintConfig;

    public UserHintHandler(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
        this.alreadyShownHints = new IntList(20);
        this.updateKeyboardType();
        this.readInitialHintConfigFromPersistence();
    }

    private void updateKeyboardType() {
        if (this.terminal == null) {
            IWidgetLogChannel.logUserHints.log(10000, "UserHintHandler#updateKeyboardType: Terminal is null. Could not update keyboardType.");
            return;
        }
        if (this.terminal.getKbdService() == null) {
            IWidgetLogChannel.logUserHints.log(10000, "UserHintHandler#updateKeyboardType: terminal.getKbdService() returned null. Could not update keyboardType.");
            return;
        }
        this.kbdType = this.terminal.getKbdService().getCurrentKeyboardType();
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getModelId() == -2033643520 && this.hintsActivatedModel != null) {
            int n = this.hintsActivatedModel.getValue();
            if (n == 0) {
                IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#processModelUpdateEvent: User turned hints off. Resetting History of what has been shown already!");
                this.alreadyShownHints.clear();
                TouchController.resetTruffleInputCount();
            } else if (n == 1) {
                this.alreadyShownHints.clear();
                TouchController.resetTruffleInputCount();
                this.readInitialHintConfigFromPersistence();
            }
        }
    }

    @Override
    public void requestInitialHint(int n) {
        this.requestHintAnimation(n, -1, -1, null);
    }

    @Override
    public void requestInitialHint(int n, IPartialPopupListener iPartialPopupListener) {
        this.requestHintAnimation(n, -1, -1, iPartialPopupListener);
    }

    @Override
    public void requestHintAnimation(int n, int n2, int n3) {
        this.requestHintAnimation(n, n2, n3, null);
    }

    private void requestHintAnimation(int n, int n2, int n3, IPartialPopupListener iPartialPopupListener) {
        if (!this.shallShowUserHints()) {
            IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#requestHintAnimation: Hints are turned globally off! The hint animation (id=%1) will not be displayed!", (long)n);
            return;
        }
        if (!this.shallShowSpecificInitialHintAnimation(n)) {
            IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#requestHintAnimation: The user configured to not show this specific hint animation (id=%1)!", (long)n);
            return;
        }
        if (this.terminal.getViewSizeManager().getCurrentViewSize() != 2) {
            IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#requestHintAnimation: user hints will not be shown on small stage (hintID=%1)!", (long)n);
            return;
        }
        if (this.terminal.getDrawerFocusManager().getDrawerState() != 16) {
            IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#requestHintAnimation: user hints will not be shown, if a drawer is open (hintID=%1)!", (long)n);
            return;
        }
        if (this.alreadyShownHints.indexOf(n) != -1) {
            IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#requestHintAnimation: the hint animation (id=%1) has already been shown before!", (long)n);
            return;
        }
        if (this.hintForKeypanelAvailable(n)) {
            PartialPopupController partialPopupController;
            IPartialPopupManagerEvo iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo();
            IPartialPopupController iPartialPopupController = iPartialPopupManagerEvo.getCurrentVisiblePopup(10);
            if (iPartialPopupController != null) {
                int n4 = iPartialPopupController.getID();
                IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#requestHintAnimation: another hint (hintID=%1) is already active and will be closed!", (long)n4);
                iPartialPopupManagerEvo.hidePopup(n4);
            }
            if ((partialPopupController = (PartialPopupController)iPartialPopupManagerEvo.getPartialPopup(n)) != null) {
                if (n2 != -1 && n3 != -1) {
                    this.doPopupPositioning(partialPopupController, n2, n3);
                }
                partialPopupController.setGreyOutBackground(false);
                if (iPartialPopupListener != null) {
                    iPartialPopupManagerEvo.showPopup(n, iPartialPopupListener);
                } else {
                    iPartialPopupManagerEvo.showPopup(n);
                }
                this.alreadyShownHints.add(n);
            } else {
                IWidgetLogChannel.logUserHints.log(10000, "UserHintHandler#requestHintAnimation: The hint animation (id=%1) is not available!", (long)n);
            }
        }
    }

    private boolean hintForKeypanelAvailable(int n) {
        if (this.kbdType == 0) {
            this.updateKeyboardType();
            if (this.kbdType == 0) {
                IWidgetLogChannel.logUserHints.log(10000, "UserHintHandler#hintForKeypanelAvailable: Unknown keypanel. Not showing userhints.");
                return false;
            }
        }
        boolean bl = true;
        switch (this.kbdType) {
            case 5: 
            case 6: 
            case 15: {
                IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#hintForKeypanelAvailable: kbdType: %1 - hintID: %2 is shown for this keypanel type", (long)this.kbdType, (long)n);
                break;
            }
            case 1: 
            case 3: 
            case 4: {
                if (n == 80 || n == 81 || n == 96 || n == 97) {
                    IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#hintForKeypanelAvailable: kbdType: %1 - hintID: %2 is shown for this keypanel type", (long)this.kbdType, (long)n);
                    break;
                }
                IWidgetLogChannel.logUserHints.log(1078071040, "UserHintHandler#hintForKeypanelAvailable: kbdType: %1 - hintID: %2 is NOT shown for this keypanel type ", (long)this.kbdType, (long)n);
                bl = false;
                break;
            }
            case 2: {
                if (n == 80 || n == 96) {
                    IWidgetLogChannel.logUserHints.log(-2137614336, "UserHintHandler#hintForKeypanelAvailable: kbdType: %1 - hintID: %2 is shown for this keypanel type", (long)this.kbdType, (long)n);
                    break;
                }
                IWidgetLogChannel.logUserHints.log(1078071040, "UserHintHandler#hintForKeypanelAvailable: kbdType: %1 - hintID: %2 is NOT shown for this keypanel type ", (long)this.kbdType, (long)n);
                bl = false;
                break;
            }
            default: {
                IWidgetLogChannel.logUserHints.log(-1601830656, "UserHintHandler#hintForKeypanelAvailable: kbdType: %1 is unknown - use same hint configuration like ALL_IN_TOUCH keypanel as default, current requested hintID: %2", (long)this.kbdType, (long)n);
            }
        }
        return bl;
    }

    private void tryToGetHintsModel() {
        HMIModel hMIModel;
        if (this.hintsActivatedModel == null && (hMIModel = this.terminal.getFramework().getHMIService().getModel(-2033643520)) instanceof ChoiceModelGUI) {
            this.hintsActivatedModel = (ChoiceModelGUI)((Object)hMIModel);
            this.hintsActivatedModel.addReference();
        }
    }

    @Override
    public boolean shallShowUserHints() {
        this.tryToGetHintsModel();
        if (this.hintsActivatedModel != null && this.terminal.getFramework().getStartupMgr().isStartupCompleted()) {
            return this.hintsActivatedModel.getValue() != 0;
        }
        int n = this.terminal.getFramework().getStorageMgr().getInt(1011, 40, 1);
        return n != 0;
    }

    @Override
    public void removeCurrentUserHint() {
        PartialPopupController partialPopupController = (PartialPopupController)this.terminal.getPartialPopupManagerEvo().getCurrentVisiblePopup(10);
        if (partialPopupController != null) {
            int n = partialPopupController.getID();
            this.terminal.getPartialPopupManagerEvo().hidePopup(n);
        }
    }

    private static boolean isInitialHint(int n) {
        return n == 96 || n == 97 || n == 105 || n == 103;
    }

    private boolean shallShowSpecificInitialHintAnimation(int n) {
        if (this.initialUserHintConfig != null && this.initialUserHintConfig.length > 3) {
            switch (n) {
                case 96: {
                    return this.initialUserHintConfig[0] == 1;
                }
                case 97: {
                    return this.initialUserHintConfig[1] == 1;
                }
                case 103: {
                    return this.initialUserHintConfig[2] == 1;
                }
                case 105: {
                    return this.initialUserHintConfig[3] == 1;
                }
            }
            return true;
        }
        return true;
    }

    private void readInitialHintConfigFromPersistence() {
        IStorageAccess iStorageAccess = this.terminal != null && this.terminal.getFramework() != null ? this.terminal.getFramework().getStorageMgr() : null;
        this.initialUserHintConfig = iStorageAccess != null ? this.terminal.getFramework().getStorageMgr().getIntArray(1011, 41, DEFAULT_SPECIAL_HINT_CONFIG) : null;
    }

    @Override
    public void updateUserHintPos(int n, int n2) {
        PartialPopupController partialPopupController = (PartialPopupController)this.terminal.getPartialPopupManagerEvo().getCurrentVisiblePopup(10);
        if (partialPopupController != null && !UserHintHandler.isInitialHint(partialPopupController.getID())) {
            this.doPopupPositioning(partialPopupController, n, n2 + 5);
        }
    }

    private void doPopupPositioning(PartialPopupController partialPopupController, int n, int n2) {
        partialPopupController.setX(n - partialPopupController.getWidth());
        partialPopupController.setY(n2);
    }

    static {
        DEFAULT_SPECIAL_HINT_CONFIG = new int[]{1, 1, 1, 1};
    }
}

