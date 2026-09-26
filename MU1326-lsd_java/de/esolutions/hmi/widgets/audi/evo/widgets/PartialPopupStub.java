/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.view.HMIView;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupStub;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;

public class PartialPopupStub
extends AbstractPartialPopupController
implements IPartialPopupStub {
    private IPartialPopupControllerEvo skeleton = null;

    public PartialPopupStub(int n) {
        this.setID(n);
    }

    public PartialPopupStub(int n, int n2, int n3, int n4, int n5, int n6, boolean bl, int n7, int n8, int n9, int[] nArray) {
        this(n);
        this.setModelID(n2);
        this.setType(n7);
        this.setPriority(n3);
        this.setZpmPriority(n4);
        this.setZpmSlot(n6);
        this.setPopupActive(bl);
        this.setSlot(n5);
        this.setStyle(n9);
        this.setInvisibleChoiceValues(nArray);
    }

    public PartialPopupStub(int n, int n2, int n3, int n4, int n5, int n6, boolean bl, int n7, int n8, int n9, int[] nArray, boolean bl2) {
        this(n, n2, n3, n4, n5, n6, bl, n7, n8, n9, nArray);
        this.setSurviveScreenChange(bl2);
    }

    public PartialPopupStub(int n, int n2, int n3, int n4, int n5, int n6, boolean bl, int n7, int n8, int n9, int[] nArray, boolean bl2, boolean bl3) {
        this(n, n2, n3, n4, n5, n6, bl, n7, n8, n9, nArray, bl2);
        this.setFallbackScreenAllowed(bl3);
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    @Override
    public HMIView[] getViews() {
        if (this.modelID != 0 && this.modelID != -1) {
            return new HMIView[]{this};
        }
        return null;
    }

    @Override
    public void activateBackgroundGrayOut() {
    }

    @Override
    public void deactivateBackgroundGrayOut() {
    }

    @Override
    public HMIView[][] getReplacementWidgets() {
        return null;
    }

    @Override
    public void hideNotScreenChangeSurvivingPopups() {
    }

    @Override
    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    @Override
    public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    @Override
    public void shiftHorizontal(int n) {
    }

    @Override
    public IPartialPopupControllerEvo getSkeleton() {
        AbstractPartialPopupController abstractPartialPopupController;
        if (this.skeleton == null && (abstractPartialPopupController = (AbstractPartialPopupController)AbstractWidget.hmiService.getPartialPopup(this.terminal.getTerminalID(), this.popupID)) != null) {
            abstractPartialPopupController.setModel(this.model);
            abstractPartialPopupController.setTerminal(this.terminal);
            this.initContext.setScreenFactory(abstractPartialPopupController.getScreenFactory());
            abstractPartialPopupController.setInitContext(this.initContext);
            abstractPartialPopupController.setType(7);
            this.skeleton = abstractPartialPopupController;
        }
        return this.skeleton;
    }

    @Override
    public int show(int n) {
        IPartialPopupControllerEvo iPartialPopupControllerEvo = this.getSkeleton();
        if (iPartialPopupControllerEvo != null) {
            iPartialPopupControllerEvo.connected(true, false);
            IWidgetLogChannel.logChannelPopups.log(-2137614336, "PartialPopupStub#show call show( %2 ) for %1", (long)this.popupID, (long)n);
            return iPartialPopupControllerEvo.show(n);
        }
        IWidgetLogChannel.logChannelPopups.log(10000, "PartialPopupStub#show couldn't retrieve skeleton for  id %1", (long)this.popupID);
        return 2;
    }

    @Override
    protected void registerPopup() {
        this.popupManager.registerPopup(this);
    }
}

