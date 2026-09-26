.version 50 0 
.class public super abstract [156] 
.super [158] 
.implements [160] 
.field private [161] [162] 
.field private final [163] [164] 
.field private final [165] [166] 
.field private final [167] [168] 
.field private [169] [170] 

.method public [172] : [173] 
    .attribute [171] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     getstatic [2] 
L8:     putfield [29] 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [30] 
L16:    aload_0 
L17:    sipush 1000 
L20:    invokestatic [3] 
L23:    imul 
L24:    putfield [31] 
L27:    aload_0 
L28:    sipush 1000 
L31:    invokestatic [4] 
L34:    imul 
L35:    putfield [32] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [171] .code stack 2 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L13 using L16 
L4:     aload_0 
L5:     getstatic [2] 
L8:     putfield [29] 
L11:    aload_1 
L12:    monitorexit 
L13:    goto L21 
        .catch [0] from L16 to L19 using L16 
L16:    astore_2 
L17:    aload_1 
L18:    monitorexit 
L19:    aload_2 
L20:    athrow 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [171] .code stack 4 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L32 using L35 
L4:     aload_0 
L5:     new [33] 
L8:     dup 
L9:     aload_1 
L10:    getfield [19] 
L13:    invokespecial [26] 
L16:    putfield [29] 
L19:    aload_0 
L20:    getfield [15] 
L23:    aload_0 
L24:    invokespecial [27] 
L27:    invokevirtual [20] 
L30:    aload_2 
L31:    monitorexit 
L32:    goto L40 
        .catch [0] from L35 to L38 using L35 
L35:    astore_3 
L36:    aload_2 
L37:    monitorexit 
L38:    aload_3 
L39:    athrow 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [178] : [179] 
    .attribute [171] .code stack 2 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L10 using L11 
L4:     aload_0 
L5:     getfield [15] 
L8:     aload_1 
L9:     monitorexit 
L10:    areturn 
        .catch [0] from L11 to L14 using L11 
L11:    astore_2 
L12:    aload_1 
L13:    monitorexit 
L14:    aload_2 
L15:    athrow 
L16:    
    .end code 
.end method 

.method private [180] : [181] 
    .attribute [171] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifeq L12 
L7:     aload_0 
L8:     getfield [18] 
L11:    areturn 
L12:    aload_0 
L13:    getfield [17] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [182] : [183] 
    .attribute [171] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     invokevirtual [22] 
L11:    pop 
L12:    aload_0 
L13:    iconst_1 
L14:    putfield [34] 
L17:    aload_0 
L18:    invokespecial [28] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [171] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [6] 
L6:     ldc [8] 
L8:     invokevirtual [22] 
L11:    pop 
L12:    aload_0 
L13:    iconst_0 
L14:    putfield [34] 
L17:    aload_0 
L18:    invokespecial [28] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [186] : [187] 
    .attribute [171] .code stack 2 locals 3 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     dup 
L4:     astore_2 
L5:     monitorenter 
        .catch [0] from L6 to L27 using L30 
L6:     aload_0 
L7:     getfield [15] 
L10:    aload_0 
L11:    invokespecial [27] 
L14:    invokevirtual [20] 
L17:    aload_0 
L18:    getfield [15] 
L21:    invokevirtual [23] 
L24:    istore_1 
L25:    aload_2 
L26:    monitorexit 
L27:    goto L35 
        .catch [0] from L30 to L33 using L30 
L30:    astore_3 
L31:    aload_2 
L32:    monitorexit 
L33:    aload_3 
L34:    athrow 
L35:    iload_1 
L36:    ifeq L43 
L39:    aload_0 
L40:    invokevirtual [24] 
L43:    return 
L44:    
    .end code 
.end method 

.method protected abstract [188] : [189] 
    .attribute [171] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [35] [36] 
