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
    public static final int STATE_AVAILABLE = 0;
    public static final int STATE_NOT_AVAILABLE = 2;
    public static final int INSTANCE_UNKNOWN = -1;
    public static final int INSTANCE_TEST = 0;
    public static final int INSTANCE_DAB = 1;
    public static final int INSTANCE_POI = 2;
    public static final int INSTANCE_BOS = 3;
    public static final int INSTANCE_GE = 4;
    public static final int INSTANCE_REMOTEHMI = 5;
    public static final int INSTANCE_REMOTEHMI_FULLSCREEN = 6;
    public static final int INSTANCE_BOARDBOOK = 7;
    public static final int INSTANCE_COUNT = 8;
    public static final Integer DEVICEINSTANCE_DSIBROWSER_TEST = new Integer(0);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_BOARDBOOK = new Integer(7);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_DAB = new Integer(1);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_POI = new Integer(2);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_BOS = new Integer(3);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_GE = new Integer(4);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_REMOTEHMI = new Integer(5);
    public static final Integer DEVICEINSTANCE_DSIBROWSER_REMOTEHMI_FULLSCREEN = new Integer(6);

    public void initialize(VirtualButtonModelApp var1, ChoiceModelApp var2, ChoiceModelApp var3, ChoiceModelApp var4, ChoiceModelApp var5, int var6, ChoiceModelApp var7, ChoiceModelApp var8, ChoiceModelApp var9, ButtonModelApp var10, ButtonModelApp var11, ButtonModelApp var12, RangeModelApp var13, LabelModelApp var14, LabelModelApp var15, ChoiceModelApp var16);

    public void initialize(VirtualButtonModelApp var1, ChoiceModelApp var2, ChoiceModelApp var3, ChoiceModelApp var4, ChoiceModelApp var5, int var6, ChoiceModelApp var7, ChoiceModelApp var8, ChoiceModelApp var9, ButtonModelApp var10, ButtonModelApp var11, ButtonModelApp var12);

    public void initialize(VirtualButtonModelApp var1, ChoiceModelApp var2, ChoiceModelApp var3, ChoiceModelApp var4, ChoiceModelApp var5, int var6);

    public void setRangeModels(RangeModelApp var1);

    public void setZoomLabel(LabelModelApp var1);

    public void setLabels(LabelModelApp var1);

    public void setModels(ChoiceModelApp var1, ChoiceModelApp var2, ChoiceModelApp var3, ButtonModelApp var4, ButtonModelApp var5, ButtonModelApp var6, ButtonModelApp var7, ButtonModelApp var8, ChoiceModelApp var9, ButtonModelApp var10);

    public void setBrowserSyncModel(ChoiceModelApp var1);

    public ChoiceModelApp getBrowserSyncModel();

    public void setEfiUrlHandler(EfiUrlHandler var1);

    public void setNotifications();

    public void loadUrl(String var1, boolean var2);

    public void suspendBrowser();

    public void setLanguage(String var1);

    public void setBoardBookConfigured(boolean var1);

    public void setSKAvailableChoice(ChoiceModelApp var1);

    public void deleteHistory();

    public void browserScreenEnteredByHistory();

    public void resumeBrowser();

    public void startBoardbook();

    public int reloadUrl();

    public void stopBrowser();

    public void scroll(int var1, int var2);

    public void prevFocus(int var1);

    public void nextFocus(int var1);

    public void setBrowserCallbackHandler(IBrowserCallbackHandler var1);

    public IBrowserCallbackHandler getBrowserCallBackHandler();

    public void openBoardbookStartPage();

    public void keyboardInput(String var1);

    public String getLastActiveUrl();

    public void setLastActiveUrl(String var1);

    public void wakeUp();

    public void cancelLoading();

    public void followLink(boolean var1);

    public void goForward();

    public void zoom(int var1, boolean var2);

    public void goBack();

    public void gotoHomeUrl();

    public void setBrowserSyncStatus(int var1);

    public void resetToFactorySettings();

    public void touchScreenPressed(int var1, int var2);

    public void touchScreenMoved(int var1, int var2, int var3, int var4);

    public void setBoardBookAvailableModel(ChoiceModelApp var1);
}

