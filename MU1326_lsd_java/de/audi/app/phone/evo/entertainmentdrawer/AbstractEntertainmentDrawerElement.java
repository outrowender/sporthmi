/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ModelGroup;

public abstract class AbstractEntertainmentDrawerElement
extends AbstractPhoneComponent {
    public AbstractEntertainmentDrawerElement(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
    }

    public abstract ModelGroup updateInternalModelValues(ModelGroup var1, IGlobalTelephoneStateStruct var2);
}

