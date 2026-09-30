/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.nar.listeners.AbstractAddressInputListenerNAR;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AbstractAddressInputNoSpellerSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetRefinementScreenListenerNAR
extends AbstractAddressInputListenerNAR
implements TiledListModelListener {
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiNarStreetRefinementScreenTiledListModel();
    private final AbstractAddressInputNoSpellerSequence inputSequence;

    public AddressInputStreetRefinementScreenListenerNAR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AbstractAddressInputNoSpellerSequence abstractAddressInputNoSpellerSequence) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = abstractAddressInputNoSpellerSequence;
        this.initListeners();
    }

    protected void initListeners() {
        this.env.getTiledListModel(TILED_LIST_MODEL_ID).setListener(this);
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.getStartCommandList();
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 30702);
            this.env.fireModelEvent(n, n4);
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        }
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#unrequestItems - was called with startIndex = %2, model = %3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (long)n3);
        }
        this.inputSequence.unrequestItems(n, n2);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused() - focus index = %2", (Object)this.CLASS_NAME, (long)n2);
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.inputSequence.checkIfElementIsAmbiguous(lIValueListElement, new StreetInputRefinementGetNavLocationCallbackCommand(evoListRow, this));
    }

    private void locationCallback(NavLocation navLocation, EvoListRow evoListRow) {
        if (this.isLocationValid(navLocation)) {
            this.removeFocusedItemIsInvalidProperty(evoListRow);
            this.previewMap.setPreviewLocation(navLocation, 1, null, null);
        } else {
            this.previewMap.hidePreviewMap();
        }
    }

    private boolean isLocationValid(NavLocation navLocation) {
        if (navLocation == null) {
            return false;
        }
        return navLocation.latitude != 0 && navLocation.longitude != 0;
    }

    private class StreetInputRefinementGetNavLocationCallbackCommand
    extends NavCommand {
        private final EvoListRow row;
        private final AddressInputStreetRefinementScreenListenerNAR listener;

        private StreetInputRefinementGetNavLocationCallbackCommand(EvoListRow evoListRow, AddressInputStreetRefinementScreenListenerNAR addressInputStreetRefinementScreenListenerNAR2) {
            this.row = evoListRow;
            this.listener = addressInputStreetRefinementScreenListenerNAR2;
        }

        public void execute() {
            NavLocation navLocation = (NavLocation)this.getCommandList().get("LocationToTest");
            this.listener.locationCallback(navLocation, this.row);
            this.getCommandList().commandFinished();
        }
    }
}

