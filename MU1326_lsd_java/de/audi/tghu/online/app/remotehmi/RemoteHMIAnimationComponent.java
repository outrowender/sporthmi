/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IAnimationController$ModelContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIAnimationComponent
extends AbstractRemoteHMIComponent {
    protected static final int ANIMATION_NONE;
    protected static final int ANIMATION_STANDARD;
    protected static final int ANIMATION_DRAWERS;
    protected static final int ADDITIONAL_INFO_NONE;
    protected ChoiceModelApp animationModelExit;
    protected ChoiceModelApp animationModelExitAdditionalInformation;
    protected ChoiceModelApp animationModelEnter;
    protected ChoiceModelApp animationModelEnterAdditionalInformation;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.animationModelExit = this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(203);
        this.animationModelExit.setValue(0);
        this.animationModelExit.setStatus(0);
        IAnimationController$ModelContainer.screenExitRemoteHMI = (ChoiceModel)this.animationModelExit;
        this.animationModelExitAdditionalInformation = this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(3924);
        this.animationModelExitAdditionalInformation.setValue(26);
        IAnimationController$ModelContainer.screenExitAdditionalInformationRemoteHMI = (ChoiceModel)this.animationModelExitAdditionalInformation;
        this.animationModelEnter = this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(202);
        this.animationModelEnter.setValue(0);
        this.animationModelEnter.setStatus(0);
        IAnimationController$ModelContainer.screenEnterRemoteHMI = (ChoiceModel)this.animationModelEnter;
        this.animationModelEnterAdditionalInformation = this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(3923);
        this.animationModelEnterAdditionalInformation.setValue(26);
        IAnimationController$ModelContainer.screenEnterAdditionalInformationRemoteHMI = (ChoiceModel)this.animationModelEnterAdditionalInformation;
    }

    public void configureAnimation(String string, AbstractHMIViewListener abstractHMIViewListener, int n, boolean bl) {
    }

    public void configureTakeScreenshot(AbstractHMIViewListener abstractHMIViewListener, AbstractHMIViewListener abstractHMIViewListener2) {
        int n = abstractHMIViewListener2 != null && abstractHMIViewListener2.isTakeScreenshotView() ? 1 : 2;
        int n2 = abstractHMIViewListener != null && abstractHMIViewListener.isTakeScreenshotView() ? 1 : 2;
        this.logChannel.log(1078071040, "RemoteHMIAnimationComponent#configureTakeScreenshot: exit=%1, enter=%2 (1=active, 2=inactive)", (long)n2, (long)n);
        this.animationModelEnter.setStatus(n);
        this.animationModelExit.setStatus(n2);
    }

    public void reset() {
    }
}

