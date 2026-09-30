/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.context;

import de.audi.app.navi.evo.map.context.CtxCrosshairEnterInMapEvo;
import de.audi.app.navi.evo.map.context.CtxDestinationMapEvo;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.context.CtxAltRoutesSelection;
import de.audi.tghu.navi.app.map.context.CtxAutozoomPositionMap;
import de.audi.tghu.navi.app.map.context.CtxCrosshairMap;
import de.audi.tghu.navi.app.map.context.CtxHidden;
import de.audi.tghu.navi.app.map.context.CtxInit;
import de.audi.tghu.navi.app.map.context.CtxKombiInit;
import de.audi.tghu.navi.app.map.context.CtxLoadState;
import de.audi.tghu.navi.app.map.context.CtxManoeuvrezoomPositionMap;
import de.audi.tghu.navi.app.map.context.CtxMapInMapShown;
import de.audi.tghu.navi.app.map.context.CtxMinorMapHidden;
import de.audi.tghu.navi.app.map.context.CtxMinorMapInit;
import de.audi.tghu.navi.app.map.context.CtxNull;
import de.audi.tghu.navi.app.map.context.CtxOnlineResults;
import de.audi.tghu.navi.app.map.context.CtxOperatorCallResults;
import de.audi.tghu.navi.app.map.context.CtxOverviewMap;
import de.audi.tghu.navi.app.map.context.CtxPicNavCarouselMap;
import de.audi.tghu.navi.app.map.context.CtxPicNavMap;
import de.audi.tghu.navi.app.map.context.CtxPositionMap;
import de.audi.tghu.navi.app.map.context.CtxPreviewMapShown;
import de.audi.tghu.navi.app.map.context.CtxRCCIMap;
import de.audi.tghu.navi.app.map.context.CtxRemoteHMIResults;
import de.audi.tghu.navi.app.map.context.CtxRouteBriefing;
import de.audi.tghu.navi.app.map.context.CtxRseRoute;
import de.audi.tghu.navi.app.map.context.CtxRubberBand;
import de.audi.tghu.navi.app.map.context.CtxScrollOnRoute;
import de.audi.tghu.navi.app.map.context.CtxSelenaOverview;
import de.audi.tghu.navi.app.map.context.CtxTMCMap;
import de.audi.tghu.navi.app.map.context.CtxTrafficNoticeMap;
import de.audi.tghu.navi.app.map.context.IContextFactory;
import de.audi.tghu.navi.app.map.utils.NullFactory;

public class ContextFactoryEvo
implements MapConsts,
IContextFactory {
    static /* synthetic */ Class class$de$audi$tghu$navi$app$map$IContext;

    public IContext createContext(int n, AbstractMap abstractMap, IconHandler iconHandler) {
        Context context = null;
        NavigationEnv navigationEnv = abstractMap.getNavigationEnv();
        switch (n) {
            case 0: {
                context = new CtxNull(navigationEnv, abstractMap);
                break;
            }
            case 1: {
                context = new CtxInit(navigationEnv, abstractMap);
                break;
            }
            case 2: {
                context = new CtxLoadState(navigationEnv, abstractMap);
                break;
            }
            case 3: {
                context = new CtxHidden(navigationEnv, iconHandler, abstractMap);
                break;
            }
            case 33: {
                context = new CtxRouteBriefing(navigationEnv, abstractMap);
                break;
            }
            case 5: {
                context = new CtxAltRoutesSelection(navigationEnv, abstractMap);
                break;
            }
            case 6: {
                context = new CtxPositionMap(navigationEnv, abstractMap);
                break;
            }
            case 7: {
                context = new CtxAutozoomPositionMap(navigationEnv, abstractMap);
                break;
            }
            case 8: {
                context = new CtxManoeuvrezoomPositionMap(navigationEnv, abstractMap);
                break;
            }
            case 10: {
                context = new CtxOverviewMap(navigationEnv, abstractMap);
                break;
            }
            case 11: {
                context = new CtxDestinationMapEvo(navigationEnv, abstractMap);
                break;
            }
            case 12: {
                context = new CtxCrosshairMap(navigationEnv, abstractMap);
                break;
            }
            case 13: {
                context = new CtxCrosshairEnterInMapEvo(navigationEnv, abstractMap);
                break;
            }
            case 15: {
                context = new CtxOnlineResults(navigationEnv, abstractMap);
                break;
            }
            case 17: {
                context = new CtxScrollOnRoute(navigationEnv, abstractMap);
                break;
            }
            case 18: {
                context = new CtxTMCMap(navigationEnv, abstractMap);
                break;
            }
            case 20: {
                context = new CtxRCCIMap(navigationEnv, abstractMap);
                break;
            }
            case 22: {
                context = new CtxRseRoute(navigationEnv, abstractMap);
                break;
            }
            case 24: {
                context = new CtxMinorMapInit(navigationEnv, abstractMap);
                break;
            }
            case 26: {
                context = new CtxPicNavMap(navigationEnv, abstractMap);
                break;
            }
            case 27: {
                context = new CtxPicNavCarouselMap(navigationEnv, abstractMap);
                break;
            }
            case 28: {
                context = new CtxRemoteHMIResults(navigationEnv, abstractMap);
                break;
            }
            case 37: {
                context = new CtxOperatorCallResults(navigationEnv, abstractMap);
                break;
            }
            case 29: {
                context = new CtxMapInMapShown(navigationEnv, abstractMap);
                break;
            }
            case 36: {
                context = new CtxTrafficNoticeMap(navigationEnv, abstractMap);
                break;
            }
            case 30: {
                context = new CtxPreviewMapShown(navigationEnv, abstractMap);
                break;
            }
            case 31: {
                context = new CtxMinorMapHidden(navigationEnv, iconHandler, abstractMap);
                break;
            }
            case 32: {
                context = new CtxKombiInit(navigationEnv, abstractMap);
                break;
            }
            case 34: {
                context = new CtxRubberBand(navigationEnv, abstractMap);
                break;
            }
            case 38: {
                context = new CtxSelenaOverview(navigationEnv, abstractMap);
                break;
            }
            default: {
                abstractMap.getMapLogChannel().log(100000, "ContextFactoryEvo#createContext() - unknown context id %1", (long)n);
            }
        }
        return context;
    }

    public IContext createNullContext(LogChannel logChannel) {
        IContext iContext = (IContext)NullFactory.create(class$de$audi$tghu$navi$app$map$IContext == null ? (class$de$audi$tghu$navi$app$map$IContext = ContextFactoryEvo.class$("de.audi.tghu.navi.app.map.IContext")) : class$de$audi$tghu$navi$app$map$IContext, logChannel, null);
        return iContext;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

