.version 50 0 
.class public final super [216] 
.super [218] 
.field private final [219] [220] 
.field private final [221] [222] 

.method public [224] : [225] 
    .attribute [223] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [43] 
L5:     aload_0 
L6:     new [48] 
L9:     dup 
L10:    aload_0 
L11:    getfield [23] 
L14:    invokespecial [44] 
L17:    putfield [49] 
L20:    aload_0 
L21:    new [50] 
L24:    dup 
L25:    aload_0 
L26:    getfield [23] 
L29:    invokespecial [45] 
L32:    putfield [51] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [223] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     invokevirtual [26] 
L11:    pop 
L12:    new [52] 
L15:    dup 
L16:    aload_0 
L17:    getfield [27] 
L20:    invokespecial [46] 
L23:    astore_1 
L24:    aload_0 
L25:    getfield [25] 
L28:    aload_1 
L29:    invokevirtual [28] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [228] : [229] 
    .attribute [223] .code stack 9 locals 8 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [4] 
L6:     ldc [7] 
L8:     invokevirtual [26] 
L11:    pop 
L12:    aload_0 
L13:    getfield [29] 
L16:    ifnull L40 
L19:    aload_0 
L20:    getfield [30] 
L23:    ifnull L40 
L26:    aload_0 
L27:    getfield [31] 
L30:    ifnull L40 
L33:    aload_0 
L34:    getfield [32] 
L37:    ifnonnull L54 
L40:    aload_0 
L41:    getfield [23] 
L44:    ldc [8] 
L46:    ldc [9] 
L48:    invokevirtual [26] 
L51:    pop 
L52:    iconst_0 
L53:    areturn 
L54:    aload_0 
L55:    getfield [33] 
L58:    ifne L79 
L61:    aload_0 
L62:    getfield [23] 
L65:    ldc [4] 
L67:    ldc [10] 
L69:    aload_0 
L70:    getfield [33] 
L73:    invokevirtual [34] 
L76:    pop 
L77:    iconst_0 
L78:    areturn 
L79:    aload_0 
L80:    getfield [35] 
L83:    istore_1 
L84:    aload_0 
L85:    getfield [31] 
L88:    invokevirtual [36] 
L91:    istore_2 
L92:    aload_0 
L93:    getfield [32] 
L96:    invokevirtual [37] 
L99:    invokevirtual [38] 
L102:   ifeq L109 
L105:   iconst_1 
L106:   goto L110 
L109:   iconst_0 
L110:   istore_3 
L111:   aload_0 
L112:   getfield [31] 
L115:   invokevirtual [39] 
L118:   iconst_1 
L119:   if_icmpne L126 
L122:   iconst_1 
L123:   goto L127 
L126:   iconst_0 
L127:   istore 4 
L129:   aload_0 
L130:   getfield [32] 
L133:   invokevirtual [40] 
L136:   invokevirtual [38] 
L139:   ifeq L146 
L142:   iconst_1 
L143:   goto L147 
L146:   iconst_0 
L147:   istore 5 
L149:   aload_0 
L150:   getfield [27] 
L153:   istore 6 
L155:   aload_0 
L156:   getfield [41] 
L159:   istore 7 
L161:   new [53] 
L164:   dup 
L165:   iload_3 
L166:   iload_1 
L167:   iload 4 
L169:   iload_2 
L170:   iload 5 
L172:   iload 6 
L174:   iload 7 
L176:   invokespecial [47] 
L179:   astore 8 
L181:   aload_0 
L182:   getfield [24] 
L185:   aload 8 
L187:   invokevirtual [42] 
L190:   areturn 
L191:   nop 
L192:   
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [223] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [4] 
L6:     ldc [12] 
L8:     invokevirtual [26] 
L11:    pop 
L12:    aload_0 
L13:    getfield [23] 
L16:    ldc [13] 
L18:    ldc [14] 
L20:    invokevirtual [26] 
L23:    pop 
L24:    iconst_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [223] .code stack 2 locals 3 
L0:     sipush 166 
L3:     invokestatic [15] 
L6:     istore_1 
L7:     sipush 167 
L10:    invokestatic [15] 
L13:    istore_2 
L14:    bipush 127 
L16:    invokestatic [15] 
L19:    istore_3 
L20:    iload_1 
L21:    iconst_1 
L22:    if_icmpne L36 
L25:    iload_2 
L26:    ifne L36 
L29:    iload_3 
L30:    iconst_1 
L31:    if_icmpne L36 
L34:    iconst_1 
L35:    areturn 
L36:    iconst_0 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = Class [55] 
.const [4] = Int -2137614336 
.const [5] = String [56] 
.const [6] = Class [57] 
.const [7] = String [58] 
.const [8] = Int 1078071040 
.const [9] = String [59] 
.const [10] = String [60] 
.const [11] = Class [61] 
.const [12] = String [62] 
.const [13] = Int -1601830656 
.const [14] = String [63] 
.const [15] = Method [64] [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Class [72] 
.const [23] = Field [73] [74] 
.const [24] = Field [75] [76] 
.const [25] = Field [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Field [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Field [85] [86] 
.const [30] = Field [87] [88] 
.const [31] = Field [89] [90] 
.const [32] = Field [91] [92] 
.const [33] = Field [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Field [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Field [109] [110] 
.const [42] = Method [111] [112] 
.const [43] = Method [113] [114] 
.const [44] = Method [115] [116] 
.const [45] = Method [117] [118] 
.const [46] = Method [119] [120] 
.const [47] = Method [121] [122] 
.const [48] = Class [123] 
.const [49] = Field [124] [125] 
.const [50] = Class [126] 
.const [51] = Field [127] [128] 
.const [52] = Class [129] 
.const [53] = Class [130] 
.const [54] = Utf8 de/audi/app/system/locking/NhtsaLockingEvaluator 
.const [55] = Utf8 de/audi/app/system/locking/SpeedLockingEvaluator 
.const [56] = Utf8 'LockingEvaluator#evaluateSpeedDefinition() --> Entered.' 
.const [57] = Utf8 de/audi/app/system/locking/SpeedEvaluationRequirements 
.const [58] = Utf8 'LockingEvaluator#evaluateNhtsaDefinition() --> Entered.' 
.const [59] = Utf8 "LockingEvaluator#evaluateConditions() <-- Returning 'false' as at least one DSI ist not available or hasn't sent any data yet. No locking due to missing information" 
.const [60] = Utf8 'LockingEvaluator#evaluateNhtsaDefinition() - Clamp15 is off, no locking (clamp15=%1)' 
.const [61] = Utf8 de/audi/app/system/locking/NhtsaEvaluationRequirements 
.const [62] = Utf8 'LockingEvaluator#evaluateEngineOffDefinition() --> Entered.' 
.const [63] = Utf8 'LockingEvaluator#evaluateEngineOffDefinition() - Engine OFF definition is not implemented, no locking.' 
.const [64] = Class [131] 
.const [65] = NameAndType [132] [133] 
.const [66] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [67] = Utf8 de/audi/app/system/locking/AbstractLockingEvaluator 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 org/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequent 
.const [70] = Utf8 org/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequentViewOptions 
.const [71] = Utf8 org/dsi/ifc/global/CarViewOption 
.const [72] = Utf8 de/audi/app/system/locking/LockingBitWrapper 
.const [73] = Class [134] 
.const [74] = NameAndType [135] [136] 
.const [75] = Class [137] 
.const [76] = NameAndType [138] [139] 
.const [77] = Class [140] 
.const [78] = NameAndType [141] [142] 
.const [79] = Class [143] 
.const [80] = NameAndType [144] [145] 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Class [167] 
.const [96] = NameAndType [168] [169] 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Class [173] 
.const [100] = NameAndType [174] [175] 
.const [101] = Class [176] 
.const [102] = NameAndType [177] [178] 
.const [103] = Class [179] 
.const [104] = NameAndType [180] [181] 
.const [105] = Class [182] 
.const [106] = NameAndType [183] [184] 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Utf8 de/audi/app/system/locking/NhtsaLockingEvaluator 
.const [124] = Class [209] 
.const [125] = NameAndType [210] [211] 
.const [126] = Utf8 de/audi/app/system/locking/SpeedLockingEvaluator 
.const [127] = Class [212] 
.const [128] = NameAndType [213] [214] 
.const [129] = Utf8 de/audi/app/system/locking/SpeedEvaluationRequirements 
.const [130] = Utf8 de/audi/app/system/locking/NhtsaEvaluationRequirements 
.const [131] = Utf8 de/audi/app/system/locking/LockingBitWrapper 
.const [132] = Utf8 getFunctionalBitState 
.const [133] = Utf8 (I)I 
.const [134] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [135] = Utf8 logChannel 
.const [136] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [137] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [138] = Utf8 nhtsaEvaluator 
.const [139] = Utf8 Lde/audi/app/system/locking/NhtsaLockingEvaluator; 
.const [140] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [141] = Utf8 speedEvaluator 
.const [142] = Utf8 Lde/audi/app/system/locking/SpeedLockingEvaluator; 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;)Z 
.const [146] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [147] = Utf8 speedThresholdExeeded 
.const [148] = Utf8 Z 
.const [149] = Utf8 de/audi/app/system/locking/SpeedLockingEvaluator 
.const [150] = Utf8 evaluate 
.const [151] = Utf8 (Lde/audi/app/system/locking/SpeedEvaluationRequirements;)Z 
.const [152] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [153] = Utf8 generalVehicleStateDsi 
.const [154] = Utf8 Lorg/dsi/ifc/generalvehiclestates/DSIGeneralVehicleStates; 
.const [155] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [156] = Utf8 carVehicleStateDsi 
.const [157] = Utf8 Lorg/dsi/ifc/carvehiclestates/DSICarVehicleStates; 
.const [158] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [159] = Utf8 dynamicVehicleInfoMidFrequent 
.const [160] = Utf8 Lorg/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequent; 
.const [161] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [162] = Utf8 dynamicVehicleInfoMidFrequentViewOptions 
.const [163] = Utf8 Lorg/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequentViewOptions; 
.const [164] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [165] = Utf8 clamp15 
.const [166] = Utf8 Z 
.const [167] = Utf8 de/audi/atip/log/LogChannel 
.const [168] = Utf8 log 
.const [169] = Utf8 (ILjava/lang/String;Z)Z 
.const [170] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [171] = Utf8 automaticGearShiftTransMode 
.const [172] = Utf8 I 
.const [173] = Utf8 org/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequent 
.const [174] = Utf8 getCurrentGear 
.const [175] = Utf8 ()I 
.const [176] = Utf8 org/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequentViewOptions 
.const [177] = Utf8 getAutomaticGearShiftTransMode 
.const [178] = Utf8 ()Lorg/dsi/ifc/global/CarViewOption; 
.const [179] = Utf8 org/dsi/ifc/global/CarViewOption 
.const [180] = Utf8 getState 
.const [181] = Utf8 ()I 
.const [182] = Utf8 org/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequent 
.const [183] = Utf8 getClutch 
.const [184] = Utf8 ()I 
.const [185] = Utf8 org/dsi/ifc/carvehiclestates/DynamicVehicleInfoMidFrequentViewOptions 
.const [186] = Utf8 getCurrentGear 
.const [187] = Utf8 ()Lorg/dsi/ifc/global/CarViewOption; 
.const [188] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [189] = Utf8 parkingBrakeEngaged 
.const [190] = Utf8 Z 
.const [191] = Utf8 de/audi/app/system/locking/NhtsaLockingEvaluator 
.const [192] = Utf8 evaluate 
.const [193] = Utf8 (Lde/audi/app/system/locking/NhtsaEvaluationRequirements;)Z 
.const [194] = Utf8 de/audi/app/system/locking/AbstractLockingEvaluator 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [197] = Utf8 de/audi/app/system/locking/NhtsaLockingEvaluator 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [200] = Utf8 de/audi/app/system/locking/SpeedLockingEvaluator 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [203] = Utf8 de/audi/app/system/locking/SpeedEvaluationRequirements 
.const [204] = Utf8 <init> 
.const [205] = Utf8 (Z)V 
.const [206] = Utf8 de/audi/app/system/locking/NhtsaEvaluationRequirements 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (ZIZIZZZ)V 
.const [209] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [210] = Utf8 nhtsaEvaluator 
.const [211] = Utf8 Lde/audi/app/system/locking/NhtsaLockingEvaluator; 
.const [212] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [213] = Utf8 speedEvaluator 
.const [214] = Utf8 Lde/audi/app/system/locking/SpeedLockingEvaluator; 
.const [215] = Utf8 de/audi/app/system/locking/LockingEvaluator 
.const [216] = Class [215] 
.const [217] = Utf8 de/audi/app/system/locking/AbstractLockingEvaluator 
.const [218] = Class [217] 
.const [219] = Utf8 nhtsaEvaluator 
.const [220] = Utf8 Lde/audi/app/system/locking/NhtsaLockingEvaluator; 
.const [221] = Utf8 speedEvaluator 
.const [222] = Utf8 Lde/audi/app/system/locking/SpeedLockingEvaluator; 
.const [223] = Utf8 Code 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [226] = Utf8 evaluateSpeedDefinition 
.const [227] = Utf8 ()Z 
.const [228] = Utf8 evaluateNhtsaDefinition 
.const [229] = Utf8 ()Z 
.const [230] = Utf8 evaluateEngineOffDefinition 
.const [231] = Utf8 ()Z 
.const [232] = Utf8 isNowPlayingScreenLockedByNhtsaCoding 
.const [233] = Utf8 ()Z 
.end class 
