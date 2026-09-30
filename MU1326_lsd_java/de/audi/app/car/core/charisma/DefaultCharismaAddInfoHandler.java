/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaAddInfoHandler;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class DefaultCharismaAddInfoHandler
extends AbstractCharismaAddInfoHandler {
    private static final int ADDITIONAL_INFO_DISPLAY_NONE = 0;
    private static final int ADDITIONAL_INFO_DISPLAY_POSITION = 1;
    private static final int ADDITIONAL_INFO_DISPLAY_ANGLE = 2;
    private static int[][] g22Mapping = new int[][]{new int[0], {0, 1, 2}, {3, 4, 5}};

    public DefaultCharismaAddInfoHandler(LogChannel logChannel, ChoiceModelApp choiceModelApp, CharismaAddInfoConfig[] charismaAddInfoConfigArray) {
        super(logChannel, choiceModelApp, charismaAddInfoConfigArray);
    }

    protected void handleItemSelected(int n) {
        this.setAllInvisible();
        if (n != 0) {
            this.setVisible(g22Mapping[n], true);
        }
    }

    protected void readPersistentAdditionalInfo() {
        int n = this.getSelection(this.isAddInfoDisplayed(g22Mapping[2]), this.isAddInfoDisplayed(g22Mapping[1]));
        this.setAllInvisible();
        this.setVisible(g22Mapping[n], true);
        this.updateChoiceModelValue(n);
    }

    private int getSelection(boolean bl, boolean bl2) {
        if (bl2) {
            return 1;
        }
        if (bl) {
            return 2;
        }
        return 0;
    }

    private boolean isAddInfoDisplayed(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            CharismaAddInfoConfig charismaAddInfoConfig = this.getConfig(nArray[i2]);
            if (charismaAddInfoConfig == null || !charismaAddInfoConfig.readPersistentAdditionalInfo()) continue;
            return true;
        }
        return false;
    }
}

