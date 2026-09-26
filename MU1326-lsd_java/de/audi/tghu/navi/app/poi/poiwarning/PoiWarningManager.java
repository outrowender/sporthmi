/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.commands.EhSetCategoryMonitoringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiGetAllCategoriesCommand;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.poi.POICategoryManager$POICategoriesObserver;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningManager$PoiElement;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningModelAccess;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningPersistenceHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Category;

public class PoiWarningManager
implements TimerListener,
POICategoryManager$POICategoriesObserver {
    protected boolean poiWarningFeatureActive = false;
    protected static final int MAX_ITEMS_SELECTION;
    protected static final int NO_POIS_SELECTED;
    protected static final int APPROACH_WARNING;
    protected static final int SOUND_FEEDBACK;
    protected static final int APPROACH_WARNING_ON;
    protected static final int APPROACH_WARNING_OFF;
    protected static final int SOUND_FEEDBACK_ON;
    protected static final int SOUND_FEEDBACK_OFF;
    private static final int[] noSelectedPois;
    private final LogChannel logChannel;
    protected final PoiWarningModelAccess poiWarningModelAccess;
    private final ICommandListFactory commandListFactory;
    private final INaviAudioHandler naviAudioHandler;
    private final IVehicle vehicle;
    private final IconHandler iconHandler;
    private int mapStyleType = 0;
    private PoiWarningPersistenceHelper poiWarningPersistenceHelper;
    private PoiWarningPersistenceHelper poiWarningSettings;
    private int[] selectedSettings = new int[]{0, 0};
    private NavLocation savedPoiLocation;
    protected LinkedList selectedPois = new LinkedList();
    private final Timer updateAirdistanceTimer;
    private static final long AIR_DISTANCE_CALCULATION_DELAY;
    private static final int MAX_TIMER_REPETITION;
    private volatile int actualRepetition = 0;
    protected MapInterface mapInterface;
    private volatile boolean checkAll = false;
    protected volatile NavLocation currentLocationPoiProximityWarning;

    public PoiWarningManager(NavigationEnv navigationEnv, PoiWarningModelAccess poiWarningModelAccess, ICommandListFactory iCommandListFactory, INaviAudioHandler iNaviAudioHandler, IVehicle iVehicle, IconHandler iconHandler, MapInterface mapInterface) {
        if (navigationEnv.getFramework().getSysConstManager().getSysConst(4548) == 1) {
            this.poiWarningFeatureActive = true;
        }
        this.logChannel = navigationEnv.getPoiApproachWarningLogChannel();
        this.poiWarningModelAccess = poiWarningModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.naviAudioHandler = iNaviAudioHandler;
        this.vehicle = iVehicle;
        this.iconHandler = iconHandler;
        this.poiWarningPersistenceHelper = new PoiWarningPersistenceHelper(navigationEnv, 980);
        this.poiWarningSettings = new PoiWarningPersistenceHelper(navigationEnv, 981);
        this.mapInterface = mapInterface;
        this.updateAirdistanceTimer = new Timer("PoiApproachWarningTimer", 5, null, this, 0, false);
    }

    public void init() {
        if (this.poiWarningFeatureActive) {
            this.deserializeAll();
            this.registerAllSelectedCategories(this.selectedPois);
        }
    }

    public void screenEntered() {
        this.logChannel.log(-2137614336, "PoiWarningManager#screenEntered");
        this.poiWarningModelAccess.setMaxSelectableCategories(10);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiGetAllCategoriesCommand(this, this.mapStyleType, this.logChannel));
        commandList.execute("PoiWarningManager#screenEntered()");
    }

    public void exitPoiWarning() {
        this.logChannel.log(-2137614336, "PoiWarningManager#exitPoiWarning");
        this.serializePois();
        this.unRegisterAllSelectedCategories();
        if (this.selectedSettings[0] == 1) {
            this.registerAllSelectedCategories(this.selectedPois);
        }
    }

    private boolean doPersonalPoisExist(Category[] categoryArray) {
        if (categoryArray != null && categoryArray.length > 0) {
            for (int i2 = 0; i2 < categoryArray.length; ++i2) {
                if (!categoryArray[i2].isPersonal()) continue;
                return true;
            }
        }
        return false;
    }

    public synchronized void poiCategoriesUpdate(int n, Category[] categoryArray) {
        this.logChannel.log(-2137614336, "PoiWarningManager#poiCategoriesUpdate");
        if (n != 0 && !this.poiWarningModelAccess.isMainPoiListEmpty()) {
            this.logChannel.log(-2137614336, "PoiWarningManager#poiCategoriesUpdate, get the categories from mapStyle: %1, skip the update: %2 ", (Object)Integer.toString(n), (Object)(categoryArray == null ? "null" : Integer.toString(categoryArray.length)));
            return;
        }
        this.mapStyleType = n;
        int n2 = 0;
        if (null != categoryArray) {
            boolean bl = this.doPersonalPoisExist(categoryArray);
            try {
                if (this.selectedPois != null && this.selectedPois.size() > 0 && ((PoiWarningManager$PoiElement)this.selectedPois.getFirst()).id() != -1) {
                    this.logChannel.log(-2137614336, "   --> SOME Categories Saved, set them to TRUE");
                    ListIterator listIterator = this.selectedPois.listIterator();
                    while (listIterator.hasNext()) {
                        PoiWarningManager$PoiElement poiWarningManager$PoiElement = (PoiWarningManager$PoiElement)listIterator.next();
                        for (int i2 = 0; i2 < categoryArray.length; ++i2) {
                            if (poiWarningManager$PoiElement.id() != categoryArray[i2].getCategoryUid()) continue;
                            categoryArray[i2].monitored = true;
                            poiWarningManager$PoiElement.setActivlyInUse();
                            this.logChannel.log(14808325, "      --> Set Category - %1 - to TRUE", (Object)categoryArray[i2].getDescription());
                            this.logChannel.log(14808325, "      --> Actual selected items: %1", (long)(++n2));
                        }
                    }
                    if (this.selectedPois.size() == categoryArray.length) {
                        this.poiWarningModelAccess.setCheckAllPoisSelected(true);
                    }
                } else {
                    this.poiWarningModelAccess.setCheckAllPoisSelected(false);
                }
                this.logChannel.log(-2137614336, "   --> selected Items: %1", (long)n2);
                this.poiWarningModelAccess.updatePois(categoryArray, bl);
                if (this.selectedSettings[0] == 1) {
                    this.logChannel.log(-2137614336, "   --> Approach Hint Activated! Registering selected Categories at Southside");
                    this.registerAllSelectedCategories(this.selectedPois);
                }
            }
            catch (NoSuchElementException noSuchElementException) {
                this.logChannel.log(10000, "   --> NoSuchElementException! Some Settings were not deserialised properly!");
            }
        }
    }

    public void changePoiSelection(int n) {
        if (!this.toggleNewPoiSelection(n)) {
            this.poiWarningModelAccess.showPoiWarningMaxPopUp();
        }
    }

    public void changePpoiSelection(int n) {
        if (!this.toggleNewPoiSelection(n)) {
            this.poiWarningModelAccess.showPpoiWarningMaxPopUp();
        }
    }

    private synchronized boolean toggleNewPoiSelection(int n) {
        if (this.removeNewPoiSelection(n)) {
            return true;
        }
        return this.addNewPoiSelection(n);
    }

    private synchronized boolean removeNewPoiSelection(int n) {
        this.logChannel.log(-2137614336, "PoiWarningManager#removeNewPoiSelection( %1 )", (long)n);
        ListIterator listIterator = this.selectedPois.listIterator();
        while (listIterator.hasNext()) {
            PoiWarningManager$PoiElement poiWarningManager$PoiElement = (PoiWarningManager$PoiElement)listIterator.next();
            if (n != poiWarningManager$PoiElement.id()) continue;
            this.unregisterCategory(n);
            this.poiWarningModelAccess.setPoiSelection(n, false);
            return true;
        }
        return false;
    }

    protected synchronized boolean addNewPoiSelection(int n) {
        if (this.NumberOfSelectedPois(this.selectedPois) < 10) {
            this.registerCategory(n);
            this.poiWarningModelAccess.setPoiSelection(n, true);
            return true;
        }
        return false;
    }

    protected int NumberOfSelectedPois(LinkedList linkedList) {
        int n = 0;
        if (linkedList != null && linkedList.size() > 0) {
            ListIterator listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                PoiWarningManager$PoiElement poiWarningManager$PoiElement = (PoiWarningManager$PoiElement)listIterator.next();
                if (!poiWarningManager$PoiElement.isValid()) continue;
                ++n;
            }
        }
        return n;
    }

    protected synchronized void registerCategory(int n) {
        this.logChannel.log(-2137614336, "PoiWarningManager#registerCategory for item with ID: %1", (long)n);
        if (this.selectedPois != null) {
            if (this.selectedPois.size() > 0 && ((PoiWarningManager$PoiElement)this.selectedPois.getFirst()).id() == -1) {
                this.selectedPois.removeFirst();
            }
            this.selectedPois.add(new PoiWarningManager$PoiElement(this, n, true));
            this.logChannel.log(-2137614336, "   --> Now there are %1 selected Items stored in the System", (long)this.selectedPois.size());
        } else {
            this.logChannel.log(-2137614336, "   --> Now there are null selected Items stored in the System");
        }
        if (this.selectedPois.size() == this.poiWarningModelAccess.getNumberOfPois()) {
            this.poiWarningModelAccess.setCheckAllPoisSelected(true);
            this.checkAll = true;
        }
        this.setNumberOfSelectedPois(this.selectedPois.size());
    }

    private synchronized void unregisterCategory(int n) {
        this.logChannel.log(-2137614336, "PoiWarningManager#unregisterCategory for item with ID: %1", (long)n);
        this.poiWarningModelAccess.setCheckAllPoisSelected(false);
        this.checkAll = false;
        if (this.selectedPois.size() == 1) {
            this.selectedPois.remove(0);
            this.selectedPois.add(new PoiWarningManager$PoiElement(this, -1, false));
            this.unRegisterAllSelectedCategories();
            this.setNumberOfSelectedPois(0);
        } else {
            ListIterator listIterator = this.selectedPois.listIterator();
            while (listIterator.hasNext()) {
                PoiWarningManager$PoiElement poiWarningManager$PoiElement = (PoiWarningManager$PoiElement)listIterator.next();
                if (poiWarningManager$PoiElement.id() != n) continue;
                listIterator.remove();
                break;
            }
            this.setNumberOfSelectedPois(this.selectedPois.size());
        }
        this.logChannel.log(14808325, "   --> selected Items: %1", (long)this.selectedPois.size());
    }

    private synchronized void registerAllSelectedCategories(LinkedList linkedList) {
        this.logChannel.log(-2137614336, "PoiWarningManager#registerAllSelectedCategories");
        if (this.poiWarningFeatureActive && linkedList != null && linkedList.size() > 0 && ((PoiWarningManager$PoiElement)linkedList.getFirst()).id() != -1 && this.selectedSettings[0] == 1) {
            Object object;
            boolean[] blArray = new boolean[linkedList.size()];
            int[] nArray = new int[linkedList.size()];
            ListIterator listIterator = linkedList.listIterator();
            int n = 0;
            while (listIterator.hasNext()) {
                object = (PoiWarningManager$PoiElement)listIterator.next();
                blArray[n] = true;
                nArray[n] = ((PoiWarningManager$PoiElement)object).id();
                ++n;
            }
            object = this.commandListFactory.createCommandList();
            ((CommandList)object).add(new EhSetCategoryMonitoringCommand(new int[]{-1}, new boolean[]{false}, this.logChannel));
            ((CommandList)object).add(new EhSetCategoryMonitoringCommand(nArray, blArray, this.logChannel));
            ((CommandList)object).execute("PoiWarningManager#registerCategories");
        }
    }

    private void unRegisterAllSelectedCategories() {
        this.setNumberOfSelectedPois(0);
        if (this.poiWarningFeatureActive) {
            this.logChannel.log(-2137614336, "PoiWarningManager#unRegisterAllSelectedCategories");
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new EhSetCategoryMonitoringCommand(new int[]{-1}, new boolean[]{false}, this.logChannel));
            commandList.execute("PoiWarningManager#deRegisterAllCategories");
        }
    }

    public void toggleApproachHint() {
        this.logChannel.log(-2137614336, "PoiWarningManager#toggleApproachHint");
        this.poiWarningModelAccess.toggleApproachHint();
        if (this.selectedSettings[0] == 1) {
            this.selectedSettings[0] = 0;
            this.unRegisterAllSelectedCategories();
            this.logChannel.log(-2137614336, "   --> toggleApproachHint to FALSE");
        } else {
            this.selectedSettings[0] = 1;
            this.registerAllSelectedCategories(this.selectedPois);
            this.logChannel.log(-2137614336, "   --> toggleApproachHint to TRUE");
        }
        this.serializeSettings();
    }

    public void toggleSpeachHint() {
        this.logChannel.log(-2137614336, "PoiWarningManager#toggleSpeachHint");
        this.poiWarningModelAccess.toggleSpeachHint();
        if (this.selectedSettings[1] == 1) {
            this.selectedSettings[1] = 0;
            this.logChannel.log(-2137614336, "   --> toggleSpeachHint to FALSE");
        } else {
            this.selectedSettings[1] = 1;
            this.logChannel.log(-2137614336, "   --> toggleSpeachHint to TRUE");
        }
        this.serializeSettings();
    }

    private synchronized void deserializeAll() {
        this.logChannel.log(-2137614336, "PoiWarningManager#deserialize");
        this.selectedSettings = this.poiWarningSettings.loadItems();
        int[] nArray = this.poiWarningPersistenceHelper.loadItems();
        this.selectedPois.clear();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.selectedPois.add(new PoiWarningManager$PoiElement(this, nArray[i2], false));
        }
        if (this.selectedSettings.length == 1) {
            this.selectedSettings = new int[2];
            this.selectedSettings[0] = 0;
            this.selectedSettings[1] = 0;
        }
        this.poiWarningModelAccess.setSettings(this.selectedSettings[0], this.selectedSettings[1]);
    }

    private synchronized void serializePois() {
        this.logChannel.log(-2137614336, "PoiWarningManager#serializePois");
        if (this.selectedPois != null && this.selectedPois.size() > 0 && ((PoiWarningManager$PoiElement)this.selectedPois.getFirst()).id() != -1) {
            this.DebugPoisToBeRemoved(this.selectedPois);
            this.StoreSelectedPois(this.selectedPois);
        } else {
            this.poiWarningPersistenceHelper.saveItems(noSelectedPois);
        }
    }

    private void StoreSelectedPois(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            PoiWarningManager$PoiElement poiWarningManager$PoiElement = (PoiWarningManager$PoiElement)listIterator.next();
            if (poiWarningManager$PoiElement.isValid()) {
                linkedList2.add(new Integer(poiWarningManager$PoiElement.id()));
                this.logChannel.log(-2137614336, "   --> POI with ID %1 added", (long)poiWarningManager$PoiElement.id());
                continue;
            }
            this.logChannel.log(-2137614336, "   --> POI with ID %1 deleted", (long)poiWarningManager$PoiElement.id());
        }
        this.poiWarningPersistenceHelper.saveItems(linkedList2);
    }

    private void DebugPoisToBeRemoved(LinkedList linkedList) {
        ListIterator listIterator = linkedList.listIterator();
        int n = 0;
        while (listIterator.hasNext()) {
            PoiWarningManager$PoiElement poiWarningManager$PoiElement = (PoiWarningManager$PoiElement)listIterator.next();
            if (poiWarningManager$PoiElement.isValid()) continue;
            this.logChannel.log(-2137614336, "   --> POI ID %1 is no longer valid. Revalidation needed!", (long)poiWarningManager$PoiElement.id());
            ++n;
        }
        this.logChannel.log(-2137614336, "   --> POIs to delete: %1", (long)n);
        this.logChannel.log(-2137614336, "   --> Resizing from %1 elements to %2 elements", (long)linkedList.size(), (long)(linkedList.size() - n));
    }

    private void serializeSettings() {
        this.logChannel.log(-2137614336, "PoiWarningManager#serializeSettings");
        this.poiWarningSettings.saveItems(this.selectedSettings);
    }

    public synchronized void poiEntersProximityRange(NavLocation[] navLocationArray) {
        this.logChannel.log(-2137614336, "PoiWarningManager#poiEntersProximityRange");
        if (null != navLocationArray && this.poiWarningFeatureActive) {
            this.logChannel.log(-2137614336, "   --> Navlocation[] of Size: %1", (long)navLocationArray.length);
            this.logChannel.log(-2137614336, "PoiWarningManager#poiEntersProximityRange Setting:%1", (long)this.selectedSettings[0]);
            if (this.selectedSettings[0] == 1) {
                if (this.updateAirdistanceTimer.isRunning()) {
                    this.updateAirdistanceTimer.cancel();
                }
                this.updateAirdistanceTimer.restart();
                this.savedPoiLocation = navLocationArray[navLocationArray.length - 1];
                this.calculateWarningPopUpValues(this.savedPoiLocation);
                this.setPoiPin(this.savedPoiLocation);
                this.poiWarningModelAccess.showPoiApproachPopUp();
            }
            if (this.selectedSettings[0] == 1 && this.selectedSettings[1] == 1) {
                this.logChannel.log(-2137614336, "   --> Requesting AudioFeedback");
                this.naviAudioHandler.requestBeepTone(235, 21);
            }
        } else if (this.poiWarningFeatureActive) {
            this.logChannel.log(-2137614336, "   --> poiEntersProximityRange is NULL!");
        }
    }

    public NavLocation getCurrentPoiProximityWarningLocation() {
        return this.currentLocationPoiProximityWarning;
    }

    public void hideCurrentPoiWarningAfterSelection() {
        this.hideWarning();
    }

    private synchronized void calculateWarningPopUpValues(NavLocation navLocation) {
        float f2 = 0.0f;
        int n = 0;
        int n2 = -1;
        Buffer buffer = new Buffer();
        buffer.clear();
        if (LocationFormatter.formatPOICategory(this.savedPoiLocation).length() != 0) {
            buffer.append(LocationFormatter.formatPOICategory(this.savedPoiLocation));
        } else if (LocationFormatter.formatPOIName(this.savedPoiLocation).length() != 0) {
            buffer.append(LocationFormatter.formatPOIName(this.savedPoiLocation));
        } else {
            buffer.append(this.poiWarningModelAccess.getPoiFallbackText());
        }
        f2 = Util.computeAirDistance(this.vehicle.getVehicleLocation().getLongitude(), this.vehicle.getVehicleLocation().getLatitude(), navLocation.getLongitude(), navLocation.getLatitude());
        n = this.computeRelativeDirection(this.vehicle, navLocation.getLongitude(), navLocation.getLatitude());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        int n3 = iMyLocationAccessor.getType();
        if (n3 == 1) {
            this.logChannel.log(-2137614336, "PoiWarningManager#calculateWarningPopUpValues navLocation=%1", (Object)navLocation);
        } else {
            this.logChannel.log(10000, "PoiWarningManager#calculateWarningPopUpValues probably invalid location type=%1 navLocation=%2", (Object)new Integer(n3), (Object)navLocation);
        }
        n2 = this.iconHandler.resolvePOIIconResourceID(iMyLocationAccessor.getIconIndex(), iMyLocationAccessor.getSubIconIndex());
        this.poiWarningModelAccess.setPoiApproachValues(buffer.toString(), f2, n, n2);
    }

    public synchronized void resetSettings() {
        this.logChannel.log(-2137614336, "PoiWarningManager#resetSettings");
        this.selectedSettings[0] = 0;
        this.selectedSettings[1] = 0;
        this.poiWarningModelAccess.setSettings(0, 0);
        this.selectedPois.clear();
        this.selectedPois.addFirst(new PoiWarningManager$PoiElement(this, -1, false));
        this.unRegisterAllSelectedCategories();
        this.serializeSettings();
        this.serializePois();
    }

    private int computeRelativeDirection(IVehicle iVehicle, int n, int n2) {
        int n3 = Util.computeAbsoluteDirection(iVehicle.getPosition(), n, n2);
        int n4 = Util.convertRotatingDirection(n3, iVehicle.getPosition().directionAngle);
        return n4;
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        this.logChannel.log(-2137614336, "PoiWarningManager#fireTimer");
        if (timer == this.updateAirdistanceTimer) {
            this.logChannel.log(-2137614336, "   --> updateAirdistanceTimer");
            if (this.actualRepetition < 5) {
                ++this.actualRepetition;
                if (null != this.savedPoiLocation) {
                    this.calculateWarningPopUpValues(this.savedPoiLocation);
                }
            } else {
                this.hideWarning();
            }
        }
    }

    protected void hideWarning() {
        this.updateAirdistanceTimer.cancel();
        this.poiWarningModelAccess.hideWarningPopUp();
        this.removePoiPin();
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logChannel.log(-2137614336, "PoiWarningManager#cancelTimer");
        this.actualRepetition = 0;
        this.updateAirdistanceTimer.cancel();
    }

    public synchronized void cleanup() {
        this.updateAirdistanceTimer.cancel();
    }

    @Override
    public void processCategories(int n, Category[] categoryArray) {
        this.poiCategoriesUpdate(n, categoryArray);
    }

    public void toggleSelectAll() {
        this.logChannel.log(-2137614336, "PoiWarningManager#toggleSelectAll");
        if (this.checkAll) {
            this.checkAll = false;
            this.poiWarningModelAccess.setCheckAllPoisSelected(false);
        } else {
            this.checkAll = true;
            this.poiWarningModelAccess.setCheckAllPoisSelected(true);
        }
        int[] nArray = this.poiWarningModelAccess.selectAllPois(this.checkAll);
        if (this.checkAll) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] < 0) continue;
                this.registerCategory(nArray[i2]);
            }
            this.registerAllSelectedCategories(this.selectedPois);
            this.serializePois();
        } else {
            this.selectedPois.clear();
            this.selectedPois.add(new PoiWarningManager$PoiElement(this, -1, false));
            this.unRegisterAllSelectedCategories();
        }
    }

    public void toggleAll(int n, int n2) {
        this.logChannel.log(-2137614336, "PoiWarningManager#toggleAll - POI Type: %1, Value: %2", (long)n, (long)n2);
        boolean bl = false;
        int[] nArray = this.poiWarningModelAccess.toggleAll(n, n2);
        this.selectedPois.clear();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] < 0) continue;
            this.registerCategory(nArray[i2]);
            bl = true;
        }
        if (bl) {
            this.registerAllSelectedCategories(this.selectedPois);
            this.serializePois();
        } else {
            this.selectedPois.add(new PoiWarningManager$PoiElement(this, -1, false));
            this.unRegisterAllSelectedCategories();
        }
    }

    protected void setPoiPin(NavLocation navLocation) {
        this.currentLocationPoiProximityWarning = navLocation;
    }

    protected void removePoiPin() {
        this.currentLocationPoiProximityWarning = null;
    }

    protected void setNumberOfSelectedPois(int n) {
        this.poiWarningModelAccess.setNumberOfSelectedPois(n);
    }

    static {
        noSelectedPois = new int[]{-1};
    }
}

