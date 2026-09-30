/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.DefaultChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class CharismaAddInfoConfigChoiceModelHandler
extends DefaultChoiceModelHandler {
    private static final int ADDITIONAL_INFO_DISPLAY_NONE = 0;
    private static final int ADDITIONAL_INFO_DISPLAY_POSITION = 1;
    private static final int ADDITIONAL_INFO_DISPLAY_ANGLE = 2;
    private static final int INVISIBLE = 0;
    private static final int VISIBLE = 1;
    private final CharismaAddInfoConfig[] addInfoConfigsPosition;
    private final CharismaAddInfoConfig[] addInfoConfigsAngle;
    private final ChoiceModelApp[] displayModelsPosition;
    private final ChoiceModelApp[] displayModelsAngle;

    public CharismaAddInfoConfigChoiceModelHandler(LogChannel logChannel, ChoiceModelApp choiceModelApp, ChoiceModelApp[] choiceModelAppArray, ChoiceModelApp[] choiceModelAppArray2, CharismaAddInfoConfig[] charismaAddInfoConfigArray, CharismaAddInfoConfig[] charismaAddInfoConfigArray2) {
        super(choiceModelApp, logChannel);
        this.addInfoConfigsPosition = charismaAddInfoConfigArray != null ? charismaAddInfoConfigArray : new CharismaAddInfoConfig[]{};
        this.addInfoConfigsAngle = charismaAddInfoConfigArray2 != null ? charismaAddInfoConfigArray2 : new CharismaAddInfoConfig[]{};
        this.displayModelsPosition = choiceModelAppArray != null ? choiceModelAppArray : new ChoiceModelApp[]{};
        this.displayModelsAngle = choiceModelAppArray2 != null ? choiceModelAppArray2 : new ChoiceModelApp[]{};
        this.readPersistentAdditionalInfo();
    }

    public void updateOnItemSelected(int n) {
        this.setSelectionPersistently(n);
        super.updateOnItemSelected(n);
    }

    private void setSelectionPersistently(int n) {
        this.updateDisplaySetting(n);
        this.writePersistentAdditionalInfo(n);
    }

    private void updateDisplaySetting(int n) {
        this.updateDisplaySetting(this.displayModelsAngle, n == 2);
        this.updateDisplaySetting(this.displayModelsPosition, n == 1);
    }

    private void updateDisplaySetting(ChoiceModelApp[] choiceModelAppArray, boolean bl) {
        for (int i2 = 0; i2 < choiceModelAppArray.length; ++i2) {
            ChoiceModelApp choiceModelApp = choiceModelAppArray[i2];
            if (choiceModelApp == null) continue;
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[CharismaAddInfoConfigChoiceModelHandler#updateDisplaySetting] set model value : value='%1' , displayModel='%2'", (Object)new Integer(bl ? 1 : 0), (Object)choiceModelApp);
            }
            choiceModelApp.setValue(bl ? 1 : 0);
        }
    }

    private void readPersistentAdditionalInfo() {
        int n = this.getSelection(this.displayAddInfoAngle(), this.displayAddInfoPosition());
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaAddInfoConfigChoiceModelHandler#readPersistentAdditionalInfo] selection for ChoiceModel('%1') read from persistence: choiceValue='%2'", (long)this.getChoiceModel().getID(), (long)n);
        }
        this.updateDisplaySetting(n);
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

    private boolean displayAddInfoAngle() {
        return this.displayAddInfo(this.addInfoConfigsAngle);
    }

    private boolean displayAddInfoPosition() {
        return this.displayAddInfo(this.addInfoConfigsPosition);
    }

    private boolean displayAddInfo(CharismaAddInfoConfig[] charismaAddInfoConfigArray) {
        for (int i2 = 0; i2 < charismaAddInfoConfigArray.length; ++i2) {
            if (charismaAddInfoConfigArray[i2] == null || !charismaAddInfoConfigArray[i2].readPersistentAdditionalInfo()) continue;
            return true;
        }
        return false;
    }

    private void writePersistentAdditionalInfo(int n) {
        this.writePersistentAdditionalInfo(this.addInfoConfigsPosition, n == 1);
        this.writePersistentAdditionalInfo(this.addInfoConfigsAngle, n == 2);
    }

    private void writePersistentAdditionalInfo(CharismaAddInfoConfig[] charismaAddInfoConfigArray, boolean bl) {
        for (int i2 = 0; i2 < charismaAddInfoConfigArray.length; ++i2) {
            if (charismaAddInfoConfigArray[i2] == null) continue;
            charismaAddInfoConfigArray[i2].writePersistentAdditionalInfo(bl);
        }
    }
}

