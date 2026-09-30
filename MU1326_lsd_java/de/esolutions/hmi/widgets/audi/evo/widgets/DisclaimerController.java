/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.RangeModel2D;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.ScreenArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyConfig;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.VisibilityProxyWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisclaimerController
extends AbstractWidgetController
implements IViewSizeAnimatable {
    private static final int VP_STATE_VISIBLE_ENABLED = 0;
    private static final int VP_STATE_INVISIBLE = 1;
    private static final int VP_STATE_VISIBLE_DISABLED = 2;
    private static final int VP_STATE_VISIBLE_DISABLED_FUNCTIONAL = 3;
    public static final int DISCLAIMER_MODE_SINGLEMODEL = 0;
    public static final int DISCLAIMER_MODE_MULTIPLE_MODEL_AUTO = 2;
    public static final int DISCLAIMER_MODE_MULTIPLE_MODEL_MANUAL = 4;
    public static final int DISCLAIMER_MODE_ALL_FOR_ONE = 6;
    public static final int DISCLAIMER_ROLE_MENU = 0;
    public static final int DISCLAIMER_ROLE_CHILDMODEL = 1;
    public static final int DISCLAIMER_ROLE_SELECTOR = 2;
    public static final int DISCLAIMER_ROLE_CONTAINER = 4;
    public static final int DISCLAIMER_ROLE_KEY_RELEASED = 3;
    private int mode;
    private int selector;
    private int value;
    private AbstractWidgetController selectorWidget;
    private InstructionTextContoller disclaimerMenu;
    private ContainerController disclaimerContainer;
    private AbstractWidget parentContainer;
    private IRenderer renderer = null;
    private int currentViewSize;
    private GlassplateController disclaimerGlassPlate;
    private boolean autoscaleDisclaimer = true;
    private boolean optionDrawerCanOpen = false;
    private List keyReleasedModelList;
    private List modelStubList = new ArrayList();

    private void updateModelValue() {
        switch (this.mode) {
            case 0: {
                this.value = this.getValueSinglemode();
                break;
            }
            case 2: {
                this.value = this.getValueMultipleProxyAuto();
                break;
            }
            case 4: {
                this.value = this.getValueMultipleProxyManual();
                break;
            }
            case 6: {
                this.value = this.getValueFromAll();
                break;
            }
            default: {
                this.value = this.getValueSinglemode();
            }
        }
        logDisclaimer.log(10000000, "DisclaimerController#updateModelValue Model has value: %1", (long)this.value);
        this.refreshVisibilityStatus(this.value);
        this.setMainMenuVisibility();
    }

    private int getValueSinglemode() {
        if (!this.modelIsChoiceModel()) {
            return this.value;
        }
        logDisclaimer.log(10000000, "DisclaimerController#updateModelValue with SINGLEMODE");
        this.forwardModelToChildren(this.model);
        return ((ChoiceModelGUI)this.model).getValue();
    }

    private int getValueMultipleProxyAuto() {
        logDisclaimer.log(10000000, "DisclaimerController#updateModelValue with DISCLAIMER_MODE_MULTIPLE_MODEL_AUTO");
        if (!this.modelIsChoiceModel() && this.modelStubList.isEmpty()) {
            return this.value;
        }
        int n = this.value;
        if (this.model != null) {
            n = this.getSelectorWidgetValue(this);
        }
        if (this.selectorWidget != null) {
            n = this.getSelectorWidgetValue(this.selectorWidget);
        }
        if (n < this.modelStubList.size() + 1 && n > 0) {
            Object object;
            this.selector = n;
            logDisclaimer.log(10000000, "DisclaimerController#getValueMultipleProxyAuto Selector is %1", (long)this.selector);
            Object object2 = this.modelStubList.get(this.selector - 1);
            if (object2 instanceof AbstractWidgetController && (object = ((AbstractWidgetController)object2).getModel()) instanceof ChoiceModelGUI) {
                logDisclaimer.log(10000000, "DisclaimerController#getValueMultipleProxyAuto Model with value %1 is forwarded to children", (long)((ChoiceModelGUI)object).getValue());
                this.forwardModelToChildren(object);
                return ((ChoiceModelGUI)object).getValue();
            }
        } else {
            logDisclaimer.log(10000000, "DisclaimerController#getValueMultipleProxyAuto Selector has unsupported Value: %1", (long)this.selector);
        }
        return this.value;
    }

    private int getValueMultipleProxyManual() {
        logDisclaimer.log(10000000, "DisclaimerController#updateModelValue with DISCLAIMER_MODE_MULTIPLE_MODEL_MANUAL");
        if (this.modelStubList.isEmpty()) {
            return this.value;
        }
        if (this.selector < this.modelStubList.size() && this.selector >= 0) {
            Object object;
            logDisclaimer.log(10000000, "DisclaimerController#getValueMultipleProxyAuto Selector is %1", (long)this.selector);
            Object object2 = this.modelStubList.get(this.selector);
            if (object2 instanceof AbstractWidgetController && (object = ((AbstractWidgetController)object2).getModel()) instanceof ChoiceModelGUI) {
                logDisclaimer.log(10000000, "DisclaimerController#getValueMultipleProxyManual Model with value %1 is forwarded to children", (long)((ChoiceModelGUI)object).getValue());
                this.forwardModelToChildren(object);
                return ((ChoiceModelGUI)object).getValue();
            }
        } else {
            logDisclaimer.log(10000000, "DisclaimerController#getValueMultipleProxyAuto Selector has unsupported Value: %1", (long)this.selector);
        }
        return this.value;
    }

    private int getValueFromAll() {
        logDisclaimer.log(10000000, "DisclaimerController#updateModelValue with DISCLAIMER_MODE_ALL_FOR_ONE");
        int n = -1;
        ChoiceModelGUI choiceModelGUI = null;
        Iterator iterator = this.modelStubList.iterator();
        while (iterator.hasNext()) {
            int n2;
            Object object;
            Object object2 = iterator.next();
            if (!(object2 instanceof AbstractWidgetController) || !((object = ((AbstractWidgetController)object2).getModel()) instanceof ChoiceModelGUI) || (n2 = ((ChoiceModelGUI)object).getValue()) <= n) continue;
            n = n2;
            choiceModelGUI = (ChoiceModelGUI)object;
        }
        if (n != -1 || choiceModelGUI != null) {
            this.forwardModelToChildren(choiceModelGUI);
            return n;
        }
        return this.value;
    }

    private boolean modelIsChoiceModel() {
        return this.model instanceof ChoiceModelGUI;
    }

    protected void initializeWidget() {
        if (this.renderer == null) {
            this.renderer = ((ExtHMITerminalEvo)((Object)this.terminal)).getRendererFactory().createCompositeRenderer(this);
            if (this.renderer != null) {
                this.renderer.connect(this.initContext);
                this.renderer.updateInheritedFonts();
            }
        }
        super.initializeWidget();
        this.currentViewSize = this.terminal.getViewSizeManager().getCurrentViewSize();
        logDisclaimer.log(10000000, "DisclaimerController#initializeWidget Current Disclaimer-Mode is: %1", (long)this.mode);
        logDisclaimer.log(10000000, "DisclaimerController#initializeWidget Current Disclaimer has: %1 ModelStubs", (long)this.modelStubList.size());
        this.getParentContainer();
        this.updateModelValue();
    }

    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof InstructionTextContoller) {
            this.disclaimerMenu = (InstructionTextContoller)abstractWidget;
            AbstractWidget abstractWidget2 = this.disclaimerMenu.getOptions().getChildOfRole(4);
            GlassplateController glassplateController = this.disclaimerGlassPlate = abstractWidget2 instanceof GlassplateController ? (GlassplateController)abstractWidget2 : null;
        }
        if (abstractWidget instanceof ContainerController) {
            this.disclaimerContainer = (ContainerController)abstractWidget;
        }
        if (abstractWidget instanceof ModelStubController || abstractWidget instanceof VisibilityProxyWidget) {
            this.modelStubList.add(abstractWidget);
        }
        super.add(abstractWidget);
    }

    public void add(AbstractWidget abstractWidget, int n) {
        switch (n) {
            case 0: {
                if (!(abstractWidget instanceof InstructionTextContoller)) break;
                this.disclaimerMenu = (InstructionTextContoller)abstractWidget;
                break;
            }
            case 4: {
                if (!(abstractWidget instanceof ContainerController)) break;
                this.disclaimerContainer = (ContainerController)abstractWidget;
                break;
            }
            case 1: {
                if (!(abstractWidget instanceof ModelStubController) && !(abstractWidget instanceof VisibilityProxyWidget)) break;
                this.modelStubList.add((ModelStubController)abstractWidget);
                break;
            }
            case 2: {
                if (!(abstractWidget instanceof ModelStubController) && !(abstractWidget instanceof VisibilityProxyWidget) || this.selectorWidget != null) break;
                this.selectorWidget = (AbstractWidgetController)abstractWidget;
                break;
            }
            case 3: {
                if (!(abstractWidget instanceof ModelStubController) && !(abstractWidget instanceof VisibilityProxyWidget)) break;
                if (this.keyReleasedModelList == null) {
                    this.keyReleasedModelList = new ArrayList();
                }
                this.keyReleasedModelList.add(abstractWidget);
                break;
            }
        }
        super.add(abstractWidget);
    }

    public int getSelectorWidgetValue(AbstractWidgetController abstractWidgetController) {
        Object object = abstractWidgetController.getModel();
        if (object instanceof ChoiceModelGUI) {
            int n = ((ChoiceModelGUI)object).getValue();
            logDisclaimer.log(10000000, "DisclaimerController#getSelectorWidgetValue Current Selector-Value is: %1", (long)n);
            return n;
        }
        if (object instanceof RangeModel2D) {
            int n = ((RangeModel2D)object).getValueX();
            logDisclaimer.log(10000000, "DisclaimerController#getSelectorWidgetValue Current Selector-Value is: %1", (long)n);
            return n;
        }
        return this.value;
    }

    private void getParentContainer() {
        ScreenWidgetEVO screenWidgetEVO = (ScreenWidgetEVO)this.getParent().getParent();
        if (screenWidgetEVO != null && screenWidgetEVO.getScreenAreas(8).contains(this.getParent())) {
            ((ContainerController)this.getParent()).setFocusableInSmallStage(false);
            this.parentContainer = this.getParent().getParent();
            return;
        }
        logDisclaimer.log(100000, "DisclaimerController#getParentContainer Disclaimer is not in valid hierarchy!");
        this.parentContainer = this.getParent();
    }

    private void setMainMenuVisibility() {
        GlassplateController glassplateController = null;
        ScreenArea screenArea = null;
        if (this.parentContainer instanceof AbstractScreenWidget) {
            screenArea = ((AbstractScreenWidget)this.parentContainer).getScreenArea(1);
        }
        Iterator iterator = this.parentContainer.getChildren().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (glassplateController == null && object instanceof AbstractWidgetController) {
                glassplateController = this.searchForGlassPlate((AbstractWidgetController)object);
            }
            if (object.equals(screenArea)) {
                this.applyVisibilityToChildren((AbstractWidgetController)((Object)screenArea), !this.isVisible());
            }
            if (object instanceof InstructionTextContoller) {
                this.applyVisibilityToChildren((AbstractWidgetController)object, !this.isVisible());
            }
            if (object instanceof ContainerController) {
                if (((ContainerController)object).getChildren().contains(this) || this.containsAllowedWidgets((ContainerController)object)) continue;
                this.applyVisiblityToWidget((AbstractWidgetController)object);
                continue;
            }
            if (object instanceof DisclaimerController || object instanceof GlassplateController || object instanceof SmallStageApplicationIconController || object instanceof FocusedPropertyConfig) continue;
            this.applyVisiblityToWidget((AbstractWidgetController)object);
        }
        if (this.isVisible()) {
            this.sendKeyEventsToModels();
        }
        if (glassplateController != null && this.autoscaleDisclaimer) {
            this.applyBoundsToDisclaimer(glassplateController);
        }
    }

    private boolean containsAllowedWidgets(ContainerController containerController) {
        Iterator iterator = containerController.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof TitleBarWidget)) continue;
            return true;
        }
        return true;
    }

    private void applyVisibilityToChildren(AbstractWidgetController abstractWidgetController, boolean bl) {
        Iterator iterator = abstractWidgetController.getChildren().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(((AbstractWidgetController)object).getParent() instanceof MenuController) && !(((AbstractWidgetController)object).getParent() instanceof MenuItemController)) {
                ((AbstractWidgetController)object).setOnScreen(bl);
                ((AbstractWidgetController)object).setActive(bl);
                logDisclaimer.log(10000000, "DisclaimerController#applyVisibilityToChildren widget: %1 is visible: %2", (Object)((AbstractWidgetController)object), (Object)String.valueOf(((AbstractWidgetController)object).isOnScreen()));
            }
            this.applyVisibilityToChildren((AbstractWidgetController)object, bl);
        }
    }

    private void applyVisiblityToWidget(AbstractWidgetController abstractWidgetController) {
        abstractWidgetController.setOnScreen(!this.isVisible());
        abstractWidgetController.setActive(!this.isVisible());
        logDisclaimer.log(10000000, "DisclaimerController#applyVisiblityToWidget widget: %1 is visible: %2", (Object)abstractWidgetController, (Object)String.valueOf(abstractWidgetController.isOnScreen()));
    }

    private void sendKeyEventsToModels() {
        if (this.keyReleasedModelList == null || this.keyReleasedModelList.size() < 1) {
            logChannel.log(10000000, "VisibilityProxyWidget#applyKeyEventsToWidget There are no Models for KeyReleased Events");
            return;
        }
        Iterator iterator = this.keyReleasedModelList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof VisibilityProxyWidget) && !(object instanceof ModelStubController) || !(((AbstractWidgetController)object).getModel() instanceof ButtonModelGUI)) continue;
            ButtonModelGUI buttonModelGUI = (ButtonModelGUI)((AbstractWidgetController)object).getModel();
            buttonModelGUI.keyReleased(buttonModelGUI.getID(), this.getTerminal().getTerminalID());
            logChannel.log(10000000, "VisibilityProxyWidget#applyKeyEventsToWidget KeyReleased is send to Model with ID: %1", (long)buttonModelGUI.getID());
        }
    }

    private GlassplateController searchForGlassPlate(AbstractWidgetController abstractWidgetController) {
        Object object;
        if (abstractWidgetController instanceof MenuController && (object = ((MenuController)abstractWidgetController).getChildOfRole(4)) instanceof GlassplateController) {
            return (GlassplateController)object;
        }
        object = abstractWidgetController.getChildren().iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            if (!(object2 instanceof GlassplateController)) continue;
            return (GlassplateController)object2;
        }
        return null;
    }

    private void applyBoundsToDisclaimer(GlassplateController glassplateController) {
        if (this.disclaimerMenu != null) {
            Iterator iterator = this.disclaimerMenu.getChildren().iterator();
            while (iterator.hasNext()) {
                int n;
                int n2;
                int n3;
                int n4;
                Object object = iterator.next();
                if (!(object instanceof MenuController)) continue;
                if (glassplateController.getParent() instanceof MenuController) {
                    n4 = glassplateController.getParent().getWidth();
                    n3 = glassplateController.getParent().getHeight();
                    n2 = glassplateController.getParent().getX();
                    n = glassplateController.getParent().getY();
                } else {
                    n4 = glassplateController.getWidth();
                    n3 = glassplateController.getHeight();
                    n2 = glassplateController.getX();
                    n = glassplateController.getY();
                }
                if (this.disclaimerGlassPlate != null) {
                    this.disclaimerGlassPlate.setOptionGlassPlate(glassplateController.isOptionGlassPlate());
                }
                MenuController menuController = (MenuController)object;
                menuController.setBounds(n2, n, n4, n3);
                menuController.setCompositesDirty(true);
                if (!logDisclaimer.isDebug()) continue;
                logDisclaimer.log(10000000, "DisclaimerController#applyBoundsToDisclaimer Disclaimer has new bounds: x:%1, y:%2, width:%3, height:%4", (Object)String.valueOf(menuController.getX()), (Object)String.valueOf(menuController.getY()), (Object)String.valueOf(menuController.getWidth()), (Object)String.valueOf(menuController.getHeight()));
            }
        }
    }

    private void refreshVisibilityStatus(int n) {
        if (this.parent != null) {
            boolean bl;
            boolean bl2;
            boolean bl3;
            switch (n) {
                case 0: {
                    bl3 = false;
                    bl2 = false;
                    bl = false;
                    break;
                }
                case 1: {
                    bl3 = true;
                    bl2 = false;
                    bl = false;
                    break;
                }
                case 2: {
                    bl3 = false;
                    bl2 = true;
                    bl = true;
                    break;
                }
                case 3: {
                    bl3 = false;
                    bl2 = true;
                    bl = false;
                    break;
                }
                default: {
                    bl3 = false;
                    bl2 = true;
                    bl = true;
                    logChannel.log(100000, "VisibilityProxyWidget#refreshVisibilityStatus status: %1 is undefined - set parent VISIBLE_DISABLED", (long)n);
                }
            }
            this.setVisibleByOwnCondition(bl3 || !bl3 && bl2);
            this.setEnabled(bl2);
            this.setFunctional(bl);
            logDisclaimer.log(10000000, "DisclaimerController#refreshVisibilityStatus Disclaimer is set to visible: %1, enabled: %2, functional: %3", this.isVisible(), this.isFunctional(), this.isEnabled());
            if (this.disclaimerMenu != null) {
                this.disclaimerMenu.setVisible(this.isVisible());
                this.disclaimerMenu.setEnabled(this.isEnabled());
                this.disclaimerMenu.setFunctional(this.isFunctional());
            } else {
                logChannel.log(100000, "VisibilityProxyWidget#refreshVisibilityStatus status disclaimer has no menu!");
            }
            if (this.disclaimerContainer != null) {
                this.disclaimerContainer.setVisible(this.isVisible());
                this.disclaimerContainer.setEnabled(this.isEnabled());
                this.disclaimerContainer.setFunctional(this.isFunctional());
            } else {
                logChannel.log(100000, "VisibilityProxyWidget#refreshVisibilityStatus status disclaimer has no container!");
            }
            if (this.isVisible()) {
                if (this.optionDrawerCanOpen) {
                    this.setDisclaimerActive(false);
                } else {
                    this.setDisclaimerActive(true);
                }
            } else {
                this.setDisclaimerActive(false);
            }
        }
    }

    private void setDisclaimerActive(boolean bl) {
        if (this.terminal != null && this.terminal.getDrawerFocusManager() != null) {
            this.terminal.getDrawerFocusManager().setDisclaimerActive(bl);
        }
    }

    public void predisconnecting() {
        super.predisconnecting();
        if (this.isVisible()) {
            this.terminal.getDrawerFocusManager().setDisclaimerActive(false);
        }
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateModelValue();
    }

    public void setVisible(boolean bl) {
    }

    private void setVisibleByOwnCondition(boolean bl) {
        super.setVisible(bl);
    }

    private void forwardModelToChildren(Object object) {
        if (this.getChildrenSize() > 0 && this.disclaimerMenu != null) {
            Iterator iterator = this.disclaimerMenu.getChildren().iterator();
            while (iterator.hasNext()) {
                Object object2 = iterator.next();
                if (object2 instanceof LabelController && object instanceof ChoiceModelGUI) {
                    LabelController labelController = (LabelController)object2;
                    labelController.setModel((ChoiceModelGUI)object);
                    labelController.updateContent();
                    logChannel.log(10000000, "DisclaimerController#forwardModelToChildren: Disclaimer send Model %1 to Label: %2", object, object2);
                    continue;
                }
                logChannel.log(10000000, "DisclaimerController#forwardModelToChildren: Disclaimer could not send Model %1 to child: %2", object, object2);
            }
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = this.value;
        this.updateModelValue();
        if (n != this.value) {
            modelUpdateEvent.consume();
            this.forwardModelToChildren(this.model);
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public InstructionTextContoller getMenu() {
        return this.disclaimerMenu;
    }

    public ContainerController getController() {
        return this.disclaimerContainer;
    }

    public void setMode(int n) {
        this.mode = n;
    }

    public int getMode() {
        return this.mode;
    }

    public void setSelector(int n) {
        if (this.selector != n) {
            this.selector = n;
            this.updateModelValue();
        }
    }

    public int getSelector() {
        return this.selector;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
    }

    public void setViewSizeAnimationFinished(float[] fArray) {
        logChannel.log(10000000, "DisclaimerController#setViewSizeAnimationFinished: Disclaimer relayoutes");
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
        logChannel.log(10000000, "DisclaimerController#viewSizeTargetChanged");
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public boolean isAutoscaleDisclaimer() {
        return this.autoscaleDisclaimer;
    }

    public void setAutoscaleDisclaimer(boolean bl) {
        this.autoscaleDisclaimer = bl;
    }

    public void setOptionDrawerCanOpen(boolean bl) {
        this.optionDrawerCanOpen = bl;
    }
}

