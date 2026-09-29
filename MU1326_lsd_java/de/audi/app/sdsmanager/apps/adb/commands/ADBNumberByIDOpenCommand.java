/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.adb.commands.IADBNumberCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.log.LogChannel;

public class ADBNumberByIDOpenCommand
extends AbstractSystemCallCommand
implements IADBNumberCommand {
    protected int privateCount = 0;
    protected int businessCount = 0;
    protected int mobileCount = 0;
    protected int generalCount = 0;
    private final int entryIDSource;
    private final ADBSDSService adbService;
    protected final AddressBookSDSHandler adbHandler;

    public ADBNumberByIDOpenCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AddressBookSDSHandler addressBookSDSHandler, ADBSDSService aDBSDSService) {
        super(logChannel, string, sDSHandlerService);
        this.adbHandler = addressBookSDSHandler;
        this.entryIDSource = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.adbService = aDBSDSService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: entryIDSource=%2!", (Object)this.getName(), (long)this.entryIDSource);
        long l = this.adbHandler.getADBID(this.entryIDSource);
        if (l == 0L) {
            this.logger.log(-1601830656, "%1#execute: No adbID found, returning ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.adbHandler.setCurrentEntryID(l);
        this.logger.log(-2137614336, "%1#execute: adbID=%2, phoneNumberTypes=%3!", (Object)this.getName(), l, (long)this.adbHandler.getPhoneNumberTypes());
        this.adbService.fillTelNumberList(l, this.adbHandler.getPhoneNumberTypes());
    }

    @Override
    public void responseFillTelNumberList(int n, String string, int n2, String string2, int[] nArray) {
        this.logger.log(-2137614336, "%1#responseFillTelNumberList: resultCode=%3, combinedName=%2!", (Object)this.getName(), (Object)string, (long)n);
        if (n != 0) {
            this.logger.log(-1601830656, "%1#responseFillTelNumberList: Unhandled resultCode %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
            return;
        }
        this.setChoiceModelValues(nArray);
        SDSModelAccess.setADBEntryNameModel(string);
        this.adbHandler.updateTelNumberInfo(nArray.length, n2, string2);
        this.sendResult(3000);
    }

    protected void setChoiceModelValues(int[] nArray) {
        this.countPhonenumberTypes(nArray);
        SDSModelAccess.setADBCategoryPhoneCountModel(this.privateCount, this.businessCount, this.mobileCount, this.generalCount);
    }

    protected void countPhonenumberTypes(int[] nArray) {
        block14: for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            switch (n) {
                case 0: {
                    ++this.generalCount;
                    continue block14;
                }
                case 1: {
                    ++this.generalCount;
                    ++this.privateCount;
                    continue block14;
                }
                case 2: {
                    ++this.generalCount;
                    ++this.businessCount;
                    continue block14;
                }
                case 3: {
                    ++this.mobileCount;
                    continue block14;
                }
                case 4: {
                    ++this.mobileCount;
                    ++this.privateCount;
                    continue block14;
                }
                case 5: {
                    ++this.mobileCount;
                    ++this.businessCount;
                    continue block14;
                }
                case 6: {
                    ++this.generalCount;
                    continue block14;
                }
                case 7: {
                    ++this.generalCount;
                    ++this.privateCount;
                    continue block14;
                }
                case 8: {
                    ++this.generalCount;
                    ++this.businessCount;
                    continue block14;
                }
                case 9: {
                    continue block14;
                }
                case 10: {
                    ++this.privateCount;
                    continue block14;
                }
                case 11: {
                    ++this.businessCount;
                    continue block14;
                }
                default: {
                    this.logger.log(-1601830656, "%1#setChoiceModelValue: unknown number type %2", (Object)this.getName(), (long)nArray[i2]);
                }
            }
        }
    }
}

