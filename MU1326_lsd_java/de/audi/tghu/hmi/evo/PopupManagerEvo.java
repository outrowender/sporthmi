/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.MMIKombiPopupIDMapper;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.PopupManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IPopupManagerEvo;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

public class PopupManagerEvo
extends PopupManager
implements IPopupManagerEvo {
    private final Map popupKeyConsumptionCache = new HashMap();
    private IPopupManager combiSyncPopupManager;

    public PopupManagerEvo(IScreenManager iScreenManager, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        super(iScreenManager, iFrameworkAccess, logChannel);
    }

    public void showPopup(final int n) {
        if (this.showPopupInEntertainmentDrawer(n)) {
            if (this.correctPopupMapping(n)) {
                this.logPopup.log(10000000, "PopupManagerEvo#showPopup showing popup with id: %1 in entertainmentdrawer, posting event", (long)n);
                this.postRunnable(new Runnable(){

                    public void run() {
                        PopupManagerEvo.this.logPopup.log(10000000, "ShowPopupRunnable in entertainmentdrawer for popupID: %1, calling entertainment drawer now) ", (long)n);
                        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = PopupManagerEvo.this.getDrawerFocusManager();
                        if (iDrawerFocusManagerEvo != null && iDrawerFocusManagerEvo.getDrawerState() != 32) {
                            iDrawerFocusManagerEvo.requestDrawerState(32);
                        }
                    }

                    public String toString() {
                        return new StringBuffer().append("ShowPopupRunnable in entertainmentdrawer(terminal: ").append(PopupManagerEvo.this.getTerminalContext().getTerminalID()).append(" popupId: ").append(n).append(")").toString();
                    }
                });
            }
        } else {
            super.showPopup(n);
        }
    }

    private boolean isSDSFurtherCommandPopup(int n) {
        return n == 13 || n == 30 || n == 31 || n == 32 || n == 33 || n == 34 || n == 35 || n == 36 || n == 37 || n == 38 || n == 39 || n == 40;
    }

    private boolean correctPopupMapping(int n) {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.getDrawerFocusManager();
        IDrawerControllerEvo iDrawerControllerEvo = (IDrawerControllerEvo)(iDrawerFocusManagerEvo != null && iDrawerFocusManagerEvo.getEntertainmentDrawer() instanceof IDrawerControllerEvo ? iDrawerFocusManagerEvo.getEntertainmentDrawer() : null);
        boolean bl = false;
        int n2 = -1;
        if (iDrawerControllerEvo != null) {
            int n3 = iDrawerControllerEvo.getCurrentAudioSource();
            boolean bl2 = n == 300000 && iDrawerControllerEvo.isPhoneAudioSource(n3);
            boolean bl3 = this.isSDSFurtherCommandPopup(n) && iDrawerControllerEvo.isSDSAudioSource(n3);
            bl = bl2 || bl3;
            n2 = iDrawerControllerEvo.getCurrentAudioSource() / 1000;
        }
        this.logPopup.log(10000000, "correctPopupMapping(popupID %1) contentID %2 ret %3", (long)n, (long)n2, bl);
        return bl;
    }

    private boolean showPopupInEntertainmentDrawer(int n) {
        return (n == 300000 || this.isSDSFurtherCommandPopup(n)) && this.framework.getKombiType() != 4;
    }

    public void removePopup(final int n) {
        if (this.showPopupInEntertainmentDrawer(n)) {
            this.logPopup.log(10000000, "PopupManagerEvo#removePopup removing popup with id: %1 from entertainmentdrawer", (long)n);
            if (this.correctPopupMapping(n)) {
                this.postRunnable(new Runnable(){

                    public void run() {
                        PopupManagerEvo.this.logPopup.log(10000000, "RemovePopupRunnable in entertainmentdrawer for popupID %1, calling entertainment drawer now ", (long)n);
                        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = PopupManagerEvo.this.getDrawerFocusManager();
                        if (iDrawerFocusManagerEvo != null && iDrawerFocusManagerEvo.getDrawerState() == 32) {
                            if (n == 300000) {
                                iDrawerFocusManagerEvo.setDrawerState(16, true);
                            } else {
                                iDrawerFocusManagerEvo.requestDrawerState(16);
                            }
                        }
                    }

                    public String toString() {
                        return new StringBuffer().append("RemovePopupRunnable in entertainmentdrawer(terminal: ").append(PopupManagerEvo.this.getTerminalContext().getTerminalID()).append(" popupId: ").append(n).append(")").toString();
                    }
                });
            }
        } else {
            super.removePopup(n);
        }
    }

    public void setPopupKeyConsuptionStrategy(final IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
        Buffer buffer;
        if (iPopupKeyConsuptionStrategy != null) {
            this.logPopup.log(10000000, "PopupManagerEvo#setPopupKeyConsumptionStrategy(%1) for PopupID='%2'", (Object)iPopupKeyConsuptionStrategy, (long)iPopupKeyConsuptionStrategy.getPopupID());
            int[] nArray = iPopupKeyConsuptionStrategy.getHKPressFilter();
            buffer = new Buffer();
            buffer.append("PopupKeyConsumptionStrategy - HKPressFilter IDs: ");
            if (0 == nArray.length) {
                buffer.append("none");
            } else {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (i2 != 0) {
                        buffer.append(", ");
                    }
                    buffer.append(nArray[i2]);
                }
            }
        } else {
            return;
        }
        this.logPopup.log(10000000, buffer.toString());
        this.popupKeyConsumptionCache.put(new Integer(iPopupKeyConsuptionStrategy.getPopupID()), iPopupKeyConsuptionStrategy);
        this.postRunnable(new Runnable(){

            public void run() {
                IScreenData iScreenData = PopupManagerEvo.this.getPopup(iPopupKeyConsuptionStrategy.getPopupID());
                if (iScreenData == null) {
                    PopupManagerEvo.this.logPopup.log(100000, "setPopupKeyConsumptionStrategy popup for id=%1 is null", (long)iPopupKeyConsuptionStrategy.getPopupID());
                    return;
                }
                Screen screen = iScreenData.getScreen();
                if (screen instanceof IScreenEvo) {
                    PopupManagerEvo.this.logPopup.log(10000000, "setPopupKeyConsuptionStrategy(%1) ", (Object)iPopupKeyConsuptionStrategy);
                    ((IScreenEvo)screen).setPopupKeyConsuptionStrategy(iPopupKeyConsuptionStrategy);
                } else {
                    PopupManagerEvo.this.logPopup.log(10000, "setPopupKeyConsuptionStrategy(%1) is not IScreenEvo", (Object)iPopupKeyConsuptionStrategy);
                }
            }

            public String toString() {
                return new StringBuffer().append("setPopupKeyConsuptionStrategy: ").append(iPopupKeyConsuptionStrategy).toString();
            }
        });
    }

    protected void inspectCachedPopupConsumtionStrategies(IScreenData iScreenData) {
        this.logPopup.log(10000000, "inspectCachedPopupConsumtionStrategies for PopupID='%1'", (long)iScreenData.getPopupId());
        IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy = (IPopupKeyConsuptionStrategy)this.popupKeyConsumptionCache.remove(new Integer(iScreenData.getPopupId()));
        if (iPopupKeyConsuptionStrategy != null) {
            Screen screen = iScreenData.getScreen();
            if (screen instanceof IScreenEvo) {
                this.logPopup.log(10000000, "setPopupKeyConsumptionStrategy(%1) ", (Object)iPopupKeyConsuptionStrategy);
                ((IScreenEvo)screen).setPopupKeyConsuptionStrategy(iPopupKeyConsuptionStrategy);
            } else {
                this.logPopup.log(10000, "inspectChashedPopupConsumtionStrategies(%1) is not IScreenEvo", (Object)iPopupKeyConsuptionStrategy);
            }
        }
    }

    protected IDrawerFocusManagerEvo getDrawerFocusManager() {
        return ((HMITerminalEvo)this.getTerminalContext().getHmiTerminal()).getDrawerFocusManager();
    }

    public boolean isLogicalPopup(IScreenData iScreenData) {
        return iScreenData != null && iScreenData.getPopupId() == 19;
    }

    public int getHMIInternalPrio(int n, int n2) {
        return this.framework.getSysConstManager().getHMIInternalPopupPrio(n, n2);
    }

    public int getCurrentPopupPriority() {
        if (this.popupAvailable()) {
            int n = MMIKombiPopupIDMapper.getMMIKombiSlotID(this.getCurrentPopupID());
            int n2 = MMIKombiPopupIDMapper.getMMIKombiPrio(this.getCurrentPopupID());
            return this.getHMIInternalPrio(n, n2);
        }
        return -1;
    }

    public boolean isInPopupList(int n) {
        if (this.combiSyncPopupManager != null) {
            return this.combiSyncPopupManager.isInPopupList(n);
        }
        return super.isInPopupList(n);
    }

    public void setCombiSyncPopupManager(IPopupManager iPopupManager) {
        this.combiSyncPopupManager = iPopupManager;
    }

    protected int getPopupPriority(IScreenData iScreenData) {
        int n = MMIKombiPopupIDMapper.getMMIKombiSlotID(iScreenData.getPopupId());
        int n2 = MMIKombiPopupIDMapper.getMMIKombiPrio(iScreenData.getPopupId());
        return this.getHMIInternalPrio(n, n2);
    }
}

