.version 50 0 
.class public super [206] 
.super [208] 
.implements [210] 
.field private final [211] [212] 
.field private final [213] [214] 
.field private [215] [216] 
.field private [217] [218] 
.field private [219] [220] 
.field private [221] [222] 
.field private [223] [224] 
.field private [225] [226] 
.field private [227] [228] 

.method public [230] : [231] 
    .attribute [229] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [29] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [30] 
L14:    aload_0 
L15:    lload_3 
L16:    putfield [31] 
L19:    aload_0 
L20:    fload 5 
L22:    putfield [32] 
L25:    aload_0 
L26:    aload 6 
L28:    putfield [33] 
L31:    aload_0 
L32:    new [34] 
L35:    dup 
L36:    aload_0 
L37:    invokespecial [23] 
L40:    putfield [35] 
L43:    aload_0 
L44:    new [34] 
L47:    dup 
L48:    aload_0 
L49:    invokespecial [23] 
L52:    putfield [36] 
L55:    return 
L56:    
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [229] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifne L21 
L7:     fload_2 
L8:     ldc [3] 
L10:    fcmpg 
L11:    ifle L21 
L14:    aload_0 
L15:    getfield [17] 
L18:    ifnull L22 
L21:    return 
L22:    aload_0 
L23:    fload_1 
L24:    fload_2 
L25:    invokespecial [24] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [234] : [235] 
    .attribute [229] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     fload_2 
L3:     invokespecial [25] 
L6:     ifeq L18 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [29] 
L14:    aload_0 
L15:    invokespecial [26] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [236] : [237] 
    .attribute [229] .code stack 2 locals 0 
L0:     fload_2 
L1:     aload_0 
L2:     getfield [13] 
L5:     fcmpg 
L6:     ifge L18 
L9:     fload_1 
L10:    aload_0 
L11:    getfield [13] 
L14:    fcmpl 
L15:    ifge L36 
L18:    fload_2 
L19:    aload_0 
L20:    getfield [13] 
L23:    fcmpl 
L24:    ifle L38 
L27:    fload_1 
L28:    aload_0 
L29:    getfield [13] 
L32:    fcmpg 
L33:    ifgt L38 
L36:    iconst_1 
L37:    areturn 
L38:    iconst_0 
L39:    areturn 
L40:    
    .end code 
.end method 

.method private [238] : [239] 
    .attribute [229] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [14] 
L9:     invokeinterface [38] 0 
L14:    invokeinterface [39] 0 
L19:    aload_0 
L20:    getfield [15] 
L23:    aload_0 
L24:    getfield [11] 
L27:    invokeinterface [40] 0 
L32:    putfield [41] 
L35:    aload_0 
L36:    invokespecial [28] 
L39:    aload_0 
L40:    aload_0 
L41:    getfield [14] 
L44:    invokeinterface [38] 0 
L49:    invokeinterface [39] 0 
L54:    aload_0 
L55:    getfield [16] 
L58:    aload_0 
L59:    getfield [12] 
L62:    invokeinterface [40] 0 
L67:    putfield [37] 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [240] : [241] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L29 
L7:     aload_0 
L8:     getfield [18] 
L11:    invokevirtual [19] 
L14:    ifne L29 
L17:    aload_0 
L18:    getfield [18] 
L21:    invokevirtual [20] 
L24:    aload_0 
L25:    aconst_null 
L26:    putfield [41] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [242] : [243] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifnull L29 
L7:     aload_0 
L8:     getfield [17] 
L11:    invokevirtual [19] 
L14:    ifne L29 
L17:    aload_0 
L18:    getfield [17] 
L21:    invokevirtual [20] 
L24:    aload_0 
L25:    aconst_null 
L26:    putfield [37] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [15] 
L5:     invokevirtual [21] 
L8:     ifeq L21 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [29] 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [41] 
L21:    aload_1 
L22:    aload_0 
L23:    getfield [16] 
L26:    invokevirtual [21] 
L29:    ifeq L37 
L32:    aload_0 
L33:    aconst_null 
L34:    putfield [37] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public interface [246] : [247] 
    .attribute [229] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [29] 
