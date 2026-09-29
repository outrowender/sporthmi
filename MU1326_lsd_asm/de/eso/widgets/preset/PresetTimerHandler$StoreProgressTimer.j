.version 50 0 
.class super [209] 
.super [211] 
.implements [213] 
.field private static final [214] [215] 
.field private static final [216] [217] 
.field private static final [218] [219] 
.field private [220] [221] 
.field private [222] [223] 
.field private [224] [225] 
.field private final [226] [227] 
.field private final synthetic [228] [229] 

.method public [231] : [232] 
    .attribute [230] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [38] 
L5:     aload_0 
L6:     invokespecial [35] 
L9:     aload_0 
L10:    invokestatic [2] 
L13:    ifeq L21 
L16:    bipush 20 
L18:    goto L23 
L21:    bipush 10 
L23:    putfield [39] 
L26:    aload_0 
L27:    new [40] 
L30:    dup 
L31:    aload_0 
L32:    invokespecial [36] 
L35:    putfield [41] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [233] : [234] 
    .attribute [230] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [21] 
L9:     invokestatic [4] 
L12:    invokeinterface [42] 0 
L17:    invokeinterface [43] 0 
L22:    aload_0 
L23:    getfield [23] 
L26:    ldc_w [1] 
L29:    invokeinterface [44] 0 
L34:    putfield [45] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [235] : [236] 
    .attribute [230] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [21] 
L5:     invokestatic [4] 
L8:     invokeinterface [42] 0 
L13:    invokeinterface [43] 0 
L18:    aload_0 
L19:    getfield [23] 
L22:    ldc_w [1] 
L25:    invokeinterface [44] 0 
L30:    putfield [45] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [237] : [238] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [46] 
L5:     aload_0 
L6:     getfield [24] 
L9:     ifnull L29 
L12:    aload_0 
L13:    getfield [24] 
L16:    invokevirtual [26] 
L19:    ifne L29 
L22:    aload_0 
L23:    getfield [24] 
L26:    invokevirtual [27] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [230] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [24] 
L11:    invokevirtual [26] 
L14:    ifne L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [230] .code stack 3 locals 1 
L0:     invokestatic [5] 
L3:     ldc [6] 
L5:     ldc [7] 
L7:     invokevirtual [28] 
L10:    pop 
L11:    aload_0 
L12:    dup 
L13:    getfield [25] 
L16:    iconst_1 
L17:    iadd 
L18:    putfield [46] 
L21:    aload_0 
L22:    getfield [25] 
L25:    aload_0 
L26:    getfield [22] 
L29:    if_icmpgt L65 
L32:    aload_0 
L33:    getfield [25] 
L36:    i2f 
L37:    aload_0 
L38:    getfield [22] 
L41:    i2f 
L42:    fdiv 
L43:    fstore_2 
L44:    aload_0 
L45:    getfield [21] 
L48:    invokestatic [8] 
L51:    invokevirtual [29] 
L54:    fload_2 
L55:    invokevirtual [30] 
L58:    aload_0 
L59:    invokespecial [37] 
L62:    goto L83 
L65:    aload_0 
L66:    iconst_0 
L67:    putfield [46] 
L70:    aload_0 
L71:    getfield [21] 
L74:    invokestatic [8] 
L77:    invokevirtual [31] 
L80:    invokevirtual [32] 
L83:    return 
L84:    
    .end code 
.end method 

.method static synthetic [243] : [244] 
    .attribute [230] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [245] : [246] 
    .attribute [230] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [48] [49] 
