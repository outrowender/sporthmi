/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.setup.RouteCriteria;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class RouteCriteriaManager$RouteCriteriaState
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private IRouteCriteria routeCriteria;
    private final /* synthetic */ RouteCriteriaManager this$0;

    public RouteCriteriaManager$RouteCriteriaState(RouteCriteriaManager routeCriteriaManager, IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.this$0 = routeCriteriaManager;
        super(iStorageAccess, 3, 1004, 850, logChannel);
        this.routeCriteria = new RouteCriteria(RouteCriteriaManager.access$000(routeCriteriaManager));
    }

    @Override
    protected void initWithDefaultValues() {
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaState#initWithDefaultValues()");
        RouteCriteriaManager.access$100(this.this$0).initRouteCriteria(this.routeCriteria);
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaState#initFromOldKeys()");
        RouteCriteriaManager.access$100(this.this$0).initRouteCriteria(this.routeCriteria);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaState#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaState#serialize - routeCriteria: %1", (Object)this.routeCriteria);
        dataOutputStream.writeInt(this.routeCriteria.getTrafficRerouting());
        dataOutputStream.writeInt(this.routeCriteria.getFreeways());
        dataOutputStream.writeInt(this.routeCriteria.getTollRoads());
        dataOutputStream.writeInt(this.routeCriteria.getFerries());
        dataOutputStream.writeInt(this.routeCriteria.getMotorrail());
        dataOutputStream.writeInt(this.routeCriteria.getTimeRestrictedRoads());
        dataOutputStream.writeInt(this.routeCriteria.getSeasonRestricted());
        dataOutputStream.writeInt(this.routeCriteria.getTrailer());
        dataOutputStream.writeInt(this.routeCriteria.getVignettes());
        dataOutputStream.writeInt(this.routeCriteria.getRouteOptions(true)[0].getRouteType());
        this.serializeIntArray(this.routeCriteria.getVignetteCountries(), dataOutputStream);
        dataOutputStream.writeInt(this.routeCriteria.getTunnels());
        dataOutputStream.writeInt(this.routeCriteria.getHovLanes());
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaState#deserialize");
        this.routeCriteria.setTrafficRerouting(dataInputStream.readInt());
        this.routeCriteria.setFreeways(dataInputStream.readInt());
        this.routeCriteria.setTollRoads(dataInputStream.readInt());
        this.routeCriteria.setFerries(dataInputStream.readInt());
        this.routeCriteria.setMotorrail(dataInputStream.readInt());
        this.routeCriteria.setTimeRestrictedRoads(dataInputStream.readInt());
        this.routeCriteria.setSeasonRestricted(dataInputStream.readInt());
        this.routeCriteria.setTrailer(dataInputStream.readInt());
        this.routeCriteria.setVignettes(dataInputStream.readInt());
        this.routeCriteria.setRouteOption(dataInputStream.readInt());
        this.routeCriteria.setVignetteCountries(this.deserializeIntArray(dataInputStream));
        this.routeCriteria.setTunnels(dataInputStream.readInt());
        this.routeCriteria.setHovLanes(dataInputStream.readInt());
        this.getLogChannel().log(-2137614336, "[RouteGuidance] RouteCriteriaState#deserialize - resulting routeCriteria: %1", (Object)this.routeCriteria);
        RouteCriteriaManager.access$100(this.this$0).checkForRegionConsistency(this.routeCriteria);
        RouteCriteriaManager.access$100(this.this$0).checkForEncodedTrailer(this.routeCriteria, RouteCriteriaManager.access$000(this.this$0));
    }

    public IRouteCriteria getRouteCriteria() {
        return this.routeCriteria;
    }

    public void setRouteCriteria(IRouteCriteria iRouteCriteria) {
        if (iRouteCriteria == null) {
            return;
        }
        this.routeCriteria = new RouteCriteria(iRouteCriteria, RouteCriteriaManager.access$000(this.this$0));
    }
}

