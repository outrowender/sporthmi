/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;

public class DSIMHIConstantsMapper {
    private static final String LOGCLASS = "DSIMHIConstantsMapper";
    private final LogChannel logger;

    public DSIMHIConstantsMapper(LogChannel logChannel) {
        this.logger = logChannel;
    }

    Application mapApplication(int n) {
        switch (n) {
            case 1: {
                return Application.NAVI;
            }
            case 2: {
                return Application.SPEECH;
            }
        }
        this.logger.log(100000, "[%1.mapApplication] Unknown application id %2", (Object)LOGCLASS, (long)n);
        return Application.PHONE;
    }

    ResourceOwner mapResourceOwner(int n) {
        switch (n) {
            case 2: {
                return ResourceOwner.DEVICE;
            }
            case 1: {
                return ResourceOwner.MAINUNIT;
            }
        }
        this.logger.log(100000, "[%1.mapResourceOwner] Unknown resource owner %1", (Object)LOGCLASS, (long)n);
        return ResourceOwner.MAINUNIT;
    }

    de.audi.app.terminalmode.statemachine.Resource mapResource(int n) {
        switch (n) {
            case 3: {
                return de.audi.app.terminalmode.statemachine.Resource.AUDIO_MEDIA;
            }
            case 2: {
                return de.audi.app.terminalmode.statemachine.Resource.AUDIO_SPEECH;
            }
            case 4: {
                return de.audi.app.terminalmode.statemachine.Resource.AUDIO_GUIDANCE;
            }
            case 1: {
                return de.audi.app.terminalmode.statemachine.Resource.SCREEN;
            }
            case 0: {
                return de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION;
            }
        }
        this.logger.log(100000, "[%1.mapResourceOwner] Unknown resource %1", (Object)LOGCLASS, (long)n);
        return de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION;
    }

    ApplicationOwner mapAppOwner(int n) {
        switch (n) {
            case 2: {
                return ApplicationOwner.DEVICE;
            }
            case 1: {
                return ApplicationOwner.MAINUNIT;
            }
        }
        return ApplicationOwner.NOBODY;
    }

    Resource[] createResources(TMState tMState) {
        Resource[] resourceArray = new Resource[]{new Resource(1, this.mapResourceOwner(tMState.getOwnerForResource(de.audi.app.terminalmode.statemachine.Resource.SCREEN))), new Resource(2, this.mapResourceOwner(tMState.getOwnerForResource(de.audi.app.terminalmode.statemachine.Resource.AUDIO_SPEECH))), new Resource(3, this.mapResourceOwner(tMState.getOwnerForResource(de.audi.app.terminalmode.statemachine.Resource.AUDIO_MEDIA))), new Resource(4, this.mapResourceOwner(tMState.getOwnerForResource(de.audi.app.terminalmode.statemachine.Resource.AUDIO_GUIDANCE)))};
        return resourceArray;
    }

    int mapResourceOwner(ResourceOwner resourceOwner) {
        if (ResourceOwner.DEVICE.is(resourceOwner)) {
            return 2;
        }
        return 1;
    }

    AppState[] createAppStates(TMState tMState) {
        AppState[] appStateArray = new AppState[]{new AppState(1, this.mapAppStateOwner(tMState.getOwnerForApplication(Application.NAVI))), new AppState(2, this.mapAppStateOwner(tMState.getOwnerForApplication(Application.SPEECH)))};
        return appStateArray;
    }

    int mapAppStateOwner(ApplicationOwner applicationOwner) {
        if (ApplicationOwner.DEVICE.is(applicationOwner)) {
            return 2;
        }
        if (ApplicationOwner.MAINUNIT.is(applicationOwner)) {
            return 1;
        }
        return 0;
    }
}

