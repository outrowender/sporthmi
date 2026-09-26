/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;

public class ListController$ListModelRowMapper {
    private ModelUpdateEvent[] nestedEvents;
    int currentHandledEvent = 0;
    private final /* synthetic */ ListController this$0;

    public ListController$ListModelRowMapper(ListController listController, ModelUpdateEvent[] modelUpdateEventArray) {
        this.this$0 = listController;
        this.nestedEvents = modelUpdateEventArray;
    }

    public int map(int n) {
        for (int i2 = this.currentHandledEvent + 1; i2 < this.nestedEvents.length; ++i2) {
            ModelUpdateEvent modelUpdateEvent = this.nestedEvents[i2];
            if (modelUpdateEvent.getModelId() != this.this$0.getModelID()) continue;
            n = this.map(n, modelUpdateEvent);
        }
        return n;
    }

    private int map(int n, ModelUpdateEvent modelUpdateEvent) {
        int n2 = modelUpdateEvent.getUpdateType();
        if (n2 == 9) {
            int n3;
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            int n4 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData$Key.INDEX) : modelUpdateEvent.getClientData1();
            int n5 = n3 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData$Key.COUNT) : 1;
            if (n4 <= n) {
                n -= n3;
                n = Math.max(n4, n);
            }
        } else if (n2 == 7) {
            int n6;
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            int n7 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData$Key.INDEX) : modelUpdateEvent.getClientData1();
            int n8 = n6 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData$Key.COUNT) : 1;
            if (n7 <= n) {
                n += n6;
            }
        }
        return n;
    }

    public String toString() {
        return new Buffer().append("ListRowMapper[current event: ").append(this.currentHandledEvent).append(", max: ").append(this.nestedEvents.length - 1).append("]").toString();
    }
}

