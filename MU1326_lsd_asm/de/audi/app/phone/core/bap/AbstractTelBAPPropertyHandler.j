.version 50 0 
.class public super abstract [189] 
.super [191] 
.implements [193] 
.field private volatile [194] [195] 
.field private volatile [196] [197] 
.field private volatile [198] [199] 

.method public [201] : [202] 
    .attribute [200] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [31] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [200] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     aload_0 
L6:     invokevirtual [16] 
L9:     invokeinterface [34] 0 
L14:    aload_0 
L15:    invokevirtual [17] 
L18:    invokevirtual [18] 
L21:    aload_0 
L22:    aload_0 
L23:    getfield [19] 
L26:    invokespecial [32] 
L29:    putfield [35] 
L32:    aload_0 
L33:    getfield [20] 
L36:    invokevirtual [21] 
L39:    aload_0 
L40:    invokevirtual [16] 
L43:    invokeinterface [36] 0 
L48:    aload_0 
L49:    invokeinterface [37] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [20] 
L11:    invokevirtual [22] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [35] 
L19:    aload_0 
L20:    invokevirtual [16] 
L23:    invokeinterface [36] 0 
L28:    aload_0 
L29:    invokeinterface [38] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [200] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_0 
L5:     getfield [19] 
L8:     sipush 10000 
L11:    ldc [4] 
L13:    invokevirtual [23] 
L16:    pop 
L17:    aconst_null 
L18:    areturn 
L19:    aload_0 
L20:    invokevirtual [16] 
L23:    invokeinterface [34] 0 
L28:    aload_1 
L29:    invokeinterface [39] 0 
L34:    astore_2 
L35:    aload_2 
L36:    ifnonnull L54 
L39:    aload_0 
L40:    getfield [19] 
L43:    sipush 10000 
L46:    ldc [5] 
L48:    invokevirtual [23] 
L51:    pop 
L52:    aconst_null 
L53:    areturn 
L54:    aload_0 
L55:    invokevirtual [17] 
L58:    aload_2 
L59:    invokevirtual [24] 
L62:    ifeq L72 
L65:    aload_0 
L66:    aload_2 
L67:    invokevirtual [25] 
L70:    aload_2 
L71:    areturn 
L72:    aload_0 
L73:    invokevirtual [16] 
L76:    invokeinterface [34] 0 
L81:    aload_1 
L82:    invokeinterface [40] 0 
L87:    pop 
L88:    aconst_null 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public enum [209] : [210] 
    .attribute [200] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [200] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     sipush 10000 
L11:    ldc [6] 
L13:    invokevirtual [23] 
L16:    pop 
L17:    return 
L18:    aload_2 
L19:    ifnonnull L36 
L22:    aload_0 
L23:    getfield [19] 
L26:    sipush 10000 
L29:    ldc [7] 
L31:    invokevirtual [23] 
L34:    pop 
L35:    return 
L36:    aload_0 
L37:    invokevirtual [17] 
L40:    aload_2 
L41:    invokevirtual [24] 
L44:    ifeq L68 
L47:    aload_0 
L48:    aconst_null 
L49:    invokevirtual [25] 
L52:    aload_0 
L53:    invokevirtual [16] 
L56:    invokeinterface [34] 0 
L61:    aload_1 
L62:    invokeinterface [40] 0 
L67:    pop 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [200] .code stack 3 locals 0 
L0:     aload_2 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     sipush 10000 
L11:    ldc [8] 
L13:    invokevirtual [23] 
L16:    pop 
L17:    return 
L18:    aload_0 
L19:    aload_2 
L20:    invokevirtual [26] 
L23:    aload_0 
L24:    iload_1 
L25:    aload_2 
L26:    invokevirtual [27] 
L29:    ifeq L36 
L32:    aload_0 
L33:    invokevirtual [28] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected interface [215] : [216] 
    .attribute [200] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [42] 
L5:     aload_1 
L6:     ifnull L13 
L9:     aload_0 
L10:    invokevirtual [28] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected interface [219] : [220] 
    .attribute [200] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [221] : [222] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [223] : [224] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [225] : [226] 
    .attribute [200] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [41] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [43] 
