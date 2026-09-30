/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.mobilekey;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;

public class MobileKeyStatusDisplayModelAccess {
    public static final int CHOICE_VALUE_SERVICE_INACTIVE = 0;
    public static final int CHOICE_VALUE_SERVICE_ACTIVE = 1;
    private static final int CHOICE_VALUE_SERVICE_CAN_BE_ACTIVATED = 0;
    private static final int CHOICE_VALUE_SERVICE_DISABLED = 1;
    public static final int CHOICE_VALUE_FLEET_MODE_INACTIVE = 0;
    public static final int CHOICE_VALUE_FLEET_MODE_ACTIVE = 1;
    public static final int CHOICE_VALUE_BACKEND_STATE_KEYS_AVAILABLE = 0;
    public static final int CHOICE_VALUE_BACKEND_STATE_NO_INFORMATION = 1;
    public static final int CHOICE_VALUE_BACKEND_STATE_DELETION_IN_PROGRESS = 2;
    public static final int CHOICE_VALUE_SMART_CARD_DISABLED = 0;
    public static final int CHOICE_VALUE_SMART_CARD_ENABLED = 1;
    public static final int CHOICE_VALUE_KEY_TYPE_SMARTCARD = 0;
    public static final int CHOICE_VALUE_KEY_TYPE_MOBILE_KEY = 1;
    public static final int CHOICE_VALUE_KEY_TYPE_PHYSICAL = 2;
    private ChoiceModelApp serviceActiveChoice;
    private ChoiceModelApp serviceActiveStateCanBeModifiedChoice;
    private ButtonModelApp serviceActivateButton;
    private ButtonModelApp serviceDeactivateButton;
    private ButtonModelApp serviceResetButton;
    private ChoiceModelApp fleetModeActiveChoice;
    private ChoiceModelApp backendStateChoice;
    private ChoiceModelApp keyCountChoice;
    private LabelModelApp keyCountLabel;
    private ChoiceModelApp smartCardEnabledChoice;
    private ChoiceModelApp carKeyTypeChoice;
    private final LogChannel log;

    public MobileKeyStatusDisplayModelAccess(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void checkConfig() {
        this.checkMemberNotNull(this.serviceActiveChoice, "serviceActiveChoice");
        this.checkMemberNotNull(this.serviceActiveStateCanBeModifiedChoice, "serviceActiveStateCanBeModifiedChoice");
        this.checkMemberNotNull(this.serviceActivateButton, "serviceActivateButton");
        this.checkMemberNotNull(this.serviceDeactivateButton, "serviceDeactivateButton");
        this.checkMemberNotNull(this.serviceResetButton, "serviceResetButton");
        this.checkMemberNotNull(this.fleetModeActiveChoice, "fleetModeActiveChoice");
        this.checkMemberNotNull(this.backendStateChoice, "backendStateChoice");
        this.checkMemberNotNull(this.keyCountChoice, "keyCountChoice");
        this.checkMemberNotNull(this.keyCountLabel, "keyCountLabel");
        this.checkMemberNotNull(this.smartCardEnabledChoice, "smartCardEnabledChoice");
    }

    private void checkMemberNotNull(Object object, String string) {
        if (object == null) {
            this.log.log(10000, "MobileKeyStatusDisplayModelAccess#checkMemberNotNull %1 must not be null", (Object)string);
        }
    }

    public ChoiceModelApp getServiceActiveChoice() {
        return this.serviceActiveChoice;
    }

    public void setServiceActiveChoice(ChoiceModelApp choiceModelApp) {
        this.serviceActiveChoice = choiceModelApp;
    }

    public void updateServiceActive(boolean bl) {
        this.serviceActiveChoice.setValue(bl ? 1 : 0);
    }

    public ChoiceModelApp getServiceActiveStateCanBeModifiedChoice() {
        return this.serviceActiveStateCanBeModifiedChoice;
    }

    public void setServiceActiveStateCanBeModifiedChoice(ChoiceModelApp choiceModelApp) {
        this.serviceActiveStateCanBeModifiedChoice = choiceModelApp;
    }

    public void updateServiceActiveStateCanBeModified(boolean bl) {
        this.serviceActiveStateCanBeModifiedChoice.setValue(bl ? 0 : 1);
    }

    public ButtonModelApp getServiceActivateButton() {
        return this.serviceActivateButton;
    }

    public void setServiceActivateButton(ButtonModelApp buttonModelApp) {
        this.serviceActivateButton = buttonModelApp;
    }

    public ButtonModelApp getServiceDeactivateButton() {
        return this.serviceDeactivateButton;
    }

    public void setServiceDeactivateButton(ButtonModelApp buttonModelApp) {
        this.serviceDeactivateButton = buttonModelApp;
    }

    public ButtonModelApp getServiceResetButton() {
        return this.serviceResetButton;
    }

    public void setServiceResetButton(ButtonModelApp buttonModelApp) {
        this.serviceResetButton = buttonModelApp;
    }

    public ChoiceModelApp getFleetModeActiveChoice() {
        return this.fleetModeActiveChoice;
    }

    public void setFleetModeActiveChoice(ChoiceModelApp choiceModelApp) {
        this.fleetModeActiveChoice = choiceModelApp;
    }

    public void updateFleetModeActive(boolean bl) {
        this.fleetModeActiveChoice.setValue(bl ? 1 : 0);
    }

    public ChoiceModelApp getBackendStateChoice() {
        return this.backendStateChoice;
    }

    public void setBackendStateChoice(ChoiceModelApp choiceModelApp) {
        this.backendStateChoice = choiceModelApp;
    }

    public void updateBackendState(int n) {
        this.backendStateChoice.setValue(n);
    }

    public ChoiceModelApp getKeyCountChoice() {
        return this.keyCountChoice;
    }

    public void setKeyCountChoice(ChoiceModelApp choiceModelApp) {
        this.keyCountChoice = choiceModelApp;
    }

    public LabelModelApp getKeyCountLabel() {
        return this.keyCountLabel;
    }

    public void setKeyCountLabel(LabelModelApp labelModelApp) {
        this.keyCountLabel = labelModelApp;
    }

    public void updateKeyCount(int n) {
        this.keyCountChoice.setValue(n);
        this.keyCountLabel.setText(String.valueOf(n));
    }

    public ChoiceModelApp getSmartCardEnabledChoice() {
        return this.smartCardEnabledChoice;
    }

    public void setSmartCardEnabledChoice(ChoiceModelApp choiceModelApp) {
        this.smartCardEnabledChoice = choiceModelApp;
    }

    public void updateSmartCardEnabled(boolean bl) {
        this.smartCardEnabledChoice.setValue(bl ? 1 : 0);
    }

    public void setCarKeyTypeChoice(ChoiceModelApp choiceModelApp) {
        this.carKeyTypeChoice = choiceModelApp;
    }

    public void updatecarKeyTypeChoice(int n) {
        if (this.carKeyTypeChoice != null) {
            this.log.log(1000000, "MobileKeyStatusDisplayModelAccess#updatecarKeyTypeChoice new keyType: %1", (long)n);
            this.carKeyTypeChoice.setValue(n);
        } else {
            this.log.log(100000, "MobileKeyStatusDisplayModelAccess#updatecarKeyTypeChoice model is null! keyType: %1", (long)n);
        }
    }
}

