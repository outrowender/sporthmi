.version 50 0 
.class public super [166] 
.super [168] 
.implements [170] 
.field private [171] [172] 
.field private [173] [174] 
.field private [175] [176] 
.field private final [177] [178] 
.field private [179] [180] 
.field private static [181] [182] 

.method public [184] : [185] 
    .attribute [183] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield [32] 
L9:     getstatic [2] 
L12:    ldc [3] 
L14:    ldc [4] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [21] 
L21:    pop 
L22:    aload_0 
L23:    iload_1 
L24:    putfield [33] 
L27:    aload_0 
L28:    iload_1 
L29:    putfield [34] 
L32:    aload_0 
L33:    getstatic [5] 
L36:    invokeinterface [35] 0 
L41:    putfield [36] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [183] .code stack 3 locals 0 
L0:     invokestatic [6] 
L3:     ifeq L23 
L6:     aload_0 
L7:     getfield [24] 
L10:    ifeq L18 
L13:    aload_0 
L14:    getfield [23] 
L17:    areturn 
L18:    aload_0 
L19:    getfield [22] 
L22:    areturn 
L23:    getstatic [2] 
L26:    ldc [3] 
L28:    ldc [7] 
L30:    invokevirtual [25] 
L33:    pop 
L34:    aload_0 
L35:    getfield [23] 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [183] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [3] 
L5:     ldc [8] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [21] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [33] 
L18:    aload_0 
L19:    iconst_1 
L20:    putfield [37] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [183] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [3] 
L5:     ldc [9] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [21] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [34] 
L18:    aload_0 
L19:    getfield [26] 
L22:    ifne L48 
L25:    getstatic [2] 
L28:    ldc [3] 
L30:    ldc [10] 
L32:    iload_1 
L33:    i2l 
L34:    invokevirtual [21] 
L37:    pop 
L38:    aload_0 
L39:    iload_1 
L40:    putfield [33] 
L43:    aload_0 
L44:    iconst_1 
L45:    putfield [37] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public interface [192] : [193] 
    .attribute [183] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [183] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     iconst_m1 
L5:     if_icmpeq L25 
L8:     aload_0 
L9:     invokevirtual [27] 
L12:    aload_0 
L13:    invokevirtual [28] 
L16:    if_icmpeq L23 
L19:    iconst_1 
L20:    goto L24 
L23:    iconst_0 
L24:    areturn 
L25:    aload_0 
L26:    invokevirtual [29] 
L29:    aload_0 
L30:    invokevirtual [28] 
L33:    if_icmpeq L40 
L36:    iconst_1 
L37:    goto L41 
L40:    iconst_0 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [196] : [197] 
    .attribute [183] .code stack 1 locals 0 
L0:     getstatic [11] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public static [198] : [199] 
    .attribute [183] .code stack 1 locals 0 
