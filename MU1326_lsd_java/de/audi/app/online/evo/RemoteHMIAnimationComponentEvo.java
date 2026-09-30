/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.HMIViewWaitingListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIAnimationComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIAnimationComponentEvo
extends RemoteHMIAnimationComponent {
    private String previousContext = "";
    private boolean isPreviousScreenMainType = true;
    private AbstractHMIViewListener previousViewType = null;
    private static final int ANIMATION_EVO_HIERARCHICAL_FORWARDS = 0;
    private static final int ANIMATION_EVO_HIERARCHICAL_BACKWARDS = 2;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
    }

    public void reset() {
        super.reset();
        this.animationModelEnter.setValue(26);
        this.animationModelEnterAdditionalInformation.setValue(0);
        this.animationModelExit.setValue(26);
        this.animationModelExitAdditionalInformation.setValue(0);
        this.previousContext = "";
        this.isPreviousScreenMainType = true;
        this.previousViewType = null;
    }

    public void configureAnimation(String string, AbstractHMIViewListener abstractHMIViewListener, int n, boolean bl) {
        int n2;
        this.logChannel.log(1000000, "RemoteHMIAnimationComponentEvo#configureAnimation: configuring animation for context %1, previous context is %2, override is %3", (Object)string, (Object)this.previousContext, (Object)new Integer(n));
        this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#configureAnimation: viewToUpdate is '%1', previousViewType is '%2'.", (Object)(abstractHMIViewListener != null ? abstractHMIViewListener.getClass().getName() : "null"), (Object)(this.previousViewType != null ? this.previousViewType.getClass().getName() : "null"));
        int n3 = 26;
        int n4 = 0;
        int n5 = 26;
        int n6 = 0;
        int n7 = n2 = this.previousViewType == null ? -1 : this.previousViewType.getLastActionType();
        if (n >= 0) {
            this.handleOverride(string, abstractHMIViewListener, n, n3, n4, n5, n6);
            return;
        }
        if (this.isSameContextAsPreviousScreen(string)) {
            this.handleSameContext(bl, string, abstractHMIViewListener, n2, n3, n4, n5, n6);
            return;
        }
        if (string != null && this.previousContext != null) {
            this.handleDifferentContext(string, abstractHMIViewListener, n3, n4, n5, n6);
            return;
        }
        this.configure(string, abstractHMIViewListener, n3, n4, n5, n6);
    }

    private void handleSameContext(boolean bl, String string, AbstractHMIViewListener abstractHMIViewListener, int n, int n2, int n3, int n4, int n5) {
        boolean bl2 = this.isMainScreenType(abstractHMIViewListener);
        if (bl2 != this.isPreviousScreenMainType) {
            if (bl2) {
                if (n == 104 || n == 10000002) {
                    this.logChannel.log(1000000, "RemoteHMIAnimationComponentEvo#handleSameContext: returning from options screen");
                    n2 = 27;
                    n4 = 27;
                    n3 = 2;
                    n5 = 2;
                } else {
                    this.logChannel.log(1000000, "RemoteHMIAnimationComponentEvo#handleSameContext: returning from options screen via action");
                }
            } else {
                this.logChannel.log(1000000, "RemoteHMIAnimationComponentEvo#handleSameContext: entering options screen");
                n2 = 27;
                n4 = 27;
                n3 = 0;
                n5 = 0;
            }
        } else {
            RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContextManagerComponent().getContext(string);
            if (remoteHMIContext != null) {
                RemoteHMIAction remoteHMIAction = remoteHMIContext.getLastAction();
                if (remoteHMIAction != null && remoteHMIAction.getType() == 104) {
                    this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleSameContext: switching from screen %1 to screen %2 via HK_BACK. Using backward animation.", (Object)this.previousContext, (Object)string);
                    n3 = 2;
                    n5 = 2;
                } else if (this.previousViewType instanceof HMIViewWaitingListener && !string.equals("top_wizard")) {
                    this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleSameContext: switching from waiting screen %1 to screen %2, skipping animation.", (Object)this.previousContext, (Object)string);
                    n2 = 0;
                    n4 = 0;
                } else if (this.previousViewType instanceof HMIViewGridListener && bl) {
                    this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleSameContext: switching from screen %1 to screen %2. Resuming screen, skipping animation.", (Object)this.previousContext, (Object)string);
                    n2 = 0;
                    n4 = 0;
                } else {
                    this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleSameContext: switching from screen %1 to screen %2. Using standard animation.", (Object)this.previousContext, (Object)string);
                }
            } else if (this.previousViewType instanceof HMIViewWaitingListener) {
                n2 = 0;
                n4 = 0;
            }
        }
        this.configure(string, abstractHMIViewListener, n2, n3, n4, n5);
    }

    private void handleDifferentContext(String string, AbstractHMIViewListener abstractHMIViewListener, int n, int n2, int n3, int n4) {
        if (this.previousViewType instanceof HMIViewWaitingListener && abstractHMIViewListener instanceof HMIViewWaitingListener) {
            this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleDifferentContext: switching from waiting screen %1 to waiting screen %2, skipping animation.", (Object)this.previousContext, (Object)string);
            n = 0;
            n3 = 0;
        } else if (string.equals("top_wizard") && !this.previousContext.equals("top_wizard")) {
            this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleDifferentContext: switching from service %1 to %2, using backward animation", (Object)this.previousContext, (Object)string);
            n2 = 2;
            n4 = 2;
        } else if (!string.equals("top_wizard") && this.previousContext.equals("top_wizard")) {
            this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleDifferentContext: switching from %1 to service %2, skipping animation.", (Object)this.previousContext, (Object)string);
            n2 = 0;
            n4 = 0;
        } else {
            this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#handleDifferentContext: switching from service %1 to service %2, using standard animation.", (Object)this.previousContext, (Object)string);
        }
        this.configure(string, abstractHMIViewListener, n, n2, n3, n4);
    }

    private boolean isSameContextAsPreviousScreen(String string) {
        return string != null && this.previousContext != null && string.equals(this.previousContext);
    }

    private void handleOverride(String string, AbstractHMIViewListener abstractHMIViewListener, int n, int n2, int n3, int n4, int n5) {
        if (n == 0) {
            this.logChannel.log(1000000, "RemoteHMIAnimationComponentEvo#handleOverride: override: no animation for %1/%2", (Object)string, (Object)abstractHMIViewListener);
            n2 = 0;
            n4 = 0;
            this.configure(string, abstractHMIViewListener, n2, n3, n4, n5);
            return;
        }
        this.logChannel.log(10000, "RemoteHMIAnimationComponentEvo#handleOverride: override: unknown mode %1 for %2/%3", (Object)new Integer(n), (Object)string, (Object)abstractHMIViewListener);
    }

    private boolean isMainScreenType(AbstractHMIViewListener abstractHMIViewListener) {
        boolean bl;
        if (abstractHMIViewListener instanceof AbstractHMIViewListenerEvo) {
            AbstractHMIViewListenerEvo abstractHMIViewListenerEvo = (AbstractHMIViewListenerEvo)abstractHMIViewListener;
            bl = abstractHMIViewListenerEvo.isScreenTypeMain();
        } else {
            this.logChannel.log(10000, "RemoteHMIAnimationComponentEvo#isMainScreenType: encountered unsupported view: %1", (Object)abstractHMIViewListener);
            bl = true;
        }
        return bl;
    }

    protected void configure(String string, AbstractHMIViewListener abstractHMIViewListener, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "RemoteHMIAnimationComponentEvo#configure: setting animation Models to %1, %2, %3, %4", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3), (Object)new Integer(n4));
        this.animationModelEnter.setValue(n);
        this.animationModelEnterAdditionalInformation.setValue(n2);
        this.animationModelExit.setValue(n3);
        this.animationModelExitAdditionalInformation.setValue(n4);
        this.previousContext = string;
        this.isPreviousScreenMainType = this.isMainScreenType(abstractHMIViewListener);
        this.previousViewType = abstractHMIViewListener;
    }
}

