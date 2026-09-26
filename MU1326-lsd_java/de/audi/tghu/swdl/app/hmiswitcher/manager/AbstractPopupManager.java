/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.IPopupListener;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public abstract class AbstractPopupManager
implements ChoiceListener,
HMIApplication {
    private static final String CLASSNAME;
    private SwdlEnv swdlEnv;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;
    public static final int MODULE_ID;
    static final boolean[] HMI_POPUP_SINGLE;
    static final int[] REMOVE_ON_ABORT;
    static final int HMI_POPUP_BUTTONS_OFFSET_ABORT_DEVICE;
    static final int HMI_POPUP_BUTTONS_OFFSET_ABORT_COMPLETLY;
    static final int HMI_POPUP_BUTTONS_OFFSET_RETRY;
    static final int HMI_POPUP_BUTTONS_OFFSET_CANCEL;
    static final int HMI_POPUP_BUTTONS_OFFSET_CONTINUE;
    static final int HMI_POPUP_BUTTONS_OFFSET_OK;
    static final int HMI_POPUP_BUTTONS_OFFSET_SELECT;
    static final int[][] HMI_POPUP_BUTTONS;
    static final int[] HMI_SELECT_DEFAULT_BUTTON;
    static final int[] HMI_POPUP_DEFAULT_REPLY;
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
        this.getLogHMI().log(1078071040, "%1 enablePopups() ", (Object)"[AbstractPopupManager]");
        this.allowPopups = true;
    }

    public void disablePopups() {
        this.getLogHMI().log(1078071040, "%1 disablePopups() ", (Object)"[AbstractPopupManager]");
        this.allowPopups = false;
    }

    synchronized AbstractPopupManager$SwdlPopup lookup(int n, String string) {
        AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = null;
        Iterator iterator = this.popupStack.iterator();
        while (iterator.hasNext()) {
            AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup2 = (AbstractPopupManager$SwdlPopup)iterator.next();
            if (abstractPopupManager$SwdlPopup2.popUpType != n || !abstractPopupManager$SwdlPopup2.id.equals(string)) continue;
            abstractPopupManager$SwdlPopup = abstractPopupManager$SwdlPopup2;
            break;
        }
        return abstractPopupManager$SwdlPopup;
    }

    synchronized AbstractPopupManager$SwdlPopup lookup(int n) {
        AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = null;
        Iterator iterator = this.popupStack.iterator();
        while (iterator.hasNext()) {
            AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup2 = (AbstractPopupManager$SwdlPopup)iterator.next();
            if (abstractPopupManager$SwdlPopup2.popUpType != n) continue;
            abstractPopupManager$SwdlPopup = abstractPopupManager$SwdlPopup2;
            break;
        }
        return abstractPopupManager$SwdlPopup;
    }

    synchronized AbstractPopupManager$SwdlPopup top() {
        AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = null;
        if (!this.popupStack.isEmpty()) {
            abstractPopupManager$SwdlPopup = (AbstractPopupManager$SwdlPopup)this.popupStack.get(0);
        }
        return abstractPopupManager$SwdlPopup;
    }

    void insert(AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup) {
        int n;
        for (n = 0; n < this.popupStack.size() && ((AbstractPopupManager$SwdlPopup)this.popupStack.get((int)n)).prio >= abstractPopupManager$SwdlPopup.prio; ++n) {
        }
        this.popupStack.add(n, abstractPopupManager$SwdlPopup);
    }

    void remove(AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup) {
        if (abstractPopupManager$SwdlPopup != null) {
            this.popupStack.remove(abstractPopupManager$SwdlPopup);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void completeAbort() {
        Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
        synchronized (clazz) {
            AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.top();
            for (int i2 = 0; i2 < REMOVE_ON_ABORT.length; ++i2) {
                int n = REMOVE_ON_ABORT[i2];
                AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup2 = this.lookup(n);
                while (abstractPopupManager$SwdlPopup2 != null) {
                    this.remove(abstractPopupManager$SwdlPopup2);
                    abstractPopupManager$SwdlPopup2 = this.lookup(n);
                }
            }
            this.updatePopUp(abstractPopupManager$SwdlPopup);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAllPopups() {
        Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
        synchronized (clazz) {
            AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.top();
            this.popupStack.clear();
            this.updatePopUp(abstractPopupManager$SwdlPopup);
        }
    }

    void updatePopUp(AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup) {
        this.getLogHMI().log(-2137614336, "%1 stack depth = %2 ", (Object)"[AbstractPopupManager]", (long)this.popupStack.size());
        if (abstractPopupManager$SwdlPopup != this.top()) {
            this.getLogHMI().log(-2137614336, "%1 start popup change ", (Object)"[AbstractPopupManager]");
            if (abstractPopupManager$SwdlPopup != null) {
                abstractPopupManager$SwdlPopup.hide();
                ++this.expectHide;
                this.getLogHMI().log(-2137614336, "%1 expect popupHidden() calls: %2 ", (Object)"[AbstractPopupManager]", (long)this.expectHide);
            }
            if (this.top() != null) {
                this.top().show();
            }
            this.getLogHMI().log(-2137614336, "%1 finish popup change ", (Object)"[AbstractPopupManager]");
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

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogHMI().log(1078071040, "%1 Item Selected: %2 %3", (Object)"[AbstractPopupManager]", (long)n, (long)n2);
        AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.top();
        if (n != this.getSwdlModels().getPopupActionChoice().getID()) {
            this.getLogHMI().log(-2137614336, "%1 ignore itemSelected( %2, %3 ) Event!", (Object)"[AbstractPopupManager]", (long)n, (long)n2);
        } else if (abstractPopupManager$SwdlPopup != null) {
            boolean bl = true;
            switch (n2) {
                case 0: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Cancel");
                    if (abstractPopupManager$SwdlPopup.popUpType == 12) {
                        this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 3));
                        abstractPopupManager$SwdlPopup.doHide();
                        this.indicatePopUp(15, "", (byte)20, 0, 0, "");
                        bl = false;
                        break;
                    }
                    this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 3));
                    break;
                }
                case 1: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Retry");
                    this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 2));
                    break;
                }
                case 2: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Continue");
                    this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 4));
                    break;
                }
                case 3: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Abort Device");
                    this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 0));
                    break;
                }
                case 4: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Abort completely");
                    this.getLogHMI().log(1078071040, "%1 Trigger Aborting Download Screen! currentTop = %2 currentRSU = %3", (Object)"[AbstractPopupManager]", (long)abstractPopupManager$SwdlPopup.popUpType, (long)this.getCurrentRSUPopup());
                    this.getSwdlModels().getInterruptCountdownLabel().setText("\n.");
                    this.fireSMEventTriggerDownloadAborting(this.getSwdlEnv().getTerminalId());
                    this.completeAbort();
                    this.disablePopups();
                    if (abstractPopupManager$SwdlPopup.popUpType == 1 && this.getCurrentRSUPopup() > 0) {
                        this.getLogHMI().log(1078071040, "%1 Cancel currentRSU popup %2", (Object)"[AbstractPopupManager]", (long)this.getCurrentRSUPopup());
                        this.progressDSIHandler.doHandleUserSelection(this.getCurrentRSUPopup(), abstractPopupManager$SwdlPopup.id, 4);
                        break;
                    }
                    this.getLogHMI().log(1078071040, "%1 Handle User interrupt: responseCode=%2", (Object)"[AbstractPopupManager]", (long)AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 1));
                    this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 1));
                    break;
                }
                case 5: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Ok");
                    this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, AbstractPopupManager$SwdlPopup.access$300(abstractPopupManager$SwdlPopup, 5));
                    break;
                }
                case 6: {
                    this.getLogHMI().log(1078071040, "SwdlPopup: Select Medium");
                    if (abstractPopupManager$SwdlPopup.popUpType == 12) {
                        this.getLogHMI().log(-2137614336, "%1 switch to media selection!", (Object)"[AbstractPopupManager]");
                        this.getSwdlModels().getPopupActionChoice().fireEvent(this.getSwdlEnv().getTerminalId());
                    }
                    bl = false;
                    break;
                }
                default: {
                    this.getLogHMI().log(-2137614336, "%1 ignore itemSelected( %2, %3 ) Event!", (Object)"[AbstractPopupManager]", (long)n, (long)n2);
                    bl = false;
                }
            }
            if (bl) {
                abstractPopupManager$SwdlPopup.doHide();
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void handleHKReturn() {
        this.getLogHMI().log(1078071040, "%1 handleHKReturn() ", (Object)"[AbstractPopupManager]");
        AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.top();
        if (abstractPopupManager$SwdlPopup != null) {
            if (abstractPopupManager$SwdlPopup.popUpType == 12) {
                this.getLogHMI().log(-2137614336, "%1 switch to media selection!", (Object)"[AbstractPopupManager]");
                this.getSwdlModels().getPopupActionChoice().fireEvent(this.getSwdlEnv().getTerminalId());
            } else {
                this.progressDSIHandler.doHandleUserSelection(abstractPopupManager$SwdlPopup.popUpType, abstractPopupManager$SwdlPopup.id, HMI_POPUP_DEFAULT_REPLY[abstractPopupManager$SwdlPopup.popUpType]);
                abstractPopupManager$SwdlPopup.doHide();
            }
        }
    }

    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        this.getLogHMI().log(1078071040, "%1 indicatePopUp: id: %2 popUp: %3 prio: %4 ", (Object)"[AbstractPopupManager]", (Object)string, (Object)new Integer(n), (long)by);
        this.getLogHMI().log(1078071040, "%1 indicatePopUp: Error Info: %3 %4 %2 ", (Object)"[AbstractPopupManager]", (Object)string2, (Object)new Integer(n2), (long)n3);
        String string3 = string2;
        if (this.getSwdlEnv().isFrontMU()) {
            if (n == 15 || n == 12) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: popUp: %2 only shown at RSU", (Object)"[AbstractPopupManager]", (long)n);
                return;
            }
            if (n == 16 || n == 14 || n == 13) {
                this.getSwdlJoinedDownloadState().setJoinedDownload(true);
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: popUp: %2, mark as currentRSUPopup", (Object)"[AbstractPopupManager]", (long)n);
                this.currentRSUPopup = n;
            }
        } else {
            if (n == 16 || n == 14 || n == 13) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: popUp: %2 only shown at front MU", (Object)"[AbstractPopupManager]", (long)n);
                return;
            }
            if (n == 15 || n == 12) {
                this.getSwdlJoinedDownloadState().setJoinedDownload(true);
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: popUp: %2, mark as currentRSUPopup", (Object)"[AbstractPopupManager]", (long)n);
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
            this.getLogHMI().log(-1601830656, "%1 indicatePopUp: unknown popUp: %2 ", (Object)"[AbstractPopupManager]", (long)n);
        } else {
            if (n == 8) {
                if (this.allowPopups) {
                    new AbstractPopupManager$SwdlPopup(this, n, string, by, n2, n3, string3).doShow();
                } else {
                    this.getLogHMI().log(-1601830656, "%1 indicatePopUp: display of popups is not allowed! ", (Object)"[AbstractPopupManager]");
                }
                this.indicateDismissPopUp(1, "");
                return;
            }
            if (n == 12) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: RSU: Request Medium for RSU download. Default Medium: %2", (Object)"[AbstractPopupManager]", (long)n2);
                this.setDefaultMedium(n2);
                this.indicateDismissPopUp(15, "");
            } else if (n == 13) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: MU: Request Medium for RSU download.", (Object)"[AbstractPopupManager]");
            } else if (n == 14) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: MU: RSU is updating", (Object)"[AbstractPopupManager]");
            } else if (n == 15) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: RSU: MU is updating", (Object)"[AbstractPopupManager]");
                this.indicateDismissPopUp(8, "");
            } else if (n == 16) {
                this.getLogHMI().log(1078071040, "%1 indicatePopUp: Request Medium for Front MU download. Default Medium: %2", (Object)"[AbstractPopupManager]", (long)n2);
                this.setDefaultMedium(n2);
            }
        }
        if (this.allowPopups) {
            this.getLogHMI().log(-2137614336, "%1 indicatePopUp: SwdlPopup(popUp=%2, id=%3, errorCode=%4) ", (Object)"[AbstractPopupManager]", (Object)new Integer(n), (Object)string, (Object)new Integer(n2));
            new AbstractPopupManager$SwdlPopup(this, n, string, by, n2, n3, string3).doShow();
        } else {
            this.getLogHMI().log(-1601830656, "%1 indicatePopUp: display of popups is not allowed! ", (Object)"[AbstractPopupManager]");
        }
    }

    private void setDefaultMedium(int n) {
        if (this.getSwdlJoinedDownloadState().isJoinedDownload()) {
            this.getSwdlEnv().getLogMain().log(10000, "implement RSE Code!");
        }
    }

    public void indicateDismissPopUp(int n, String string) {
        this.getLogHMI().log(1078071040, "%1 indicateDismissPopUp: popUp: %3 id: %2 ", (Object)"[AbstractPopupManager]", (Object)string, (long)n);
        AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.lookup(n, string);
        if (abstractPopupManager$SwdlPopup != null) {
            abstractPopupManager$SwdlPopup.doHide();
        }
        if (this.currentRSUPopup == n) {
            this.currentRSUPopup = 0;
            this.getLogHMI().log(1078071040, "%1 indicateDismissPopUp: popUp: %2, remove currentRSUPopup", (Object)"[AbstractPopupManager]", (long)n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void indicateDismissAllPopUps(int n) {
        this.getLogHMI().log(1078071040, "%1 indicateDismissAllPopUps: popUp: %2 ", (Object)"[AbstractPopupManager]", (long)n);
        Class clazz = class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
        synchronized (clazz) {
            AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.top();
            AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup2 = this.lookup(n);
            while (abstractPopupManager$SwdlPopup2 != null) {
                this.remove(abstractPopupManager$SwdlPopup2);
                abstractPopupManager$SwdlPopup2 = this.lookup(n);
            }
            this.updatePopUp(abstractPopupManager$SwdlPopup);
        }
        if (this.currentRSUPopup == n) {
            this.currentRSUPopup = 0;
            this.getLogHMI().log(1078071040, "%1 indicateDismissAllPopUps: popUp: %2, remove currentRSUPopup", (Object)"[AbstractPopupManager]", (long)n);
        }
    }

    public void popupHidden(int n) {
        Object object;
        this.getLogHMI().log(1078071040, "%1 popupHidden( %2 ) ", (Object)"[AbstractPopupManager]", (long)n);
        if (this.popupListeners.size() > 0) {
            object = this.popupListeners.iterator();
            while (object.hasNext()) {
                ((IPopupListener)object.next()).popupHidden(n);
            }
        }
        if (n != this.getSwdlPopupID()) {
            return;
        }
        this.getLogHMI().log(-2137614336, "%1: expect popupHidden() calls: %2 ", (Object)"[AbstractPopupManager]", (long)this.expectHide);
        if (this.expectHide > 0) {
            --this.expectHide;
        } else {
            this.getLogHMI().log(-1601830656, "%1 popupHidden() unexpected hiding of popup! ", (Object)"[AbstractPopupManager]");
            object = this.top();
            if (object != null) {
                this.progressDSIHandler.doHandleUserSelection(((AbstractPopupManager$SwdlPopup)object).popUpType, ((AbstractPopupManager$SwdlPopup)object).id, HMI_POPUP_DEFAULT_REPLY[((AbstractPopupManager$SwdlPopup)object).popUpType]);
                this.remove((AbstractPopupManager$SwdlPopup)object);
                this.updatePopUp(null);
            }
        }
    }

    public void popupRemoved(int n) {
        Object object;
        if (this.getSwdlPopupID() == n && (object = this.top()) != null) {
            ((AbstractPopupManager$SwdlPopup)object).show();
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

    protected abstract void fireSMEventTriggerDownloadAborting(int n) {
    }

    protected abstract int getSwdlPopupID() {
    }

    protected abstract void showSwdlPopup(int n) {
    }

    protected abstract void hideSwdlPopup(int n) {
    }

    @Override
    public int getId() {
        return 17;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.popupHidden(n);
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.popupRemoved(n);
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.popupVisible(n);
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
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

    static /* synthetic */ SwdlEnv access$000(AbstractPopupManager abstractPopupManager) {
        return abstractPopupManager.getSwdlEnv();
    }

    static /* synthetic */ SwdlModels access$100(AbstractPopupManager abstractPopupManager) {
        return abstractPopupManager.getSwdlModels();
    }

    static /* synthetic */ String access$200(AbstractPopupManager abstractPopupManager, int n) {
        return abstractPopupManager.getPopupTemplateText(n);
    }

    static {
        HMI_POPUP_SINGLE = new boolean[]{true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false};
        REMOVE_ON_ABORT = new int[]{3, 4, 5, 7, 12, 13, 14, 15, 16, 22};
        HMI_POPUP_BUTTONS = new int[][]{{0, 0, 0, 4, 0, 0, 0}, {1, 2, 0, 0, 5, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {4, 2, 3, 0, 0, 0, 0}, {4, 2, 3, 0, 0, 0, 0}, {0, 2, 3, 0, 5, 0, 0}, {0, 0, 0, 0, 0, 6, 0}, {0, 2, 0, 0, 3, 0, 0}, {0, 0, 0, 4, 0, 0, 0}, {0, 2, 0, 0, 0, 0, 0}, {0, 0, 3, 4, 0, 0, 0}, {0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 4, 0, 0, 6}, {0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 4, 6, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}, {0, 2, 3, 4, 0, 0, 0}};
        HMI_SELECT_DEFAULT_BUTTON = new int[]{0, 2, 1, 1, 1, 1, 5, 2, 0, 4, 1, 4, 6, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1};
        HMI_POPUP_DEFAULT_REPLY = new int[]{4, 5, 3, 3, 3, 3, 6, 3, 4, 2, 3, 2, 6, 4, 4, 4, 6, 3, 3, 3, 3, 2, 3};
    }
}

