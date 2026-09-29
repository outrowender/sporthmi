.version 50 0 
.class public super [146] 
.super [148] 
.implements [150] 
.field private volatile [151] [152] 
.field static synthetic [153] [154] 

.method public [156] : [157] 
    .attribute [155] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [27] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [155] .code stack 8 locals 0 
L0:     aload_0 
L1:     new [31] 
L4:     dup 
L5:     getstatic [7] 
L8:     ifnonnull L23 
L11:    ldc [8] 
L13:    invokestatic [9] 
L16:    dup 
L17:    putstatic [28] 
L20:    goto L26 
L23:    getstatic [7] 
L26:    invokevirtual [19] 
L29:    aload_0 
L30:    aconst_null 
L31:    aload_0 
L32:    invokevirtual [20] 
L35:    invokeinterface [32] 0 
L40:    aload_0 
L41:    getfield [21] 
L44:    invokespecial [29] 
L47:    putfield [33] 
L50:    aload_0 
L51:    getfield [22] 
L54:    invokevirtual [23] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [22] 
L11:    invokevirtual [24] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [33] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [155] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [10] 
L6:     ldc [11] 
L8:     iload_1 
L9:     invokevirtual [25] 
L12:    pop 
L13:    aload_0 
L14:    invokevirtual [20] 
L17:    invokeinterface [34] 0 
L22:    iconst_0 
L23:    invokeinterface [35] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static synthetic [164] : [165] 
    .attribute [155] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [30] 
L9:     dup 
L10:    invokespecial [26] 
L13:    aload_1 
L14:    invokevirtual [18] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Class [38] 
.const [4] = Class [39] 
.const [5] = String [40] 
.const [6] = Class [41] 
.const [7] = Field [42] [43] 
.const [8] = String [44] 
.const [9] = Method [45] [46] 
.const [10] = Int 1078071040 
.const [11] = String [47] 
.const [12] = Class [48] 
.const [13] = Class [49] 
.const [14] = Class [50] 
.const [15] = Class [51] 
.const [16] = Class [52] 
.const [17] = Class [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = Field [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Field [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Class [78] 
.const [31] = Class [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = Field [82] [83] 
.const [34] = InterfaceMethod [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = Class [88] 
.const [37] = NameAndType [89] [90] 
.const [38] = Utf8 java/lang/ClassNotFoundException 
.const [39] = Utf8 java/lang/NoClassDefFoundError 
.const [40] = Utf8 'App.Phone.Audio' 
.const [41] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [42] = Class [91] 
.const [43] = NameAndType [92] [93] 
.const [44] = Utf8 'de.audi.atip.interapp.phone.ITelMuteMicService' 
.const [45] = Class [94] 
.const [46] = NameAndType [95] [96] 
.const [47] = Utf8 '[TelMuteMicServiceImpl#toggleMuteMicrophone] muteMicrophone=%1' 
.const [48] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [49] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [50] = Utf8 java/lang/Class 
.const [51] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 de/audi/app/phone/core/audio/ITelAudio 
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
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Utf8 java/lang/NoClassDefFoundError 
.const [79] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Utf8 java/lang/Class 
.const [89] = Utf8 forName 
.const [90] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [91] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [92] = Utf8 class$de$audi$atip$interapp$phone$ITelMuteMicService 
.const [93] = Utf8 Ljava/lang/Class; 
.const [94] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [95] = Utf8 class$ 
.const [96] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [97] = Utf8 java/lang/NoClassDefFoundError 
.const [98] = Utf8 initCause 
.const [99] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [100] = Utf8 java/lang/Class 
.const [101] = Utf8 getName 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [104] = Utf8 getApplication 
.const [105] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [106] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [107] = Utf8 log 
.const [108] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [109] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [110] = Utf8 telMuteMicServiceProvider 
.const [111] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [112] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [113] = Utf8 startService 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [116] = Utf8 stopService 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/audi/atip/log/LogChannel 
.const [119] = Utf8 log 
.const [120] = Utf8 (ILjava/lang/String;Z)Z 
.const [121] = Utf8 java/lang/NoClassDefFoundError 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [127] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [128] = Utf8 class$de$audi$atip$interapp$phone$ITelMuteMicService 
.const [129] = Utf8 Ljava/lang/Class; 
.const [130] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [133] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [134] = Utf8 getBundleContext 
.const [135] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [136] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [137] = Utf8 telMuteMicServiceProvider 
.const [138] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [139] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [140] = Utf8 getAudio 
.const [141] = Utf8 ()Lde/audi/app/phone/core/audio/ITelAudio; 
.const [142] = Utf8 de/audi/app/phone/core/audio/ITelAudio 
.const [143] = Utf8 toggelMicMuteState 
.const [144] = Utf8 (I)V 
.const [145] = Utf8 de/audi/app/phone/core/interapp/TelMuteMicServiceImpl 
.const [146] = Class [145] 
.const [147] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [148] = Class [147] 
.const [149] = Utf8 de/audi/atip/interapp/phone/ITelMuteMicService 
.const [150] = Class [149] 
.const [151] = Utf8 telMuteMicServiceProvider 
.const [152] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [153] = Utf8 class$de$audi$atip$interapp$phone$ITelMuteMicService 
.const [154] = Utf8 Ljava/lang/Class; 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [158] = Utf8 init 
.const [159] = Utf8 ()V 
.const [160] = Utf8 deinit 
.const [161] = Utf8 ()V 
.const [162] = Utf8 toggleMuteMicrophone 
.const [163] = Utf8 (Z)V 
.const [164] = Utf8 class$ 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
