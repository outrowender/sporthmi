/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.HMIPopUpsAddressBook;
import de.audi.atip.hmi.HMIPopUpsCar;
import de.audi.atip.hmi.HMIPopUpsConnectivity;
import de.audi.atip.hmi.HMIPopUpsEarlyApps;
import de.audi.atip.hmi.HMIPopUpsEcall;
import de.audi.atip.hmi.HMIPopUpsInfo;
import de.audi.atip.hmi.HMIPopUpsMedia;
import de.audi.atip.hmi.HMIPopUpsMessaging;
import de.audi.atip.hmi.HMIPopUpsNavi;
import de.audi.atip.hmi.HMIPopUpsOnline;
import de.audi.atip.hmi.HMIPopUpsPhone;
import de.audi.atip.hmi.HMIPopUpsSWDL;
import de.audi.atip.hmi.HMIPopUpsSystem;
import de.audi.atip.hmi.HMIPopUpsTV;
import de.audi.atip.hmi.HMIPopUpsTuner;
import de.audi.atip.hmi.HMIPopUpsWirelessCharging;

public interface HMIPopUps
extends HMIPopUpsSystem,
HMIPopUpsTuner,
HMIPopUpsMedia,
HMIPopUpsPhone,
HMIPopUpsNavi,
HMIPopUpsInfo,
HMIPopUpsCar,
HMIPopUpsAddressBook,
HMIPopUpsSWDL,
HMIPopUpsEarlyApps,
HMIPopUpsMessaging,
HMIPopUpsOnline,
HMIPopUpsConnectivity,
HMIPopUpsTV,
HMIPopUpsEcall,
HMIPopUpsWirelessCharging {
}

