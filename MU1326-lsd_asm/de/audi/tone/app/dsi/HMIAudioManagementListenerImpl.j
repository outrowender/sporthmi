.version 50 0 
.class public super [135] 
.super [137] 
.implements [139] 
.field private final [140] [141] 
.field private final [142] [143] 
.field private volatile [144] [145] 

.method public [147] : [148] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     new [30] 
L8:     dup 
L9:     invokespecial [28] 
L12:    putfield [31] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [32] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [146] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    aload_1 
L12:    invokevirtual [20] 
L15:    pop 
L16:    aload_1 
L17:    aload_0 
L18:    getfield [21] 
L21:    invokeinterface [33] 0 
L26:    aload_0 
L27:    getfield [17] 
L30:    aload_1 
L31:    invokevirtual [22] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     ldc [3] 
L9:     ldc [5] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [23] 
L18:    pop 
L19:    aload_0 
L20:    iload_1 
L21:    iconst_0 
L22:    iload_2 
L23:    invokespecial [29] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [146] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     ldc [3] 
L9:     ldc [6] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [23] 
L18:    pop 
L19:    aload_0 
L20:    iload_1 
L21:    iconst_2 
L22:    iload_2 
L23:    invokespecial [29] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [146] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     ldc [3] 
L9:     ldc [7] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [23] 
L18:    pop 
L19:    aload_0 
L20:    iload_1 
L21:    iconst_4 
L22:    iload_2 
L23:    invokespecial [29] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [146] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     ldc [3] 
L9:     ldc [8] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [23] 
L18:    pop 
L19:    aload_0 
L20:    iload_1 
L21:    iconst_5 
L22:    iload_2 
L23:    invokespecial [29] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [146] .code stack 9 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     sipush 10000 
L10:    ldc [9] 
L12:    iload_1 
L13:    i2l 
L14:    iload_2 
L15:    i2l 
L16:    iload_3 
L17:    i2l 
L18:    invokevirtual [24] 
L21:    pop 
L22:    aload_0 
L23:    iload_1 
L24:    iconst_5 
L25:    iload_2 
L26:    invokespecial [29] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [146] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     getfield [19] 
L7:     ldc [10] 
L9:     ldc [11] 
L11:    iload_1 
L12:    invokevirtual [25] 
L15:    pop 
L16:    aload_0 
L17:    getfield [17] 
L20:    invokevirtual [26] 
L23:    astore_2 
L24:    iconst_0 
L25:    istore_3 
L26:    iload_3 
L27:    aload_2 
L28:    arraylength 
L29:    if_icmpge L47 
L32:    aload_2 
L33:    iload_3 
L34:    aaload 
L35:    iload_1 
L36:    invokeinterface [33] 0 
L41:    iinc 3 1 
L44:    goto L26 
L47:    return 
L48:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [146] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [26] 
L7:     astore 4 
L9:     iconst_0 
L10:    istore 5 
L12:    iload 5 
L14:    aload 4 
L16:    arraylength 
L17:    if_icmpge L39 
L20:    aload 4 
L22:    iload 5 
L24:    aaload 
L25:    iload_1 
L26:    iload_2 
L27:    iload_3 
L28:    invokeinterface [34] 0 
L33:    iinc 5 1 
L36:    goto L12 
L39:    return 
L40:    
    .end code 
.end method 

.method public enum [165] : [166] 
    .attribute [146] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Int -2137614336 
