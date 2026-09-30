/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ILocationDisambiguatorSequence {
    public void startDisambiguationForNavLocation(NavLocation var1, ILocationDisambiguationCallback var2, int var3, int var4, int var5);

    public void startDisambiguationForLiValueListElement(LIValueListElement var1, ILocationDisambiguationCallback var2, int var3, int var4, int var5);

    public void startDisambiguationForMapCode(ILocationDisambiguationCallback var1, int var2, int var3, int var4);

    public void startDisambiguationForMapCodeBySds(ILocationDisambiguationCallback var1, int var2, NotifyNaviServiceListenerCommand var3);

    public void startRouteGuidance(NavLocation var1);

    public void setLocationAsCurrentLdForSds(int var1, NotifyNaviServiceListenerCommand var2, NotifyNaviServiceListenerCommand var3);

    public void setAsHomeAddress(NavLocation var1);

    public void setAsContact(NavLocation var1);

    public void setAsContactFromAdb(NavLocation var1);

    public void setForPoiAtThisLocation(NavLocation var1);

    public boolean setAsFavorite(NavLocation var1);

    public void setPoiService(IPoiService var1);
}

