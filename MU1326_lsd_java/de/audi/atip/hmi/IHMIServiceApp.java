/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.BrowserModelApp;
import de.audi.atip.hmi.modelaccess.BufferedFolderListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DataModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.FastScrollingModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.IPSpellerModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SlidingListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;

public interface IHMIServiceApp {
    public static final int MODULE_DIVISOR;
    public static final int CONTEXT_HMI;
    public static final int CONTEXT_HMI_TV;
    public static final int CONTEXT_HMI_DVD_VIDEO;
    public static final int CONTEXT_HMI_REARVIEW_CAMERA;
    public static final int CONTEXT_HMI_BROWSER;
    public static final int CONTEXT_HMI_SPLASH_SCREEN;
    public static final int CONTEXT_HMI_AUX_AV;
    public static final int CONTEXT_HMI_EXTERNAL_DVD_VIDEO;
    public static final int CONTEXT_HMI_FILE_BASED_VIDEO;
    public static final int CONTEXT_HMI_COVERFLOW;
    public static final int CONTEXT_HMI_MAP_VIEWER;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION_3D;
    public static final int CONTEXT_HMI_MAP_VIEWER_JUNCTION;
    public static final int CONTEXT_HMI_MAP_VIEWER_RG;
    public static final int CONTEXT_HMI_MAP_VIEWER_LANDMARK;
    public static final int CONTEXT_HMI_GE;
    public static final int CONTEXT_HMI_GE_INTERSECTION;
    public static final int CONTEXT_HMI_GE_INTERSECTION_3D;
    public static final int CONTEXT_HMI_GE_JUNCTION;
    public static final int CONTEXT_HMI_GE_RGS;
    public static final int CONTEXT_HMI_GE_LANDMARK;
    public static final int CONTEXT_HMI_MAP_VIEWER_RG_JUNCTION;
    public static final int CONTEXT_HMI_TV_VIDEOTEXT;
    public static final int CONTEXT_HMI_3D_ENGINE;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_1;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_2;
    public static final int CONTEXT_HMI_COVERFLOW_MAP_VIEWER;
    public static final int CONTEXT_HMI_COVERFLOW_GE_MAP_VIEWER;
    public static final int CONTEXT_HMI_MAP_IN_MAP;
    public static final int CONTEXT_HMI_GE_MAP_IN_MAP;
    public static final int CONTEXT_HMI_STREETVIEW;
    public static final int CONTEXT_HMI_VIEWER_INTERSECTION;
    public static final int CONTEXT_HMI_COVERFLOW_PICTURE;
    public static final int CONTEXT_HMI_TERMINAL_2;
    public static final int CONTEXT_HMI_TV_TERMINAL_2;
    public static final int CONTEXT_HMI_DVD_VIDEO_TERMINAL_2;
    public static final int CONTEXT_HMI_REARVIEW_CAMERA_TERMINAL_2;
    public static final int CONTEXT_HMI_BROWSER_TERMINAL_2;
    public static final int CONTEXT_HMI_SPLASH_SCREEN_TERMINAL_2;
    public static final int CONTEXT_HMI_AUX_AV_TERMINAL_2;
    public static final int CONTEXT_HMI_EXTERNAL_DVD_VIDEO_TERMINAL_2;
    public static final int CONTEXT_HMI_FILE_BASED_VIDEO_TERMINAL_2;
    public static final int CONTEXT_HMI_COVERFLOW_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_VIEWER_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION_3D_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_VIEWER_JUNCTION_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_VIEWER_RGS_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_VIEWER_LANDMARK_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_INTERSECTION_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_INTERSECTION_3D_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_JUNCTION_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_RGS_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_LANDMARK_TERMINAL_2;
    public static final int CONTEXT_HMI_TV_VIDEOTEXT_TERMINAL_2;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_1_TERMINAL_2;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_2_TERMINAL_2;
    public static final int CONTEXT_HMI_COVERFLOW_MAP_VIEWER_TERMINAL_2;
    public static final int CONTEXT_HMI_COVERFLOW_GE_MAP_VIEWER_TERMINAL_2;
    public static final int CONTEXT_HMI_MAP_IN_MAP_TERMINAL_2;
    public static final int CONTEXT_HMI_GE_MAP_IN_MAP_TERMINAL_2;
    public static final int CONTEXT_HMI_STREETVIEW_TERMINAL_2;
    public static final int CONTEXT_HMI_STREETVIEW_MAP_IN_MAP_TERMINAL_2;
    public static final int CONTEXT_HMI_VIEWER_INTERSECTION_TERMINAL_2;
    public static final int CONTEXT_TV_ONLY;
    public static final int CONTEXT_DVD_VIDEO_ONLY;
    public static final int CONTEXT_EXTERNAL_DVD_VIDEO_ONLY;
    public static final int CONTEXT_FILE_BASED_VIDEO_ONLY;
    public static final int CONTEXT_AUX_AV_ONLY;
    public static final int CONTEXT_KOMBI_MAP;
    public static final int CONTEXT_KOMBI_KDK;
    public static final int CONTEXT_KOMBI_MAP_KDK;
    public static final int CONTEXT_KOMBI_EMPTY_CONTEXT;
    public static final int CONTEXT_KOMBI_MAP_GE;
    public static final int CONTEXT_KOMBI_MAP_GE_KDK;
    public static final int CONTEXT_HMI_EXTERNAL_SMARTPHONE;
    public static final int MAX_CONTEXTS;

