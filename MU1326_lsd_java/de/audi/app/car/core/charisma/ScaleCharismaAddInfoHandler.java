/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaAddInfoHandler;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class ScaleCharismaAddInfoHandler
extends AbstractCharismaAddInfoHandler {
    private static final int ADDITIONAL_INFO_DISPLAY_NONE;
    private static int[] g21Mapping;

    public ScaleCharismaAddInfoHandler(LogChannel logChannel, ChoiceModelApp choiceModelApp, CharismaAddInfoConfig[] charismaAddInfoConfigArray) {
        super(logChannel, choiceModelApp, charismaAddInfoConfigArray);
    }

    @Override
    protected void handleItemSelected(int n) {
        this.setAllInvisible();
        if (n != 0) {
            this.setVisible(g21Mapping[n], true);
        }
    }

    @Override
    protected void readPersistentAdditionalInfo() {
        int n = 0;
        for (int i2 = 1; i2 < g21Mapping.length; ++i2) {
            CharismaAddInfoConfig charismaAddInfoConfig = this.getConfig(g21Mapping[i2]);
            if (charismaAddInfoConfig == null || !charismaAddInfoConfig.readPersistentAdditionalInfo()) continue;
            n = i2;
            break;
        }
        this.setAllInvisible();
        if (g21Mapping[n] != 0) {
            this.setVisible(g21Mapping[n], true);
        }
        this.updateChoiceModelValue(n);
    }

    static {
        g21Mapping = new int[]{0, 3, 4, 5};
    }
}

