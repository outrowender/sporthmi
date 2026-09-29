/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import java.util.HashMap;
import java.util.Map;

public class UpdateAddressInputFormScreenModelsCommand
extends NavCommand {
    private final IAddressInputModelAccess modelAccess;
    private final IAddressInputFormModelAccessHelper modelAccessHelper;

    public UpdateAddressInputFormScreenModelsCommand(IAddressInputModelAccess iAddressInputModelAccess) {
        this.modelAccess = iAddressInputModelAccess;
        this.modelAccessHelper = null;
    }

    public UpdateAddressInputFormScreenModelsCommand(IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.modelAccess = null;
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    @Override
    public void execute() {
        if (this.modelAccess == null) {
            if (this.modelAccessHelper == null) {
                this.getCommandList().commandAborted("ModelAccess is null");
                return;
            }
            this.modelAccessHelper.onUpdateLocation(this.env, this.env.getAddressInputLogChannel(), this.env.getContainer().getLiCurrentLD(), this.getEnableMapFlags());
            this.getCommandList().commandFinished();
            return;
        }
        this.modelAccess.onUpdateLocation(this.env.getContainer().getLiCurrentLD(), this.getEnableMapFlags());
        this.getCommandList().commandFinished();
    }

    private Map getEnableMapFlags() {
        HashMap hashMap = new HashMap();
        hashMap.put("routeGuidancePossible", this.canRouteGuidanceBeStarted());
        hashMap.put("countryEnabled", this.canCountryBeEntered());
        hashMap.put("cityEnabled", this.canCityBeEntered());
        hashMap.put("streetEnabled", this.canStreetBeEntered());
        hashMap.put("housenumberEnabled", this.canHousenumberBeEntered());
        hashMap.put("junctionEnabled", this.canJunctionBeEntered());
        hashMap.put("poiNameEnabled", this.canPOINameBeEntered());
        hashMap.put("prefectureEnabled", this.canPrefectureBeEntered());
        hashMap.put("placenameEnbaled", this.canPlacenameBeEntered());
        hashMap.put("chomeEnabled", this.canChomeNumberBeEntered());
        hashMap.put("wardEnabled", this.canWardBeEntered());
        hashMap.put("townStreetEnabled", this.canTownStreetBeEntered());
        hashMap.put("villageStreetEnabled", this.canVillageStreetBeEntered());
        hashMap.put("cityCenterSelected", this.hasCenterBeenSelected());
        return hashMap;
    }

    private boolean canRouteGuidanceBeStarted() {
        if (this.env.getContainer().getLiCurrentLD() == null) {
            return false;
        }
        return this.env.getContainer().getLiCurrentLD().isPositionValid();
    }

    private boolean canCountryBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(1);
    }

    private boolean canCityBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(2) || this.env.getContainer().selectionCriterionAvailable(6);
    }

    private boolean canStreetBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(3) || this.env.getContainer().selectionCriterionAvailable(0xE800000) && this.env.getContainer().refinementCriterionAvailable(2);
    }

    private boolean canHousenumberBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(5) || this.env.getContainer().selectionCriterionAvailable(154) && this.env.getInputModeManager().isSdsActive() || this.env.getContainer().selectionCriterionAvailable(136);
    }

    private boolean canJunctionBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(4);
    }

    private boolean canPOINameBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(0x3800000);
    }

    private boolean canPrefectureBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(138);
    }

    private boolean canPlacenameBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(147);
    }

    private boolean canChomeNumberBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(144);
    }

    private boolean canWardBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(152);
    }

    private boolean canTownStreetBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(150);
    }

    private boolean canVillageStreetBeEntered() {
        return this.env.getContainer().selectionCriterionAvailable(151);
    }

    private boolean hasCityCenterBeenSelected() {
        return SpellerStack.getInstance().isActiveSpellerContextIDEqual(34) && Util.isEmpty(Util.getLocationAccessor(this.env.getContainer().getLiCurrentLD()).getTown());
    }

    private boolean hasWardCenterBeenSelected() {
        return SpellerStack.getInstance().isActiveSpellerContextIDEqual(39) && Util.isEmpty(Util.getLocationAccessor(this.env.getContainer().getLiCurrentLD()).getWard());
    }

    private boolean hasPlaceCenterBeenSelected() {
        return SpellerStack.getInstance().isActiveSpellerContextIDEqual(36) && Util.isEmpty(Util.getLocationAccessor(this.env.getContainer().getLiCurrentLD()).getPlaceName());
    }

    private boolean hasChomeCenterBeenSelected() {
        return SpellerStack.getInstance().isActiveSpellerContextIDEqual(37) && Util.isEmpty(Util.getLocationAccessor(this.env.getContainer().getLiCurrentLD()).getChome());
    }

    private boolean hasCenterBeenSelected() {
        return this.hasCityCenterBeenSelected() || this.hasWardCenterBeenSelected() || this.hasPlaceCenterBeenSelected() || this.hasChomeCenterBeenSelected();
    }
}

