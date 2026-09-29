.version 50 0 
.class public final super [143] 
.super [145] 
.implements [147] 
.field private static final [148] [149] 
.field private final [150] [151] 
.field private final [152] [153] 
.field private final [154] [155] 
.field private final [156] [157] 
.field private volatile [158] [159] 

.method public [161] : [162] 
    .attribute [160] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     new [27] 
L8:     dup 
L9:     invokespecial [24] 
L12:    putfield [28] 
L15:    aload_0 
L16:    new [29] 
L19:    dup 
L20:    ldc [4] 
L22:    ldc_w [1] 
L25:    iconst_1 
L26:    aload_0 
L27:    invokespecial [25] 
L30:    putfield [30] 
L33:    aload_0 
L34:    aconst_null 
L35:    putfield [31] 
L38:    aload_0 
L39:    aload_1 
L40:    putfield [32] 
L43:    aload_0 
L44:    aload_2 
L45:    putfield [33] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [160] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [18] 
L7:     ifeq L35 
L10:    aload_0 
L11:    getfield [13] 
L14:    dup 
L15:    astore_2 
L16:    monitorenter 
        .catch [0] from L17 to L24 using L27 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [31] 
L22:    aload_2 
L23:    monitorexit 
L24:    goto L32 
        .catch [0] from L27 to L30 using L27 
L27:    astore_3 
L28:    aload_2 
L29:    monitorexit 
L30:    aload_3 
L31:    athrow 
L32:    goto L40 
L35:    aload_0 
L36:    aload_1 
L37:    invokespecial [26] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [160] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokevirtual [19] 
L7:     ldc [5] 
L9:     ldc [6] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    aconst_null 
L16:    astore_2 
L17:    aload_0 
L18:    getfield [13] 
L21:    dup 
L22:    astore_3 
L23:    monitorenter 
        .catch [0] from L24 to L43 using L46 
L24:    aload_0 
L25:    getfield [15] 
L28:    ifnull L41 
L31:    aload_0 
L32:    getfield [15] 
L35:    astore_2 
L36:    aload_0 
L37:    aconst_null 
L38:    putfield [31] 
L41:    aload_3 
L42:    monitorexit 
L43:    goto L53 
        .catch [0] from L46 to L50 using L46 
L46:    astore 4 
L48:    aload_3 
L49:    monitorexit 
L50:    aload 4 
L52:    athrow 
L53:    aload_2 
L54:    ifnull L62 
L57:    aload_0 
L58:    aload_2 
L59:    invokespecial [26] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public enum [167] : [168] 
    .attribute [160] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [169] : [170] 
    .attribute [160] .code stack 3 locals 0 
