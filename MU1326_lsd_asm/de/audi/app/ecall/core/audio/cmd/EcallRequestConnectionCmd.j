.version 50 0 
.class super [135] 
.super [137] 
.field static final [138] [139] 
.field static final [140] [141] 
.field private final [142] [143] 
.field private final [144] [145] 

.method static [147] : [148] 
    .attribute [146] .code stack 1 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            0 : L28 
            1 : L31 
            default : L34 

L28:    ldc [2] 
L30:    areturn 
L31:    ldc [3] 
L33:    areturn 
L34:    ldc [4] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method [149] : [150] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokespecial [29] 
L6:     aload_0 
L7:     iload_2 
L8:     putfield [31] 
L11:    aload_0 
L12:    iload 4 
L14:    putfield [32] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iconst_1 
L5:     if_icmpne L16 
L8:     aload_0 
L9:     invokespecial [30] 
L12:    ifeq L16 
L15:    return 
L16:    aload_0 
L17:    getfield [23] 
L20:    ldc [5] 
L22:    ldc [6] 
L24:    aload_0 
L25:    getfield [21] 
L28:    i2l 
L29:    invokevirtual [24] 
L32:    pop 
L33:    aload_0 
L34:    getfield [25] 
L37:    aload_0 
L38:    getfield [21] 
L41:    invokeinterface [33] 0 
L46:    aload_0 
L47:    getfield [22] 
L50:    ifne L62 
L53:    aload_0 
L54:    invokevirtual [26] 
L57:    invokeinterface [34] 0 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [146] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [21] 
L5:     if_icmpne L31 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [5] 
L14:    ldc [7] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [24] 
L21:    pop 
L22:    aload_0 
L23:    invokevirtual [26] 
L26:    invokeinterface [34] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [146] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [21] 
L5:     if_icmpne L22 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [5] 
L14:    ldc [8] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [24] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [146] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [21] 
L5:     if_icmpne L64 
L8:     aload_0 
L9:     getfield [22] 
L12:    iconst_1 
L13:    if_icmpne L43 
L16:    aload_0 
L17:    getfield [23] 
L20:    ldc [5] 
L22:    ldc [9] 
L24:    iload_1 
L25:    i2l 
L26:    invokevirtual [24] 
L29:    pop 
L30:    aload_0 
L31:    getfield [25] 
L34:    iload_1 
L35:    invokeinterface [35] 0 
L40:    goto L64 
L43:    aload_0 
L44:    getfield [23] 
L47:    ldc [5] 
L49:    ldc [10] 
L51:    invokevirtual [27] 
L54:    pop 
L55:    aload_0 
L56:    invokevirtual [26] 
L59:    invokeinterface [34] 0 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [146] .code stack 9 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [21] 
L5:     if_icmpne L35 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [11] 
L14:    ldc [12] 
L16:    iload_1 
L17:    i2l 
L18:    iload_2 
L19:    i2l 
L20:    iload_3 
L21:    i2l 
L22:    invokevirtual [28] 
L25:    pop 
L26:    aload_0 
L27:    invokevirtual [26] 
L30:    invokeinterface [34] 0 
L35:    return 
L36:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [146] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [21] 
L5:     if_icmpne L31 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [5] 
L14:    ldc [13] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [24] 
L21:    pop 
L22:    aload_0 
L23:    invokevirtual [26] 
L26:    invokeinterface [34] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [146] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [25] 
L4:     aload_0 
L5:     getfield [21] 
L8:     invokeinterface [36] 0 
L13:    istore_1 
L14:    iload_1 
L15:    ifeq L23 
L18:    iload_1 
L19:    iconst_1 
L20:    if_icmpne L51 
L23:    aload_0 
L24:    getfield [23] 
L27:    ldc [5] 
L29:    ldc [14] 
L31:    aload_0 
L32:    getfield [21] 
L35:    i2l 
L36:    invokevirtual [24] 
L39:    pop 
L40:    aload_0 
L41:    invokevirtual [26] 
L44:    invokeinterface [34] 0 
L49:    iconst_1 
L50:    areturn 
L51:    iload_1 
L52:    iconst_2 
L53:    if_icmpne L88 
L56:    aload_0 
L57:    getfield [23] 
L60:    ldc [5] 
L62:    ldc [15] 
L64:    aload_0 
L65:    getfield [21] 
L68:    i2l 
L69:    invokevirtual [24] 
L72:    pop 
L73:    aload_0 
L74:    getfield [25] 
L77:    aload_0 
L78:    getfield [21] 
L81:    invokeinterface [35] 0 
L86:    iconst_1 
L87:    areturn 
L88:    iconst_0 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [37] 
.const [3] = String [38] 
.const [4] = String [39] 
.const [5] = Int 1078071040 
.const [6] = String [40] 
.const [7] = String [41] 
.const [8] = String [42] 
.const [9] = String [43] 
.const [10] = String [44] 
.const [11] = Int -2137614336 
.const [12] = String [45] 
.const [13] = String [46] 
.const [14] = String [47] 
.const [15] = String [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Class [51] 
.const [19] = Class [52] 
.const [20] = Class [53] 
.const [21] = Field [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Field [62] [63] 
.const [26] = Method [64] [65] 
.const [27] = Method [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = Method [70] [71] 
.const [30] = Method [72] [73] 
.const [31] = Field [74] [75] 
.const [32] = Field [76] [77] 
.const [33] = InterfaceMethod [78] [79] 
.const [34] = InterfaceMethod [80] [81] 
.const [35] = InterfaceMethod [82] [83] 
.const [36] = InterfaceMethod [84] [85] 
.const [37] = Utf8 FINISH_TRIGGER_REQUEST 
.const [38] = Utf8 FINISH_TRIGGER_FADED_IN 
.const [39] = Utf8 UNKNOWN_TRIGGER 
.const [40] = Utf8 'EcallRequestConnectionCmd#execute(): requesting connection %1' 
.const [41] = Utf8 '[EcallRequestConnectionCmd#stopConnection] connection=%1' 
.const [42] = Utf8 '[EcallRequestConnectionCmd#pauseConnection] connection=%1' 
.const [43] = Utf8 '[EcallRequestConnectionCmd#startConnection] fading in to connection=%1' 
.const [44] = Utf8 '[EcallRequestConnectionCmd#startConnection] finishing' 
.const [45] = Utf8 '[EcallRequestConnectionCmd#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3' 
.const [46] = Utf8 '[EcallRequestConnectionCmd#fadedIn] connection=%1' 
.const [47] = Utf8 '[EcallRequestConnectionCmd#avoidRequestConnection] connection=%1 already faded in, finish command!' 
.const [48] = Utf8 '[EcallRequestConnectionCmd#avoidRequestConnection] connection=%1 already started, fading in!' 
.const [49] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [50] = Utf8 de/audi/app/ecall/core/audio/cmd/AbstractEcallAudioCmd 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [53] = Utf8 de/audi/tghu/command/ICommandList 
.const [54] = Class [86] 
.const [55] = NameAndType [87] [88] 
.const [56] = Class [89] 
.const [57] = NameAndType [90] [91] 
.const [58] = Class [92] 
.const [59] = NameAndType [93] [94] 
.const [60] = Class [95] 
.const [61] = NameAndType [96] [97] 
.const [62] = Class [98] 
.const [63] = NameAndType [99] [100] 
.const [64] = Class [101] 
.const [65] = NameAndType [102] [103] 
.const [66] = Class [104] 
.const [67] = NameAndType [105] [106] 
.const [68] = Class [107] 
.const [69] = NameAndType [108] [109] 
.const [70] = Class [110] 
.const [71] = NameAndType [111] [112] 
.const [72] = Class [113] 
.const [73] = NameAndType [114] [115] 
.const [74] = Class [116] 
.const [75] = NameAndType [117] [118] 
.const [76] = Class [119] 
.const [77] = NameAndType [120] [121] 
.const [78] = Class [122] 
.const [79] = NameAndType [123] [124] 
.const [80] = Class [125] 
.const [81] = NameAndType [126] [127] 
.const [82] = Class [128] 
.const [83] = NameAndType [129] [130] 
.const [84] = Class [131] 
.const [85] = NameAndType [132] [133] 
.const [86] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [87] = Utf8 connection 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [90] = Utf8 finishTrigger 
.const [91] = Utf8 I 
.const [92] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [93] = Utf8 logger 
.const [94] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 log 
.const [97] = Utf8 (ILjava/lang/String;J)Z 
.const [98] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [99] = Utf8 audioService 
.const [100] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [101] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [102] = Utf8 getCommandList 
.const [103] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;)Z 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 log 
.const [109] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [110] = Utf8 de/audi/app/ecall/core/audio/cmd/AbstractEcallAudioCmd 
.const [111] = Utf8 <init> 
.const [112] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/audio/HMIAudioService;)V 
.const [113] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [114] = Utf8 skipRequestConnection 
.const [115] = Utf8 ()Z 
.const [116] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [117] = Utf8 connection 
.const [118] = Utf8 I 
.const [119] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [120] = Utf8 finishTrigger 
.const [121] = Utf8 I 
.const [122] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [123] = Utf8 requestConnection 
.const [124] = Utf8 (I)V 
.const [125] = Utf8 de/audi/tghu/command/ICommandList 
.const [126] = Utf8 commandFinished 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [129] = Utf8 fadeToConnection 
.const [130] = Utf8 (I)V 
.const [131] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [132] = Utf8 getStatus 
.const [133] = Utf8 (I)I 
.const [134] = Utf8 de/audi/app/ecall/core/audio/cmd/EcallRequestConnectionCmd 
.const [135] = Class [134] 
.const [136] = Utf8 de/audi/app/ecall/core/audio/cmd/AbstractEcallAudioCmd 
.const [137] = Class [136] 
.const [138] = Utf8 FINISH_TRIGGER_REQUEST 
.const [139] = Utf8 I 
.const [140] = Utf8 FINISH_TRIGGER_FADED_IN 
.const [141] = Utf8 I 
.const [142] = Utf8 finishTrigger 
.const [143] = Utf8 I 
.const [144] = Utf8 connection 
.const [145] = Utf8 I 
.const [146] = Utf8 Code 
.const [147] = Utf8 getFinishTriggerName 
.const [148] = Utf8 (I)Ljava/lang/String; 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;I)V 
.const [151] = Utf8 execute 
.const [152] = Utf8 ()V 
.const [153] = Utf8 stopConnection 
.const [154] = Utf8 (II)V 
.const [155] = Utf8 pauseConnection 
.const [156] = Utf8 (II)V 
.const [157] = Utf8 startConnection 
.const [158] = Utf8 (II)V 
.const [159] = Utf8 errorConnection 
.const [160] = Utf8 (III)V 
.const [161] = Utf8 fadedIn 
.const [162] = Utf8 (II)V 
.const [163] = Utf8 skipRequestConnection 
.const [164] = Utf8 ()Z 
.end class 
