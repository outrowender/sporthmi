.version 50 0 
.class public final super [245] 
.super [247] 
.implements [249] 
.implements [251] 
.field private static final [252] [253] 
.field private static final [254] [255] 
.field private volatile [256] [257] 
.field private final [258] [259] 
.field private [260] [261] 
.field private [262] [263] 

.method public [265] : [266] 
    .attribute [264] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [37] 
L7:     aload_0 
L8:     lconst_0 
L9:     putfield [45] 
L12:    aload_0 
L13:    lconst_0 
L14:    putfield [46] 
L17:    aload_0 
L18:    aload_0 
L19:    getfield [26] 
L22:    invokeinterface [47] 0 
L27:    sipush 3878 
L30:    invokeinterface [48] 0 
L35:    putfield [49] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public synchronized [267] : [268] 
    .attribute [264] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [38] 
L5:     aload_0 
L6:     getfield [27] 
L9:     iconst_0 
L10:    sipush 10000 
L13:    iconst_1 
L14:    invokeinterface [50] 0 
L19:    aload_0 
L20:    aload_0 
L21:    invokespecial [39] 
L24:    putfield [51] 
L27:    aload_0 
L28:    iconst_0 
L29:    invokespecial [36] 
L32:    aload_1 
L33:    invokevirtual [29] 
L36:    aload_0 
L37:    invokeinterface [52] 0 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [269] : [270] 
    .attribute [264] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     getfield [28] 
L8:     invokevirtual [30] 
L11:    pop 
L12:    aload_0 
L13:    iconst_0 
L14:    invokespecial [36] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private synchronized [271] : [272] 
    .attribute [264] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [24] 
L12:    invokevirtual [31] 
L15:    pop 
L16:    aload_0 
L17:    getfield [24] 
L20:    invokestatic [5] 
L23:    ifeq L54 
L26:    aload_0 
L27:    iconst_0 
L28:    invokespecial [36] 
L31:    aload_0 
L32:    aload_0 
L33:    getfield [26] 
L36:    invokeinterface [53] 0 
L41:    putfield [46] 
L44:    aload_0 
L45:    getfield [28] 
L48:    invokevirtual [32] 
L51:    goto L67 
L54:    aload_0 
L55:    getfield [23] 
L58:    sipush 10000 
L61:    ldc [6] 
L63:    invokevirtual [33] 
L66:    pop 
L67:    return 
L68:    
    .end code 
.end method 

.method private synchronized [273] : [274] 
    .attribute [264] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    getfield [28] 
L16:    invokevirtual [30] 
L19:    pop 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [275] : [276] 
    .attribute [264] .code stack 7 locals 1 
L0:     new [54] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [41] 
L8:     astore_1 
L9:     new [55] 
L12:    dup 
L13:    ldc [10] 
L15:    ldc_w [1] 
L18:    iconst_0 
L19:    aload_1 
L20:    invokespecial [42] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method private synchronized [277] : [278] 
    .attribute [264] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [34] 
L7:     ifeq L35 
L10:    iload_1 
L11:    bipush 100 
L13:    imul 
L14:    sipush 10000 
L17:    idiv 
L18:    istore_2 
L19:    aload_0 
L20:    getfield [23] 
L23:    ldc [3] 
L25:    ldc [11] 
L27:    iload_1 
L28:    i2l 
L29:    iload_2 
L30:    i2l 
L31:    invokevirtual [35] 
L34:    pop 
L35:    aload_0 
L36:    getfield [27] 
L39:    iload_1 
L40:    invokeinterface [56] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private static [279] : [280] 
    .attribute [264] .code stack 4 locals 0 
L0:     lload_0 
L1:     lconst_0 
L2:     lcmp 
L3:     ifle L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public enum [281] : [282] 
    .attribute [264] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [283] : [284] 
    .attribute [264] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [3] 
L6:     ldc [12] 
L8:     lload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    aload_0 
L14:    getfield [24] 
L17:    lload_1 
L18:    lcmp 
L19:    ifeq L50 
L22:    lload_1 
L23:    invokestatic [5] 
L26:    ifeq L37 
L29:    aload_0 
L30:    lload_1 
L31:    putfield [45] 
L34:    goto L50 
L37:    aload_0 
L38:    getfield [23] 
L41:    sipush 10000 
L44:    ldc [13] 
L46:    invokevirtual [33] 
L49:    pop 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [264] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [3] 
L6:     ldc [14] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    invokespecial [43] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [287] : [288] 
    .attribute [264] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [3] 
L6:     ldc [14] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    invokespecial [44] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [289] : [290] 
    .attribute [264] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [291] : [292] 
    .attribute [264] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [293] : [294] 
    .attribute [264] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [295] : [296] 
    .attribute [264] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [36] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [297] : [298] 
    .attribute [264] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [58] 
