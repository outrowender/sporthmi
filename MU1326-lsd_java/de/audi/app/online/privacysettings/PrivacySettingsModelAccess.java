/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.privacysettings;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class PrivacySettingsModelAccess {
    public ButtonModelApp deactivateNadButtonModel;
    public ButtonModelApp activateNadButtonModel;
    public ChoiceModelApp privacyModeOnOffChoice;

    public PrivacySettingsModelAccess(ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ChoiceModelApp choiceModelApp) {
        this.deactivateNadButtonModel = buttonModelApp;
        this.activateNadButtonModel = buttonModelApp2;
        this.privacyModeOnOffChoice = choiceModelApp;
    }
}

