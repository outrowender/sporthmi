/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import de.audi.tghu.navi.app.map.routecalc.RcsRGActivated;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RcsBetterRouteAvailable
extends RcsRGActivated {
    BlockedPopupFSM blockedPopupFSM = new BlockedPopupFSM();
    BetterRoutePopupFSM betterRoutePopupFSM = new BetterRoutePopupFSM();

    protected RcsBetterRouteAvailable(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsBetterRouteAvailable");
    }

    public void exit() {
        super.exit();
        this.cleanAll();
    }

    public boolean refreshPopupOnUpdate() {
        return true;
    }

    public void enter() {
        this.postUpdateRCCI(this.getStateMachine().getRcciEvent());
    }

    protected void postUpdateRCCI(RcciEvent rcciEvent) {
        try {
            this.getStateMachine().naviMap.getActiveContext().updateRgRouteCostChangeInformation(this.getData().rgRCCI);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - %1", (Throwable)exception);
        }
        long l = rcciEvent.reliable ? rcciEvent.savingTime : -1L;
        this.data.iBetterRouteState = rcciEvent.type;
        switch (rcciEvent.type) {
            case 1: {
                this.goTo(7);
                break;
            }
            case 0: {
                this.getLogger().log(10000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - inconsistent");
                break;
            }
            case 6: {
                this.getLogger().log(100000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - new route is not recommended");
                break;
            }
            case 4: 
            case 9: {
                this.getLogger().log(10000000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - due to blocking, ignored = %1", this.getData().isPopupDueToBlockingIgnored);
                this.refreshBetterRouteIndicator(l, true);
                this.refreshNewRouteEta(rcciEvent.origin.newRoute.etaWithSpeedAndFlow);
                this.blockedPopupFSM.getCurrentState().onShowPrompt();
                break;
            }
            case 3: 
            case 8: {
                this.getLogger().log(10000000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - definitive better, ignored = %1", this.getData().isPopupDefinitiveBetterIgnored);
                this.refreshBetterRouteIndicator(l, true);
                this.refreshNewRouteEta(rcciEvent.origin.newRoute.etaWithSpeedAndFlow);
                this.betterRoutePopupFSM.getCurrentState().onShowPrompt();
                break;
            }
            case 2: 
            case 7: {
                this.refreshBetterRouteIndicator(l, false);
                this.refreshNewRouteEta(rcciEvent.origin.newRoute.etaWithSpeedAndFlow);
                break;
            }
            default: {
                this.getLogger().log(10000000, "RcsBetterRouteAvailable#postUpdateRCCI( %1 ) - unexpected call", (long)rcciEvent.type);
                this.goTo(9);
            }
        }
    }

    protected void refreshBetterRouteIndicator(long l, boolean bl) {
        this.getLogger().log(10000000, "RcsBetterRouteAvailable#refreshBetterRouteIndicator( %1 )", l);
        this.getData().sSavingTimeOfBetterRoute = l;
        if (bl) {
            this.getViews().getSemidynRGView().showShortInfo(l);
            return;
        }
        if (!this.getData().wasOnceVisible) {
            this.getViews().getSemidynRGView().showPopupBetterRouteAvailable(l);
            this.getData().wasOnceVisible = true;
            this.data.shortBetterRouteAvailableInfoTimer.start();
        } else if (this.data.shortBetterRouteAvailableInfoTimer.isRunning() && this.getViews().getSemidynRGView().isBetterRouteIndicatorVisible()) {
            this.getViews().getSemidynRGView().updateSavedTime(l);
        } else {
            this.getViews().getSemidynRGView().showShortInfo(l);
        }
    }

    protected void refreshNewRouteEta(long l) {
    }

    private void cleanAll() {
        this.data.shortBetterRouteAvailableInfoTimer.cancel();
        this.getViews().getSemidynRGView().hidePopupBetterRouteAvailable();
        this.getViews().getSemidynRGView().hidePopupSemidynBlockMain();
        this.getViews().getSemidynRGView().hidePopupSemidynBetterMain();
        this.blockedPopupFSM.getCurrentState().onClearAll();
        this.betterRoutePopupFSM.getCurrentState().onClearAll();
    }

    public void setSelectedRouteIndex(int n) {
        this.getLogger().log(10000000, "RcsBetterRouteAvailable#setSelectedRouteIndex( %1 )", (long)n);
        if (0 <= n && n <= 1) {
            this.getData().iRouteIndex = n;
        } else {
            this.getLogger().log(10000, "RcsBetterRouteAvailable#setSelectedRouteIndex( ) - invalid index");
        }
    }

    private final class BlockedPopupFSM
    extends AbstractPopupFSM {
        private BlockedPopupFSM() {
        }

        protected void showPopup() {
            RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.BlockedPopupFSM#showPopup()");
            RcsBetterRouteAvailable.this.getViews().getSemidynRGView().showPopupSemidynBlockMain();
        }

        protected void hidePopup() {
            RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.BlockedPopupFSM#hidePopup()");
            RcsBetterRouteAvailable.this.getViews().getSemidynRGView().hidePopupSemidynBlockMain();
        }

        protected void afaRepeat() {
            RcsBetterRouteAvailable.this.getStateMachine().naviMap.getNaviInterface().afaRepeat(4);
        }
    }

    private abstract class AbstractPopupFSM {
        static final String POPUP_NOT_VISIBLE = "POPUP_NOT_VISIBLE";
        static final String POPUP_VISIBLE = "POPUP_VISIBLE";
        static final String POPUP_CANCELED = "POPUP_CANCELED";
        private final PopupNotVisibleState popupNotVisibleState = new PopupNotVisibleState("POPUP_NOT_VISIBLE");
        private final PopupVisibleState popupVisibleState = new PopupVisibleState("POPUP_VISIBLE");
        private final PopupCanceledState popupCanceledState = new PopupCanceledState("POPUP_CANCELED");
        private State currentState = this.popupNotVisibleState;

        private AbstractPopupFSM() {
        }

        public State getCurrentState() {
            return this.currentState;
        }

        protected abstract void showPopup();

        protected abstract void hidePopup();

        protected abstract void afaRepeat();

        private void changeState(State state) {
            if (state == this.currentState) {
                return;
            }
            this.currentState.exit();
            this.currentState = state;
            this.currentState.enter();
        }

        private boolean isValidContextToShowPopup() {
            return RcsBetterRouteAvailable.this.getStateMachine().naviMap.getActiveContextIndex() != 20;
        }

        private class State {
            private final String name;

            public State(String string) {
                this.name = string;
            }

            void enter() {
            }

            void exit() {
            }

            void onShowPrompt() {
            }

            void onClearAll() {
            }

            String getName() {
                return this.name;
            }
        }

        private class PopupVisibleState
        extends State {
            public PopupVisibleState(String string) {
                super(string);
            }

            void enter() {
                RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupVisibleState#enter() Show popup and afaRepeat");
                AbstractPopupFSM.this.showPopup();
                AbstractPopupFSM.this.afaRepeat();
            }

            void onShowPrompt() {
                if (RcsBetterRouteAvailable.this.getStateMachine().isBetterRouteIgnored()) {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupVisibleState#onShowPrompt() Better Route Ignored");
                    AbstractPopupFSM.this.changeState(AbstractPopupFSM.this.popupCanceledState);
                } else if (!AbstractPopupFSM.this.isValidContextToShowPopup()) {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupVisibleState#onShowPrompt() Active Context not valid, RCCI Map");
                } else {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupVisibleState#onShowPrompt() Better Route NOT Ignored");
                    if (RcsBetterRouteAvailable.this.refreshPopupOnUpdate()) {
                        AbstractPopupFSM.this.showPopup();
                    }
                }
            }

            void onClearAll() {
                RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupVisibleState#onClearAll()");
                AbstractPopupFSM.this.changeState(AbstractPopupFSM.this.popupNotVisibleState);
            }
        }

        private class PopupCanceledState
        extends State {
            public PopupCanceledState(String string) {
                super(string);
            }

            void enter() {
                RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupCanceledState#enter()");
                AbstractPopupFSM.this.hidePopup();
            }

            void onClearAll() {
                RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupCanceledState#onClearAll()");
                AbstractPopupFSM.this.changeState(AbstractPopupFSM.this.popupNotVisibleState);
            }

            void onShowPrompt() {
                if (!AbstractPopupFSM.this.isValidContextToShowPopup()) {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupCanceledState#onShowPrompt() Active Context not valid, RCCI Map ");
                } else if (!RcsBetterRouteAvailable.this.getStateMachine().isBetterRouteIgnored()) {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupCanceledState#onShowPrompt() Better Route NOT ignored");
                    AbstractPopupFSM.this.changeState(AbstractPopupFSM.this.popupVisibleState);
                } else {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupCanceledState#onShowPrompt() Stay in canceled state");
                }
            }
        }

        private class PopupNotVisibleState
        extends State {
            public PopupNotVisibleState(String string) {
                super(string);
            }

            void enter() {
                RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupNotVisibleState#enter()");
                AbstractPopupFSM.this.hidePopup();
            }

            void onShowPrompt() {
                if (RcsBetterRouteAvailable.this.getStateMachine().isBetterRouteIgnored()) {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupNotVisibleState#onShowPrompt() Better Route ignored");
                    AbstractPopupFSM.this.changeState(AbstractPopupFSM.this.popupCanceledState);
                } else if (!AbstractPopupFSM.this.isValidContextToShowPopup()) {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupNotVisibleState#onShowPrompt() Active Context not avlid, RCCI Map");
                } else {
                    RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupNotVisibleState#onShowPrompt() Better Route NOT ignored");
                    AbstractPopupFSM.this.changeState(AbstractPopupFSM.this.popupVisibleState);
                }
            }

            void onClearAll() {
                RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.PopupNotVisibleState#onClearAll()");
            }
        }
    }

    private final class BetterRoutePopupFSM
    extends AbstractPopupFSM {
        private BetterRoutePopupFSM() {
        }

        protected void showPopup() {
            RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.BetterRoutePopupFSM#showPopup()");
            RcsBetterRouteAvailable.this.getViews().getSemidynRGView().showPopupSemidynBetterMain();
        }

        protected void hidePopup() {
            RcsBetterRouteAvailable.this.getLogger().log(10000000, "RcsBetterRouteAvailable.BetterRoutePopupFSM#hidePopup()");
            RcsBetterRouteAvailable.this.getViews().getSemidynRGView().hidePopupSemidynBetterMain();
        }

        protected void afaRepeat() {
            RcsBetterRouteAvailable.this.getStateMachine().naviMap.getNaviInterface().afaRepeat(5);
        }
    }
}

