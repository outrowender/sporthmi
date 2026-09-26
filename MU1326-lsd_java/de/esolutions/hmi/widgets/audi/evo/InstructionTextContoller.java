/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InstructionTextContoller
extends LayoutContainerController
implements IViewSizeAnimatable {
    private PartialPopupGlassplateController glassPlate;
    private List hintTexts;
    private ContainerController hintContainer;
    private MenuController optionsMenu;
    private MenuController hintTextMenu;
    private int fixedNumberOfOptions = -1;
    private int hintTextHorizontalOrientation = 2;
    private IconController icon;
    private IconController hintTextIconLeftSide;
    private boolean isViewSizeChanging;

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (this.layoutManager == null) {
            InstructionTextLayout instructionTextLayout = new InstructionTextLayout(this.initContext.getLayout());
            this.setLayoutManager(instructionTextLayout);
            if (this.optionsMenu != null) {
                instructionTextLayout.setTouchfieldLayout(this.isTochfieldAvailable());
            }
            if (this.glassPlate == null && this.parent instanceof PartialPopupController) {
                this.handlePartialPopupCase();
            }
        }
    }

    private void handlePartialPopupCase() {
        if (this.optionsMenu != null) {
            this.optionsMenu.setCalculatePreferredSize(true);
        }
        PartialPopupController partialPopupController = (PartialPopupController)this.parent;
        this.setMaxWidth(partialPopupController.getWidth());
        AbstractWidgetController abstractWidgetController = partialPopupController.getBackgroundController();
        if (abstractWidgetController instanceof PartialPopupGlassplateController) {
            this.glassPlate = (PartialPopupGlassplateController)abstractWidgetController;
        }
    }

    private boolean isTochfieldAvailable() {
        Iterator iterator = this.optionsMenu.getChildren().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            if (!(iterator.next() instanceof TouchController)) continue;
            bl = true;
            break;
        }
        return bl;
    }

    public void setGlassplate(PartialPopupGlassplateController partialPopupGlassplateController) {
        this.glassPlate = partialPopupGlassplateController;
        this.add(partialPopupGlassplateController);
    }

    public PartialPopupGlassplateController getGlassPlate() {
        return this.glassPlate;
    }

    public void addHintText(LabelController labelController) {
        if (this.hintTexts == null) {
            this.hintTexts = new ArrayList(1);
        }
        this.hintTexts.add(labelController);
        this.add(labelController);
    }

    public LabelController getHintText() {
        LabelController labelController = null;
        if (this.hintTexts != null) {
            Iterator iterator = this.hintTexts.iterator();
            boolean bl = false;
            while (iterator.hasNext() && !bl) {
                LabelController labelController2;
                Object object = iterator.next();
                if (!(object instanceof LabelController)) continue;
                labelController = labelController2 = (LabelController)object;
                bl = labelController2.isVisible();
            }
        }
        return labelController;
    }

    public void setOptions(MenuController menuController) {
        this.addOptions(menuController);
    }

    public void addOptions(MenuController menuController) {
        if (this.optionsMenu == null) {
            this.optionsMenu = menuController;
            menuController.setClipContent(true);
            this.add(menuController);
        } else if (this.hintTextMenu == null) {
            this.hintTextMenu = menuController;
            this.add(menuController);
        }
    }

    public void addHintTextIcon(AbstractWidget abstractWidget) {
    }

    public MenuController getOptions() {
        return this.optionsMenu;
    }

    public MenuController getHintTextMenu() {
        return this.hintTextMenu;
    }

    public void setHintArea(ContainerController containerController) {
        this.hintContainer = containerController;
    }

    public ContainerController getHintArea() {
        return this.hintContainer;
    }

    private void setMaxWidth(int n) {
        LayoutManager layoutManager = this.getLayoutManager();
        ((InstructionTextLayout)layoutManager).setMaxWidth(n);
    }

    public void setFixedNumberOfOptions(int n) {
        this.fixedNumberOfOptions = n;
    }

    public int getFixedNumberOfOptions() {
        return this.fixedNumberOfOptions;
    }

    @Override
    public IRenderer getRenderer() {
        IRendererFactory iRendererFactory;
        if (this.renderer == null && (iRendererFactory = this.getRendererFactory()) != null) {
            this.renderer = iRendererFactory.createInstructionTextRenderer(this);
        }
        return super.getRenderer();
    }

    private IRendererFactory getRendererFactory() {
        ExtHMITerminalEvo extHMITerminalEvo = (ExtHMITerminalEvo)this.getTerminal();
        if (extHMITerminalEvo == null) {
            return null;
        }
        return extHMITerminalEvo.getRendererFactory();
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        int n;
        super.setViewSizeAnimation(f2, fArray, fArray2, bl);
        if (!this.isViewSizeChanging) {
            this.isViewSizeChanging = true;
            n = 0;
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)((Object)this.getInitContext().getScreen());
            if (abstractWidgetController instanceof AbstractScreenWidget) {
                int n2 = n = ((AbstractScreenWidget)this.getInitContext().getScreen()).getSmallStageType() == 3 ? 1 : 0;
            }
            if (this.hintTexts != null && n == 0) {
                for (int i2 = 0; i2 < this.hintTexts.size(); ++i2) {
                    ((LabelController)this.hintTexts.get(i2)).setOnScreen(false);
                }
            }
        }
        if (f2 >= 1.0f && this.hintTexts != null) {
            for (n = 0; n < this.hintTexts.size(); ++n) {
                ((LabelController)this.hintTexts.get(n)).setOnScreen(true);
            }
        }
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        super.setViewSizeAnimationFinished(fArray, bl);
        this.isViewSizeChanging = false;
        if (this.hintTexts != null) {
            for (int i2 = 0; i2 < this.hintTexts.size(); ++i2) {
                ((LabelController)this.hintTexts.get(i2)).setOnScreen(true);
            }
        }
    }

    @Override
    public void setVisible(boolean bl) {
        if (this.optionsMenu != null) {
            this.optionsMenu.setVisible(bl);
        }
        super.setVisible(bl);
        this.invalidateChildrenBounds();
    }

    public int getHintTextHorizontalOrientation() {
        return this.hintTextHorizontalOrientation;
    }

    public void setHintTextHorizontalOrientation(int n) {
        this.hintTextHorizontalOrientation = n;
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof IconController) {
            this.icon = (IconController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    public IconController getIcon() {
        return this.icon;
    }

    public IconController getHintTextIconLeftSide() {
        return this.hintTextIconLeftSide;
    }
}

