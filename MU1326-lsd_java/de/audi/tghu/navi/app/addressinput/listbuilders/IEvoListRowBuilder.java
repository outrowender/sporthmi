/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.listbuilders;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IEvoListRowBuilder {
    default public EvoListRow buildListRow(LIValueListElement lIValueListElement, int n) {
    }
}

