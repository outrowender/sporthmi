/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModel2DGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.view.IKzbMergeListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.ICarViewer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager$Helper;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController$MutableAnimationTransformation;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICarViewerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import java.util.HashMap;
import java.util.Map;

public class CarViewerController
extends AbstractWidgetController
implements ICarViewer,
IMenuCallback,
IViewSizeAnimatable,
DrawerAnimationListener,
IKzbMergeListener {
    private ICarViewerRenderer renderer;
    private static final float[][] AMBIENTLIGHT_FIXED_PROFILE_COLORS = new float[][]{{32579, 32579, 32579, 32579, 32579, 32579}, {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, {32579, 32579, 32579, 32579, 32579, 32579}, {32579, 32579, 32579, 32579, 32579, 32579}, {0.0f, 0.0f, 32579, 0.0f, 0.0f, 32579}, {32579, 1347, 63553, 32579, 1347, 63553}, {32579, 0.0f, 0.0f, 32579, 0.0f, 0.0f}, {32067, 32579, 28227, 32067, 32579, 28227}, {32579, 32579, 32579, 32579, 0.0f, 0.0f}};
    private int currentCarMenuIndex = -1;
    private int currentMode = 0;
    private static final int INTLIGHT_PROFILE_NONE;
    private static final int INTLIGHT_PROFILE_INDIVIDUAL;
    private static final int MODELSTUB_CHARISMA_PHEV;
    private static final int MODELSTUB_UGDO;
    private static final int MODELSTUB_CHARISMA_INDEX;
    private static final int MODELSTUB_CHARISMA_PITCH;
    private static final int MODELSTUB_CHARISMA_ROLL;
    private static final int MODELSTUB_CHARISMA_PITCH_SOFT_WARNING_START;
    private static final int MODELSTUB_CHARISMA_PITCH_HARD_WARNING_START;
    private static final int MODELSTUB_CHARISMA_PITCH_HARD_WARNING_END;
    private static final int MODELSTUB_CHARISMA_ROLL_SOFT_WARNING_START;
    private static final int MODELSTUB_CHARISMA_ROLL_HARD_WARNING_START;
    private static final int MODELSTUB_CHARISMA_ROLL_HARD_WARNING_END;
    private static final int MODELSTUB_CHARISMA_GYRO_VISIBLE;
    private static final int MODELSTUB_CHARISMA_PITCH_ANGLE_VISIBLE;
    private static final int MODELSTUB_CHARISMA_ROLL_ANGLE_VISIBLE;
    private static final int MODELSTUB_CHARISMA_ROLL_HARD_WARNING_END_ORIGNAL;
    private static final int MODELSTUB_CHARISMA_ROLL_HARD_WARNING_START_ORIGNAL;
    private static final int MODELSTUB_CHARISMA_ROLL_SOFT_WARNING_START_ORIGNAL;
    private static final int MODELSTUB_INTLIGHT_CONTOUR_COLOR_LIST;
    private static final int MODELSTUB_INTLIGHT_AMBIENT_COLOR_LIST;
    private static final int MODELSTUB_INTLIGHT_SELECTED_PROFILE;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS_DOOR;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS_FOOTWELL;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS_CONTOUR;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS_DASH;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS_SURFACE;
    private static final int MODELSTUB_INTLIGHT_BRIGHTNESS_SURFACE_AVAILABLE;
    private static final int MODELSTUB_FRONT_AVAILABLE;
    private static final int FRONT_VISIBLE;
    private static final int QQ1;
    private static final int QQ2;
    public static final int ROLE_TEXT_ROLL;
    public static final int ROLE_TEXT_ROLL_DEGREE;
    public static final int ROLE_TEXT_PITCH;
    public static final int ROLE_TEXT_PITCH_DEGREE;
    private static final int MAXIMUM_ANGEL_VALUE_APPLICATION;
    private static final int MAXIMUM_ANGEL_VALUE_FOR_KZB;
    private static final float[] DEFAULT_COLOR;
    private static final int DEFAULT_BRIGHTNESS;
    private static final float CAR_MENU_SMALL_STAGE_TRANSLATION_X;
    private static final float CAR_MENU_SMALL_STAGE_TRANSLATION_X_RTL;
    private int[] cachedPhevValues = null;
    private boolean phevAvailable = false;
    private float[] ambientLightColor;
    private float[] contourLightColor;
    private float[] intlightBrightness;
    private boolean connected;
    private boolean ddbOpen;
    private static int lastStage;
    private static int lastFinishedStage;
    private boolean viewSizeAnimationRunning;
    private MenuController activeMenu;
    private LogChannel logChannel3DCar = IWidgetLogChannel.logChannel3DCar;
    private float desaturation;
    private float transX;
    private float transY;
    private float scale = 1.0f;
    private ContainerController carAreaParent;
    private AbstractWidget pitchText;
    private AbstractWidget pitchDegreeText;
    private AbstractWidget rollText;
    private AbstractWidget rollDegreeText;
    private boolean variantLoadedFlag = false;
    private Map standardVariantIconControllers = new HashMap();
    private IconController activeStandardIconController = null;
    private boolean isWrapperController = false;
    private CarViewerController internalCarViewerController = null;
    private ContainerController$MutableAnimationTransformation carAreaTransform = new ContainerController$MutableAnimationTransformation();
    private boolean ignoreScreenChangeTransformation;

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ICarViewerRenderer iCarViewerRenderer) {
        this.renderer = iCarViewerRenderer;
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (!this.variantLoadedFlag) {
            this.adjustVariantVisibilityForStandard();
        }
        if (this.terminal.getCarCodingHelper().isPHEVCar()) {
            this.phevAvailable = true;
        }
        this.connected = true;
        this.setOnScreen(true);
        this.setCarMenuIndex(this.currentCarMenuIndex);
        this.setRendererVisible(this.isVisible());
        this.setRendererMode(this.currentMode);
        this.setRendererDDBOpen();
        this.updateCarStubValues();
        this.updateSmallStageTranslationOffsetX();
        if (this.parent != null && this.parent instanceof ContainerController) {
            this.carAreaParent = (ContainerController)this.parent;
        }
        this.terminal.getDrawerFocusManager().registerDrawerAnimationListener(this);
        int n = this.terminal.getViewSizeManager().getCurrentViewSize() == 1 ? 1 : 0;
        this.viewSizeAnimationRunning = this.terminal.getViewSizeManager().isAnimationRunning();
        this.logChannel3DCar.log(-2137614336, "CarViewerController#initializeWidget newStage=%1, lastStage=%2, viewSizeAnimationRunning=%3", (long)n, (long)lastStage, this.viewSizeAnimationRunning);
        if (n != lastStage) {
            this.renderer.setViewSizeTargetChanged(n, false);
            lastStage = n;
        }
    }

    @Override
    protected void afterConnected() {
        if (this.phevAvailable && this.currentMode == 1) {
            this.updateDriveSelectPEHEVModels(true);
        }
        super.afterConnected();
    }

    private void updateSmallStageTranslationOffsetX() {
        if (this.renderer != null && this.terminal.getCarCodingHelper().isR8orTT()) {
            int n = 23747;
            if (!this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation()) {
                n = 38595;
            }
            this.renderer.updateSmallStageTranslationOffset(n);
        }
    }

    private void adjustVariantVisibilityForStandard() {
        if (this.standardVariantIconControllers == null || this.standardVariantIconControllers.isEmpty()) {
            this.logChannel3DCar.log(-2137614336, "CarViewerController#adjustVariantVisibility: no IconControllers specified.");
            return;
        }
        ICarCodingHelper iCarCodingHelper = this.terminal.getCarCodingHelper();
        if (iCarCodingHelper == null) {
            this.logChannel3DCar.log(-2137614336, "CarViewerController#adjustVariantVisibility: no valid CarCodingHelper accessible.");
            return;
        }
        Integer n = Util.createInteger(iCarCodingHelper.getCarType());
        this.activeStandardIconController = (IconController)this.standardVariantIconControllers.get(n);
        if (this.activeStandardIconController != null) {
            this.activeStandardIconController.setVisible(true);
            this.variantLoadedFlag = true;
        }
    }

    private void updateCarStubValues() {
        if (AbstractWidget.isVariantStd()) {
            return;
        }
        if (this.currentMode == 1) {
            this.updateDriveSelectModels();
            if (this.phevAvailable) {
                this.updateDriveSelectPEHEVModels(true);
            }
        }
        if (this.currentMode == 2) {
            this.updateUGDOModels();
        } else {
            this.updateAmbientLightModels();
        }
    }

    @Override
    public void setVisible(boolean bl) {
        super.setVisible(bl);
        this.setRendererVisible(this.shouldRender());
    }

    @Override
    public void setOnScreen(boolean bl) {
        super.setOnScreen(bl);
        this.setRendererVisible(this.shouldRender());
    }

    @Override
    public void setVisibleOnCurrentStage(boolean bl) {
        if (this.connected) {
            super.setVisibleOnCurrentStage(bl);
            this.setRendererVisible(this.shouldRender());
        }
    }

    private void setRendererVisible(boolean bl) {
        if (this.renderer != null) {
            this.renderer.setVisible(bl);
        }
    }

    private int getChoiceIndexFromMenu() {
        if (this.activeMenu == null) {
            return -1;
        }
        if (!this.activeMenu.hasFocusedItem()) {
            this.logChannel3DCar.log(-2137614336, "CarViewerController#menuFocusChangeFinished: no focused item");
            return -1;
        }
        MenuItemIndex menuItemIndex = this.activeMenu.getFocusedIndex();
        AbstractWidget abstractWidget = this.activeMenu.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItem) {
            int n = ((IMenuItem)((Object)abstractWidget)).getWidgetID();
            this.logChannel3DCar.log(-2137614336, "CarViewerController#getChoiceIndexFromMenu: set value %2 for focused item %1", (Object)menuItemIndex, (long)n);
            return n;
        }
        this.logChannel3DCar.log(-2137614336, "CarViewerController#getChoiceIndexFromMenu: focused widget %1 is not a menuItem: %2", (Object)menuItemIndex, (Object)abstractWidget);
        return -1;
    }

    @Override
    public void menuLayouted() {
    }

    @Override
    public void viewportUpdated(boolean bl) {
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }

    @Override
    public void menuFocusChangeFinished() {
        int n = this.getChoiceIndexFromMenu();
        this.setCarMenuIndex(n);
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
        this.activeMenu = menuController;
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    @Override
    public void setCarMenuIndex(int n) {
        this.currentCarMenuIndex = n;
        if (this.isWrapperController && this.internalCarViewerController != null) {
            this.internalCarViewerController.setCarMenuIndex(this.currentCarMenuIndex);
        } else if (this.renderer != null) {
            this.renderer.setCarMenuIndex(this.currentCarMenuIndex);
        }
    }

    private void setRendererMode(int n) {
        if (this.renderer != null && n != 2) {
            this.renderer.setMode(this.currentMode);
        }
    }

    @Override
    public void setMode(int n) {
        this.currentMode = n;
        this.setRendererMode(this.currentMode);
    }

    private Object getModelStubModel(int n) {
        if (n >= this.getChildrenSize()) {
            return null;
        }
        AbstractWidget abstractWidget = this.getChild(n);
        if (abstractWidget == null || !(abstractWidget instanceof ModelStubController)) {
            return null;
        }
        ModelStubController modelStubController = (ModelStubController)abstractWidget;
        return modelStubController.getModel();
    }

    private int getChoiceModelStubValue(int n, String string) {
        Object object = this.getModelStubModel(n);
        if (object == null) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getChoiceModelStubValue modelStub with for type %1 not available", (Object)string);
            return 0;
        }
        if (!(object instanceof ChoiceModelGUI)) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getChoiceModelStubValue modelStub for type %1 has no ChoiceModel attached", (Object)string);
            return 0;
        }
        return ((ChoiceModelGUI)object).getValue();
    }

    private int[] getListModelValues(int n) {
        Object object = this.getModelStubModel(n);
        int[] nArray = new int[10];
        if (object instanceof ListModel) {
            ListModelGUI listModelGUI = (ListModelGUI)object;
            for (int i2 = 0; i2 < listModelGUI.getLength(); ++i2) {
                IntegerListCell integerListCell = (IntegerListCell)listModelGUI.getCell(i2, 0);
                nArray[i2] = integerListCell.getValue();
            }
        }
        return nArray;
    }

    private void setDefaultColor(float[] fArray) {
        fArray[0] = DEFAULT_COLOR[0];
        fArray[1] = DEFAULT_COLOR[1];
        fArray[2] = DEFAULT_COLOR[2];
    }

    private void getColorFromListModelStub(int n, float[] fArray, String string) {
        Object object = this.getModelStubModel(n);
        if (object == null) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getColorFromListModelStub modelStub with for type %1 not available", (Object)string);
            this.setDefaultColor(fArray);
            return;
        }
        if (!(object instanceof TiledListModelGUI)) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getColorFromListModelStub modelStub for type %1 has no ChoiceModel attached", (Object)string);
            this.setDefaultColor(fArray);
            return;
        }
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)object;
        SelectedItem selectedItem = tiledListModelGUI.getSelected();
        if (selectedItem == null) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getColorFromListModelStub selectedItem is null");
            this.setDefaultColor(fArray);
            return;
        }
        int n2 = selectedItem.getIndex();
        GuiListRow guiListRow = tiledListModelGUI.getGuiRow(n2);
        if (guiListRow == null) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getColorFromListModelStub listModel has no selected row");
            this.setDefaultColor(fArray);
            return;
        }
        if (guiListRow.getColumnCount() < 3) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getColorFromListModelStub listModel for type %1 has not enough colums", (Object)string);
            this.setDefaultColor(fArray);
            return;
        }
        fArray[0] = (float)guiListRow.getInteger(0) / 32579;
        fArray[1] = (float)guiListRow.getInteger(1) / 32579;
        fArray[2] = (float)guiListRow.getInteger(2) / 32579;
    }

    private int getRange2DModelStubValue(int n, String string, int n2, int n3) {
        Object object = this.getModelStubModel(n);
        if (object == null) {
            this.logChannel3DCar.log(1078071040, "CarViewerController#getRange2DModelStubValue modelStub with type %1 not available", (Object)string);
            return n3;
        }
        if (object instanceof RangeModel2DGUI) {
            RangeModel2DGUI rangeModel2DGUI = (RangeModel2DGUI)object;
            if (n2 == 1) {
                return rangeModel2DGUI.getValueY();
            }
            return rangeModel2DGUI.getValueX();
        }
        if (object instanceof RangeModelGUI) {
            RangeModelGUI rangeModelGUI = (RangeModelGUI)object;
            return rangeModelGUI.getValue();
        }
        this.logChannel3DCar.log(-1601830656, "CarViewerController#getRange2DModelStubValue modelStub for type %1 has no RangeModel attached", (Object)string);
        return n3;
    }

    private int getRangeModelStubValue(int n, String string, int n2) {
        Object object = this.getModelStubModel(n);
        if (object == null) {
            this.logChannel3DCar.log(1078071040, "CarViewerController#getRangeModelStubValue modelStub with type %1 not available", (Object)string);
            return n2;
        }
        if (!(object instanceof RangeModelGUI)) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getRangeModelStubValue modelStub for type %1 has no ChoiceModel attached", (Object)string);
            return n2;
        }
        RangeModelGUI rangeModelGUI = (RangeModelGUI)object;
        return rangeModelGUI.getValue();
    }

    public IconController getVariantController() {
        return this.activeStandardIconController;
    }

    private void updateDriveSelectModels() {
        int n;
        boolean bl;
        int n2 = this.getChoiceModelStubValue(0, "selectedProfile");
        float f2 = (float)this.getChoiceModelStubValue(1, "pitch") / 8257;
        float f3 = (float)this.getChoiceModelStubValue(2, "roll") / 8257;
        int n3 = this.getChoiceModelStubValue(3, "pitch soft warning start");
        int n4 = this.getChoiceModelStubValue(4, "pitch hard warning start");
        int n5 = this.getChoiceModelStubValue(5, "pitch hard warning end");
        int n6 = this.getChoiceModelStubValue(6, "roll soft warning start");
        int n7 = this.getChoiceModelStubValue(7, "roll hard warning start");
        int n8 = this.getChoiceModelStubValue(8, "roll hard warning end");
        int n9 = this.getChoiceModelStubValue(12, "roll hard warning end orignal");
        int n10 = this.getChoiceModelStubValue(13, "roll hard warning orignal Angel");
        int n11 = this.getChoiceModelStubValue(14, "roll soft warning orignal Angel");
        if (n10 == 255) {
            n6 = n7;
        }
        if (n9 == 255) {
            n8 = 45;
            bl = n11 > n10;
            n7 = n8;
            if (bl || n11 == n10) {
                n6 = n7;
            } else if (n6 > 45) {
                n = n10 - n11;
                n6 = 45 - n;
            }
        }
        bl = this.getChoiceModelStubValue(9, "gyro visible") == 0;
        int n12 = n = n2 == 0 || n2 == 1 || n2 == 7 || n2 == 9 ? 1 : 0;
        if (this.phevAvailable) {
            n = n2 == 0 || n2 == 7 || n2 == 9 ? 1 : 0;
        }
        bl = bl && n != 0;
        boolean bl2 = this.getChoiceModelStubValue(10, "pitch angle visible") == 0;
        boolean bl3 = this.getChoiceModelStubValue(11, "roll angle visible") == 0;
        this.renderer.setDriveSelectValues(n2, f2, f3, n3, n4, n5, n6, n7, n8, bl, bl2, bl3);
    }

    private void updateDriveSelectPEHEVModels(boolean bl) {
        int n;
        int[] nArray = this.getListModelValues(15);
        if (nArray == null || nArray.length == 0) {
            return;
        }
        if (this.cachedPhevValues != null) {
            for (n = 0; n < nArray.length; ++n) {
                if (this.cachedPhevValues[n] == nArray[n]) continue;
                bl = true;
                break;
            }
            if (!bl) {
                return;
            }
        }
        n = nArray[0];
        int n2 = nArray[1];
        int n3 = nArray[2];
        int n4 = nArray[3];
        int n5 = nArray[4];
        int n6 = nArray[5];
        int n7 = nArray[6];
        this.cachedPhevValues = nArray;
        this.renderer.setDriveSelectPHEVValues(n, n2, n3, n4, n5, n6, n7);
    }

    private void updateUGDOModels() {
        int n = this.getChoiceModelStubValue(0, "MODELSTUB_UGDO");
        this.renderer.setUGDOMode(n);
    }

    private void updateAmbientLightModels() {
        if (this.ambientLightColor == null) {
            this.ambientLightColor = new float[4];
            this.setDefaultColor(this.ambientLightColor);
        }
        if (this.contourLightColor == null) {
            this.contourLightColor = new float[3];
            this.setDefaultColor(this.contourLightColor);
        }
        if (this.intlightBrightness == null) {
            this.intlightBrightness = new float[4];
            this.intlightBrightness[0] = 0.0f;
            this.intlightBrightness[1] = 0.0f;
            this.intlightBrightness[2] = 0.0f;
            this.intlightBrightness[3] = 0.0f;
        }
        int n = this.getRange2DModelStubValue(2, "intlight selected profile", 0, 0);
        int n2 = this.getRange2DModelStubValue(3, "intlight brightness", 1, 0);
        int n3 = 858989376 * (float)n2 / 32579;
        this.intlightBrightness[0] = n3;
        this.intlightBrightness[1] = n3;
        this.intlightBrightness[2] = n3;
        this.intlightBrightness[3] = n3;
        if (this.logChannel3DCar.isDebug()) {
            String string = new String(new StringBuffer().append("unmodified brigthness value from model: ").append(n2).append(" is scaled to intlightBrigthness: ").append((float)n3).toString());
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels %1", (Object)string);
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels Profile: %1", (long)n);
        }
        if (n == 1 || n == 0) {
            int n4;
            int n5 = 858989376 * (float)this.getRangeModelStubValue(3, "intlight brightness whole area", 0) / 32579;
            this.getColorFromListModelStub(0, this.contourLightColor, "intlight contour color list");
            this.getColorFromListModelStub(1, this.ambientLightColor, "intlight ambient color list");
            int n6 = this.getRangeModelStubValue(4, "intlight brightness Door", 0);
            this.intlightBrightness[0] = 858989376 * (float)n6 / 32579;
            int n7 = this.getRangeModelStubValue(5, "intlight brightness Footwell", 0);
            this.intlightBrightness[1] = 858989376 * (float)n7 / 32579;
            int n8 = this.getRangeModelStubValue(6, "intlight brightness Contour", 0);
            this.intlightBrightness[2] = 858989376 * (float)n8 / 32579;
            int n9 = this.getRangeModelStubValue(7, "intlight brightness Dash", 0);
            this.intlightBrightness[3] = 858989376 * (float)n9 / 32579;
            int n10 = this.getRangeModelStubValue(8, "intlight brightness surface (Door + front)", 0);
            int n11 = 858989376 * (float)n10 / 32579;
            int n12 = this.getChoiceModelStubValueForSurface(9, " is intlight brightness surface available");
            if (n12 == 0) {
                this.intlightBrightness[0] = n11;
                this.intlightBrightness[3] = n11;
            }
            if (this.logChannel3DCar.isDebug()) {
                String string = new String(new StringBuffer().append("Model(Door):").append(n6).append(" Model(Foot): ").append(n7).append(" Model(Contour): ").append(n8).append(" Model(Dash): ").append(n9).append(" Model(Surface): ").append(n10).toString());
                this.logChannel3DCar.log(-2137614336, "CarViewercontroller#updateAmbientLightModels individual model values: %1", (Object)string);
                String string2 = new String(new StringBuffer().append("Door: ").append(this.intlightBrightness[0]).append("Floor: ").append(this.intlightBrightness[1]).append("Contour: ").append(this.intlightBrightness[2]).append("Dash: ").append(this.intlightBrightness[3]).append("Surface: ").append((float)n11).toString());
                this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels IndividualArea values: %1", (Object)string2);
            }
            if (n5 != 0.0f && this.intlightBrightness[0] == 0.0f && this.intlightBrightness[1] == 0.0f && this.intlightBrightness[2] == 0.0f && this.intlightBrightness[3] == 0.0f) {
                this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels individual mainscreen-mode all zones ar set with allsetsync-model");
                this.intlightBrightness[0] = n5;
                this.intlightBrightness[1] = n5;
                this.intlightBrightness[2] = n5;
                this.intlightBrightness[3] = n5;
                this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels Individual values: %1", (double)n5);
            }
            if ((n4 = this.getChoiceModelStubValueForSurface(10, " ist front menu entry available")) == 0) {
                this.renderer.setAmbientLightPackage(1);
            } else {
                this.renderer.setAmbientLightPackage(2);
            }
        } else {
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels selected Profile %1 is not INDIVIDUAL use color-profiles instead.", (long)n);
            if (n < 0 || n >= AMBIENTLIGHT_FIXED_PROFILE_COLORS.length) {
                this.logChannel3DCar.log(-1601830656, "CarViewerController#updateAmbientLightModels: selected int light profile out of range (%1) -> using white", (long)n);
                this.ambientLightColor[0] = -252743873;
                this.ambientLightColor[1] = -50627777;
                this.ambientLightColor[2] = 1.0f;
                this.ambientLightColor[3] = 1.0f;
                this.contourLightColor[0] = -252743873;
                this.contourLightColor[1] = -50627777;
                this.contourLightColor[2] = 1.0f;
            } else {
                this.ambientLightColor[0] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][0] / 32579;
                this.ambientLightColor[1] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][1] / 32579;
                this.ambientLightColor[2] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][2] / 32579;
                this.ambientLightColor[3] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][3] / 32579;
                this.contourLightColor[0] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][3] / 32579;
                this.contourLightColor[1] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][4] / 32579;
                this.contourLightColor[2] = AMBIENTLIGHT_FIXED_PROFILE_COLORS[n][5] / 32579;
            }
            this.renderer.setAmbientLightPackage(2);
        }
        if (this.logChannel3DCar.isDebug()) {
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels these are the values given to the renderer.");
            String string = new String(new StringBuffer().append("R: ").append(this.ambientLightColor[0]).append("G: ").append(this.ambientLightColor[1]).append("B: ").append(this.ambientLightColor[2]).toString());
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels ambient light color values: %1", (Object)string);
            String string3 = new String(new StringBuffer().append("R: ").append(this.contourLightColor[0]).append("G: ").append(this.contourLightColor[1]).append("B: ").append(this.contourLightColor[2]).toString());
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels contour light color values: %1", (Object)string3);
            String string4 = new String(new StringBuffer().append("Door: ").append(this.intlightBrightness[0]).append("Floor: ").append(this.intlightBrightness[1]).append("Contour: ").append(this.intlightBrightness[2]).append("Dash: ").append(this.intlightBrightness[3]).toString());
            this.logChannel3DCar.log(-2137614336, "CarViewerController#updateAmbientLightModels intlightBrightness values: %1", (Object)string4);
        }
        this.renderer.setAmbientLightValues(this.ambientLightColor, this.contourLightColor, this.intlightBrightness);
    }

    private int getChoiceModelStubValueForSurface(int n, String string) {
        Object object = this.getModelStubModel(n);
        if (object == null) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getChoiceModelStubValue modelStub with for type %1 not available", (Object)string);
            return 1;
        }
        if (!(object instanceof ChoiceModelGUI)) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#getChoiceModelStubValue modelStub for type %1 has no ChoiceModel attached", (Object)string);
            return 1;
        }
        return ((ChoiceModelGUI)object).getValue();
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateCarStubValues();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void setRendererDDBOpen() {
        if (this.renderer != null) {
            this.renderer.setDriveSelectDDBOpen(this.ddbOpen);
        }
    }

    public void setDdbOpen(boolean bl) {
        this.ddbOpen = bl;
    }

    @Override
    public void predisconnecting() {
        super.predisconnecting();
        this.connected = false;
        this.setOnScreen(false);
        this.setRendererVisible(false);
        this.terminal.getDrawerFocusManager().unregisterDrawerAnimationListener(this);
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (this.renderer != null) {
            this.renderer.setSmallStagePositionPercentage(fArray[0]);
        }
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (this.renderer != null) {
            int n;
            int n2 = n = fArray[0] > 63 ? 1 : 0;
            if (n != lastFinishedStage) {
                this.renderer.setViewSizeAnimationFinished(n);
                lastFinishedStage = n;
            }
        }
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
        if (this.viewSizeAnimationRunning) {
            this.viewSizeAnimationStarted(0.0f, fArray, fArray2);
        }
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
        if (this.renderer != null) {
            int n;
            int n2 = n = fArray2[0] > 63 ? 1 : 0;
            if (n != lastStage) {
                this.viewSizeAnimationRunning = true;
                this.renderer.setViewSizeTargetChanged(n, true);
                lastStage = n;
            }
        }
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof CarViewerController) {
            this.isWrapperController = true;
            this.internalCarViewerController = (CarViewerController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof LabelController) {
            this.checkRoleIsEmpty(n, abstractWidget);
            switch (n) {
                case 2: {
                    this.pitchText = abstractWidget;
                    break;
                }
                case 3: {
                    this.pitchDegreeText = abstractWidget;
                    break;
                }
                case 0: {
                    this.rollText = abstractWidget;
                    break;
                }
                case 1: {
                    this.rollDegreeText = abstractWidget;
                    break;
                }
                default: {
                    this.logChannel3DCar.log(-1601830656, "CarViewerController#add: unknown role %2 for child widget %1", (Object)abstractWidget, (long)n);
                    break;
                }
            }
        } else {
            abstractWidget.setVisible(false);
            if (abstractWidget instanceof IconController) {
                if (!this.standardVariantIconControllers.containsKey(Util.createInteger(n))) {
                    this.standardVariantIconControllers.put(Util.createInteger(n), (IconController)abstractWidget);
                } else if (CarViewerController.isRightHandDrive()) {
                    this.standardVariantIconControllers.put(Util.createInteger(n), (IconController)abstractWidget);
                    this.logChannel3DCar.log(-2137614336, "CarViewerController#add: IconController for role %1 already defined, now overwriting with RHD IconController.", (long)n);
                }
            } else {
                this.logChannel3DCar.log(-1601830656, "CarViewerController#add: specified wrong type %1 for car variant %2", (Object)abstractWidget, (long)n);
            }
        }
        super.add(abstractWidget);
    }

    private void checkRoleIsEmpty(int n, AbstractWidget abstractWidget) {
        AbstractWidget abstractWidget2 = this.getChildOfRole(n);
        if (abstractWidget2 != null) {
            this.logChannel3DCar.log(-1601830656, "CarViewerController#add: two children with same role: %3, old child: %1, new child: %2", (Object)abstractWidget2, (Object)abstractWidget, (long)n);
        }
    }

    public AbstractWidget getChildOfRole(int n) {
        switch (n) {
            case 2: {
                return this.pitchText;
            }
            case 3: {
                return this.pitchDegreeText;
            }
            case 0: {
                return this.rollText;
            }
            case 1: {
                return this.rollDegreeText;
            }
        }
        this.logChannel3DCar.log(-1601830656, "CarViewerController#getChildOfRole: unknown role: %1", (long)n);
        return null;
    }

    @Override
    public void remove(AbstractWidget abstractWidget) {
        super.remove(abstractWidget);
        if (Util.equals(abstractWidget, this.pitchText)) {
            this.pitchText = null;
        }
        if (Util.equals(abstractWidget, this.pitchDegreeText)) {
            this.pitchDegreeText = null;
        }
        if (Util.equals(abstractWidget, this.rollText)) {
            this.rollText = null;
        }
        if (Util.equals(abstractWidget, this.rollDegreeText)) {
            this.rollDegreeText = null;
        }
    }

    private void setCarDesaturation(float f2) {
        if (this.desaturation != f2) {
            this.setCompositesDirty(true);
            this.desaturation = f2;
        }
    }

    public float getDesaturation() {
        return this.desaturation;
    }

    private void setCarTranslation(float f2, float f3) {
        if (this.transX != f2 && this.transY != f3) {
            this.setCompositesDirty(true);
            this.transX = f2;
            this.transY = f3;
        }
    }

    public float getScale() {
        return this.scale;
    }

    private void setCarScale(float f2) {
        if (this.scale != f2) {
            this.setCompositesDirty(true);
            this.scale = f2;
        }
    }

    public float getTransX() {
        return this.transX;
    }

    public float getTransY() {
        return this.transY;
    }

    private void updateCarTransformation() {
        if (this.carAreaParent == null) {
            this.logChannel3DCar.log(-2137614336, "CarViewerController#setDrawerAnimation: carAreaParent is null");
            return;
        }
        this.carAreaTransform.resetToIdentityTransformation().combine(this.carAreaParent.getSelectionDrawerTransformation()).combine(this.carAreaParent.getOptionDrawerTransformation()).combine(this.carAreaParent.getEntertainmentDrawerTransformation());
        if (!this.ignoreScreenChangeTransformation) {
            this.carAreaTransform.combine(this.carAreaParent.getCurrentScreenChangeTransformation());
        }
        if (!this.getTerminalImpl().getFramework().getLanguageMgr().isLeftToRightOrientation()) {
            float f2 = this.carAreaTransform.getTransX();
            if (f2 > 0.0f) {
                this.carAreaTransform.move(f2 * -1883081282, 0.0f, 0.0f);
            } else {
                this.carAreaTransform.move(f2 * 41025, 0.0f, 0.0f);
            }
        }
        this.setCarTranslation(this.carAreaTransform.getTransX(), this.carAreaTransform.getTransY());
        this.setCarScale(this.carAreaTransform.getScale());
    }

    @Override
    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        this.setDrawerAnimation(fArray, fArray2, this.getDrawerAnimationMask());
    }

    @Override
    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    @Override
    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        if (DrawerAnimationManager$Helper.hasFlag(n, 0) || DrawerAnimationManager$Helper.hasFlag(n, 2) || DrawerAnimationManager$Helper.hasFlag(n, 4) || DrawerAnimationManager$Helper.hasFlag(n, 12)) {
            this.updateCarTransformation();
            float f2 = Math.max(fArray[0], fArray[2]);
            if (!this.ignoreScreenChangeTransformation) {
                f2 = Math.max(f2, fArray[12]);
            }
            float f3 = 1.0f - f2;
            if (this.currentMode == 1) {
                float f4 = Math.max(f3, this.carAreaTransform.getOpacity());
                this.setOpacity(f4);
            } else {
                this.setOpacity(f3);
            }
        }
        if (DrawerAnimationManager$Helper.hasFlag(n, 11)) {
            this.setCarDesaturation(fArray[11]);
        }
    }

    @Override
    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        if (DrawerAnimationManager$Helper.hasFlag(n, 12)) {
            this.renderer.stopAnimations();
        }
        this.setDrawerAnimation(fArray, fArray2, n);
    }

    @Override
    public int getDrawerAnimationMask() {
        return 6165;
    }

    @Override
    public String getWidgetName() {
        return this.getClassName();
    }

    @Override
    public void mergeFinished(String string) {
        this.logChannel3DCar.log(-2137614336, "CarViewerController#updateCarViewerAfterKZBMerge: carKZB merged finished. CarModels will updating now.");
        this.updateCarStubValues();
    }

    @Override
    public boolean isConnected() {
        return this.connected;
    }

    public void setConnected(boolean bl) {
        this.connected = bl;
    }

    public void setViewSizeAnimationReallyFinished(float[] fArray, boolean bl) {
        this.viewSizeAnimationRunning = false;
    }

    @Override
    public void setIgnoreScreenChangeTransformation(boolean bl) {
        this.ignoreScreenChangeTransformation = bl;
    }

    static {
        DEFAULT_COLOR = new float[]{1.0f, 1.0f, 1.0f};
        lastStage = -1;
        lastFinishedStage = -1;
    }
}

