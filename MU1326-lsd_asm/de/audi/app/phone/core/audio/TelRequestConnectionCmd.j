.version 50 0 
.class public super [198] 
.super [200] 
.field static final [201] [202] 
.field static final [203] [204] 
.field static final [205] [206] 
.field private final [207] [208] 
.field private final [209] [210] 

.method static [212] : [213] 
    .attribute [211] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L31 
            L34 
            default : L37 

L28:    ldc [2] 
L30:    areturn 
L31:    ldc [3] 
L33:    areturn 
L34:    ldc [4] 
L36:    areturn 
L37:    ldc [5] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [211] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [44] 
L5:     dup 
L6:     invokespecial [40] 
L9:     ldc [7] 
L11:    invokevirtual [28] 
L14:    iload_2 
L15:    invokevirtual [29] 
L18:    ldc [8] 
L20:    invokevirtual [28] 
L23:    iload 4 
L25:    invokestatic [9] 
L28:    invokevirtual [28] 
L31:    invokevirtual [30] 
L34:    aload_3 
L35:    invokespecial [41] 
L38:    aload_0 
L39:    iload_2 
L40:    putfield [45] 
L43:    aload_0 
L44:    iload 4 
L46:    putfield [46] 
L49:    aload_3 
L50:    ifnonnull L63 
L53:    new [47] 
L56:    dup 
L57:    ldc [11] 
L59:    invokespecial [42] 
L62:    athrow 
L63:    return 
L64:    
    .end code 
.end method 

.method public [216] : [217] 
    .attribute [211] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     ifne L49 
L7:     aload_0 
L8:     getfield [33] 
L11:    ldc [12] 
L13:    ldc [13] 
L15:    aload_0 
L16:    getfield [31] 
L19:    i2l 
L20:    invokevirtual [34] 
L23:    pop 
L24:    aload_0 
L25:    getfield [35] 
L28:    aload_0 
L29:    getfield [31] 
L32:    invokeinterface [48] 0 
L37:    aload_0 
L38:    invokevirtual [36] 
L41:    invokeinterface [49] 0 
L46:    goto L86 
L49:    aload_0 
L50:    getfield [33] 
L53:    ldc [12] 
L55:    ldc [14] 
L57:    aload_0 
L58:    getfield [32] 
L61:    invokestatic [9] 
L64:    aload_0 
L65:    getfield [31] 
L68:    i2l 
L69:    invokevirtual [37] 
L72:    pop 
L73:    aload_0 
L74:    getfield [35] 
L77:    aload_0 
L78:    getfield [31] 
L81:    invokeinterface [48] 0 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [218] : [219] 
    .attribute [211] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [31] 
L5:     if_icmpne L31 
L8:     aload_0 
L9:     getfield [33] 
L12:    ldc [12] 
L14:    ldc [15] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [34] 
L21:    pop 
L22:    aload_0 
L23:    invokevirtual [36] 
L26:    invokeinterface [49] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [211] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [31] 
L5:     if_icmpne L38 
L8:     iload_1 
L9:     invokestatic [16] 
L12:    ifeq L38 
L15:    aload_0 
L16:    getfield [33] 
L19:    ldc [12] 
L21:    ldc [17] 
L23:    iload_1 
L24:    i2l 
L25:    invokevirtual [34] 
L28:    pop 
L29:    aload_0 
L30:    invokevirtual [36] 
L33:    invokeinterface [49] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [222] : [223] 
    .attribute [211] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [31] 
L5:     if_icmpne L70 
L8:     aload_0 
L9:     iload_1 
L10:    iload_2 
L11:    invokespecial [43] 
L14:    aload_0 
L15:    getfield [32] 
L18:    iconst_2 
L19:    if_icmpne L49 
L22:    aload_0 
L23:    getfield [33] 
L26:    ldc [12] 
L28:    ldc [18] 
L30:    iload_1 
L31:    i2l 
L32:    invokevirtual [34] 
L35:    pop 
L36:    aload_0 
L37:    getfield [35] 
L40:    iload_1 
L41:    invokeinterface [50] 0 
L46:    goto L70 
L49:    aload_0 
L50:    getfield [33] 
L53:    ldc [12] 
L55:    ldc [19] 
L57:    invokevirtual [38] 
L60:    pop 
L61:    aload_0 
L62:    invokevirtual [36] 
L65:    invokeinterface [49] 0 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [211] .code stack 9 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [31] 
L5:     if_icmpne L35 
L8:     aload_0 
L9:     getfield [33] 
L12:    ldc [12] 
L14:    ldc [20] 
L16:    iload_1 
L17:    i2l 
L18:    iload_2 
L19:    i2l 
L20:    iload_3 
L21:    i2l 
L22:    invokevirtual [39] 
L25:    pop 
L26:    aload_0 
L27:    invokevirtual [36] 
L30:    invokeinterface [49] 0 
L35:    return 
L36:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [211] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [31] 
L5:     if_icmpne L31 
L8:     aload_0 
L9:     getfield [33] 
L12:    ldc [12] 
L14:    ldc [21] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [34] 
L21:    pop 
L22:    aload_0 
L23:    invokevirtual [36] 
L26:    invokeinterface [49] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method private [228] : [229] 
    .attribute [211] .code stack 5 locals 0 
