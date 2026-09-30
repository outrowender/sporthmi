/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TitleBarWidget
extends LayoutContainerController
implements IViewSizeAnimatable {
    int currentHMIApplication = -1;
    int currentHMIContext = -1;
    public static final int SEPARATOR_BITMAP_INDEX = 0;
    private List titleWidgets = Collections.EMPTY_LIST;
    private List breadcrumbWidgets = Collections.EMPTY_LIST;
    private List leftIconWidgets = Collections.EMPTY_LIST;
    private List rightIconWidgets = Collections.EMPTY_LIST;
    private boolean separatorVisible;
    private int separatorX;
    private int separatorY;
    private boolean isAnimating;
    private float nowPlayingState = 0.0f;
    private boolean fadeForNowPlayingScreen;

    public TitleBarWidget() {
        this.setLayoutManager(new TitleBarLayout());
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.terminal != null) {
            this.currentHMIApplication = this.terminal.getFramework().getHMIService().getChoiceModel(8).getValue();
            this.currentHMIContext = this.terminal.getFramework().getHMIService().getChoiceModel(138).getValue();
        }
    }

    protected void initializeWidget() {
        boolean bl = ((AbstractScreenWidget)this.initContext.getScreen()).getScreenMode() == 2;
        for (int i2 = 0; i2 < this.titleWidgets.size(); ++i2) {
            ((AbstractWidgetController)this.titleWidgets.get(i2)).setHighlighted(bl);
        }
        super.initializeWidget();
        this.fadeForNowPlayingScreen = false;
        this.propagateNowPlayingStateToLabels();
    }

    public void disconnecting() {
        this.nowPlayingState = 0.0f;
        super.disconnecting();
    }

    public void addTitle(AbstractWidgetController abstractWidgetController) {
        if (this.titleWidgets.isEmpty()) {
            this.titleWidgets = new ArrayList(1);
        }
        this.titleWidgets.add(abstractWidgetController);
        this.add(abstractWidgetController);
    }

    public void addBreadcrumb(AbstractWidgetController abstractWidgetController) {
        if (this.breadcrumbWidgets.isEmpty()) {
            this.breadcrumbWidgets = new ArrayList(1);
        }
        this.breadcrumbWidgets.add(abstractWidgetController);
        this.add(abstractWidgetController);
    }

    public void addLeftIcon(AbstractWidgetController abstractWidgetController) {
        if (this.leftIconWidgets.isEmpty()) {
            this.leftIconWidgets = new ArrayList(1);
        }
        this.leftIconWidgets.add(abstractWidgetController);
        this.add(abstractWidgetController);
    }

    public void addRightIcon(AbstractWidgetController abstractWidgetController) {
        if (this.rightIconWidgets.isEmpty()) {
            this.rightIconWidgets = new ArrayList(1);
        }
        this.rightIconWidgets.add(abstractWidgetController);
        this.add(abstractWidgetController);
    }

    public void remove(AbstractWidget abstractWidget) {
        this.titleWidgets.remove(abstractWidget);
        this.breadcrumbWidgets.remove(abstractWidget);
        this.leftIconWidgets.remove(abstractWidget);
        this.rightIconWidgets.remove(abstractWidget);
        super.remove(abstractWidget);
    }

    public List getTitleWidgets() {
        return this.titleWidgets;
    }

    public List getBreadcrumbWidgets() {
        return this.breadcrumbWidgets;
    }

    public List getLeftIconWidgets() {
        return this.leftIconWidgets;
    }

    public List getRightIconWidgets() {
        return this.rightIconWidgets;
    }

    public boolean hasSeparator() {
        return this.hasBitmap(0);
    }

    public int getSeparatorWidth() {
        if (this.renderer instanceof TitleBarRenderer) {
            return ((TitleBarRenderer)this.renderer).getSeparatorWidth();
        }
        return 0;
    }

    public int getSeparatorHeight() {
        if (this.renderer instanceof TitleBarRenderer) {
            return ((TitleBarRenderer)this.renderer).getSeparatorHeight();
        }
        return 0;
    }

    public void setSeparatorVisible(boolean bl) {
        this.separatorVisible = bl;
    }

    public void setSeparatorLocation(int n, int n2) {
        this.separatorX = n;
        this.separatorY = n2;
    }

    public int getSeparatorX() {
        return this.separatorX;
    }

    public int getSeparatorY() {
        return this.separatorY;
    }

    public boolean isSeparatorVisible() {
        return this.separatorVisible;
    }

    public TitleBarLayout getTitleLayout() {
        return (TitleBarLayout)this.getLayoutManager();
    }

    public void invalidateChildrenBounds() {
        super.invalidateChildrenBounds();
        this.setCompositesDirty(true);
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (!this.isAnimating) {
            boolean bl2;
            this.isAnimating = true;
            boolean bl3 = bl2 = ((AbstractScreenWidget)this.getInitContext().getScreen()).getSmallStageType() == 3;
            if (!bl2) {
                this.setOnScreen(false);
            }
        }
        if (f2 >= 1.0f) {
            this.setOnScreen(true);
        }
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        boolean bl2;
        this.isAnimating = false;
        boolean bl3 = bl2 = ((AbstractScreenWidget)this.getInitContext().getScreen()).getSmallStageType() == 3;
        if (((HMITerminalEvoImpl)this.getTerminal()).getSkin() == 1) {
            this.setBreadcrumVisible(!this.terminal.getViewSizeManager().isSportskinSmallStage());
        } else {
            int n = ((HMITerminalEvoImpl)this.getTerminal()).getViewSizeManager().getCurrentViewSize();
            if (n == 1 && !bl2) {
                this.setBreadcrumVisible(false);
            } else {
                this.setBreadcrumVisible(true);
            }
        }
        if (!bl2 && !this.isAnimating && bl) {
            this.setOnScreen(true);
        }
    }

    private void setBreadcrumVisible(boolean bl) {
        for (int i2 = 0; i2 < this.breadcrumbWidgets.size(); ++i2) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.breadcrumbWidgets.get(i2);
            if (abstractWidgetController == null) continue;
            boolean bl2 = abstractWidgetController.isOnScreen();
            abstractWidgetController.setOnScreen(bl);
            if (bl2 == bl) continue;
            this.invalidateChildrenBounds();
            this.setCompositesDirty(true);
        }
    }

    private void propagateNowPlayingStateToLabels() {
        AbstractWidget abstractWidget;
        Iterator iterator = this.breadcrumbWidgets.iterator();
        while (iterator.hasNext()) {
            abstractWidget = (AbstractWidget)iterator.next();
            this.propagateNowPlayingStateToLabels(abstractWidget);
        }
        iterator = this.titleWidgets.iterator();
        while (iterator.hasNext()) {
            abstractWidget = (AbstractWidget)iterator.next();
            this.propagateNowPlayingStateToLabels(abstractWidget);
        }
    }

    private void propagateNowPlayingStateToLabels(AbstractWidget abstractWidget) {
        LabelController labelController;
        if (abstractWidget instanceof LabelController && this.hasNowPlayingText(labelController = (LabelController)abstractWidget)) {
            boolean bl = this.nowPlayingState > 0.5f;
            labelController.setModel(Util.createInteger(bl ? 1 : 0));
            labelController.updateContent();
            this.fadeForNowPlayingScreen = true;
        }
    }

    private boolean hasNowPlayingText(LabelController labelController) {
        int[] nArray = labelController.getTextIds();
        if (nArray == null || nArray.length < 2) {
            return false;
        }
        Object object = labelController.getModel();
        return object == null || object instanceof Integer;
    }

    public float getNowPlayingState() {
        return this.nowPlayingState;
    }

    public void setNowPlayingState(float f2) {
        if (this.nowPlayingState == f2) {
            return;
        }
        this.nowPlayingState = f2;
        this.propagateNowPlayingStateToLabels();
        if (this.fadeForNowPlayingScreen) {
            this.setCompositesDirty(true);
        }
    }

    public float getNowPlayingOpacity() {
        if (this.fadeForNowPlayingScreen) {
            float f2;
            float f3 = this.nowPlayingState;
            if (f3 > 0.5f) {
                f3 = 1.0f - f3;
            }
            if (f3 > (f2 = 0.2f)) {
                return 0.0f;
            }
            return 1.0f - f3 / f2;
        }
        return 1.0f;
    }

    public void setVisible(boolean bl) {
        if (this.terminal != null) {
            int n = this.terminal.getFramework().getHMIService().getChoiceModel(138).getValue();
            int n2 = this.terminal.getFramework().getHMIService().getChoiceModel(8).getValue();
            if (this.isConnected() && (n2 != this.currentHMIApplication || n != this.currentHMIContext)) {
                return;
            }
        }
        super.setVisible(bl);
    }
}

