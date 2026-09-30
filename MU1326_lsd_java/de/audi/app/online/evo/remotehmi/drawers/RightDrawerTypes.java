/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands;
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

    protected void setRightDrawerTypes(Commands.RightDrawerPayload rightDrawerPayload) {
        if (rightDrawerPayload == null) {
            this.log.log(100000, "RightDrawerTypes#setRightDrawerTypes: LeftDrawerPayload provided is null");
            return;
        }
        String string = rightDrawerPayload.getContextName();
        List list = rightDrawerPayload.rightDrawerEntriesList;
        List list2 = list == null ? Collections.EMPTY_LIST : list;
        this.log.log(1000000, "RightDrawerTypes#setRightDrawerTypes: called for context name '%1'", (Object)string);
        this.rightDrawerTypes = list2;
        this.rightDrawerHandler.loadRightDrawerForSpecificContext();
    }

    private List getRightDrawerTypes() {
        return this.rightDrawerTypes;
    }

    public DrawerEntry findEntryByEntryId(String string) {
        this.log.log(1000000, "RightDrawerTypes#findEntryByEntryId: called for app id '%1'", (Object)string);
        EntryIdMatcher entryIdMatcher = new EntryIdMatcher(string);
        return this.findEntry(entryIdMatcher);
    }

    public List findBlockableEntries() {
        this.log.log(1000000, "RightDrawerTypes#findBlockableEntries: called.");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getRightDrawerTypes().iterator();
        while (iterator.hasNext()) {
            RightDrawerType rightDrawerType = (RightDrawerType)iterator.next();
            this.log.log(10000000, "RightDrawerTypes#findBlockableEntries: type: %1", (Object)rightDrawerType.getTypeName());
            List list = rightDrawerType.getEntriesList();
            if (list == null || list.isEmpty()) {
                this.log.log(10000000, "RightDrawerTypes#findBlockableEntries: type %1 has no entries", (Object)rightDrawerType.getTypeName());
                continue;
            }
            for (int i2 = 0; i2 < list.size(); ++i2) {
                DrawerEntry drawerEntry = (DrawerEntry)list.get(i2);
                this.log.log(10000000, "RightDrawerTypes#findBlockableEntries: type %1, entry  %3 (%2), blockable %4", (Object)rightDrawerType.getTypeName(), (Object)drawerEntry.getEntryId(), (Object)drawerEntry.getEntryName(), (Object)Boolean.toString(drawerEntry.isBlocking()));
                if (!drawerEntry.isBlocking()) continue;
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    public DrawerEntry findEntryByAppId(String string) {
        this.log.log(1000000, "RightDrawerTypes#findEntryByAppId: called for app id '%1'", (Object)string);
        AppIdMatcher appIdMatcher = new AppIdMatcher(string);
        return this.findEntry(appIdMatcher);
    }

    private DrawerEntry findEntry(AbstractDrawerEntryMatcher abstractDrawerEntryMatcher) {
        DrawerEntry drawerEntry = this.findContextSpecificOrContextSensitiveEntry(abstractDrawerEntryMatcher);
        if (drawerEntry == null) {
            this.log.log(1000000, "RightDrawerTypes#findEntry: entry id '%1' not found in context specific and context sensitive entries so checking menu specific entries", (Object)abstractDrawerEntryMatcher);
            drawerEntry = this.findMenuSpecificEntry(abstractDrawerEntryMatcher);
        }
        return drawerEntry;
    }

    private DrawerEntry findMenuSpecificEntry(AbstractDrawerEntryMatcher abstractDrawerEntryMatcher) {
        this.log.log(1000000, "RightDrawerTypes#findMenuSpecificEntry: called for entry id '%1'", (Object)abstractDrawerEntryMatcher);
        List list = this.leftDrawerHandler.getMenuEntries();
        if (list == null) {
            return null;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry;
            MenuEntry menuEntry = (MenuEntry)iterator.next();
            List list2 = menuEntry.getRightDrawerEntries();
            if (list2 == null || (drawerEntry = this.findEntryInList(abstractDrawerEntryMatcher, list2)) == null) continue;
            this.log.log(1000000, "RightDrawerTypes#findMenuSpecificEntry: entry id '%1' found", (Object)abstractDrawerEntryMatcher);
            return drawerEntry;
        }
        return null;
    }

    private DrawerEntry findContextSpecificOrContextSensitiveEntry(AbstractDrawerEntryMatcher abstractDrawerEntryMatcher) {
        this.log.log(1000000, "RightDrawerTypes#findContextSpecificOrContextSensitiveEntry: called for entry id '%1'", (Object)abstractDrawerEntryMatcher);
        if (this.getRightDrawerTypes() == null) {
            return null;
        }
        Iterator iterator = this.getRightDrawerTypes().iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry;
            RightDrawerType rightDrawerType = (RightDrawerType)iterator.next();
            List list = rightDrawerType.getEntriesList();
            if (list == null || (drawerEntry = this.findEntryInList(abstractDrawerEntryMatcher, list)) == null) continue;
            this.log.log(1000000, "RightDrawerTypes#findContextSpecificOrContextSensitiveEntry: entry id '%1' found", (Object)abstractDrawerEntryMatcher);
            return drawerEntry;
        }
        return null;
    }

    private DrawerEntry findEntryInList(AbstractDrawerEntryMatcher abstractDrawerEntryMatcher, List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DrawerEntry drawerEntry = (DrawerEntry)iterator.next();
            if (!abstractDrawerEntryMatcher.matches(drawerEntry)) continue;
            return drawerEntry;
        }
        return null;
    }

    public Map getRightDrawerEntriesForCurrentContext() {
        HashMap hashMap = new HashMap();
        if (this.getRightDrawerTypes() == null || this.getRightDrawerTypes().size() <= 0) {
            this.log.log(1000000, "RightDrawerTypes#getRightDrawerEntriesForCurrentContext: No types exist");
            return hashMap;
        }
        Iterator iterator = this.getRightDrawerTypes().iterator();
        while (iterator.hasNext()) {
            RightDrawerType rightDrawerType = (RightDrawerType)iterator.next();
            String string = rightDrawerType.getTypeName();
            List list = rightDrawerType.getEntriesList();
            if (list == null || list.size() <= 0) continue;
            hashMap.put(string, list);
            this.log.log(1000000, "RightDrawerTypes#getRightDrawerEntriesForCurrentContext: type '%1' having entries '%2' added", (Object)string, (Object)list.toString());
        }
        return hashMap;
    }

    private class AppIdMatcher
    extends AbstractDrawerEntryMatcher {
        public AppIdMatcher(String string) {
            this.property = string;
        }

        public boolean matches(DrawerEntry drawerEntry) {
            if (drawerEntry == null || drawerEntry.getAppId() == null) {
                return false;
            }
            return drawerEntry.getAppId().equals(this.property);
        }
    }

    private class EntryIdMatcher
    extends AbstractDrawerEntryMatcher {
        public EntryIdMatcher(String string) {
            this.property = string;
        }

        public boolean matches(DrawerEntry drawerEntry) {
            if (drawerEntry == null || drawerEntry.getEntryId() == null || drawerEntry.getEntryId().equals("")) {
                return false;
            }
            return drawerEntry.getEntryId().equals(this.property);
        }
    }

    private abstract class AbstractDrawerEntryMatcher {
        protected String property;

        private AbstractDrawerEntryMatcher() {
        }

        abstract boolean matches(DrawerEntry var1);

        public String toString() {
            return this.property;
        }
    }
}

