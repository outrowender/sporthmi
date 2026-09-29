/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online.myaudi;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.destinationimport.AbstractNaviMyAudiImportListener;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import de.audi.tghu.navi.app.util.Util;

public class DestinationImportListenerEvo
extends AbstractNaviMyAudiImportListener {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$app$navi$evo$online$myaudi$DestinationImportListenerEvo == null ? (class$de$audi$app$navi$evo$online$myaudi$DestinationImportListenerEvo = DestinationImportListenerEvo.class$("de.audi.app.navi.evo.online.myaudi.DestinationImportListenerEvo")) : class$de$audi$app$navi$evo$online$myaudi$DestinationImportListenerEvo);
    static /* synthetic */ Class class$de$audi$app$navi$evo$online$myaudi$DestinationImportListenerEvo;

    public DestinationImportListenerEvo(NavigationEnv navigationEnv, NaviMyAudiImportImpl naviMyAudiImportImpl) {
        super(navigationEnv, naviMyAudiImportImpl);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected - row=%2", (Object)CLASS_NAME, (Object)evoListRow);
        this.myAudiImporter.portalEntrySelected(evoListRow.getUniqueID());
        this.contactsList.setSelectedIndex(n2);
        this.env.fireModelEvent(n, n4);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

