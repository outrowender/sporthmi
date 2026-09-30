/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.truffle;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.mer.IncludeMenuEntry;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.dsi.ifc.search.CarFunction;

public class CarTruffleSearch
extends AbstractSearch
implements IMERVisibilityChangeListener {
    private HashMap carFunctions;
    private CarFunction[] carFunctionsArray;
    private LinkedList currentlyInvisibleMenuEntries = new LinkedList();
    private final ArrayList includeMenuEntries = new ArrayList();
    private ICarApplication carApplication;

    public CarTruffleSearch(ICarApplication iCarApplication, LogChannel logChannel, int n) {
        super(iCarApplication.getBundleContext(), iCarApplication.getFrameworkAccess(), logChannel, n);
        this.carApplication = iCarApplication;
        this.carFunctions = new HashMap();
    }

    public void initDSI() {
        super.initDSI();
        this.carApplication.getMenuEntryRegistry().registerVisibilityChangeListener(this);
    }

    private void setActiveElementsWithRealIDs() {
        this.setCarFunctionStates(this.getCarFunctions());
    }

    public void notifyVisibilityChange(List list) {
        if (this.areThereRelevantChangesForTruffleSearch(list)) {
            this.disableChildrenOfLooseIncludeMenuEntries();
            this.setActiveElementsWithRealIDs();
        }
    }

    private void disableChildrenOfLooseIncludeMenuEntries() {
        Iterator iterator = this.includeMenuEntries.iterator();
        while (iterator.hasNext()) {
            IncludeMenuEntry includeMenuEntry = (IncludeMenuEntry)iterator.next();
            if (includeMenuEntry.isBoundToSlot()) continue;
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[CarTruffleSearch#disableChildrenOfLooseIncludeMenuEntries] %1('%2')", (Object)includeMenuEntry.getType(), (Object)includeMenuEntry);
            }
            Vector vector = new Vector();
            includeMenuEntry.addChildrenToListRecursively(vector);
            this.disableMenuEntriesForTruffleSearch(vector);
        }
    }

    private void disableMenuEntriesForTruffleSearch(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMenuEntry iMenuEntry = (IMenuEntry)iterator.next();
            CarFunction carFunction = (CarFunction)this.carFunctions.get(new Integer(iMenuEntry.getID()));
            carFunction.enabled = false;
            if (!this.currentlyInvisibleMenuEntries.contains(iMenuEntry)) {
                this.currentlyInvisibleMenuEntries.add(iMenuEntry);
            }
            if (!this.logChannel.isInfo()) continue;
            this.logChannel.log(1000000, "[CarTruffleSearch#disableMenuEntriesForTruffleSearch] %1('%2') disabled for truffle search: CarFunction ID='%3'", (Object)iMenuEntry.getType(), (Object)iMenuEntry, (long)carFunction.getId());
        }
    }

    private boolean areThereRelevantChangesForTruffleSearch(List list) {
        return this.applyChangesToCarFunctions(list);
    }

    private boolean applyChangesToCarFunctions(List list) {
        boolean bl = false;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IMenuEntry iMenuEntry = (IMenuEntry)iterator.next();
            if (!this.isRelevantChange(iMenuEntry, arrayList)) continue;
            CarFunction carFunction = (CarFunction)this.carFunctions.get(new Integer(iMenuEntry.getID()));
            carFunction.enabled = this.shouldMEBeEnabledForTruffleSearch(iMenuEntry);
            bl = true;
            if (!this.logChannel.isInfo()) continue;
            this.logChannel.log(1000000, "[CarTruffleSearch#applyChangesToCarFunctions] searchability of MenuEntry('%1') changed: menu entry current state='%2', CarFunction ID='%3', enabled for truffle search='%4'", (Object)iMenuEntry, (Object)new Integer(iMenuEntry.getState()), (Object)new Integer(carFunction.getId()), (Object)carFunction.enabled);
        }
        this.currentlyInvisibleMenuEntries.addAll(arrayList);
        return bl;
    }

    private boolean isRelevantChange(IMenuEntry iMenuEntry, List list) {
        if (!this.shouldMEBeEnabledForTruffleSearch(iMenuEntry)) {
            list.add(iMenuEntry);
            return true;
        }
        if (this.currentlyInvisibleMenuEntries.contains(iMenuEntry)) {
            this.currentlyInvisibleMenuEntries.remove(iMenuEntry);
            return true;
        }
        return false;
    }

    private boolean shouldMEBeEnabledForTruffleSearch(IMenuEntry iMenuEntry) {
        return iMenuEntry.getState() != 1;
    }

    public void initUseOfMenuStructure(IMenuEntryStructure iMenuEntryStructure) {
        this.initCarFunctions(iMenuEntryStructure);
        this.setActiveElementsWithRealIDs();
    }

    private void initCarFunctions(IMenuEntryStructure iMenuEntryStructure) {
        Iterator iterator = iMenuEntryStructure.getMenuEntries().entrySet().iterator();
        while (iterator.hasNext()) {
            IMenuEntry iMenuEntry = (IMenuEntry)((Map.Entry)iterator.next()).getValue();
            if (iMenuEntry.isType(MenuEntryType.INCLUDE_MENU_ENTRY)) {
                this.includeMenuEntries.add((IncludeMenuEntry)iMenuEntry);
                continue;
            }
            if (iMenuEntry.isType(MenuEntryType.SLOT_MENU_ENTRY) || iMenuEntry.isType(MenuEntryType.MMICOMBI_MENU_ENTRY)) continue;
            CarFunction carFunction = new CarFunction(iMenuEntry.getID(), this.shouldMEBeEnabledForTruffleSearch(iMenuEntry));
            this.carFunctions.put(new Integer(carFunction.id), carFunction);
            if (!carFunction.enabled) {
                this.currentlyInvisibleMenuEntries.add(iMenuEntry);
            }
            if (!this.logChannel.isInfo()) continue;
            this.logChannel.log(1000000, "[CarTruffleSearch#initCarFunctions] init CarFunction for MenuEntry('%1'): menu entry current state='%2', CarFunction ID='%3', enabled='%4'", (Object)iMenuEntry, (Object)new Integer(iMenuEntry.getState()), (Object)new Integer(carFunction.getId()), (Object)carFunction.enabled);
        }
    }

    private CarFunction[] getCarFunctions() {
        if (this.carFunctionsArray == null) {
            this.carFunctionsArray = new CarFunction[this.carFunctions.size()];
            Iterator iterator = this.carFunctions.values().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                CarFunction carFunction;
                this.carFunctionsArray[n] = carFunction = (CarFunction)iterator.next();
                ++n;
            }
        }
        return this.carFunctionsArray;
    }
}

