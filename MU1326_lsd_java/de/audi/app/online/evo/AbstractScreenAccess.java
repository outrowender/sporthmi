/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractScreenAccess$ModelData;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class AbstractScreenAccess {
    static final int MODEL_TYPE_LABEL;
    static final int MODEL_TYPE_LIST;
    static final int MODEL_TYPE_RESOURCE_LOCATOR;
    static final int MODEL_TYPE_CHOICE;
    static final int MODEL_TYPE_BUTTON;
    private final ChoiceModelApp screenTypeChoice;
    private final LogChannel logChannel;

    protected AbstractScreenAccess(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.screenTypeChoice = choiceModelApp;
        this.logChannel = logChannel;
    }

    public boolean isMainScreen() {
        return this.screenTypeChoice.getValue() == 0;
    }

    public boolean switchScreen(boolean bl) {
        int n;
        this.logChannel.log(1078071040, "AbstractScreenAccess#switchScreen: switch to '%1' screen", (Object)(bl ? "Main" : "Option"));
        int n2 = n = bl ? 0 : 1;
        if (this.screenTypeChoice.getValue() == n) {
            return false;
        }
        this.screenTypeChoice.setValue(n);
        return true;
    }

    public void refreshModelGroup(ModelGroup modelGroup, AbstractScreenAccess$ModelData[] abstractScreenAccess$ModelDataArray) {
        boolean bl = this.isMainScreen();
        for (AbstractScreenAccess$ModelData abstractScreenAccess$ModelData : abstractScreenAccess$ModelDataArray) {
            if (abstractScreenAccess$ModelData == null || !abstractScreenAccess$ModelData.isAddedToModelGroup()) continue;
            modelGroup.replaceOrAdd(abstractScreenAccess$ModelData.getModel(!bl), abstractScreenAccess$ModelData.getModel(bl));
        }
    }
}

