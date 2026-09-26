/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.browser.app.BoardbookBrowserHandler;
import de.audi.tghu.browser.app.BrowserModelHandler;

public class BrowserHMIListener
implements ChoiceListener,
VirtualButtonListener {
    private LogChannel log;
    private LogChannel logDSI;
    private IBrowserHandler browserHandler;
    private IBrowserCallbackHandler cbHandler;
    protected EfiUrlHandler efiUrlHandler;
    private int instance;
    private static final boolean SIMULATION;
    private static final int STEP_SIZE;
    public static final boolean USE_INCREMENTAL_ZOOM;
    private BrowserModelHandler modelHandler;
    private IFrameworkAccess framework;

    public BrowserHMIListener(IBrowserHandler iBrowserHandler, int n, IFrameworkAccess iFrameworkAccess, BrowserModelHandler browserModelHandler, LogChannel logChannel, LogChannel logChannel2) {
        this.browserHandler = iBrowserHandler;
        this.framework = iFrameworkAccess;
        this.instance = n;
        this.modelHandler = browserModelHandler;
        this.log = logChannel;
        this.logDSI = logChannel2;
    }

    public void setEfiUrlHandler(EfiUrlHandler efiUrlHandler) {
        this.efiUrlHandler = efiUrlHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.log.log(-2137614336, "BrowserHMIListener#keyPressed");
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.log.log(-2137614336, "BrowserHMIListener#keyReleased");
    }

    public LogChannel getLogChannel() {
        return this.log;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "BrowserHMIListener#keyTyped modelid %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
        if (this.framework.getSysConst(4168) == 5 && (n2 == 9 || n2 == 11)) {
            this.log.log(1078071040, "In case of Bentley KeyEvent %1 is suppresed to fix issue artf135109", (long)n2);
            return;
        }
        if (n == 640551168) {
            this.log.log(-2137614336, "BrowserHMIListener#keyTyped from BACK Button Model, set keyID to %1", (long)0);
            n2 = 15;
        }
        if (this.modelHandler.getKeyId() != null) {
            this.modelHandler.getKeyId().setValue(n2);
        }
        if (this.browserHandler != null) {
            this.log.log(-2137614336, "BrowserHMIListener#key typed modelID(%1) keyID(%2)", (long)n, (long)n2);
            if (n == this.modelHandler.getButtonCancelID()) {
                this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.cancelLoading()");
                this.browserHandler.cancelLoading();
                this.modelHandler.getButtonCancel().fireEvent(n3);
            } else if (n == this.modelHandler.getButtonReloadID()) {
                this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.reloadUrl()");
                this.browserHandler.reloadUrl();
            } else if (n == this.modelHandler.getButtonHomeID()) {
                this.log.log(1078071040, "BrowserHMIListener#keyTyped() Home Button");
                this.browserHandler.openBoardbookStartPage();
            } else if (n == this.modelHandler.getButtonIndexID()) {
                this.log.log(1078071040, "BrowserHMIListener#keyTyped() Index Button");
                ((BoardbookBrowserHandler)this.browserHandler).openPage(1);
            } else if (n == this.modelHandler.getButtonBookmarkID()) {
                if (this.instance != 7) {
                    this.log.log(-1601830656, "DefaultBrowserHandler: buttonBookmark pressed - no code yet");
                } else {
                    this.logDSI.log(1078071040, "BrowserHMIListener#keyTyped  dsiBrowserBoardbook.openPage(Constants.BOARDBOOKPAGE_STARTPAGE)");
                    ((BoardbookBrowserHandler)this.browserHandler).openPage(1);
                }
            } else {
                this.log.log(-2137614336, "BrowserHMIListener#keyTyped no matching modelID looking for keyIDs");
                block0 : switch (n2) {
                    case 17: {
                        this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.MENU_ENTER()");
                        boolean bl = false;
                        if (this.cbHandler != null) {
                            this.log.log(1078071040, "BrowserHMIListener#keyTyped relaying Enter to browser callback");
                            bl = this.cbHandler.press();
                        }
                        if (bl) break;
                        if (this.modelHandler.getChoiceSidebar() != null) {
                            int n4 = this.modelHandler.getChoiceSidebar().getValue();
                            if (n4 == 0) {
                                this.logDSI.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.followLink()");
                                this.browserHandler.followLink(false);
                                break;
                            }
                            this.log.log(1078071040, "BrowserHMIListener#keyTyped followLink not triggered because menu is open");
                            break;
                        }
                        this.logDSI.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.followLink()");
                        this.browserHandler.followLink(false);
                        break;
                    }
                    case 12: {
                        this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.KEY_SK_SE()");
                        if (this.efiUrlHandler != null && this.efiUrlHandler.goForward()) {
                            this.log.log(-2137614336, "BrowserHMIListener#keyTyped goForward processed by efiUrlHandler");
                            return;
                        }
                        this.logDSI.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.goForward()");
                        this.browserHandler.goForward();
                        break;
                    }
                    case 10: {
                        this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.KEY_SK_SW()");
                        this.log.log(-2137614336, "BrowserHMIListener#keyTyped goBack");
                        if (this.efiUrlHandler != null && this.efiUrlHandler.goBack()) {
                            this.log.log(-2137614336, "BrowserHMIListener#keyTyped goBack processed by efiUrlHandler");
                            return;
                        }
                        if (this.modelHandler.getVirtualButton() == null) break;
                        this.log.log(-2137614336, "BrowserHMIListener#keyTyped for keyID KEY_SK_SW sending exit event");
                        this.modelHandler.getVirtualButton().fireEvent(n3);
                        break;
                    }
                    case 11: {
                        this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.KEY_SK_NE()");
                        int n5 = this.modelHandler.getChoiceSidebar().getValue();
                        switch (n5) {
                            case 0: 
                            case 3: {
                                this.log.log(-2137614336, "BrowserHMIListener#keyTyped opening sidebar");
                                this.modelHandler.getChoiceSidebar().setValue(1);
                                break block0;
                            }
                            case 1: 
                            case 2: {
                                this.log.log(-2137614336, "BrowserHMIListener#keyTyped closing sidebar");
                                this.modelHandler.getChoiceSidebar().setValue(3);
                                break block0;
                            }
                        }
                        break;
                    }
                    case 15: {
                        this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.KEY_BACK()");
                        if (n == 1680673024 || n == 640551168) {
                            int n6 = this.modelHandler.getChoicePrevValue();
                            this.log.log(1078071040, "BrowserHMIListener: previous page available: %1", (long)n6);
                            if (n6 == 0) {
                                this.modelHandler.getVirtualButton().fireEvent(n3);
                                this.log.log(-2137614336, "BrowserHMIListener#keyTyped for keyID KEY_BACK send HK_RETURN");
                                return;
                            }
                            this.logDSI.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.goBack()");
                            this.browserHandler.goBack();
                        }
                        if (this.cbHandler == null) break;
                        this.cbHandler.virtualButtonBack();
                        break;
                    }
                    case 9: {
                        this.log.log(1078071040, "BrowserHMIListener#keyTyped dsiBrowser.KEY_SK_NW()");
                        this.logDSI.log(1078071040, "BrowserHMIListener#keyTyped: dsiBrowser.gotoHomeUrl()");
                        this.browserHandler.gotoHomeUrl();
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("BrowserHMIListener#keyTyped Unknown keyEvent");
                    }
                }
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == ((ChoiceModel)this.modelHandler.getChoiceSidebar()).getID()) {
            this.log.log(1078071040, "BrowserHMIListener#itemSelected() sidebar state: %1", (long)n2);
            this.modelHandler.getChoiceSidebar().setValue(n2);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.log.log(-2137614336, "BrowserHMIListener#VirtualButton-decrement()");
        if (this.browserHandler == null) {
            this.log.log(10000, "ERR: BrowserHMIListener#decrement %1 %2: no DSI", (long)n, (long)n2);
            return;
        }
        if (this.cbHandler != null) {
            this.log.log(-2137614336, "BrowserHMIListener#decrement forwarding event to delegate");
            if (this.cbHandler.scrollUp(n2)) {
                this.log.log(-2137614336, "BrowserHMIListener#decrement handled by callbackListener: %1", (Object)super.getClass());
                return;
            }
        }
        this.log.log(-2137614336, "BrowserHMIListener#decrement %1 %2", (long)n, (long)n2);
        if (n == this.modelHandler.getZoomerID()) {
            this.log.log(1078071040, "BrowserHMIListener#decrement: incremental zoom -10");
            this.browserHandler.zoom(-10, true);
        } else if (this.framework.isPorsche()) {
            this.logDSI.log(-2137614336, "BrowserHMIListener#decrement nextFocus(): steps=%1", (long)n2);
            this.browserHandler.nextFocus(n2);
        } else {
            this.logDSI.log(-2137614336, "BrowserHMIListener#decrement prevFocus(): steps=%1", (long)n2);
            this.browserHandler.prevFocus(n2);
        }
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.log.log(-2137614336, "BrowserHMIListener#VirtualButton-increment()");
        if (this.browserHandler == null) {
            this.logDSI.log(10000, "ERR: BrowserHMIListener#increment %1 %2: no DSI", (long)n, (long)n2);
            return;
        }
        if (this.cbHandler != null) {
            this.log.log(-2137614336, "BrowserHMIListener#increment forwarding event to delegate");
            if (this.cbHandler.scrollDown(n2)) {
                return;
            }
        }
        this.log.log(-2137614336, "BrowserHMIListener#increment %1 %2", (long)n, (long)n2);
        if (n == this.modelHandler.getZoomerID()) {
            this.logDSI.log(1078071040, "BrowserHMIListener#increment: incremental zoom +10");
            this.browserHandler.zoom(10, true);
        } else if (this.framework.isPorsche()) {
            this.logDSI.log(-2137614336, "BrowserHMIListener#decrement prevFocus(): steps=%1", (long)n2);
            this.browserHandler.prevFocus(n2);
        } else {
            this.logDSI.log(-2137614336, "BrowserHMIListener#decrement nextFocus(): steps=%1", (long)n2);
            this.browserHandler.nextFocus(n2);
        }
    }

    public void moveNW(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{17, 19}, "moveNW");
    }

    public void moveN(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{17}, "moveN");
    }

    public void moveNE(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{17, 20}, "moveNE");
    }

    public void moveE(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{20}, "moveE");
    }

    public void moveSE(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{18, 20}, "moveSE");
    }

    public void moveS(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{18}, "moveS");
    }

    public void moveSW(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{18, 19}, "moveS");
    }

    public void moveW(int n, int n2, int n3) {
        this.moveHelper(n, n2, new int[]{19}, "moveW");
    }

    public void moveMiddle(int n, int n2) {
        if (this.browserHandler == null) {
            this.logDSI.log(10000, "ERR: DefaultBrowserHandler.moveMiddle %1: no DSI", (long)n);
            return;
        }
        this.log.log(-2137614336, "BrowserHMIListener#moveMiddle %1", (long)n);
        this.logDSI.log(1078071040, "BrowserHMIListener#moveMiddle dsiBrowser.scroll(): MIDDLE");
        this.browserHandler.scroll(12, 1);
    }

    private void moveHelper(int n, int n2, int[] nArray, String string) {
        if (this.browserHandler == null) {
            this.logDSI.log(10000, "ERR: BrowserHMIListener#moveHelper .%1: %1 %2: no DSI", (Object)string, (long)n, (long)n2);
            return;
        }
        this.logDSI.log(1078071040, "DefaultBrowserHandler: dsiBrowser.scroll(): Stopping scrolling");
        this.browserHandler.scroll(12, n2 * 15);
        this.log.log(-2137614336, "BrowserHMIListener#moveHelper .%1 modelID=%2, steps=%3", (Object)string, (long)n, (long)n2);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n3 = nArray[i2];
            this.logDSI.log(1078071040, "BrowserHMIListener#moveHelper dsiBrowser.scroll(): , currentDirection=%1, steps = %2", (long)n3, (long)n2);
            this.browserHandler.scroll(n3, n2 * 15);
        }
    }

    public void setCallbackHandler(IBrowserCallbackHandler iBrowserCallbackHandler) {
        this.cbHandler = iBrowserCallbackHandler;
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public void touchPadReleased(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPressed(int n, int n2, int n3) {
    }

    @Override
    public void stickN(int n, int n2) {
    }

    @Override
    public void stickNW(int n, int n2) {
    }

    @Override
    public void stickW(int n, int n2) {
    }

    @Override
    public void stickSW(int n, int n2) {
    }

    @Override
    public void stickS(int n, int n2) {
    }

    @Override
    public void stickSE(int n, int n2) {
    }

    @Override
    public void stickE(int n, int n2) {
    }

    @Override
    public void stickNE(int n, int n2) {
    }

    @Override
    public void stickIdle(int n, int n2) {
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenMoved");
        if (this.browserHandler != null) {
            this.log.log(-2137614336, "BrowserHMIListener#touchScreenMoved modelID(%1)", (long)n);
            if (n == this.modelHandler.getVirtualButton().getID()) {
                this.log.log(1078071040, "BrowserHMIListener#touchScreenMoved  dsiBrowser.touchScreenMoved()");
                boolean bl = false;
                if (this.cbHandler != null) {
                    this.log.log(1078071040, "BrowserHMIListener#touchScreenMoved relaying to browser callback");
                    bl = this.cbHandler.press();
                }
                if (!bl) {
                    this.logDSI.log(1078071040, "BrowserHMIListener#touchScreenMoved dsiBrowser.followLink()");
                    this.browserHandler.touchScreenMoved(n2, n3, n4, n5);
                }
            }
        }
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenPressed");
        if (this.browserHandler != null) {
            this.log.log(-2137614336, "BrowserHMIListener#touchScreenPressed modelID(%1)", (long)n);
            if (n == this.modelHandler.getVirtualButton().getID()) {
                this.log.log(1078071040, "BrowserHMIListener#touchScreenPressed  dsiBrowser.touchScreenMoved()");
                boolean bl = false;
                if (this.cbHandler != null) {
                    this.log.log(1078071040, "BrowserHMIListener#touchScreenPressed relaying to browser callback");
                    bl = this.cbHandler.press();
                }
                if (!bl) {
                    this.logDSI.log(1078071040, "BrowserHMIListener#touchScreenPressed dsiBrowser.followLink()");
                    this.browserHandler.touchScreenPressed(n2, n3);
                }
            }
        }
    }

    @Override
    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenLongPressed");
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenReleased");
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenDoubleClick");
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenPinch");
    }

    @Override
    public void touchScreenRotate(int n, short s, int n2) {
        this.log.log(-2137614336, "BrowserHMIListener#touchScreenRotate");
    }
}

