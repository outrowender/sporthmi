/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes$AbstractDrawerEntryMatcher;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes$AppIdMatcher;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes$EntryIdMatcher;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$RightDrawerPayload;
import de.audi.remotehmi.ui.mib2.DrawerEntry;
import de.audi.remotehmi.ui.mib2.MenuEntry;
import de.audi.remotehmi.ui.mib2.RightDrawerType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RightDrawerTypes {
    private List rightDrawerTypes;
    private final LogChannel log;
    private final RightDrawerHandler rightDrawerHandler;
    private final LeftDrawerHandler leftDrawerHandler;

    public RightDrawerTypes(RightDrawerHandler rightDrawerHandler, LogChannel logChannel, LeftDrawerHandler leftDrawerHandler) {
        this.rightDrawerHandler = rightDrawerHandler;
        this.log = logChannel;
        this.leftDrawerHandler = leftDrawerHandler;
        this.rightDrawerTypes = new ArrayList();
    }

    protected void setRightDrawerTypes(Commands$RightDrawerPayload commands$RightDrawerPayload) {
        if (commands$RightDrawerPayload == null) {
            this.log.log(-1601830656, "RightDrawerTypes#setRightDrawerTypes: LeftDrawerPayload provided is null");
            return;
        }
        String string = commands$RightDrawerPayload.getContextName();
        List list = commands$RightDrawerPayload.rightDrawerEntriesList;
        List list2 = list == null ? Collections.EMPTY_LIST : list;
        this.log.log(1078071040, "RightDrawerTypes#setRightDrawerTypes: called for context name '%1'", (Object)string);
        this.rightDrawerTypes = list2;
        this.rightDrawerHandler.loadRightDrawerForSpecificContext();
    }

    private List getRightDrawerTypes() {
        return this.rightDrawerTypes;
    }

    public DrawerEntry findEntryByEntryId(String string) {
        this.log.log(1078071040, "RightDrawerTypes#findEntryByEntryId: called for app id '%1'", (Object)string);
        RightDrawerTypes$EntryIdMatcher rightDrawerTypes$EntryIdMatcher = new RightDrawerTypes$EntryIdMatcher(this, string);
        return this.findEntry(rightDrawerTypes$EntryIdMatcher);
    }

    public List findBlockableEntries() {
        this.log.log(1078071040, "RightDrawerTypes#findBlockableEntries: called.");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getRightDrawerTypes().iterator();
        while (iterator.hasNext()) {
            RightDrawerType rightDrawerType = (RightDrawerType)iterator.next();
            this.log.log(-2137614336, "RightDrawerTypes#findBlockableEntries: type: %1", (Object)rightDrawerType.getTypeName());
            List list = rightDrawerType.getEntriesList();
            if (list == null || list.isEmpty()) {
                this.log.log(-2137614336, "RightDrawerTypes#findBlockableEntries: type %1 has no entries", (Object)rightDrawerType.getTypeName());
                continue;
            }
            for (int i2 = 0; i2 < list.size(); ++i2) {
                DrawerEntry drawerEntry = (DrawerEntry)list.get(i2);
                this.log.log(-2137614336, "RightDrawerTypes#findBlockableEntries: type %1, entry  %3 (%2), blockable %4", (Object)rightDrawerType.getTypeName(), (Object)drawerEntry.getEntryId(), (Object)drawerEntry.getEntryName(), (Object)Boolean.toString(drawerEntry.isBlocking()));
                if (!drawerEntry.isBlocking()) continue;
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    public DrawerEntry findEntryByAppId(String string) {
        this.log.log(1078071040, "RightDrawerTypes#findEntryByAppId: called for app id '%1'", (Object)string);
        RightDrawerTypes$AppIdMatcher rightDrawerTypes$AppIdMatcher = new RightDrawerTypes$AppIdMatcher(this, string);
        return this.findEntry(rightDrawerTypes$AppIdMatcher);
    }

    private DrawerEntry findEntry(RightDrawerTypes$AbstractDrawerEntryMatcher rightDrawerTypes$AbstractDrawerEntryMatcher) {
        DrawerEntry drawerEntry = this.findContextSpecificOrContextSensitiveEntry(rightDrawerTypes$AbstractDrawerEntryMatcher);
        if (drawerEntry == null) {
            this.log.log(1078071040, "RightDrawerTypes#findEntry: entry id '%1' not found in context specific and context sensitive entries so checking menu specific entries", (Object)rightDrawerTypes$AbstractDrawerEntryMatcher);
            drawerEntry = this.findMenuSpecificEntry(rightDrawerTypes$AbstractDrawerEntryMatcher);
        }
        return drawerEntry;
    }

    private DrawerEntry findMenuSpecificEntry(RightDrawerTypes$AbstractDrawerEntryMatcher rightDrawerTypes$AbstractDrawerEntryMatcher) {
        this.log.log(1078071040, "RightDrawerTypes#findMenuSpecificEntry: called for entry id '%1'", (Object)rightDrawerTypes$AbstractDrawerEntryMatcher);
        List list = this.leftDrawerHandler.getMenuEntries();
        if (list == null) {
            return null;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry;
            MenuEntry menuEntry = (MenuEntry)iterator.next();
            List list2 = menuEntry.getRightDrawerEntries();
            if (list2 == null || (drawerEntry = this.findEntryInList(rightDrawerTypes$AbstractDrawerEntryMatcher, list2)) == null) continue;
            this.log.log(1078071040, "RightDrawerTypes#findMenuSpecificEntry: entry id '%1' found", (Object)rightDrawerTypes$AbstractDrawerEntryMatcher);
            return drawerEntry;
        }
        return null;
    }

    private DrawerEntry findContextSpecificOrContextSensitiveEntry(RightDrawerTypes$AbstractDrawerEntryMatcher rightDrawerTypes$AbstractDrawerEntryMatcher) {
        this.log.log(1078071040, "RightDrawerTypes#findContextSpecificOrContextSensitiveEntry: called for entry id '%1'", (Object)rightDrawerTypes$AbstractDrawerEntryMatcher);
        if (this.getRightDrawerTypes() == null) {
            return null;
        }
        Iterator iterator = this.getRightDrawerTypes().iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry;
            RightDrawerType rightDrawerType = (RightDrawerType)iterator.next();
            List list = rightDrawerType.getEntriesList();
            if (list == null || (drawerEntry = this.findEntryInList(rightDrawerTypes$AbstractDrawerEntryMatcher, list)) == null) continue;
            this.log.log(1078071040, "RightDrawerTypes#findContextSpecificOrContextSensitiveEntry: entry id '%1' found", (Object)rightDrawerTypes$AbstractDrawerEntryMatcher);
            return drawerEntry;
        }
        return null;
    }

    private DrawerEntry findEntryInList(RightDrawerTypes$AbstractDrawerEntryMatcher rightDrawerTypes$AbstractDrawerEntryMatcher, List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry = (DrawerEntry)iterator.next();
            if (!rightDrawerTypes$AbstractDrawerEntryMatcher.matches(drawerEntry)) continue;
            return drawerEntry;
        }
        return null;
    }

    public Map getRightDrawerEntriesForCurrentContext() {
        HashMap hashMap = new HashMap();
        if (this.getRightDrawerTypes() == null || this.getRightDrawerTypes().size() <= 0) {
            this.log.log(1078071040, "RightDrawerTypes#getRightDrawerEntriesForCurrentContext: No types exist");
            return hashMap;
        }
        Iterator iterator = this.getRightDrawerTypes().iterator();
        while (iterator.hasNext()) {
            RightDrawerType rightDrawerType = (RightDrawerType)iterator.next();
            String string = rightDrawerType.getTypeName();
            List list = rightDrawerType.getEntriesList();
            if (list == null || list.size() <= 0) continue;
            hashMap.put(string, list);
            this.log.log(1078071040, "RightDrawerTypes#getRightDrawerEntriesForCurrentContext: type '%1' having entries '%2' added", (Object)string, (Object)list.toString());
        }
        return hashMap;
    }
}

