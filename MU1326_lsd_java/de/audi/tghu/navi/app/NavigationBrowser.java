/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationBrowser$FreetextSpeller;
import de.audi.tghu.navi.app.NavigationBrowserCallbackHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class NavigationBrowser
implements ButtonListener {
    public static final String URL_PREFIX;
    public static final String EXTURL_PREFIX;
    public static final String EXTURL_PREFIX_SECURE;
    public static final int DETAILS_SCREEN_NORMAL;
    public static final int DETAILS_SCREEN_LOADING;
    public static final int DETAILS_SCREEN_BROWSER;
    private final NavigationEnv env;
    private LogChannel logChannel;
    private final boolean[] visible = new boolean[8];
    private final IBrowserHandler[] browserHandlers = new IBrowserHandler[8];
    private final String[] bufferedURL = new String[8];
    private final boolean[] deleteCache = new boolean[8];
    private final EfiUrlHandler[] efiUrlHandlers = new EfiUrlHandler[8];
    private final NavigationBrowser$FreetextSpeller[] freetextSpellers = new NavigationBrowser$FreetextSpeller[8];
    private ChoiceModelApp browserTypeChoice;
    private boolean[] browsersSuspended = new boolean[8];

    public NavigationBrowser(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.browserTypeChoice = navigationEnv.getChoiceModel(-1021573632);
        navigationEnv.getButtonModel(-1508047360).setButtonListener(this);
        navigationEnv.getButtonModel(-1524824576).setButtonListener(this);
        navigationEnv.getButtonModel(-1541601792).setButtonListener(this);
        for (int i2 = 0; i2 < 8; ++i2) {
            this.browsersSuspended[i2] = false;
        }
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler, int n) {
        this.logChannel.log(-2137614336, "NavigationBrowser#setBrowserHandler() -instance %1", (long)n);
        if (n != 2 || iBrowserHandler == null) {
            this.logChannel.log(-1601830656, "NavigationBrowser#setBrowserHandler() - unknown instance: %1", (long)n);
            this.browserHandlers[n] = null;
            return;
        }
        int n2 = 7;
        VirtualButtonModelApp virtualButtonModelApp = this.env.getVirtualButtonModel(-1323235840);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(538904064);
        ButtonModelApp buttonModelApp = this.env.getButtonModel(-2145384960);
        ChoiceModelApp choiceModelApp2 = this.env.getChoiceModel(1696269824);
        LabelModelApp labelModelApp = this.env.getLabelModel(1713047040);
        ChoiceModelApp choiceModelApp3 = this.env.getChoiceModel(-585366016);
        ChoiceModelApp choiceModelApp4 = this.env.getChoiceModel(1746601472);
        this.browserHandlers[n] = iBrowserHandler;
        this.browserHandlers[n].setBrowserCallbackHandler(new NavigationBrowserCallbackHandler(this.env, this.logChannel));
        this.browserHandlers[n].initialize(virtualButtonModelApp, choiceModelApp, choiceModelApp3, choiceModelApp4, null, n2);
        this.browserHandlers[n].setLabels(labelModelApp);
        this.browserHandlers[n].setModels(null, null, null, buttonModelApp, null, null, null, null, null, null);
        this.browserHandlers[n].setBrowserSyncModel(choiceModelApp2);
        this.browserHandlers[n].setEfiUrlHandler(this.efiUrlHandlers[n]);
    }

    public void registerEfiUrlHandler(EfiUrlHandler efiUrlHandler, int n) {
        this.efiUrlHandlers[n] = efiUrlHandler;
        if (this.browserHandlers[n] != null) {
            this.browserHandlers[n].setEfiUrlHandler(efiUrlHandler);
        }
    }

    public void registerFreetextSpeller(NavigationBrowser$FreetextSpeller freetextSpeller, int n) {
        this.freetextSpellers[n] = freetextSpeller;
    }

    public void browserVisible(boolean bl, int n) {
        this.logChannel.log(-2137614336, "NavigationBrowser#browserVisible( %1, %2 )", bl, (long)n);
        if (this.browserHandlers[n] == null) {
            this.logChannel.log(10000, "NavigationBrowser#browserVisible() - browser not ready [browserHandler[%1] == null]!", (long)n);
            return;
        }
        this.visible[n] = bl;
        if (bl) {
            if (this.browsersSuspended[n]) {
                this.logChannel.log(-2137614336, "NavigationBrowser#browserVisible() - resuming browser ( %1 )", (long)n);
                this.browserHandlers[n].resumeBrowser();
                this.browsersSuspended[n] = false;
                if (!Util.isEmpty(this.bufferedURL[n])) {
                    this.browserHandlers[n].loadUrl(this.bufferedURL[n], this.deleteCache[n]);
                    this.bufferedURL[n] = null;
                } else if (this.browserHandlers[n].getBrowserSyncModel() != null && this.browserHandlers[n].getBrowserSyncModel().getStatus() == 2 && this.browserHandlers[n].getLastActiveUrl() != null) {
                    String string = this.browserHandlers[n].getLastActiveUrl();
                    this.logChannel.log(-2137614336, "NavigationBrowser#browserVisible() - last state was error, loading last URL again. %1", (Object)string);
                    this.browserHandlers[n].loadUrl(string, false);
                }
            } else {
                if (!Util.isEmpty(this.bufferedURL[n])) {
                    this.logChannel.log(-2137614336, "NavigationBrowser#browserVisible() - startBrowser( %1 ) - buffer set", (Object)this.bufferedURL[n]);
                    this.browserHandlers[n].loadUrl(this.bufferedURL[n], this.deleteCache[n]);
                    this.bufferedURL[n] = null;
                } else {
                    this.logChannel.log(-2137614336, "NavigationBrowser#browserVisible() - startBrowser( ) - enter by history");
                    this.browserHandlers[n].loadUrl(null, false);
                }
                this.deleteCache[n] = false;
            }
        } else {
            this.logChannel.log(-2137614336, "NavigationBrowser#browserVisible() - stopBrowser() ");
            if (this.freetextSpellers[n] != null) {
                this.freetextSpellers[n].finishSpeller();
            }
            this.browserHandlers[n].suspendBrowser();
            this.browsersSuspended[n] = true;
        }
    }

    public boolean loadURL(int n, String string, boolean bl) {
        String string2 = string;
        if (!(string2 == null || string2.startsWith("file://") || string2.startsWith("http://") || string2.startsWith("https://"))) {
            string2 = new StringBuffer().append("file://").append(string2).toString();
        }
        this.logChannel.log(-2137614336, "NavigationBrowser#loadURL( %1 ) Instance %2", (Object)string2, (long)n);
        this.bufferedURL[n] = string2;
        this.logChannel.log(-2137614336, "NavigationBrowser#loadURL bufferedURL:  %1 ", (Object)this.bufferedURL[n]);
        this.deleteCache[n] = bl;
        if (this.browserHandlers[n] == null) {
            this.logChannel.log(10000, "NavigationBrowser#loadURL() - browser not ready [browserHandler[%1] == null]!", (long)n);
            return false;
        }
        this.browserTypeChoice.setValue(n);
        this.browserVisible(true, n);
        this.browserHandlers[n].getBrowserCallBackHandler().updateBrowserStateBusy(true);
        return true;
    }

    public boolean finishSpeller(int n, String string, boolean bl) {
        boolean bl2;
        this.logChannel.log(-2137614336, "NavigationBrowser#finishSpeller( %3, %2, %1 )", bl, (Object)string, (Object)Integer.toString(n));
        if (this.browserHandlers[n] == null) {
            this.logChannel.log(10000, "NavigationBrowser#finishSpeller() - browser not ready [browserHandler[%1] == null]!", (long)n);
            bl2 = false;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public String printBrowserStatus() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < 8; ++i2) {
            buffer.append("browserHandlers[").append(i2).append("]: ").append(this.browserHandlers[i2]).append("\n");
            buffer.append("bufferedURL[").append(i2).append("]: ").append(this.bufferedURL[i2]).append("\n");
            buffer.append("visible[").append(i2).append("]: ").append(this.visible[i2]).append("\n");
            buffer.append("suspended[").append(i2).append("]: ").append(this.browsersSuspended[i2]).append("\n");
        }
        return buffer.toString();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "NavigationBrowser#keyPressed( %1 )", (long)n);
        switch (n) {
            case 400806: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400805: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400804: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401536: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "NavigationBrowser#keyPressed( %1 ) - unknown modelID.", (long)n);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    public IBrowserHandler getBrowserInstance(int n) {
        return this.browserHandlers[n];
    }

    public void setDetailScreenLoading() {
        this.env.getChoiceModel(1747125760).setValue(1);
    }

    public void setDetailScreenNormal() {
        this.env.getChoiceModel(1747125760).setValue(0);
    }

    public int getCurrentDetailScreenState() {
        return this.env.getChoiceModel(1747125760).getValue();
    }
}

