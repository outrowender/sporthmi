.version 50 0 
.class public super [184] 
.super [186] 
.field private final [187] [188] 

.method [190] : [191] 
    .attribute [189] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [38] 
L5:     dup 
L6:     invokespecial [33] 
L9:     ldc [3] 
L11:    invokevirtual [19] 
L14:    iload_2 
L15:    invokevirtual [20] 
L18:    invokevirtual [21] 
L21:    aload_3 
L22:    invokespecial [34] 
L25:    aload_0 
L26:    iload_2 
L27:    putfield [39] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [192] : [193] 
    .attribute [189] .code stack 4 locals 3 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [22] 
L5:     invokespecial [35] 
L8:     istore_1 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [22] 
L14:    invokespecial [35] 
L17:    iconst_5 
L18:    if_icmpne L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    istore_2 
L27:    aload_0 
L28:    getfield [23] 
L31:    invokevirtual [24] 
L34:    ifeq L109 
L37:    new [40] 
L40:    dup 
L41:    invokespecial [36] 
L44:    astore_3 
L45:    aload_3 
L46:    ldc [5] 
L48:    invokevirtual [25] 
L51:    pop 
L52:    aload_3 
L53:    aload_0 
L54:    getfield [22] 
L57:    invokevirtual [26] 
L60:    pop 
L61:    aload_3 
L62:    ldc [6] 
L64:    invokevirtual [25] 
L67:    pop 
L68:    aload_3 
L69:    aload_0 
L70:    iload_1 
L71:    invokevirtual [27] 
L74:    invokevirtual [25] 
L77:    pop 
L78:    aload_3 
L79:    ldc [7] 
L81:    invokevirtual [25] 
L84:    pop 
L85:    iload_2 
L86:    ifne L96 
L89:    aload_3 
L90:    ldc [8] 
L92:    invokevirtual [25] 
L95:    pop 
L96:    aload_0 
L97:    getfield [23] 
L100:   ldc [9] 
L102:   ldc [10] 
L104:   aload_3 
L105:   invokevirtual [28] 
L108:   pop 
L109:   aload_0 
L110:   getfield [29] 
L113:   aload_0 
L114:   getfield [22] 
L117:   invokeinterface [41] 0 
L122:   iload_2 
L123:   ifeq L135 
L126:   aload_0 
L127:   invokevirtual [30] 
L130:   invokeinterface [42] 0 
L135:   return 
L136:   
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [189] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [22] 
L5:     if_icmpne L37 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [9] 
L14:    ldc [11] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [31] 
L21:    pop 
L22:    aload_0 
L23:    iload_1 
L24:    iload_2 
L25:    invokespecial [37] 
L28:    aload_0 
L29:    invokevirtual [30] 
L32:    invokeinterface [42] 0 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [189] .code stack 7 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [22] 
L5:     if_icmpne L39 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [9] 
L14:    ldc [12] 
L16:    iload_1 
L17:    i2l 
L18:    iload_3 
L19:    i2l 
L20:    invokevirtual [32] 
L23:    pop 
L24:    aload_0 
L25:    iload_1 
L26:    iload_2 
L27:    invokespecial [37] 
L30:    aload_0 
L31:    invokevirtual [30] 
L34:    invokeinterface [42] 0 
L39:    return 
L40:    
    .end code 
.end method 

.method private [198] : [199] 
    .attribute [189] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ifnull L18 
L7:     aload_0 
L8:     getfield [29] 
L11:    iload_1 
L12:    invokeinterface [43] 0 
L17:    areturn 
L18:    iconst_m1 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private [200] : [201] 
    .attribute [189] .code stack 5 locals 0 