.const [3] = Class [50] 
.const [4] = Method [51] [52] 
.const [5] = Method [53] [54] 
.const [6] = Int -2137614336 
.const [7] = String [55] 
.const [8] = Method [56] [57] 
.const [9] = Class [58] 
.const [10] = Class [59] 
.const [11] = Class [60] 
.const [12] = Class [61] 
.const [13] = Class [62] 
.const [14] = Class [63] 
.const [15] = Class [64] 
.const [16] = Class [65] 
.const [17] = Class [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Field [70] [71] 
.const [22] = Field [72] [73] 
.const [23] = Field [74] [75] 
.const [24] = Field [76] [77] 
.const [25] = Field [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Class [108] 
.const [41] = Field [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = Field [117] [118] 
.const [46] = Field [119] [120] 
.const [47] = Int 1342177280 
.const [48] = Class [121] 
.const [49] = NameAndType [122] [123] 
.const [50] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [51] = Class [124] 
.const [52] = NameAndType [125] [126] 
.const [53] = Class [127] 
.const [54] = NameAndType [128] [129] 
.const [55] = Utf8 'StoreProgressTimer#processEvent fireLongPressTimer received' 
.const [56] = Class [130] 
.const [57] = NameAndType [131] [132] 
.const [58] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [61] = Utf8 de/eso/widgets/preset/PresetTimerHandler 
.const [62] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [63] = Utf8 de/audi/atip/hmi/HMIService 
.const [64] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [65] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 de/eso/widgets/preset/PresetManager 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/PresetPopupController 
.const [69] = Utf8 de/eso/widgets/preset/PresetFSM 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Class [172] 
.const [97] = NameAndType [173] [174] 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [109] = Class [190] 
.const [110] = NameAndType [191] [192] 
.const [111] = Class [193] 
.const [112] = NameAndType [194] [195] 
.const [113] = Class [196] 
.const [114] = NameAndType [197] [198] 
.const [115] = Class [199] 
.const [116] = NameAndType [200] [201] 
.const [117] = Class [202] 
.const [118] = NameAndType [203] [204] 
.const [119] = Class [205] 
.const [120] = NameAndType [206] [207] 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [122] = Utf8 isScreenResolution1024 
.const [123] = Utf8 ()Z 
.const [124] = Utf8 de/eso/widgets/preset/PresetTimerHandler 
.const [125] = Utf8 access$000 
.const [126] = Utf8 (Lde/eso/widgets/preset/PresetTimerHandler;)Lde/audi/atip/base/IFrameworkAccess; 
.const [127] = Utf8 de/eso/widgets/preset/PresetTimerHandler 
.const [128] = Utf8 access$100 
.const [129] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [130] = Utf8 de/eso/widgets/preset/PresetTimerHandler 
.const [131] = Utf8 access$200 
.const [132] = Utf8 (Lde/eso/widgets/preset/PresetTimerHandler;)Lde/eso/widgets/preset/PresetManager; 
.const [133] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [134] = Utf8 this$0 
.const [135] = Utf8 Lde/eso/widgets/preset/PresetTimerHandler; 
.const [136] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [137] = Utf8 longPressStoreSteps 
.const [138] = Utf8 I 
.const [139] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [140] = Utf8 longPressTimerEvent 
.const [141] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [142] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [143] = Utf8 longPressTimer 
.const [144] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [145] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [146] = Utf8 longPressProgressCounter 
.const [147] = Utf8 I 
.const [148] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [149] = Utf8 isCanceled 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [152] = Utf8 cancel 
.const [153] = Utf8 ()V 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;)Z 
.const [157] = Utf8 de/eso/widgets/preset/PresetManager 
.const [158] = Utf8 getPresetPopupController 
.const [159] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/PresetPopupController; 
.const [160] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/PresetPopupController 
.const [161] = Utf8 setStoreProgressbarValue 
.const [162] = Utf8 (F)V 
.const [163] = Utf8 de/eso/widgets/preset/PresetManager 
.const [164] = Utf8 getPresetFSM 
.const [165] = Utf8 ()Lde/eso/widgets/preset/PresetFSM; 
.const [166] = Utf8 de/eso/widgets/preset/PresetFSM 
.const [167] = Utf8 fireLongPressTimer 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [170] = Utf8 stop 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [173] = Utf8 start 
.const [174] = Utf8 ()V 
.const [175] = Utf8 java/lang/Object 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;)V 
.const [181] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [182] = Utf8 reschedule 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [185] = Utf8 this$0 
.const [186] = Utf8 Lde/eso/widgets/preset/PresetTimerHandler; 
.const [187] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [188] = Utf8 longPressStoreSteps 
.const [189] = Utf8 I 
.const [190] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [191] = Utf8 longPressTimerEvent 
.const [192] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [193] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [194] = Utf8 getHMIService 
.const [195] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [196] = Utf8 de/audi/atip/hmi/HMIService 
.const [197] = Utf8 getEventDispatcher 
.const [198] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [199] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [200] = Utf8 postEvent 
.const [201] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;J)Lde/esolutions/fw/util/commons/job/Job; 
.const [202] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [203] = Utf8 longPressTimer 
.const [204] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [205] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [206] = Utf8 longPressProgressCounter 
.const [207] = Utf8 I 
.const [208] = Utf8 de/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer 
.const [209] = Class [208] 
.const [210] = Utf8 java/lang/Object 
.const [211] = Class [210] 
.const [212] = Utf8 de/audi/atip/hmi/event/ATIPEventListener 
.const [213] = Class [212] 
.const [214] = Utf8 LONG_PRESS_STORE_TIME_STEP_DELAY 
.const [215] = Utf8 I 
.const [216] = Utf8 LONG_PRESS_STORE_STEPS_HIGH 
.const [217] = Utf8 I 
.const [218] = Utf8 LONG_PRESS_STORE_STEPS_STD 
.const [219] = Utf8 I 
.const [220] = Utf8 longPressProgressCounter 
.const [221] = Utf8 I 
.const [222] = Utf8 longPressTimer 
.const [223] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [224] = Utf8 longPressTimerEvent 
.const [225] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [226] = Utf8 longPressStoreSteps 
.const [227] = Utf8 I 
.const [228] = Utf8 this$0 
.const [229] = Utf8 Lde/eso/widgets/preset/PresetTimerHandler; 
.const [230] = Utf8 Code 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/eso/widgets/preset/PresetTimerHandler;)V 
.const [233] = Utf8 start 
.const [234] = Utf8 ()V 
.const [235] = Utf8 reschedule 
.const [236] = Utf8 ()V 
.const [237] = Utf8 stop 
.const [238] = Utf8 ()V 
.const [239] = Utf8 isActive 
.const [240] = Utf8 ()Z 
.const [241] = Utf8 processEvent 
.const [242] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [243] = Utf8 access$300 
.const [244] = Utf8 (Lde/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer;)V 
.const [245] = Utf8 access$400 
.const [246] = Utf8 (Lde/eso/widgets/preset/PresetTimerHandler$StoreProgressTimer;)V 
.end class 
