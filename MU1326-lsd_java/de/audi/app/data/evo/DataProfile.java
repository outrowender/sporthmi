/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.evo;

import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.profile.APNSpellersHandler;
import de.audi.app.data.core.profile.AbstractDataProfile;

public class DataProfile
extends AbstractDataProfile {
    public DataProfile(IDataApplication iDataApplication) {
        super(iDataApplication);
        this.apn1SpellersHandler = new APNSpellersHandler(this.log, this.apnSpeller, this.apnSpeller2, this.usernameSpeller, this.usernameSpeller2, this.passwordSpeller, this.passwordSpeller2);
        this.apn2SpellersHandler = new APNSpellersHandler(this.log, this.apn2Speller, this.apn2Speller2, this.apn2UsernameSpeller, this.apn2UsernameSpeller2, this.apn2PasswordSpeller, this.apn2PasswordSpeller2);
    }
}

