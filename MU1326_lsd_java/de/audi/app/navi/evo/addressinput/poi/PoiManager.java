/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager$1;
import de.audi.app.navi.evo.addressinput.poi.PoiManager$2;
import de.audi.app.navi.evo.addressinput.poi.PoiManager$3;
import de.audi.app.navi.evo.addressinput.poi.PoiManager$4;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiBrandResultScreenNoSpellerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiBrandScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiCategoryScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiClassScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiExternalHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiMainScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiParentChildCategoryScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiParentChildResultScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiParkingNearDestinationScreenHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenNoSpellerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithMatchSpellerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithSpellerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiRightDrawerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.asia.PoiResultScreenWithMatchSpellerListenerAsia;
import de.audi.app.navi.evo.addressinput.poi.models.PoiBrandResultScreenNoSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiBrandScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiCategoryScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiClassScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiMainScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiParentChildCategoryScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiParentChildResultScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiParkingNearDestinationScreenModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenNoSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenWithMatchSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenWithSpellerModelAccess;
import de.audi.app.navi.evo.addressinput.poi.searcharea.evo.PoiAreaCityZipInputModelAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.poi.CorePoiManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiWorkFlowManager;
import de.audi.tghu.navi.app.addressinput.poi.IShowHideResetSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiBrandScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaHandler;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiMainScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildResultScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildResultScreenInputSequenceAsia;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence;
import de.audi.tghu.navi.app.command.ResetSpellerStackCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiManager
extends CorePoiManager
implements IShowHideResetSearchArea {
    private PoiMainScreenHmiListener poiMainScreenHmiListener;
    private PoiResultScreenWithSpellerHmiListener poiResultScreenWithSpellerHmiListener;
    private PoiResultScreenNoSpellerHmiListener poiResultScreenNoSpellerHmiListener;
    private PoiResultScreenWithMatchSpellerHmiListener poiResultScreenWithMatchSpellerHmiListener;
    private PoiClassScreenHmiListener poiClassScreenHmiListener;
    private PoiCategoryScreenHmiListener poiCategoryScreenHmiListener;
    private PoiBrandScreenHmiListener poiBrandScreenHmiListener;
    private PoiBrandResultScreenNoSpellerHmiListener poiBrandResultScreenNoSpellerHmiListener;
    private PoiParentChildCategoryScreenHmiListener poiParentChildScreenHmiListener;
    private PoiParentChildResultScreenHmiListener poiParentChildResultScreenHmiListener;
    private PoiParkingNearDestinationScreenHmiListener poiParkingNearDestinationScreenHmiListener;
    private AbstractPoiScreenHmiListener[] allListeners;
    private AbstractPoiScreenHmiListener activeListener = null;
    private AbstractPoiRightDrawerHmiListener poiRightDrawerHmiListener;
    private PoiExternalHmiListener poiExternalHmiListener;
    private final AsyncNavLocationExtractor extractor;
    private final INaviFavoriteHandler naviFavoriteHandler;
    private final MapInterface mapInterface;
    private final NaviADBHandler navAdbHandler;
    private final ITelService telService;
    private final IRRDListener rrdListener;
    private boolean allowRestartRRDCalculation;
    private final ChoiceModelApp searchAreaVisibleChoice;
    private final IDetailsScreen detailsScreen;
    private final Monitor poiCommandListMonitor;
    private boolean previewMapPosible;
    private final ValueListStatus initialSubstringSearchStatus = new ValueListStatus(2, 0, 0);

    public PoiManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IconHandler iconHandler, PoiSearchArea poiSearchArea, SpellerStack spellerStack, IPoiWorkFlowManager iPoiWorkFlowManager, IRouteManager iRouteManager, IVehicle iVehicle, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IPreviewMap iPreviewMap, INaviFavoriteHandler iNaviFavoriteHandler, NaviADBHandler naviADBHandler, MapInterface mapInterface, ITelService iTelService, IRRDListener iRRDListener, PoiSearchAreaSequence poiSearchAreaSequence, IDetailsScreen iDetailsScreen) {
        super(navigationEnv, iconHandler, iRouteManager, iCommandListFactory, poiSearchArea, iVehicle, iPreviewMap, spellerStack, iStartGuidanceToDestinationSequence, iPoiWorkFlowManager, poiSearchAreaSequence);
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.navAdbHandler = naviADBHandler;
        this.mapInterface = mapInterface;
        this.telService = iTelService;
        this.detailsScreen = iDetailsScreen;
        this.extractor = new LiValueListAsyncNavLocationExtractor(iCommandListFactory);
        this.rrdListener = iRRDListener;
        this.searchAreaVisibleChoice = navigationEnv.getChoiceModel(1210189312);
        this.poiCommandListMonitor = new Monitor(this.logChannel);
        this.showSearchArea();
        this.initListeners();
    }

    private void initListeners() {
        this.poiMainScreenHmiListener = this.initPoiMainScreenHmiListener();
        this.poiResultScreenWithSpellerHmiListener = this.initPoiResultScreenWithSpellerHmiListener();
        this.poiResultScreenNoSpellerHmiListener = this.initPoiResultScreenNoSpellerHmiListener();
        this.poiResultScreenWithMatchSpellerHmiListener = this.initPoiResultScreenWithMatchSpellerHmiListener();
        this.poiClassScreenHmiListener = this.initPoiClassScreenHmiListener();
        this.poiCategoryScreenHmiListener = this.initPoiCategoryScreenHmiListener();
        this.poiBrandScreenHmiListener = this.initPoiBrandScreenHmiListener();
        this.poiBrandResultScreenNoSpellerHmiListener = this.initPoiBrandResultScreenNoSpellerHmiListener();
        this.poiParentChildScreenHmiListener = this.initPoiParentChildCategoryScreenHmiListener();
        this.poiParentChildResultScreenHmiListener = this.initPoiParentChildResultScreenHmiListener();
        this.poiParkingNearDestinationScreenHmiListener = this.initPoiParkingNearDestinationScreenHmiListener();
        this.poiRightDrawerHmiListener = this.initPoiRightDrawerHmiListener();
        this.poiExternalHmiListener = this.initPoiExternalHmiListener();
        this.allListeners = new AbstractPoiScreenHmiListener[]{this.poiResultScreenWithSpellerHmiListener, this.poiResultScreenNoSpellerHmiListener, this.poiResultScreenWithMatchSpellerHmiListener, this.poiClassScreenHmiListener, this.poiCategoryScreenHmiListener, this.poiBrandScreenHmiListener, this.poiBrandResultScreenNoSpellerHmiListener, this.poiParentChildScreenHmiListener, this.poiParentChildResultScreenHmiListener, this.poiParkingNearDestinationScreenHmiListener};
    }

    public PoiMainScreenHmiListener getPoiMainScreenHmiListener() {
        return this.poiMainScreenHmiListener;
    }

    public PoiResultScreenWithSpellerHmiListener getPoiResultScreenWithSpellerHmiListener() {
        return this.poiResultScreenWithSpellerHmiListener;
    }

    public PoiResultScreenNoSpellerHmiListener getPoiResultScreenNoSpellerHmiListener() {
        return this.poiResultScreenNoSpellerHmiListener;
    }

    public PoiResultScreenWithMatchSpellerHmiListener getPoiResultScreenWithMatchSpellerHmiListener() {
        return this.poiResultScreenWithMatchSpellerHmiListener;
    }

    public PoiClassScreenHmiListener getPoiClassScreenHmiListener() {
        return this.poiClassScreenHmiListener;
    }

    public PoiCategoryScreenHmiListener getPoiCategoryScreenHmiListener() {
        return this.poiCategoryScreenHmiListener;
    }

    public PoiBrandScreenHmiListener getPoiBrandScreenHmiListener() {
        return this.poiBrandScreenHmiListener;
    }

    public PoiBrandResultScreenNoSpellerHmiListener getPoiBrandResultScreenNoSpellerHmiListener() {
        return this.poiBrandResultScreenNoSpellerHmiListener;
    }

    public PoiParentChildCategoryScreenHmiListener getPoiParentChildCategoryScreenHmiListener() {
        return this.poiParentChildScreenHmiListener;
    }

    public PoiParentChildResultScreenHmiListener getPoiParentChildResultScreenHmiListener() {
        return this.poiParentChildResultScreenHmiListener;
    }

    public PoiParkingNearDestinationScreenHmiListener getPoiParkingNearDestinationScreenHmiListener() {
        return this.poiParkingNearDestinationScreenHmiListener;
    }

    public AbstractPoiRightDrawerHmiListener getPoiRightDrawerHmiListener() {
        return this.poiRightDrawerHmiListener;
    }

    public PoiExternalHmiListener getPoiExternalHmiListener() {
        return this.poiExternalHmiListener;
    }

    private PoiMainScreenHmiListener initPoiMainScreenHmiListener() {
        PoiMainScreenModelAccess poiMainScreenModelAccess = PoiScreensEvo.getPoiMainScreenModelAccess(this.env, this.iconHandler);
        PoiMainScreenInputSequence poiMainScreenInputSequence = new PoiMainScreenInputSequence(poiMainScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiMainScreenHmiListener poiMainScreenHmiListener = new PoiMainScreenHmiListener(this.env, poiMainScreenInputSequence, this, this.previewMapInterface, this.poiSearchArea);
        return poiMainScreenHmiListener;
    }

    private PoiResultScreenWithSpellerHmiListener initPoiResultScreenWithSpellerHmiListener() {
        PoiResultScreenWithSpellerModelAccess poiResultScreenWithSpellerModelAccess = PoiScreensEvo.getPoiResultScreenWithSpellerModelAccess(this.env, this.iconHandler, this.routeManager, this.vehicle, this.poiSearchArea, this.previewMapInterface);
        PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence = new PoiResultScreenWithSpellerInputSequence(poiResultScreenWithSpellerModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiResultScreenWithSpellerHmiListener poiResultScreenWithSpellerHmiListener = new PoiResultScreenWithSpellerHmiListener(this.env, poiResultScreenWithSpellerInputSequence, this, this.previewMapInterface, this.poiSearchArea, this.extractor);
        return poiResultScreenWithSpellerHmiListener;
    }

    private PoiResultScreenNoSpellerHmiListener initPoiResultScreenNoSpellerHmiListener() {
        PoiResultScreenNoSpellerModelAccess poiResultScreenNoSpellerModelAccess = PoiScreensEvo.getPoiResultScreenNoSpellerModelAccess(this.env, this.iconHandler, this.routeManager, this.vehicle, this.poiSearchArea);
        PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence = new PoiResultScreenNoSpellerInputSequence(poiResultScreenNoSpellerModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiResultScreenNoSpellerHmiListener poiResultScreenNoSpellerHmiListener = new PoiResultScreenNoSpellerHmiListener(this.env, poiResultScreenNoSpellerInputSequence, this, this.previewMapInterface, this.poiSearchArea, this.extractor);
        return poiResultScreenNoSpellerHmiListener;
    }

    private PoiResultScreenWithMatchSpellerHmiListener initPoiResultScreenWithMatchSpellerHmiListener() {
        PoiResultScreenWithMatchSpellerHmiListener poiResultScreenWithMatchSpellerHmiListener;
        PoiResultScreenWithMatchSpellerModelAccess poiResultScreenWithMatchSpellerModelAccess = PoiScreensEvo.getPoiResultScreenWithMatchSpellerModelAccess(this.env, this.iconHandler, this.routeManager, this.vehicle, this.poiSearchArea);
        if (Util.isHURegionAsia()) {
            PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia = new PoiResultScreenWithMatchSpellerInputSequenceAsia(poiResultScreenWithMatchSpellerModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.previewMapInterface, this.spellerStack, this);
            poiResultScreenWithMatchSpellerHmiListener = new PoiResultScreenWithMatchSpellerListenerAsia(this.env, poiResultScreenWithMatchSpellerInputSequenceAsia, this, this.previewMapInterface, this.poiSearchArea, this.extractor);
        } else {
            PoiResultScreenWithMatchSpellerInputSequence poiResultScreenWithMatchSpellerInputSequence = new PoiResultScreenWithMatchSpellerInputSequence(poiResultScreenWithMatchSpellerModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
            poiResultScreenWithMatchSpellerHmiListener = new PoiResultScreenWithMatchSpellerHmiListener(this.env, poiResultScreenWithMatchSpellerInputSequence, this, this.previewMapInterface, this.poiSearchArea, this.extractor);
        }
        return poiResultScreenWithMatchSpellerHmiListener;
    }

    private PoiClassScreenHmiListener initPoiClassScreenHmiListener() {
        PoiClassScreenModelAccess poiClassScreenModelAccess = PoiScreensEvo.getPoiClassScreenModelAccess(this.env);
        PoiClassScreenInputSequence poiClassScreenInputSequence = new PoiClassScreenInputSequence(poiClassScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiClassScreenHmiListener poiClassScreenHmiListener = new PoiClassScreenHmiListener(this.env, poiClassScreenInputSequence, this, this.previewMapInterface, this.poiSearchArea);
        return poiClassScreenHmiListener;
    }

    private PoiCategoryScreenHmiListener initPoiCategoryScreenHmiListener() {
        PoiCategoryScreenModelAccess poiCategoryScreenModelAccess = PoiScreensEvo.getPoiCategoryScreenModelAccess(this.env, this.iconHandler);
        PoiCategoryScreenInputSequence poiCategoryScreenInputSequence = new PoiCategoryScreenInputSequence(poiCategoryScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiCategoryScreenHmiListener poiCategoryScreenHmiListener = new PoiCategoryScreenHmiListener(this.env, poiCategoryScreenInputSequence, this, this.previewMapInterface, this.poiSearchArea);
        return poiCategoryScreenHmiListener;
    }

    private PoiBrandScreenHmiListener initPoiBrandScreenHmiListener() {
        PoiBrandScreenModelAccess poiBrandScreenModelAccess = PoiScreensEvo.getPoiBrandScreenModelAccess(this.env, this.iconHandler);
        PoiBrandScreenInputSequence poiBrandScreenInputSequence = new PoiBrandScreenInputSequence(poiBrandScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiBrandScreenHmiListener poiBrandScreenHmiListener = new PoiBrandScreenHmiListener(this.env, poiBrandScreenInputSequence, this, this.previewMapInterface, this.poiSearchArea);
        return poiBrandScreenHmiListener;
    }

    private PoiBrandResultScreenNoSpellerHmiListener initPoiBrandResultScreenNoSpellerHmiListener() {
        PoiBrandResultScreenNoSpellerModelAccess poiBrandResultScreenNoSpellerModelAccess = PoiScreensEvo.getPoiBrandResultScreenNoSpellerModelAccess(this.env, this.iconHandler, this.routeManager, this.vehicle, this.poiSearchArea);
        PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence = new PoiBrandResultScreenNoSpellerInputSequence(poiBrandResultScreenNoSpellerModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiBrandResultScreenNoSpellerHmiListener poiBrandResultScreenNoSpellerHmiListener = new PoiBrandResultScreenNoSpellerHmiListener(this.env, poiBrandResultScreenNoSpellerInputSequence, this, this.previewMapInterface, this.poiSearchArea, this.extractor);
        return poiBrandResultScreenNoSpellerHmiListener;
    }

    private PoiParentChildCategoryScreenHmiListener initPoiParentChildCategoryScreenHmiListener() {
        PoiParentChildCategoryScreenModelAccess poiParentChildCategoryScreenModelAccess = PoiScreensEvo.getPoiParentChildCategoryScreenModelAccess(this.env, this.iconHandler, this.routeManager, this.vehicle);
        PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence = new PoiParentChildCategoryScreenInputSequence(poiParentChildCategoryScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiParentChildCategoryScreenHmiListener poiParentChildCategoryScreenHmiListener = new PoiParentChildCategoryScreenHmiListener(this.env, poiParentChildCategoryScreenInputSequence, this, this.previewMapInterface, this.poiSearchArea);
        return poiParentChildCategoryScreenHmiListener;
    }

    private PoiParentChildResultScreenHmiListener initPoiParentChildResultScreenHmiListener() {
        PoiParentChildResultScreenModelAccess poiParentChildResultScreenModelAccess = PoiScreensEvo.getPoiParentChildResultScreenModelAccess(this.env, this.iconHandler, this.routeManager, this.vehicle);
        PoiParentChildResultScreenInputSequence poiParentChildResultScreenInputSequence = Util.isHURegionAsia() ? new PoiParentChildResultScreenInputSequenceAsia(poiParentChildResultScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this) : new PoiParentChildResultScreenInputSequence(poiParentChildResultScreenModelAccess, this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, (IPoiManager)this);
        PoiParentChildResultScreenHmiListener poiParentChildResultScreenHmiListener = new PoiParentChildResultScreenHmiListener(this.env, poiParentChildResultScreenInputSequence, this, this.previewMapInterface, this.poiSearchArea, this.extractor);
        return poiParentChildResultScreenHmiListener;
    }

    private PoiParkingNearDestinationScreenHmiListener initPoiParkingNearDestinationScreenHmiListener() {
        PoiParkingNearDestinationScreenModelAccess poiParkingNearDestinationScreenModelAccess = PoiScreensEvo.getPoiParkingNearDestinationModelAccess(this.env, this.iconHandler, this.routeManager);
        PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence = new PoiParkingNearDestinationScreenInputSequence(this.commandListFactory, this.poiSearchArea, this.env, this.spellerStack, poiParkingNearDestinationScreenModelAccess, (IPoiManager)this);
        PoiParkingNearDestinationScreenHmiListener poiParkingNearDestinationScreenHmiListener = new PoiParkingNearDestinationScreenHmiListener(this.env, this, this.previewMapInterface, this.poiSearchArea, poiParkingNearDestinationScreenInputSequence, this.extractor);
        return poiParkingNearDestinationScreenHmiListener;
    }

    private AbstractPoiRightDrawerHmiListener initPoiRightDrawerHmiListener() {
        return new PoiRightDrawerHmiListener(this.env, this.commandListFactory, this.naviFavoriteHandler, this.mapInterface, this.navAdbHandler, this, this.telService, this.detailsScreen);
    }

    private PoiExternalHmiListener initPoiExternalHmiListener() {
        return new PoiExternalHmiListener(this.env, this, this.previewMapInterface, this.poiSearchArea, this.commandListFactory);
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.logChannel.log(-2137614336, "%1#updatePoiSubstringSearchStatus(%2)", (Object)this.CLASS_NAME, (Object)valueListStatus);
        SpellerContext spellerContext = this.spellerStack.getActiveSC();
        if (spellerContext != null) {
            int n;
            int n2 = spellerContext.getContextID();
            this.logChannel.log(-2137614336, "%1#updatePoiSubstringSearchStatus() - activeContextId=%2", (Object)this.CLASS_NAME, (long)n2);
            PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence = this.poiResultScreenWithSpellerHmiListener.getPoiResultScreenWithSpellerInputSequence();
            PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence = this.poiResultScreenNoSpellerHmiListener.getPoiResultScreenNoSpellerInputSequence();
            PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence = this.poiBrandResultScreenNoSpellerHmiListener.getPoiBrandResultScreenNoSpellerInputSequence();
            PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence = this.poiParkingNearDestinationScreenHmiListener.getPoiParkingNearDestinationScreenInputSequence();
            PoiResultScreenWithMatchSpellerInputSequence poiResultScreenWithMatchSpellerInputSequence = this.poiResultScreenWithMatchSpellerHmiListener.getPoiResultScreenWithMatchSpellerInputSequence();
            PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence = this.poiParentChildScreenHmiListener.getPoiParentChildCategoryScreenInputSequence();
            if (n2 == poiResultScreenWithSpellerInputSequence.getSpellerContextId()) {
                this.activeListener = this.poiResultScreenWithSpellerHmiListener;
                poiResultScreenWithSpellerInputSequence.onUpdateSearchStatus(valueListStatus);
            } else if (n2 == poiResultScreenNoSpellerInputSequence.getSpellerContextId() || n2 == 115) {
                this.activeListener = this.poiResultScreenNoSpellerHmiListener;
                poiResultScreenNoSpellerInputSequence.onUpdateSearchStatus(valueListStatus);
            } else if (n2 == poiBrandResultScreenNoSpellerInputSequence.getSpellerContextId()) {
                this.activeListener = this.poiBrandResultScreenNoSpellerHmiListener;
                poiBrandResultScreenNoSpellerInputSequence.onUpdateSearchStatus(valueListStatus);
            } else if (n2 == poiParkingNearDestinationScreenInputSequence.getSpellerContextId() || n2 == 55) {
                this.activeListener = this.poiParkingNearDestinationScreenHmiListener;
                poiParkingNearDestinationScreenInputSequence.onUpdateSearchStatus(valueListStatus);
            } else if (n2 == poiResultScreenWithMatchSpellerInputSequence.getSpellerContextId()) {
                this.activeListener = this.poiResultScreenWithMatchSpellerHmiListener;
                poiResultScreenWithMatchSpellerInputSequence.onUpdateSearchStatus(valueListStatus);
            } else if (n2 == poiParentChildCategoryScreenInputSequence.getSpellerContextId()) {
                this.activeListener = this.poiParentChildScreenHmiListener;
            } else {
                this.logChannel.log(-1601830656, "%1#updatePoiSubstringSearchStatus - active context id available but matching was not possible.", (Object)this.CLASS_NAME);
            }
            if (this.isSearchStarted(valueListStatus) && this.activeListener != null) {
                this.activeListener.updateSearchStarted();
            }
            if ((n = valueListStatus.numberOfAvailableItems) > 0 && this.activeListener != null) {
                this.previewMapPosible = true;
                this.activeListener.updateResultsAvailable();
            } else {
                this.previewMapPosible = false;
            }
        } else {
            this.logChannel.log(-2137614336, "%1#updatePoiSubstringSearchStatus() was called but there is no active speller context.", (Object)this.CLASS_NAME);
        }
    }

    private boolean isSearchStarted(ValueListStatus valueListStatus) {
        return valueListStatus.getStatus() == 2 && valueListStatus.getNumberOfAvailableItems() == 0 && valueListStatus.getDistance() == 0;
    }

    private void resetPoiSubstringSearchStatus() {
        this.updatePoiSubstringSearchStatus(this.initialSubstringSearchStatus);
    }

    @Override
    public void destPOIHKReturn(int n, int n2) {
        this.logChannel.log(-2137614336, "%1#destPOIHKReturn(%2, %3)", (Object)this.CLASS_NAME, (long)n, (long)n2);
        SpellerStack$StackElement spellerStack$StackElement = null;
        boolean bl = false;
        switch (n2) {
            case 1: {
                bl = true;
                break;
            }
            case 201: {
                spellerStack$StackElement = this.spellerStack.pop();
                if (this.env.getChoiceModel(1902080).getValue() != 1) break;
                spellerStack$StackElement = this.spellerStack.pop();
                if (this.env.getChoiceModel(18679296).getValue() != 1) break;
                spellerStack$StackElement = this.spellerStack.pop();
                break;
            }
            case 501: {
                spellerStack$StackElement = this.spellerStack.pop();
                if (this.env.getChoiceModel(18679296).getValue() != 1) break;
                spellerStack$StackElement = this.spellerStack.pop();
                break;
            }
            case 601: {
                spellerStack$StackElement = this.spellerStack.pop();
                if (this.env.getChoiceModel(-1541732864).getValue() == 1) {
                    spellerStack$StackElement = this.spellerStack.pop();
                }
                if (this.poiWorkFlowManager.getSpellerScreenBreadcrumb(this.env) != 6) break;
                this.poiWorkFlowManager.setSpellerScreenBreadcrumb(this.env, -1);
                break;
            }
            case 1206: {
                break;
            }
            default: {
                spellerStack$StackElement = this.spellerStack.pop();
            }
        }
        this.resetPoiSubstringSearchStatus();
        if (bl) {
            this.logChannel.log(-2137614336, "%1#destPOIHKReturn: starting poi main screen", (Object)this.CLASS_NAME);
            this.startPoiMainScreen(true, false);
        } else if (spellerStack$StackElement != null) {
            boolean bl2;
            this.logChannel.log(-2137614336, "%1#destPOIHKReturn: Element popped from SpellerStack: %2", (Object)this.CLASS_NAME, (Object)spellerStack$StackElement);
            CommandList commandList = this.commandListFactory.createCommandList(0);
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
            boolean bl3 = n2 == 601;
            boolean bl4 = false;
            SpellerContext spellerContext = this.spellerStack.getActiveSC();
            if (spellerContext != null) {
                bl4 = spellerContext.getContextID() == 14;
            }
            boolean bl5 = this.env.getChoiceModel(-1541732864).getValue() > 1;
            boolean bl6 = bl2 = this.poiSearchArea.getSearchContext() == 1;
            if (!Util.isHURegionAsia() && bl2 && bl5 && bl3 && bl4) {
                IPoiBrandScreenModelAccess iPoiBrandScreenModelAccess = this.getPoiBrandScreenHmiListener().getPoiBrandScreenInputSequence().getPoiBrandScreenModelAccess();
                commandList.add(new PoiModelStartCommand(iPoiBrandScreenModelAccess));
                commandList.add(new NewModelUpdateFullListCommand(iPoiBrandScreenModelAccess, this.commandListFactory));
            }
            commandList.add(new PoiManager$1(this, new StringBuffer().append(this.CLASS_NAME).append("#destPOIHKReturn#preparePreviewMap").toString()));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#destPOIHKReturn").toString());
        } else if (n2 != 1206) {
            this.logChannel.log(-1601830656, "%1#destPOIHKReturn: Element popped from SpellerStack but element is null!", (Object)this.CLASS_NAME);
        }
    }

    public IRouteManager getRouteManager() {
        return this.routeManager;
    }

    public IStartGuidanceToDestinationSequence getStartGuidanceToDestinationSequence() {
        return this.startGuidanceToDestinationSequence;
    }

    private void preparePreviewMapForCurrentScreen() {
        SpellerContext spellerContext = this.spellerStack.getActiveSC();
        if (spellerContext != null) {
            int n = spellerContext.getContextID();
            this.logChannel.log(-2137614336, "%1#preparePreviewMapForCurrentScreen() - trying to update preview map for context id: '%2'", (Object)this.CLASS_NAME, (long)n);
            if (n == this.poiMainScreenHmiListener.getPoiMainScreenInputSequence().getSpellerContextId() || n == 105) {
                this.poiMainScreenHmiListener.preparePreviewMap();
            } else if (n == this.poiResultScreenWithSpellerHmiListener.getPoiResultScreenWithSpellerInputSequence().getSpellerContextId()) {
                this.poiResultScreenWithSpellerHmiListener.preparePreviewMap();
            } else if (n == this.poiResultScreenNoSpellerHmiListener.getPoiResultScreenNoSpellerInputSequence().getSpellerContextId() || n == 115) {
                this.poiResultScreenNoSpellerHmiListener.preparePreviewMap();
            } else if (n == this.poiResultScreenWithMatchSpellerHmiListener.getPoiResultScreenWithMatchSpellerInputSequence().getSpellerContextId()) {
                this.poiResultScreenWithMatchSpellerHmiListener.preparePreviewMap();
            } else if (n == this.poiClassScreenHmiListener.getPoiClassScreenInputSequence().getSpellerContextId()) {
                this.poiClassScreenHmiListener.preparePreviewMap();
            } else if (n == this.poiCategoryScreenHmiListener.getPoiCategoryScreenInputSequence().getSpellerContextId() || n == 114) {
                this.poiCategoryScreenHmiListener.preparePreviewMap();
            } else if (n == this.poiBrandScreenHmiListener.getPoiBrandScreenInputSequence().getSpellerContextId()) {
                this.poiBrandScreenHmiListener.preparePreviewMap();
                this.poiResultScreenNoSpellerHmiListener.preparePreviewMap();
            } else if (n == this.poiBrandResultScreenNoSpellerHmiListener.getPoiBrandResultScreenNoSpellerInputSequence().getSpellerContextId()) {
                this.poiBrandResultScreenNoSpellerHmiListener.preparePreviewMap();
            } else if (n == this.poiParkingNearDestinationScreenHmiListener.getPoiParkingNearDestinationScreenInputSequence().getSpellerContextId()) {
                this.poiParkingNearDestinationScreenHmiListener.preparePreviewMap();
            } else if (n == this.poiParentChildScreenHmiListener.getPoiParentChildCategoryScreenInputSequence().getSpellerContextId()) {
                this.poiParentChildScreenHmiListener.preparePreviewMap();
            } else if (n == this.poiParentChildResultScreenHmiListener.getParentChildResultScreenInputSequence().getSpellerContextId()) {
                this.poiParentChildResultScreenHmiListener.preparePreviewMap();
            } else if (n != 54) {
                this.logChannel.log(-1601830656, "%1#preparePreviewMapForCurrentScreen() - found no match for context id: '%2'. Unable to update the preview map.", (Object)this.CLASS_NAME, (long)n);
            }
        }
    }

    @Override
    public void startPoiMainScreen(boolean bl, boolean bl2) {
        this.startPoiMainScreen(bl, bl2, 10, null);
    }

    private synchronized void startPoiMainScreen(boolean bl, boolean bl2, int n, IAdditionalStateInfo iAdditionalStateInfo) {
        if (!this.poiCommandListMonitor.isActive()) {
            this.logChannel.log(-2137614336, "%1#startPoiMainScreen - command list is not running, starting POI", (Object)this.CLASS_NAME);
            CommandList commandList = this.commandListFactory.createCommandList();
            if (iAdditionalStateInfo != null) {
                commandList.put("SEARCH_AREA_RESTORABLE", iAdditionalStateInfo);
            }
            commandList.add(new PoiManager$2(this, "Initial calls for starting POI main screen", bl2));
            if (bl) {
                commandList.add(new ResetSpellerStackCommand());
            }
            commandList.addMonitor(this.poiCommandListMonitor);
            this.executePoiSelectionEvent(commandList, n);
        } else {
            this.logChannel.log(-2137614336, "%1#startPoiMainScreen - the command list to start POI is still running - ignoring further calls.", (Object)this.CLASS_NAME);
        }
    }

    public void startPoiAreaCityInputSequence(IPoiSearchAreaHandler iPoiSearchAreaHandler, PoiAreaCityZipInputModelAccess poiAreaCityZipInputModelAccess) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiManager$3(this));
        iPoiSearchAreaHandler.startPoiAreaCityZipInputSequence(poiAreaCityZipInputModelAccess, commandList, true);
    }

    @Override
    public synchronized void allowRestartOfRRDCalculation() {
        int n = this.poiSearchArea.getSearchContext();
        switch (n) {
            case 2: 
            case 3: 
            case 4: {
                this.allowRestartRRDCalculation = false;
                if (!this.logChannel.isDebug2()) break;
                this.logChannel.log(14808325, "%1#allowRestartOfRRDCalculation not allowed SearchContext: %2", (Object)this.CLASS_NAME, (long)n);
                break;
            }
            case 0: 
            case 1: 
            case 5: {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "%1#allowRestartOfRRDCalculation allowed SearchContext: %2", (Object)this.CLASS_NAME, (long)n);
                }
                this.allowRestartRRDCalculation = true;
                break;
            }
            default: {
                this.logChannel.log(1078071040, "%1#allowRestartOfRRDCalculation no valid searchContext : %2", (Object)this.CLASS_NAME, (long)n);
            }
        }
    }

    public synchronized void restartRRDForCurrentContext() {
        this.logChannel.log(-2137614336, "%1#restartRRDForCurrentContext - allowRestartRRDCalculation=%2", (Object)this.CLASS_NAME, (Object)this.allowRestartRRDCalculation);
        if (this.allowRestartRRDCalculation) {
            this.allowRestartRRDCalculation = false;
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new PoiManager$4(this, "Restart RRD"));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#restartRRDForCurrentContext").toString());
        }
    }

    @Override
    public void exitRRD() {
        this.rrdListener.exitRRD(this.getRRDListType());
    }

    private int getRRDListType() {
        int n = 4;
        SpellerContext spellerContext = this.spellerStack.getActiveSC();
        if (spellerContext != null) {
            int n2 = spellerContext.getContextID();
            if (n2 == this.poiResultScreenWithSpellerHmiListener.getPoiResultScreenWithSpellerInputSequence().getSpellerContextId()) {
                n = 4;
            } else if (n2 == this.poiResultScreenNoSpellerHmiListener.getPoiResultScreenNoSpellerInputSequence().getSpellerContextId()) {
                n = 0;
            } else if (n2 == this.poiBrandResultScreenNoSpellerHmiListener.getPoiBrandResultScreenNoSpellerInputSequence().getSpellerContextId()) {
                n = 1;
            }
        } else {
            this.logChannel.log(-2137614336, "%1#getRRDListType - active Speller Context is null.", (Object)this.CLASS_NAME);
        }
        this.logChannel.log(-2137614336, "%1#getRRDListType - listType=%2", (Object)this.CLASS_NAME, (long)n);
        return n;
    }

    @Override
    public void hideSearchArea() {
        this.searchAreaVisibleChoice.setValue(0);
    }

    @Override
    public void showSearchArea() {
        this.searchAreaVisibleChoice.setValue(1);
    }

    private void resetPreviewMapsForAllListeners() {
        for (int i2 = this.allListeners.length - 1; i2 >= 0; --i2) {
            this.allListeners[i2].preparePreviewMap();
        }
    }

    public boolean isPreviewMapPossible() {
        return this.previewMapPosible;
    }

    public CommandList getCommandlist() {
        return this.commandListFactory.createCommandList();
    }

    @Override
    public void showPoiDetailScreen(NavLocation navLocation) {
        this.detailsScreen.enterDetailsScreen(navLocation);
    }

    @Override
    public void resetPoiSearchArea() {
        if (this.poiSearchArea.getSearchContext() == 1 && !this.inputModeManager.isSdsActive()) {
            this.poiSearchArea.setSearchContext(0);
        }
    }

    static /* synthetic */ void access$000(PoiManager poiManager) {
        poiManager.preparePreviewMapForCurrentScreen();
    }

    static /* synthetic */ void access$100(PoiManager poiManager) {
        poiManager.resetPreviewMapsForAllListeners();
    }

    static /* synthetic */ int access$200(PoiManager poiManager) {
        return poiManager.getRRDListType();
    }

    static /* synthetic */ IRRDListener access$300(PoiManager poiManager) {
        return poiManager.rrdListener;
    }
}

