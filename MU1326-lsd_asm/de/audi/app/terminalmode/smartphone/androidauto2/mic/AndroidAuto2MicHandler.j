.version 50 0 
.class public super [150] 
.super [152] 
.implements [154] 
.field private static final [155] [156] 
.field private volatile [157] [158] 
.field private volatile [159] [160] 

.method public [162] : [163] 
    .attribute [161] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [31] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [34] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [35] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [161] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     iload_1 
L5:     if_icmpne L9 
L8:     return 
L9:     aload_0 
L10:    getfield [23] 
L13:    ldc [2] 
L15:    ldc [3] 
L17:    ldc [4] 
L19:    iload_1 
L20:    ifeq L28 
L23:    ldc [5] 
L25:    goto L30 
L28:    ldc [6] 
L30:    invokevirtual [24] 
L33:    iload_1 
L34:    ifeq L54 
L37:    aload_0 
L38:    getfield [25] 
L41:    iconst_1 
L42:    aload_0 
L43:    getfield [21] 
L46:    invokeinterface [36] 0 
L51:    goto L68 
L54:    aload_0 
L55:    getfield [25] 
L58:    iconst_2 
L59:    aload_0 
L60:    getfield [21] 
L63:    invokeinterface [36] 0 
L68:    aload_0 
L69:    iconst_1 
L70:    putfield [34] 
L73:    aload_0 
L74:    iload_1 
L75:    putfield [35] 
L78:    return 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [161] .code stack 6 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     invokevirtual [26] 
L5:     ifeq L59 
L8:     aload_0 
L9:     getfield [23] 
L12:    ldc [2] 
L14:    ldc [7] 
L16:    ldc [4] 
L18:    aload_0 
L19:    iload_1 
L20:    invokespecial [32] 
L23:    invokevirtual [24] 
L26:    iload_1 
L27:    iconst_1 
L28:    if_icmpne L44 
L31:    aload_0 
L32:    getstatic [8] 
L35:    getstatic [9] 
L38:    invokevirtual [27] 
L41:    goto L54 
L44:    aload_0 
L45:    getstatic [8] 
L48:    getstatic [10] 
L51:    invokevirtual [27] 
L54:    aload_0 
L55:    iconst_0 
L56:    putfield [34] 
L59:    return 
L60:    
    .end code 
.end method 

.method private [168] : [169] 
    .attribute [161] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L28 
            2 : L31 
            default : L34 

L28:    ldc [11] 
L30:    areturn 
L31:    ldc [12] 
L33:    areturn 
L34:    new [37] 
L37:    dup 
L38:    invokespecial [33] 
L41:    ldc [14] 
L43:    invokevirtual [28] 
L46:    iload_1 
L47:    invokevirtual [29] 
L50:    invokevirtual [30] 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method protected [170] : [171] 
    .attribute [161] .code stack 1 locals 0 
L0:     ldc [4] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [38] 
.const [4] = String [39] 
.const [5] = String [40] 
.const [6] = String [41] 
.const [7] = String [42] 
.const [8] = Field [43] [44] 
.const [9] = Field [45] [46] 
.const [10] = Field [47] [48] 
.const [11] = String [49] 
.const [12] = String [50] 
.const [13] = Class [51] 
.const [14] = String [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Method [83] [84] 
.const [34] = Field [85] [86] 
.const [35] = Field [87] [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = Class [91] 
.const [38] = Utf8 '[%1.microphoneUpdate] %2' 
.const [39] = Utf8 AndroidAuto2MicHandler 
.const [40] = Utf8 OPEN 
.const [41] = Utf8 CLOSE 
.const [42] = Utf8 '<- [%1.microphoneRequestNotification] %2' 
.const [43] = Class [92] 
.const [44] = NameAndType [93] [94] 
.const [45] = Class [95] 
.const [46] = NameAndType [96] [97] 
.const [47] = Class [98] 
.const [48] = NameAndType [99] [100] 
.const [49] = Utf8 MIC_OPEN 
.const [50] = Utf8 MIC_CLOSE 
.const [51] = Utf8 java/lang/StringBuffer 
.const [52] = Utf8 'MIC_UNKNOWN ' 
.const [53] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [54] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [57] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [58] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
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
.const [89] = Class [146] 
.const [90] = NameAndType [147] [148] 
.const [91] = Utf8 java/lang/StringBuffer 
.const [92] = Utf8 de/audi/app/terminalmode/statemachine/Resource 
.const [93] = Utf8 AUDIO_SPEECH 
.const [94] = Utf8 Lde/audi/app/terminalmode/statemachine/Resource; 
.const [95] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [96] = Utf8 DEVICE 
.const [97] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [98] = Utf8 de/audi/app/terminalmode/statemachine/ResourceOwner 
.const [99] = Utf8 MAINUNIT 
.const [100] = Utf8 Lde/audi/app/terminalmode/statemachine/ResourceOwner; 
.const [101] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [102] = Utf8 unsolicited 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [105] = Utf8 micState 
.const [106] = Utf8 Z 
.const [107] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [108] = Utf8 logger 
.const [109] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [113] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [114] = Utf8 dsi 
.const [115] = Utf8 Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2; 
.const [116] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [117] = Utf8 isValid 
.const [118] = Utf8 (I)Z 
.const [119] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [120] = Utf8 requestDSIUpdate 
.const [121] = Utf8 (Lde/audi/app/terminalmode/statemachine/Resource;Lde/audi/app/terminalmode/statemachine/ResourceOwner;)V 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 append 
.const [124] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 append 
.const [127] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 toString 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/app/terminalmode/statemachine/IStateHandler;Lde/audi/app/terminalmode/IContext;)V 
.const [134] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [135] = Utf8 getMicrophoneState 
.const [136] = Utf8 (I)Ljava/lang/String; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [141] = Utf8 unsolicited 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [144] = Utf8 micState 
.const [145] = Utf8 Z 
.const [146] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [147] = Utf8 microphoneNotification 
.const [148] = Utf8 (IZ)V 
.const [149] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/AndroidAuto2MicHandler 
.const [150] = Class [149] 
.const [151] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [152] = Class [151] 
.const [153] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/mic/IAndroidAuto2MicHandler 
.const [154] = Class [153] 
.const [155] = Utf8 LOGCLASS 
.const [156] = Utf8 Ljava/lang/String; 
.const [157] = Utf8 micState 
.const [158] = Utf8 Z 
.const [159] = Utf8 unsolicited 
.const [160] = Utf8 Z 
.const [161] = Utf8 Code 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/app/terminalmode/statemachine/IStateHandler;Lde/audi/app/terminalmode/IContext;)V 
.const [164] = Utf8 microphoneUpdate 
.const [165] = Utf8 (Z)V 
.const [166] = Utf8 microphoneRequestNotification 
.const [167] = Utf8 (II)V 
.const [168] = Utf8 getMicrophoneState 
.const [169] = Utf8 (I)Ljava/lang/String; 
.const [170] = Utf8 getLogClass 
.const [171] = Utf8 ()Ljava/lang/String; 
.end class 
