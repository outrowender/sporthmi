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
- **Build script:** `patched/build.sh` recompiles only a FILES list. Currently includes:
  `CarEvoMenuEntryStructure`, `SportComponentEvo`, `SportKombiComponentEvo`.
  **Must also add** when their patches are active: `CarScreenBag1`, `CarSMMInitStates`,
  `CarSMMInitTransitions`.
- **ID namespaces** (all in the `6000xx` range, mutually distinct): state IDs, event IDs,
  transition IDs, screen IDs, choice-model IDs, bitmap IDs, text/label IDs.

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
`cARSPORTMAIN` `setConditionWidgets` changed from
`{601056, 602113, 602114, 602116, 602118}` (5 groups) to
`{601056, 602113, 602118}` (3 groups) — removing 602116 (power) and 602114 (boost) so those
gauges always render (read 0 if no data). Keep the `int[]` and `AbstractWidget[][]` aligned.

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
- [ ] Keep `build.sh` FILES in sync: `CarScreenBag1`, `CarSMMInitStates`, `CarSMMInitTransitions`,
      `CarEvoMenuEntryStructure`, `SportComponentEvo`, `SportKombiComponentEvo`.
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
