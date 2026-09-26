/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.BrowserHMIListener;

public class BrowserModelHandler {
    public static int NULL_VALUE = 128;
    BrowserHMIListener listener;
    private ChoiceModelApp choiceNext;
    private ChoiceModelApp choicePrev;
    private ChoiceModelApp keyId;
    private RangeModelApp zoomer;
    private LabelModelApp zoomLabel;
    private ChoiceModelApp browserAvailableChoice;
    private ButtonModelApp buttonBookmark;
    private ChoiceModelApp browserState;
    private ChoiceModelApp browserSync;
    private ChoiceModelApp vehicleSpeedChoice;
    private ChoiceModelApp browserSpeedChoice;
    private LabelModelApp labelTitle;
    private ChoiceModelApp skAvailableChoice;
    private VirtualButtonModelApp virtualButton;
    private ChoiceModelApp choiceSidebar;
    private ButtonModelApp buttonCancel;
    private ButtonModelApp buttonReload;
    private ChoiceModelApp displayContextSwitchChoice;
    private ChoiceModelApp boardbookAvailable;
    private ButtonModelApp buttonHome;
    private ButtonModelApp buttonIndex;
    private ButtonModelApp backButton;
    private final LogChannel logger;

    public BrowserModelHandler(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void setHMIListener(BrowserHMIListener browserHMIListener) {
        this.listener = browserHMIListener;
    }

    public ChoiceModelApp getDisplayContextSwitchChoice() {
        return this.displayContextSwitchChoice;
    }

    public int getDisplayContextSwitchChoiceValue() {
        if (this.displayContextSwitchChoice != null) {
            return this.displayContextSwitchChoice.getValue();
        }
        return NULL_VALUE;
    }

    public void setDisplayContextSwitchChoiceValue(int n) {
        if (this.displayContextSwitchChoice != null) {
            this.logger.log(-2137614336, "BrowserModelHandler#setDisplayContextSwitchChoiceValue: id=%1 set to value=%2", (long)this.displayContextSwitchChoice.getID(), (long)n);
            this.displayContextSwitchChoice.setValue(n);
        } else {
            this.logger.log(-2137614336, "BrowserModelHandler#setDisplayContextSwitchChoiceValue: choice was null");
        }
    }

    public void setDisplayContextSwitchChoice(ChoiceModelApp choiceModelApp) {
        this.displayContextSwitchChoice = choiceModelApp;
    }

    public void setButtonCancel(ButtonModelApp buttonModelApp) {
        this.buttonCancel = buttonModelApp;
        if (this.buttonCancel != null) {
            this.buttonCancel.setButtonListener(this.listener);
        }
    }

    public int getButtonCancelID() {
        if (this.buttonCancel != null) {
            return this.buttonCancel.getID();
        }
        return NULL_VALUE;
    }

    public ButtonModelApp getButtonCancel() {
        return this.buttonCancel;
    }

    public ButtonModelApp getButtonIndex() {
        return this.buttonIndex;
    }

    public int getButtonIndexID() {
        if (this.buttonIndex != null) {
            return this.buttonIndex.getID();
        }
        return NULL_VALUE;
    }

    public void setButtonIndex(ButtonModelApp buttonModelApp) {
        this.buttonIndex = buttonModelApp;
        if (this.buttonIndex != null) {
            this.buttonIndex.setButtonListener(this.listener);
        }
    }

    public ButtonModelApp getButtonHome() {
        return this.buttonHome;
    }

    public int getButtonHomeID() {
        if (this.buttonHome != null) {
            return this.buttonHome.getID();
        }
        return NULL_VALUE;
    }

    public void setButtonHome(ButtonModelApp buttonModelApp) {
        this.buttonHome = buttonModelApp;
        if (this.buttonHome != null) {
            this.buttonHome.setButtonListener(this.listener);
        }
    }

    public ButtonModelApp getButtonReload() {
        return this.buttonReload;
    }

    public int getButtonReloadID() {
        if (this.buttonReload != null) {
            return this.buttonReload.getID();
        }
        return NULL_VALUE;
    }

    public void setButtonReload(ButtonModelApp buttonModelApp) {
        this.buttonReload = buttonModelApp;
        if (this.buttonReload != null) {
            this.buttonReload.setButtonListener(this.listener);
        }
    }

    public int getChoiceNextValue() {
        if (this.choiceNext != null) {
            return this.choiceNext.getValue();
        }
        return NULL_VALUE;
    }

    public void setChoiceNext(ChoiceModelApp choiceModelApp) {
        this.choiceNext = choiceModelApp;
        if (this.choiceNext != null) {
            this.choiceNext.setChoiceListener(this.listener);
        }
    }

    public void setChoiceNextValue(int n) {
        if (this.choiceNext != null) {
            this.choiceNext.setValue(n);
        }
    }

    public void setChoicePrev(ChoiceModelApp choiceModelApp) {
        this.choicePrev = choiceModelApp;
        if (this.choicePrev != null) {
            this.choicePrev.setChoiceListener(this.listener);
        }
    }

    public void setChoicePrevValue(int n) {
        if (this.choicePrev != null) {
            this.choicePrev.setValue(n);
        }
    }

    public int getChoicePrevValue() {
        if (this.choicePrev != null) {
            return this.choicePrev.getValue();
        }
        return NULL_VALUE;
    }

    public RangeModelApp getZoomer() {
        return this.zoomer;
    }

    public int getZoomerValue() {
        if (this.zoomer != null) {
            return this.zoomer.getValue();
        }
        return NULL_VALUE;
    }

    public int getZoomerID() {
        if (this.zoomer != null) {
            return this.zoomer.getID();
        }
        return NULL_VALUE;
    }

    public int getZoomerMax() {
        if (this.zoomer != null) {
            return this.zoomer.getMaximum();
        }
        return NULL_VALUE;
    }

    public int getZoomerMin() {
        if (this.zoomer != null) {
            return this.zoomer.getMinimum();
        }
        return NULL_VALUE;
    }

    public void setZoomer(RangeModelApp rangeModelApp) {
        this.zoomer = rangeModelApp;
        if (this.zoomer != null) {
            this.zoomer.setRangeListener(this.listener);
        }
    }

    public void setZoomerValues(int n, int n2, int n3, int n4) {
        if (this.zoomer != null) {
            this.zoomer.setLimits(n2, n3, n4);
            this.zoomer.setValue(n);
        }
    }

    public void setZoomerValue(int n) {
        if (this.zoomer != null) {
            this.zoomer.setValue(n);
        }
    }

    public void setZoomerRange(int n, int n2, int n3) {
        if (this.zoomer != null) {
            this.zoomer.setLimits(n, n2, n3);
        }
    }

    public void setZoomLabelText(String string) {
        if (this.zoomLabel != null) {
            this.zoomLabel.setText(string);
        }
    }

    public String getZoomLabelText() {
        if (this.zoomLabel != null) {
            return this.zoomLabel.getText();
        }
        return "";
    }

    public void setZoomLabel(LabelModelApp labelModelApp) {
        this.zoomLabel = labelModelApp;
    }

    public void setBrowserAvailableChoice(ChoiceModelApp choiceModelApp) {
        this.browserAvailableChoice = choiceModelApp;
    }

    public void setBrowserAvailableChoiceValue(int n) {
        if (this.browserAvailableChoice != null) {
            this.browserAvailableChoice.setValue(n);
        }
    }

    public int getButtonBookmarkID() {
        if (this.buttonBookmark != null) {
            return this.buttonBookmark.getID();
        }
        return NULL_VALUE;
    }

    public void setButtonBookmark(ButtonModelApp buttonModelApp) {
        this.buttonBookmark = buttonModelApp;
        if (this.buttonBookmark != null) {
            this.buttonBookmark.setButtonListener(this.listener);
        }
    }

    public ChoiceModelApp getBrowserState() {
        return this.browserState;
    }

    public void setBrowserState(ChoiceModelApp choiceModelApp) {
        this.browserState = choiceModelApp;
    }

    public int getBrowserStateValue() {
        if (this.browserState != null) {
            return this.browserState.getValue();
        }
        return NULL_VALUE;
    }

    public void setBrowserStateValue(int n) {
        if (this.browserState != null) {
            this.browserState.setValue(n);
        }
    }

    public ChoiceModelApp getBrowserSync() {
        return this.browserSync;
    }

    public void setBrowserSync(ChoiceModelApp choiceModelApp) {
        this.browserSync = choiceModelApp;
    }

    public void setVehicleSpeedChoice(ChoiceModelApp choiceModelApp) {
        this.vehicleSpeedChoice = choiceModelApp;
    }

    public void setVehicleSpeedChoiceValue(int n) {
        if (this.vehicleSpeedChoice != null) {
            this.vehicleSpeedChoice.setValue(n);
        }
    }

    public void setBrowserSpeedChoice(ChoiceModelApp choiceModelApp) {
        this.browserSpeedChoice = choiceModelApp;
    }

    public void setBrowserSpeedChoiceValue(int n) {
        if (this.browserSpeedChoice != null) {
            this.browserSpeedChoice.setValue(n);
        }
    }

    public LabelModelApp getLabelTitle() {
        return this.labelTitle;
    }

    public void setLabelTitle(LabelModelApp labelModelApp) {
        this.labelTitle = labelModelApp;
    }

    public void setLabelTitleText(String string) {
        if (this.labelTitle != null) {
            this.labelTitle.setText(string);
        }
    }

    public ChoiceModelApp getSkAvailableChoice() {
        return this.skAvailableChoice;
    }

    public int getSkAvailableChoiceValue() {
        if (this.skAvailableChoice != null) {
            return this.skAvailableChoice.getValue();
        }
        return NULL_VALUE;
    }

    public int getSkAvailableChoiceStatus() {
        if (this.skAvailableChoice != null) {
            return this.skAvailableChoice.getStatus();
        }
        return NULL_VALUE;
    }

    public void setSkAvailableChoiceItemSelected(int n, int n2) {
        if (this.skAvailableChoice != null) {
            ((ChoiceModelGUI)((Object)this.skAvailableChoice)).itemSelected(n, n2);
        }
    }

    public void setSkAvailableChoice(ChoiceModelApp choiceModelApp) {
        this.skAvailableChoice = choiceModelApp;
    }

    public VirtualButtonModelApp getVirtualButton() {
        return this.virtualButton;
    }

    public void setVirtualButton(VirtualButtonModelApp virtualButtonModelApp) {
        this.virtualButton = virtualButtonModelApp;
        if (this.virtualButton != null) {
            this.virtualButton.setVirtualButtonListener(this.listener);
        }
    }

    public ChoiceModelApp getChoiceSidebar() {
        return this.choiceSidebar;
    }

    public void setChoiceSidebar(ChoiceModelApp choiceModelApp) {
        this.choiceSidebar = choiceModelApp;
        if (this.choiceSidebar != null) {
            this.choiceSidebar.setChoiceListener(this.listener);
        }
    }

    public void setBoardbookAvailableValue(int n) {
        if (this.boardbookAvailable != null) {
            this.boardbookAvailable.setValue(n);
        }
    }

    public void setBoardbookAvailableStatus(int n) {
        if (this.boardbookAvailable != null) {
            this.boardbookAvailable.setStatus(n);
        }
    }

    public void setBoardbookAvailableChoice(ChoiceModelApp choiceModelApp) {
        this.boardbookAvailable = choiceModelApp;
        if (this.boardbookAvailable != null) {
            this.boardbookAvailable.setValue(0);
        }
    }

    public void setKeyId(ChoiceModelApp choiceModelApp) {
        if (choiceModelApp != null) {
            this.keyId = choiceModelApp;
            choiceModelApp.setButtonListener(this.listener);
        }
    }

    public ChoiceModelApp getKeyId() {
        return this.keyId;
    }

    public void setBackButton(ButtonModelApp buttonModelApp) {
        if (buttonModelApp != null) {
            this.backButton = buttonModelApp;
            buttonModelApp.setButtonListener(this.listener);
        }
    }

    public ButtonModelApp getBackButton() {
        return this.backButton;
    }
}

