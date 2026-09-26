.version 50 0 
.class public super abstract [151] 
.super [153] 
.implements [155] 
.field private final [156] [157] 
.field private final [158] [159] 
.field private volatile [160] [161] 

.method public [163] : [164] 
    .attribute [162] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [21] 
L6:     aload_0 
L7:     aload_3 
L8:     putfield [25] 
L11:    aload_0 
L12:    new [26] 
L15:    dup 
L16:    aload_0 
L17:    invokevirtual [10] 
L20:    invokeinterface [27] 0 
L25:    aload_3 
L26:    invokevirtual [11] 
L29:    aload_0 
L30:    aload_0 
L31:    getfield [12] 
L34:    invokespecial [22] 
L37:    putfield [28] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [162] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     getfield [13] 
L8:     invokevirtual [14] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [162] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     getfield [13] 
L8:     invokevirtual [15] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [162] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     invokeinterface [27] 0 
L9:     aload_1 
L10:    invokeinterface [29] 0 
L15:    astore_2 
L16:    aload_0 
L17:    getfield [9] 
L20:    aload_2 
L21:    invokevirtual [16] 
L24:    ifeq L39 
L27:    aload_0 
L28:    aload_2 
L29:    putfield [30] 
L32:    aload_0 
L33:    aload_2 
L34:    invokevirtual [18] 
L37:    aload_2 
L38:    areturn 
L39:    aload_0 
L40:    invokevirtual [10] 
L43:    invokeinterface [27] 0 
L48:    aload_1 
L49:    invokeinterface [31] 0 
L54:    pop 
L55:    aconst_null 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public enum [171] : [172] 
    .attribute [162] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [162] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_2 
L5:     invokevirtual [16] 
L8:     ifeq L50 
L11:    aload_0 
L12:    getfield [17] 
L15:    ifnull L50 
L18:    aload_0 
L19:    getfield [17] 
L22:    aload_2 
L23:    invokevirtual [19] 
L26:    ifeq L50 
L29:    aload_0 
L30:    aload_2 
L31:    invokevirtual [20] 
L34:    aload_0 
L35:    invokevirtual [10] 
L38:    invokeinterface [27] 0 
L43:    aload_1 
L44:    invokeinterface [31] 0 
L49:    pop 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected abstract [175] : [176] 
    .attribute [162] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [177] : [178] 
    .attribute [162] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = Class [35] 
.const [6] = Class [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Field [39] [40] 
.const [10] = Method [41] [42] 
.const [11] = Method [43] [44] 
.const [12] = Field [45] [46] 
.const [13] = Field [47] [48] 
.const [14] = Method [49] [50] 
.const [15] = Method [51] [52] 
.const [16] = Method [53] [54] 
.const [17] = Field [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Class [73] 
.const [27] = InterfaceMethod [74] [75] 
.const [28] = Field [76] [77] 
.const [29] = InterfaceMethod [78] [79] 
.const [30] = Field [80] [81] 
.const [31] = InterfaceMethod [82] [83] 
.const [32] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [33] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [34] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [35] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [36] = Utf8 java/lang/Class 
.const [37] = Utf8 org/osgi/framework/BundleContext 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [84] 
.const [40] = NameAndType [85] [86] 
.const [41] = Class [87] 
.const [42] = NameAndType [88] [89] 
.const [43] = Class [90] 
.const [44] = NameAndType [91] [92] 
.const [45] = Class [93] 
.const [46] = NameAndType [94] [95] 
.const [47] = Class [96] 
.const [48] = NameAndType [97] [98] 
.const [49] = Class [99] 
.const [50] = NameAndType [100] [101] 
.const [51] = Class [102] 
.const [52] = NameAndType [103] [104] 
.const [53] = Class [105] 
.const [54] = NameAndType [106] [107] 
.const [55] = Class [108] 
.const [56] = NameAndType [109] [110] 
.const [57] = Class [111] 
.const [58] = NameAndType [112] [113] 
.const [59] = Class [114] 
.const [60] = NameAndType [115] [116] 
.const [61] = Class [117] 
.const [62] = NameAndType [118] [119] 
.const [63] = Class [120] 
.const [64] = NameAndType [121] [122] 
.const [65] = Class [123] 
.const [66] = NameAndType [124] [125] 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Class [129] 
.const [70] = NameAndType [130] [131] 
.const [71] = Class [132] 
.const [72] = NameAndType [133] [134] 
.const [73] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [85] = Utf8 trackedServiceClazz 
.const [86] = Utf8 Ljava/lang/Class; 
.const [87] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [88] = Utf8 getApplication 
.const [89] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [90] = Utf8 java/lang/Class 
.const [91] = Utf8 getName 
.const [92] = Utf8 ()Ljava/lang/String; 
.const [93] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [94] = Utf8 log 
.const [95] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [96] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [97] = Utf8 serviceTracker 
.const [98] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [99] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [100] = Utf8 openTracker 
.const [101] = Utf8 ()V 
.const [102] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [103] = Utf8 closeTracker 
.const [104] = Utf8 ()V 
.const [105] = Utf8 java/lang/Class 
.const [106] = Utf8 isInstance 
.const [107] = Utf8 (Ljava/lang/Object;)Z 
.const [108] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [109] = Utf8 service 
.const [110] = Utf8 Ljava/lang/Object; 
.const [111] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [112] = Utf8 serviceAvailable 
.const [113] = Utf8 (Ljava/lang/Object;)V 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 equals 
.const [116] = Utf8 (Ljava/lang/Object;)Z 
.const [117] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [118] = Utf8 serviceRemoved 
.const [119] = Utf8 (Ljava/lang/Object;)V 
.const [120] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [123] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [126] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [127] = Utf8 init 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [130] = Utf8 deinit 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [133] = Utf8 trackedServiceClazz 
.const [134] = Utf8 Ljava/lang/Class; 
.const [135] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [136] = Utf8 getBundleContext 
.const [137] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [138] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [139] = Utf8 serviceTracker 
.const [140] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [141] = Utf8 org/osgi/framework/BundleContext 
.const [142] = Utf8 getService 
.const [143] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [144] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [145] = Utf8 service 
.const [146] = Utf8 Ljava/lang/Object; 
.const [147] = Utf8 org/osgi/framework/BundleContext 
.const [148] = Utf8 ungetService 
.const [149] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [150] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [151] = Class [150] 
.const [152] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [153] = Class [152] 
.const [154] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [155] = Class [154] 
.const [156] = Utf8 serviceTracker 
.const [157] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [158] = Utf8 trackedServiceClazz 
.const [159] = Utf8 Ljava/lang/Class; 
.const [160] = Utf8 service 
.const [161] = Utf8 Ljava/lang/Object; 
.const [162] = Utf8 Code 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;Ljava/lang/Class;)V 
.const [165] = Utf8 init 
.const [166] = Utf8 ()V 
.const [167] = Utf8 deinit 
.const [168] = Utf8 ()V 
.const [169] = Utf8 addingService 
.const [170] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [171] = Utf8 modifiedService 
.const [172] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [173] = Utf8 removedService 
.const [174] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [175] = Utf8 serviceAvailable 
.const [176] = Utf8 (Ljava/lang/Object;)V 
.const [177] = Utf8 serviceRemoved 
.const [178] = Utf8 (Ljava/lang/Object;)V 
.end class 