.const [3] = Method [37] [38] 
.const [4] = Method [39] [40] 
.const [5] = Class [41] 
.const [6] = Int -2137614336 
.const [7] = String [42] 
.const [8] = String [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Field [50] [51] 
.const [16] = Field [52] [53] 
.const [17] = Field [54] [55] 
.const [18] = Field [56] [57] 
.const [19] = Field [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Field [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Field [80] [81] 
.const [31] = Field [82] [83] 
.const [32] = Field [84] [85] 
.const [33] = Class [86] 
.const [34] = Field [87] [88] 
.const [35] = Class [89] 
.const [36] = NameAndType [90] [91] 
.const [37] = Class [92] 
.const [38] = NameAndType [93] [94] 
.const [39] = Class [95] 
.const [40] = NameAndType [96] [97] 
.const [41] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [42] = Utf8 'DABSlideShowHandler#exceedsUpperThreshold' 
.const [43] = Utf8 'DABSlideShowHandler#belowLowerThreshold' 
.const [44] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/audi/tuner/ifc/ISimpleTuner 
.const [47] = Utf8 de/audi/tuner/app/Utilities 
.const [48] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Class [98] 
.const [51] = NameAndType [99] [100] 
.const [52] = Class [101] 
.const [53] = NameAndType [102] [103] 
.const [54] = Class [104] 
.const [55] = NameAndType [105] [106] 
.const [56] = Class [107] 
.const [57] = NameAndType [108] [109] 
.const [58] = Class [110] 
.const [59] = NameAndType [111] [112] 
.const [60] = Class [113] 
.const [61] = NameAndType [114] [115] 
.const [62] = Class [116] 
.const [63] = NameAndType [117] [118] 
.const [64] = Class [119] 
.const [65] = NameAndType [120] [121] 
.const [66] = Class [122] 
.const [67] = NameAndType [123] [124] 
.const [68] = Class [125] 
.const [69] = NameAndType [126] [127] 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Class [146] 
.const [83] = NameAndType [147] [148] 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [87] = Class [152] 
.const [88] = NameAndType [153] [154] 
.const [89] = Utf8 de/audi/tuner/ifc/ISimpleTuner 
.const [90] = Utf8 EMPTY_RL 
.const [91] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [92] = Utf8 de/audi/tuner/app/Utilities 
.const [93] = Utf8 getSlideshowDisplayDuration1 
.const [94] = Utf8 ()I 
.const [95] = Utf8 de/audi/tuner/app/Utilities 
.const [96] = Utf8 getSlideshowDisplayDuration2 
.const [97] = Utf8 ()I 
.const [98] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [99] = Utf8 slsImage 
.const [100] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [101] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [102] = Utf8 lc 
.const [103] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [104] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [105] = Utf8 lowerDuration 
.const [106] = Utf8 I 
.const [107] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [108] = Utf8 upperDuration 
.const [109] = Utf8 I 
.const [110] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [111] = Utf8 url 
.const [112] = Utf8 Ljava/lang/String; 
.const [113] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [114] = Utf8 setMinDisplayDuration 
.const [115] = Utf8 (I)V 
.const [116] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [117] = Utf8 speedOverLimit 
.const [118] = Utf8 Z 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;)Z 
.const [122] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [123] = Utf8 containsResourceURI 
.const [124] = Utf8 ()Z 
.const [125] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [126] = Utf8 update 
.const [127] = Utf8 ()V 
.const [128] = Utf8 java/lang/Object 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Ljava/lang/String;)V 
.const [134] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [135] = Utf8 getDuration 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [138] = Utf8 speedChanged 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [141] = Utf8 slsImage 
.const [142] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [143] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [144] = Utf8 lc 
.const [145] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [146] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [147] = Utf8 lowerDuration 
.const [148] = Utf8 I 
.const [149] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [150] = Utf8 upperDuration 
.const [151] = Utf8 I 
.const [152] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [153] = Utf8 speedOverLimit 
.const [154] = Utf8 Z 
.const [155] = Utf8 de/audi/tuner/app/AbstractSlsSpeedManagerBase 
.const [156] = Class [155] 
.const [157] = Utf8 java/lang/Object 
.const [158] = Class [157] 
.const [159] = Utf8 de/audi/atip/sysapp/SpeedThresholdListener 
.const [160] = Class [159] 
.const [161] = Utf8 speedOverLimit 
.const [162] = Utf8 Z 
.const [163] = Utf8 lc 
.const [164] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 lowerDuration 
.const [166] = Utf8 I 
.const [167] = Utf8 upperDuration 
.const [168] = Utf8 I 
.const [169] = Utf8 slsImage 
.const [170] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [171] = Utf8 Code 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [174] = Utf8 clear 
.const [175] = Utf8 ()V 
.const [176] = Utf8 setImage 
.const [177] = Utf8 (Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [178] = Utf8 getSlsImage 
.const [179] = Utf8 ()Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [180] = Utf8 getDuration 
.const [181] = Utf8 ()I 
.const [182] = Utf8 exceedsUpperThreshold 
.const [183] = Utf8 (I)V 
.const [184] = Utf8 belowLowerThreshold 
.const [185] = Utf8 (I)V 
.const [186] = Utf8 speedChanged 
.const [187] = Utf8 ()V 
.const [188] = Utf8 update 
.const [189] = Utf8 ()V 
.end class 