L0:     iload_1 
L1:     bipush 106 
L3:     if_icmpne L20 
L6:     aload_0 
L7:     getfield [35] 
L10:    iload_1 
L11:    iload_2 
L12:    iconst_1 
L13:    ldc [22] 
L15:    invokeinterface [51] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private static [230] : [231] 
    .attribute [211] .code stack 2 locals 0 
L0:     iload_0 
L1:     bipush 106 
L3:     if_icmpeq L12 
L6:     iload_0 
L7:     bipush 102 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [52] 
.const [3] = String [53] 
.const [4] = String [54] 
.const [5] = String [55] 
.const [6] = Class [56] 
.const [7] = String [57] 
.const [8] = String [58] 
.const [9] = Method [59] [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = Int 1078071040 
.const [13] = String [63] 
.const [14] = String [64] 
.const [15] = String [65] 
.const [16] = Method [66] [67] 
.const [17] = String [68] 
.const [18] = String [69] 
.const [19] = String [70] 
.const [20] = String [71] 
.const [21] = String [72] 
.const [22] = String [73] 
.const [23] = Class [74] 
.const [24] = Class [75] 
.const [25] = Class [76] 
.const [26] = Class [77] 
.const [27] = Class [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Field [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = Field [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Field [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Method [97] [98] 
.const [38] = Method [99] [100] 
.const [39] = Method [101] [102] 
.const [40] = Method [103] [104] 
.const [41] = Method [105] [106] 
.const [42] = Method [107] [108] 
.const [43] = Method [109] [110] 
.const [44] = Class [111] 
.const [45] = Field [112] [113] 
.const [46] = Field [114] [115] 
.const [47] = Class [116] 
.const [48] = InterfaceMethod [117] [118] 
.const [49] = InterfaceMethod [119] [120] 
.const [50] = InterfaceMethod [121] [122] 
.const [51] = InterfaceMethod [123] [124] 
.const [52] = Utf8 FINISH_TRIGGER_REQUEST 
.const [53] = Utf8 FINISH_TRIGGER_START 
.const [54] = Utf8 FINISH_TRIGGER_FADED_IN 
.const [55] = Utf8 UNKNOWN_TRIGGER 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 'TelRequestConnectionCmd: ' 
.const [58] = Utf8 ', finishTrigger: ' 
.const [59] = Class [125] 
.const [60] = NameAndType [126] [127] 
.const [61] = Utf8 java/lang/IllegalArgumentException 
.const [62] = Utf8 'TelRequestConnectionCmd#init: audioService is null' 
.const [63] = Utf8 '[TelRequestConnectionCmd#execute] requesting connection %1' 
.const [64] = Utf8 '[TelRequestConnectionCmd#execute] requesting connection %2, waiting for %1' 
.const [65] = Utf8 '[TelRequestConnectionCmd#stopConnection] connection=%1, finish command' 
.const [66] = Class [128] 
.const [67] = NameAndType [129] [130] 
.const [68] = Utf8 '[TelRequestConnectionCmd#pauseConnection] MUTE connection=%1' 
.const [69] = Utf8 '[TelRequestConnectionCmd#startConnection] fading in to connection=%1' 
.const [70] = Utf8 '[TelRequestConnectionCmd#startConnection] finishing' 
.const [71] = Utf8 '[TelRequestConnectionCmd#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3' 
.const [72] = Utf8 '[TelRequestConnectionCmd#fadedIn] connection=%1' 
.const [73] = Utf8 'PhoneHMI.setVolumeLock(true) for BT Downlink' 
.const [74] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [75] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmd 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [78] = Utf8 de/audi/tghu/command/ICommandList 
.const [79] = Class [131] 
.const [80] = NameAndType [132] [133] 
.const [81] = Class [134] 
.const [82] = NameAndType [135] [136] 
.const [83] = Class [137] 
.const [84] = NameAndType [138] [139] 
.const [85] = Class [140] 
.const [86] = NameAndType [141] [142] 
.const [87] = Class [143] 
.const [88] = NameAndType [144] [145] 
.const [89] = Class [146] 
.const [90] = NameAndType [147] [148] 
.const [91] = Class [149] 
.const [92] = NameAndType [150] [151] 
.const [93] = Class [152] 
.const [94] = NameAndType [153] [154] 
.const [95] = Class [155] 
.const [96] = NameAndType [156] [157] 
.const [97] = Class [158] 
.const [98] = NameAndType [159] [160] 
.const [99] = Class [161] 
.const [100] = NameAndType [162] [163] 
.const [101] = Class [164] 
.const [102] = NameAndType [165] [166] 
.const [103] = Class [167] 
.const [104] = NameAndType [168] [169] 
.const [105] = Class [170] 
.const [106] = NameAndType [171] [172] 
.const [107] = Class [173] 
.const [108] = NameAndType [174] [175] 
.const [109] = Class [176] 
.const [110] = NameAndType [177] [178] 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Class [179] 
.const [113] = NameAndType [180] [181] 
.const [114] = Class [182] 
.const [115] = NameAndType [183] [184] 
.const [116] = Utf8 java/lang/IllegalArgumentException 
.const [117] = Class [185] 
.const [118] = NameAndType [186] [187] 
.const [119] = Class [188] 
.const [120] = NameAndType [189] [190] 
.const [121] = Class [191] 
.const [122] = NameAndType [192] [193] 
.const [123] = Class [194] 
.const [124] = NameAndType [195] [196] 
.const [125] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [126] = Utf8 getFinishTriggerName 
.const [127] = Utf8 (I)Ljava/lang/String; 
.const [128] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [129] = Utf8 isSomeMuteConnection 
.const [130] = Utf8 (I)Z 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 append 
.const [133] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [134] = Utf8 java/lang/StringBuffer 
.const [135] = Utf8 append 
.const [136] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 toString 
.const [139] = Utf8 ()Ljava/lang/String; 
.const [140] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [141] = Utf8 connection 
.const [142] = Utf8 I 
.const [143] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [144] = Utf8 finishTrigger 
.const [145] = Utf8 I 
.const [146] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [147] = Utf8 logger 
.const [148] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;J)Z 
.const [152] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [153] = Utf8 audioService 
.const [154] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [155] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [156] = Utf8 getCommandList 
.const [157] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [158] = Utf8 de/audi/atip/log/LogChannel 
.const [159] = Utf8 log 
.const [160] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [161] = Utf8 de/audi/atip/log/LogChannel 
.const [162] = Utf8 log 
.const [163] = Utf8 (ILjava/lang/String;)Z 
.const [164] = Utf8 de/audi/atip/log/LogChannel 
.const [165] = Utf8 log 
.const [166] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [167] = Utf8 java/lang/StringBuffer 
.const [168] = Utf8 <init> 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmd 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/atip/audio/HMIAudioService;)V 
.const [173] = Utf8 java/lang/IllegalArgumentException 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Ljava/lang/String;)V 
.const [176] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [177] = Utf8 checkEnableVolumeLockForBTDownlink 
.const [178] = Utf8 (II)V 
.const [179] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [180] = Utf8 connection 
.const [181] = Utf8 I 
.const [182] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [183] = Utf8 finishTrigger 
.const [184] = Utf8 I 
.const [185] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [186] = Utf8 requestConnection 
.const [187] = Utf8 (I)V 
.const [188] = Utf8 de/audi/tghu/command/ICommandList 
.const [189] = Utf8 commandFinished 
.const [190] = Utf8 ()V 
.const [191] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [192] = Utf8 fadeToConnection 
.const [193] = Utf8 (I)V 
.const [194] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [195] = Utf8 setVolumelock 
.const [196] = Utf8 (IIZLjava/lang/Object;)V 
.const [197] = Utf8 de/audi/app/phone/core/audio/TelRequestConnectionCmd 
.const [198] = Class [197] 
.const [199] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmd 
.const [200] = Class [199] 
.const [201] = Utf8 FINISH_TRIGGER_REQUEST 
.const [202] = Utf8 I 
.const [203] = Utf8 FINISH_TRIGGER_START 
.const [204] = Utf8 I 
.const [205] = Utf8 FINISH_TRIGGER_FADED_IN 
.const [206] = Utf8 I 
.const [207] = Utf8 connection 
.const [208] = Utf8 I 
.const [209] = Utf8 finishTrigger 
.const [210] = Utf8 I 
.const [211] = Utf8 Code 
.const [212] = Utf8 getFinishTriggerName 
.const [213] = Utf8 (I)Ljava/lang/String; 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;I)V 
.const [216] = Utf8 execute 
.const [217] = Utf8 ()V 
.const [218] = Utf8 stopConnection 
.const [219] = Utf8 (II)V 
.const [220] = Utf8 pauseConnection 
.const [221] = Utf8 (II)V 
.const [222] = Utf8 startConnection 
.const [223] = Utf8 (II)V 
.const [224] = Utf8 errorConnection 
.const [225] = Utf8 (III)V 
.const [226] = Utf8 fadedIn 
.const [227] = Utf8 (II)V 
.const [228] = Utf8 checkEnableVolumeLockForBTDownlink 
.const [229] = Utf8 (II)V 
.const [230] = Utf8 isSomeMuteConnection 
.const [231] = Utf8 (I)Z 
.end class 