L5:     aload_0 
L6:     invokespecial [27] 
L9:     aload_0 
L10:    invokespecial [28] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = Int 32959 
.const [4] = Class [43] 
.const [5] = Class [44] 
.const [6] = Class [45] 
.const [7] = Class [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = Field [49] [50] 
.const [11] = Field [51] [52] 
.const [12] = Field [53] [54] 
.const [13] = Field [55] [56] 
.const [14] = Field [57] [58] 
.const [15] = Field [59] [60] 
.const [16] = Field [61] [62] 
.const [17] = Field [63] [64] 
.const [18] = Field [65] [66] 
.const [19] = Method [67] [68] 
.const [20] = Method [69] [70] 
.const [21] = Method [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Method [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Field [87] [88] 
.const [30] = Field [89] [90] 
.const [31] = Field [91] [92] 
.const [32] = Field [93] [94] 
.const [33] = Field [95] [96] 
.const [34] = Class [97] 
.const [35] = Field [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = InterfaceMethod [104] [105] 
.const [39] = InterfaceMethod [106] [107] 
.const [40] = InterfaceMethod [108] [109] 
.const [41] = Field [110] [111] 
.const [42] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [43] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [46] = Utf8 de/audi/atip/hmi/HMIService 
.const [47] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [48] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [49] = Class [112] 
.const [50] = NameAndType [113] [114] 
.const [51] = Class [115] 
.const [52] = NameAndType [116] [117] 
.const [53] = Class [118] 
.const [54] = NameAndType [119] [120] 
.const [55] = Class [121] 
.const [56] = NameAndType [122] [123] 
.const [57] = Class [124] 
.const [58] = NameAndType [125] [126] 
.const [59] = Class [127] 
.const [60] = NameAndType [128] [129] 
.const [61] = Class [130] 
.const [62] = NameAndType [131] [132] 
.const [63] = Class [133] 
.const [64] = NameAndType [134] [135] 
.const [65] = Class [136] 
.const [66] = NameAndType [137] [138] 
.const [67] = Class [139] 
.const [68] = NameAndType [140] [141] 
.const [69] = Class [142] 
.const [70] = NameAndType [143] [144] 
.const [71] = Class [145] 
.const [72] = NameAndType [146] [147] 
.const [73] = Class [148] 
.const [74] = NameAndType [149] [150] 
.const [75] = Class [151] 
.const [76] = NameAndType [152] [153] 
.const [77] = Class [154] 
.const [78] = NameAndType [155] [156] 
.const [79] = Class [157] 
.const [80] = NameAndType [158] [159] 
.const [81] = Class [160] 
.const [82] = NameAndType [161] [162] 
.const [83] = Class [163] 
.const [84] = NameAndType [164] [165] 
.const [85] = Class [166] 
.const [86] = NameAndType [167] [168] 
.const [87] = Class [169] 
.const [88] = NameAndType [170] [171] 
.const [89] = Class [172] 
.const [90] = NameAndType [173] [174] 
.const [91] = Class [175] 
.const [92] = NameAndType [176] [177] 
.const [93] = Class [178] 
.const [94] = NameAndType [179] [180] 
.const [95] = Class [181] 
.const [96] = NameAndType [182] [183] 
.const [97] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [98] = Class [184] 
.const [99] = NameAndType [185] [186] 
.const [100] = Class [187] 
.const [101] = NameAndType [188] [189] 
.const [102] = Class [190] 
.const [103] = NameAndType [191] [192] 
.const [104] = Class [193] 
.const [105] = NameAndType [194] [195] 
.const [106] = Class [196] 
.const [107] = NameAndType [197] [198] 
.const [108] = Class [199] 
.const [109] = NameAndType [200] [201] 
.const [110] = Class [202] 
.const [111] = NameAndType [203] [204] 
.const [112] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [113] = Utf8 isLocked 
.const [114] = Utf8 Z 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [116] = Utf8 LOCK_DURATION 
.const [117] = Utf8 J 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [119] = Utf8 TIME_BETWEEN_LOCKS 
.const [120] = Utf8 J 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [122] = Utf8 axisPosition 
.const [123] = Utf8 F 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [125] = Utf8 framework 
.const [126] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [128] = Utf8 axisLockEvent 
.const [129] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [131] = Utf8 betweenLocksEvent 
.const [132] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [134] = Utf8 betweenLocksTimer 
.const [135] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [137] = Utf8 axisLockTimer 
.const [138] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [139] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [140] = Utf8 isCanceled 
.const [141] = Utf8 ()Z 
.const [142] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [143] = Utf8 cancel 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/lang/Object 
.const [146] = Utf8 equals 
.const [147] = Utf8 (Ljava/lang/Object;)Z 
.const [148] = Utf8 java/lang/Object 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;)V 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [155] = Utf8 tryToSetLock 
.const [156] = Utf8 (FF)V 
.const [157] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [158] = Utf8 lockAxis 
.const [159] = Utf8 (FF)Z 
.const [160] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [161] = Utf8 restartTimer 
.const [162] = Utf8 ()V 
.const [163] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [164] = Utf8 cancelAxisLockTimer 
.const [165] = Utf8 ()V 
.const [166] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [167] = Utf8 cancelBetweenLocksTimer 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [170] = Utf8 isLocked 
.const [171] = Utf8 Z 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [173] = Utf8 LOCK_DURATION 
.const [174] = Utf8 J 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [176] = Utf8 TIME_BETWEEN_LOCKS 
.const [177] = Utf8 J 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [179] = Utf8 axisPosition 
.const [180] = Utf8 F 
.const [181] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [182] = Utf8 framework 
.const [183] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [185] = Utf8 axisLockEvent 
.const [186] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [187] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [188] = Utf8 betweenLocksEvent 
.const [189] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [190] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [191] = Utf8 betweenLocksTimer 
.const [192] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [193] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [194] = Utf8 getHMIService 
.const [195] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [196] = Utf8 de/audi/atip/hmi/HMIService 
.const [197] = Utf8 getEventDispatcher 
.const [198] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [199] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [200] = Utf8 postEvent 
.const [201] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;J)Lde/esolutions/fw/util/commons/job/Job; 
.const [202] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [203] = Utf8 axisLockTimer 
.const [204] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [205] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/balancefader/AxisLockWithTimer 
.const [206] = Class [205] 
.const [207] = Utf8 java/lang/Object 
.const [208] = Class [207] 
.const [209] = Utf8 de/audi/atip/hmi/event/ATIPEventListener 
.const [210] = Class [209] 
.const [211] = Utf8 LOCK_DURATION 
.const [212] = Utf8 J 
.const [213] = Utf8 TIME_BETWEEN_LOCKS 
.const [214] = Utf8 J 
.const [215] = Utf8 isLocked 
.const [216] = Utf8 Z 
.const [217] = Utf8 axisPosition 
.const [218] = Utf8 F 
.const [219] = Utf8 framework 
.const [220] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [221] = Utf8 axisLockTimer 
.const [222] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [223] = Utf8 betweenLocksTimer 
.const [224] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [225] = Utf8 axisLockEvent 
.const [226] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [227] = Utf8 betweenLocksEvent 
.const [228] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [229] = Utf8 Code 
.const [230] = Utf8 <init> 
.const [231] = Utf8 (JJFLde/audi/atip/base/IFrameworkAccess;)V 
.const [232] = Utf8 tryToLock 
.const [233] = Utf8 (FF)V 
.const [234] = Utf8 tryToSetLock 
.const [235] = Utf8 (FF)V 
.const [236] = Utf8 lockAxis 
.const [237] = Utf8 (FF)Z 
.const [238] = Utf8 restartTimer 
.const [239] = Utf8 ()V 
.const [240] = Utf8 cancelAxisLockTimer 
.const [241] = Utf8 ()V 
.const [242] = Utf8 cancelBetweenLocksTimer 
.const [243] = Utf8 ()V 
.const [244] = Utf8 processEvent 
.const [245] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [246] = Utf8 isLocked 
.const [247] = Utf8 ()Z 
.const [248] = Utf8 reset 
.const [249] = Utf8 ()V 
.end class 
