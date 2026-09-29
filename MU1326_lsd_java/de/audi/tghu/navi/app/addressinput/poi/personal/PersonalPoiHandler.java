/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.personal;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.PersonalPoiDatabaseUpdateEvent;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.commands.DeletePersonalPOICommand;
import de.audi.tghu.navi.app.addressinput.poi.personal.IPersonalPoiHandler;
import de.audi.tghu.navi.app.addressinput.poi.personal.IPersonalPoiModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.personal.PersonalPoiHandler$1;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import org.dsi.ifc.navigation.NavDataBase;

public class PersonalPoiHandler
implements IPersonalPoiHandler {
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final IconHandler iconHandler;
    private final POICategoryManager poiCatManager;
    private final NavigationEnv env;
    private final IPersonalPoiModelAccess modelAccess;

    public PersonalPoiHandler(LogChannel logChannel, POICategoryManager pOICategoryManager, ICommandListFactory iCommandListFactory, IPersonalPoiModelAccess iPersonalPoiModelAccess, IconHandler iconHandler, NavigationEnv navigationEnv) {
        this.logChannel = logChannel;
        this.poiCatManager = pOICategoryManager;
        this.commandListFactory = iCommandListFactory;
        this.modelAccess = iPersonalPoiModelAccess;
        this.iconHandler = iconHandler;
        this.env = navigationEnv;
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray) {
        this.logChannel.log(-2137614336, "PersonalPOIHandler#updateEtcAvailablePersonalPOIDataBases( %1 )", (Object)navDataBaseArray);
        boolean bl = navDataBaseArray.length > 0;
        this.clearWidgetPPoiCache(this.env);
        this.modelAccess.onUpdateDataBaseAvailable(bl);
        if (!this.env.getFramework().isAsia()) {
            try {
                this.logChannel.log(-2137614336, "PersonalPOIHandler#enter() - fetchPOICategories");
                this.poiCatManager.fetchPOICategories(0).execute("PersonalPOIHandler#fetchPOICategories(Standard/Traffic)");
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void clearWidgetPPoiCache(NavigationEnv navigationEnv) {
        this.logChannel.log(1078071040, "PersonalPoiHandler#clearWidgetPPoiCache() - Clearing PPOI Cache");
        HMIService hMIService = navigationEnv.getFramework().getHMIService();
        PersonalPoiDatabaseUpdateEvent personalPoiDatabaseUpdateEvent = new PersonalPoiDatabaseUpdateEvent(hMIService.getRootWindow(0), 255);
        hMIService.getEventDispatcher().postEvent(personalPoiDatabaseUpdateEvent);
    }

    public void updatePersonalPOISearchStatus(int n) {
        this.logChannel.log(-2137614336, "PersonalPOIHandler#updatePersonalPOISearchStatus( %1 )", (long)n);
    }

    @Override
    public void deletePersonalPOIDataBases() {
        this.logChannel.log(-2137614336, "PersonalPOIHandler#detelePersonalPOIDataBases()");
        this.deletePersonalPOIDataBases(null);
    }

    @Override
    public void deletePersonalPOIDataBases(String[] stringArray) {
        this.logChannel.log(1078071040, "PersonalPOIHandler#detelePersonalPOIDataBases( %1 )", (Object)stringArray);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess.isPpoiavailable()) {
            commandList.add(new DeletePersonalPOICommand(stringArray));
            commandList.add(new PersonalPoiHandler$1(this, "FlushIconCacheAndModelAccess", stringArray));
            commandList.add(this.poiCatManager.fetchPOICategories(0));
            commandList.execute("PersonalPOIHandler#detelePersonalPOIDataBases");
        }
    }

    static /* synthetic */ IconHandler access$000(PersonalPoiHandler personalPoiHandler) {
        return personalPoiHandler.iconHandler;
    }

    static /* synthetic */ IPersonalPoiModelAccess access$100(PersonalPoiHandler personalPoiHandler) {
        return personalPoiHandler.modelAccess;
    }
}

