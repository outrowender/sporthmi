.version 50 0 
.class public super [142] 
.super [144] 
.field private static final [145] [146] 
.field private static final [147] [148] 
.field private static final [149] [150] 
.field private volatile [151] [152] 
.field private final [153] [154] 
.field private final [155] [156] 
.field private volatile [157] [158] 

.method public [160] : [161] 
    .attribute [159] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [25] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [27] 
L12:    aload_0 
L13:    iconst_0 
L14:    putfield [28] 
L17:    aload_0 
L18:    new [29] 
L21:    dup 
L22:    aload_0 
L23:    aconst_null 
L24:    invokespecial [26] 
L27:    putfield [30] 
L30:    aload_0 
L31:    aload_2 
L32:    putfield [31] 
L35:    return 
L36:    
    .end code 
.end method 

.method public synchronized [162] : [163] 
    .attribute [159] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnull L105 
L4:     aload_1 
L5:     invokeinterface [32] 0 
L10:    ifeq L17 
L13:    iconst_2 
L14:    goto L18 
L17:    iconst_1 
L18:    istore 4 
L20:    aload_0 
L21:    invokevirtual [21] 
L24:    ifeq L36 
L27:    iload 4 
L29:    aload_0 
L30:    getfield [17] 
L33:    if_icmpne L40 
L36:    iload_3 
L37:    ifeq L102 
L40:    aload_0 
L41:    iload 4 
L43:    putfield [27] 
L46:    aload_0 
L47:    getfield [17] 
L50:    iconst_2 
L51:    if_icmpne L58 
L54:    iconst_1 
L55:    goto L59 
L58:    iconst_0 
L59:    istore 5 
L61:    aload_0 
L62:    getfield [16] 
L65:    ldc [4] 
L67:    ldc [5] 
L69:    aload_1 
L70:    invokeinterface [33] 0 
L75:    invokestatic [6] 
L78:    iload 5 
L80:    invokestatic [7] 
L83:    invokevirtual [22] 
L86:    aload_0 
L87:    getfield [20] 
L90:    iload 5 
L92:    iload_2 
L93:    aload_0 
L94:    getfield [19] 
L97:    invokevirtual [23] 
L100:   iconst_1 
L101:   areturn 
L102:   goto L118 
L105:   aload_0 
L106:   getfield [16] 
L109:   sipush 10000 
L112:   ldc [8] 
L114:   invokevirtual [24] 
L117:   pop 
L118:   iconst_0 
L119:   areturn 
L120:   
    .end code 
.end method 

.method public interface [164] : [165] 
    .attribute [159] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [159] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [168] : [169] 
    .attribute [159] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [170] : [171] 
    .attribute [159] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [172] : [173] 
    .attribute [159] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [27] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [174] : [175] 
    .attribute [159] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [34] 
