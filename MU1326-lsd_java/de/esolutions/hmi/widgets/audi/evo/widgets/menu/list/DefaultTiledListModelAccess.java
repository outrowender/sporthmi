/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.AbstractTiledListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.DefaultTiledListModelAccess$ListRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DefaultTiledListModelAccess
extends AbstractTiledListModelAccess {
    private static final LogChannel lc = listLogCh;
    private static int nextRequestID = 0;
    private int runningRequestID;
    private DefaultTiledListModelAccess$ListRange runningRequest = new DefaultTiledListModelAccess$ListRange();
    private List fulfilledRequests = new ArrayList(10);
    private MenuViewport visibleItems = new MenuViewport(null, null);
    private MenuViewport destination = new MenuViewport(null, null);
    private int defaultRequestLength = 20;
    private int bufferAroundViewport = 20;
    private int bufferAtListStart = 7;
    private int unrequestMinLength = 50;
    private int listLength;
    private boolean isAsia = false;

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.runningRequest.clear();
        this.fulfilledRequests.clear();
        this.visibleItems = new MenuViewport(null, null);
        this.destination = new MenuViewport(null, null);
        this.updateLength();
        this.isAsia = AbstractWidget.isAsia();
    }

    public boolean isRequestRunning() {
        return !this.runningRequest.isEmpty();
    }

    private void sendRequest(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange) {
        int n;
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            return;
        }
        this.adjustRequestForAlreadyExistingRows(defaultTiledListModelAccess$ListRange);
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            return;
        }
        this.runningRequestID = n = DefaultTiledListModelAccess.generateRequestID();
        this.runningRequest.start = defaultTiledListModelAccess$ListRange.start;
        this.runningRequest.end = defaultTiledListModelAccess$ListRange.end;
        lc.log(-2137614336, "DefaultTiledListModelAccess#sendRequest: requestID: %2, %1", (Object)this.createLogMessage(defaultTiledListModelAccess$ListRange.start, defaultTiledListModelAccess$ListRange.length()), (long)n);
        this.model.requestItems(n, defaultTiledListModelAccess$ListRange.start, defaultTiledListModelAccess$ListRange.length(), this.context.getTerminalID());
    }

    void adjustRequestForAlreadyExistingRows(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange) {
        defaultTiledListModelAccess$ListRange.start = this.findEmptyListRow(defaultTiledListModelAccess$ListRange.start, defaultTiledListModelAccess$ListRange.end, true);
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            return;
        }
        defaultTiledListModelAccess$ListRange.end = this.findEmptyListRow(defaultTiledListModelAccess$ListRange.end, defaultTiledListModelAccess$ListRange.start, false);
    }

    private int findEmptyListRow(int n, int n2, boolean bl) {
        int n3 = bl ? 1 : -1;
        int n4 = n2 + n3;
        for (int i2 = n; i2 != n4; i2 += n3) {
            if (!this.isModelRowEmpty(i2)) continue;
            return i2;
        }
        return n4;
    }

    private boolean isModelRowEmpty(int n) {
        return this.model.getGuiRow(n) == null;
    }

    private Buffer createLogMessage(int n, int n2) {
        if (lc.isDebug()) {
            Buffer buffer = new Buffer(30);
            buffer.append("start: ").append(n);
            buffer.append(", length: ").append(n2);
            buffer.append(", modelID: ").append(this.model.getID());
            buffer.append(", listWidgetIndex: ").append(this.listWidgetIndex);
            buffer.append(", destination: ").append(this.destination);
            buffer.append(", rendered: ").append(this.visibleItems);
            if (!this.isScrolling()) {
                buffer.append(", no scroll");
            } else if (this.isScrollingDownward()) {
                buffer.append(", scroll down");
            } else {
                buffer.append(", scroll up");
            }
            buffer.append(", fulfilled: ").append(this.createLogMessageForFulfilledRanges());
            return buffer;
        }
        return null;
    }

    private Buffer createLogMessageForFulfilledRanges() {
        if (lc.isDebug()) {
            Buffer buffer = new Buffer(20);
            if (this.fulfilledRequests.isEmpty()) {
                buffer.append("noFulfilled");
            }
            Iterator iterator = this.fulfilledRequests.iterator();
            while (iterator.hasNext()) {
                DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)iterator.next();
                buffer.append(defaultTiledListModelAccess$ListRange);
                if (!iterator.hasNext()) continue;
                buffer.append(", ");
            }
            return buffer;
        }
        return null;
    }

    private static int generateRequestID() {
        return nextRequestID++;
    }

    private void sendUnrequest(int n, int n2) {
        lc.log(-2137614336, "DefaultTiledListModelAccess#sendUnrequest: %1", (Object)this.createLogMessage(n, n2));
        this.model.unrequestItems(n, n2, this.context.getTerminalID());
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = this.listLength;
        this.updateLength();
        int n2 = modelUpdateEvent.getUpdateType();
        ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
        if (modelUpdateData != null) {
            if (n2 == 8) {
                int n3;
                if (modelUpdateData.contains(ModelUpdateData$Key.REQUESTID) && this.isExpectedResponse(n3 = modelUpdateData.getInt(ModelUpdateData$Key.REQUESTID))) {
                    int n4 = modelUpdateData.getInt(ModelUpdateData$Key.INDEX);
                    int n5 = modelUpdateData.getInt(ModelUpdateData$Key.COUNT);
                    lc.log(-2137614336, "DefaultTiledListModelAccess#processModelUpdateEvent: received response for requestID: %1, start: %2, length: %3", (long)n3, (long)n4, (long)n5);
                    this.handleResponse(n4, n5);
                }
            } else if (n2 == 20) {
                int n6 = modelUpdateData.getInt(ModelUpdateData$Key.INDEX);
                int n7 = modelUpdateData.getInt(ModelUpdateData$Key.COUNT);
                this.handleCleared(n6, n7);
            } else if (n2 == 7) {
                int n8 = modelUpdateData.getInt(ModelUpdateData$Key.INDEX);
                int n9 = modelUpdateData.getInt(ModelUpdateData$Key.COUNT);
                this.adjustFulfilledForInsert(n8, n9);
            } else if (n2 == 9) {
                int n10 = modelUpdateData.getInt(ModelUpdateData$Key.INDEX);
                int n11 = modelUpdateData.getInt(ModelUpdateData$Key.COUNT);
                this.adjustFulfilledForRemove(n10, n11);
            }
        }
        this.adjustFulfilledForLength();
        if (n2 == 21 || n2 == 6) {
            this.handleClearedAll();
        } else if (n < this.listLength) {
            this.manageRequest();
        }
    }

    private void updateLength() {
        int n = this.getLength();
        if (this.listLength != n) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#updateLength: list length changed from %1 to %2", (long)this.listLength, (long)n);
        }
        this.listLength = n;
    }

    private void adjustFulfilledForLength() {
        Iterator iterator = this.fulfilledRequests.iterator();
        while (iterator.hasNext()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)iterator.next();
            this.adjustFulfilledForLength(defaultTiledListModelAccess$ListRange);
            if (!defaultTiledListModelAccess$ListRange.isEmpty()) continue;
            iterator.remove();
        }
    }

    private void adjustFulfilledForLength(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange) {
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            return;
        }
        int n = this.listLength - 1;
        if (defaultTiledListModelAccess$ListRange.end <= n) {
            return;
        }
        if (defaultTiledListModelAccess$ListRange.start > n) {
            defaultTiledListModelAccess$ListRange.clear();
        } else {
            defaultTiledListModelAccess$ListRange.end = Math.min(defaultTiledListModelAccess$ListRange.end, n);
        }
    }

    private void adjustFulfilledForInsert(int n, int n2) {
        Iterator iterator = this.fulfilledRequests.iterator();
        while (iterator.hasNext()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)iterator.next();
            this.adjustFulfilledForInsert(n, n2, defaultTiledListModelAccess$ListRange);
        }
    }

    private void adjustFulfilledForInsert(int n, int n2, DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange) {
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            return;
        }
        if (defaultTiledListModelAccess$ListRange.end < n) {
            return;
        }
        if (defaultTiledListModelAccess$ListRange.start >= n) {
            defaultTiledListModelAccess$ListRange.start += n2;
        }
        if (defaultTiledListModelAccess$ListRange.end >= n) {
            defaultTiledListModelAccess$ListRange.end += n2;
        }
        lc.log(-2137614336, "DefaultTiledListModelAccess#adjustFulfilledForInsert: adjust fulfilled range: %1", (Object)defaultTiledListModelAccess$ListRange);
    }

    private void adjustFulfilledForRemove(int n, int n2) {
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = null;
        Iterator iterator = this.fulfilledRequests.iterator();
        while (iterator.hasNext()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange2 = (DefaultTiledListModelAccess$ListRange)iterator.next();
            this.adjustFulfilledForRemove(n, n2, defaultTiledListModelAccess$ListRange2);
            if (defaultTiledListModelAccess$ListRange2.isEmpty() || defaultTiledListModelAccess$ListRange != null && this.combine(defaultTiledListModelAccess$ListRange, defaultTiledListModelAccess$ListRange2)) {
                iterator.remove();
                continue;
            }
            defaultTiledListModelAccess$ListRange = defaultTiledListModelAccess$ListRange2;
        }
    }

    private void adjustFulfilledForRemove(int n, int n2, DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange) {
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            return;
        }
        if (defaultTiledListModelAccess$ListRange.end < n) {
            return;
        }
        int n3 = n + n2 - 1;
        if (defaultTiledListModelAccess$ListRange.start > n3) {
            defaultTiledListModelAccess$ListRange.start -= n2;
            defaultTiledListModelAccess$ListRange.end -= n2;
        } else if (defaultTiledListModelAccess$ListRange.start >= n && defaultTiledListModelAccess$ListRange.end <= n3) {
            defaultTiledListModelAccess$ListRange.clear();
        } else {
            if (defaultTiledListModelAccess$ListRange.start >= n) {
                defaultTiledListModelAccess$ListRange.start = n;
            }
            int n4 = Math.max(0, Math.min(defaultTiledListModelAccess$ListRange.end, n3) - Math.max(defaultTiledListModelAccess$ListRange.start, n) + 1);
            defaultTiledListModelAccess$ListRange.end -= n4;
        }
        lc.log(-2137614336, "DefaultTiledListModelAccess#adjustFulfilledForRemove: adjust fulfilled range: %1", (Object)defaultTiledListModelAccess$ListRange);
    }

    private boolean isExpectedResponse(int n) {
        if (!this.isRequestRunning()) {
            lc.log(-1601830656, "DefaultTiledListModelAccess#checkResponse: received unexpected response with requestID %1", (long)n);
            return false;
        }
        if (this.runningRequestID != n) {
            lc.log(-1601830656, "DefaultTiledListModelAccess#checkResponse: received response with requestID %1, but expected %2", (long)n, (long)this.runningRequestID);
            return false;
        }
        return true;
    }

    private void handleResponse(int n, int n2) {
        this.fulfilled(n, n2);
        if (lc.isDebug()) {
            int n3 = n + n2 - 1;
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = new DefaultTiledListModelAccess$ListRange(n, n3);
            lc.log(-2137614336, "DefaultTiledListModelAccess#handleResponse: items updated: %1, now fulfilled: %2", (Object)defaultTiledListModelAccess$ListRange, (Object)this.createLogMessageForFulfilledRanges());
        }
        this.manageUnrequest();
        this.manageRequest();
    }

    private void fulfilled(int n, int n2) {
        this.addFulfilled(n, n + n2 - 1);
        this.runningRequest.clear();
    }

    void addFulfilled(int n, int n2) {
        int n3;
        boolean bl;
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange;
        if (n > n2) {
            return;
        }
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange2 = new DefaultTiledListModelAccess$ListRange(n, n2);
        int n4 = Collections.binarySearch(this.fulfilledRequests, defaultTiledListModelAccess$ListRange2);
        if (n4 < 0) {
            n4 = -n4 - 1;
        }
        boolean bl2 = false;
        ListIterator listIterator = this.fulfilledRequests.listIterator(n4);
        while (listIterator.hasNext() && this.combine(defaultTiledListModelAccess$ListRange2, defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)listIterator.next())) {
            if (bl2) {
                listIterator.remove();
            } else {
                defaultTiledListModelAccess$ListRange2 = defaultTiledListModelAccess$ListRange;
            }
            bl2 = true;
        }
        if (n4 > 0 && (bl = this.combine(defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)this.fulfilledRequests.get(n3 = n4 - 1), defaultTiledListModelAccess$ListRange2))) {
            if (bl2) {
                this.fulfilledRequests.remove(n3);
            }
            bl2 = true;
        }
        if (!bl2) {
            this.fulfilledRequests.add(n4, defaultTiledListModelAccess$ListRange2);
        }
    }

    private boolean combine(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange, DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange2) {
        if (defaultTiledListModelAccess$ListRange.isEmpty()) {
            defaultTiledListModelAccess$ListRange.set(defaultTiledListModelAccess$ListRange2.start, defaultTiledListModelAccess$ListRange2.end);
            return true;
        }
        if (defaultTiledListModelAccess$ListRange2.isEmpty()) {
            defaultTiledListModelAccess$ListRange2.set(defaultTiledListModelAccess$ListRange.start, defaultTiledListModelAccess$ListRange.end);
            return true;
        }
        if (this.areDistinct(defaultTiledListModelAccess$ListRange, defaultTiledListModelAccess$ListRange2) && !this.areAdjacent(defaultTiledListModelAccess$ListRange, defaultTiledListModelAccess$ListRange2)) {
            return false;
        }
        int n = Math.min(defaultTiledListModelAccess$ListRange.start, defaultTiledListModelAccess$ListRange2.start);
        int n2 = Math.max(defaultTiledListModelAccess$ListRange.end, defaultTiledListModelAccess$ListRange2.end);
        defaultTiledListModelAccess$ListRange.set(n, n2);
        defaultTiledListModelAccess$ListRange2.set(n, n2);
        return true;
    }

    private boolean areDistinct(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange, DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange2) {
        return defaultTiledListModelAccess$ListRange.start > defaultTiledListModelAccess$ListRange2.end || defaultTiledListModelAccess$ListRange.end < defaultTiledListModelAccess$ListRange2.start;
    }

    private boolean areAdjacent(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange, DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange2) {
        return defaultTiledListModelAccess$ListRange.start == defaultTiledListModelAccess$ListRange2.end + 1 || defaultTiledListModelAccess$ListRange.end == defaultTiledListModelAccess$ListRange2.start - 1;
    }

    private void handleCleared(int n, int n2) {
        int n3 = n + n2 - 1;
        this.removeFulfilled(n, n3);
        if (lc.isDebug()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = new DefaultTiledListModelAccess$ListRange(n, n3);
            lc.log(-2137614336, "DefaultTiledListModelAccess#handleCleared: rows cleared: %1, remaining fulfilled: %2", (Object)defaultTiledListModelAccess$ListRange, (Object)this.createLogMessageForFulfilledRanges());
        }
        this.manageRequest();
    }

    private void handleClearedAll() {
        this.fulfilledRequests.clear();
        lc.log(-2137614336, "DefaultTiledListModelAccess#handleClearedAll: all rows cleared");
        this.manageRequest();
    }

    void removeFulfilled(int n, int n2) {
        boolean bl;
        boolean bl2;
        if (this.fulfilledRequests.isEmpty()) {
            return;
        }
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = new DefaultTiledListModelAccess$ListRange(n, n2);
        int n3 = Collections.binarySearch(this.fulfilledRequests, defaultTiledListModelAccess$ListRange);
        if (n3 < 0) {
            n3 = -n3 - 1;
            bl2 = true;
        } else {
            bl2 = false;
        }
        ListIterator listIterator = this.fulfilledRequests.listIterator(n3);
        while (listIterator.hasNext() && (bl = this.removeFulfilledDuringIteration(defaultTiledListModelAccess$ListRange, listIterator))) {
        }
        if (bl2 && n3 > 0) {
            this.removeFulfilledDuringIteration(defaultTiledListModelAccess$ListRange, this.fulfilledRequests.listIterator(n3 - 1));
        }
    }

    private boolean removeFulfilledDuringIteration(DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange, ListIterator listIterator) {
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange2 = (DefaultTiledListModelAccess$ListRange)listIterator.next();
        if (this.areDistinct(defaultTiledListModelAccess$ListRange, defaultTiledListModelAccess$ListRange2)) {
            return false;
        }
        if (defaultTiledListModelAccess$ListRange2.start < defaultTiledListModelAccess$ListRange.start && defaultTiledListModelAccess$ListRange2.end > defaultTiledListModelAccess$ListRange.end) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange3 = new DefaultTiledListModelAccess$ListRange(defaultTiledListModelAccess$ListRange.end + 1, defaultTiledListModelAccess$ListRange2.end);
            listIterator.add(defaultTiledListModelAccess$ListRange3);
            defaultTiledListModelAccess$ListRange2.end = defaultTiledListModelAccess$ListRange.start - 1;
            return false;
        }
        if (defaultTiledListModelAccess$ListRange.start <= defaultTiledListModelAccess$ListRange2.start && defaultTiledListModelAccess$ListRange.end >= defaultTiledListModelAccess$ListRange2.end) {
            listIterator.remove();
            return true;
        }
        if (defaultTiledListModelAccess$ListRange.end < defaultTiledListModelAccess$ListRange2.end) {
            defaultTiledListModelAccess$ListRange2.start = defaultTiledListModelAccess$ListRange.end + 1;
            return false;
        }
        defaultTiledListModelAccess$ListRange2.end = defaultTiledListModelAccess$ListRange.start - 1;
        return true;
    }

    @Override
    public void viewportChanged(MenuViewport menuViewport) {
        if (this.model == null) {
            lc.log(-1601830656, "DefaultTiledListModelAccess#viewportChanged: no valid model set");
            return;
        }
        this.destination = menuViewport;
        lc.log(-2137614336, "DefaultTiledListModelAccess#viewportChanged: new viewport: %1, listWidgetIndex: %2", (Object)menuViewport, (long)this.listWidgetIndex);
        this.manageUnrequest();
        this.manageRequest();
    }

    @Override
    public void rendered(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        if (this.model == null) {
            lc.log(-1601830656, "DefaultTiledListModelAccess#rendered: no valid model set");
            return;
        }
        this.visibleItems = new MenuViewport(menuItemIndex, menuItemIndex2);
        lc.log(-2137614336, "DefaultTiledListModelAccess#rendered: visible items: %1, listWidgetIndex: %2", (Object)this.visibleItems, (long)this.listWidgetIndex);
        this.manageUnrequest();
        this.manageRequest();
    }

    private void manageUnrequest() {
        if (!this.listWidgetVisible) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#manageUnrequest: unrequest all, because list is not visible. fulfilled: %1", (Object)this.createLogMessageForFulfilledRanges());
            this.unrequestAll();
            return;
        }
        if (this.visibleItems.isEmpty() && this.destination.isEmpty()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#manageUnrequest: unrequest all, because list is empty. fulfilled: %1", (Object)this.createLogMessageForFulfilledRanges());
            this.unrequestAll();
            return;
        }
        if (!this.isScrolling()) {
            MenuViewport menuViewport = this.visibleItems.isEmpty() ? this.destination : this.visibleItems;
            this.unrequestBefore(menuViewport);
            this.unrequestAfter(menuViewport);
        } else if (this.isScrollingDownward()) {
            this.unrequestBefore(this.visibleItems);
        } else {
            this.unrequestAfter(this.visibleItems);
        }
    }

    private void unrequestBefore(MenuViewport menuViewport) {
        if (this.fulfilledRequests.isEmpty()) {
            return;
        }
        int n = this.menuIndexToListIndex(menuViewport.start, false) - this.bufferAroundViewport;
        int n2 = this.getFirstFulfilledRow(this.getNotUnrequestAtListStart());
        int n3 = this.getLastFulfilledRow(n - 1);
        if (n2 == -1 || n3 == -1 || n2 > n3) {
            return;
        }
        lc.log(-2137614336, "DefaultTiledListModelAccess#unrequestBefore: retain: %1. unrequest until: %3, fulfilled: %2, ", (Object)menuViewport, (Object)this.createLogMessageForFulfilledRanges(), (long)n3);
        this.unrequestInternal(n2, n3, false);
    }

    private void unrequestAfter(MenuViewport menuViewport) {
        if (this.fulfilledRequests.isEmpty()) {
            return;
        }
        int n = this.menuIndexToListIndex(menuViewport.end, false) + this.bufferAroundViewport;
        int n2 = this.getFirstFulfilledRow(Math.max(n + 1, this.getNotUnrequestAtListStart()));
        int n3 = this.getLastFulfilledRow();
        if (n2 == -1 || n3 == -1 || n2 > n3) {
            return;
        }
        lc.log(-2137614336, "DefaultTiledListModelAccess#unrequestAfter: retain: %1. fulfilled: %2, unrequest from: %3", (Object)menuViewport, (Object)this.createLogMessageForFulfilledRanges(), (long)n2);
        this.unrequestInternal(n2, n3, false);
    }

    private void unrequestAll() {
        if (this.fulfilledRequests.isEmpty()) {
            return;
        }
        int n = this.getFirstFulfilledRow(this.getNotUnrequestAtListStart());
        int n2 = this.getLastFulfilledRow();
        this.unrequestInternal(n, n2, true);
    }

    private int getLastFulfilledRow() {
        return ((DefaultTiledListModelAccess$ListRange)this.fulfilledRequests.get((int)(this.fulfilledRequests.size() - 1))).end;
    }

    private int getFirstFulfilledRow(int n) {
        Iterator iterator = this.fulfilledRequests.iterator();
        while (iterator.hasNext()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)iterator.next();
            if (defaultTiledListModelAccess$ListRange.end < n) continue;
            return Math.max(n, defaultTiledListModelAccess$ListRange.start);
        }
        return -1;
    }

    private int getLastFulfilledRow(int n) {
        ListIterator listIterator = this.fulfilledRequests.listIterator(this.fulfilledRequests.size());
        while (listIterator.hasPrevious()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)listIterator.previous();
            if (defaultTiledListModelAccess$ListRange.start > n) continue;
            return Math.min(n, defaultTiledListModelAccess$ListRange.end);
        }
        return -1;
    }

    private int getFirstNotFulfilledRow(int n) {
        Iterator iterator = this.fulfilledRequests.iterator();
        while (iterator.hasNext()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)iterator.next();
            if (defaultTiledListModelAccess$ListRange.end < n) continue;
            if (defaultTiledListModelAccess$ListRange.start > n) {
                return n;
            }
            n = defaultTiledListModelAccess$ListRange.end + 1;
        }
        return n;
    }

    private int getLastNotFulfilledRow(int n) {
        ListIterator listIterator = this.fulfilledRequests.listIterator(this.fulfilledRequests.size());
        while (listIterator.hasPrevious()) {
            DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)listIterator.previous();
            if (defaultTiledListModelAccess$ListRange.start > n) continue;
            if (defaultTiledListModelAccess$ListRange.end < n) {
                return n;
            }
            n = defaultTiledListModelAccess$ListRange.start - 1;
        }
        return n;
    }

    private void manageRequest() {
        if (!this.listWidgetVisible) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#manageRequest: list widget is not visible");
            return;
        }
        if (this.destination.isEmpty()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#manageRequest: destination is empty");
            return;
        }
        if (this.isListEmpty()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#manageRequest: list is empty. Destination: %1, listIndex: %2", (Object)this.destination, (long)this.listWidgetIndex);
            return;
        }
        if (this.isRequestRunning()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#manageRequest: another request is still running. ID: %2, range: %1", (Object)this.runningRequest, (long)this.runningRequestID);
            return;
        }
        if (!this.isScrolling()) {
            this.requestDestination();
        } else if (this.isScrollingDownward()) {
            this.requestAfter();
        } else {
            this.requestBefore();
        }
    }

    private void requestBefore() {
        int n;
        int n2 = this.menuIndexToListIndex(this.visibleItems.end, false);
        if (n2 < 0) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestBefore: visible area is before list. visible items: %1, list widget index: %2", (Object)this.visibleItems, (long)this.listWidgetIndex);
            return;
        }
        n2 = Math.min(this.getLastListIndex(), n2);
        if (!this.fulfilledRequests.isEmpty()) {
            n2 = this.getLastNotFulfilledRow(n2);
            n = this.menuIndexToListIndex(this.visibleItems.start, false);
            int n3 = n - n2 - 1;
            if (n3 >= this.defaultRequestLength) {
                lc.log(-2137614336, "DefaultTiledListModelAccess#requestBefore: preloading-limit reached. visibleStart: %2, last unloaded: %3, fulfilled: %1", (Object)this.createLogMessageForFulfilledRanges(), (long)n, (long)n2);
                return;
            }
        }
        if (n2 < 0) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestBefore: reached start of list. visible items: %1, fulfilled: %2, listLength: %3", (Object)this.visibleItems, (Object)this.createLogMessageForFulfilledRanges(), (long)this.listLength);
            return;
        }
        if (n2 < this.menuIndexToListIndex(this.destination.start, false)) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestBefore: reached destination: %1, next request index: %2", (Object)this.destination, (long)n2);
            return;
        }
        n = Math.max(0, n2 - this.defaultRequestLength + 1);
        this.requestInternal(n, this.defaultRequestLength);
    }

    private void requestAfter() {
        int n;
        int n2;
        int n3 = this.menuIndexToListIndex(this.visibleItems.start, false);
        if (n3 > this.getLastListIndex()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestAfter: visible area is after list. visible items: %1, list widget index: %2", (Object)this.visibleItems, (long)this.listWidgetIndex);
            return;
        }
        n3 = Math.max(0, n3);
        if (!this.fulfilledRequests.isEmpty() && (n2 = (n3 = this.getFirstNotFulfilledRow(n3)) - (n = this.menuIndexToListIndex(this.visibleItems.end, false)) - 1) >= this.defaultRequestLength) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestAfter: preloading-limit reached. visibleEnd: %2, first unloaded: %3, fulfilled: %1", (Object)this.createLogMessageForFulfilledRanges(), (long)n, (long)n3);
            return;
        }
        if (n3 > this.getLastListIndex()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestAfter: reached end of list. visible items: %1, fulfilled: %2, listLength: %3", (Object)this.visibleItems, (Object)this.createLogMessageForFulfilledRanges(), (long)this.listLength);
            return;
        }
        if (n3 > this.menuIndexToListIndex(this.destination.end, false)) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestAfter: reached destination: %1, next request index: %2", (Object)this.destination, (long)n3);
            return;
        }
        this.requestInternal(n3, this.defaultRequestLength);
    }

    private void requestDestination() {
        int n;
        if (this.destination.start.widget > this.listWidgetIndex || this.destination.end.widget < this.listWidgetIndex) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestDestination: destination is outside of this list. Destination: %1, listIndex: %2", (Object)this.destination, (long)this.listWidgetIndex);
            return;
        }
        if (this.isListEmpty()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestDestination: list is empty. Destination: %1, listIndex: %2", (Object)this.destination, (long)this.listWidgetIndex);
            return;
        }
        int n2 = this.menuIndexToListIndex(this.destination.start, true);
        int n3 = this.menuIndexToListIndex(this.destination.end, true);
        --n2;
        ++n3;
        n2 = Math.max(0, n2);
        n3 = Math.min(this.getLastListIndex(), n3);
        if (!this.fulfilledRequests.isEmpty()) {
            n2 = this.getFirstNotFulfilledRow(n2);
            n3 = this.getLastNotFulfilledRow(n3);
        }
        if ((n = n3 - n2 + 1) <= 0) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestDestination: already loaded destination: %1, fulfilled: %2", (Object)this.destination, (Object)this.createLogMessageForFulfilledRanges());
            return;
        }
        int n4 = Math.max(0, this.defaultRequestLength - n);
        int n5 = Math.min(n2, n4 / 2);
        int n6 = n2 - n5;
        int n7 = this.defaultRequestLength;
        this.requestInternal(n6, n7);
    }

    private boolean isScrolling() {
        if (this.destination.isEmpty() || this.visibleItems.isEmpty()) {
            return false;
        }
        return !this.visibleItems.contains(this.destination.start) || !this.visibleItems.contains(this.destination.end);
    }

    private boolean isScrollingDownward() {
        return this.visibleItems.start.isBefore(this.destination.start);
    }

    private int menuIndexToListIndex(MenuItemIndex menuItemIndex, boolean bl) {
        if (menuItemIndex.widget == this.listWidgetIndex) {
            return Math.min(menuItemIndex.widgetPart, this.getLastListIndex());
        }
        if (menuItemIndex.widget < this.listWidgetIndex) {
            return bl ? 0 : -1;
        }
        return bl ? this.getLastListIndex() : this.getLastListIndex() + 1;
    }

    private int getLastListIndex() {
        return this.isListEmpty() ? 0 : this.listLength - 1;
    }

    private boolean isListEmpty() {
        return this.listLength == 0;
    }

    private void requestInternal(int n, int n2) {
        if (this.isAsia) {
            this.updateLength();
        }
        if ((n2 = Math.min(n2, this.listLength - n)) <= 0) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#requestInternal: requestLength is 0 (start: %1)", (long)n);
            return;
        }
        if (this.isRequestRunning()) {
            lc.log(10000, "DefaultTiledListModelAccess#requestInternal: Already requested %1, can't request %2+%3", (Object)this.runningRequest, (long)n, (long)n2);
            throw new IllegalStateException(new StringBuffer().append("Already requested: ").append(this.runningRequest).append(". Can't send new request for ").append(n).append("-").append(n2).toString());
        }
        this.sendRequest(new DefaultTiledListModelAccess$ListRange(n, n + n2 - 1));
    }

    private void unrequestInternal(int n, int n2, boolean bl) {
        if ((n2 = Math.min(n2, this.getLastListIndex())) < n) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#unrequestInternal: end %1 is before start %2", (long)n2, (long)n);
            return;
        }
        int n3 = n2 - n + 1;
        if (n3 < this.unrequestMinLength && !bl && this.isScrolling()) {
            lc.log(-2137614336, "DefaultTiledListModelAccess#unrequestInternal: don't send unrequest (%1 - %2) smaller than min size %3", (long)n, (long)n2, (long)this.unrequestMinLength);
            return;
        }
        this.removeFulfilled(n, n2);
        this.sendUnrequest(n, n3);
    }

    private int getNotUnrequestAtListStart() {
        return Math.max(this.bufferAtListStart, this.defaultRequestLength);
    }

    public int getDefaultRequestLength() {
        return this.defaultRequestLength;
    }

    public void setDefaultRequestLength(int n) {
        this.defaultRequestLength = n;
    }

    public int getBufferAroundViewport() {
        return this.bufferAroundViewport;
    }

    public void setBufferAroundViewport(int n) {
        this.bufferAroundViewport = n;
    }

    public int getUnrequestMinLength() {
        return this.unrequestMinLength;
    }

    public void setUnrequestMinLength(int n) {
        this.unrequestMinLength = n;
    }

    List test_getFulfilledRequests() {
        return this.fulfilledRequests;
    }
}

