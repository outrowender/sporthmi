# SportHMI (Audi MIB2) — Agent Knowledge Base

> Seed file for an AI agent. It captures the full reverse-engineering of the Audi
> "SportHMI / Sportanzeige" feature in the MIB2 firmware, **every data path investigated**,
> the **menu-visibility mechanism + the exact patches** applied to enable it, the gauge
> value logic, and the open problem (real boost pressure) with the **Golf 1.4 TSI lead**.

---

## 1. Mission

Enable and populate the hidden Audi **"Sportanzeige"** (Sport display) in the **Car** menu of a
**2017 Audi A3 1.4 TFSI (8V, 122 PS / EA211 engine)**, whose factory firmware ships the feature
fully built but deliberately crippled and whose gateway does not broadcast the Sport telemetry.

Four sub-goals, with status:
1. Make the Sport item **appear** in the Car menu drawer — **DONE** (confirmed on device).
2. Make it **navigate/click** to the gauges screen — **DONE** (confirmed).
3. Show **all 4 gauges** (power, torque, oil temp, boost) — **DONE** (via ungating).
4. Make the gauges **move with real data** — **PARTIAL**: power/torque derived from live
   pedal+RPM; oil temp via coolant fallback; **boost has no reachable real source** (see §9).

---

## 2. Hardware & firmware environment

- **Unit:** Harman MIB2 High (MMX2 board), dataset **MU 1326**, firmware family
  `MHI2_ER_AU37x_P5089` (Audi A3/S3/RS3 8V).
- **OS:** QNX Neutrino. **Arch:** ARMv7 little-endian (`armle-v7`).
- **Two-board split (critical):**
  - **MMX** (MultiMedia eXtension): runs QNX + the **Java HMI** (this decompiled codebase,
    `LSD.jxe`). **Has NO vehicle-bus hardware** — `/dev/can*` does not exist here.
  - **RCC** (Radio Car Control): owns CAN/MOST/BAP hardware + the **native DSI backend**
    (`libdsi_car.so` / `dsi_server`). Talks to MMX over an internal Ethernet link, passing
    **already-digested DSI/BAP** messages.
- **Consequence:** the Java HMI receives vehicle data **second-hand** and **pre-zeroed**. The
  engine's boost/MAP lives on the **powertrain CAN behind the gateway**, which is **not routed**
  to the infotainment domain on this car. That non-routing is *why Audi disabled Sport here*.
- Active MMX app path: `/net/mmx/mnt/app/` (needs `mount -uw` to modify). Access via WLAN + SSH.

---

## 3. Codebase layout & build

- **Workspace root:** `MU1326_lsd_java/` — decompiled `LSD.jxe` (CFR 0.152). Compiled with
  `javac -source 1.2 -target 1.2` → **keep all edits Java 1.2-compatible** (no generics,
  autoboxing, enhanced-for, etc.).
- **Build script:** `patched/build.sh` recompiles only a FILES list. **Current FILES (in order):**
  `CarModelBank`, `OilTemperatureGaugeController`, `OilTemperatureGaugeRendererHigh`,
  `CarScreenFactory`, `CarScreenBag1`, `CarSMMInitStates`, `CarSMMInitTransitions`,
  `SportComponentEvo`, `SportKombiComponentEvo`. Build: `cd patched; bash build.sh`
  (→ `SportHMI.jar`).
- **ID namespaces** (all in the `6000xx` range, mutually distinct): state IDs, event IDs,
  transition IDs, screen IDs, choice-model IDs, bitmap IDs, text/label IDs.

### 3.1 PATCH WORKFLOW — `patched/` is the only place you edit

The decompiled trees (`MU1326_lsd_java/`, `VW_lsd_java/`) are **read-only references** — they are
the pristine decompilation and must **never** be modified. **Everything inside `patched/` is what
actually gets patched** into the firmware; it is the build input and the source of truth for edits.

**Rule:** to modify a class, do **not** touch its original under `MU1326_lsd_java/` (or
`VW_lsd_java/`). Instead:
1. From inside `patched/`, run `./add_original.sh <fully.qualified.ClassName>` (e.g.
   `./add_original.sh de.audi.tghu.car.hmi.evohighscale.CarScreenBag1`). The script copies the
   pristine original from the decompiled tree (`$JAVA/...`, resolved via `process.sh`), recreates
   its package path under `patched/`, runs `./cleanup.sh` on it (strips decompiler-only constructs
   so it recompiles under Java 1.2 — comments out `final`/`@Override`, fixes `default` method stubs),
   and `git add`s it.
2. Edit the copy **inside `patched/`** only.
3. Add the class to the `FILES` list in `patched/build.sh` if it isn't already there.

**The set of files in the patch == the `FILES` list in `build.sh`.** Only those classes are compiled
and jarred into `SportHMI.jar`. If a patched file is not in `FILES`, it is not in the patch. Keep
`FILES` and the `patched/` tree in sync (currently: `CarScreenBag1`, `CarSMMInitStates`,
`CarSMMInitTransitions`, `SportComponentEvo` — add `CarEvoMenuEntryStructure` /
`SportKombiComponentEvo` when their patches are active).