.const [3] = Class [35] 
.const [4] = Int 1078071040 
.const [5] = String [36] 
.const [6] = Method [37] [38] 
.const [7] = Method [39] [40] 
.const [8] = String [41] 
.const [9] = Class [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Field [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Field [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Class [75] 
.const [30] = Field [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = Utf8 'App.Phone.Main' 
.const [35] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener 
.const [36] = Utf8 '[TelWidebandSpeechHandler#setWidebandSpeech] %1 - setting wideband speech to %2' 
.const [37] = Class [84] 
.const [38] = NameAndType [85] [86] 
.const [39] = Class [87] 
.const [40] = NameAndType [88] [89] 
.const [41] = Utf8 'TelWidebandSpeechHandler#setWidebandSpeech deviceState is null' 
.const [42] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [43] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [44] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [45] = Utf8 de/audi/app/phone/core/dsi/TelDSIUtils 
.const [46] = Utf8 java/lang/String 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdManager 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Class [117] 
.const [68] = NameAndType [118] [119] 
.const [69] = Class [120] 
.const [70] = NameAndType [121] [122] 
.const [71] = Class [123] 
.const [72] = NameAndType [124] [125] 
.const [73] = Class [126] 
.const [74] = NameAndType [127] [128] 
.const [75] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Class [132] 
.const [79] = NameAndType [133] [134] 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Class [138] 
.const [83] = NameAndType [139] [140] 
.const [84] = Utf8 de/audi/app/phone/core/dsi/TelDSIUtils 
.const [85] = Utf8 getRoleName 
.const [86] = Utf8 (I)Ljava/lang/String; 
.const [87] = Utf8 java/lang/String 
.const [88] = Utf8 valueOf 
.const [89] = Utf8 (Z)Ljava/lang/String; 
.const [90] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [91] = Utf8 log 
.const [92] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [93] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [94] = Utf8 currentWidebandSpeechSetting 
.const [95] = Utf8 I 
.const [96] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [97] = Utf8 isAMAvailable 
.const [98] = Utf8 Z 
.const [99] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [100] = Utf8 widebandSpeechResponseListener 
.const [101] = Utf8 Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener; 
.const [102] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [103] = Utf8 cmdManager 
.const [104] = Utf8 Lde/audi/app/phone/core/audio/TelAudioCmdManager; 
.const [105] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [106] = Utf8 isAMAvailable 
.const [107] = Utf8 ()Z 
.const [108] = Utf8 de/audi/atip/log/LogChannel 
.const [109] = Utf8 log 
.const [110] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [111] = Utf8 de/audi/app/phone/core/audio/TelAudioCmdManager 
.const [112] = Utf8 scheduleWidebandSpeech 
.const [113] = Utf8 (ZZLorg/dsi/ifc/audio/DSISoundListener;)V 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;)Z 
.const [117] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [120] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler;Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler$1;)V 
.const [123] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [124] = Utf8 currentWidebandSpeechSetting 
.const [125] = Utf8 I 
.const [126] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [127] = Utf8 isAMAvailable 
.const [128] = Utf8 Z 
.const [129] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [130] = Utf8 widebandSpeechResponseListener 
.const [131] = Utf8 Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener; 
.const [132] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [133] = Utf8 cmdManager 
.const [134] = Utf8 Lde/audi/app/phone/core/audio/TelAudioCmdManager; 
.const [135] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [136] = Utf8 isWidebandSpeechActive 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [139] = Utf8 getDeviceRole 
.const [140] = Utf8 ()I 
.const [141] = Utf8 de/audi/app/phone/core/audio/TelWidebandSpeechHandler 
.const [142] = Class [141] 
.const [143] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [144] = Class [143] 
.const [145] = Utf8 WIDEBAND_SPEECH_UNKNOWN 
.const [146] = Utf8 I 
.const [147] = Utf8 WIDEBAND_SPEECH_DISABLED 
.const [148] = Utf8 I 
.const [149] = Utf8 WIDEBAND_SPEECH_ENABLED 
.const [150] = Utf8 I 
.const [151] = Utf8 currentWidebandSpeechSetting 
.const [152] = Utf8 I 
.const [153] = Utf8 widebandSpeechResponseListener 
.const [154] = Utf8 Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener; 
.const [155] = Utf8 cmdManager 
.const [156] = Utf8 Lde/audi/app/phone/core/audio/TelAudioCmdManager; 
.const [157] = Utf8 isAMAvailable 
.const [158] = Utf8 Z 
.const [159] = Utf8 Code 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/audi/app/phone/core/audio/TelAudioCmdManager;)V 
.const [162] = Utf8 setWidebandSpeech 
.const [163] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;ZZ)Z 
.const [164] = Utf8 isAMAvailable 
.const [165] = Utf8 ()Z 
.const [166] = Utf8 setAMAvailable 
.const [167] = Utf8 (Z)V 
.const [168] = Utf8 access$100 
.const [169] = Utf8 (Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler;)Lde/audi/atip/log/LogChannel; 
.const [170] = Utf8 access$200 
.const [171] = Utf8 (Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler;)Z 
.const [172] = Utf8 access$302 
.const [173] = Utf8 (Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler;I)I 
.const [174] = Utf8 access$400 
.const [175] = Utf8 (Lde/audi/app/phone/core/audio/TelWidebandSpeechHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
