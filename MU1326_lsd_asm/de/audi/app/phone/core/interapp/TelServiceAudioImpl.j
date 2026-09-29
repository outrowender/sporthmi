.version 50 0 
.class public super [139] 
.super [141] 
.implements [143] 
.field private volatile [144] [145] 
.field static synthetic [146] [147] 

.method public [149] : [150] 
    .attribute [148] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [24] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [148] .code stack 8 locals 0 
L0:     aload_0 
L1:     new [29] 
L4:     dup 
L5:     getstatic [7] 
L8:     ifnonnull L23 
L11:    ldc [8] 
L13:    invokestatic [9] 
L16:    dup 
L17:    putstatic [25] 
L20:    goto L26 
L23:    getstatic [7] 
L26:    invokevirtual [19] 
L29:    aload_0 
L30:    aconst_null 
L31:    aload_0 
L32:    invokevirtual [17] 
L35:    invokeinterface [30] 0 
L40:    aload_0 
L41:    getfield [16] 
L44:    invokespecial [26] 
L47:    putfield [31] 
L50:    aload_0 
L51:    getfield [20] 
L54:    invokevirtual [21] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [148] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [20] 
L11:    invokevirtual [22] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [31] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [148] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [17] 
L4:     new [32] 
L7:     dup 
L8:     aload_0 
L9:     ldc [11] 
L11:    invokespecial [27] 
L14:    invokeinterface [33] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method static synthetic [157] : [158] 
    .attribute [148] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [28] 
L9:     dup 
L10:    invokespecial [23] 
L13:    aload_1 
L14:    invokevirtual [18] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [159] : [160] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [161] : [162] 
    .attribute [148] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [163] : [164] 
    .attribute [148] .code stack 1 locals 0 
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
.const [2] = Method [34] [35] 
.const [3] = Class [36] 
.const [4] = Class [37] 
.const [5] = String [38] 
.const [6] = Class [39] 
.const [7] = Field [40] [41] 
.const [8] = String [42] 
.const [9] = Method [43] [44] 
.const [10] = Class [45] 
.const [11] = String [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Field [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Field [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Field [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Class [75] 
.const [29] = Class [76] 
.const [30] = InterfaceMethod [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Class [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = Class [84] 
.const [35] = NameAndType [85] [86] 
.const [36] = Utf8 java/lang/ClassNotFoundException 
.const [37] = Utf8 java/lang/NoClassDefFoundError 
.const [38] = Utf8 'App.Phone.Audio' 
.const [39] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [40] = Class [87] 
.const [41] = NameAndType [88] [89] 
.const [42] = Utf8 'de.audi.atip.interapp.phone.ITelServiceAudio' 
.const [43] = Class [90] 
.const [44] = NameAndType [91] [92] 
.const [45] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl$1 
.const [46] = Utf8 'TelServiceAudioImpl#muteIncomingCallRingtone' 
.const [47] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [48] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [49] = Utf8 java/lang/Class 
.const [50] = Utf8 de/audi/app/phone/core/ITelApplication 
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
.const [75] = Utf8 java/lang/NoClassDefFoundError 
.const [76] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [77] = Class [129] 
.const [78] = NameAndType [130] [131] 
.const [79] = Class [132] 
.const [80] = NameAndType [133] [134] 
.const [81] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl$1 
.const [82] = Class [135] 
.const [83] = NameAndType [136] [137] 
.const [84] = Utf8 java/lang/Class 
.const [85] = Utf8 forName 
.const [86] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [87] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [88] = Utf8 class$de$audi$atip$interapp$phone$ITelServiceAudio 
.const [89] = Utf8 Ljava/lang/Class; 
.const [90] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [91] = Utf8 class$ 
.const [92] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [93] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [94] = Utf8 log 
.const [95] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [96] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [97] = Utf8 getApplication 
.const [98] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [99] = Utf8 java/lang/NoClassDefFoundError 
.const [100] = Utf8 initCause 
.const [101] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [102] = Utf8 java/lang/Class 
.const [103] = Utf8 getName 
.const [104] = Utf8 ()Ljava/lang/String; 
.const [105] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [106] = Utf8 telServiceAudioProvider 
.const [107] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [108] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [109] = Utf8 startService 
.const [110] = Utf8 ()V 
.const [111] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [112] = Utf8 stopService 
.const [113] = Utf8 ()V 
.const [114] = Utf8 java/lang/NoClassDefFoundError 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [120] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [121] = Utf8 class$de$audi$atip$interapp$phone$ITelServiceAudio 
.const [122] = Utf8 Ljava/lang/Class; 
.const [123] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [126] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl$1 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceAudioImpl;Ljava/lang/String;)V 
.const [129] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [130] = Utf8 getBundleContext 
.const [131] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [132] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [133] = Utf8 telServiceAudioProvider 
.const [134] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [135] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [136] = Utf8 enqueueEvent 
.const [137] = Utf8 (Lde/audi/app/phone/core/event/AbstractTelEvent;)V 
.const [138] = Utf8 de/audi/app/phone/core/interapp/TelServiceAudioImpl 
.const [139] = Class [138] 
.const [140] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [141] = Class [140] 
.const [142] = Utf8 de/audi/atip/interapp/phone/ITelServiceAudio 
.const [143] = Class [142] 
.const [144] = Utf8 telServiceAudioProvider 
.const [145] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [146] = Utf8 class$de$audi$atip$interapp$phone$ITelServiceAudio 
.const [147] = Utf8 Ljava/lang/Class; 
.const [148] = Utf8 Code 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [151] = Utf8 init 
.const [152] = Utf8 ()V 
.const [153] = Utf8 deinit 
.const [154] = Utf8 ()V 
.const [155] = Utf8 muteIncomingCallRingtone 
.const [156] = Utf8 ()V 
.const [157] = Utf8 class$ 
.const [158] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [159] = Utf8 access$000 
.const [160] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceAudioImpl;)Lde/audi/app/phone/core/ITelApplication; 
.const [161] = Utf8 access$100 
.const [162] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceAudioImpl;)Lde/audi/atip/log/LogChannel; 
.const [163] = Utf8 access$200 
.const [164] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceAudioImpl;)Lde/audi/atip/log/LogChannel; 
.end class 
