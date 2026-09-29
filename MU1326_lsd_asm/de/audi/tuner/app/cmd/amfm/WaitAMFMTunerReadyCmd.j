.version 50 0 
.class public super [140] 
.super [142] 
.field private [143] [144] 
.field private final [145] [146] 
.field private [147] [148] 

.method public [150] : [151] 
    .attribute [149] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_3 
L2:     invokespecial [22] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [27] 
L10:    aload_0 
L11:    iload_1 
L12:    ifeq L19 
L15:    iconst_0 
L16:    goto L20 
L19:    iconst_2 
L20:    putfield [28] 
L23:    aload_0 
L24:    iload_2 
L25:    putfield [29] 
L28:    aload_0 
L29:    ldc [2] 
L31:    invokevirtual [14] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [149] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     aload_0 
L5:     getfield [16] 
L8:     ldc [3] 
L10:    ldc [4] 
L12:    invokevirtual [17] 
L15:    pop 
L16:    aload_0 
L17:    getfield [18] 
L20:    iconst_2 
L21:    newarray int 
L23:    dup 
L24:    iconst_0 
L25:    bipush 10 
L27:    iastore 
L28:    dup 
L29:    iconst_1 
L30:    bipush 18 
L32:    iastore 
L33:    invokeinterface [30] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [154] : [155] 
    .attribute [149] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     aload_0 
L5:     invokespecial [23] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [149] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [20] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [24] 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [27] 
L24:    aload_0 
L25:    invokespecial [25] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [149] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [6] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [20] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [26] 
L19:    aload_0 
L20:    iload_1 
L21:    putfield [28] 
L24:    aload_0 
L25:    invokespecial [25] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [160] : [161] 
    .attribute [149] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_4 
L5:     if_icmpeq L23 
L8:     aload_0 
L9:     getfield [13] 
L12:    ifne L35 
L15:    aload_0 
L16:    getfield [11] 
L19:    iconst_3 
L20:    if_icmpne L35 
L23:    aload_0 
L24:    getfield [12] 
L27:    iconst_2 
L28:    if_icmpne L35 
L31:    aload_0 
L32:    invokevirtual [21] 
L35:    return 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [31] 
.const [3] = Int -2137614336 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Field [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Field [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = InterfaceMethod [77] [78] 
.const [31] = Utf8 WaitAMFMTunerReadyCmd 
.const [32] = Utf8 '[WaitAMFMTunerReadyCmd.execute] set notifications' 
.const [33] = Utf8 '[WaitAMFMTunerReadyCmd.updateDetectedDevice] detectedDevice:%1' 
.const [34] = Utf8 '[WaitAMFMTunerReadyCmd.updateAvailability] availability:%1' 
.const [35] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [36] = Utf8 de/audi/tuner/app/cmd/amfm/AbstractAMFMCmd 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 de/audi/tuner/ifc/IAMFMTuner 
.const [39] = Class [79] 
.const [40] = NameAndType [80] [81] 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Class [85] 
.const [44] = NameAndType [86] [87] 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Class [91] 
.const [48] = NameAndType [92] [93] 
.const [49] = Class [94] 
.const [50] = NameAndType [95] [96] 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Class [112] 
.const [62] = NameAndType [113] [114] 
.const [63] = Class [115] 
.const [64] = NameAndType [116] [117] 
.const [65] = Class [118] 
.const [66] = NameAndType [119] [120] 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [80] = Utf8 detectedDevice 
.const [81] = Utf8 I 
.const [82] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [83] = Utf8 availability 
.const [84] = Utf8 I 
.const [85] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [86] = Utf8 hdTuner 
.const [87] = Utf8 Z 
.const [88] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [89] = Utf8 setName 
.const [90] = Utf8 (Ljava/lang/String;)V 
.const [91] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [92] = Utf8 logExecuteFirstCmd 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [95] = Utf8 logger 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;)Z 
.const [100] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [101] = Utf8 tuner 
.const [102] = Utf8 Lde/audi/tuner/ifc/IAMFMTuner; 
.const [103] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [104] = Utf8 logFinishFirstCmd 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;J)Z 
.const [109] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [110] = Utf8 commandFinished 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/tuner/app/cmd/amfm/AbstractAMFMCmd 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/audi/tuner/app/cmd/amfm/AbstractAMFMCmd$Builder;)V 
.const [115] = Utf8 de/audi/tuner/app/cmd/amfm/AbstractAMFMCmd 
.const [116] = Utf8 commandFinished 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/audi/tuner/app/cmd/amfm/AbstractAMFMCmd 
.const [119] = Utf8 updateDetectedDevice 
.const [120] = Utf8 (I)V 
.const [121] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [122] = Utf8 checkFinished 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/tuner/app/cmd/amfm/AbstractAMFMCmd 
.const [125] = Utf8 updateAvailability 
.const [126] = Utf8 (I)V 
.const [127] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [128] = Utf8 detectedDevice 
.const [129] = Utf8 I 
.const [130] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [131] = Utf8 availability 
.const [132] = Utf8 I 
.const [133] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [134] = Utf8 hdTuner 
.const [135] = Utf8 Z 
.const [136] = Utf8 de/audi/tuner/ifc/IAMFMTuner 
.const [137] = Utf8 setNotification 
.const [138] = Utf8 ([I)V 
.const [139] = Utf8 de/audi/tuner/app/cmd/amfm/WaitAMFMTunerReadyCmd 
.const [140] = Class [139] 
.const [141] = Utf8 de/audi/tuner/app/cmd/amfm/AbstractAMFMCmd 
.const [142] = Class [141] 
.const [143] = Utf8 availability 
.const [144] = Utf8 I 
.const [145] = Utf8 hdTuner 
.const [146] = Utf8 Z 
.const [147] = Utf8 detectedDevice 
.const [148] = Utf8 I 
.const [149] = Utf8 Code 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (ZZLde/audi/tuner/app/cmd/amfm/AbstractAMFMCmd$Builder;)V 
.const [152] = Utf8 execute 
.const [153] = Utf8 ()V 
.const [154] = Utf8 commandFinished 
.const [155] = Utf8 ()V 
.const [156] = Utf8 updateDetectedDevice 
.const [157] = Utf8 (I)V 
.const [158] = Utf8 updateAvailability 
.const [159] = Utf8 (I)V 
.const [160] = Utf8 checkFinished 
.const [161] = Utf8 ()V 
.end class 
