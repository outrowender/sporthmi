.version 50 0 
.class public super [174] 
.super [176] 
.implements [178] 
.field private volatile [179] [180] 
.field static synthetic [181] [182] 

.method public [184] : [185] 
    .attribute [183] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [33] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [183] .code stack 8 locals 1 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [34] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    ldc [8] 
L13:    invokevirtual [23] 
L16:    pop 
L17:    aload_0 
L18:    new [39] 
L21:    dup 
L22:    getstatic [10] 
L25:    ifnonnull L40 
L28:    ldc [11] 
L30:    invokestatic [12] 
L33:    dup 
L34:    putstatic [35] 
L37:    goto L43 
L40:    getstatic [10] 
L43:    invokevirtual [24] 
L46:    aload_0 
L47:    aload_1 
L48:    aload_0 
L49:    invokevirtual [25] 
L52:    invokeinterface [40] 0 
L57:    aload_0 
L58:    getfield [26] 
L61:    invokespecial [36] 
L64:    putfield [41] 
L67:    aload_0 
L68:    getfield [27] 
L71:    invokevirtual [28] 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [183] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     ifnull L14 
L7:     aload_0 
L8:     getfield [27] 
L11:    invokevirtual [29] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [183] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [13] 
L6:     ldc [14] 
L8:     aload_1 
L9:     invokevirtual [30] 
L12:    pop 
L13:    aload_0 
L14:    invokevirtual [31] 
L17:    invokeinterface [42] 0 
L22:    aload_1 
L23:    invokeinterface [43] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static synthetic [192] : [193] 
    .attribute [183] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [37] 
