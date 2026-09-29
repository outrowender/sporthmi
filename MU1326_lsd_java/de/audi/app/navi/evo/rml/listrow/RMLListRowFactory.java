/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml.listrow;

import de.audi.app.navi.evo.rml.listrow.RMLEvoDestinationListRow;
import de.audi.app.navi.evo.rml.listrow.RMLEvoPOIListRow;
import de.audi.app.navi.evo.rml.listrow.RMLEvoRoadSegmentListRow;
import de.audi.app.navi.evo.rml.listrow.RMLEvoSapaListRow;
import de.audi.app.navi.evo.rml.listrow.RMLEvoTmcListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.hierarchiclist.rml.RMLUtil;
import de.audi.tghu.navi.app.rml.AbstractRMLListRow;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.Route;

public class RMLListRowFactory {
    private LogChannel logChannel;
    private static final String LOGCLASS;

    public RMLListRowFactory(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public AbstractRMLListRow createRMLListRow(CombinedRouteListElement combinedRouteListElement, IconHandler iconHandler, long l, NavigationEnv navigationEnv, Route route, IRouteManager iRouteManager) {
        if (RMLUtil.isDestination(combinedRouteListElement)) {
            return this.createDestinationListRow(combinedRouteListElement, iconHandler, l, navigationEnv, route);
        }
        if (RMLUtil.isTMC(combinedRouteListElement)) {
            return this.createTMCListRow(combinedRouteListElement, iconHandler, l, navigationEnv, route);
        }
        if (RMLUtil.isPOI(combinedRouteListElement) || RMLUtil.isCountryChange(combinedRouteListElement)) {
            return this.createRMLPOIListRow(combinedRouteListElement, iconHandler, l, navigationEnv, iRouteManager);
        }
        if (RMLUtil.isRoadSegment(combinedRouteListElement)) {
            return this.createRMLRoadSegmentListRow(combinedRouteListElement, iconHandler, l, navigationEnv);
        }
        if (RMLUtil.isOffroad(combinedRouteListElement)) {
            return this.createRMLRoadSegmentListRow(combinedRouteListElement, iconHandler, l, navigationEnv);
        }
        this.logChannel.log(-2137614336, "%1#createRMLListRow no Row created", (Object)"RMLListRowFactory");
        return null;
    }

    private AbstractRMLListRow createTMCListRow(CombinedRouteListElement combinedRouteListElement, IconHandler iconHandler, long l, NavigationEnv navigationEnv, Route route) {
        return new RMLEvoTmcListRow(this.logChannel, combinedRouteListElement, this.figureOutChildState(combinedRouteListElement, l), iconHandler, navigationEnv);
    }

    private AbstractRMLListRow createDestinationListRow(CombinedRouteListElement combinedRouteListElement, IconHandler iconHandler, long l, NavigationEnv navigationEnv, Route route) {
        return new RMLEvoDestinationListRow(this.logChannel, combinedRouteListElement, this.figureOutChildState(combinedRouteListElement, l), iconHandler, navigationEnv, route);
    }

    private AbstractRMLListRow createRMLPOIListRow(CombinedRouteListElement combinedRouteListElement, IconHandler iconHandler, long l, NavigationEnv navigationEnv, IRouteManager iRouteManager) {
        if (combinedRouteListElement.getIcons().length > 1) {
            this.logChannel.log(-2137614336, "%1#RMLEvoSapaListRow() with %2 icons", (Object)"RMLListRowFactory", (Object)new Integer(combinedRouteListElement.getIcons().length));
            return new RMLEvoSapaListRow(this.logChannel, combinedRouteListElement, this.figureOutChildState(combinedRouteListElement, l), iconHandler, navigationEnv, iRouteManager);
        }
        return new RMLEvoPOIListRow(this.logChannel, combinedRouteListElement, this.figureOutChildState(combinedRouteListElement, l), iconHandler, navigationEnv, iRouteManager);
    }

    private RMLEvoRoadSegmentListRow createRMLRoadSegmentListRow(CombinedRouteListElement combinedRouteListElement, IconHandler iconHandler, long l, NavigationEnv navigationEnv) {
        return new RMLEvoRoadSegmentListRow(this.logChannel, combinedRouteListElement, this.figureOutChildState(combinedRouteListElement, l), iconHandler, navigationEnv);
    }

    private int figureOutChildState(CombinedRouteListElement combinedRouteListElement, long l) {
        if (combinedRouteListElement.getUid() == l) {
            return 2;
        }
        if (combinedRouteListElement.isHasChildren()) {
            return 1;
        }
        return 0;
    }
}