### Key files
| Path | Role |
|---|---|
| `de/audi/tghu/car/hmi/evohighscale/CarScreenBag1.java` | Builds Car screens. Contains `cARSEL` (Car drawer, screen 600043) and `cARSPORTMAIN` (Sport gauges, screen 600289). |
| `de/audi/tghu/car/hmi/evohighscale/CarScreenFactory.java` | `executeCondition` — per-gauge visibility by condition-model ID. |
| `de/audi/tghu/car/sm/CarSMMInitStates.java` | State → trigger-events + out-transitions tables. |
| `de/audi/tghu/car/sm/CarSMMInitTransitions.java` | Transition flag/target tables (size 587, ids 600000–600586). |
| `de/audi/atip/statemachine/AbstractSMM.java` | SM engine. `arrayIndex = ID − 600000`. |
| `de/audi/app/car/evo/sport/SportComponentEvo.java` | DSI consumer: power/torque/boost gauges (models 602115/602112/602111). |
| `de/audi/app/car/evo/sport/SportKombiComponentEvo.java` | DSI consumer: oil-temp gauge (model 602117). |
| `de/audi/app/car/evo/mer/CarEvoMenuEntryStructure.java` | Menu-entry tree (CAR_FUNC_SPORT + sport leaves). |
| `de/audi/app/car/common/mer/MenuEntryRegistry.java` / `MenuEntry.java` | Menu-entry registration + state propagation. |
| `de/audi/app/car/common/comp/AbstractCarComponent.java` | DSI subscription (`setNotification`). |
| `de/esolutions/fw/comm/dsi/carvehiclestates/impl/*Serializer.java` | DSI (de)serializers — the wire format. |

---

## 4. The feature in one paragraph

A top-level **CAR_FUNC_SPORT** menu entry (internalID **12**, choice model **602119**) with
leaves for power/torque/oil-temp/air-pressure opens a dedicated screen **CAR_SPORT_MAIN (600289)**
holding 4 gauges. The HMI renders the Car drawer from `cARSEL`; Audi removed the Sport drawer
item's wiring, deleted the state-machine transition into the Sport screen, and the gateway sends
no Sport telemetry — three independent cripples that had to be undone separately.

---

## 5. MENU VISIBILITY — mechanism + applied patch

### 5.1 How the Car drawer renders
`cARSEL` (CarScreenBag1, ~line 1335+) builds a `selectionMenuController` with
`menuItemController..menuItemController13`. Each drawer item = a **`MenuItemController`** +
a **`VisibilityProxyWidget`** bound to an availability **choice model** via
`drawerController.setViews(modelId → {proxy})`. The proxy toggles item visibility when its
model updates. Pattern (from CHARISMA):
```
setModelID(601227); setEvent(<SMEvent>); setLabelId(<text>); setInternalID(<menuEntryID>);
setType(2); setWidgetID(k); add(VisibilityProxyWidget w/ setModelID(<availChoice>));
+ drawerController.setViews(<availChoice> → {proxy})
```

### 5.2 How Audi crippled it
`menuItemController13` in `cARSEL` **is the real hidden Sport item** (not a missing item):
- bitmaps `{600721,600722,600723}` (sport icon), labelId **605468** ("Sportanzeige"),
  internalID **600772** = `CAR_MAIN_LEFTDRAWER_SPORTDISPLAY` (sibling: CHARISMA=600159, etc.).
- Crippled **3 ways**: (1) `setVisible(false)` default, (2) **no** `setEvent`, (3) its
  `visibilityProxyWidget11` had **no** `setModelID` and was **absent** from `setViews` → nothing
  drove its visibility.

### 5.3 PATCH APPLIED (in `cARSEL`)
- `visibilityProxyWidget11.setModelID(602119)` — bind to `MAIN_MENU_SPORT_AVAILABLE_CHOICE`.
- `menuItemController13.setEvent(600338)` — `LD_CAR_SEL_SPORTDISPLAY`.
- **removed** `setVisible(false)`.
- appended `602119 → {visibilityProxyWidget11}` to `drawerController.setViews`
  (keep the `int[]` and `HMIView[][]` arrays length-aligned).

> Note: a bad undo once corrupted `setViews` (`1700231`→`170`, tail
> `visibilityProxyWidget11ller`). If the drawer breaks, check that line first.

### 5.4 Menu-entry state model (background)
`MenuEntry` states: 0=FUNCTIONAL(visible), 1=INVISIBLE, 2=DISABLED_ERROR, 3=DISABLED_CLAMP15,
4=threshold, 6=standstill. Parent = most-functional child. `getMenuEntryVisibilityState(viewOption)`:
`viewOption.state==2 → 0 FUNCTIONAL`. The MER pipeline already reaches FUNCTIONAL — forcing states
does **not** reveal the item; the **HMI drawer binding** (§5.3) is the real gate.

---

## 6. NAVIGATION (click) — state machine patch

