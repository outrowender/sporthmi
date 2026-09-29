/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.atip.interapp.online.IOperatorCallNaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.operatorcall.INaviOperatorCallService;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService$1;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService$2;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService$3;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService$4;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.online.OperatorCallResult;

public class NaviOperatorCallService
implements INaviOperatorCallService {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final LogChannel logChannel;
    private final HomeAddressHandler homeAddressHandler;
    private final INaviFavoriteHandler favoriteHandler;
    private final NaviADBHandler adbHandler;
    private final IDetailsScreen detailsScreen;
    private final ICommandListFactory commandListFactory;
    private IOperatorCallNaviService onlineOperatorCallService = null;
    private final int serviceType;

    public NaviOperatorCallService(NavigationEnv navigationEnv, HomeAddressHandler homeAddressHandler, INaviFavoriteHandler iNaviFavoriteHandler, NaviADBHandler naviADBHandler, IDetailsScreen iDetailsScreen, ICommandListFactory iCommandListFactory) {
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.homeAddressHandler = homeAddressHandler;
        this.favoriteHandler = iNaviFavoriteHandler;
        this.adbHandler = naviADBHandler;
        this.detailsScreen = iDetailsScreen;
        this.commandListFactory = iCommandListFactory;
        this.serviceType = this.getServiceType();
    }

    private int getServiceType() {
        if (Util.isHURegionCN()) {
            return 2;
        }
        if (Util.isHURegionJP()) {
            return 1;
        }
        this.logChannel.log(-1601830656, "%1#getServiceType - no match found for the service type for operator call! This should NOT happen!", (Object)this.CLASS_NAME);
        return -1;
    }

    @Override
    public void setContext(int n) {
        this.logChannel.log(-2137614336, "%1#setContext - context=%2", (Object)this.CLASS_NAME, (long)n);
        if (this.onlineOperatorCallService != null && this.serviceType > -1) {
            this.onlineOperatorCallService.enterOperatorCall(this.serviceType, n);
        } else {
            this.logChannel.log(10000, "%1#setContext - failed to set context. serviceType=%3; onlineOperatorCallService=%2 !", (Object)this.CLASS_NAME, (Object)this.onlineOperatorCallService, (long)this.serviceType);
        }
    }

    @Override
    public void receiveEvent(OperatorCallResult operatorCallResult, int n) {
        this.logChannel.log(-2137614336, "%1#receiveEvent - eventId=%3, operatorCallResult=%2", (Object)this.CLASS_NAME, (Object)operatorCallResult, (long)n);
        switch (n) {
            case 2: {
                this.addToContact(operatorCallResult);
                break;
            }
            case 1: {
                this.addToFavorites(operatorCallResult);
                break;
            }
            case 3: {
                this.addAsHomeAddress(operatorCallResult);
                break;
            }
            case 4: {
                this.saveToContact(operatorCallResult);
                break;
            }
            case 0: {
                this.showDetailScreen(operatorCallResult);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "%1#receiveEvent - received unkown eventId=%2", (Object)this.CLASS_NAME, (long)n);
            }
        }
    }

    @Override
    public void setOnlineOperatorCallService(IOperatorCallNaviService iOperatorCallNaviService) {
        this.onlineOperatorCallService = iOperatorCallNaviService;
    }

    private void showDetailScreen(OperatorCallResult operatorCallResult) {
        this.detailsScreen.enterDetailsScreenOperatorCall(operatorCallResult);
    }

    private void saveToContact(OperatorCallResult operatorCallResult) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(operatorCallResult.getLocation()));
        commandList.add(new NaviOperatorCallService$1(this, "Start ReturnNavLocationToAddressbookSequence with transformed location"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#saveToContact").toString());
    }

    private void addToFavorites(OperatorCallResult operatorCallResult) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(operatorCallResult.getLocation()));
        commandList.add(new NaviOperatorCallService$2(this, "Start add to favorites with transformed location", operatorCallResult));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addToFavorites").toString());
    }

    private void addAsHomeAddress(OperatorCallResult operatorCallResult) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(operatorCallResult.getLocation()));
        commandList.add(new NaviOperatorCallService$3(this, "Get transformed location and send to home address handler"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addAsHomeAddress").toString());
    }

    private void addToContact(OperatorCallResult operatorCallResult) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(operatorCallResult.getLocation()));
        commandList.add(new NaviOperatorCallService$4(this, "Get transformed location and send to adb"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addToContact").toString());
    }

    static /* synthetic */ ICommandListFactory access$000(NaviOperatorCallService naviOperatorCallService) {
        return naviOperatorCallService.commandListFactory;
    }

    static /* synthetic */ INaviFavoriteHandler access$100(NaviOperatorCallService naviOperatorCallService) {
        return naviOperatorCallService.favoriteHandler;
    }

    static /* synthetic */ HomeAddressHandler access$200(NaviOperatorCallService naviOperatorCallService) {
        return naviOperatorCallService.homeAddressHandler;
    }

    static /* synthetic */ NaviADBHandler access$300(NaviOperatorCallService naviOperatorCallService) {
        return naviOperatorCallService.adbHandler;
    }
}

