/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rml.AbstractRMLListRow;
import de.audi.tghu.navi.app.rml.IRMLListener;
import de.audi.tghu.navi.app.rml.RMLDSIHandler;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.navigation.CombinedRouteListElement;

public class RMLListener
implements TiledListModelListener,
ButtonListener,
MenuModelListener,
IRMLListener {
    private static final long[] NO_ANCHOR = new long[]{-1L};
    private final RMLSequence rmlSequence;
    private final NavigationEnv env;
    private final int buttonModelId;
    private final int menuModelId;
    private final LogChannel logChannel;
    private final IPreviewMap previewMap;
    private volatile CombinedRouteListElement openedElement;
    private RMLDSIHandler rmlDsiHandler;

    public RMLListener(NavigationEnv navigationEnv, int n, int n2, int n3, RMLSequence rMLSequence, RMLDSIHandler rMLDSIHandler, IPreviewMap iPreviewMap) {
        this.rmlDsiHandler = rMLDSIHandler;
        this.buttonModelId = n2;
        this.menuModelId = n3;
        this.rmlSequence = rMLSequence;
        this.previewMap = iPreviewMap;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getRMLLogChannel();
        navigationEnv.getTiledListModel(n).setListener(this);
        navigationEnv.getButtonModel(n2).setButtonListener(this);
        navigationEnv.getMenuModel(n3).setListener(this);
        rMLSequence.setRMLListener(this);
    }

    public void enterRMLScreen() {
        if (!this.rmlSequence.isRoutelistActive()) {
            this.logChannel.log(10000000, "RMLListener#enterRML - call start()");
            this.start();
        } else {
            this.logChannel.log(10000000, "RMLListener#enterRML - the Routelist Feature is active and takes a lot of time to load. Dont start it a second time (will just make the user wait...)");
        }
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "RMLListener#itemSelected - model = %1, index = %2", (long)n, (long)n2);
        if (evoListRow == null || !(evoListRow instanceof AbstractRMLListRow)) {
            return;
        }
        AbstractRMLListRow abstractRMLListRow = (AbstractRMLListRow)evoListRow;
        CombinedRouteListElement combinedRouteListElement = abstractRMLListRow.getCombinedRouteListElement();
        this.logChannel.log(10000000, "RMLListener#itemSelected - combinedRouteListElement of selected index = %1", (Object)combinedRouteListElement);
        long[] lArray = this.findPossibleAnchors(this.env.getTiledListModel(n).getCopy(), n2, 10, 0);
        if (lArray.length == 0) {
            this.logChannel.log(10000000, "RMLListener#itemSelected - No AnchorID has been found to use. use from selectedItem for fallback reasons = %1");
            lArray = new long[]{combinedRouteListElement.uid};
        }
        this.logChannel.log(10000000, "RMLListener#itemSelected - openedElement = %1", (Object)this.openedElement);
        if (this.openedElement == null || this.openedElement.getUid() != combinedRouteListElement.getUid()) {
            if (combinedRouteListElement.getParent() == -1L && combinedRouteListElement.isHasChildren() && !this.isType(combinedRouteListElement, 10)) {
                if (!this.rmlSequence.getRunningRequestMonitor().isActive()) {
                    this.logChannel.log(10000000, "RMLListener#itemSelected() - No Running CommandList in the RMLSequence Acknowledged --> request to open the element");
                    this.openedElement = combinedRouteListElement;
                    this.rmlSequence.selectNoDetails();
                    this.rmlSequence.requestCombinedRouteList(lArray, combinedRouteListElement.getUid(), -1, 0, false);
                    this.logChannel.log(10000000, "RMLListener#itemSelected - Open Child");
                } else {
                    this.logChannel.log(1000000, "RMLListener#itemSelected() - Detected a running CommandList in the RMLSequence DONT ask for elements");
                }
            } else {
                this.openDetailScreen(combinedRouteListElement);
                this.logChannel.log(10000000, "RMLListener#itemSelected - Open Detail");
            }
        } else {
            this.rmlSequence.selectNoDetails();
            this.openedElement = null;
            this.rmlSequence.requestCombinedRouteList(lArray, -1L, -1, 0, false);
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private boolean isType(CombinedRouteListElement combinedRouteListElement, int n) {
        for (int i2 = 0; i2 < combinedRouteListElement.getType().length; ++i2) {
            if (combinedRouteListElement.getType()[i2] != n) continue;
            return true;
        }
        return false;
    }

    private void openDetailScreen(CombinedRouteListElement combinedRouteListElement) {
        int[] nArray = combinedRouteListElement.getType();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 10) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_COUNTRYCHANGE");
                this.rmlSequence.selectForCountryInfo(combinedRouteListElement);
                break;
            }
            if (nArray[i2] == 4) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_POI");
                this.rmlSequence.selectForPOIDetails(combinedRouteListElement);
                break;
            }
            if (nArray[i2] == 7) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_FERRYSEGMENT");
                this.rmlSequence.selectNoDetails();
                break;
            }
            if (nArray[i2] == 16) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_TOLLSTATION");
                this.rmlSequence.selectForPOIDetails(combinedRouteListElement);
                break;
            }
            if (nArray[i2] == 5) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_STOPOVER");
                this.rmlSequence.selectForAddressDetails(combinedRouteListElement);
                break;
            }
            if (nArray[i2] == -2) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_LIST_END");
                this.rmlSequence.selectForAddressDetails(combinedRouteListElement);
                break;
            }
            if (nArray[i2] == 3) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_TRAFFIC_EVENT");
                if (Util.isHURegionAsia()) {
                    this.rmlSequence.selectNoDetails();
                    break;
                }
                this.rmlSequence.selectForTrafficDetails(combinedRouteListElement);
                break;
            }
            if (nArray[i2] == 0) {
                this.logChannel.log(10000000, "RMLListener#openDetailScreen - COMBINEDROUTELISTELEMENTTYPE_ROAD_SEGMENT");
                this.rmlSequence.selectNoDetails();
                break;
            }
            this.logChannel.log(10000000, "RMLListener#openDetailScreen - NO MATCH");
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "RMLListener#itemFocused() - model=%1, index=%2", (long)n, (long)n2);
        if (evoListRow instanceof AbstractRMLListRow) {
            AbstractRMLListRow abstractRMLListRow = (AbstractRMLListRow)evoListRow;
            CombinedRouteListElement combinedRouteListElement = abstractRMLListRow.getCombinedRouteListElement();
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "RMLListener#itemFocused - item on index %1 is focused and has description: %2", (Object)(n2 + ""), (Object)evoListRow.getText(4));
            }
            if (this.elementIsType(combinedRouteListElement, 4)) {
                this.rmlSequence.focusPOI(combinedRouteListElement);
            } else if (this.elementIsType(combinedRouteListElement, 3)) {
                this.rmlSequence.focusTMC(combinedRouteListElement);
            } else {
                this.rmlSequence.itemFocused(combinedRouteListElement);
            }
        } else {
            this.logChannel.log(100000, "RMLListener#itemFocused() - unexpected row received: the focused row is %1", (Object)(evoListRow == null ? "null" : "not an AbstractRMLListRow"));
        }
    }

    private boolean elementIsType(CombinedRouteListElement combinedRouteListElement, int n) {
        int[] nArray = combinedRouteListElement.getType();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        if (this.env.getTiledListModel(n4).getLength() == 0) {
            this.logChannel.log(10000000, "RMLListener#requestItems - resettet the openedAnchorId");
            this.openedElement = null;
        } else {
            this.logChannel.log(10000000, "RMLListener#requestItems - ModelLength is %1", (long)this.env.getTiledListModel(n4).getLength());
        }
        this.logChannel.log(10000000, "RMLListener#requestItems - requesting new items with: startIndex = %1, length = %2, requestId = %3, modelId = %4", (Object)(n + ""), (Object)(n2 + ""), (Object)(n3 + ""), (long)n4);
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(n4);
        int n6 = tiledListModelApp.getLength();
        int n7 = this.findOutScrollDirection(tiledListModelApp, n);
        long l = this.openedElement == null ? -1L : this.openedElement.getUid();
        if (n6 > 0) {
            long[] lArray = this.findPossibleAnchors(tiledListModelApp.getCopy(), n, n2, n7);
            this.rmlSequence.requestCombinedRouteList(lArray, l, n3, n, true);
        } else {
            long[] lArray = NO_ANCHOR;
            this.rmlSequence.requestCombinedRouteList(lArray, l, n3, n, true);
        }
        this.rmlSequence.selectNoDetails();
        this.env.fireModelEvent(n4, n5);
    }

    public void windowChanged(int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 2: {
                break;
            }
            case 1: {
                break;
            }
        }
    }

    private int findOutScrollDirection(TiledListModelApp tiledListModelApp, int n) {
        EvoListRow evoListRow;
        int n2;
        for (n2 = n; n2 > 0; --n2) {
            evoListRow = tiledListModelApp.getRow(n2);
            if (evoListRow == null) continue;
            this.logChannel.log(10000000, "RMLListener#requestItems - SCROLL_DIRECTION_DOWN");
            return 1;
        }
        for (n2 = n; n2 < tiledListModelApp.getLength(); ++n2) {
            evoListRow = tiledListModelApp.getRow(n2);
            if (evoListRow == null) continue;
            this.logChannel.log(10000000, "RMLListener#requestItems - SCROLL_DIRECTION_UP");
            return 0;
        }
        this.logChannel.log(10000000, "RMLListener#requestItems - SCROLL_DIRECTION_NO_DIRECTION");
        return 2;
    }

    private long[] findPossibleAnchors(BaseListModelApp baseListModelApp, int n, int n2, int n3) {
        int n4;
        ArrayList arrayList = new ArrayList();
        this.logChannel.log(10000000, "RMLListener#findPossibleAnchors startIndex = %1, scrollDirection = %2", (long)n, (long)n3);
        if (n3 == 1 || n3 == 2) {
            for (n4 = baseListModelApp.getLength() - 1; n4 >= 0; --n4) {
                EvoListRow evoListRow = baseListModelApp.getRow(n4);
                if (evoListRow == null || !(evoListRow instanceof AbstractRMLListRow)) continue;
                AbstractRMLListRow abstractRMLListRow = (AbstractRMLListRow)evoListRow;
                arrayList.add(new Long(abstractRMLListRow.getUniqueID()));
                if (arrayList.size() <= 1) {
                    continue;
                }
                break;
            }
        } else {
            for (n4 = n; n4 < baseListModelApp.getLength(); ++n4) {
                EvoListRow evoListRow = baseListModelApp.getRow(n4);
                if (evoListRow == null || !(evoListRow instanceof AbstractRMLListRow)) continue;
                AbstractRMLListRow abstractRMLListRow = (AbstractRMLListRow)evoListRow;
                if (abstractRMLListRow != null) {
                    arrayList.add(new Long(abstractRMLListRow.getUniqueID()));
                }
                if (arrayList.size() <= 1) {
                    continue;
                }
                break;
            }
        }
        long[] lArray = this.transformListToArray(arrayList);
        this.logChannel.log(10000000, "RMLListener#findPossibleAnchors used AnchorId's will be %1", (Object)lArray);
        return lArray;
    }

    private long[] transformListToArray(List list) {
        long[] lArray = new long[list.size()];
        for (int i2 = 0; i2 < list.size(); ++i2) {
            lArray[i2] = (Long)list.get(i2);
        }
        return lArray;
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
        if (n != this.buttonModelId) {
            this.logChannel.log(100000, "RMLListener#KeyPressed - unexpected Model-ID (%1)", (long)n);
            return;
        }
        this.rmlSequence.start();
        this.env.fireModelEvent(n, n3);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void stop() {
        this.logChannel.log(10000000, "RMLListener#stop()");
        this.openedElement = null;
        this.rmlDsiHandler.unregisterForUpdates();
        this.rmlSequence.stop();
    }

    public void start() {
        this.logChannel.log(10000000, "RMLListener#start()");
        this.openedElement = null;
        this.rmlDsiHandler.registerForUpdates(this.rmlSequence);
        this.rmlSequence.start();
    }

    public CombinedRouteListElement getOpenedElement() {
        return this.openedElement;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(1000000, "RMLListener#itemFocused(%1, %2, %3)", (long)n, (long)n2, l);
        if (n2 != this.menuModelId) {
            this.logChannel.log(100000, "RMLListener#itemFocused - unexpected Model-ID (%1)", (long)n2);
            return;
        }
        if (n == 29) {
            this.previewMap.setPreviewAreaAroundCCP(1);
        }
    }
}