Clicking fired event **600338** but **no transition** targeted the Sport screen (Audi deleted it).
- Sport **leaf state = 604147** (flag 6 = leaf, screen/DHS = **600289**, parent 600049 = car-menu
  container, same parent as the Charisma leaf). Entry action `setCarContext(9)` (CarSMMActions).
- **Created transition 600008** (mirrors Charisma's trans 256) and wired it:
  - `CarSMMInitTransitions.java`: `nArray[8]=8` (transFlagList), `nArray[8]=new int[]{72}`
    (initTransTrgtFlagList0), `nArray[8]=new int[]{604147}` (initTransitionTargetStateList0).
  - `CarSMMInitStates.java` (root state **604167** handles Car drawer nav events): appended
    `600338` to `nArray[4167]` (events) and `600008` to `nArray2[4167]` (out-transitions),
    **index 36, append-only, both aligned** (no index-shift risk).
- No guard on 600008 (`checkGuard` has no case 8). Verified: `600338@idx36 → 600008 → 604147 →
  screen 600289`.

---

## 7. THE GAUGES — screen, models, gating + patch

### 7.1 Screen `cARSPORTMAIN` (600289, CarScreenBag1 ~line 3433+)
| Gauge | Controller | Model ID | Container | Label |
|---|---|---|---|---|
| Power (clock) | `circularGaugeController` | **602115** | containerController | 605466 |
| Torque (clock) | `circularGaugeController2` | **602112** | containerController2 | 605467 |
| Oil temp | `oilTemperatureGaugeController` | **602117** | containerController3 | — |
| Boost (bar) | `chargingAirPressureGaugeController` | **602111** | containerController3 | — |

- Boost gauge = Kanzi template `Prefabs/tg_boost`, property `tg_barLength = model/100`. An empty
  bar = model value 0.
- Range models 602115/602112/602111 are 0–100 (`setLimits(0,100,1)` in `SportComponentEvo.initModels`).
  Oil temp 602117 is a **metrics** (Temperature) model.

### 7.2 Gauge gating (visibility) — `CarScreenFactory.executeCondition`
Each gauge is toggled by a **condition/choice model** = the SPORT_* menu-entry model:
- 602113 → oil-temp container + gauge
- 602118 → torque container
- 602116 → power container
- 602114 → boost bar (`ChargingAirPressureGaugeController.setVisible(602114==1)`)

Menu-entry→model map (`CarEvoMenuEntryStructure`): 608 SPORT_AIR_PRESSURE→**602114**,
606 SPORT_TORQUE-ish, etc. Availability driven by DSI view-options in
`SportComponentEvo.updateDynamicVehicleInfoHighFrequentViewOptions`.

**This car:** torque(602118)+oiltemp(602113) available; power(602116)+boost(602114) NOT.

### 7.3 PATCH APPLIED — ungate all 4
`cARSPORTMAIN` `setConditionWidgets` is now reduced to **`{601056}` only** (one group,
binding `screenWidgetEVO`). All gauge-container condition bindings (602113 oil-temp,
602114 boost, 602116 power, **602118 torque**) were removed, so every gauge container stays
at its default-visible state on every car regardless of per-car DSI view-options. Keep the
`int[]` and `AbstractWidget[][]` arrays length-aligned.

```java
screenWidgetEVO.setConditionWidgets(new int[]{601056}, new AbstractWidget[][]{{screenWidgetEVO}});
```

**Why this is the real gate (key mechanism — do NOT chase menu entries):** gauge *widget*
visibility on this screen is driven by **screen condition widgets** (`setConditionWidgets` →
handler `CarScreenFactory.executeConditioncARSPORTMAINScreen`), **NOT** by the
`MenuEntryRegistry` / `updateMenuEntryVisibility` path. Forcing menu entries (606/603/608/…)
visible does nothing to the gauges. The torque container (`containerController2`, holding
`circularGaugeController2`/model 602112) was hidden on cars where choice model **602118 != 1**
— that is exactly why only the torque meter disappeared while boost/power/oil-temp (not wired
in the patched `setConditionWidgets`) stayed visible. `601056` = `CAR_VIEWSTATE_CHOICE`
(`IEvoCarModelBank`), a ChoiceModel holding the active car view-state; in this screen it only
toggles Return-key drawer behavior (`!= 604147`), not visibility — safe to keep.

---

## 8. DATA FLOW ARCHITECTURE

```
Engine ECU ─ powertrain CAN ─► [GATEWAY] ─► infotainment CAN/MOST
                                              │  (RCC board, native)
                                              ▼
                      native vehicle-states DSI PROVIDER  (libdsi_car.so — NOT in this jar)
                                              │  serializes struct → bytes
                                              ▼  internal MMX↔RCC link
            DSI (de)serializers (Java) ──► SportComponentEvo (consumer) ──► gauge models
```

- The Java side is a **DSI client**. `AbstractCarComponent.setDSIAttributeNotification` calls
  `this.dsi.setNotification(attrs, listener)` — **no rate/coalescing/latest-value option exists**.
- `SportComponentEvo.getDSIAttributesSets()` = `CarDSIAttributesSet(0, {16,12}, {17,14})`:
  primary = SEMISTATICVEHICLEDATAVIEWOPTIONS(16)+HIGHFREQVIEWOPTIONS(12),
  secondary = SEMISTATICVEHICLEDATA(17)+HIGHFREQ(14).
- **The `relChargingAirPressure` field is only ever WRITTEN by the deserializer** — there is **no
  Java code that sources it from CAN**. The producer is native (RCC). Patching the Java DSI classes
  can only reinterpret bytes we already receive (= synthesis).

### 8.1 `DynamicVehicleInfoHighFrequent` — exact wire layout (attr 14)
Order the native serializer writes = order the Java deserializer reads:
| # | field | type |
|---|---|---|
| 1 | longitudinalAcceleration | float |
| 2 | engineSpeed (RPM) | int32 |
| 3 | powermeter (0–100) | int32 |
| 4 | lateralAcceleration | float |
| 5 | **relChargingAirPressure** (0–100 rel boost %) | **int8** |
| 6 | **absChargingAirPressure** (absolute MAP) | **float** |
| 7 | currentOutputPower | float |
| 8 | yawRate | float |
| 9 | brakePressure | float |
| 10 | wheelAngle | int32 |
| 11 | acceleratorPosition (0–100 pedal) | int8 |
| 12 | vehicleSpeed | optional CarBCSpeed |
| 13 | currentTorque | int32 |
| 14+ | systemCycleDistance, torqueDistribution×4, realVehicleSpeed, shiftLight, allWheelDriveTorque, esp*, relAllWheelDriveTorque | … |

### 8.2 DSICarVehicleStates service identity (for native work)
- Interface string: `dsi.carvehiclestates.DSICarVehicleStates` (v2.11.28)
- Service UUID: `529dbcfc-8a30-59cd-9267-87ca78828718`
- Interface key: `0d2c16a0-aed7-5c28-9333-eba1913d09ab`
- Reply service UUID: `01233b5d-75cd-5163-928f-f10a23ccd2e7`
- Reply interface key: `49b8560c-29e3-50ed-b6e3-35667b14ad8f`
- These are literal strings in `libdsi_car.so` — grep for them to locate the serializer/vtable.
- **`DSICarPerformanceView` / `updateTurboChargerPressure` do NOT exist in this firmware** — any
  blueprint naming them targets the wrong symbol for MU1326.

---

## 9. DATA SOURCES — exhaustive investigation (every path + verdict)

| Source (DSI service / field) | Carries boost? | Verdict on this A3 |
|---|---|---|
| **carvehiclestates** `relChargingAirPressure` / `absChargingAirPressure` (attr 14) | The only real boost feed into the MIB | **Both report 0** even under load; `maxChargingAirPressure` = state 2 (not available) |
| carvehiclestates `currentTorque` / `currentOutputPower` | power/torque | **0** (not routed) |
| carvehiclestates mid-frequent (attr 13/15) | no boost | gearbox oil temp, tire pressures, gear, battery only |
| **carkombi DC** `DCELEMENTCONTENT_BOOSTPRESSURE=1` | NO — display-config enum only; no value feedback | cluster draws it internally; never exports a number |
| carkombi value attrs | temps only | ATTR 64 oil-temp value, 63 coolant, 65 outside; **no boost attr** |
| **EXLAP** (`DSIExlap`) | NO | just `start()/stop()`+AVAILABLESERVICES passthrough; no Java channel |
| **diagnose** (`DSIDiagnoseSystem`) | generic `updateDiagnosticValueChanged(ns,key,val)` | used for language/tuner diag; no live engine boost key |
| generalvehiclestates | NO | tank, airbag, gears, velocity thresholds |
| SDIS (`sdis/*`, `SDISCarDiag.cmdUpdate*`) | injection path only | consumes same empty DSI; feeding it = synthesis |

**Verdict:** No MIB-reachable source carries real boost on this car. The value is physically on the
**powertrain CAN** (OBD port) and inside the **cluster**, neither of which the MMX/RCC infotainment
domain sees. A "DSI patch" in the Java layer can only reinterpret zero bytes (synthesis). A native
`libdsi_car.so` hook on the RCC could *force validity + inject a value*, but still needs a **real
data source** — and the RCC's bus doesn't carry boost either.

### 9.1 Signals that ARE present (used for the working gauges)
`engineSpeed` (RPM), `acceleratorPosition` (0–100 pedal), `vehicleSpeed`, accelerations,
`powermeter` (sometimes). These drive the power/torque estimates (§10).

### 9.2 Oil temp — real data via a request toggle (lead)
`DSICarKombiProvider.setBCOilTemperature(true)` is a **command that asks the cluster to broadcast**
its oil-temp value (attr 64), which otherwise returns `null/valid:2` because nothing requested it.
Coolant (attr 63) is a close fallback. PATCH in `SportKombiComponentEvo`: subscribe secondary
`{64,63}`, feed model 602117 from coolant when `oilTempValid==false`, null-guard the handler.

---

## 10. GAUGE VALUE LOGIC (power/torque) — `SportComponentEvo.updateVisibleValues`

Because `currentTorque`/`currentOutputPower` are 0, the gauges are driven from live pedal+RPM
for a **122 PS 1.4 TFSI (200 Nm @ 1400–4000, power peak ~5000)**:

- **Torque %** = `pedal × wotTorque(rpm) / 100`, where `wotTorque(rpm)` is a full-throttle torque
  envelope (% of 200 Nm) interpolated over:
  rpm `{750,1000,1400,4000,4500,5000,5500,6000,6500}` →
  `{25,50,100,100,96,86,78,71,63}`.
- **Power %** = `torquePct × rpm / 4297` (physics: `P = T·rpm/9549`; divisor 4297 encodes
  200 Nm / 90 kW). Power naturally lags low RPM, peaks ~5000, fades after.
- `clampPercent(0..100)`. Tuning knobs: the `wotTorque` array (torque shape) and `4297` (overall
  power scale). Per-variant maxes: 125 PS = 92 kW/200 Nm; 150 PS = 110 kW/250 Nm.

> These are **estimates from throttle/RPM demand**, not measured Nm/kW — the only option while the
> car doesn't broadcast real torque/power. (User explicitly accepts estimates for power/torque but
> **not** for boost.)

