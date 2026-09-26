/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.AbstractBrowserHandler;
import de.audi.tghu.browser.app.ContextSwitchBrowserHandler$1;
import org.dsi.ifc.browser.KeyboardInfo;

public class ContextSwitchBrowserHandler
extends AbstractBrowserHandler {
    public ContextSwitchBrowserHandler(IFrameworkAccess iFrameworkAccess, int n, LogChannel logChannel, LogChannel logChannel2) {
        super(iFrameworkAccess, n, logChannel, logChannel2);
    }

    @Override
    public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n, ChoiceModelApp choiceModelApp5, ChoiceModelApp choiceModelApp6, ChoiceModelApp choiceModelApp7, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, RangeModelApp rangeModelApp, LabelModelApp labelModelApp, LabelModelApp labelModelApp2, ChoiceModelApp choiceModelApp8) {
        super.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, choiceModelApp3, choiceModelApp4, n, choiceModelApp5, choiceModelApp6, choiceModelApp7, buttonModelApp, buttonModelApp2, buttonModelApp3, rangeModelApp, labelModelApp, labelModelApp2, choiceModelApp8);
        if (this.modelHandler.getDisplayContextSwitchChoice() != null) {
            this.modelHandler.setDisplayContextSwitchChoiceValue(0);
            this.modelHandler.getDisplayContextSwitchChoice().setChoiceListener(new ContextSwitchBrowserHandler$1(this));
        }
    }

    @Override
    public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n, ChoiceModelApp choiceModelApp5, ChoiceModelApp choiceModelApp6, ChoiceModelApp choiceModelApp7, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3) {
        this.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, choiceModelApp3, choiceModelApp4, n, choiceModelApp5, choiceModelApp6, choiceModelApp7, buttonModelApp, buttonModelApp2, buttonModelApp3, null, null, null, null);
    }

    @Override
    public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n) {
        this.initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp2, choiceModelApp3, choiceModelApp4, n, null, null, null, null, null, null);
    }

    @Override
    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

