.version 50 0 
.class public super [134] 
.super [136] 

.method public [138] : [139] 
    .attribute [137] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [25] 
L5:     aload_0 
L6:     ldc [2] 
L8:     invokevirtual [13] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [137] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [14] 
L4:     aload_0 
L5:     getfield [15] 
L8:     ldc [3] 
L10:    ldc [4] 
L12:    invokevirtual [16] 
L15:    pop 
L16:    aload_0 
L17:    getfield [17] 
L20:    iconst_1 
L21:    newarray int 
L23:    dup 
L24:    iconst_0 
L25:    iconst_1 
L26:    iastore 
L27:    invokeinterface [29] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [137] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [18] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [26] 
L19:    iload_1 
L20:    iconst_1 
L21:    if_icmpne L55 
L24:    aload_0 
L25:    getfield [19] 
L28:    new [30] 
L31:    dup 
L32:    invokespecial [27] 
L35:    ldc [7] 
L37:    invokevirtual [20] 
L40:    iload_1 
L41:    invokevirtual [21] 
L44:    invokevirtual [22] 
L47:    invokeinterface [31] 0 
L52:    goto L64 
L55:    iload_1 
L56:    iconst_3 
L57:    if_icmpne L64 
L60:    aload_0 
L61:    invokevirtual [23] 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method protected [144] : [145] 
    .attribute [137] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [24] 
L4:     aload_0 
L5:     invokespecial [28] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [32] 
.const [3] = Int -2137614336 
.const [4] = String [33] 
.const [5] = String [34] 
.const [6] = Class [35] 
.const [7] = String [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Field [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = Class [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = Utf8 WaitUniTunerReadyCmd 
.const [33] = Utf8 '[WaitUniTunerReadyCmd.execute] set notifications' 
.const [34] = Utf8 '[WaitUniTunerReadyCmd.updateDetectedDevice] detectedDevice:%1' 
.const [35] = Utf8 java/lang/StringBuffer 
.const [36] = Utf8 'No Uni-Tuner found! Detected Device = ' 
.const [37] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [38] = Utf8 de/audi/tuner/app/cmd/uni/AbstractUnifiedCmd 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 de/audi/tuner/app/cmd/uni/IUnifiedTuner 
.const [41] = Utf8 de/audi/tghu/command/ICommandList 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [80] = Utf8 setName 
.const [81] = Utf8 (Ljava/lang/String;)V 
.const [82] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [83] = Utf8 logExecuteFirstCmd 
.const [84] = Utf8 ()V 
.const [85] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [86] = Utf8 logger 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;)Z 
.const [91] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [92] = Utf8 unifiedTuner 
.const [93] = Utf8 Lde/audi/tuner/app/cmd/uni/IUnifiedTuner; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;J)Z 
.const [97] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [98] = Utf8 commandList 
.const [99] = Utf8 Lde/audi/tghu/command/ICommandList; 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 append 
.const [102] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 append 
.const [105] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 toString 
.const [108] = Utf8 ()Ljava/lang/String; 
.const [109] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [110] = Utf8 commandFinished 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [113] = Utf8 logFinishFirstCmd 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/tuner/app/cmd/uni/AbstractUnifiedCmd 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (Lde/audi/tuner/app/cmd/uni/AbstractUnifiedCmd$Builder;)V 
.const [118] = Utf8 de/audi/tuner/app/cmd/uni/AbstractUnifiedCmd 
.const [119] = Utf8 updateDetectedDevice 
.const [120] = Utf8 (I)V 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/tuner/app/cmd/uni/AbstractUnifiedCmd 
.const [125] = Utf8 commandFinished 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/tuner/app/cmd/uni/IUnifiedTuner 
.const [128] = Utf8 setNotification 
.const [129] = Utf8 ([I)V 
.const [130] = Utf8 de/audi/tghu/command/ICommandList 
.const [131] = Utf8 stop 
.const [132] = Utf8 (Ljava/lang/String;)V 
.const [133] = Utf8 de/audi/tuner/app/cmd/uni/WaitUniTunerReadyCmd 
.const [134] = Class [133] 
.const [135] = Utf8 de/audi/tuner/app/cmd/uni/AbstractUnifiedCmd 
.const [136] = Class [135] 
.const [137] = Utf8 Code 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Lde/audi/tuner/app/cmd/uni/AbstractUnifiedCmd$Builder;)V 
.const [140] = Utf8 execute 
.const [141] = Utf8 ()V 
.const [142] = Utf8 updateDetectedDevice 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 commandFinished 
.const [145] = Utf8 ()V 
.end class 
