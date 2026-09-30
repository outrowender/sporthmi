/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.IPopupListener;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public abstract class AbstractPopupManager
implements ChoiceListener,
HMIApplication {
    private static final String CLASSNAME = "[AbstractPopupManager]";
    private SwdlEnv swdlEnv;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;
    public static final int MODULE_ID = 17;
    static final boolean[] HMI_POPUP_SINGLE = new boolean[]{true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false};
    static final int[] REMOVE_ON_ABORT = new int[]{3, 4, 5, 7, 12, 13, 14, 15, 16, 22};
    static final int HMI_POPUP_BUTTONS_OFFSET_ABORT_DEVICE = 0;
    static final int HMI_POPUP_BUTTONS_OFFSET_ABORT_COMPLETLY = 1;
    static final int HMI_POPUP_BUTTONS_OFFSET_RETRY = 2;
    static final int HMI_POPUP_BUTTONS_OFFSET_CANCEL = 3;
    static final int HMI_POPUP_BUTTONS_OFFSET_CONTINUE = 4;
    static final int HMI_POPUP_BUTTONS_OFFSET_OK = 5;
    static final int HMI_POPUP_BUTTONS_OFFSET_SELECT = 6;
    static final int[][] HMI_POPUP_BUTTONS = new int[][]{{0, 0, 0, 4, 0, 0, 0}, {1, 2, 0, 0, 5, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {4, 2, 3, 0, 0, 0, 0}, {4, 2, 3, 0, 0, 0, 0}, {0, 2, 3, 0, 5, 0, 0}, {0, 0, 0, 0, 0, 6, 0}, {0, 2, 0, 0, 3, 0, 0}, {0, 0, 0, 4, 0, 0, 0}, {0, 2, 0, 0, 0, 0, 0}, {0, 0, 3, 4, 0, 0, 0}, {0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 4, 0, 0, 6}, {0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 4, 6, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}};
    static final int[] HMI_SELECT_DEFAULT_BUTTON = new int[]{0, 2, 1, 1, 1, 1, 5, 2, 0, 4, 1, 4, 6, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1};
    static final int[] HMI_POPUP_DEFAULT_REPLY = new int[]{4, 5, 3, 3, 3, 3, 6, 3, 4, 2, 3, 2, 6, 4, 4, 4, 6, 3, 3, 3, 3, 2, 3};
    private List popupStack;
    int expectHide = 0;
    SwdlDSIHandlerProgress progressDSIHandler;
    boolean allowPopups = true;
    private int currentRSUPopup = 0;
    private List popupListeners;
    static /* synthetic */ Class class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;

    public AbstractPopupManager(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        this.swdlEnv = swdlEnv;
        this.swdlJoinedDownloadState = abstractSwdlJoinedDownloadState;
        this.progressDSIHandler = swdlDSIHandlerProgress;
        this.popupStack = new ArrayList(10);
        this.popupListeners = new ArrayList(1);
        this.getSwdlModels().getPopupActionChoice().setChoiceListener(this);
        this.enablePopups();
    }

    private final AbstractSwdlJoinedDownloadState getSwdlJoinedDownloadState() {
        return this.swdlJoinedDownloadState;
    }

    private final LogChannel getLogHMI() {
        return this.getSwdlEnv().getLogHMI();
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    protected final IHMIServiceApp getHMIService() {
        return this.getSwdlEnv().getHMIService();
    }

    private final void enablePopups() {
        this.getLogHMI().log(1000000, "%1 enablePopups() ", (Object)CLASSNAME);
        this.allowPopups = true;
    }

    public void disablePopups() {
        this.getLogHMI().log(1000000, "%1 disablePopups() ", (Object)CLASSNAME);
        this.allowPopups = false;
    }

    synchronized SwdlPopup lookup(int n, String string) {
        SwdlPopup swdlPopup = null;
        Iterator iterator = this.popupStack.iterator();
        while (iterator.hasNext()) {
            SwdlPopup swdlPopup2 = (SwdlPopup)iterator.next();
            if (swdlPopup2.popUpType != n || !swdlPopup2.id.equals(string)) continue;
            swdlPopup = swdlPopup2;
            break;
        }
        return swdlPopup;
    }

    synchronized SwdlPopup lookup(int n) {
        SwdlPopup swdlPopup = null;
        Iterator iterator = this.popupStack.iterator();
        while (iterator.hasNext()) {
            SwdlPopup swdlPopup2 = (SwdlPopup)iterator.next();
            if (swdlPopup2.popUpType != n) continue;
            swdlPopup = swdlPopup2;
            break;
        }
        return swdlPopup;
    }

    synchronized SwdlPopup top() {
        SwdlPopup swdlPopup = null;
        if (!this.popupStack.isEmpty()) {
            swdlPopup = (SwdlPopup)this.popupStack.get(0);
        }
        return swdlPopup;
    }

    void insert(SwdlPopup swdlPopup) {
        int n;
        for (n = 0; n < this.popupStack.size() && ((SwdlPopup)this.popupStack.get((int)n)).prio >= swdlPopup.prio; ++n) {
        }
        this.popupStack.add(n, swdlPopup);
    }

    void remove(SwdlPopup swdlPopup) {
        if (swdlPopup != null) {
            this.popupStack.remove(swdlPopup);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void completeAbort() {
        Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
        synchronized (clazz) {
            SwdlPopup swdlPopup = this.top();
            for (int i2 = 0; i2 < REMOVE_ON_ABORT.length; ++i2) {
                int n = REMOVE_ON_ABORT[i2];
                SwdlPopup swdlPopup2 = this.lookup(n);
                while (swdlPopup2 != null) {
                    this.remove(swdlPopup2);
                    swdlPopup2 = this.lookup(n);
                }
            }
            this.updatePopUp(swdlPopup);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAllPopups() {
        Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
        synchronized (clazz) {
            SwdlPopup swdlPopup = this.top();
            this.popupStack.clear();
            this.updatePopUp(swdlPopup);
        }
    }

    void updatePopUp(SwdlPopup swdlPopup) {
        this.getLogHMI().log(10000000, "%1 stack depth = %2 ", (Object)CLASSNAME, (long)this.popupStack.size());
        if (swdlPopup != this.top()) {
            this.getLogHMI().log(10000000, "%1 start popup change ", (Object)CLASSNAME);
            if (swdlPopup != null) {
                swdlPopup.hide();
                ++this.expectHide;
                this.getLogHMI().log(10000000, "%1 expect popupHidden() calls: %2 ", (Object)CLASSNAME, (long)this.expectHide);
            }
            if (this.top() != null) {
                this.top().show();
            }
            this.getLogHMI().log(10000000, "%1 finish popup change ", (Object)CLASSNAME);
        }
    }

    private String getPopupTemplateText(int n) {
        return this.getSwdlEnv().getTextFactory().getPopupTemplateText(n);
    }

    String getFileErrorText(int n) {
        return this.getSwdlEnv().getTextFactory().getFileErrorText(n);
    }

    public void addPopupListener(IPopupListener iPopupListener) {
        if (iPopupListener != null && !this.popupListeners.contains(iPopupListener)) {
            this.popupListeners.add(iPopupListener);
        }
    }

    public void removePopupListener(IPopupListener iPopupListener) {
        if (iPopupListener != null) {
            this.popupListeners.remove(iPopupListener);
        }
    }

    private final SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    public int getCurrentRSUPopup() {
        return this.currentRSUPopup;
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogHMI().log(1000000, "%1 Item Selected: %2 %3", (Object)CLASSNAME, (long)n, (long)n2);
        SwdlPopup swdlPopup = this.top();
        if (n != this.getSwdlModels().getPopupActionChoice().getID()) {
            this.getLogHMI().log(10000000, "%1 ignore itemSelected( %2, %3 ) Event!", (Object)CLASSNAME, (long)n, (long)n2);
        } else if (swdlPopup != null) {
            boolean bl = true;
            switch (n2) {
                case 0: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Cancel");
                    if (swdlPopup.popUpType == 12) {
                        this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(3));
                        swdlPopup.doHide();
                        this.indicatePopUp(15, "", (byte)20, 0, 0, "");
                        bl = false;
                        break;
                    }
                    this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(3));
                    break;
                }
                case 1: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Retry");
                    this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(2));
                    break;
                }
                case 2: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Continue");
                    this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(4));
                    break;
                }
                case 3: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Abort Device");
                    this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(0));
                    break;
                }
                case 4: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Abort completely");
                    this.getLogHMI().log(1000000, "%1 Trigger Aborting Download Screen! currentTop = %2 currentRSU = %3", (Object)CLASSNAME, (long)swdlPopup.popUpType, (long)this.getCurrentRSUPopup());
                    this.getSwdlModels().getInterruptCountdownLabel().setText("\n.");
                    this.fireSMEventTriggerDownloadAborting(this.getSwdlEnv().getTerminalId());
                    this.completeAbort();
                    this.disablePopups();
                    if (swdlPopup.popUpType == 1 && this.getCurrentRSUPopup() > 0) {
                        this.getLogHMI().log(1000000, "%1 Cancel currentRSU popup %2", (Object)CLASSNAME, (long)this.getCurrentRSUPopup());
                        this.progressDSIHandler.doHandleUserSelection(this.getCurrentRSUPopup(), swdlPopup.id, 4);
                        break;
                    }
                    this.getLogHMI().log(1000000, "%1 Handle User interrupt: responseCode=%2", (Object)CLASSNAME, (long)swdlPopup.getResponseCode(1));
                    this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(1));
                    break;
                }
                case 5: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Ok");
                    this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, swdlPopup.getResponseCode(5));
                    break;
                }
                case 6: {
                    this.getLogHMI().log(1000000, "SwdlPopup: Select Medium");
                    if (swdlPopup.popUpType == 12) {
                        this.getLogHMI().log(10000000, "%1 switch to media selection!", (Object)CLASSNAME);
                        this.getSwdlModels().getPopupActionChoice().fireEvent(this.getSwdlEnv().getTerminalId());
                    }
                    bl = false;
                    break;
                }
                default: {
                    this.getLogHMI().log(10000000, "%1 ignore itemSelected( %2, %3 ) Event!", (Object)CLASSNAME, (long)n, (long)n2);
                    bl = false;
                }
            }
            if (bl) {
                swdlPopup.doHide();
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void handleHKReturn() {
        this.getLogHMI().log(1000000, "%1 handleHKReturn() ", (Object)CLASSNAME);
        SwdlPopup swdlPopup = this.top();
        if (swdlPopup != null) {
            if (swdlPopup.popUpType == 12) {
                this.getLogHMI().log(10000000, "%1 switch to media selection!", (Object)CLASSNAME);
                this.getSwdlModels().getPopupActionChoice().fireEvent(this.getSwdlEnv().getTerminalId());
            } else {
                this.progressDSIHandler.doHandleUserSelection(swdlPopup.popUpType, swdlPopup.id, HMI_POPUP_DEFAULT_REPLY[swdlPopup.popUpType]);
                swdlPopup.doHide();
            }
        }
    }

    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        this.getLogHMI().log(1000000, "%1 indicatePopUp: id: %2 popUp: %3 prio: %4 ", (Object)CLASSNAME, (Object)string, (Object)new Integer(n), (long)by);
        this.getLogHMI().log(1000000, "%1 indicatePopUp: Error Info: %3 %4 %2 ", (Object)CLASSNAME, (Object)string2, (Object)new Integer(n2), (long)n3);
        String string3 = string2;
        if (this.getSwdlEnv().isFrontMU()) {
            if (n == 15 || n == 12) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: popUp: %2 only shown at RSU", (Object)CLASSNAME, (long)n);
                return;
            }
            if (n == 16 || n == 14 || n == 13) {
                this.getSwdlJoinedDownloadState().setJoinedDownload(true);
                this.getLogHMI().log(1000000, "%1 indicatePopUp: popUp: %2, mark as currentRSUPopup", (Object)CLASSNAME, (long)n);
                this.currentRSUPopup = n;
            }
        } else {
            if (n == 16 || n == 14 || n == 13) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: popUp: %2 only shown at front MU", (Object)CLASSNAME, (long)n);
                return;
            }
            if (n == 15 || n == 12) {
                this.getSwdlJoinedDownloadState().setJoinedDownload(true);
                this.getLogHMI().log(1000000, "%1 indicatePopUp: popUp: %2, mark as currentRSUPopup", (Object)CLASSNAME, (long)n);
                this.currentRSUPopup = n;
            }
        }
        if (n == 8 || n == 5) {
            Buffer buffer = new Buffer();
            StringTokenizer stringTokenizer = new StringTokenizer(string2, "&");
            String string4 = "";
            while (stringTokenizer.hasMoreTokens()) {
                buffer.append(string4);
                buffer.append(stringTokenizer.nextToken());
                string4 = ", ";
            }
            string3 = buffer.toString();
        } else if (n == 7) {
            string3 = new Buffer("\n").append(string).append("  ").append(n2).append('/').append(string2).toString();
        } else if (n == 2) {
            Buffer buffer = new Buffer(this.getFileErrorText(n2));
            if (null != string2 && string2.trim().length() > 0) {
                buffer.append("\n").append(string2.trim());
            }
            string3 = buffer.toString();
        }
        if (n == 0 || n < 0 || n > 22) {
            this.getLogHMI().log(100000, "%1 indicatePopUp: unknown popUp: %2 ", (Object)CLASSNAME, (long)n);
        } else {
            if (n == 8) {
                if (this.allowPopups) {
                    new SwdlPopup(n, string, by, n2, n3, string3).doShow();
                } else {
                    this.getLogHMI().log(100000, "%1 indicatePopUp: display of popups is not allowed! ", (Object)CLASSNAME);
                }
                this.indicateDismissPopUp(1, "");
                return;
            }
            if (n == 12) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: RSU: Request Medium for RSU download. Default Medium: %2", (Object)CLASSNAME, (long)n2);
                this.setDefaultMedium(n2);
                this.indicateDismissPopUp(15, "");
            } else if (n == 13) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: MU: Request Medium for RSU download.", (Object)CLASSNAME);
            } else if (n == 14) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: MU: RSU is updating", (Object)CLASSNAME);
            } else if (n == 15) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: RSU: MU is updating", (Object)CLASSNAME);
                this.indicateDismissPopUp(8, "");
            } else if (n == 16) {
                this.getLogHMI().log(1000000, "%1 indicatePopUp: Request Medium for Front MU download. Default Medium: %2", (Object)CLASSNAME, (long)n2);
                this.setDefaultMedium(n2);
            }
        }
        if (this.allowPopups) {
            this.getLogHMI().log(10000000, "%1 indicatePopUp: SwdlPopup(popUp=%2, id=%3, errorCode=%4) ", (Object)CLASSNAME, (Object)new Integer(n), (Object)string, (Object)new Integer(n2));
            new SwdlPopup(n, string, by, n2, n3, string3).doShow();
        } else {
            this.getLogHMI().log(100000, "%1 indicatePopUp: display of popups is not allowed! ", (Object)CLASSNAME);
        }
    }

    private void setDefaultMedium(int n) {
        if (this.getSwdlJoinedDownloadState().isJoinedDownload()) {
            this.getSwdlEnv().getLogMain().log(10000, "implement RSE Code!");
        }
    }

    public void indicateDismissPopUp(int n, String string) {
        this.getLogHMI().log(1000000, "%1 indicateDismissPopUp: popUp: %3 id: %2 ", (Object)CLASSNAME, (Object)string, (long)n);
        SwdlPopup swdlPopup = this.lookup(n, string);
        if (swdlPopup != null) {
            swdlPopup.doHide();
        }
        if (this.currentRSUPopup == n) {
            this.currentRSUPopup = 0;
            this.getLogHMI().log(1000000, "%1 indicateDismissPopUp: popUp: %2, remove currentRSUPopup", (Object)CLASSNAME, (long)n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void indicateDismissAllPopUps(int n) {
        this.getLogHMI().log(1000000, "%1 indicateDismissAllPopUps: popUp: %2 ", (Object)CLASSNAME, (long)n);
        Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
        synchronized (clazz) {
            SwdlPopup swdlPopup = this.top();
            SwdlPopup swdlPopup2 = this.lookup(n);
            while (swdlPopup2 != null) {
                this.remove(swdlPopup2);
                swdlPopup2 = this.lookup(n);
            }
            this.updatePopUp(swdlPopup);
        }
        if (this.currentRSUPopup == n) {
            this.currentRSUPopup = 0;
            this.getLogHMI().log(1000000, "%1 indicateDismissAllPopUps: popUp: %2, remove currentRSUPopup", (Object)CLASSNAME, (long)n);
        }
    }

    public void popupHidden(int n) {
        Object object;
        this.getLogHMI().log(1000000, "%1 popupHidden( %2 ) ", (Object)CLASSNAME, (long)n);
        if (this.popupListeners.size() > 0) {
            object = this.popupListeners.iterator();
            while (object.hasNext()) {
                ((IPopupListener)object.next()).popupHidden(n);
            }
        }
        if (n != this.getSwdlPopupID()) {
            return;
        }
        this.getLogHMI().log(10000000, "%1: expect popupHidden() calls: %2 ", (Object)CLASSNAME, (long)this.expectHide);
        if (this.expectHide > 0) {
            --this.expectHide;
        } else {
            this.getLogHMI().log(100000, "%1 popupHidden() unexpected hiding of popup! ", (Object)CLASSNAME);
            object = this.top();
            if (object != null) {
                this.progressDSIHandler.doHandleUserSelection(((SwdlPopup)object).popUpType, ((SwdlPopup)object).id, HMI_POPUP_DEFAULT_REPLY[((SwdlPopup)object).popUpType]);
                this.remove((SwdlPopup)object);
                this.updatePopUp(null);
            }
        }
    }

    public void popupRemoved(int n) {
        Object object;
        if (this.getSwdlPopupID() == n && (object = this.top()) != null) {
            ((SwdlPopup)object).show();
        }
        if (this.popupListeners.size() > 0) {
            object = this.popupListeners.iterator();
            while (object.hasNext()) {
                ((IPopupListener)object.next()).popupRemoved(n);
            }
        }
    }

    public void popupVisible(int n) {
        if (this.popupListeners.size() > 0) {
            Iterator iterator = this.popupListeners.iterator();
            while (iterator.hasNext()) {
                ((IPopupListener)iterator.next()).popupVisible(n);
            }
        }
    }

    protected abstract void fireSMEventTriggerDownloadAborting(int var1);

    protected abstract int getSwdlPopupID();

    protected abstract void showSwdlPopup(int var1);

    protected abstract void hideSwdlPopup(int var1);

    public int getId() {
        return 17;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void popupHidden(int n, int n2) {
        this.popupHidden(n);
    }

    public void popupRemoved(int n, int n2) {
        this.popupRemoved(n);
    }

    public void popupVisible(int n, int n2) {
        this.popupVisible(n);
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenVisible(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    class SwdlPopup {
        int popUpType;
        String id;
        byte prio;
        int errorCode;
        int errorCodeDetail;
        String info;
        int hmiPopUpId;

        SwdlPopup(int n, String string, byte by, int n2, int n3, String string2) {
            this.popUpType = n;
            this.id = string;
            this.prio = by;
            this.errorCode = n2;
            this.errorCodeDetail = n3;
            this.info = string2;
            this.hmiPopUpId = AbstractPopupManager.this.getSwdlPopupID();
        }

        boolean isSingle() {
            return HMI_POPUP_SINGLE[this.popUpType];
        }

        void replace(SwdlPopup swdlPopup) {
            this.errorCode = swdlPopup.errorCode;
            this.errorCodeDetail = swdlPopup.errorCodeDetail;
            this.info = swdlPopup.info;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void doShow() {
            if (this.hmiPopUpId != 0) {
                Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
                synchronized (clazz) {
                    SwdlPopup swdlPopup = AbstractPopupManager.this.top();
                    SwdlPopup swdlPopup2 = null;
                    swdlPopup2 = this.isSingle() ? AbstractPopupManager.this.lookup(this.popUpType) : AbstractPopupManager.this.lookup(this.popUpType, this.id);
                    if (swdlPopup2 == null) {
                        AbstractPopupManager.this.insert(this);
                        AbstractPopupManager.this.updatePopUp(swdlPopup);
                    } else if (this.prio != swdlPopup2.prio) {
                        AbstractPopupManager.this.remove(swdlPopup2);
                        AbstractPopupManager.this.insert(this);
                        AbstractPopupManager.this.updatePopUp(swdlPopup);
                    } else {
                        swdlPopup2.replace(this);
                        if (swdlPopup2.equals(swdlPopup)) {
                            swdlPopup.update();
                        }
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void doHide() {
            if (this.hmiPopUpId != 0) {
                Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
                synchronized (clazz) {
                    SwdlPopup swdlPopup = AbstractPopupManager.this.top();
                    AbstractPopupManager.this.remove(this);
                    AbstractPopupManager.this.updatePopUp(swdlPopup);
                }
            }
        }

        private void setSubTitle() {
            String string = AbstractPopupManager.this.getSwdlEnv().getTextFactory().getSubTitleText(this.popUpType);
            AbstractPopupManager.this.getSwdlModels().getPopupSubtitle().setText(string);
        }

        private void setPopupText() {
            String[] stringArray;
            if (this.popUpType == 16) {
                stringArray = new String[]{Integer.toString(this.errorCode), this.info, Integer.toString(this.errorCode), Integer.toString(this.errorCodeDetail)};
            } else if (this.popUpType == 22) {
                StringTokenizer stringTokenizer = new StringTokenizer(this.info, "&");
                if (stringTokenizer.countTokens() == 2) {
                    stringArray = new String[]{"-", stringTokenizer.nextToken(), stringTokenizer.nextToken()};
                } else {
                    stringArray = new String[stringTokenizer.countTokens()];
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        stringArray[i2] = stringTokenizer.nextToken();
                    }
                    if (stringArray.length > 2) {
                        String string = stringArray[0];
                        stringArray[0] = stringArray[1];
                        stringArray[1] = string;
                    }
                }
            } else {
                stringArray = new String[]{this.id, this.info, Integer.toString(this.errorCode), Integer.toString(this.errorCodeDetail)};
            }
            AbstractPopupManager.this.getSwdlModels().getPopupTextLabel().setText(StringUtilities.formatMessage(AbstractPopupManager.this.getPopupTemplateText(this.popUpType), stringArray));
        }

        private void enableButtons() {
            AbstractPopupManager.this.getSwdlModels().getPopupActionChoice().setValue(HMI_SELECT_DEFAULT_BUTTON[this.popUpType]);
            AbstractPopupManager.this.getHMIService().getMenuModel(1700352).setFocusedItem(HMI_SELECT_DEFAULT_BUTTON[this.popUpType], FocusAdvice.KEEP_POSITION, -1L);
            AbstractPopupManager.this.getSwdlModels().getPopupSkipDeviceChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][0] > 0 ? 1 : 0);
            AbstractPopupManager.this.getSwdlModels().getPopupInterruptChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][1] > 0 ? 1 : 0);
            AbstractPopupManager.this.getSwdlModels().getPopupRetryChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][2] > 0 ? 1 : 0);
            AbstractPopupManager.this.getSwdlModels().getPopupCancelChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][3] > 0 ? 1 : 0);
            AbstractPopupManager.this.getSwdlModels().getPopupContinueChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][4] > 0 ? 1 : 0);
            AbstractPopupManager.this.getSwdlModels().getPopupOkChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][5] > 0 ? 1 : 0);
            AbstractPopupManager.this.getSwdlModels().getPopupSelectChoice().setValue(HMI_POPUP_BUTTONS[this.popUpType][6] > 0 ? 1 : 0);
        }

        private int getResponseCode(int n) {
            return HMI_POPUP_BUTTONS[this.popUpType][n];
        }

        void update() {
            this.setSubTitle();
            this.setPopupText();
        }

        void show() {
            this.update();
            this.enableButtons();
            AbstractPopupManager.this.showSwdlPopup(AbstractPopupManager.this.getSwdlEnv().getTerminalId());
        }

        void hide() {
            AbstractPopupManager.this.hideSwdlPopup(AbstractPopupManager.this.getSwdlEnv().getTerminalId());
        }
    }
}