---

## 11. PERFORMANCE — frame backpressure fix

Symptom: while driving, `currentInfoHighFrequent` arrives every 100 ms but with **data from ~500
frames ago, growing** = upstream FIFO backlog (producer > drain). The DSI listener callback is
**synchronous**, so its duration caps delivery rate.

- Disable logs inside lsd.sh

---

## 12. REAL BOOST — the Golf 1.4 TSI lead + paths

**Observation:** a **Golf 1.4 TSI** (sibling EA211 engine) **does expose absolute barometric /
charge-air pressure** to its infotainment. The sensor and data exist on the platform — the
difference is **gateway/ECU routing + coding**, not hardware. So the A3 should be reachable too.

**Boost math:** `Boost = MAP (intake manifold abs pressure) − BARO (ambient)`.
- OBD-II PIDs: `0x0B` = MAP (kPa), `0x33` = BARO (kPa).
- DSI equivalent already modeled: `absChargingAirPressure` (field #6, absolute MAP) +
  a barometric baseline. If the gateway populated `relChargingAirPressure`/`absChargingAirPressure`,
  the existing gauge (model 602111) would just work — **no code change needed**.

### Paths to real boost, ranked
1. **Gateway/ECU recoding (ODIS / VCDS / OBDeleven)** — compare the A3's gateway adaptation to the
   Golf's "charge-air pressure" routing and enable it so `absChargingAirPressure` reaches the
   infotainment vehicle-states provider. **This is the clean fix if the channel can be coded on.**
   Needs confirmation via diagnostics that the A3 gateway exposes the measuring value.
2. **External OBD-II bridge** — WiFi/BLE ELM327 on the OBD port reads PID 0x0B/0x33 → a small
   daemon on the MMX writes `/dev/shmem/custom_boost` → a native hook injects it into model 602111.
   Real data, but requires external hardware.
3. **Native `libdsi_car.so` hook on the RCC** — force attr-12 validity to valid and overwrite
   fields #5/#6 of the attr-14 struct. **Still needs a real source** (path 1 or 2). Caveats:
   `LD_PRELOAD` can't intercept **intra-`.so`** C++ calls (they bind directly, not via PLT) → need
   a cross-boundary symbol or inline/vtable patch; and the RCC's bus must actually carry the signal.

---

## 13. OPEN ITEMS / NEXT STEPS

- [ ] Diagnose the A3 gateway (ODIS/OBDeleven) for a **charge-air / barometric pressure measuring
      value**, mirroring the Golf 1.4 TSI. If routable → real boost with zero code change.
- [ ] If not routable: decide between external OBD bridge (path 2) or leave boost empty.
- [ ] Verify/retain the oil-temp `setBCOilTemperature(true)` + coolant-fallback patch on device.
- [ ] Keep `build.sh` FILES in sync: `CarModelBank`, `OilTemperatureGaugeController`,
      `OilTemperatureGaugeRendererHigh`, `CarScreenFactory`, `CarScreenBag1`, `CarSMMInitStates`,
      `CarSMMInitTransitions`, `SportComponentEvo`, `SportKombiComponentEvo`.
- [ ] Fine-tune the `wotTorque` curve and `4297` divisor against a dyno/reference for the exact PS.

---

## 14. REFERENCE — key IDs

| Thing | ID |
|---|---|
| Coding channel (feature) | 52 = `[LO]_menu_display_SportHMI` (Car_Function_Adaptations_Gen2), coded ON |
| Menu entry CAR_FUNC_SPORT internalID | 12 |
| Sport availability choice model | 602119 (`MAIN_MENU_SPORT_AVAILABLE_CHOICE`) |
| Hidden drawer item internalID | 600772 (`CAR_MAIN_LEFTDRAWER_SPORTDISPLAY`) |
| Sport drawer icon bitmaps | {600721, 600722, 600723} |
| Sport label ("Sportanzeige") | 605468 |
| Nav event | 600338 (`LD_CAR_SEL_SPORTDISPLAY`) |
| Created transition | 600008 → state 604147 |
| Root state handling Car drawer nav | 604167 |
| Sport leaf state | 604147 (screen 600289, parent 600049) |
| Sport screen | 600289 (`CAR_SPORT_MAIN`, `cARSPORTMAIN`) |
| Gauge models | 602115 power, 602112 torque, 602117 oil temp, 602111 boost |
| Gauge condition models | 602116 power, 602118 torque, 602113 oil temp, 602114 boost |
| Sport leaves (menu entries) | 601 power, 604 torque, 607 oil temp, 608 air pressure, 602/603/605/606 |
| DSICarVehicleStates attrs | 12 highfreq-viewopts, 14 highfreq, 16 semistatic-viewopts, 17 semistatic |
| CarKombi value attrs | 64 oil-temp value, 63 coolant, 65 outside temp |

---

## 15. HARD RULES for the agent

1. Keep all Java edits **1.2-compatible** (no generics/autoboxing/enhanced-for).
2. **Do not synthesize boost** — the user wants real data only for boost (estimates OK for
   power/torque). If no real source, say so plainly.
3. The native boost injection targets `libdsi_car.so` on the **RCC**, service
   `dsi.carvehiclestates.DSICarVehicleStates`, attr 14, fields #5/#6 — **not** any
   `PerformanceView`/`TurboCharger` symbol (those don't exist in MU1326).
4. Prefer **gateway coding** (Golf-parity) over native hooks for real boost.
5. Before editing, **re-read current file state** — the user frequently reverts edits.
6. Keep `build.sh` FILES in sync with active patches.

---

## 16. SESSION CHANGELOG (2026-10)

Chronological record of everything done in the latest session. Newest topics grouped by area.

### 16.1 Gauge value logic — reverted to REAL DSI values
`SportComponentEvo.updateVisibleValues()` currently reads the **real** DSI fields (an earlier
full turbo/torque/power *simulation* from pedal+RPM was written then reverted by the user):
- `torque% = currentTorque * 100 / maxSimulatedTorque`
- `power% = round(currentOutputPower * 100 / maxOutputPower)`
- `boost  = relChargingAirPressure`
- `maxSimulatedTorque` set in `calculateMissingStaticValues()`: uses `maxTorque` if >0, else
  350 when `engineDisplacement == 2.0f`, else 250.
- `getDSIAttributesSets()` = `CarDSIAttributesSet(0, {16,12}, {17,14,15})`.
- Debug label (model 602123) still rendered via `buildDebugText()` (dumps RPM, pedal, speed,
  boost rel/abs, power, torque, oil temp, gear). `vehicleSpeed`/`realVehicleSpeed` are
  `CarBCSpeed` with a **float** `speedValue` (km/h), `speedValueState`, `speedUnit`.
- NOTE: if the throttle/RPM-based simulation is reintroduced, it lived in the same method with
  a time-lagged turbo model (2 s spool-up / 1 s spool-down) feeding a `wotTorquePercent(rpm)`
  table, plus a speed-based idle floor (below ~10 km/h torque never drops under 7%).

### 16.2 Torque meter "missing on some cars" — root cause + fix
- Symptom: torque gauge absent on certain cars; boost/power/oil-temp fine.
- **False trails:** menu-entry visibility (`updateMenuEntryVisibility(606,…)`) and forcing all
  SPORT menu entries visible — **neither works**; the MenuEntryRegistry path doesn't gate the
  on-screen gauges (and coding gate `isMenuDisplayActivated(52)` can block registration anyway).
- **Real cause:** condition widget **602118** bound to the torque container in
  `cARSPORTMAIN.setConditionWidgets`; handler hides it when model `602118 != 1`.
- **Fix:** removed that binding (now `setConditionWidgets(new int[]{601056}, {{screenWidgetEVO}})`).
  See §7.3. Repo memory: `/memories/repo/sporthmi_screen.md`.

### 16.3 Oil-temperature scale labels (30/60/90/120)
Added 4 on-screen numeric labels along the oil-temp gauge in `cARSPORTMAIN`:
- `labelTempScale1..4` = `MultiLineLabelRendererHigh`, children of **containerController3**
  (the oil-temp/boost container at 500,96,280,288) so they animate with the screen.
- Each: `setFonts(carScreenFactory.getBoldFont(n,17))`, `setAlignment(2,5)`, `setLineHeight(17)`,
  `setBounds(x,82,48,18)` with x = 10/61/113/166, `setColorIndices({9,0,4,0})`, `setMaxLines(1)`,
  text "30"/"60"/"90"/"120".
- Registered via `oilTemperatureGaugeController.setScaleLabels(new LabelController[]{…})`.
- **Palette:** appended a 10th column (index 9) `-1973791` (=0xFFE1E1E1, light grey) to all 5
  rows of the screen's `setColorPalettes` so `colorIndices[0]=9` resolves to that grey.
- **New helper** `CarScreenFactory.getBoldFont(int n, int size)` →
  `fontLoader.getFont(FontLoader.STANDARD_FONT_BOLD, 1, size)` (built-in `getFonts` sizes are
  fixed; `setLineHeight` only sizes the line box, not the glyph — custom size needs this helper).
- `OilTemperatureGaugeController` got `scaleLabels` + `CELSIUS_SCALE={30,60,90,120}` /
  `FAHRENHEIT_SCALE={140,190,240,290}` + `updateScaleLabels()` (picks set by `temperatureUnit`).

### 16.4 Oil-temp gauge Celsius range
`OilTemperatureGaugeRendererHigh`: Celsius range widened to **min=15 / max=135** (both the
constants and the `case 1:` literals `f3=15.0f`, `f2=135.0f`).

### 16.5 HMI label/font facts (reference)
- `CarScreenFactory.getFonts(i,n)` built-in px sizes: 0=29, 1=23, 4=29 bold, 11=19, 15=17,
  19=20 bold, 20=15 (smallest single), 21=16, 22=18.
- Label color resolves as `activeColorPlate[colorIndices[0]]` (a palette column); no direct-ARGB
  path. `colorIndices[0]=0` → white (-1).
- No per-character letter-spacing in `MultiLineLabelRendererHigh`/`LabelRendererHigh`
  (glyph advances are font-baked).

### 16.6 KZB texture repacker — `kzb/kzb_repack.py`
Size-safe repacker for the monolithic big-endian `SPORT_HMI.kzb` (Kanzi, kzb constant 21 =
`IKzbMappingHelper.SPORTHMI_KZB`):
- Header `@0x00` magic `.KZB`; **`@0x04` = TOTAL FILE SIZE** (loader trusts it — MUST be patched
  on repack, this was the "textures silently don't load" bug); `@0x1C` = 16-byte build GUID
  (not a content hash).
- Per-texture 16-byte descriptor (near 0x1230) right before `u16 nameLen + name`:
  `[u32 chunkOffset=sig-4][u32 chunkSize=PNG bytelen][u32 type=10][u32 flags=0]`; textures packed
  `[4-byte 00000000 sep][PNG]…` + trailing footer; offsets ABSOLUTE.
- The car's embedded PNG decoder accepts **bare PNGs only** (IHDR/IDAT/IEND); ancillary chunks
  (iCCP/eXIf/iTXt) cause **silent** decode failure → repacker auto-strips them (keeps
  {IHDR,PLTE,IDAT,IEND,tRNS}), patches descriptors + `@0x04`, self-validates. Proven byte-exact
  round-trip. Usage: `python3 kzb_repack.py IN.kzb OUT.kzb name.png=new.png` or `--list`.
- `kzbTools` (C++) unpack/pack is unreliable for this variant (wrong hardcoded root offset,
  zeroes 0x4C, wrong magic, never sets 0x04) — prefer `kzb_repack.py`. Full resource set was
  extracted via a Python descriptor scan into `kzb/SPORT_HMI_textures/` and `kzb/SPORT_HMI_all/`.
- Repo memory with full kzb/font/label facts: `/memories/repo/kzb_format.md`.

### 16.7 build.sh FILES now also includes
`CarModelBank`, `OilTemperatureGaugeController`, `OilTemperatureGaugeRendererHigh`,
`CarScreenFactory` (for the scale-label + gauge-range + getBoldFont patches).

---

## 17. SPORT MENU ARCHITECTURE (end-to-end)

How a tap on **"Sportanzeige"** turns into moving gauges. Four decoupled layers: **(A) menu
drawer**, **(B) state machine**, **(C) screen + widgets**, **(D) DSI data → models**. Audi
crippled one thing in each of A/B and starved D; the patches restore each independently.

```
 USER taps "Sportanzeige" in Car drawer
        │
 (A) DRAWER   cARSEL (screen 600043, CarScreenBag1)
        │     menuItemController13  ── internalID 600772, label 605468, icons {600721..723}
        │        ├─ VisibilityProxyWidget (modelID 602119)  → controls item visibility
        │        └─ setEvent(600338)  LD_CAR_SEL_SPORTDISPLAY
        ▼
 (B) STATE MACHINE   AbstractSMM (arrayIndex = ID − 600000)
        │     root state 604167 (Car-drawer nav) : event 600338 → transition 600008
        │     transition 600008 → leaf state 604147  (entry action setCarContext(9))
        ▼
 (C) SCREEN   leaf 604147 → DHS/screen 600289  cARSPORTMAIN (CarScreenBag1)
        │     4 gauge controllers bound to range/metrics models:
        │        circularGaugeController   602115  power
        │        circularGaugeController2  602112  torque
        │        oilTemperatureGaugeController 602117  oil temp (+ scale labels 30/60/90/120)
        │        chargingAirPressureGaugeController 602111  boost bar
        │     visibility = setConditionWidgets → executeConditioncARSPORTMAINScreen (NOT MER)
        ▲
 (D) DATA   SportComponentEvo / SportKombiComponentEvo  (DSI consumers)
        │     subscribe DSICarVehicleStates attrs (viewopts 16/12, data 17/14/15)
        │     updateVisibleValues(): currentTorque→602112, currentOutputPower→602115,
        │                            relChargingAirPressure→602111 ; oil temp→602117
        └─ native DSI provider (libdsi_car.so on RCC board) feeds pre-digested bytes
```

### 17.1 Layer A — the Car drawer (visibility)
- The Car menu is a **`DrawerController`** built by `cARSEL`. Each row is a `MenuItemController`
  whose visibility is driven by a **`VisibilityProxyWidget`** bound to an availability **choice
  model** via `drawerController.setViews(modelId → {proxy})`.
- Sport row = `menuItemController13` (internalID **600772**). Audi crippled it 3 ways: default
  `setVisible(false)`, no `setEvent`, and its proxy had no `setModelID` / wasn't in `setViews`.
- **Patch:** bind proxy to **602119** (`MAIN_MENU_SPORT_AVAILABLE_CHOICE`), `setEvent(600338)`,
  drop `setVisible(false)`, append `602119 → {proxy}` to `setViews`. (See §5.)
- Gate upstream of all this: coding channel **52** (`[LO]_menu_display_SportHMI`) must be ON, else
  `MenuEntryRegistry.registerMenuEntry(…, 52)` refuses and nothing registers.

### 17.2 Layer B — navigation (state machine)
- `AbstractSMM` runs the menu SM; every state/event/transition ID maps to an array via
  `arrayIndex = ID − 600000`. Tables live in `CarSMMInitStates` (state → events + out-transitions)
  and `CarSMMInitTransitions` (transition flags + target state).
- Tapping the Sport row fires **600338**, but Audi deleted the transition into the Sport screen.
- **Patch:** created transition **600008** (mirrors Charisma's) targeting leaf **604147**
  (screen 600289), and appended `600338→600008` under root nav state **604167** (append-only,
  index-aligned). (See §6.)

### 17.3 Layer C — the screen + gauge widgets
- Leaf **604147** displays screen **600289** = `cARSPORTMAIN`. It builds the 4 gauge controllers
  (bound to models 602115/602112/602117/602111), the title bar, the oil-temp **scale labels**
  (§16.3), and a hidden debug label (model 602123).
- **Visibility of each gauge is a screen condition widget**, handled by
  `CarScreenFactory.executeConditioncARSPORTMAINScreen` — **not** the MenuEntryRegistry. The
  torque container was hidden on cars where model `602118 != 1`. **Patch:** reduce
  `setConditionWidgets` to `{601056}` so all gauge containers stay visible. (See §7.3 / §16.2.)
- Gauges render via Kanzi templates in the **KZB** (`SPORT_HMI.kzb`); the boost bar is
  `tg_barLength = model/100`. Texture edits go through `kzb/kzb_repack.py` (§16.6).

### 17.4 Layer D — data (DSI → models)
- Two DSI consumers subclass `AbstractDSICarVehicleStatesAdapter`:
  **`SportComponentEvo`** (power/torque/boost: models 602115/602112/602111, 0–100 range) and
  **`SportKombiComponentEvo`** (oil temp: metrics model 602117).
- `getDSIAttributesSets()` subscribes view-option attrs (16 semistatic-viewopts, 12 highfreq-
  viewopts) + data attrs (17 semistatic, 14 highfreq, 15 midfreq). On each `update…` callback,
  `updateVisibleValues()` writes the gauge models from the live fields
  (`currentTorque`, `currentOutputPower`, `relChargingAirPressure`; §16.1).
- The Java side is only a **DSI client** — the real producer is native (`libdsi_car.so` on the RCC
  board). On this A3 the powertrain CAN isn't routed to infotainment, so torque/power/boost arrive
  **pre-zeroed**; that non-routing is *why Audi disabled Sport here* (data flow in §8, exhaustive
  source hunt in §9, real-boost leads in §12).

### 17.5 ID cross-reference (who talks to whom)
| Layer | Artifact | ID |
|---|---|---|
| A | Sport drawer item internalID | 600772 |
| A | Sport availability choice model (proxy) | 602119 |
| A | Nav event | 600338 |
| A | Coding channel | 52 |
| B | Root nav state (Car drawer) | 604167 |
| B | Created transition | 600008 |
| B | Sport leaf state | 604147 |
| C | Sport screen | 600289 (`cARSPORTMAIN`) |
| C | Gauge models | 602115 / 602112 / 602117 / 602111 |
| C | Gauge condition models (now ungated) | 602116 / 602118 / 602113 / 602114 |
| C | Return-key view-state model (kept) | 601056 |
| D | DSI consumers | `SportComponentEvo`, `SportKombiComponentEvo` |
| D | DSI attrs | 12/16 view-opts, 14/15/17 data |
