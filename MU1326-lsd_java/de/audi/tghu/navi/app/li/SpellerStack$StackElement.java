/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.tghu.navi.app.addressinput.IRestorable;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class SpellerStack$StackElement {
    public LISpellerData spellerData;
    public LIValueListElement element;
    public int categoryUid;
    public IAdditionalStateInfo[] infos;
    public SpellerContext sc;
    public IRestorable restorable;

    public SpellerStack$StackElement(LISpellerData lISpellerData) {
        this(lISpellerData, null, -1, null, null, null);
    }

    public SpellerStack$StackElement(LISpellerData lISpellerData, LIValueListElement lIValueListElement, int n, IAdditionalStateInfo[] iAdditionalStateInfoArray, SpellerContext spellerContext) {
        this(lISpellerData, lIValueListElement, n, iAdditionalStateInfoArray, spellerContext, null);
    }

    public SpellerStack$StackElement(LISpellerData lISpellerData, LIValueListElement lIValueListElement, int n, IAdditionalStateInfo[] iAdditionalStateInfoArray, SpellerContext spellerContext, IRestorable iRestorable) {
        this.spellerData = lISpellerData;
        this.element = lIValueListElement;
        this.categoryUid = n;
        this.infos = iAdditionalStateInfoArray;
        this.sc = spellerContext;
        this.restorable = iRestorable;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[spellerData.length=");
        buffer.append(this.spellerData != null && this.spellerData.getSpellerStateData() != null ? this.spellerData.getSpellerStateData().length : 0);
        buffer.append(", ");
        buffer.append(this.element != null ? this.element.getData() : "<null>");
        buffer.append(", ");
        buffer.append(this.categoryUid);
        buffer.append(", ");
        buffer.append(this.sc);
        buffer.append(", ");
        buffer.append(this.restorable != null ? this.restorable.toString() : "<null>");
        if (this.infos != null) {
            for (int i2 = 0; i2 < this.infos.length; ++i2) {
                buffer.append(", ");
                buffer.append(this.infos[i2] != null ? this.infos[i2].toString() : "<null>");
            }
        }
        buffer.append(']');
        return buffer.toString();
    }
}