L0:     iload_1 
L1:     bipush 106 
L3:     if_icmpne L20 
L6:     aload_0 
L7:     getfield [29] 
L10:    iload_1 
L11:    iload_2 
L12:    iconst_0 
L13:    ldc [13] 
L15:    invokeinterface [44] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [45] 
.const [3] = String [46] 
.const [4] = Class [47] 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = String [50] 
.const [8] = String [51] 
.const [9] = Int 1078071040 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = String [54] 
.const [13] = String [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Field [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Field [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Method [97] [98] 
.const [38] = Class [99] 
.const [39] = Field [100] [101] 
.const [40] = Class [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = InterfaceMethod [105] [106] 
.const [43] = InterfaceMethod [107] [108] 
.const [44] = InterfaceMethod [109] [110] 
.const [45] = Utf8 java/lang/StringBuffer 
.const [46] = Utf8 'TelReleaseConnectionCmd: ' 
.const [47] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [48] = Utf8 'releasing AC:' 
.const [49] = Utf8 ' (' 
.const [50] = Utf8 ')' 
.const [51] = Utf8 ' --> waiting for stopConnection' 
.const [52] = Utf8 '[TelReleaseConnectionCmd#execute] %1' 
.const [53] = Utf8 '[TelReleaseConnectionCmd#stopConnection] AC:%1' 
.const [54] = Utf8 '[TelReleaseConnectionCmd#stopConnection] AC:%1, errorCode:%2' 
.const [55] = Utf8 'PhoneHMI.setVolumeLock(false) for BT Downlink' 
.const [56] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [57] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmd 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [60] = Utf8 de/audi/tghu/command/ICommandList 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Class [126] 
.const [72] = NameAndType [127] [128] 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Class [144] 
.const [84] = NameAndType [145] [146] 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Class [150] 
.const [88] = NameAndType [151] [152] 
.const [89] = Class [153] 
.const [90] = NameAndType [154] [155] 
.const [91] = Class [156] 
.const [92] = NameAndType [157] [158] 
.const [93] = Class [159] 
.const [94] = NameAndType [160] [161] 
.const [95] = Class [162] 
.const [96] = NameAndType [163] [164] 
.const [97] = Class [165] 
.const [98] = NameAndType [166] [167] 
.const [99] = Utf8 java/lang/StringBuffer 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Class [174] 
.const [106] = NameAndType [175] [176] 
.const [107] = Class [177] 
.const [108] = NameAndType [178] [179] 
.const [109] = Class [180] 
.const [110] = NameAndType [181] [182] 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 append 
.const [113] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 toString 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [121] = Utf8 connection 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [124] = Utf8 logger 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 de/audi/atip/log/LogChannel 
.const [127] = Utf8 isInfo 
.const [128] = Utf8 ()Z 
.const [129] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [132] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [135] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [136] = Utf8 getConnectionStatusName 
.const [137] = Utf8 (I)Ljava/lang/String; 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [141] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [142] = Utf8 audioService 
.const [143] = Utf8 Lde/audi/atip/audio/HMIAudioService; 
.const [144] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [145] = Utf8 getCommandList 
.const [146] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;J)Z 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;JJ)Z 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmd 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/atip/audio/HMIAudioService;)V 
.const [159] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [160] = Utf8 getConnectionStatus 
.const [161] = Utf8 (I)I 
.const [162] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [166] = Utf8 checkDisableVolumeLockForBTDownlink 
.const [167] = Utf8 (II)V 
.const [168] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [169] = Utf8 connection 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [172] = Utf8 releaseConnection 
.const [173] = Utf8 (I)V 
.const [174] = Utf8 de/audi/tghu/command/ICommandList 
.const [175] = Utf8 commandFinished 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [178] = Utf8 getStatus 
.const [179] = Utf8 (I)I 
.const [180] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [181] = Utf8 setVolumelock 
.const [182] = Utf8 (IIZLjava/lang/Object;)V 
.const [183] = Utf8 de/audi/app/phone/core/audio/TelReleaseConnectionCmd 
.const [184] = Class [183] 
.const [185] = Utf8 de/audi/app/phone/core/audio/AbstractTelAudioCmd 
.const [186] = Class [185] 
.const [187] = Utf8 connection 
.const [188] = Utf8 I 
.const [189] = Utf8 Code 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lde/audi/atip/log/LogChannel;ILde/audi/atip/audio/HMIAudioService;)V 
.const [192] = Utf8 execute 
.const [193] = Utf8 ()V 
.const [194] = Utf8 stopConnection 
.const [195] = Utf8 (II)V 
.const [196] = Utf8 errorConnection 
.const [197] = Utf8 (III)V 
.const [198] = Utf8 getConnectionStatus 
.const [199] = Utf8 (I)I 
.const [200] = Utf8 checkDisableVolumeLockForBTDownlink 
.const [201] = Utf8 (II)V 
.end class 
