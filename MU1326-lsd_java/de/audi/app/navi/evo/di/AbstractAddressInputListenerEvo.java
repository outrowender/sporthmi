/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.AbstractAddressInputListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;

public abstract class AbstractAddressInputListenerEvo
extends AbstractAddressInputListener {
    public AbstractAddressInputListenerEvo(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
    }

    @Override
    protected abstract void initListeners() {
    }

    protected void removeFocusedItemIsInvalidProperty(EvoListRow evoListRow) {
        PropertyListCell propertyListCell = (PropertyListCell)evoListRow.getCell(4);
        int[] nArray = propertyListCell.getProperties();
        boolean bl = false;
        int[] nArray2 = new int[nArray.length];
        int n = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 511357349) {
                bl = true;
                nArray2[n] = 1738979261;
                ++n;
                continue;
            }
            nArray2[n] = nArray[i2];
            ++n;
        }
        if (!bl) {
            return;
        }
        evoListRow.setPropertyCell(4, new PropertyListCell(propertyListCell.getCategory(), nArray2));
    }
}

