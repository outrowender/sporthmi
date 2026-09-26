.version 50 0 
.class public super [147] 
.super [149] 
.field private final [150] [151] 
.field private final [152] [153] 
.field private [154] [155] 
.field private volatile [156] [157] 

.method public [159] : [160] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     bipush 50 
L7:     putfield [27] 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [28] 
L15:    aload_0 
L16:    aload_1 
L17:    invokevirtual [20] 
L20:    ldc [2] 
L22:    invokeinterface [29] 0 
L27:    putfield [30] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [158] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [22] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnull L51 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [27] 
L14:    aload_2 
L15:    aload_0 
L16:    getfield [18] 
L19:    invokeinterface [32] 0 
L24:    aload_0 
L25:    getfield [19] 
L28:    invokevirtual [20] 
L31:    invokeinterface [33] 0 
L36:    invokeinterface [34] 0 
L41:    aload_0 
L42:    getfield [18] 
L45:    iconst_1 
L46:    invokeinterface [35] 0 
L51:    return 
L52:    
    .end code 
.end method 

.method public interface [163] : [164] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [165] : [166] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [158] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_1 
L14:    ifnonnull L38 
L17:    aload_0 
L18:    aconst_null 
L19:    putfield [31] 
L22:    aload_0 
L23:    getfield [21] 
L26:    sipush 10000 
L29:    ldc [5] 
L31:    invokevirtual [24] 
L34:    pop 
L35:    goto L95 
L38:    aload_1 
L39:    instanceof [6] 
L42:    ifeq L82 
L45:    aload_0 
L46:    aload_1 
L47:    checkcast [6] 
L50:    putfield [31] 
L53:    aload_0 
L54:    aload_0 
L55:    getfield [19] 
L58:    invokevirtual [20] 
L61:    invokeinterface [33] 0 
L66:    invokeinterface [34] 0 
L71:    invokeinterface [36] 0 
L76:    putfield [27] 
L79:    goto L95 
L82:    aload_0 
L83:    getfield [21] 
L86:    ldc [3] 
L88:    ldc [7] 
L90:    aload_1 
L91:    invokevirtual [23] 
L94:    pop 
L95:    return 
L96:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [158] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     invokevirtual [24] 
L11:    pop 
L12:    iconst_1 
L13:    newarray int 
L15:    dup 
L16:    iconst_0 
L17:    bipush 83 
L19:    iastore 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [158] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     sipush 10000 
L7:     ldc [10] 
L9:     aload_2 
L10:    iload_1 
L11:    i2l 
L12:    iload_3 
L13:    i2l 
L14:    invokevirtual [25] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [37] 
.const [3] = Int -1601830656 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = Class [40] 
.const [7] = String [41] 
.const [8] = Int 1078071040 
.const [9] = String [42] 
.const [10] = String [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = InterfaceMethod [73] [74] 
.const [30] = Field [75] [76] 
.const [31] = Field [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = InterfaceMethod [83] [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = InterfaceMethod [87] [88] 
.const [37] = Utf8 'App.Settings.KombiDisplay' 
.const [38] = Utf8 'setDSI( %1 )' 
.const [39] = Utf8 'KombiBrightnessHandler: DSICarKombi provider is NULL!' 
.const [40] = Utf8 org/dsi/ifc/carkombi/DSICarKombi 
.const [41] = Utf8 'setDSI( %1 ) failed! wrong class!' 
.const [42] = Utf8 getAutoNotifications() 
.const [43] = Utf8 'asyncException( %2, %1, %3 )' 
.const [44] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [45] = Utf8 de/audi/app/settings/display/KombiBrightnessDsiWrapper 
.const [46] = Utf8 de/audi/app/settings/SettingsEnv 
.const [47] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [48] = Utf8 de/audi/atip/start/ILastmodeHandler 
.const [49] = Utf8 de/audi/atip/start/ILastmodeStorage 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
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
.const [89] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [90] = Utf8 brightness 
.const [91] = Utf8 I 
.const [92] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [93] = Utf8 env 
.const [94] = Utf8 Lde/audi/app/settings/SettingsEnv; 
.const [95] = Utf8 de/audi/app/settings/SettingsEnv 
.const [96] = Utf8 getFw 
.const [97] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [98] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [99] = Utf8 lc 
.const [100] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [101] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [102] = Utf8 dsi 
.const [103] = Utf8 Lorg/dsi/ifc/carkombi/DSICarKombi; 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 log 
.const [109] = Utf8 (ILjava/lang/String;)Z 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [113] = Utf8 de/audi/app/settings/display/KombiBrightnessDsiWrapper 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [117] = Utf8 brightness 
.const [118] = Utf8 I 
.const [119] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [120] = Utf8 env 
.const [121] = Utf8 Lde/audi/app/settings/SettingsEnv; 
.const [122] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [123] = Utf8 getLogChannel 
.const [124] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [126] = Utf8 lc 
.const [127] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [128] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [129] = Utf8 dsi 
.const [130] = Utf8 Lorg/dsi/ifc/carkombi/DSICarKombi; 
.const [131] = Utf8 org/dsi/ifc/carkombi/DSICarKombi 
.const [132] = Utf8 setDCBrightness 
.const [133] = Utf8 (I)V 
.const [134] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [135] = Utf8 getLastmodeHandler 
.const [136] = Utf8 ()Lde/audi/atip/start/ILastmodeHandler; 
.const [137] = Utf8 de/audi/atip/start/ILastmodeHandler 
.const [138] = Utf8 getLastmodeStorage 
.const [139] = Utf8 ()Lde/audi/atip/start/ILastmodeStorage; 
.const [140] = Utf8 de/audi/atip/start/ILastmodeStorage 
.const [141] = Utf8 setKombiBrightness 
.const [142] = Utf8 (IZ)V 
.const [143] = Utf8 de/audi/atip/start/ILastmodeStorage 
.const [144] = Utf8 getKombiBrightness 
.const [145] = Utf8 ()I 
.const [146] = Utf8 de/audi/app/settings/display/KombiBrightnessHandler 
.const [147] = Class [146] 
.const [148] = Utf8 de/audi/app/settings/display/KombiBrightnessDsiWrapper 
.const [149] = Class [148] 
.const [150] = Utf8 env 
.const [151] = Utf8 Lde/audi/app/settings/SettingsEnv; 
.const [152] = Utf8 lc 
.const [153] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 dsi 
.const [155] = Utf8 Lorg/dsi/ifc/carkombi/DSICarKombi; 
.const [156] = Utf8 brightness 
.const [157] = Utf8 I 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/app/settings/SettingsEnv;)V 
.const [161] = Utf8 setBrightness 
.const [162] = Utf8 (I)V 
.const [163] = Utf8 getBrightness 
.const [164] = Utf8 ()I 
.const [165] = Utf8 updateDCBrightness 
.const [166] = Utf8 (II)V 
.const [167] = Utf8 setDSI 
.const [168] = Utf8 (Lorg/dsi/ifc/base/DSIBase;)V 
.const [169] = Utf8 getAutoNotifications 
.const [170] = Utf8 ()[I 
.const [171] = Utf8 asyncException 
.const [172] = Utf8 (ILjava/lang/String;I)V 
.end class 
