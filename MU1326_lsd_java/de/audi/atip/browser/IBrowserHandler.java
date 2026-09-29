/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.browser;

import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;

public interface IBrowserHandler {
    public static final int STATE_AVAILABLE;
    public static final int STATE_NOT_AVAILABLE;
    public static final int INSTANCE_UNKNOWN;
    public static final int INSTANCE_TEST;
    public static final int INSTANCE_DAB;
    public static final int INSTANCE_POI;
    public static final int INSTANCE_BOS;
    public static final int INSTANCE_GE;
    public static final int INSTANCE_REMOTEHMI;
    public static final int INSTANCE_REMOTEHMI_FULLSCREEN;
    public static final int INSTANCE_BOARDBOOK;
    public static final int INSTANCE_COUNT;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_TEST;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_BOARDBOOK;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_DAB;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_POI;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_BOS;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_GE;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_REMOTEHMI;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_REMOTEHMI_FULLSCREEN;

    default public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n, ChoiceModelApp choiceModelApp5, ChoiceModelApp choiceModelApp6, ChoiceModelApp choiceModelApp7, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, RangeModelApp rangeModelApp, LabelModelApp labelModelApp, LabelModelApp labelModelApp2, ChoiceModelApp choiceModelApp8) {
    }

    default public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n, ChoiceModelApp choiceModelApp5, ChoiceModelApp choiceModelApp6, ChoiceModelApp choiceModelApp7, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3) {
    }

    default public void initialize(VirtualButtonModelApp virtualButtonModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, int n) {
    }

    default public void setRangeModels(RangeModelApp rangeModelApp) {
    }

    default public void setZoomLabel(LabelModelApp labelModelApp) {
    }

    default public void setLabels(LabelModelApp labelModelApp) {
    }

    default public void setModels(ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, ButtonModelApp buttonModelApp4, ButtonModelApp buttonModelApp5, ChoiceModelApp choiceModelApp4, ButtonModelApp buttonModelApp6) {
    }

    default public void setBrowserSyncModel(ChoiceModelApp choiceModelApp) {
    }

    default public ChoiceModelApp getBrowserSyncModel() {
    }

    default public void setEfiUrlHandler(EfiUrlHandler efiUrlHandler) {
    }

    default public void setNotifications() {
    }

    default public void loadUrl(String string, boolean bl) {
    }

    default public void suspendBrowser() {
    }

    default public void setLanguage(String string) {
    }

    default public void setBoardBookConfigured(boolean bl) {
    }

    default public void setSKAvailableChoice(ChoiceModelApp choiceModelApp) {
    }

    default public void deleteHistory() {
    }

    default public void browserScreenEnteredByHistory() {
    }

    default public void resumeBrowser() {
    }

    default public void startBoardbook() {
    }

    default public int reloadUrl() {
    }

    default public void stopBrowser() {
    }

    default public void scroll(int n, int n2) {
    }

    default public void prevFocus(int n) {
    }

    default public void nextFocus(int n) {
    }

    default public void setBrowserCallbackHandler(IBrowserCallbackHandler iBrowserCallbackHandler) {
    }

    default public IBrowserCallbackHandler getBrowserCallBackHandler() {
    }

    default public void openBoardbookStartPage() {
    }

    default public void keyboardInput(String string) {
    }

    default public String getLastActiveUrl() {
    }

    default public void setLastActiveUrl(String string) {
    }

    default public void wakeUp() {
    }

    default public void cancelLoading() {
    }

    default public void followLink(boolean bl) {
    }

    default public void goForward() {
    }

    default public void zoom(int n, boolean bl) {
    }

    default public void goBack() {
    }

    default public void gotoHomeUrl() {
    }

    default public void setBrowserSyncStatus(int n) {
    }

    default public void resetToFactorySettings() {
    }

    default public void touchScreenPressed(int n, int n2) {
    }

    default public void touchScreenMoved(int n, int n2, int n3, int n4) {
    }

    default public void setBoardBookAvailableModel(ChoiceModelApp choiceModelApp) {
    }

    static {
        DEVICEINSTANCE_DSIBROWSER_TEST = new Integer(0);
        DEVICEINSTANCE_DSIBROWSER_BOARDBOOK = new Integer(7);
        DEVICEINSTANCE_DSIBROWSER_DAB = new Integer(1);
        DEVICEINSTANCE_DSIBROWSER_POI = new Integer(2);
        DEVICEINSTANCE_DSIBROWSER_BOS = new Integer(3);
        DEVICEINSTANCE_DSIBROWSER_GE = new Integer(4);
        DEVICEINSTANCE_DSIBROWSER_REMOTEHMI = new Integer(5);
        DEVICEINSTANCE_DSIBROWSER_REMOTEHMI_FULLSCREEN = new Integer(6);
    }
}

