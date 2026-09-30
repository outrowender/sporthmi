/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.AbstractInputSequenceMatchspellerListener;

public abstract class AbstractEvoInputSequenceMatchspellerListener
extends AbstractInputSequenceMatchspellerListener {
    public AbstractEvoInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int[] nArray, int[] nArray2, IPreviewMap iPreviewMap) {
        super(navigationEnv, nArray, nArray2, iPreviewMap);
    }

    public AbstractEvoInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int[] nArray, int[] nArray2, int n, IPreviewMap iPreviewMap) {
        super(navigationEnv, nArray, nArray2, n, iPreviewMap);
    }

    public AbstractEvoInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int n, int n2, IPreviewMap iPreviewMap) {
        super(navigationEnv, n, n2, iPreviewMap);
    }

    public AbstractEvoInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
        super(navigationEnv, n, n2, n3, iPreviewMap);
    }

    public AbstractEvoInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int n, int n2) {
        super(navigationEnv, n, n2);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#itemSelected - item selected was called with model = %1, index = %2", (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#itemSelected row is instanceOf AILIVLELR");
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.getInputSequence().selectListElement(addressInputLIValueListElementListRow.getElement(), true);
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#itemFocused - item focused was called with model = %1, index = %2", (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.getInputSequence().showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#keyTyped - keyTyped was called with model = %1, index = %2", (long)n, (long)n2);
        long l = this.env.getContainer().getLispValueListCount();
        this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#keyTyped - valueListCount = %1 ", l);
        if (l == 1L && null != this.menuModel) {
            if (this.tiledListModel == null) {
                this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#keyTyped - tiledListModel is null");
                return;
            }
            if (this.tiledListModel.getRow(0) == null) {
                this.logChannel.log(10000000, "AbstractEvoInputSequenceMatchspellerListener#keyTyped - tiledListModel.getRow(0) is null");
                return;
            }
            EvoListRow evoListRow = this.tiledListModel.getRow(0);
            this.menuModel.setFocusedItem(this.tiledListModel.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, evoListRow.getUniqueID());
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.getInputSequence().selectListElement(addressInputLIValueListElementListRow.getElement(), false);
            this.env.fireModelEvent(this.tiledListModel.getID(), n3);
        }
    }
}

