/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.search.organizer.AlphabeticalFastscrollRow;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.IndexInformation;

public class ADBModelUtils {
    public static int getEntryTypeModelValue(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 4: {
                return 3;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 4;
            }
        }
        return 0;
    }

    private static int getIconMobile(int n) {
        int n2;
        int n3 = n & 6;
        switch (n3) {
            case 4: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        return n2;
    }

    private static int getIconISDN(int n) {
        int n2;
        int n3 = n & 6;
        switch (n3) {
            case 4: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static int getIconFax(int n) {
        int n2;
        int n3 = n & 6;
        switch (n3) {
            case 4: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 8;
                break;
            }
            default: {
                n2 = 6;
            }
        }
        return n2;
    }

    private static int getIconOther(int n) {
        int n2;
        int n3 = n & 6;
        switch (n3) {
            case 4: {
                n2 = 10;
                break;
            }
            case 2: {
                n2 = 11;
                break;
            }
            default: {
                n2 = 9;
            }
        }
        return n2;
    }

    public static int getIconTypeForPhoneNumber(int n) {
        int n2;
        int n3 = n & 0x1FF8;
        switch (n3) {
            case 64: 
            case 72: 
            case 1088: 
            case 1096: {
                n2 = ADBModelUtils.getIconMobile(n);
                break;
            }
            case 8: 
            case 1032: 
            case 2048: 
            case 2056: {
                n2 = ADBModelUtils.getIconISDN(n);
                break;
            }
            case 16: 
            case 24: 
            case 80: 
            case 1040: 
            case 1048: 
            case 1104: 
            case 2064: 
            case 2072: {
                n2 = ADBModelUtils.getIconFax(n);
                break;
            }
            default: {
                n2 = ADBModelUtils.getIconOther(n);
            }
        }
        return n2;
    }

    public static int getModelPhoneNumberCategory(int n) {
        int n2 = n & 0x1FF8;
        switch (n2) {
            case 64: 
            case 72: 
            case 1088: 
            case 1096: {
                return 1;
            }
            case 8: 
            case 1032: 
            case 2048: 
            case 2056: {
                return 0;
            }
            case 16: 
            case 24: 
            case 80: 
            case 1040: 
            case 1048: 
            case 1104: 
            case 2064: 
            case 2072: {
                return 2;
            }
        }
        return 3;
    }

    public static int getModelPhoneNumberType(int n) {
        int n2 = n & 6;
        switch (n2) {
            case 2: {
                return 0;
            }
            case 4: {
                return 1;
            }
        }
        return 2;
    }

    public static int setPhoneTypeFromModelType(int n, int n2, LogChannel logChannel) {
        int n3 = n & 0x1FF8;
        switch (n2) {
            case 0: {
                n3 |= 2;
                break;
            }
            case 1: {
                n3 |= 4;
                break;
            }
            case 2: {
                n3 |= 0;
                break;
            }
            default: {
                logChannel.log(-2137614336, "ADBModelUtils#setPhoneTypeFromModelType(): unknown type: %1", (long)n2);
            }
        }
        return n3;
    }

    public static int setPhoneTypeFromModelCategory(int n, int n2, LogChannel logChannel) {
        int n3 = n & 6;
        switch (n2) {
            case 0: {
                n3 |= 8;
                break;
            }
            case 1: {
                n3 |= 0x40;
                break;
            }
            case 2: {
                n3 |= 0x10;
                break;
            }
            case 3: {
                n3 |= 0;
                break;
            }
            default: {
                logChannel.log(-2137614336, "ADBModelUtils#setPhoneTypeFromModelCategory(): unknown category: %1", (long)n2);
            }
        }
        return n3;
    }

    public static int getDSISortOrderValue(int n) {
        switch (n) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
        }
        return 3;
    }

    public static int getHMISortOrderValue(int n) {
        switch (n) {
            case 2: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }

    public static int getPercentageValueForProgressBars(float f2) {
        if (f2 > 0.0f && f2 <= 16448) {
            return 3;
        }
        if (f2 >= 49730 && f2 < 51266) {
            return 97;
        }
        if (f2 >= 51266) {
            return 100;
        }
        return Math.round(f2);
    }

    public static void updatePicture(ResourceLocator resourceLocator, ResourceLocatorModelApp resourceLocatorModelApp, LogChannel logChannel) {
        boolean bl = ADBUtils.isPictureAvailable(resourceLocator);
        int n = bl ? resourceLocator.getId() : -1;
        String string = bl ? resourceLocator.getUrl() : ResourceLocatorModelApp.UNDEFINED_URI;
        logChannel.log(-2137614336, "ADBModelUtils#updatePicture(): picture %1 available, picId: %3, picUrl: %2", (Object)(bl ? "is" : "is not"), (Object)string, (long)n);
        resourceLocatorModelApp.setResourceLocator(n, string);
        resourceLocatorModelApp.setStatus(bl ? 1 : 0);
    }

    public static void clearPicture(ResourceLocatorModelApp resourceLocatorModelApp) {
        resourceLocatorModelApp.setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        resourceLocatorModelApp.setStatus(0);
    }

    public static String concatenate(String string, String string2, String string3) {
        return new StringBuffer().append(!ADBUtils.isEmpty(string) ? string : "").append(!ADBUtils.isEmpty(string) && !ADBUtils.isEmpty(string2) ? string3 : "").append(!ADBUtils.isEmpty(string2) ? string2 : "").toString();
    }

    public static String getCombinedName(String string, String string2, int n) {
        switch (n) {
            case 1: {
                return ADBModelUtils.concatenate(string2, string, " ");
            }
            case 2: {
                return ADBModelUtils.concatenate(string, string2, " ");
            }
        }
        return ADBModelUtils.concatenate(string, string2, ", ");
    }

    public static void fillIndices(IndexInformation[] indexInformationArray, BaseListModelApp baseListModelApp, int n) {
        boolean bl = false;
        if (indexInformationArray != null) {
            for (int i2 = 0; i2 < indexInformationArray.length; ++i2) {
                if (indexInformationArray[i2].getViewtype() != n) continue;
                ADBModelUtils.fillIndicesList(indexInformationArray[i2].getCharacterInfo(), baseListModelApp);
                bl = true;
            }
        }
        if (!bl) {
            baseListModelApp.removeAll();
        }
    }

    private static void fillIndicesList(CharacterInfo[] characterInfoArray, BaseListModelApp baseListModelApp) {
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(baseListModelApp);
        baseListModelApp.removeAll();
        if (characterInfoArray != null) {
            for (int i2 = 0; i2 < characterInfoArray.length; ++i2) {
                baseListModelApp.append(AlphabeticalFastscrollRow.createFastscrollRow(i2, characterInfoArray[i2]));
            }
        }
        modelGroup.flush();
        modelGroup.removeAll();
    }
}

