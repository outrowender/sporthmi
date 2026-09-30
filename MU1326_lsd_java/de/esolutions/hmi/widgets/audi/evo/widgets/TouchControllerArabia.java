/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataArabia;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchInputDataArabia;

public class TouchControllerArabia
extends TouchController {
    private static boolean arabicCharsetActivated;
    private static boolean isLatinOnlyField;
    private TouchInputDataArabia inputData = (TouchInputDataArabia)this.inputFieldData;
    private String orientationMark;

    public TouchControllerArabia() {
        this(new TouchInputDataArabia());
    }

    protected void setLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        super.setLanguage(touchCharSetAndTTSHandler);
        if (this.inputData == null) {
            this.inputData = (TouchInputDataArabia)this.inputFieldData;
        }
        this.inputData.setSystemLanguageArabic(!this.isLTR());
        isLatinOnlyField = this.isLatinOnly();
        boolean bl = this.isLatinOnly() ? false : (arabicCharsetActivated = touchCharSetAndTTSHandler.getCharSet() == 2);
        if (!this.isAutoCharsetSwitch() && touchCharSetAndTTSHandler.getCharSet() == 2) {
            this.inputData.setRTL(true);
        }
        if (!this.isAutoCharsetSwitch() && touchCharSetAndTTSHandler.getCharSet() == 0) {
            this.inputData.setRTL(false);
        }
        this.setAutoCharsetSwitch(false);
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.inputData.setSystemLanguageArabic(!this.isLTR());
        this.inputData.setRTL(TouchControllerArabia.isArabicCharSetActivated());
    }

    protected void stringEntered(String string, String[] stringArray) {
        if (string == null || string.length() == 0 || this.isInputLocked()) {
            tpLogChannelKeypanel.log(10000000, "TouchController#stringEntered return because inputString is Empty or cuz blockSpellerInput=%1", this.isInputLocked());
            return;
        }
        char c2 = string.charAt(string.length() - 1);
        if (c2 == '\b') {
            if (this.inputData == null) {
                this.inputData = (TouchInputDataArabia)this.inputFieldData;
            }
            if (stringArray == null) {
                this.inputData.setDeleteWithTouchPad(false);
            } else {
                this.inputData.setDeleteWithTouchPad(true);
            }
        }
        super.stringEntered(string, stringArray);
    }

    protected void handleHKBackShortPress() {
        this.inputData.setDeleteWithTouchPad(false);
        super.handleHKBackShortPress();
    }

    protected TouchControllerArabia(ITouchInputDataArabia iTouchInputDataArabia) {
        super(iTouchInputDataArabia);
    }

    public static boolean isArabicCharSetActivated() {
        return arabicCharsetActivated;
    }

    public String getCurrentOrientationMark() {
        if (this.orientationMark == null) {
            return "";
        }
        return this.orientationMark;
    }

    public int getLanguageIndicatorIconIndex() {
        if (this.touchUtil != null && !this.isLatinOnly() && this.terminal != null && this.terminal.getViewSizeManager() != null && this.terminal.getViewSizeManager().getCurrentViewSize() == 2) {
            return this.touchUtil.getLanguageIndicatorIconIndex();
        }
        return TouchControllerArabia.isLatinOnlyField() && this.touchUtil.getSystemLanguage() == 26 && this.getTouchpadMode() != 64 ? 1 : 0;
    }

    public void setCurrentOrientationMark(String string) {
        this.orientationMark = string;
    }

    public static boolean isLatinOnlyField() {
        return isLatinOnlyField;
    }

    public void setFingerTraceMaxOpacity(float f2) {
        if (this.fingerTraceWidget != null) {
            this.fingerTraceWidget.setMaxOpacity(f2);
        }
    }

    protected void updateModelText(String string, char c2) {
        string = StringUtility.revertTextToArabicBlock(string);
        super.updateModelText(string, c2);
    }
}

