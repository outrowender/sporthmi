/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.evo.AbstractEvoPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.interapp.phone.ITelServiceADB;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import java.util.Hashtable;

public class TelServiceADBImpl
extends AbstractEvoPhoneComponent
implements ITelServiceADB {
    private volatile PhoneServiceProvider telServiceADB;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceADB;

    public TelServiceADBImpl(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication, "App.Phone.Main");
    }

    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.telServiceADB = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceADB == null ? (class$de$audi$atip$interapp$phone$ITelServiceADB = TelServiceADBImpl.class$("de.audi.atip.interapp.phone.ITelServiceADB")) : class$de$audi$atip$interapp$phone$ITelServiceADB).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.telServiceADB.startService();
    }

    public void deinit() {
        if (this.telServiceADB != null) {
            this.telServiceADB.stopService();
        }
    }

    public void addToFavorites(TelFavoriteStruct telFavoriteStruct) {
        this.log.log(1000000, "[TelServiceADBImpl#addToFavorites] favorite=%1", (Object)telFavoriteStruct);
        this.getEvoApplication().getFavoriteHandler().addToFavorites(telFavoriteStruct);
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