L0:     iload_0 
L1:     putstatic [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [200] : [201] 
    .attribute [183] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [183] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [32] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [204] : [205] 
    .attribute [183] .code stack 2 locals 0 
L0:     ldc [12] 
L2:     iconst_1 
L3:     invokestatic [13] 
L6:     putstatic [31] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [38] [39] 
.const [3] = Int 1078071040 
.const [4] = String [40] 
.const [5] = Field [41] [42] 
.const [6] = Method [43] [44] 
.const [7] = String [45] 
.const [8] = String [46] 
.const [9] = String [47] 
.const [10] = String [48] 
.const [11] = Field [49] [50] 
.const [12] = String [51] 
.const [13] = Method [52] [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Field [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Field [64] [65] 
.const [23] = Field [66] [67] 
.const [24] = Field [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Field [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Field [82] [83] 
.const [32] = Field [84] [85] 
.const [33] = Field [86] [87] 
.const [34] = Field [88] [89] 
.const [35] = InterfaceMethod [90] [91] 
.const [36] = Field [92] [93] 
.const [37] = Field [94] [95] 
.const [38] = Class [96] 
.const [39] = NameAndType [97] [98] 
.const [40] = Utf8 'ViewSizeHistoryManager#constructor initializing with view size %1' 
.const [41] = Class [99] 
.const [42] = NameAndType [100] [101] 
.const [43] = Class [102] 
.const [44] = NameAndType [103] [104] 
.const [45] = Utf8 'ViewSizeHistoryManager#getPreferredViewSize Automatic view size change is disabled.' 
.const [46] = Utf8 'ViewSizeHistoryManager#setPreferredViewSize preferred view size: %1' 
.const [47] = Utf8 'ViewSizeHistoryManager#setCurrentViewSize setting current view size to %1' 
.const [48] = Utf8 'ViewSizeHistoryManager#setCurrentViewSize setting initial preferred view size to %1' 
.const [49] = Class [105] 
.const [50] = NameAndType [106] [107] 
.const [51] = Utf8 EnableAutomaticViewSizeChange 
.const [52] = Class [108] 
.const [53] = NameAndType [109] [110] 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [58] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/base/SystemProperties 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [97] = Utf8 logViewSize 
.const [98] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [99] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [100] = Utf8 framework 
.const [101] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [102] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [103] = Utf8 isActive 
.const [104] = Utf8 ()Z 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [106] = Utf8 isActive 
.const [107] = Utf8 Z 
.const [108] = Utf8 de/esolutions/hmi/widgets/audi/base/SystemProperties 
.const [109] = Utf8 getBoolean 
.const [110] = Utf8 (Ljava/lang/String;Z)Z 
.const [111] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [112] = Utf8 requestedViewSize 
.const [113] = Utf8 I 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;J)Z 
.const [117] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [118] = Utf8 preferredViewSize 
.const [119] = Utf8 I 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [121] = Utf8 currentViewSize 
.const [122] = Utf8 I 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [124] = Utf8 isSimulator 
.const [125] = Utf8 Z 
.const [126] = Utf8 de/audi/atip/log/LogChannel 
.const [127] = Utf8 log 
.const [128] = Utf8 (ILjava/lang/String;)Z 
.const [129] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [130] = Utf8 preferredViewSizeInitialized 
.const [131] = Utf8 Z 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [133] = Utf8 getRequestedViewSize 
.const [134] = Utf8 ()I 
.const [135] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [136] = Utf8 getPreferredViewSize 
.const [137] = Utf8 ()I 
.const [138] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [139] = Utf8 getCurrentViewSize 
.const [140] = Utf8 ()I 
.const [141] = Utf8 java/lang/Object 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [145] = Utf8 isActive 
.const [146] = Utf8 Z 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [148] = Utf8 requestedViewSize 
.const [149] = Utf8 I 
.const [150] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [151] = Utf8 preferredViewSize 
.const [152] = Utf8 I 
.const [153] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [154] = Utf8 currentViewSize 
.const [155] = Utf8 I 
.const [156] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [157] = Utf8 isSimulator 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [160] = Utf8 isSimulator 
.const [161] = Utf8 Z 
.const [162] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [163] = Utf8 preferredViewSizeInitialized 
.const [164] = Utf8 Z 
.const [165] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeHistoryManager 
.const [166] = Class [165] 
.const [167] = Utf8 java/lang/Object 
.const [168] = Class [167] 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [170] = Class [169] 
.const [171] = Utf8 preferredViewSize 
.const [172] = Utf8 I 
.const [173] = Utf8 preferredViewSizeInitialized 
.const [174] = Utf8 Z 
.const [175] = Utf8 currentViewSize 
.const [176] = Utf8 I 
.const [177] = Utf8 isSimulator 
.const [178] = Utf8 Z 
.const [179] = Utf8 requestedViewSize 
.const [180] = Utf8 I 
.const [181] = Utf8 isActive 
.const [182] = Utf8 Z 
.const [183] = Utf8 Code 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (I)V 
.const [186] = Utf8 getPreferredViewSize 
.const [187] = Utf8 ()I 
.const [188] = Utf8 setPreferredViewSize 
.const [189] = Utf8 (I)V 
.const [190] = Utf8 setCurrentViewSize 
.const [191] = Utf8 (I)V 
.const [192] = Utf8 getCurrentViewSize 
.const [193] = Utf8 ()I 
.const [194] = Utf8 isHistoryStateChangeRequired 
.const [195] = Utf8 ()Z 
.const [196] = Utf8 isActive 
.const [197] = Utf8 ()Z 
.const [198] = Utf8 setActive 
.const [199] = Utf8 (Z)V 
.const [200] = Utf8 getRequestedViewSize 
.const [201] = Utf8 ()I 
.const [202] = Utf8 setRequestedViewSize 
.const [203] = Utf8 (I)V 
.const [204] = Utf8 <clinit> 
.const [205] = Utf8 ()V 
.end class 