.const [4] = String [36] 
.const [5] = String [37] 
.const [6] = String [38] 
.const [7] = String [39] 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = Int 1078071040 
.const [11] = String [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Field [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Class [74] 
.const [31] = Field [75] [76] 
.const [32] = Field [77] [78] 
.const [33] = InterfaceMethod [79] [80] 
.const [34] = InterfaceMethod [81] [82] 
.const [35] = Utf8 de/audi/tone/app/intra/AppAudioListeners 
.const [36] = Utf8 '[HMIAudioManagementListenerImpl.addAppListener] %1' 
.const [37] = Utf8 '[HMIAudioManagementListenerImpl.fadedIn] HC:%1 HT:%2' 
.const [38] = Utf8 '[HMIAudioManagementListenerImpl.startConnection] HC:%1 HT:%2' 
.const [39] = Utf8 '[HMIAudioManagementListenerImpl.pauseConnection] HC:%1 HT:%2' 
.const [40] = Utf8 '[HMIAudioManagementListenerImpl.stopConnection] HC:%1 HT:%2' 
.const [41] = Utf8 '[HMIAudioManagementListenerImpl.errorConnection] HC:%1 HT:%2 error:%3' 
.const [42] = Utf8 '[HMIAudioManagementListenerImpl.updateAMAvailable] available:%1' 
.const [43] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/audi/tone/app/ToneEnv 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 de/audi/tone/app/intra/IAppAudioListener 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Utf8 de/audi/tone/app/intra/AppAudioListeners 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Class [125] 
.const [78] = NameAndType [126] [127] 
.const [79] = Class [128] 
.const [80] = NameAndType [129] [130] 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [84] = Utf8 listeners 
.const [85] = Utf8 Lde/audi/tone/app/intra/AppAudioListeners; 
.const [86] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [87] = Utf8 env 
.const [88] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [89] = Utf8 de/audi/tone/app/ToneEnv 
.const [90] = Utf8 lcMain 
.const [91] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 log 
.const [94] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [95] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [96] = Utf8 amAvailable 
.const [97] = Utf8 Z 
.const [98] = Utf8 de/audi/tone/app/intra/AppAudioListeners 
.const [99] = Utf8 add 
.const [100] = Utf8 (Lde/audi/tone/app/intra/IAppAudioListener;)V 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;JJ)Z 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 log 
.const [109] = Utf8 (ILjava/lang/String;Z)Z 
.const [110] = Utf8 de/audi/tone/app/intra/AppAudioListeners 
.const [111] = Utf8 toArray 
.const [112] = Utf8 ()[Lde/audi/tone/app/intra/IAppAudioListener; 
.const [113] = Utf8 java/lang/Object 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/tone/app/intra/AppAudioListeners 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [120] = Utf8 broadcastConnectionStatus 
.const [121] = Utf8 (III)V 
.const [122] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [123] = Utf8 listeners 
.const [124] = Utf8 Lde/audi/tone/app/intra/AppAudioListeners; 
.const [125] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [126] = Utf8 env 
.const [127] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [128] = Utf8 de/audi/tone/app/intra/IAppAudioListener 
.const [129] = Utf8 updateAMAvailable 
.const [130] = Utf8 (Z)V 
.const [131] = Utf8 de/audi/tone/app/intra/IAppAudioListener 
.const [132] = Utf8 updateConnectionStatus 
.const [133] = Utf8 (III)V 
.const [134] = Utf8 de/audi/tone/app/dsi/HMIAudioManagementListenerImpl 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 de/audi/atip/audio/HMIAudioServiceListener 
.const [139] = Class [138] 
.const [140] = Utf8 env 
.const [141] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [142] = Utf8 listeners 
.const [143] = Utf8 Lde/audi/tone/app/intra/AppAudioListeners; 
.const [144] = Utf8 amAvailable 
.const [145] = Utf8 Z 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Lde/audi/tone/app/ToneEnv;)V 
.const [149] = Utf8 addAppListener 
.const [150] = Utf8 (Lde/audi/tone/app/intra/IAppAudioListener;)V 
.const [151] = Utf8 fadedIn 
.const [152] = Utf8 (II)V 
.const [153] = Utf8 startConnection 
.const [154] = Utf8 (II)V 
.const [155] = Utf8 pauseConnection 
.const [156] = Utf8 (II)V 
.const [157] = Utf8 stopConnection 
.const [158] = Utf8 (II)V 
.const [159] = Utf8 errorConnection 
.const [160] = Utf8 (III)V 
.const [161] = Utf8 updateAMAvailable 
.const [162] = Utf8 (Z)V 
.const [163] = Utf8 broadcastConnectionStatus 
.const [164] = Utf8 (III)V 
.const [165] = Utf8 updateVolumeLock 
.const [166] = Utf8 (IIZ)V 
.end class 