.const [3] = Int -2137614336 
.const [4] = String [59] 
.const [5] = Method [60] [61] 
.const [6] = String [62] 
.const [7] = String [63] 
.const [8] = Class [64] 
.const [9] = Class [65] 
.const [10] = String [66] 
.const [11] = String [67] 
.const [12] = String [68] 
.const [13] = String [69] 
.const [14] = String [70] 
.const [15] = Class [71] 
.const [16] = Class [72] 
.const [17] = Class [73] 
.const [18] = Class [74] 
.const [19] = Class [75] 
.const [20] = Class [76] 
.const [21] = Class [77] 
.const [22] = Class [78] 
.const [23] = Field [79] [80] 
.const [24] = Field [81] [82] 
.const [25] = Field [83] [84] 
.const [26] = Field [85] [86] 
.const [27] = Field [87] [88] 
.const [28] = Field [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Method [113] [114] 
.const [41] = Method [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Field [123] [124] 
.const [46] = Field [125] [126] 
.const [47] = InterfaceMethod [127] [128] 
.const [48] = InterfaceMethod [129] [130] 
.const [49] = Field [131] [132] 
.const [50] = InterfaceMethod [133] [134] 
.const [51] = Field [135] [136] 
.const [52] = InterfaceMethod [137] [138] 
.const [53] = InterfaceMethod [139] [140] 
.const [54] = Class [141] 
.const [55] = Class [142] 
.const [56] = InterfaceMethod [143] [144] 
.const [57] = Int 1677721600 
.const [58] = Utf8 'App.SDS.Dictation' 
.const [59] = Utf8 '[RecordingProgressBarController#recordingStarted] dictationMaxDuration = %1' 
.const [60] = Class [145] 
.const [61] = NameAndType [146] [147] 
.const [62] = Utf8 '[RecordingProgressBarController#recordingStarted] Unsuitable maximum duration, ignoring call.' 
.const [63] = Utf8 '[RecordingProgressBarController#recordingFinished]' 
.const [64] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [65] = Utf8 de/audi/atip/timer/Timer 
.const [66] = Utf8 '[RecordingProgressBarControllerTimer]' 
.const [67] = Utf8 '[RecordingProgressBarController#setProgress] progress = %1 (%2%)' 
.const [68] = Utf8 '[RecordingProgressBarController#updateDictationMaxDuration] dictationMaxDuration = %1' 
.const [69] = Utf8 '[RecordingProgressBarController#updateDictationMaxDuration] Unsuitable maximum duration, ignoring call.' 
.const [70] = Utf8 '[RecordingProgressBarController#indicateRecordingStarted]' 
.const [71] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [72] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [73] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [74] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [75] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [76] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [77] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateManager 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Class [175] 
.const [98] = NameAndType [176] [177] 
.const [99] = Class [178] 
.const [100] = NameAndType [179] [180] 
.const [101] = Class [181] 
.const [102] = NameAndType [182] [183] 
.const [103] = Class [184] 
.const [104] = NameAndType [185] [186] 
.const [105] = Class [187] 
.const [106] = NameAndType [188] [189] 
.const [107] = Class [190] 
.const [108] = NameAndType [191] [192] 
.const [109] = Class [193] 
.const [110] = NameAndType [194] [195] 
.const [111] = Class [196] 
.const [112] = NameAndType [197] [198] 
.const [113] = Class [199] 
.const [114] = NameAndType [200] [201] 
.const [115] = Class [202] 
.const [116] = NameAndType [203] [204] 
.const [117] = Class [205] 
.const [118] = NameAndType [206] [207] 
.const [119] = Class [208] 
.const [120] = NameAndType [209] [210] 
.const [121] = Class [211] 
.const [122] = NameAndType [212] [213] 
.const [123] = Class [214] 
.const [124] = NameAndType [215] [216] 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Class [220] 
.const [128] = NameAndType [221] [222] 
.const [129] = Class [223] 
.const [130] = NameAndType [224] [225] 
.const [131] = Class [226] 
.const [132] = NameAndType [227] [228] 
.const [133] = Class [229] 
.const [134] = NameAndType [230] [231] 
.const [135] = Class [232] 
.const [136] = NameAndType [233] [234] 
.const [137] = Class [235] 
.const [138] = NameAndType [236] [237] 
.const [139] = Class [238] 
.const [140] = NameAndType [239] [240] 
.const [141] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [142] = Utf8 de/audi/atip/timer/Timer 
.const [143] = Class [241] 
.const [144] = NameAndType [242] [243] 
.const [145] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [146] = Utf8 isValidDictationMaxDuration 
.const [147] = Utf8 (J)Z 
.const [148] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [149] = Utf8 log 
.const [150] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [152] = Utf8 dictationMaxDuration 
.const [153] = Utf8 J 
.const [154] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [155] = Utf8 startTime 
.const [156] = Utf8 J 
.const [157] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [158] = Utf8 framework 
.const [159] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [160] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [161] = Utf8 dictationProgressRange 
.const [162] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [163] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [164] = Utf8 timer 
.const [165] = Utf8 Lde/audi/atip/timer/Timer; 
.const [166] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [167] = Utf8 getDictationStateManager 
.const [168] = Utf8 ()Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateManager; 
.const [169] = Utf8 de/audi/atip/timer/Timer 
.const [170] = Utf8 cancel 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;J)Z 
.const [175] = Utf8 de/audi/atip/timer/Timer 
.const [176] = Utf8 start 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/audi/atip/log/LogChannel 
.const [179] = Utf8 log 
.const [180] = Utf8 (ILjava/lang/String;)Z 
.const [181] = Utf8 de/audi/atip/log/LogChannel 
.const [182] = Utf8 isDebug 
.const [183] = Utf8 ()Z 
.const [184] = Utf8 de/audi/atip/log/LogChannel 
.const [185] = Utf8 log 
.const [186] = Utf8 (ILjava/lang/String;JJ)Z 
.const [187] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [188] = Utf8 setProgress 
.const [189] = Utf8 (I)V 
.const [190] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;Ljava/lang/String;)V 
.const [193] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [194] = Utf8 init 
.const [195] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [196] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [197] = Utf8 createTimer 
.const [198] = Utf8 ()Lde/audi/atip/timer/Timer; 
.const [199] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [200] = Utf8 dispose 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)V 
.const [205] = Utf8 de/audi/atip/timer/Timer 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [208] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [209] = Utf8 recordingStarted 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [212] = Utf8 recordingFinished 
.const [213] = Utf8 ()V 
.const [214] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [215] = Utf8 dictationMaxDuration 
.const [216] = Utf8 J 
.const [217] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [218] = Utf8 startTime 
.const [219] = Utf8 J 
.const [220] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [221] = Utf8 getHmiServiceApp 
.const [222] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [223] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [224] = Utf8 getRangeModel 
.const [225] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [226] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [227] = Utf8 dictationProgressRange 
.const [228] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [229] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [230] = Utf8 setLimits 
.const [231] = Utf8 (III)V 
.const [232] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [233] = Utf8 timer 
.const [234] = Utf8 Lde/audi/atip/timer/Timer; 
.const [235] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateManager 
.const [236] = Utf8 addObserver 
.const [237] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver;)V 
.const [238] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [239] = Utf8 getMonotonicTime 
.const [240] = Utf8 ()J 
.const [241] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [242] = Utf8 setValue 
.const [243] = Utf8 (I)V 
.const [244] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [245] = Class [244] 
.const [246] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [247] = Class [246] 
.const [248] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/IRecordingProgressBarController 
.const [249] = Class [248] 
.const [250] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver 
.const [251] = Class [250] 
.const [252] = Utf8 UPDATE_INTERVAL 
.const [253] = Utf8 J 
.const [254] = Utf8 PROGRESS_BAR_MAX_VALUE 
.const [255] = Utf8 I 
.const [256] = Utf8 dictationMaxDuration 
.const [257] = Utf8 J 
.const [258] = Utf8 dictationProgressRange 
.const [259] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [260] = Utf8 timer 
.const [261] = Utf8 Lde/audi/atip/timer/Timer; 
.const [262] = Utf8 startTime 
.const [263] = Utf8 J 
.const [264] = Utf8 Code 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;)V 
.const [267] = Utf8 init 
.const [268] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [269] = Utf8 dispose 
.const [270] = Utf8 ()V 
.const [271] = Utf8 recordingStarted 
.const [272] = Utf8 ()V 
.const [273] = Utf8 recordingFinished 
.const [274] = Utf8 ()V 
.const [275] = Utf8 createTimer 
.const [276] = Utf8 ()Lde/audi/atip/timer/Timer; 
.const [277] = Utf8 setProgress 
.const [278] = Utf8 (I)V 
.const [279] = Utf8 isValidDictationMaxDuration 
.const [280] = Utf8 (J)Z 
.const [281] = Utf8 updateDictationState 
.const [282] = Utf8 (I)V 
.const [283] = Utf8 updateDictationMaxDuration 
.const [284] = Utf8 (J)V 
.const [285] = Utf8 indicateRecordingStarted 
.const [286] = Utf8 ()V 
.const [287] = Utf8 indicateRecordingStopped 
.const [288] = Utf8 ()V 
.const [289] = Utf8 access$000 
.const [290] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)Lde/audi/atip/base/IFrameworkAccess; 
.const [291] = Utf8 access$100 
.const [292] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)J 
.const [293] = Utf8 access$200 
.const [294] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)J 
.const [295] = Utf8 access$300 
.const [296] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;I)V 
.const [297] = Utf8 access$400 
.const [298] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)Lde/audi/atip/log/LogChannel; 
.end class 
