/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiScreensEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviADBService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.AbstractPoiWorkFlowManager;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.POIAbortCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiGetCategoryTypesFromUIdCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiPrepareParentChildCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiPrepareParentChildCommandAsia;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildResultScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SearchAreaRestoreState;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiWorkFlowManager
extends AbstractPoiWorkFlowManager {
    private PoiManager poiManager;
    private final IVehicle vehicle;
    private final ICommandListFactory commandListFactory;
    private final SpellerStack spellerStack;
    private final IconHandler iconHandler;
    private final INavigationInputModeManager inputModeManager;
    private final HomeAddressHandler homeAddressHandler;
    private final IRouteManager routeManager;
    private final ADBInterAppService adbInterAppService;
    private final PoiSearchAreaSequence searchAreaSequence;
    private static final int SDS_MAX_RESULTS = 50;
    private static final int SUBTITLE_DYNAMIC_OFFSET = 6;
    private static final int SUBTITLE_STATIC_OFFSET = 0;
    private int oldBreadcrumbChoice;
    private int oldBrandsAvailableChoice;

    public PoiWorkFlowManager(IVehicle iVehicle, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IconHandler iconHandler, INavigationInputModeManager iNavigationInputModeManager, HomeAddressHandler homeAddressHandler, IRouteManager iRouteManager, ADBInterAppService aDBInterAppService, PoiSearchAreaSequence poiSearchAreaSequence) {
        this.vehicle = iVehicle;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.iconHandler = iconHandler;
        this.inputModeManager = iNavigationInputModeManager;
        this.homeAddressHandler = homeAddressHandler;
        this.routeManager = iRouteManager;
        this.adbInterAppService = aDBInterAppService;
        this.searchAreaSequence = poiSearchAreaSequence;
    }

    public void setPoiManager(PoiManager poiManager) {
        this.poiManager = poiManager;
    }

    public CommandList handleWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        commandList.setErrorCommand(new POIAbortCommand(navigationEnv));
        navigationEnv.getPOILogChannel().log(10000000, "%1#handleWorkFlow(%2)", (Object)this.CLASS_NAME, (Object)Integer.toString(n));
        if (this.isPoiMainScreen(n)) {
            return this.handlePoiMainScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiResultScreenWithSpeller(n)) {
            return this.handlePoiResultScreenWithSpellerWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiResultScreenNoSpeller(n)) {
            return this.handlePoiResultScreenNoSpellerWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiResultScreenWithMatchSpeller(n)) {
            return this.handlePoiResultScreenWithMatchSpellerWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiClassScreen(n)) {
            return this.handlePoiClassScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiCategoryScreen(n)) {
            return this.handlePoiCategoryScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiBrandScreen(n)) {
            return this.handlePoiBrandScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiBrandResultScreen(n)) {
            return this.handlePoiBrandResultScreenNoSpellerWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiParentChildCategoryScreen(n)) {
            return this.handlePoiParentChildCategoryScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiParentChildResultScreen(n)) {
            return this.handlePoiParentChildResultScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiParkingNearDestinationScreen(n)) {
            return this.handlePoiParkingNearDestinationScreenWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        if (this.isPoiSDS(n)) {
            return this.handlePoiSDSWorkFlow(commandList, n, poiSearchArea, navigationEnv);
        }
        navigationEnv.getPOILogChannel().log(100000, "%1#handleWorkFlow: couldn't handle screen with id %2. Returning empty command list.", (Object)this.CLASS_NAME, (long)n);
        return commandList;
    }

    private CommandList handlePoiMainScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (n != 10) {
            this.poiManager.enterPoiScreens();
        }
        switch (n) {
            case 4: {
                this.createPoiMainScreenSearchAreaWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 5: {
                this.createPoiMainScreenSearchByNameWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 2: {
                this.createPoiMainScreenClassesWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 3: {
                this.createPoiMainScreenPersonalPoiWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 1: {
                this.createPoiMainScreenTopPoiSelectedWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 10: {
                this.createPoiMainScreenStartWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 13: {
                this.createPoiMainScreenStartWithHiddenSearchAreaWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 11: {
                this.createPoiHybridSearchWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiMainScreenWorkFlow screenEventID(%2) is in range of PoiMainScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiMainScreenStartWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(8)));
        commandList.add(this.poiManager.getPoiMainScreenHmiListener().getStartCommandList());
    }

    private void createPoiMainScreenStartWithHiddenSearchAreaWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        Object object = commandList.get("SEARCH_AREA_RESTORABLE");
        if (object instanceof IAdditionalStateInfo) {
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{(IAdditionalStateInfo)object}, new SpellerContext(105)));
        } else {
            commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(105)));
            navigationEnv.getPOILogChannel().log(100000, "%1#createPoiMainScreenStartWithHiddenSearchAreaWorkFlow - found no valid IAdditionalStateInfo object! Restoring previous search area will not work!", (Object)this.CLASS_NAME);
        }
        commandList.add(this.poiManager.getPoiMainScreenHmiListener().getStartCommandList());
    }

    private void createPoiMainScreenSearchAreaWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiMainScreenSearchAreaWorkFlow", (Object)this.CLASS_NAME);
        }
    }

    private void createPoiMainScreenSearchByNameWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiMainScreenSearchByNameWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiMainScreenSearchByNameWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
        } else {
            int n = poiSearchArea.getSearchContext();
            this.setSpellerScreenBreadcrumb(navigationEnv, 0);
            switch (n) {
                case 5: {
                    commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(11), null));
                    commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandList());
                    break;
                }
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(9), null));
                    commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandList());
                    break;
                }
                default: {
                    navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiMainScreenSearchByNameWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                }
            }
        }
    }

    private void createPoiHybridSearchWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(11), null));
        commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandList());
    }

    private void createPoiMainScreenClassesWorkFlow(CommandList commandList, final PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiMainScreenClassesWorkFlow", (Object)this.CLASS_NAME);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(12), null));
        commandList.add(this.poiManager.getPoiClassScreenHmiListener().getStartCommandList());
        commandList.add(new NavCommand("Select Single Class Or Do Nothing"){

            public void execute() {
                long l = this.dsiResponseContainer.getLispValueListCount();
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                if (l == 1L && lIValueList != null && lIValueList.getList() != null && lIValueList.getList().length == 1) {
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    this.getCommandList().put("CurrentSelection", lIValueListElement);
                    this.logger.log(10000000, "%1#navCommand#execute() - continue directly to results screen", (Object)this.CLASS_NAME);
                    CommandList commandList = PoiWorkFlowManager.this.commandListFactory.createCommandList();
                    PoiWorkFlowManager.this.createPoiClassScreenListElementWorkFlow(commandList, poiSearchArea, this.env);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
    }

    private void createPoiMainScreenPersonalPoiWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiMainScreenPersonalPoiWorkFlow", (Object)this.CLASS_NAME);
        }
        commandList.add(new LIGetStateCommand(this.spellerStack, null, 10, null, new SpellerContext(114), null));
        commandList.add(this.poiManager.getPoiClassScreenHmiListener().getStartCommandList());
        commandList.add(this.poiManager.getPoiCategoryScreenHmiListener().getStartCommandListByUID(10));
    }

    private void createPoiMainScreenTopPoiSelectedWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        this.setSpellerScreenBreadcrumb(navigationEnv, 5);
        navigationEnv.getChoiceModel(400960).setValue(1);
        int n = navigationEnv.getChoiceModel(402577).getValue();
        navigationEnv.getChoiceModel(402724).setValue(n + 6);
        navigationEnv.getChoiceModel(400959).setValue(0);
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiMainScreenTopPoiSelectedWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(10), null));
        commandList.add(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getStartCommandListWithElement());
    }

    private CommandList handlePoiResultScreenWithSpellerWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 101: {
                this.createPoiResultScreenWithSpellerElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiResultScreenWithSpellerWorkFlow screenEventID(%2) is in range of PoiResultScreenWithSpeller but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiResultScreenWithSpellerElementWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenWithSpellerElementWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(5), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiPrepareParentChildCommand(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getPoiResultScreenWithSpellerInputSequence().getModelAccess()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiResultScreenWithSpellerElementWorkFlow decide the followup action").toString()){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(32774)) {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getPoiParentChildCategoryScreenHmiListener().getStartCommandList());
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                }
            }
        });
    }

    private CommandList handlePoiResultScreenNoSpellerWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 202: {
                this.createPoiResultScreenNoSpellerBrandWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 203: {
                this.createPoiResultScreenNoSpellerListElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 201: {
                if (navigationEnv.getChoiceModel(401255).getValue() == 1) {
                    this.createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow(commandList, poiSearchArea, navigationEnv);
                    break;
                }
                this.createPoiResultScreenNoSpellerSearchByNameWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiResultScreenNoSpellerWorkFlow screenEventID(%2) is in range of PoiResultScreenNoSpeller but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiResultScreenNoSpellerBrandWorkFlow(CommandList commandList, final PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        SpellerStack.StackElement stackElement;
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerBrandWorkFlow", (Object)this.CLASS_NAME);
        }
        if ((stackElement = this.spellerStack.peekLastSelection()) != null) {
            commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(14), null));
            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
            commandList.put("CurrentSelection", stackElement.element);
            commandList.add(this.poiManager.getPoiBrandScreenHmiListener().getStartCommandList());
            commandList.add(new NavCommand("Select Single Brand Or Do Nothing"){

                public void execute() {
                    long l = this.dsiResponseContainer.getLispValueListCount();
                    LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                    if (l == 1L && lIValueList != null && lIValueList.getList() != null && lIValueList.getList().length == 1) {
                        LIValueListElement lIValueListElement = lIValueList.getList()[0];
                        this.getCommandList().put("CurrentSelection", lIValueListElement);
                        this.logger.log(10000000, "%1#navCommand#execute() - continue directly to brand result screen", (Object)this.CLASS_NAME);
                        CommandList commandList = PoiWorkFlowManager.this.commandListFactory.createCommandList();
                        PoiWorkFlowManager.this.createPoiBrandScreenListElementWorkFlow(commandList, poiSearchArea, this.env);
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                    } else {
                        this.getCommandList().commandFinished();
                    }
                }
            });
        } else {
            navigationEnv.getPOILogChannel().log(10000000, "%1#createPoiResultScreenNoSpellerBrandWorkFlow - retreived null objects from speller stack.", (Object)this.CLASS_NAME);
        }
    }

    private void createPoiResultScreenNoSpellerListElementWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerListElementWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(5), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiPrepareParentChildCommand(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getPoiResultScreenNoSpellerInputSequence().getModelAccess()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiResultScreenNoSpellerListElementWorkFlow decide the followup action").toString()){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(32774)) {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getPoiParentChildCategoryScreenHmiListener().getStartCommandList());
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                }
            }
        });
    }

    private void createPoiResultScreenNoSpellerSearchByNameWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerSearchByNameWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "#createPoiResultScreenNoSpellerSearchByNameWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
        } else {
            int n = poiSearchArea.getSearchContext();
            SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
            if (stackElement != null) {
                LIValueListElement lIValueListElement = stackElement.element;
                commandList.put("CurrentSelection", lIValueListElement);
                if (PoiUtil.useNvcTextSearch(navigationEnv) || n == 5) {
                    commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(11), null));
                    commandList.add(new LIRestoreStateCommand(this.spellerStack.peekLastSelection().spellerData));
                    commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandListWithElement());
                } else if (PoiUtil.useFreeTextSearch(navigationEnv)) {
                    switch (n) {
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: {
                            commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(9), null));
                            commandList.add(new LIRestoreStateCommand(this.spellerStack.peekLastSelection().spellerData));
                            commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandListWithElement());
                            break;
                        }
                        default: {
                            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiResultScreenNoSpellerSearchByNameWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                            break;
                        }
                    }
                } else {
                    navigationEnv.getPOILogChannel().log(10000, "%1#createPoiResultScreenNoSpellerSearchByNameWorkFlow - NO TYPE OF SPELLER FOR SEARCH BY NAME IS DEFINED!", (Object)this.CLASS_NAME);
                }
            }
        }
    }

    private void createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (this.spellerStack.getActiveSC().getContextID() == 115) {
            this.setSpellerScreenBreadcrumb(navigationEnv, 8);
        } else if (this.spellerStack.getActiveSC().getContextID() == 10) {
            this.setSpellerScreenBreadcrumb(navigationEnv, 5);
        }
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
        } else {
            int n = poiSearchArea.getSearchContext();
            SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
            if (stackElement != null) {
                switch (n) {
                    case 5: {
                        if (stackElement.element == null) {
                            if (navigationEnv.getPOILogChannel().isDebug2()) {
                                navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow --> StackElement is null", (Object)this.CLASS_NAME);
                            }
                            commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(11), null));
                            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                            commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandListByUID(10));
                            break;
                        }
                        if (navigationEnv.getPOILogChannel().isDebug2()) {
                            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow --> StackElement.element = %2", (Object)this.CLASS_NAME, (Object)stackElement.element);
                        }
                        commandList.add(new LIGetStateCommand(this.spellerStack, stackElement.element, -1, null, new SpellerContext(11), null));
                        commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                        commandList.put("CurrentSelection", stackElement.element);
                        commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandListWithElement());
                        break;
                    }
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        if (stackElement.element == null) {
                            if (navigationEnv.getPOILogChannel().isDebug2()) {
                                navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow --> StackElement is null", (Object)this.CLASS_NAME);
                            }
                            commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(9), null));
                            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                            commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandListByUID(10));
                            break;
                        }
                        if (navigationEnv.getPOILogChannel().isDebug2()) {
                            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow --> StackElement.element = %2", (Object)this.CLASS_NAME, (Object)stackElement.element);
                        }
                        commandList.add(new LIGetStateCommand(this.spellerStack, stackElement.element, -1, null, new SpellerContext(9), null));
                        commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                        commandList.put("CurrentSelection", stackElement.element);
                        commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandListWithElement());
                        break;
                    }
                    default: {
                        navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiResultScreenNoSpellerSearchByNamePPoiWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                    }
                }
            }
        }
    }

    private CommandList handlePoiResultScreenWithMatchSpellerWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 301: {
                this.createPoiResultScreenWithMatchSpellerListElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 302: {
                this.createPoiResultScreenWithMatchSpellerListElementWorkFlowAsia(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiResultScreenWithMatchSpellerWorkFlow screenEventID(%2) is in range of PoiResultScreenWithMatchSpeller but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiResultScreenWithMatchSpellerListElementWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenWithMatchSpellerListElementWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(5), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiPrepareParentChildCommand(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getPoiResultScreenNoSpellerInputSequence().getModelAccess()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiResultScreenWithMatchSpellerListElementWorkFlow decide the followup action").toString()){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(32774)) {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getPoiParentChildCategoryScreenHmiListener().getStartCommandList());
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().start(this.dsiResponseContainer.getLiCurrentLD());
                    this.getCommandList().commandFinished();
                }
            }
        });
    }

    private void createPoiResultScreenWithMatchSpellerListElementWorkFlowAsia(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiResultScreenWithMatchSpellerListElementWorkFlowAsia", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(5), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiPrepareParentChildCommandAsia(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getPoiResultScreenWithMatchSpellerInputSequence().getModelAccess()));
        commandList.add(new ModelOnElementSelectedCommand(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getPoiResultScreenWithMatchSpellerInputSequence().getModelAccess(), lIValueListElement));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiResultScreenWithMatchSpellerListElementWorkFlowAsia decide the followup action").toString()){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(32775) && this.dsiResponseContainer.refinementCriterionAvailable(32775)) {
                    IPoiParentChildResultScreenModelAccess iPoiParentChildResultScreenModelAccess = PoiWorkFlowManager.this.poiManager.getPoiParentChildResultScreenHmiListener().getParentChildResultScreenInputSequence().getModelAccess();
                    CommandList commandList = PoiWorkFlowManager.this.commandListFactory.createCommandList();
                    commandList.add(new PoiSetSortOrderCommand(2));
                    commandList.add(new PoiModelStartCommand(iPoiParentChildResultScreenModelAccess));
                    commandList.add(new LIStartSpellerCommand(32775, false, false, false));
                    commandList.add(new NewModelUpdateResultListCommand(iPoiParentChildResultScreenModelAccess));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                }
            }
        });
    }

    private CommandList handlePoiClassScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 401: {
                this.createPoiClassScreenListElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 402: {
                this.createPoiClassScreenSearchByNameWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiClassScreenWorkFlow screenEventID(%1) is in range of PoiClassScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiClassScreenSearchByNameWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiClassScreenSearchByNameWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiClassScreenSearchByNameWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
        } else {
            int n = poiSearchArea.getSearchContext();
            this.setSpellerScreenBreadcrumb(navigationEnv, 1);
            if (PoiUtil.useNvcTextSearch(navigationEnv) || n == 5) {
                commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(11), null));
                commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandList());
            } else if (PoiUtil.useFreeTextSearch(navigationEnv)) {
                switch (n) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(9), null));
                        commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandList());
                        break;
                    }
                    default: {
                        navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiClassScreenSearchByNameWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                        break;
                    }
                }
            } else {
                navigationEnv.getPOILogChannel().log(10000, "%1#createPoiClassScreenSearchByNameWorkFlow - NO TYPE OF SPELLER FOR SEARCH BY NAME IS DEFINED!", (Object)this.CLASS_NAME);
            }
        }
    }

    private void createPoiClassScreenListElementWorkFlow(CommandList commandList, final PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        this.setSpellerScreenBreadcrumb(navigationEnv, 1);
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiClassScreenListElementWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(13), null));
        commandList.add(this.poiManager.getPoiCategoryScreenHmiListener().getStartCommandList());
        commandList.add(new NavCommand("Select Single Category Or Do Nothing"){

            public void execute() {
                long l = this.dsiResponseContainer.getLispValueListCount();
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                if (l == 1L && lIValueList != null && lIValueList.getList() != null && lIValueList.getList().length == 1) {
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    this.getCommandList().put("CurrentSelection", lIValueListElement);
                    this.logger.log(10000000, "%1#navCommand#execute() - continue directly to results screen", (Object)this.CLASS_NAME);
                    CommandList commandList = PoiWorkFlowManager.this.commandListFactory.createCommandList();
                    commandList.put("CurrentSelection", lIValueListElement);
                    PoiWorkFlowManager.this.createPoiCategoryScreenListElementWorkFlow(commandList, poiSearchArea, this.env);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
    }

    private CommandList handlePoiCategoryScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 501: {
                if (navigationEnv.getChoiceModel(401255).getValue() == 1) {
                    this.createPoiCategoryScreenSearchByNamePPOIWorkFlow(commandList, poiSearchArea, navigationEnv);
                    break;
                }
                this.createPoiCategoryScreenSearchByNameWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 502: {
                if (navigationEnv.getChoiceModel(401255).getValue() == 1) {
                    this.createPoiCategoryScreenAllResultsPPoiWorkFlow(commandList, poiSearchArea, navigationEnv);
                    break;
                }
                this.createPoiCategoryScreenAllResultsWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 503: {
                this.createPoiCategoryScreenListElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiCategoryScreenWorkFlow screenEventID(%2) is in range of PoiCategoryScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiCategoryScreenSearchByNameWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiCategoryScreenSearchByNameWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "#createPoiCategoryScreenSearchByNameWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
        } else {
            int n = poiSearchArea.getSearchContext();
            SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
            this.setSpellerScreenBreadcrumb(navigationEnv, 2);
            this.setSpellerScreenBreadcrumb(navigationEnv, 3);
            navigationEnv.getPOILogChannel().log(10000000, "%1#createPoiCategoryScreenSearchByNameWorkFlow STACKELEMENT=%2", (Object)this.CLASS_NAME, (Object)stackElement);
            if (stackElement != null) {
                LIValueListElement lIValueListElement = stackElement.element;
                commandList.put("CurrentSelection", lIValueListElement);
                if (PoiUtil.useNvcTextSearch(navigationEnv) || n == 5) {
                    commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(11), null));
                    commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                    commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandListWithElement());
                } else if (PoiUtil.useFreeTextSearch(navigationEnv)) {
                    switch (n) {
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: {
                            commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(9), null));
                            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                            commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandListWithElement());
                            break;
                        }
                        default: {
                            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiCategoryScreenSearchByNameWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                            break;
                        }
                    }
                } else {
                    navigationEnv.getPOILogChannel().log(10000, "%1#createPoiCategoryScreenSearchByNameWorkFlow - NO TYPE OF SPELLER FOR SEARCH BY NAME IS DEFINED!", (Object)this.CLASS_NAME);
                }
            }
        }
    }

    private void createPoiCategoryScreenSearchByNamePPOIWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiCategoryScreenSearchByNameWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiCategoryScreenSearchByNameWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
        } else {
            this.setSpellerScreenBreadcrumb(navigationEnv, 8);
            int n = poiSearchArea.getSearchContext();
            SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
            if (stackElement != null) {
                switch (n) {
                    case 5: {
                        commandList.add(new LIGetStateCommand(this.spellerStack, null, 10, null, new SpellerContext(11), null));
                        commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                        commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandListByUID(10));
                        break;
                    }
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        commandList.add(new LIGetStateCommand(this.spellerStack, null, 10, null, new SpellerContext(9), null));
                        commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                        commandList.add(this.poiManager.getPoiClassScreenHmiListener().getStartCommandList());
                        commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandListByUID(10));
                        break;
                    }
                    default: {
                        navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiCategoryScreenSearchByNameWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                    }
                }
            }
        }
    }

    private void createPoiCategoryScreenAllResultsWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiCategoryScreenAllResultsWorkFlow", (Object)this.CLASS_NAME);
        }
        SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
        this.setSpellerScreenBreadcrumb(navigationEnv, 4);
        navigationEnv.getChoiceModel(400959).setValue(2);
        navigationEnv.getChoiceModel(400960).setValue(0);
        int n = navigationEnv.getChoiceModel(402577).getValue();
        navigationEnv.getChoiceModel(402724).setValue(n + 0);
        if (stackElement != null) {
            LIValueListElement lIValueListElement = stackElement.element;
            commandList.put("CurrentSelection", lIValueListElement);
            commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, null, new SpellerContext(10), null));
            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
            commandList.add(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getStartCommandListWithElement());
        }
    }

    private void createPoiCategoryScreenAllResultsPPoiWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiCategoryScreenAllResultsWorkFlow", (Object)this.CLASS_NAME);
        }
        SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
        this.setSpellerScreenBreadcrumb(navigationEnv, 4);
        navigationEnv.getChoiceModel(400960).setValue(0);
        int n = navigationEnv.getChoiceModel(402577).getValue();
        navigationEnv.getChoiceModel(402724).setValue(n + 0);
        if (stackElement != null) {
            commandList.add(new LIGetStateCommand(this.spellerStack, null, 10, null, new SpellerContext(115), null));
            commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
            commandList.add(this.poiManager.getPoiClassScreenHmiListener().getStartCommandList());
            commandList.add(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getStartCommandListByUID(10));
        }
    }

    private void createPoiCategoryScreenListElementWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiCategoryScreenListElementWorkFlow", (Object)this.CLASS_NAME);
        }
        this.setSpellerScreenBreadcrumb(navigationEnv, 5);
        if (this.spellerStack.getActiveSC().getContextID() == 114) {
            navigationEnv.getChoiceModel(400959).setValue(0);
        } else {
            navigationEnv.getChoiceModel(400959).setValue(2);
        }
        navigationEnv.getChoiceModel(400960).setValue(1);
        int n = navigationEnv.getChoiceModel(402577).getValue();
        navigationEnv.getChoiceModel(402724).setValue(n + 6);
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(10), null));
        commandList.add(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getStartCommandListWithElement());
    }

    private CommandList handlePoiBrandScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 601: {
                this.createPoiBrandScreenListElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiBrandScreenWorkFlow screenEventID(%2) is in range of PoiBrandScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiBrandScreenListElementWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiBrandScreenListElementWorkFlow", (Object)this.CLASS_NAME);
        }
        this.setSpellerScreenBreadcrumb(navigationEnv, 6);
        commandList.add(new NavCommand("SaveState with Element from CommandListContext"){

            public void execute() {
                LIValueListElement lIValueListElement = (LIValueListElement)this.getCommandList().get("CurrentSelection");
                this.logger.log(10000000, "%1#NavCommand#execute: element retreived: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
                this.getCommandList().commandFinishedWithPostCommand(new LIGetStateCommand(PoiWorkFlowManager.this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(15), null));
            }
        });
        commandList.add(this.poiManager.getPoiBrandResultScreenNoSpellerHmiListener().getStartCommandList());
    }

    private CommandList handlePoiBrandResultScreenNoSpellerWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 701: {
                this.createPoiBrandResultScreenNoSpellerListElementWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 702: {
                this.createPoiBrandResultScreenNoSpellerSearchByNameWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiBrandScreenWorkFlow screenEventID(%2) is in range of PoiBrandScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiBrandResultScreenNoSpellerSearchByNameWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiBrandResultScreenNoSpellerSearchByNameWorkFlow", (Object)this.CLASS_NAME);
        }
        if (poiSearchArea == null) {
            navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiBrandResultScreenNoSpellerSearchByNameWorkFlow no valid searchContext", (Object)this.CLASS_NAME);
            return;
        }
        int n = poiSearchArea.getSearchContext();
        SpellerStack.StackElement stackElement = this.spellerStack.peekLastSelection();
        if (stackElement != null) {
            LIValueListElement lIValueListElement = stackElement.element;
            commandList.put("CurrentSelection", lIValueListElement);
            if (PoiUtil.useNvcTextSearch(navigationEnv) || n == 5) {
                commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(11), null));
                commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                commandList.add(this.poiManager.getPoiResultScreenWithMatchSpellerHmiListener().getStartCommandListWithElement());
            } else if (PoiUtil.useFreeTextSearch(navigationEnv)) {
                switch (n) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(9), null));
                        commandList.add(new LIRestoreStateCommand(stackElement.spellerData));
                        commandList.add(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getStartCommandListWithElement());
                        break;
                    }
                    default: {
                        navigationEnv.getPOILogChannel().log(1000000, "%1#createPoiBrandResultScreenNoSpellerSearchByNameWorkFlow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)poiSearchArea.getSearchContext());
                        break;
                    }
                }
            } else {
                navigationEnv.getPOILogChannel().log(10000, "%1#createPoiBrandResultScreenNoSpellerSearchByNameWorkFlow - NO TYPE OF SPELLER FOR SEARCH BY NAME IS DEFINED!", (Object)this.CLASS_NAME);
            }
        }
    }

    private void createPoiBrandResultScreenNoSpellerListElementWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiBrandResultScreenNoSpellerListElementWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.getPoiUniqueId(), null, new SpellerContext(5), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiPrepareParentChildCommand(this.poiManager.getPoiResultScreenNoSpellerHmiListener().getPoiResultScreenNoSpellerInputSequence().getModelAccess()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiBrandResultScreenNoSpellerListElementWorkFlow decide the followup action").toString()){

            public void execute() {
                if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                }
            }
        });
    }

    private CommandList handlePoiParentChildCategoryScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 1003: {
                this.createPoiParentChildCategoryScreenParentElementSelectedWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 1002: {
                this.createPoiParentChildCategoryScreenListElementSelectedWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiParentChildCategoryScreenWorkFlow screenEventID(%1) is in range of PoiParentChildCategoryScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiParentChildCategoryScreenParentElementSelectedWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(5), null));
        commandList.add(new ModelOnElementSelectedCommand(this.poiManager.getPoiParentChildCategoryScreenHmiListener().getPoiParentChildCategoryScreenInputSequence().getPoiParentChildCategoryScreenModelAccess(), lIValueListElement));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiParentChildCategoryScreenParentElementSelectedWorkFlow startGuidance").toString()){

            public void execute() {
                if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                }
            }
        });
    }

    private void createPoiParentChildCategoryScreenListElementSelectedWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(5), null));
        commandList.add(this.poiManager.getPoiParentChildResultScreenHmiListener().getStartCommandList());
    }

    private CommandList handlePoiParentChildResultScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 1102: {
                this.createPoiParentChildResultScreenListElementSelectedWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiParentChildCategoryScreenWorkFlow screenEventID(%1) is in range of PoiParentChildCategoryScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiParentChildResultScreenListElementSelectedWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, null, new SpellerContext(5), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new ModelOnElementSelectedCommand(this.poiManager.getPoiParentChildCategoryScreenHmiListener().getPoiParentChildCategoryScreenInputSequence().getPoiParentChildCategoryScreenModelAccess(), lIValueListElement));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiParentChildCategoryScreenParentElementSelectedWorkFlow startGuidance").toString()){

            public void execute() {
                if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 2) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    PoiWorkFlowManager.this.storeHomeAddress(navLocation);
                    this.getCommandList().commandFinished();
                } else if (PoiWorkFlowManager.this.inputModeManager.getInputMode() == 1) {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.createUpdateAdbNavLocationCommandList(navLocation));
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
                }
            }
        });
    }

    private CommandList handlePoiParkingNearDestinationScreenWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 1205: {
                this.createPoiParkingAlongRouteScreenStartFromRightDrawerWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 1204: {
                this.createPoiParkingNearDestinationScreenStartFromRightDrawerWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 1202: {
                this.createPoiParkingNearDestinationScreenListSelectedWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiParentChildCategoryScreenWorkFlow screenEventID(%2) is in range of PoiParentChildCategoryScreen but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiParkingNearDestinationScreenListSelectedWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        if (navigationEnv.getPOILogChannel().isDebug2()) {
            navigationEnv.getPOILogChannel().log(100000000, "%1#createPoiParkingNearDestinationScreenListSelectedWorkFlow", (Object)this.CLASS_NAME);
        }
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, -1, null, new SpellerContext(16), null));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiPrepareParentChildCommand(this.poiManager.getPoiResultScreenWithSpellerHmiListener().getPoiResultScreenWithSpellerInputSequence().getModelAccess()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiParkingNearDestinationScreenListSelectedWorkFlow decide the followup action").toString()){

            public void execute() {
                this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.this.poiManager.getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
            }
        });
    }

    private void createPoiParkingNearDestinationScreenStartFromRightDrawerWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        SearchAreaRestoreState searchAreaRestoreState = new SearchAreaRestoreState(poiSearchArea, this.searchAreaSequence, navigationEnv.getPOILogChannel(), this.poiManager);
        searchAreaRestoreState.gatherInfo();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createPoiParkingNearDestinationScreenStartFromRightDrawerWorkFlow: get search context from DSI response container").toString()){

            public void execute() {
                PoiWorkFlowManager.this.searchAreaSequence.updateSearchArea(0, this.dsiResponseContainer.getSelectedLocation());
                this.getCommandList().commandFinished();
            }
        });
        if (lIValueListElement == null) {
            commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, new IAdditionalStateInfo[]{searchAreaRestoreState}, new SpellerContext(16), null));
        } else {
            commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, new IAdditionalStateInfo[]{searchAreaRestoreState}, new SpellerContext(16), null));
        }
        commandList.add(this.poiManager.getPoiParkingNearDestinationScreenHmiListener().getStartCommandList());
    }

    private void createPoiParkingAlongRouteScreenStartFromRightDrawerWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        LIValueListElement lIValueListElement = (LIValueListElement)commandList.get("CurrentSelection");
        SearchAreaRestoreState searchAreaRestoreState = new SearchAreaRestoreState(poiSearchArea, this.searchAreaSequence, navigationEnv.getPOILogChannel(), this.poiManager);
        searchAreaRestoreState.gatherInfo();
        if (lIValueListElement == null) {
            commandList.add(new LIGetStateCommand(this.spellerStack, null, -1, new IAdditionalStateInfo[]{searchAreaRestoreState}, new SpellerContext(55), null));
        } else {
            commandList.add(new LIGetStateCommand(this.spellerStack, lIValueListElement, lIValueListElement.poiUniqueId, new IAdditionalStateInfo[]{searchAreaRestoreState}, new SpellerContext(55), null));
        }
        poiSearchArea.setSearchContext(1);
        commandList.add(this.poiManager.getPoiParkingNearDestinationScreenHmiListener().getStartCommandList());
    }

    private CommandList handlePoiSDSWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        switch (n) {
            case 1502: {
                this.createPoiSDSSelectTopPoiWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            case 1503: {
                this.createPoiSDSSelectPoiWorkFlow(commandList, poiSearchArea, navigationEnv);
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(1000000, "%1#handlePoiSDSWorkFlow screenEventID(%2) is in range of PoiSDS but not known as a valid eventID", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return commandList;
    }

    private void createPoiSDSSelectTopPoiWorkFlow(CommandList commandList, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(4)));
        PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence = new PoiResultScreenNoSpellerInputSequence(SDSPoiScreensEvo.getResultsScreenModelAccess(navigationEnv, this.iconHandler, this.routeManager, this.vehicle), this.commandListFactory, poiSearchArea, navigationEnv, this.spellerStack, 50, this.poiManager);
        commandList.add(poiResultScreenNoSpellerInputSequence.getStartCommandList((Integer)commandList.get("selected poi UID")));
    }

    private void createPoiSDSSelectPoiWorkFlow(CommandList commandList, final PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(111)));
        commandList.add(new PoiGetCategoryTypesFromUIdCommand((Integer)commandList.get("selected poi UID")));
        commandList.add(new NavCommand("Decide if TopPoi, GenericPoi or UndefinedPoi"){

            public void execute() {
                if (this.isGenericPoi()) {
                    this.logger.log(10000000, "%1#startSpellerCommand#execute poiID is POICATEGORYTYPE_GENERIC", (Object)this.CLASS_NAME);
                    CommandList commandList = PoiWorkFlowManager.this.commandListFactory.createCommandList();
                    commandList.add(new LISPCancelSpellerCommand());
                    commandList.add(new PoiSetSortOrderCommand(0));
                    commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#startSpeller").toString()){

                        public void execute() {
                            if (poiSearchArea.getSearchContext() == 1) {
                                this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(32783, Util.isHURegionNAR()));
                            } else {
                                NavLocation navLocation = PoiUtil.getLocation(poiSearchArea, this.env);
                                CommandList commandList = PoiWorkFlowManager.this.commandListFactory.createCommandList();
                                commandList.add(new PoiSetContextCommand(navLocation));
                                commandList.add(new LIStartSpellerCommand(32783, false, false, false));
                                this.getCommandList().commandFinishedWithPostSequence(commandList);
                            }
                        }
                    });
                    commandList.add(this.getSelectPoiByUidCommandList());
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else if (this.isTopPoi()) {
                    this.logger.log(10000000, "%1#startSpellerCommand#execute poiID is POICATEGORYTYPE_TOPPOI", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinishedWithPostSequence(this.getSelectPoiByUidCommandList());
                } else if (this.isUndefinedPoi()) {
                    this.logger.log(10000000, "%1#startSpellerCommand#execute poiID is POICATEGORYTYPE_UNDEFINED", (Object)this.CLASS_NAME);
                    this.env.getBaseListModel(3901).removeAll();
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted(2L);
                }
            }

            private CommandList getSelectPoiByUidCommandList() {
                PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence = new PoiResultScreenNoSpellerInputSequence(SDSPoiScreensEvo.getResultsScreenModelAccess(this.env, PoiWorkFlowManager.this.iconHandler, PoiWorkFlowManager.this.routeManager, PoiWorkFlowManager.this.vehicle), PoiWorkFlowManager.this.commandListFactory, poiSearchArea, this.env, PoiWorkFlowManager.this.spellerStack, 50, PoiWorkFlowManager.this.poiManager);
                return poiResultScreenNoSpellerInputSequence.getStartCommandList((Integer)this.commandList.get("selected poi UID"));
            }

            private boolean isTopPoi() {
                return this.checkForCategoryType(1);
            }

            private boolean isGenericPoi() {
                return this.checkForCategoryType(2);
            }

            private boolean isUndefinedPoi() {
                return this.checkForCategoryType(0);
            }

            private boolean checkForCategoryType(int n) {
                int[] nArray = this.dsiResponseContainer.getPoiGetCategoryTypesFromUId();
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (nArray[i2] != n) continue;
                    return true;
                }
                return false;
            }
        });
    }

    private void storeHomeAddress(NavLocation navLocation) {
        this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
    }

    private CommandList createUpdateAdbNavLocationCommandList(NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new NavCommand("Update ADB NavLocation"){

            public void execute() {
                byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
                PoiWorkFlowManager.this.updateAdbNavLocation(byArray, this.env);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private void updateAdbNavLocation(byte[] byArray, NavigationEnv navigationEnv) {
        navigationEnv.getPOILogChannel().log(10000000, "%1#updateAdbNavLocation", (Object)this.CLASS_NAME);
        NaviADBService.LocationInputHandler locationInputHandler = this.adbInterAppService.getCurrentLocationInputHandler();
        if (locationInputHandler != null) {
            locationInputHandler.updateLocation(byArray);
        } else {
            navigationEnv.getPOILogChannel().log(1000000, "%1#updateAdbNavLocation LocationInputHandler is null, unable to save contact.", (Object)this.CLASS_NAME);
        }
    }

    public void setSpellerScreenBreadcrumb(NavigationEnv navigationEnv, int n) {
        ChoiceModelApp choiceModelApp = navigationEnv.getChoiceModel(400961);
        ChoiceModelApp choiceModelApp2 = navigationEnv.getChoiceModel(400291);
        if (n == 6) {
            this.oldBreadcrumbChoice = choiceModelApp.getValue();
            this.oldBrandsAvailableChoice = choiceModelApp2.getValue();
        }
        if (n == -1) {
            choiceModelApp.setValue(this.oldBreadcrumbChoice);
            choiceModelApp2.setValue(this.oldBrandsAvailableChoice);
        } else {
            choiceModelApp.setValue(n);
        }
    }

    public int getSpellerScreenBreadcrumb(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(400961).getValue();
    }
}

