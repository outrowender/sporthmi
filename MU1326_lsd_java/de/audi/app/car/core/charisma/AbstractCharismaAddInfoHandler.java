/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.DefaultChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCharismaAddInfoHandler
extends DefaultChoiceModelHandler {
    protected LogChannel logChannel = null;
    private final int[] configIds;
    private final Map configs = new HashMap();

    public AbstractCharismaAddInfoHandler(LogChannel logChannel, ChoiceModelApp choiceModelApp, CharismaAddInfoConfig[] charismaAddInfoConfigArray) {
        super(choiceModelApp, logChannel);
        this.logChannel = logChannel;
        this.configIds = new int[charismaAddInfoConfigArray.length];
        for (int i2 = 0; i2 < charismaAddInfoConfigArray.length; ++i2) {
            this.configs.put(new Integer(charismaAddInfoConfigArray[i2].getId()), charismaAddInfoConfigArray[i2]);
            this.configIds[i2] = charismaAddInfoConfigArray[i2].getId();
        }
        this.readPersistentAdditionalInfo();
    }

    public void updateOnItemSelected(int n) {
        this.handleItemSelected(n);
        super.updateOnItemSelected(n);
    }

    protected CharismaAddInfoConfig getConfig(int n) {
        Integer n2 = new Integer(n);
        if (this.configs.containsKey(n2)) {
            return (CharismaAddInfoConfig)this.configs.get(new Integer(n));
        }
        this.logChannel.log(100000, "[AbstractCharismaAddInfoHandler#getConfig] Config not found in Map! config=%1", (long)n);
        return null;
    }

    protected void setAllInvisible() {
        this.setVisible(this.configIds, false);
    }

    protected void setVisible(int[] nArray, boolean bl) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.setVisible(nArray[i2], bl);
        }
    }

    protected void setVisible(int n, boolean bl) {
        this.logChannel.log(1000000, "[AbstractCharismaAddInfoHandler#setVisible] config=%2 visible=%1", bl, (long)n);
        CharismaAddInfoConfig charismaAddInfoConfig = this.getConfig(n);
        if (charismaAddInfoConfig != null) {
            charismaAddInfoConfig.setVisible(bl);
            charismaAddInfoConfig.writePersistentAdditionalInfo(bl);
        } else {
            this.logChannel.log(100000, "[AbstractCharismaAddInfoHandler#setVisible] Not setting visible! Config not available! config=%1", (long)n);
        }
    }

    protected abstract void handleItemSelected(int var1);

    protected abstract void readPersistentAdditionalInfo();
}

