/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class PartialPopupActivatorController
extends AbstractWidgetController
implements IPartialPopupListener {
    private int[] popupIDs;
    private int lastPopupID = -1;
    private int lastRequestedPopupID = -1;
    protected int hkReturnEvent = 0;
    public static final int USE_SETTINGS_OF_POPUP;
    private int consumeHKReturn = -1;
    private int consumeDDSPress = -1;
    private int consumeKeyTurned = -1;
    private boolean updateFromModelOnConnect = true;

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    @Override
    protected void initializeWidget() {
        if (this.updateFromModelOnConnect) {
            this.updateModelValue(null);
        }
    }

    private boolean showPopup(int n) {
        int n2;
        if (!this.isEnabled()) {
            return false;
        }
        this.lastRequestedPopupID = n;
        IPartialPopupManagerEvo iPartialPopupManagerEvo = (IPartialPopupManagerEvo)this.terminal.getPartialPopupManager();
        if (iPartialPopupManagerEvo == null) {
            return false;
        }
        IPartialPopupControllerEvo iPartialPopupControllerEvo = (IPartialPopupControllerEvo)iPartialPopupManagerEvo.getPartialPopup(n);
        if (iPartialPopupControllerEvo != null) {
            if (this.consumeDDSPress != -1) {
                iPartialPopupControllerEvo.setConsumeDDSPress(this.consumeDDSPress);
            }
            if (this.consumeHKReturn != -1) {
                iPartialPopupControllerEvo.setConsumeHKReturn(this.consumeHKReturn);
            }
            if (this.consumeKeyTurned != -1) {
                iPartialPopupControllerEvo.setConsumeKeyTurned(this.consumeKeyTurned);
            }
            if (this.hkReturnEvent != 0) {
                iPartialPopupControllerEvo.setHKReturnEvent(this.hkReturnEvent);
            }
            if (this.event != 0) {
                iPartialPopupControllerEvo.setEvent(this.event);
            }
        }
        if ((n2 = iPartialPopupManagerEvo.showPopup(n, this)) == 2) {
            return false;
        }
        if (this.lastPopupID != n) {
            this.hideLastPopup();
        }
        this.lastPopupID = n;
        return true;
    }

    private void hideLastPopup() {
        if (this.lastPopupID != -1) {
            IPartialPopupManager iPartialPopupManager = this.terminal.getPartialPopupManager();
            if (iPartialPopupManager == null) {
                return;
            }
            iPartialPopupManager.hidePopup(this.lastPopupID);
        }
    }

    private boolean updateModelValue(ModelUpdateEvent modelUpdateEvent) {
        if (this.model == null) {
            return false;
        }
        if (this.popupIDs == null) {
            IWidgetLogChannel.logChannelPopups.log(10000, "PartialPopupActivatorController#processModelUpdateEvent popupID list is empty");
            return false;
        }
        boolean bl = false;
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
        int n = choiceModelGUI.getValue();
        if (n < 0 || n >= this.popupIDs.length) {
            IWidgetLogChannel.logChannelPopups.log(10000, "PartialPopupActivatorController#processModelUpdateEvent popupID list is not long enough for ChoiceModel value %1", (long)n);
            this.hideLastPopup();
        } else if (this.popupIDs[n] == 0 || this.popupIDs[n] == -1) {
            this.hideLastPopup();
        } else {
            bl = this.showPopup(this.popupIDs[n]);
        }
        if (modelUpdateEvent != null) {
            modelUpdateEvent.consume();
        }
        return bl;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getModelType() == 2) {
            switch (modelUpdateEvent.getUpdateType()) {
                case 1: {
                    this.updateModelValue(modelUpdateEvent);
                    break;
                }
                default: {
                    AbstractPartialPopupManager.LOGPOPUPS.log(10000, "PartialPopupActivatorControlelr#processModelUpdateEvent unknown updateType: %1 ", (long)modelUpdateEvent.getUpdateType());
                }
            }
        }
    }

    @Override
    public void partialPopupVisible(int n, int n2) {
    }

    @Override
    public void partialPopupHidden(int n, int n2) {
        if (this.lastRequestedPopupID == n || this.lastRequestedPopupID == -1) {
            this.lastPopupID = -1;
        }
    }

    @Override
    public int[] getPPIDsForCallbacks() {
        return this.popupIDs;
    }

    public void setPopupIDs(int[] nArray) {
        this.popupIDs = nArray;
    }

    public void setConsumeHKReturn(int n) {
        this.consumeHKReturn = n;
    }

    public void setConsumeDDSPress(int n) {
        this.consumeDDSPress = n;
    }

    public void setConsumeKeyTurned(int n) {
        this.consumeKeyTurned = n;
    }

    public void setHKReturnEvent(int n) {
        this.hkReturnEvent = n;
    }

    public void setUpdateFromModelOnConnect(boolean bl) {
        this.updateFromModelOnConnect = bl;
    }

    @Override
    public void partialPopupRemoved(int n, int n2) {
    }

    @Override
    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    @Override
    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