L0:     aload_1 
L1:     checkcast [7] 
L4:     getfield [21] 
L7:     bipush 53 
L9:     if_icmpne L34 
L12:    aload_0 
L13:    getfield [16] 
L16:    invokevirtual [19] 
L19:    ldc [5] 
L21:    ldc [8] 
L23:    invokevirtual [20] 
L26:    pop 
L27:    aload_0 
L28:    getfield [14] 
L31:    invokevirtual [22] 
L34:    aload_0 
L35:    getfield [17] 
L38:    aload_1 
L39:    invokevirtual [23] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = String [37] 
.const [5] = Int -2137614336 
.const [6] = String [38] 
.const [7] = Class [39] 
.const [8] = String [40] 
.const [9] = Class [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Field [45] [46] 
.const [14] = Field [47] [48] 
.const [15] = Field [49] [50] 
.const [16] = Field [51] [52] 
.const [17] = Field [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Field [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Class [73] 
.const [28] = Field [74] [75] 
.const [29] = Class [76] 
.const [30] = Field [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Field [83] [84] 
.const [34] = Int -1207238656 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 de/audi/atip/timer/Timer 
.const [37] = Utf8 infoStateTimer 
.const [38] = Utf8 '[BAPPropertyInfoStatesWithOverCurrentSupport#fireTimer] restoring InfoStates before Overcurrent' 
.const [39] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/InfoStates_Status 
.const [40] = Utf8 '[BAPPropertyInfoStatesWithOverCurrentSupport#statusREQAndStartTimerIfNeeded] Sending Overcurrent InfoStates' 
.const [41] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [42] = Utf8 de/audi/app/combi/bap/app/audio/CombiModuleAudio 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [45] = Class [85] 
.const [46] = NameAndType [86] [87] 
.const [47] = Class [88] 
.const [48] = NameAndType [89] [90] 
.const [49] = Class [91] 
.const [50] = NameAndType [92] [93] 
.const [51] = Class [94] 
.const [52] = NameAndType [95] [96] 
.const [53] = Class [97] 
.const [54] = NameAndType [98] [99] 
.const [55] = Class [100] 
.const [56] = NameAndType [101] [102] 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Class [121] 
.const [70] = NameAndType [122] [123] 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Utf8 java/lang/Object 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Utf8 de/audi/atip/timer/Timer 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Class [133] 
.const [80] = NameAndType [134] [135] 
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Class [139] 
.const [84] = NameAndType [140] [141] 
.const [85] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [86] = Utf8 mutex 
.const [87] = Utf8 Ljava/lang/Object; 
.const [88] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [89] = Utf8 infoStateMediatorTimer 
.const [90] = Utf8 Lde/audi/atip/timer/Timer; 
.const [91] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [92] = Utf8 statusPending 
.const [93] = Utf8 Lde/vw/mib/bap/requests/StatusProperty; 
.const [94] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [95] = Utf8 combiModuleAudio 
.const [96] = Utf8 Lde/audi/app/combi/bap/app/audio/CombiModuleAudio; 
.const [97] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [98] = Utf8 infoStateProperty 
.const [99] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [100] = Utf8 de/audi/atip/timer/Timer 
.const [101] = Utf8 isRunning 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 de/audi/app/combi/bap/app/audio/CombiModuleAudio 
.const [104] = Utf8 getLogChannel 
.const [105] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;)Z 
.const [109] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/InfoStates_Status 
.const [110] = Utf8 states 
.const [111] = Utf8 I 
.const [112] = Utf8 de/audi/atip/timer/Timer 
.const [113] = Utf8 restart 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [116] = Utf8 sendStatusIfChanged 
.const [117] = Utf8 (Lde/vw/mib/bap/requests/StatusProperty;)V 
.const [118] = Utf8 java/lang/Object 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/audi/atip/timer/Timer 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [124] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [125] = Utf8 statusREQAndStartTimerIfNeeded 
.const [126] = Utf8 (Lde/vw/mib/bap/requests/StatusProperty;)V 
.const [127] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [128] = Utf8 mutex 
.const [129] = Utf8 Ljava/lang/Object; 
.const [130] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [131] = Utf8 infoStateMediatorTimer 
.const [132] = Utf8 Lde/audi/atip/timer/Timer; 
.const [133] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [134] = Utf8 statusPending 
.const [135] = Utf8 Lde/vw/mib/bap/requests/StatusProperty; 
.const [136] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [137] = Utf8 combiModuleAudio 
.const [138] = Utf8 Lde/audi/app/combi/bap/app/audio/CombiModuleAudio; 
.const [139] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [140] = Utf8 infoStateProperty 
.const [141] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [142] = Utf8 de/audi/app/combi/bap/app/audio/BAPPropertyInfoStatesWithOverCurrentSupport 
.const [143] = Class [142] 
.const [144] = Utf8 java/lang/Object 
.const [145] = Class [144] 
.const [146] = Utf8 de/audi/atip/timer/TimerListener 
.const [147] = Class [146] 
.const [148] = Utf8 OVER_CURRENT_MIN_DISPLAY_TIME_MILLI_SECONDS 
.const [149] = Utf8 I 
.const [150] = Utf8 combiModuleAudio 
.const [151] = Utf8 Lde/audi/app/combi/bap/app/audio/CombiModuleAudio; 
.const [152] = Utf8 infoStateProperty 
.const [153] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [154] = Utf8 mutex 
.const [155] = Utf8 Ljava/lang/Object; 
.const [156] = Utf8 infoStateMediatorTimer 
.const [157] = Utf8 Lde/audi/atip/timer/Timer; 
.const [158] = Utf8 statusPending 
.const [159] = Utf8 Lde/vw/mib/bap/requests/StatusProperty; 
.const [160] = Utf8 Code 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/audi/app/combi/bap/app/audio/CombiModuleAudio;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;)V 
.const [163] = Utf8 statusREQ 
.const [164] = Utf8 (Lde/vw/mib/bap/requests/StatusProperty;)V 
.const [165] = Utf8 fireTimer 
.const [166] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [167] = Utf8 cancelTimer 
.const [168] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [169] = Utf8 statusREQAndStartTimerIfNeeded 
.const [170] = Utf8 (Lde/vw/mib/bap/requests/StatusProperty;)V 
.end class 
