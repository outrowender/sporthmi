/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.preferredstations;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.poi.commands.EhGetAllBrandsOfCategoryCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.EhSetBrandPreferenceCommand;
import de.audi.tghu.navi.app.addressinput.poi.preferredstations.IPreferredStations;
import de.audi.tghu.navi.app.addressinput.poi.preferredstations.IPreferredStationsModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.Brand;

public class PreferredStationsHandler
implements IPreferredStations {
    private final ICommandListFactory commandListFactory;
    private final IPreferredStationsModelAccess modelAccess;
    private int mapStyleType;
    private Brand[] brands = null;

    public PreferredStationsHandler(ICommandListFactory iCommandListFactory, IPreferredStationsModelAccess iPreferredStationsModelAccess) {
        this.commandListFactory = iCommandListFactory;
        this.modelAccess = iPreferredStationsModelAccess;
    }

    @Override
    public void onStart(int n, int n2, NavCommand navCommand) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.brands == null) {
            this.mapStyleType = n;
            commandList.add(new EhGetAllBrandsOfCategoryCommand(this, n, n2));
        }
        if (navCommand != null) {
            commandList.add(navCommand);
        }
        commandList.execute("PreferredStationsHandler#onStart");
    }

    @Override
    public void brandsUpdated(int n, int n2, Brand[] brandArray) {
        this.brands = brandArray;
        this.modelAccess.brandsUpdated(brandArray);
    }

    @Override
    public void toggleBrandPreferrence(int n) {
        for (int i2 = 0; i2 < this.brands.length; ++i2) {
            boolean bl;
            if (n != this.brands[i2].getBrandUid()) continue;
            this.brands[i2].preferred = bl = !this.brands[i2].isPreferred();
            int[] nArray = new int[]{n};
            boolean[] blArray = new boolean[]{bl};
            this.modelAccess.preferrBrand(n, bl);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new EhSetBrandPreferenceCommand(this.mapStyleType, nArray, blArray));
            commandList.execute("PreferredStationsHandler#onStart");
            break;
        }
    }

    @Override
    public void onExit() {
        int[] nArray = new int[this.brands.length];
        boolean[] blArray = new boolean[this.brands.length];
        for (int i2 = 0; i2 < this.brands.length; ++i2) {
            nArray[i2] = this.brands[i2].getBrandUid();
            blArray[i2] = this.brands[i2].isPreferred();
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new EhSetBrandPreferenceCommand(this.mapStyleType, nArray, blArray));
        commandList.execute("PreferredStationsHandler#onStart");
    }
}

