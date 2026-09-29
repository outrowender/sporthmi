/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.Preset;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetInputHandler;
import de.eso.widgets.preset.PresetLayoutConfigurator;
import de.eso.widgets.preset.PresetManager;
import de.eso.widgets.preset.PresetStorageProvider;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PresetPopupHeadlineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PresetController
extends PartialPopupController
implements CacheEventListener {
    private static final int DEFAULT_ICON_WIDTH;
    private static LogChannel lc;
    private static final int INDENTION;
    private static final int ENTRY_STORED;
    private static final int ENTRY_NEW;
    public static final int LAYOUT_INDEX_A_STORED;
    public static final int LAYOUT_INDEX_A_NEW;
    public static final int LAYOUT_INDEX_B_STORED;
    public static final int LAYOUT_INDEX_B_NEW;
    public static final int LAYOUT_INDEX_C_STORED;
    public static final int LAYOUT_INDEX_C_NEW;
    public static final int LAYOUT_INDEX_D_STORED;
    public static final int LAYOUT_INDEX_D_NEW;
    public static final int LAYOUT_INDEX_E_STORED;
    public static final int LAYOUT_INDEX_E_NEW;
    public static final int LAYOUT_INDEX_F_STORED;
    public static final int LAYOUT_INDEX_F_NEW;
    public static final int LAYOUT_INDEX_G_STORED;
    public static final int LAYOUT_INDEX_G_NEW;
    public static final int LAYOUT_INDEX_NO_ENTRY_STORED;
    public static final int LAYOUT_INDEX_NOT_STORABLE;
    public static final int LAYOUT_INDEX_NOT_STORABLE_MAIN_ENTRY;
    public static final int LAYOUT_INDEX_NO_APP_REGISTRED;
    private PresetPopupHeadlineController presetPopupHeadline;
    private ArrayList presetContentContainers = new ArrayList(20);
    private PartialPopupGlassplateController glassPlate = null;
    private PresetManager presetMngr;
    private ProgressBarController progressBar;
    private static PresetLayoutConfigurator layoutConfigurator;
    private LayoutContainerController notStorableContainer;
    private static final String[] PRESET_SERVICE_ID;
    private boolean isManualGearshiftControl;

    public PresetController(int n) {
        super(n);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.presetMngr = ((PresetInputHandler)this.terminal.getPresetPopupHandler()).getPresetManager();
        if (this.presetMngr == null) {
            lc.log(10000, "PresetController#initializeWidget presetMngr == null");
        }
        this.registerAtAndReadLayoutCache(framework);
        this.initializeLayout(this.isManualGearshiftControl);
        this.setIconTypes();
    }

    private void registerAtAndReadLayoutCache(IFrameworkAccess iFrameworkAccess) {
        CacheHandler cacheHandler = iFrameworkAccess.getCacheHandler();
        if (cacheHandler != null) {
            cacheHandler.addListener(this);
            Object object = cacheHandler.getState(PRESET_SERVICE_ID[0], PRESET_SERVICE_ID[0]);
            if (object instanceof Boolean) {
                this.isManualGearshiftControl = (Boolean)object;
                lc.log(1078071040, "PresetController#registerAtAndReadLayoutCache isManualGearshiftControl == %1", this.isManualGearshiftControl);
            }
        }
    }

    public void activateGlowOnActivePreset() {
        this.presetPopupHeadline.activateGlowOnActivePreset();
        this.presetPopupHeadline.setCompositesDirty(true);
        this.presetPopupHeadline.triggerRepaint();
    }

    public void deactivateGlowOnActivePreset() {
        this.presetPopupHeadline.deactivateGlowOnActivePreset();
        this.presetPopupHeadline.triggerRepaint();
    }

    public void presetTouched(int n) {
        if (this.isConnected()) {
            lc.log(-2137614336, "PresetController#presetTouched presetIndex=%1", (long)n);
            PresetStorageProvider presetStorageProvider = this.presetMngr.getPresetStorageProvider();
            IPresetPopupData iPresetPopupData = presetStorageProvider.getPersistedPresetPopupData(n);
            if (iPresetPopupData == null || iPresetPopupData.getPreset() == null) {
                Buffer buffer = new Buffer();
                buffer.append("PresetController#presetTouched ");
                buffer.append("presetIndex: ").append(n);
                buffer.append(", ppDataStoredEntry: ").append(iPresetPopupData);
                buffer.append(", preset: ").append(iPresetPopupData == null ? null : iPresetPopupData.getPreset());
                lc.log(10000, buffer.toString());
                iPresetPopupData = presetStorageProvider.getNoEntryStoredPresetPopupData();
            }
            this.presetPopupHeadline.setFocusedPreset(n, iPresetPopupData.getCursorColor(), iPresetPopupData.getPreset().getIconType());
            if (this.getGlassPlate() != null) {
                this.getGlassPlate().setSeparatorVisible(false);
                this.getGlassPlate().setBounds(0, 0, this.width, layoutConfigurator.getGlassplateHeightTouch());
            }
            this.hideAllContentContainers();
            this.showStoredContentLayout(n);
            this.triggerRepaint();
            this.terminal.getDrawerFocusManager().getPresetPopupData();
        }
    }

    public void presetLongTouched(int n) {
        if (this.isConnected()) {
            lc.log(-2137614336, "PresetController#presetLongTouched presetIndex=%1", (long)n);
            IPresetPopupData iPresetPopupData = this.presetMngr.getPresetStorageProvider().getPersistedPresetPopupData(n);
            if (iPresetPopupData == null || iPresetPopupData.getPreset() == null) {
                Buffer buffer = new Buffer();
                buffer.append("PresetController#presetLongTouched");
                buffer.append("presetIndex: ").append(n);
                buffer.append(", ppDataStoredEntry: ").append(iPresetPopupData);
                buffer.append(", preset: ").append(iPresetPopupData == null ? null : iPresetPopupData.getPreset());
                lc.log(10000, buffer.toString());
                iPresetPopupData = this.presetMngr.getPresetStorageProvider().getNotStorablePopupData();
            }
            this.presetPopupHeadline.setFocusedPreset(n, iPresetPopupData.getCursorColor(), iPresetPopupData.getPreset().getIconType());
            if (this.getGlassPlate() != null) {
                this.getGlassPlate().setSeparatorVisible(true);
                this.getGlassPlate().setBounds(0, 0, this.width, layoutConfigurator.getGlassplateHeightLongTouch());
            }
            this.hideAllContentContainers();
            this.showStoredContentLayout(n);
            this.showDefinedContentLayout(n);
            this.setStoreProgressbarValue(0.0f);
            this.triggerRepaint();
        }
    }

    private void showStoredContentLayout(int n) {
        IPresetPopupData iPresetPopupData = this.presetMngr.updatePreviewIfOnlinePreset(n);
        this.setContainerLayout(iPresetPopupData, 0);
    }

    private void showDefinedContentLayout(int n) {
        this.setContainerLayout(this.presetMngr.getPresetStorageProvider().getPresetPopupDataToStore(n), 1);
    }

    private void configureProgressBar(LayoutContainerController layoutContainerController) {
        List list = layoutContainerController.getChildren();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof ProgressBarController)) continue;
            this.progressBar = (ProgressBarController)object;
        }
    }

    public void setStoreProgressbarValue(float f2) {
        if (this.progressBar != null) {
            if (f2 == 0.0f) {
                this.progressBar.setVisible(false);
            } else {
                this.progressBar.setVisible(true);
            }
            this.progressBar.setProgress(f2);
            this.progressBar.setCompositesDirty(true);
            this.progressBar.triggerRepaint();
        }
    }

    private void configureLayoutStored(LayoutContainerController layoutContainerController, IPresetPopupData iPresetPopupData) {
        this.setMainLabel(layoutContainerController, iPresetPopupData);
        this.setSubLabel(layoutContainerController, iPresetPopupData);
        hmiService.getChoiceModel(4128).setValue(iPresetPopupData.getPreset().getIconType());
        List list = layoutContainerController.getChildren();
        IconController iconController = (IconController)list.get(1);
        iconController.updateContent();
        if (iPresetPopupData.getPreset().getExecutionType() == 3 && iPresetPopupData.getPreset().getPreview() != null) {
            int n = 0;
            try {
                n = iPresetPopupData.getPreset().getPreview().getSubIconIndex();
            }
            catch (Exception exception) {
                lc.log(10000, "PresetController#configureLayoutStored subIcon not set for EXECUTION_TYPE_TELEPHONE");
            }
            hmiService.getChoiceModel(4351).setValue(n);
            IconController iconController2 = (IconController)list.get(3);
            if (iconController2 != null) {
                iconController2.updateContent();
            }
        }
    }

    private void configureLayoutNew(LayoutContainerController layoutContainerController, IPresetPopupData iPresetPopupData) {
        hmiService.getChoiceModel(4127).setValue(iPresetPopupData.getPreset().getIconType());
        List list = layoutContainerController.getChildren();
        IconController iconController = (IconController)list.get(1);
        iconController.updateContent();
        this.setMainLabel(layoutContainerController, iPresetPopupData);
        hmiService.getChoiceModel(4129).setValue(1);
    }

    private LayoutContainerController setContainerLayout(IPresetPopupData iPresetPopupData, int n) {
        int n2 = iPresetPopupData.getLayoutType();
        LayoutContainerController layoutContainerController = null;
        int n3 = 0;
        if (n == 0) {
            switch (n2) {
                case 0: {
                    n3 = iPresetPopupData.getPreset().getExecutionType() == 3 ? 2 : 0;
                    layoutContainerController = (LayoutContainerController)this.presetContentContainers.get(n3);
                    this.configureLayoutStored(layoutContainerController, iPresetPopupData);
                    break;
                }
                case 1: {
                    n3 = 2;
                    break;
                }
                case 2: {
                    n3 = 4;
                    break;
                }
                case 3: {
                    n3 = 6;
                    break;
                }
                case 4: {
                    n3 = 8;
                    break;
                }
                case 5: {
                    n3 = 10;
                    break;
                }
                case 7: {
                    n3 = 14;
                    break;
                }
                default: {
                    lc.log(-1601830656, "PresetPopupController#getCurrentContainerLayout for ENTRY_STORED. Unknown layoutType: %1 for stored entry - return layout no entry stored instead", (Object)iPresetPopupData);
                    n3 = 14;
                    break;
                }
            }
        } else {
            switch (n2) {
                case 0: {
                    n3 = 1;
                    layoutContainerController = (LayoutContainerController)this.presetContentContainers.get(n3);
                    this.configureProgressBar(layoutContainerController);
                    this.configureLayoutNew(layoutContainerController, iPresetPopupData);
                    break;
                }
                case 1: {
                    n3 = 3;
                    break;
                }
                case 2: {
                    n3 = 5;
                    break;
                }
                case 3: {
                    n3 = 7;
                    break;
                }
                case 4: {
                    n3 = 9;
                    break;
                }
                case 5: {
                    n3 = 11;
                    break;
                }
                case 8: {
                    n3 = 15;
                    this.configNotStorableContainer(hmiService.getText(3051));
                    layoutContainerController = this.notStorableContainer;
                    break;
                }
                case 9: {
                    n3 = 16;
                    int n4 = -1;
                    ChoiceModelApp choiceModelApp = hmiService.getChoiceModel(8);
                    if (choiceModelApp != null) {
                        n4 = choiceModelApp.getValue();
                    }
                    int n5 = 3051;
                    if (n4 == 4) {
                        n5 = 3053;
                    } else if (n4 == 5) {
                        n5 = 3052;
                    }
                    this.configNotStorableContainer(hmiService.getText(n5));
                    layoutContainerController = this.notStorableContainer;
                    break;
                }
                case 7: {
                    lc.log(10000, "PresetPopupController#getCurrentContainerLayout for NEW_ENTRY. Layout NOT_ENTRY_STORED cannot be the layout of a NEW entry. LayoutType: %1 - return layout NOT_STORABLE instead", (Object)iPresetPopupData);
                    n3 = 15;
                    break;
                }
                case 10: {
                    n3 = 17;
                    break;
                }
                default: {
                    lc.log(10000, "PresetPopupController#getCurrentContainerLayout for NEW_ENTRY. Unknown layoutType: %1 for new entry - return layout entry not storable instead", (Object)iPresetPopupData);
                    n3 = 15;
                }
            }
        }
        if (layoutContainerController == null) {
            layoutContainerController = (LayoutContainerController)this.presetContentContainers.get(n3);
        }
        layoutContainerController.setWidth(this.width - 35);
        this.setMaxWidthForMainLabelCell(layoutContainerController);
        layoutContainerController.setVisible(true);
        return layoutContainerController;
    }

    private void setMaxWidthForMainLabelCell(LayoutContainerController layoutContainerController) {
        LayoutManager layoutManager = layoutContainerController.getLayoutManager();
        if (layoutManager instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout)layoutManager;
            AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
            int n = 0;
            if (axisConstraints.gaps != null) {
                for (int i2 = 0; i2 < axisConstraints.gaps.length - 1; ++i2) {
                    n += axisConstraints.gaps[i2];
                }
            }
            List list = layoutContainerController.getChildren();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (!(object instanceof IconController)) continue;
                n += 30;
            }
            int n2 = axisConstraints.getLength();
            int n3 = layoutContainerController.getWidth() - n;
            switch (n2) {
                case 2: {
                    axisConstraints.max = new int[]{-1, n3};
                    break;
                }
                case 3: {
                    axisConstraints.max = new int[]{-1, -1, n3};
                    break;
                }
            }
        }
    }

    private void configNotStorableContainer(String string) {
        if (this.notStorableContainer == null) {
            this.notStorableContainer = this.presetMngr.getPresetLayoutFactory().getNotStorableContainer();
            this.add(this.notStorableContainer);
        }
        List list = this.notStorableContainer.getChildren();
        LabelController labelController = (LabelController)list.get(0);
        labelController.setText(string);
    }

    private void setMainLabel(LayoutContainerController layoutContainerController, IPresetPopupData iPresetPopupData) {
        List list = layoutContainerController.getChildren();
        LabelController labelController = (LabelController)list.get(0);
        Preset preset = iPresetPopupData.getPreset();
        if (preset != null && preset.getPreview() != null) {
            labelController.setModel(iPresetPopupData.getPreset().getPreview().getMainLabel());
        } else {
            labelController.setModel("");
        }
        labelController.updateContent();
    }

    private void setSubLabel(LayoutContainerController layoutContainerController, IPresetPopupData iPresetPopupData) {
        List list = layoutContainerController.getChildren();
        LabelController labelController = (LabelController)list.get(2);
        Preset preset = iPresetPopupData.getPreset();
        if (preset != null && preset.getPreview() != null) {
            labelController.setModel(iPresetPopupData.getPreset().getPreview().getSubLabel());
        } else {
            labelController.setModel("<Sub Label>");
        }
        labelController.updateContent();
    }

    public void initializeLayout(boolean bl) {
        int n = this.terminal.getKbdService().getCurrentKeyboardType();
        int n2 = this.calculatePresetLayout(bl);
        if (layoutConfigurator == null) {
            layoutConfigurator = new PresetLayoutConfigurator();
        }
        layoutConfigurator.init(n, n2);
        this.x = layoutConfigurator.getX();
        this.y = layoutConfigurator.getY();
        this.width = layoutConfigurator.getWidth();
        this.setBounds(this.x, this.y, this.width, this.height);
        this.presetPopupHeadline.setX(layoutConfigurator.getHeadlineX());
        this.presetPopupHeadline.setY(layoutConfigurator.getHeadlineY());
        this.presetPopupHeadline.setTemplateNodePath(layoutConfigurator.getTemplateNodePath());
    }

    private int calculatePresetLayout(boolean bl) {
        ICarCodingHelper iCarCodingHelper = this.terminal.getCarCodingHelper();
        int n = iCarCodingHelper.isB9() ? (bl ? 8 : 1) : (iCarCodingHelper.isQ5() ? (bl ? 8 : 3) : 3);
        return n;
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof LayoutContainerController) {
            this.presetContentContainers.add(abstractWidget);
        } else if (abstractWidget instanceof PresetPopupHeadlineController) {
            this.presetPopupHeadline = (PresetPopupHeadlineController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    public PartialPopupGlassplateController getGlassPlate() {
        if (this.glassPlate == null && this.backgroundController instanceof PartialPopupGlassplateController) {
            this.glassPlate = (PartialPopupGlassplateController)this.backgroundController;
        }
        return this.glassPlate;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (this.getRenderer() != null) {
            this.getRenderer().render(redrawContext);
        }
    }

    @Override
    public int show(int n) {
        int n2 = super.show(n);
        if (n2 == 1) {
            this.notifyPresetPopupManager(true);
        }
        return n2;
    }

    @Override
    public int hide(int n) {
        int n2 = super.hide(n);
        if (n2 == 1) {
            this.notifyPresetPopupManager(false);
        }
        return n2;
    }

    public void setIconTypes() {
        if (this.presetPopupHeadline != null && this.presetMngr != null) {
            this.presetPopupHeadline.setSavedIconTypes(this.presetMngr.getPresetStorageProvider().getSavedIconTypes());
        }
    }

    private void hideAllContentContainers() {
        int n = this.presetContentContainers.size();
        for (int i2 = 0; i2 < n; ++i2) {
            ((LayoutContainerController)this.presetContentContainers.get(i2)).setVisible(false);
        }
    }

    private void notifyPresetPopupManager(boolean bl) {
        IPresetInputHandler iPresetInputHandler = this.terminal.getPresetPopupHandler();
        if (iPresetInputHandler != null) {
            iPresetInputHandler.presetPopupVisible(bl);
        }
    }

    @Override
    public String[] getServiceIDs() {
        return PRESET_SERVICE_ID;
    }

    @Override
    public String[] getTokens(String string) {
        return PRESET_SERVICE_ID;
    }

    @Override
    public void updateToken(String string, String string2, Object object) {
        boolean bl;
        if (string.equals(PRESET_SERVICE_ID[0]) && string2.equals(PRESET_SERVICE_ID[0]) && object instanceof Boolean && this.isManualGearshiftControl != (bl = ((Boolean)object).booleanValue())) {
            this.isManualGearshiftControl = bl;
            this.initializeLayout(this.isManualGearshiftControl);
            this.presetPopupHeadline.resetTemplateNode();
            lc.log(1078071040, "PresetController#updateToken PresetLayout has changed! isManualGearshiftControl == %1", this.isManualGearshiftControl);
        }
    }

    static {
        lc = IWidgetLogChannel.logPreset;
        PRESET_SERVICE_ID = new String[]{"service_dsi_presetlayout"};
    }
}