L9:     dup 
L10:    invokespecial [32] 
L13:    aload_1 
L14:    invokevirtual [22] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [44] [45] 
.const [3] = Class [46] 
.const [4] = Class [47] 
.const [5] = String [48] 
.const [6] = Class [49] 
.const [7] = String [50] 
.const [8] = String [51] 
.const [9] = Class [52] 
.const [10] = Field [53] [54] 
.const [11] = String [55] 
.const [12] = Method [56] [57] 
.const [13] = Int 1078071040 
.const [14] = String [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Field [74] [75] 
.const [27] = Field [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Class [96] 
.const [38] = Class [97] 
.const [39] = Class [98] 
.const [40] = InterfaceMethod [99] [100] 
.const [41] = Field [101] [102] 
.const [42] = InterfaceMethod [103] [104] 
.const [43] = InterfaceMethod [105] [106] 
.const [44] = Class [107] 
.const [45] = NameAndType [108] [109] 
.const [46] = Utf8 java/lang/ClassNotFoundException 
.const [47] = Utf8 java/lang/NoClassDefFoundError 
.const [48] = Utf8 'App.Phone.Main' 
.const [49] = Utf8 java/util/Hashtable 
.const [50] = Utf8 ApplicationName 
.const [51] = Utf8 AppPhone 
.const [52] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [53] = Class [110] 
.const [54] = NameAndType [111] [112] 
.const [55] = Utf8 'de.audi.atip.interapp.phone.ITelServiceADB' 
.const [56] = Class [113] 
.const [57] = NameAndType [114] [115] 
.const [58] = Utf8 '[TelServiceADBImpl#addToFavorites] favorite=%1' 
.const [59] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [60] = Utf8 de/audi/app/phone/evo/AbstractEvoPhoneComponent 
.const [61] = Utf8 java/lang/Class 
.const [62] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/app/phone/evo/ITelEvoApplication 
.const [65] = Utf8 de/audi/app/phone/evo/favorite/ITelFavoriteHandler 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Class [146] 
.const [87] = NameAndType [147] [148] 
.const [88] = Class [149] 
.const [89] = NameAndType [150] [151] 
.const [90] = Class [152] 
.const [91] = NameAndType [153] [154] 
.const [92] = Class [155] 
.const [93] = NameAndType [156] [157] 
.const [94] = Class [158] 
.const [95] = NameAndType [159] [160] 
.const [96] = Utf8 java/lang/NoClassDefFoundError 
.const [97] = Utf8 java/util/Hashtable 
.const [98] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [99] = Class [161] 
.const [100] = NameAndType [162] [163] 
.const [101] = Class [164] 
.const [102] = NameAndType [165] [166] 
.const [103] = Class [167] 
.const [104] = NameAndType [168] [169] 
.const [105] = Class [170] 
.const [106] = NameAndType [171] [172] 
.const [107] = Utf8 java/lang/Class 
.const [108] = Utf8 forName 
.const [109] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [110] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [111] = Utf8 class$de$audi$atip$interapp$phone$ITelServiceADB 
.const [112] = Utf8 Ljava/lang/Class; 
.const [113] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [114] = Utf8 class$ 
.const [115] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [116] = Utf8 java/lang/NoClassDefFoundError 
.const [117] = Utf8 initCause 
.const [118] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [119] = Utf8 java/util/Hashtable 
.const [120] = Utf8 put 
.const [121] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [122] = Utf8 java/lang/Class 
.const [123] = Utf8 getName 
.const [124] = Utf8 ()Ljava/lang/String; 
.const [125] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [126] = Utf8 getApplication 
.const [127] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [128] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [129] = Utf8 log 
.const [130] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [131] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [132] = Utf8 telServiceADB 
.const [133] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [134] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [135] = Utf8 startService 
.const [136] = Utf8 ()V 
.const [137] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [138] = Utf8 stopService 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [143] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [144] = Utf8 getEvoApplication 
.const [145] = Utf8 ()Lde/audi/app/phone/evo/ITelEvoApplication; 
.const [146] = Utf8 java/lang/NoClassDefFoundError 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/audi/app/phone/evo/AbstractEvoPhoneComponent 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/app/phone/evo/ITelEvoApplication;Ljava/lang/String;)V 
.const [152] = Utf8 java/util/Hashtable 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [156] = Utf8 class$de$audi$atip$interapp$phone$ITelServiceADB 
.const [157] = Utf8 Ljava/lang/Class; 
.const [158] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [161] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [162] = Utf8 getBundleContext 
.const [163] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [164] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [165] = Utf8 telServiceADB 
.const [166] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [167] = Utf8 de/audi/app/phone/evo/ITelEvoApplication 
.const [168] = Utf8 getFavoriteHandler 
.const [169] = Utf8 ()Lde/audi/app/phone/evo/favorite/ITelFavoriteHandler; 
.const [170] = Utf8 de/audi/app/phone/evo/favorite/ITelFavoriteHandler 
.const [171] = Utf8 addToFavorites 
.const [172] = Utf8 (Lde/audi/atip/interapp/phone/TelFavoriteStruct;)V 
.const [173] = Utf8 de/audi/app/phone/evo/interapp/TelServiceADBImpl 
.const [174] = Class [173] 
.const [175] = Utf8 de/audi/app/phone/evo/AbstractEvoPhoneComponent 
.const [176] = Class [175] 
.const [177] = Utf8 de/audi/atip/interapp/phone/ITelServiceADB 
.const [178] = Class [177] 
.const [179] = Utf8 telServiceADB 
.const [180] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [181] = Utf8 class$de$audi$atip$interapp$phone$ITelServiceADB 
.const [182] = Utf8 Ljava/lang/Class; 
.const [183] = Utf8 Code 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Lde/audi/app/phone/evo/ITelEvoApplication;)V 
.const [186] = Utf8 init 
.const [187] = Utf8 ()V 
.const [188] = Utf8 deinit 
.const [189] = Utf8 ()V 
.const [190] = Utf8 addToFavorites 
.const [191] = Utf8 (Lde/audi/atip/interapp/phone/TelFavoriteStruct;)V 
.const [192] = Utf8 class$ 
.const [193] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
