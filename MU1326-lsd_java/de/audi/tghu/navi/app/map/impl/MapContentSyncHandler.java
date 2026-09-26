/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IMapContent;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.gui.IAsiaMapContentView;
import de.audi.tghu.navi.app.map.gui.IMapContentView;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler;
import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.map.impl.ContentListItem$ContentListRowWrapper;
import de.audi.tghu.navi.app.map.impl.ItemList;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$1;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$2;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$3;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$4;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$5;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$6;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$7;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler$8;
import de.audi.tghu.navi.app.poi.POICategoryManager$POICategoriesObserver;
import de.audi.tghu.navi.app.poi.PoiCategoryTree;
import de.audi.tghu.navi.app.poi.PoiCategoryTreeBuilder;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.navigation.Category;

public class MapContentSyncHandler
implements POICategoryManager$POICategoriesObserver,
IMapContent {
    public static final int LIST_MAIN;
    public static final int LIST_PPOI;
    public static final int LIST_MAX;
    private static final int ENABLED;
    private static final int DISABLED;
    protected final NavigationEnv env;
    protected final IconHandler iconHandler;
    private final LogChannel mGUILogChannel;
    private int[] storedSystemLayerIDs = new int[0];
    private int[] storedSystemLayerAvailable = new int[0];
    protected final AbstractMap naviMap;
    private final MapDataContainer container;
    private final IMapContentView mapContentView;
    private final IAsiaMapContentView asiaMapContentView;
    private int[] mVisibleCategoryIDs = new int[0];
    private ItemList[] mItemList = new ItemList[2];
    private boolean factoryReset = false;
    private final boolean isParentPoisAvailable;
    private final Object listMainLock = new Object();
    private ContentListItem[] mStaticItems = null;
    private boolean poiVisibilityReceived = false;
    private PoiCategoryTree onboardPoiCategoryTree;
    final SimpleButtonListener asiaRemoveAllPoiListener = new MapContentSyncHandler$1(this);
    final SimpleChoiceListener asiaMapContentListener = this.createItemSelectionHandler();

    protected SimpleChoiceListener createItemSelectionHandler() {
        return new MapContentSyncHandler$2(this);
    }

    public MapContentSyncHandler(NavigationEnv navigationEnv, IconHandler iconHandler, AbstractMap abstractMap, IMapContentView iMapContentView, IAsiaMapContentView iAsiaMapContentView) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.naviMap = abstractMap;
        this.container = abstractMap.getMapDataContainer();
        this.mapContentView = iMapContentView;
        this.asiaMapContentView = iAsiaMapContentView;
        this.mGUILogChannel = abstractMap.getMapGUILogChannel();
        this.isParentPoisAvailable = Util.isPoiSelectionTreeAvailable(navigationEnv.getFramework());
        this.mItemList[0] = new ItemList(0);
        this.mItemList[0].addAll(this.getStaticItems());
        this.flushMainList();
        this.mItemList[1] = new ItemList(1);
        this.flushPPOIList();
        iMapContentView.getCheckAllStandard().setChoiceListener(new MapContentSyncHandler$3(this, navigationEnv));
        this.mapContentView.getStandardList().setListener(new MapContentSyncHandler$4(this));
        this.mapContentView.getStandardListLevel2().setListener(new MapContentSyncHandler$5(this));
        this.mapContentView.getStandardListLevel3().setListener(new MapContentSyncHandler$6(this));
        this.mapContentView.getPPOIList().setListener(new MapContentSyncHandler$7(this));
        if (Util.isHURegionAsia()) {
            this.setAsiaMapContentListeners();
        }
    }

    private void setAsiaMapContentListeners() {
        this.asiaMapContentView.getRemoveAllPOI().setButtonListener(this.asiaRemoveAllPoiListener);
        this.asiaMapContentView.getTrafficFlow().setChoiceListener(this.asiaMapContentListener);
        this.asiaMapContentView.getTrafficEventIcons().setChoiceListener(this.asiaMapContentListener);
        this.asiaMapContentView.getTrafficEventNotice().setChoiceListener(this.asiaMapContentListener);
        this.asiaMapContentView.getUncrowdedRoad().setChoiceListener(this.asiaMapContentListener);
        this.asiaMapContentView.getFavorites().setChoiceListener(this.asiaMapContentListener);
        this.asiaMapContentView.getWeatherIcons().setChoiceListener(this.asiaMapContentListener);
    }

    protected LogChannel getLogger() {
        return this.mGUILogChannel;
    }

    private void refreshPOIState() {
        if (this.onboardPoiCategoryTree == null || this.onboardPoiCategoryTree.isEmpty()) {
            return;
        }
        Iterator iterator = this.onboardPoiCategoryTree.iterator();
        while (iterator.hasNext()) {
            ContentListItem contentListItem = (ContentListItem)iterator.next();
            contentListItem.enabled = true;
        }
    }

    private void refreshPOIVisibility(int[] nArray) {
        int n;
        if (nArray == null) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshPOIVisibility() - visiblePoiIDs = null");
            return;
        }
        if (this.onboardPoiCategoryTree == null || this.onboardPoiCategoryTree.isEmpty()) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshPOIVisibility() - no poi categories received yet");
            return;
        }
        int n2 = nArray == null ? 0 : nArray.length;
        this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshPOIVisibility() - length = %1", (long)n2);
        Object object = this.onboardPoiCategoryTree.iterator();
        while (object.hasNext()) {
            n = 0;
            ContentListItem contentListItem = (ContentListItem)object.next();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (contentListItem.rowID != nArray[i2]) continue;
                n = 1;
                break;
            }
            contentListItem.checked = n;
        }
        object = this.mItemList[1];
        for (n = 0; n < ((ItemList)object).size(); ++n) {
            boolean bl = false;
            ContentListItem contentListItem = ((ItemList)object).getItem(n);
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (contentListItem.rowID != nArray[i3]) continue;
                bl = true;
                break;
            }
            contentListItem.checked = bl;
        }
        this.refreshSublists();
    }

    private void refreshSublists() {
        if (!this.isParentPoisAvailable) {
            return;
        }
        this.refreshItemListModel(this.mapContentView.getStandardListLevel2());
        this.refreshItemListModel(this.mapContentView.getStandardListLevel3());
    }

    public void refreshItemListModel(BaseListModelApp baseListModelApp) {
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        List list = baseListModelApp.asList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            EvoListRow evoListRow = (EvoListRow)iterator.next();
            if (!(evoListRow instanceof ContentListItem$ContentListRowWrapper)) {
                this.getLogger().log(10000, "MapContentSyncHandler#refreshItemListModel don't update, row is not an instance of ContentListRowWrapper");
                return;
            }
            ContentListItem contentListItem = ((ContentListItem$ContentListRowWrapper)evoListRow).item;
            baseListModelApp2.append(contentListItem.toEvoListRow());
        }
        baseListModelApp.update(baseListModelApp2);
    }

    private ContentListItem[] getStaticItems() {
        if (this.mStaticItems != null) {
            return this.mStaticItems;
        }
        if (Util.isHURegionAsia()) {
            return new ContentListItem[0];
        }
        ArrayList arrayList = new ArrayList();
        if (Util.isSpeedAndFlowAvailable(this.env.getFramework())) {
            arrayList.add(ContentListItem.createStaticItem(0, 0));
            arrayList.add(ContentListItem.createStaticItem(1, 1));
        }
        if (Util.isTrafficPresent(this.env.getFramework())) {
            arrayList.add(ContentListItem.createStaticItem(2, 2, 2));
        }
        if (Util.is3DLandmarksAvailable(this.env.getFramework())) {
            arrayList.add(ContentListItem.createStaticItem(3, 4));
        }
        if (Util.isCityModelModeAvailable(this.env.getFramework())) {
            arrayList.add(ContentListItem.createStaticItem(4, 5));
        }
        arrayList.add(ContentListItem.createStaticItem(5, 6));
        if (Util.isPictureNavPresent(this.env.getFramework())) {
            arrayList.add(ContentListItem.createStaticItem(6, 7));
        }
        if (Util.isWeatherOnMapPresent(this.env.getFramework())) {
            arrayList.add(ContentListItem.createStaticItem(8, 12));
        }
        arrayList.add(ContentListItem.createStaticItem(9, 10));
        this.mStaticItems = new ContentListItem[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            this.mStaticItems[i2] = (ContentListItem)arrayList.get(i2);
        }
        return this.mStaticItems;
    }

    @Override
    public void onChangedMapRenderer() {
        if (!this.factoryReset) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#onChangedMapRenderer()");
            this.refresh();
            this.setPOIVisibility(true);
        } else {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#onChangedMapRenderer() - don't take old settings");
            this.refresh();
            this.factoryReset = false;
        }
    }

    @Override
    public void refresh() {
        this.refreshStaticPart();
        this.refreshPOIState();
        this.flushAllLists();
        if (Util.isHURegionAsia()) {
            this.refreshAsiaOptions();
        }
        this.refreshCheckAll(this.areAllEnabledItemsChecked());
    }

    public void refreshAsiaOptions() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshAsiaOptions()");
        ISetupHandler iSetupHandler = this.naviMap.getSetup();
        this.asiaMapContentView.getTrafficEventIcons().setValue(iSetupHandler.getProperty(0));
        this.asiaMapContentView.getTrafficEventNotice().setValue(iSetupHandler.getProperty(1));
        this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshAsiaOptions() - %1", (long)iSetupHandler.getProperty(2));
        this.asiaMapContentView.getUncrowdedRoad().setValue(iSetupHandler.getProperty(2));
        int n = this.mapTrafficFlowToItemID(iSetupHandler.getProperty(5));
        this.asiaMapContentView.getTrafficFlow().setValue(n);
        if (Util.isPorsche(this.env.getFramework())) {
            if (n == 4) {
                this.asiaMapContentView.getUncrowdedRoad().setStatus(1);
            } else {
                this.asiaMapContentView.getUncrowdedRoad().setStatus(0);
            }
        }
        this.asiaMapContentView.getFavorites().setValue(iSetupHandler.getProperty(4));
        this.asiaMapContentView.getWeatherIcons().setValue(iSetupHandler.getProperty(6));
    }

    private int mapTrafficFlowToItemID(int n) {
        switch (n) {
            case 0: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 4: {
                return 0;
            }
        }
        return 0;
    }

    protected void refreshAsiaTrafficFlow() {
        ISetupHandler iSetupHandler = this.naviMap.getSetup();
        boolean bl = iSetupHandler.getSpeedAndFlowFreeflow(0);
        boolean bl2 = iSetupHandler.getSpeedAndFlowCongestions(0);
        int n = iSetupHandler.getProperty(5);
        this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshAsiaTrafficFlow() - showFreeflow=%1, showCongestions=%2, roadClass=%3", (Object)bl, (Object)bl2, (long)n);
        IContext iContext = this.naviMap.getActiveContext();
        iContext.showSpeedAndFlowFreeflow(bl);
        iContext.showSpeedAndFlowCongestions(bl2);
        iContext.setSpeedAndFlowRoadClass(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processCategories(int n, Category[] categoryArray) {
        int n2;
        int n3 = n2 = categoryArray == null ? 0 : categoryArray.length;
        if (n2 <= 0) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#processCategories() - length: %1, mapStyle: %2 - ignore empty list", (long)n2, (long)n);
            return;
        }
        this.getLogger().log(-2137614336, "MapContentSyncHandler#processCategories() - length: %1, mapStyle: %2", (long)n2, (long)n);
        Buffer buffer = new Buffer();
        this.mItemList[1].clear();
        PoiCategoryTreeBuilder poiCategoryTreeBuilder = new PoiCategoryTreeBuilder(this.getLogger());
        for (int i2 = 0; i2 < categoryArray.length; ++i2) {
            int n4 = this.iconHandler.resolvePOIIconResourceID(categoryArray[i2].getIconIndex(), categoryArray[i2].getSubIconIndex());
            String string = categoryArray[i2].getDescription();
            int n5 = categoryArray[i2].getCategoryUid();
            if (this.getLogger().isDebug2()) {
                buffer.append("rowID=").append(n5).append(", iconID=").append(n4).append(", text=").append(string).append(Formatter.LINE_SEPARATOR);
            }
            if (categoryArray[i2].isPersonal()) {
                this.mItemList[1].add(ContentListItem.createMyAudiItem(n5, n4, string, categoryArray[i2].isParent(), categoryArray[i2].getParentId()));
                continue;
            }
            poiCategoryTreeBuilder.add(ContentListItem.createPOIItem(n5, n4, string, categoryArray[i2].isParent(), categoryArray[i2].getParentId(), this.isParentPoisAvailable));
        }
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MapContentSyncHandler#processCategories() - Categories:%1%2", (Object)Formatter.LINE_SEPARATOR, (Object)buffer.toString());
        }
        this.onboardPoiCategoryTree = poiCategoryTreeBuilder.build();
        Object object = this.listMainLock;
        synchronized (object) {
            this.mItemList[0].clear();
            this.mItemList[0].addAll(this.getStaticItems());
            this.mItemList[0].addAll(this.onboardPoiCategoryTree.getSubCategoriesOf(PoiCategoryTree.ROOT_ID));
            this.refreshStaticPart();
            this.refreshPOIVisibility(this.mVisibleCategoryIDs);
            this.mapContentView.getCheckAllStandard().setValue(this.areAllEnabledItemsChecked() ? 1 : 0);
            this.mapContentView.setMyAudiAvailable(this.mItemList[1].size() > 0);
            if (this.poiVisibilityReceived) {
                this.flushMainList();
                this.flushPPOIList();
            }
        }
    }

    private boolean shouldBeChecked(int n) {
        boolean bl = false;
        int n2 = 0;
        switch (n) {
            case 0: {
                bl = this.naviMap.getSetup().getSpeedAndFlowFreeflow(n2);
                break;
            }
            case 1: {
                bl = this.naviMap.getSetup().getSpeedAndFlowCongestions(n2);
                break;
            }
            case 2: {
                bl = this.naviMap.getSetup().getTMCSymbols(n2);
                break;
            }
            case 3: {
                bl = this.naviMap.getSetup().get3DLandmarks(n2);
                break;
            }
            case 4: {
                bl = this.naviMap.getSetup().get3DBuildings(n2) != 0;
                break;
            }
            case 14: {
                bl = this.naviMap.getSetup().getGoogle3DCityModel() != 0;
                break;
            }
            case 5: {
                bl = this.naviMap.getSetup().isFavoriteVisible(n2);
                break;
            }
            case 6: {
                bl = this.naviMap.getSetup().getPicNavIcons(n2);
                break;
            }
            case 8: {
                bl = this.naviMap.getSetup().isWeatherIconVisible(n2);
                break;
            }
            case 9: {
                bl = this.naviMap.getSetup().getBrandedPOIs(n2) == 0;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void backupDynamicPOIVisibilityAndHide() {
        CommandList commandList = null;
        commandList = this.naviMap.getNaviInterface().createCommandList();
        if (this.naviMap.getSetup().getPoiVisibleUid() == null) {
            commandList.add(this.naviMap.getNaviInterface().getPOICategoryManager().fetchPOICategories(0));
        }
        commandList.add(new MapContentSyncHandler$8(this, "backupDynamicPOIVisibilityAndHide"));
        commandList.execute("MapContentSyncHandler#backupDynamicPOIVisibilityAndHide()");
    }

    @Override
    public void restoreDynamicPOIVisibility() {
        if (this.container.sPoiTypeVisibilityDirty) {
            int[] nArray = this.naviMap.getSetup().getPoiVisibleUid();
            boolean[] blArray = this.naviMap.getSetup().getPoiVisibleStatus();
            this.getLogger().log(-2137614336, "MapContentSyncHandler#restoreDynamicPOIVisibility(): sSetupPoiVisibleUid.length: %1, sBackupPoiVisibleUid.length: %2", nArray == null ? 0L : (long)nArray.length, this.container.sBackupPoiVisibleUid == null ? 0L : (long)this.container.sBackupPoiVisibleUid.length);
            this.container.sPoiTypeVisibilityDirty = false;
            if (this.container.sBackupPoiVisibleUid != null) {
                nArray = this.container.sBackupPoiVisibleUid;
                this.container.sBackupPoiVisibleUid = null;
            }
            if (this.container.sBackupPoiVisibleStatus != null) {
                blArray = this.container.sBackupPoiVisibleStatus;
                this.container.sBackupPoiVisibleStatus = null;
            }
            this.naviMap.getSetup().setPoiVisible(nArray, blArray, true);
            int[] nArray2 = this.naviMap.getSetup().getPoiVisibleUid();
            boolean[] blArray2 = this.naviMap.getSetup().getPoiVisibleStatus();
            this.naviMap.getMVRequest().ehSetCategoryVisibility(this.naviMap.getCurrentMapStyle(), nArray2, blArray2);
        }
    }

    @Override
    public void setPOIVisibility(boolean bl) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#setPoiVisiblity() - persistent: %1 ", bl);
        if (this.mItemList[0].size() == 0 && this.mItemList[1].size() == 0) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#setPoiVisiblity() - not initialized - return ");
            return;
        }
        ItemList itemList = this.onboardPoiCategoryTree.getLeafs();
        itemList.addAll(this.mItemList[1]);
        int[] nArray = new int[itemList.size()];
        boolean[] blArray = new boolean[itemList.size()];
        for (int i2 = 0; i2 < itemList.size(); ++i2) {
            ContentListItem contentListItem = itemList.getItem(i2);
            if (contentListItem.isStatic) continue;
            nArray[i2] = contentListItem.rowID;
            blArray[i2] = contentListItem.checked;
        }
        if (this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MapContentSyncHandler#setPoiVisiblity() - %1", (Object)this.onboardPoiCategoryTree.toString());
        }
        this.naviMap.getSetup().setPoiVisible(nArray, blArray, bl);
    }

    @Override
    public synchronized int[] getPoiVisibility() {
        return this.mVisibleCategoryIDs;
    }

    @Override
    public void initializeSystemLayers(int[] nArray, int[] nArray2, boolean bl) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#initializeSystemLayers() - systemLayerIDs: %1, persistedSystemLayerAvailable: %2", (Object)nArray, (Object)nArray2);
        this.storedSystemLayerIDs = nArray == null ? new int[]{} : nArray;
        this.storedSystemLayerAvailable = nArray2 == null ? new int[]{} : nArray2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] getSystemLayers() {
        MapContentSyncHandler mapContentSyncHandler = this;
        synchronized (mapContentSyncHandler) {
            return this.storedSystemLayerIDs == null ? new int[]{} : this.storedSystemLayerIDs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] getSystemLayersAvailable() {
        MapContentSyncHandler mapContentSyncHandler = this;
        synchronized (mapContentSyncHandler) {
            return this.storedSystemLayerAvailable == null ? new int[]{} : this.storedSystemLayerAvailable;
        }
    }

    public void checkAll(boolean bl) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#checkAll( %1 )", bl);
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.mItemList.length; ++i2) {
            for (int i3 = 0; i3 < this.mItemList[i2].size(); ++i3) {
                ContentListItem contentListItem = this.mItemList[i2].getItem(i3);
                if (contentListItem.checked == bl) continue;
                if (contentListItem.rowID == 8 && contentListItem.enabled) {
                    bl2 = true;
                    if (bl) continue;
                    contentListItem.checked = bl;
                    this.checkStaticItem(contentListItem, false);
                    continue;
                }
                contentListItem.checked = bl;
                if (!contentListItem.isStatic) continue;
                this.checkStaticItem(contentListItem, false);
            }
        }
        Object object = this.onboardPoiCategoryTree.iterator();
        while (object.hasNext()) {
            ContentListItem contentListItem = (ContentListItem)object.next();
            contentListItem.checked = bl;
        }
        this.setPOIVisibility(false);
        this.flushAllLists();
        this.naviMap.getSetup().saveState();
        if (bl2) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#checkAll() - weather item was changed! ");
            object = this.naviMap.getMapManager().getWeatherLicenseHandler();
            if (bl) {
                ((WeatherLicenseHandler)object).onWeatherCheckboxSelected(this);
            } else {
                try {
                    ((WeatherLicenseHandler)object).deactivateWeather();
                }
                catch (Exception exception) {
                    this.getLogger().log(10000, "MapContentSyncHandler#checkAll() - ERROR=%1", (Throwable)exception);
                }
            }
        }
    }

    protected void onClickListItem(int n, BaseListModelApp baseListModelApp, int n2) {
        boolean bl;
        ContentListItem contentListItem = null;
        switch (n) {
            case 0: 
            case 1: {
                contentListItem = this.mItemList[n].getItem(n2);
                if (contentListItem != null) break;
                this.getLogger().log(-1601830656, "MapContentSyncHandler#onClickListItem() - invalid index %1 of list %2", (long)n2, (long)n);
                return;
            }
            default: {
                this.getLogger().log(-1601830656, "MapContentSyncHandler#onClickListItem() - unknown list type : %1", (long)n);
                return;
            }
        }
        this.getLogger().log(-2137614336, "MapContentSyncHandler#onClickListItem() - click: %2, enabled: %1 ", contentListItem.enabled, (Object)contentListItem);
        if (!contentListItem.enabled) {
            return;
        }
        WeatherLicenseHandler weatherLicenseHandler = this.naviMap.getMapManager().getWeatherLicenseHandler();
        boolean bl2 = bl = contentListItem.rowID == 8;
        if (bl && !contentListItem.checked) {
            weatherLicenseHandler.onWeatherCheckboxSelected(this);
            return;
        }
        if (n == 0 && contentListItem.isParent && this.isParentPoisAvailable) {
            this.handleParentPoi(contentListItem, baseListModelApp);
            return;
        }
        if (n == 0 && !contentListItem.isStatic) {
            contentListItem.checked = !contentListItem.checked;
            this.onboardPoiCategoryTree.setItemChecked(contentListItem.rowID, contentListItem.checked);
        } else {
            contentListItem.checked = !contentListItem.checked;
        }
        baseListModelApp.setRow(n2, contentListItem.toEvoListRow());
        if (baseListModelApp == this.mapContentView.getStandardList()) {
            this.refreshButtonStatusRemoveAll();
        }
        this.refreshCheckAll(contentListItem.checked && this.areAllEnabledItemsChecked());
        if (contentListItem.isStatic) {
            this.checkStaticItem(contentListItem, true);
        } else if (n == 0 || n == 1) {
            this.setPOIVisibility(true);
        } else {
            this.getLogger().log(-1601830656, "MapContentSyncHandler#onClickListItem() - unexpected call");
        }
        if (bl) {
            this.getLogger().log(1078071040, "MapContentSyncHandler#onClickListItem() - deactivate weather in map", 0L);
            try {
                weatherLicenseHandler.deactivateWeather();
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MapContentSyncHandler#onClickListItem() - ERROR=%1", (Throwable)exception);
            }
        }
    }

    private void onClickOnboardPoiItem(int n, BaseListModelApp baseListModelApp) {
        ContentListItem contentListItem = ((ContentListItem$ContentListRowWrapper)baseListModelApp.getRowByUniqueID((long)((long)n))).item;
        if (contentListItem.isParent) {
            this.handleParentPoi(contentListItem, baseListModelApp);
        } else {
            this.getLogger().log(1078071040, "MapContentSyncHandler#onClickOnboardPoiItem() - selected item=%1", (Object)contentListItem);
            contentListItem.checked = !contentListItem.checked;
            this.onboardPoiCategoryTree.setItemChecked(contentListItem.rowID, contentListItem.checked);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(n), contentListItem.toEvoListRow());
            this.setPOIVisibility(true);
        }
    }

    private void handleParentPoi(ContentListItem contentListItem, BaseListModelApp baseListModelApp) {
        BaseListModelApp baseListModelApp2;
        LabelModelApp labelModelApp;
        if (baseListModelApp == this.mapContentView.getStandardList()) {
            labelModelApp = this.env.getLabelModel(975504896);
            baseListModelApp2 = this.mapContentView.getStandardListLevel2();
        } else if (baseListModelApp == this.mapContentView.getStandardListLevel2()) {
            labelModelApp = this.env.getLabelModel(992282112);
            baseListModelApp2 = this.mapContentView.getStandardListLevel3();
        } else {
            this.getLogger().log(10000, "MapContentSyncHandler#handleParentPoi no followup list found for BaseListModelApp %1", (long)baseListModelApp.getID());
            return;
        }
        this.getLogger().log(1078071040, "MapContentSyncHandler#handleParentPoi parentpoi(%2) selected in list %1", (Object)Integer.toString(baseListModelApp.getID()), (Object)contentListItem.text);
        ItemList itemList = this.onboardPoiCategoryTree.getSubCategoriesOf(contentListItem.rowID);
        labelModelApp.setText(contentListItem.text);
        this.flush(itemList, baseListModelApp2);
        this.env.fireModelEvent(baseListModelApp.getID(), 0);
    }

    private void refreshCheckAll(boolean bl) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshCheckAll( %1 )", bl);
        this.mapContentView.getCheckAllStandard().setValue(bl ? 1 : 0);
    }

    private boolean areAllEnabledItemsChecked() {
        for (int i2 = 0; i2 < this.mItemList.length; ++i2) {
            for (int i3 = 0; i3 < this.mItemList[i2].size(); ++i3) {
                ContentListItem contentListItem = this.mItemList[i2].getItem(i3);
                if (contentListItem.checked) continue;
                this.getLogger().log(14808325, "MapContentSyncHandler#areAllEnabledItemsChecked() - List[%2] %1", (Object)contentListItem, (long)i2);
                return false;
            }
        }
        return true;
    }

    private void refreshStaticPart() {
        boolean bl = Util.isLockFeatureNavMapAdvancedMapEnabled(this.env) && this.naviMap.getNaviInterface().isFeatureToBeLocked();
        boolean bl2 = !bl;
        Buffer buffer = new Buffer();
        this.getLogger().log(-2137614336, "MapContentSyncHandler#refreshStaticPart() - are3DModelsAllowed: %1", bl2);
        for (int i2 = 0; i2 < this.mItemList[0].size(); ++i2) {
            ContentListItem contentListItem = this.mItemList[0].getItem(i2);
            if (!contentListItem.isStatic) continue;
            contentListItem.checked = this.shouldBeChecked(contentListItem.rowID);
            if (contentListItem.rowID == 4 || contentListItem.rowID == 3) {
                contentListItem.enabled = bl2;
            }
            if (!this.getLogger().isDebug2()) continue;
            buffer.append("rowID=").append(contentListItem.rowID).append(", checked=").append(contentListItem.checked).append(Formatter.LINE_SEPARATOR);
        }
        if (buffer.length() > 0 && this.getLogger().isDebug2()) {
            this.getLogger().log(14808325, "MapContentSyncHandler#refreshStaticPart() - Static categories:%1%2", (Object)Formatter.LINE_SEPARATOR, (Object)buffer.toString());
        }
    }

    private void checkStaticItem(ContentListItem contentListItem, boolean bl) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#checkStaticItem() - rowID: %2, persistent: %1", bl, (long)contentListItem.rowID);
        int n = contentListItem.rowID;
        boolean bl2 = contentListItem.checked;
        int n2 = 0;
        ISetupHandler iSetupHandler = this.naviMap.getSetup();
        switch (n) {
            case 2: {
                iSetupHandler.setOption(11, bl2, bl);
                this.naviMap.getActiveContext().showTMC(bl2);
                break;
            }
            case 0: {
                iSetupHandler.setSpeedAndFlowFreeflow(bl2, bl, n2);
                this.naviMap.getActiveContext().showSpeedAndFlowFreeflow(bl2);
                break;
            }
            case 1: {
                iSetupHandler.setSpeedAndFlowCongestions(bl2, bl, n2);
                this.naviMap.getActiveContext().showSpeedAndFlowCongestions(bl2);
                break;
            }
            case 3: {
                iSetupHandler.setOption(3, bl2, bl);
                this.naviMap.getActiveContext().setLandmarksVisible(bl2);
                break;
            }
            case 4: {
                int n3 = bl2 ? 2 : 0;
                iSetupHandler.setOption(2, n3, bl);
                if (this.naviMap.getSatellitemapsManager().isSatelliteMapActive()) break;
                this.naviMap.getActiveContext().setCityModelMode(n3);
                break;
            }
            case 14: {
                int n4 = bl2 ? 2 : 0;
                iSetupHandler.setGoogle3DCityModel(n4, bl);
                if (!this.naviMap.getSatellitemapsManager().isSatelliteMapActive()) break;
                this.naviMap.getActiveContext().setCityModelMode(n4);
                break;
            }
            case 9: {
                int n5 = bl2 ? 0 : 1;
                iSetupHandler.setBrandedPOIs(n5, bl, n2);
                this.naviMap.getActiveContext().showBrandIcons(n5);
                break;
            }
            case 6: {
                iSetupHandler.setPicNavIcons(bl2, bl, n2);
                this.naviMap.getActiveContext().showPictureNavigationIcons(bl2);
                break;
            }
            case 13: {
                break;
            }
            case 5: {
                iSetupHandler.setFavorites(bl2, bl, n2);
                this.naviMap.getMapFlagHandler().refresh(true);
                break;
            }
            case 12: {
                break;
            }
            case 8: {
                iSetupHandler.setWeatherIcons(bl2, bl, n2);
                this.naviMap.getActiveContext().showWeatherIcons(bl2);
                break;
            }
            default: {
                this.getLogger().log(-2137614336, "MapContentSyncHandler#checkStaticItem() invalid staticRowID: %1", (long)n);
            }
        }
    }

    @Override
    public boolean toggleTMC() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#toggleTMC()");
        ContentListItem contentListItem = this.mItemList[0].getItem(true, 2);
        if (contentListItem != null) {
            contentListItem.checked = !contentListItem.checked;
            this.flushMainList();
            if (contentListItem.checked) {
                this.mapContentView.getCheckAllStandard().setValue(this.areAllEnabledItemsChecked() ? 1 : 0);
            } else {
                this.mapContentView.getCheckAllStandard().setValue(0);
            }
            this.checkStaticItem(contentListItem, true);
            return this.naviMap.getSetup().getTMCSymbols(0);
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateEhCategoryVisibility(int[] nArray) {
        if (nArray == null) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#updateEhCategoryVisibility( null )");
            return;
        }
        this.getLogger().log(-2137614336, "MapContentSyncHandler#updateEhCategoryVisibility( ) - length = %1", (long)nArray.length);
        Object object = this.listMainLock;
        synchronized (object) {
            this.poiVisibilityReceived = true;
            this.mVisibleCategoryIDs = nArray;
            this.refreshPOIVisibility(this.mVisibleCategoryIDs);
            this.refreshCheckAll(this.areAllEnabledItemsChecked());
            this.flushMainList();
        }
        this.flushPPOIList();
    }

    private void flush(ItemList itemList, BaseListModelApp baseListModelApp) {
        this.getLogger().log(14808325, "MapContentSyncHandler#flush() - itemList.ID:%1, modelID:%2", (long)itemList.ID, (long)baseListModelApp.getID());
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        EvoListRow[] evoListRowArray = new EvoListRow[itemList.size()];
        for (int i2 = 0; i2 < itemList.size(); ++i2) {
            evoListRowArray[i2] = itemList.getItem(i2).toEvoListRow();
        }
        if (evoListRowArray.length > 0) {
            baseListModelApp2.append(evoListRowArray);
        }
        if (baseListModelApp == this.mapContentView.getStandardList()) {
            this.refreshButtonStatusRemoveAll();
        }
        baseListModelApp.update(baseListModelApp2);
    }

    private void flushAllLists() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#flushAllLists()");
        this.flush(this.mItemList[0], this.mapContentView.getStandardList());
        this.flush(this.mItemList[1], this.mapContentView.getPPOIList());
    }

    private void flushMainList() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#flushMainList()");
        this.flush(this.mItemList[0], this.mapContentView.getStandardList());
    }

    private void flushPPOIList() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#flushPPOIList()");
        this.flush(this.mItemList[1], this.mapContentView.getPPOIList());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refreshButtonStatusRemoveAll() {
        if (!Util.isHURegionAsia()) {
            return;
        }
        if (this.onboardPoiCategoryTree == null) {
            return;
        }
        Object object = this.listMainLock;
        synchronized (object) {
            ButtonModelApp buttonModelApp = this.asiaMapContentView.getRemoveAllPOI();
            boolean bl = false;
            Iterator iterator = this.onboardPoiCategoryTree.iterator();
            while (iterator.hasNext()) {
                ContentListItem contentListItem = (ContentListItem)iterator.next();
                if (!contentListItem.checked) continue;
                bl = true;
                break;
            }
            if (bl) {
                if (buttonModelApp.getStatus() != 1) {
                    buttonModelApp.setStatus(1);
                    this.getLogger().log(14808325, "MapContentSyncHandler#enableRemoveAllPOIBtn() ENABLED");
                }
            } else if (buttonModelApp.getStatus() != 0) {
                buttonModelApp.setStatus(0);
                this.getLogger().log(14808325, "MapContentSyncHandler#enableRemoveAllPOIBtn() DISABLED");
            }
        }
    }

    @Override
    public void resetSettings() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#resetSettings()");
        this.factoryReset = true;
    }

    @Override
    public boolean isWeatherInMapSelected() {
        boolean bl = false;
        ContentListItem[] contentListItemArray = this.getStaticItems();
        if (contentListItemArray != null) {
            for (int i2 = 0; i2 < contentListItemArray.length; ++i2) {
                if (contentListItemArray[i2] == null || contentListItemArray[i2].rowID != 8) continue;
                bl = contentListItemArray[i2].checked;
                break;
            }
        }
        return bl;
    }

    @Override
    public void checkWeatherInMap(boolean bl, boolean bl2, boolean bl3) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#checkWeatherInMap() - check: %1, enable: %2 ", bl, bl2);
        ContentListItem contentListItem = this.mItemList[0].getItem(true, 8);
        if (contentListItem != null) {
            contentListItem.checked = bl;
            contentListItem.enabled = bl2;
            this.flushMainList();
            if (contentListItem.checked) {
                this.mapContentView.getCheckAllStandard().setValue(this.areAllEnabledItemsChecked() ? 1 : 0);
            } else {
                this.mapContentView.getCheckAllStandard().setValue(0);
            }
            this.checkStaticItem(contentListItem, bl3);
        }
    }

    @Override
    public String getName() {
        if (this.naviMap != null) {
            Buffer buffer = new Buffer(50);
            buffer.append("MapContentSyncHandler[");
            buffer.append(this.naviMap.getName());
            buffer.append(']');
            return buffer.toString();
        }
        return this.toString();
    }

    @Override
    public void jumpToInclude() {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#jumpToInclude() ");
        int n = this.mapContentView.getStandardList().getID();
        this.env.fireModelEvent(n, 0);
    }

    @Override
    public void activateDeactivateWeatherInMap(boolean bl) {
        this.getLogger().log(-2137614336, "MapContentSyncHandler#activateDeactivateWeatherInMap()");
        WeatherLicenseHandler weatherLicenseHandler = this.naviMap.getMapManager().getWeatherLicenseHandler();
        if (bl && null != weatherLicenseHandler) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#activateDeactivateWeatherInMap() - ACTIVATE");
            weatherLicenseHandler.onWeatherCheckboxSelected(this);
            return;
        }
        if (!bl && null != weatherLicenseHandler) {
            this.getLogger().log(-2137614336, "MapContentSyncHandler#activateDeactivateWeatherInMap() - DEACTIVATE");
            try {
                weatherLicenseHandler.disableWeatherInMapApp();
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "MapContentSyncHandler#activateDeactivateWeatherInMap() - ERROR=%1", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
    }

    @Override
    public void updateVisibleLayers(int[] nArray) {
    }

    static /* synthetic */ Object access$000(MapContentSyncHandler mapContentSyncHandler) {
        return mapContentSyncHandler.listMainLock;
    }

    static /* synthetic */ IMapContentView access$100(MapContentSyncHandler mapContentSyncHandler) {
        return mapContentSyncHandler.mapContentView;
    }

    static /* synthetic */ void access$200(MapContentSyncHandler mapContentSyncHandler, int n, BaseListModelApp baseListModelApp) {
        mapContentSyncHandler.onClickOnboardPoiItem(n, baseListModelApp);
    }

    static /* synthetic */ MapDataContainer access$300(MapContentSyncHandler mapContentSyncHandler) {
        return mapContentSyncHandler.container;
    }
}