.const [3] = Class [44] 
.const [4] = String [45] 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = String [48] 
.const [8] = String [49] 
.const [9] = Class [50] 
.const [10] = Class [51] 
.const [11] = Class [52] 
.const [12] = Class [53] 
.const [13] = Class [54] 
.const [14] = Class [55] 
.const [15] = Class [56] 
.const [16] = Method [57] [58] 
.const [17] = Method [59] [60] 
.const [18] = Method [61] [62] 
.const [19] = Field [63] [64] 
.const [20] = Field [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Field [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Class [91] 
.const [34] = InterfaceMethod [92] [93] 
.const [35] = Field [94] [95] 
.const [36] = InterfaceMethod [96] [97] 
.const [37] = InterfaceMethod [98] [99] 
.const [38] = InterfaceMethod [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = Field [106] [107] 
.const [42] = Field [108] [109] 
.const [43] = Utf8 'App.Phone.BAP' 
.const [44] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [45] = Utf8 'AbstractTelBAPPropertyHandler#addingService reference is null' 
.const [46] = Utf8 'AbstractTelBAPPropertyHandler#addingService service is null' 
.const [47] = Utf8 'AbstractTelBAPPropertyHandler#removedService reference is null' 
.const [48] = Utf8 'AbstractTelBAPPropertyHandler#removedService service is null' 
.const [49] = Utf8 'AbstractTelBAPPropertyHandler#updateGlobalTelephoneStateProperty stateStruct is null' 
.const [50] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [51] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [52] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [53] = Utf8 java/lang/Class 
.const [54] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 org/osgi/framework/BundleContext 
.const [57] = Class [110] 
.const [58] = NameAndType [111] [112] 
.const [59] = Class [113] 
.const [60] = NameAndType [114] [115] 
.const [61] = Class [116] 
.const [62] = NameAndType [117] [118] 
.const [63] = Class [119] 
.const [64] = NameAndType [120] [121] 
.const [65] = Class [122] 
.const [66] = NameAndType [123] [124] 
.const [67] = Class [125] 
.const [68] = NameAndType [126] [127] 
.const [69] = Class [128] 
.const [70] = NameAndType [129] [130] 
.const [71] = Class [131] 
.const [72] = NameAndType [132] [133] 
.const [73] = Class [134] 
.const [74] = NameAndType [135] [136] 
.const [75] = Class [137] 
.const [76] = NameAndType [138] [139] 
.const [77] = Class [140] 
.const [78] = NameAndType [141] [142] 
.const [79] = Class [143] 
.const [80] = NameAndType [144] [145] 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Class [179] 
.const [105] = NameAndType [180] [181] 
.const [106] = Class [182] 
.const [107] = NameAndType [183] [184] 
.const [108] = Class [185] 
.const [109] = NameAndType [186] [187] 
.const [110] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [111] = Utf8 getApplication 
.const [112] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [113] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [114] = Utf8 getBAPServiceClazz 
.const [115] = Utf8 ()Ljava/lang/Class; 
.const [116] = Utf8 java/lang/Class 
.const [117] = Utf8 getName 
.const [118] = Utf8 ()Ljava/lang/String; 
.const [119] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [120] = Utf8 log 
.const [121] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [122] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [123] = Utf8 bapServiceTracker 
.const [124] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [125] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [126] = Utf8 openTracker 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [129] = Utf8 closeTracker 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/audi/atip/log/LogChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (ILjava/lang/String;)Z 
.const [134] = Utf8 java/lang/Class 
.const [135] = Utf8 isInstance 
.const [136] = Utf8 (Ljava/lang/Object;)Z 
.const [137] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [138] = Utf8 setBAPService 
.const [139] = Utf8 (Ljava/lang/Object;)V 
.const [140] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [141] = Utf8 setTelephoneState 
.const [142] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [143] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [144] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [145] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [146] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [147] = Utf8 update 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [150] = Utf8 telephoneState 
.const [151] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [152] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [153] = Utf8 combiService 
.const [154] = Utf8 Ljava/lang/Object; 
.const [155] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [158] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [161] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [162] = Utf8 getBundleContext 
.const [163] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [164] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [165] = Utf8 bapServiceTracker 
.const [166] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [167] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [168] = Utf8 getGlobalTelephoneStateManager 
.const [169] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [170] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [171] = Utf8 registerListener 
.const [172] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [173] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [174] = Utf8 removeListener 
.const [175] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [176] = Utf8 org/osgi/framework/BundleContext 
.const [177] = Utf8 getService 
.const [178] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [179] = Utf8 org/osgi/framework/BundleContext 
.const [180] = Utf8 ungetService 
.const [181] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [182] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [183] = Utf8 telephoneState 
.const [184] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [185] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [186] = Utf8 combiService 
.const [187] = Utf8 Ljava/lang/Object; 
.const [188] = Utf8 de/audi/app/phone/core/bap/AbstractTelBAPPropertyHandler 
.const [189] = Class [188] 
.const [190] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [191] = Class [190] 
.const [192] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [193] = Class [192] 
.const [194] = Utf8 bapServiceTracker 
.const [195] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [196] = Utf8 telephoneState 
.const [197] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [198] = Utf8 combiService 
.const [199] = Utf8 Ljava/lang/Object; 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [203] = Utf8 init 
.const [204] = Utf8 ()V 
.const [205] = Utf8 deinit 
.const [206] = Utf8 ()V 
.const [207] = Utf8 addingService 
.const [208] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [209] = Utf8 modifiedService 
.const [210] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [211] = Utf8 removedService 
.const [212] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [213] = Utf8 updateGlobalTelephoneStateProperty 
.const [214] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [215] = Utf8 getTelephoneState 
.const [216] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [217] = Utf8 setBAPService 
.const [218] = Utf8 (Ljava/lang/Object;)V 
.const [219] = Utf8 getCombiService 
.const [220] = Utf8 ()Ljava/lang/Object; 
.const [221] = Utf8 getBAPServiceClazz 
.const [222] = Utf8 ()Ljava/lang/Class; 
.const [223] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [224] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [225] = Utf8 update 
.const [226] = Utf8 ()V 
.const [227] = Utf8 setTelephoneState 
.const [228] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.end class 