    default public HMIModelApp getModelApp(int n) {
    }

    default public HMIModelApp getModelApp(int n, int n2) {
    }

    default public ChoiceModelApp getChoiceModel(int n) {
    }

    default public ChoiceModelApp getChoiceModel(int n, int n2) {
    }

    default public TextEditorModelApp getTextEditorModel(int n) {
    }

    default public TextEditorModelApp getTextEditorModel(int n, int n2) {
    }

    default public TextEditorModelDDApp getTextEditorModelDD(int n) {
    }

    default public TextEditorModelDDApp getTextEditorModelDD(int n, int n2) {
    }

    default public ButtonModelApp getButtonModel(int n) {
    }

    default public OptionModelApp getOptionModel(int n) {
    }

    default public ButtonModelApp getButtonModel(int n, int n2) {
    }

    default public LabelModelApp getLabelModel(int n) {
    }

    default public LabelModelApp getLabelModel(int n, int n2) {
    }

    default public MetricsModelApp getMetricsModel(int n) {
    }

    default public MetricsModelApp getMetricsModel(int n, int n2) {
    }

    default public ListModelApp getListModel(int n) {
    }

    default public BaseListModelApp getBaseListModel(int n) {
    }

    default public TiledListModelApp getTiledListModel(int n) {
    }

    default public ListModelApp getListModel(int n, int n2) {
    }

    default public RangeModelApp getRangeModel(int n) {
    }

    default public RangeModelApp getRangeModel(int n, int n2) {
    }

    default public IPSpellerModelApp getIPSpellerModel(int n) {
    }

    default public IPSpellerModelApp getIPSpellerModel(int n, int n2) {
    }

    default public SpellerModelApp getSpellerModel(int n) {
    }

    default public SpellerModelApp getSpellerModel(int n, int n2) {
    }

    default public MatchspellerModelApp getMatchSpellerModel(int n) {
    }

    default public SlidingListModelApp getSlidingListModel(int n) {
    }

    default public TooltipModelApp getTooltipModel(int n) {
    }

    default public TooltipModelApp getTooltipModel(int n, int n2) {
    }

    default public TextfieldModelApp getTextfieldModel(int n) {
    }

    default public DynamicListModelApp getDynamicListModel(int n) {
    }

    default public DynamicListModelApp getDynamicListModel(int n, int n2) {
    }

    default public ResourceLocatorModelApp getResourceLocatorModel(int n) {
    }

    default public ResourceLocatorModelApp getResourceLocatorModel(int n, int n2) {
    }

    default public FastScrollingModelApp getFastScrollingModel(int n) {
    }

    default public VirtualButtonModelApp getVirtualButtonModel(int n) {
    }

    default public BufferedFolderListModelApp getBufferedFolderListModel(int n) {
    }

    default public BufferedFolderListModelApp getBufferedFolderListModel(int n, int n2) {
    }

    default public BrowserModelApp getBrowserModel(int n) {
    }

    default public DataModelApp getDataModel(int n) {
    }

    default public MenuModelApp getMenuModel(int n) {
    }

    default public PropertyModelApp getPropertyModel(int n) {
    }

    default public PropertyModelApp getPropertyModel(int n, int n2) {
    }

    default public String getText(int n) {
    }

    default public String getText(int n, int n2) {
    }

    default public void showPopup(int n) {
    }

    default public void showPopup(int n, int n2) {
    }

    default public void removePopup(int n) {
    }

    default public void removePopup(int n, int n2) {
    }

    default public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    default public boolean removeCurrentPopup(int n) {
    }

    default public int getCurrentPopup() {
    }

    default public int getCurrentPopup(int n) {
    }

    default public int getCurrentPopupPriority(int n) {
    }

    default public void enablePopups() {
    }

    default public void disablePopups(int n) {
    }

    default public void disablePopups() {
    }

    default public void setPartialPopupsEnabled(int n, boolean bl) {
    }

    default public void showPartialPopup(int n, int n2) {
    }

    default public void removePartialPopup(int n, int n2) {
    }

    default public void fireSMEvent(int n, int n2) {
    }
}

