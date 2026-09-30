/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.widgets.DABSlideShowHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class IconCrossFadeController
extends LayoutContainerController
implements AnimationListener {
    IconController containerA;
    IconController containerB;
    AbstractAnimation animation;
    IRenderer renderer;
    String resourceUri = "";
    int delay = 0;
    private boolean useCrossfading;
    private boolean avoidFlickering = false;
    private int crossFadeState = 0;
    static final int ANIMATION_TYPE = 104;
    private DABSlideShowHandler dabSlsHandler = null;

    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IconController) {
            if (this.containerA == null) {
                this.containerA = (IconController)abstractWidget;
            } else if (this.containerB == null) {
                this.containerB = (IconController)abstractWidget;
            }
        }
        super.add(abstractWidget);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        String string = "";
        int n = 1;
        if (modelUpdateEvent.getUpdateType() == 1) {
            if (this.model instanceof ResourceLocatorModel) {
                string = ((ResourceLocatorModel)this.model).getResourceLocator().getResourceURI();
                n = ((ResourceLocatorModel)this.model).getResourceLocator().getMinDisplayDuration();
            }
            if (!string.equals(this.resourceUri)) {
                this.updateContent(modelUpdateEvent);
            }
            if (this.delay > n) {
                this.updateContent(modelUpdateEvent);
            }
            this.resourceUri = string;
            this.delay = n;
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected void initializeWidget() {
        if (this.renderer == null) {
            this.renderer = ((ExtHMITerminalEvo)((Object)this.terminal)).getRendererFactory().createCompositeRenderer(this);
            if (this.renderer != null) {
                this.renderer.connect(this.initContext);
                this.renderer.updateInheritedFonts();
            }
        }
        this.containerA.setModelID(this.modelID);
        this.containerB.setModelID(this.modelID);
        this.updateContent(null);
        super.initializeWidget();
    }

    public void updateContent(ModelUpdateEvent modelUpdateEvent) {
        logChannelCoverStack.log(10000000, "IconCrossFadeController#updateContent crossFadeState: %1", (long)this.crossFadeState);
        IconController iconController = null;
        if (this.dabSlsHandler != null && !this.dabSlsHandler.isUpdateEventProccessable(((ResourceLocatorModel)this.model).getResourceLocator())) {
            logChannel.log(10000000, "IconCrossFadeController#processCrossFading: : blocked processing ResourceLocator UpdateEvent , DABSlideShow Timer is running");
            this.dabSlsHandler.setModelUpdateEvent(modelUpdateEvent);
            return;
        }
        if (this.model instanceof ResourceLocatorModel && ((ResourceLocatorModel)this.model).getResourceLocator().getMinDisplayDuration() > 0) {
            if (this.dabSlsHandler == null) {
                this.dabSlsHandler = new DABSlideShowHandler(this);
            }
            if (this.dabSlsHandler.startSlsTimer(((ResourceLocatorModel)this.model).getResourceLocator()) == 0) {
                logChannel.log(10000000, "IconCrossFadeController#processCrossFading : (re)started DABSlideShow Timer ");
            }
        }
        switch (this.crossFadeState) {
            case 0: {
                logChannelCoverStack.log(10000000, "IconCrossFadeController#updateContent updateIconB");
                iconController = this.containerB;
                break;
            }
            case 1: {
                logChannelCoverStack.log(10000000, "IconCrossFadeController#updateContent updateIconA");
                iconController = this.containerA;
                break;
            }
            default: {
                return;
            }
        }
        this.updateIcon(iconController, modelUpdateEvent);
    }

    private void updateIcon(IconController iconController, ModelUpdateEvent modelUpdateEvent) {
        if (iconController == null) {
            return;
        }
        iconController.setModel(this.model);
        if (modelUpdateEvent != null) {
            iconController.processModelUpdateEvent(modelUpdateEvent);
            logChannelCoverStack.log(10000000, "IconCrossFadeController#updateIcon forward modelUpdateEvent");
        }
        this.processCrossFading();
    }

    public void processCrossFading() {
        logChannelCoverStack.log(10000000, "IconCrossFadeController#processCrossFading crossFadeState: %1", (long)this.crossFadeState);
        IconController iconController = this.containerA;
        IconController iconController2 = this.containerB;
        if (iconController.getWidth() != iconController2.getWidth() || iconController.getHeight() != iconController2.getHeight()) {
            this.avoidFlickering = false;
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(10000000, "IconCrossFadeController#animate A res: %1/%2, B res: %3/%4", (Object)String.valueOf(iconController.getWidth()), (Object)String.valueOf(iconController.getHeight()), (Object)String.valueOf(iconController2.getWidth()), (Object)String.valueOf(iconController2.getHeight()));
                logChannelCoverStack.log(10000000, "IconCrossFadeController#processCrossFading avoidFlickering: %1", this.avoidFlickering);
            }
        } else {
            this.avoidFlickering = true;
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(10000000, "IconCrossFadeController#animate A res: %1/%2, B res: %3/%4", (Object)String.valueOf(iconController.getWidth()), (Object)String.valueOf(iconController.getHeight()), (Object)String.valueOf(iconController2.getWidth()), (Object)String.valueOf(iconController2.getHeight()));
                logChannelCoverStack.log(10000000, "IconCrossFadeController#processCrossFading avoidFlickering: %1", this.avoidFlickering);
            }
        }
    }

    public void startCrossFadingAnimation() {
        if (this.getAnimation().isAnimating()) {
            this.getAnimation().setTarget(this.animation.getTarget());
            logChannelCoverStack.log(10000000, "IconCrossFadeController#startCrossFadingAnimation");
        } else {
            this.getAnimation().startDynamicAnimation(0.0f, 1000.0f, 104, true, this);
            logChannelCoverStack.log(10000000, "IconCrossFadeController#startCrossFadingAnimation");
        }
    }

    private AbstractAnimationController getAnimationController() {
        if (this.getTerminal() != null) {
            return (AbstractAnimationController)this.getTerminal().getIAnimationController();
        }
        return null;
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(104);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    public boolean isUseCrossfading() {
        return this.useCrossfading;
    }

    public void setUseCrossfading(boolean bl) {
        this.useCrossfading = bl;
    }

    public void animationStarted(int n, int n2) {
        logChannelCoverStack.log(10000000, "IconCrossFadeController#animationStarted");
    }

    public void animationFinished(int n, int n2) {
        logChannelCoverStack.log(10000000, "IconCrossFadeController#animationFinished");
        switch (this.crossFadeState) {
            case 0: {
                this.containerB.setOpacity(1.0f);
                this.containerA.setOpacity(0.0f);
                break;
            }
            case 1: {
                this.containerB.setOpacity(0.0f);
                this.containerA.setOpacity(1.0f);
                break;
            }
            default: {
                logChannelCoverStack.log(10000, "IconCrossFadeController#animationFinished: unknown cross fade state: %1", (long)this.crossFadeState);
            }
        }
        this.crossFadeState = this.crossFadeState == 0 ? 1 : 0;
    }

    public void animate(int n, float f2, int n2) {
        logChannelCoverStack.log(10000000, "IconCrossFadeController#animate progress: %1", (double)this.animation.getProgress());
        switch (this.crossFadeState) {
            case 0: {
                this.containerB.setOpacity(this.animation.getProgress());
                this.containerA.setOpacity(!this.avoidFlickering ? 1.0f - this.animation.getProgress() : this.containerA.getOpacity());
                logChannelCoverStack.log(10000000, "IconCrossFadeController#animateA opacity: %1", (double)this.containerA.getOpacity());
                break;
            }
            case 1: {
                this.containerB.setOpacity(1.0f - this.animation.getProgress());
                this.containerA.setOpacity(!this.avoidFlickering ? this.animation.getProgress() : 1.0f);
                logChannelCoverStack.log(10000000, "IconCrossFadeController#animateB opacity: %1", (double)this.containerA.getOpacity());
                break;
            }
            default: {
                logChannelCoverStack.log(10000, "IconCrossFadeController#animationFinished: unknown cross fade state: %1", (long)this.crossFadeState);
            }
        }
    }

    public void disconnecting() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        if (this.containerA != null) {
            this.containerA.setOpacity(1.0f);
        }
        if (this.containerB != null) {
            this.containerB.setOpacity(1.0f);
        }
        if (this.dabSlsHandler != null) {
            this.dabSlsHandler.cancelSlsTimer();
        }
        this.crossFadeState = 0;
        logChannelCoverStack.log(10000000, "IconCrossFadeController#disconnecting - reset icons and crossfadeState");
        super.disconnecting();
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setViewSizeOpacity(float f2) {
        if (this.viewSizeOpacity != f2) {
            this.viewSizeOpacity = f2;
            this.setCompositesDirty(true);
        }
    }
}

