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
    public static final int MODULE_DIVISOR = 100000;
    public static final int CONTEXT_HMI = 0;
    public static final int CONTEXT_HMI_TV = 1;
    public static final int CONTEXT_HMI_DVD_VIDEO = 2;
    public static final int CONTEXT_HMI_REARVIEW_CAMERA = 3;
    public static final int CONTEXT_HMI_BROWSER = 4;
    public static final int CONTEXT_HMI_SPLASH_SCREEN = 5;
    public static final int CONTEXT_HMI_AUX_AV = 6;
    public static final int CONTEXT_HMI_EXTERNAL_DVD_VIDEO = 7;
    public static final int CONTEXT_HMI_FILE_BASED_VIDEO = 8;
    public static final int CONTEXT_HMI_COVERFLOW = 9;
    public static final int CONTEXT_HMI_MAP_VIEWER = 10;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION = 11;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION_3D = 12;
    public static final int CONTEXT_HMI_MAP_VIEWER_JUNCTION = 13;
    public static final int CONTEXT_HMI_MAP_VIEWER_RG = 14;
    public static final int CONTEXT_HMI_MAP_VIEWER_LANDMARK = 15;
    public static final int CONTEXT_HMI_GE = 16;
    public static final int CONTEXT_HMI_GE_INTERSECTION = 17;
    public static final int CONTEXT_HMI_GE_INTERSECTION_3D = 18;
    public static final int CONTEXT_HMI_GE_JUNCTION = 19;
    public static final int CONTEXT_HMI_GE_RGS = 20;
    public static final int CONTEXT_HMI_GE_LANDMARK = 21;
    public static final int CONTEXT_HMI_MAP_VIEWER_RG_JUNCTION = 22;
    public static final int CONTEXT_HMI_TV_VIDEOTEXT = 23;
    public static final int CONTEXT_HMI_3D_ENGINE = 24;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_1 = 25;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_2 = 26;
    public static final int CONTEXT_HMI_COVERFLOW_MAP_VIEWER = 27;
    public static final int CONTEXT_HMI_COVERFLOW_GE_MAP_VIEWER = 28;
    public static final int CONTEXT_HMI_MAP_IN_MAP = 29;
    public static final int CONTEXT_HMI_GE_MAP_IN_MAP = 30;
    public static final int CONTEXT_HMI_STREETVIEW = 31;
    public static final int CONTEXT_HMI_VIEWER_INTERSECTION = 32;
    public static final int CONTEXT_HMI_COVERFLOW_PICTURE = 33;
    public static final int CONTEXT_HMI_TERMINAL_2 = 35;
    public static final int CONTEXT_HMI_TV_TERMINAL_2 = 36;
    public static final int CONTEXT_HMI_DVD_VIDEO_TERMINAL_2 = 37;
    public static final int CONTEXT_HMI_REARVIEW_CAMERA_TERMINAL_2 = 38;
    public static final int CONTEXT_HMI_BROWSER_TERMINAL_2 = 39;
    public static final int CONTEXT_HMI_SPLASH_SCREEN_TERMINAL_2 = 40;
    public static final int CONTEXT_HMI_AUX_AV_TERMINAL_2 = 41;
    public static final int CONTEXT_HMI_EXTERNAL_DVD_VIDEO_TERMINAL_2 = 42;
    public static final int CONTEXT_HMI_FILE_BASED_VIDEO_TERMINAL_2 = 43;
    public static final int CONTEXT_HMI_COVERFLOW_TERMINAL_2 = 44;
    public static final int CONTEXT_HMI_MAP_VIEWER_TERMINAL_2 = 45;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION_TERMINAL_2 = 46;
    public static final int CONTEXT_HMI_MAP_VIEWER_INTERSECTION_3D_TERMINAL_2 = 47;
    public static final int CONTEXT_HMI_MAP_VIEWER_JUNCTION_TERMINAL_2 = 48;
    public static final int CONTEXT_HMI_MAP_VIEWER_RGS_TERMINAL_2 = 49;
    public static final int CONTEXT_HMI_MAP_VIEWER_LANDMARK_TERMINAL_2 = 50;
    public static final int CONTEXT_HMI_GE_TERMINAL_2 = 51;
    public static final int CONTEXT_HMI_GE_INTERSECTION_TERMINAL_2 = 52;
    public static final int CONTEXT_HMI_GE_INTERSECTION_3D_TERMINAL_2 = 53;
    public static final int CONTEXT_HMI_GE_JUNCTION_TERMINAL_2 = 54;
    public static final int CONTEXT_HMI_GE_RGS_TERMINAL_2 = 55;
    public static final int CONTEXT_HMI_GE_LANDMARK_TERMINAL_2 = 56;
    public static final int CONTEXT_HMI_TV_VIDEOTEXT_TERMINAL_2 = 57;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_1_TERMINAL_2 = 58;
    public static final int CONTEXT_HMI_DIGITAL_VIDEOPLAYER_2_TERMINAL_2 = 59;
    public static final int CONTEXT_HMI_COVERFLOW_MAP_VIEWER_TERMINAL_2 = 60;
    public static final int CONTEXT_HMI_COVERFLOW_GE_MAP_VIEWER_TERMINAL_2 = 61;
    public static final int CONTEXT_HMI_MAP_IN_MAP_TERMINAL_2 = 62;
    public static final int CONTEXT_HMI_GE_MAP_IN_MAP_TERMINAL_2 = 63;
    public static final int CONTEXT_HMI_STREETVIEW_TERMINAL_2 = 64;
    public static final int CONTEXT_HMI_STREETVIEW_MAP_IN_MAP_TERMINAL_2 = 65;
    public static final int CONTEXT_HMI_VIEWER_INTERSECTION_TERMINAL_2 = 66;
    public static final int CONTEXT_TV_ONLY = 67;
    public static final int CONTEXT_DVD_VIDEO_ONLY = 68;
    public static final int CONTEXT_EXTERNAL_DVD_VIDEO_ONLY = 69;
    public static final int CONTEXT_FILE_BASED_VIDEO_ONLY = 70;
    public static final int CONTEXT_AUX_AV_ONLY = 71;
    public static final int CONTEXT_KOMBI_MAP = 72;
    public static final int CONTEXT_KOMBI_KDK = 73;
    public static final int CONTEXT_KOMBI_MAP_KDK = 74;
    public static final int CONTEXT_KOMBI_EMPTY_CONTEXT = 75;
    public static final int CONTEXT_KOMBI_MAP_GE = 76;
    public static final int CONTEXT_KOMBI_MAP_GE_KDK = 77;
    public static final int CONTEXT_HMI_EXTERNAL_SMARTPHONE = 78;
    public static final int MAX_CONTEXTS = 79;

    public HMIModelApp getModelApp(int var1);

    public HMIModelApp getModelApp(int var1, int var2);

    public ChoiceModelApp getChoiceModel(int var1);

    public ChoiceModelApp getChoiceModel(int var1, int var2);

    public TextEditorModelApp getTextEditorModel(int var1);

    public TextEditorModelApp getTextEditorModel(int var1, int var2);

    public TextEditorModelDDApp getTextEditorModelDD(int var1);

    public TextEditorModelDDApp getTextEditorModelDD(int var1, int var2);

    public ButtonModelApp getButtonModel(int var1);

    public OptionModelApp getOptionModel(int var1);

    public ButtonModelApp getButtonModel(int var1, int var2);

    public LabelModelApp getLabelModel(int var1);

    public LabelModelApp getLabelModel(int var1, int var2);

    public MetricsModelApp getMetricsModel(int var1);

    public MetricsModelApp getMetricsModel(int var1, int var2);

    public ListModelApp getListModel(int var1);

    public BaseListModelApp getBaseListModel(int var1);

    public TiledListModelApp getTiledListModel(int var1);

    public ListModelApp getListModel(int var1, int var2);

    public RangeModelApp getRangeModel(int var1);

    public RangeModelApp getRangeModel(int var1, int var2);

    public IPSpellerModelApp getIPSpellerModel(int var1);

    public IPSpellerModelApp getIPSpellerModel(int var1, int var2);

    public SpellerModelApp getSpellerModel(int var1);

    public SpellerModelApp getSpellerModel(int var1, int var2);

    public MatchspellerModelApp getMatchSpellerModel(int var1);

    public SlidingListModelApp getSlidingListModel(int var1);

    public TooltipModelApp getTooltipModel(int var1);

    public TooltipModelApp getTooltipModel(int var1, int var2);

    public TextfieldModelApp getTextfieldModel(int var1);

    public DynamicListModelApp getDynamicListModel(int var1);

    public DynamicListModelApp getDynamicListModel(int var1, int var2);

    public ResourceLocatorModelApp getResourceLocatorModel(int var1);

    public ResourceLocatorModelApp getResourceLocatorModel(int var1, int var2);

    public FastScrollingModelApp getFastScrollingModel(int var1);

    public VirtualButtonModelApp getVirtualButtonModel(int var1);

    public BufferedFolderListModelApp getBufferedFolderListModel(int var1);

    public BufferedFolderListModelApp getBufferedFolderListModel(int var1, int var2);

    public BrowserModelApp getBrowserModel(int var1);

    public DataModelApp getDataModel(int var1);

    public MenuModelApp getMenuModel(int var1);

    public PropertyModelApp getPropertyModel(int var1);

    public PropertyModelApp getPropertyModel(int var1, int var2);

    public String getText(int var1);

    public String getText(int var1, int var2);

    public void showPopup(int var1);

    public void showPopup(int var1, int var2);

    public void removePopup(int var1);

    public void removePopup(int var1, int var2);

    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy var1);

    public boolean removeCurrentPopup(int var1);

    public int getCurrentPopup();

    public int getCurrentPopup(int var1);

    public int getCurrentPopupPriority(int var1);

    public void enablePopups();

    public void disablePopups(int var1);

    public void disablePopups();

    public void setPartialPopupsEnabled(int var1, boolean var2);

    public void showPartialPopup(int var1, int var2);

    public void removePartialPopup(int var1, int var2);

    public void fireSMEvent(int var1, int var2);
}

