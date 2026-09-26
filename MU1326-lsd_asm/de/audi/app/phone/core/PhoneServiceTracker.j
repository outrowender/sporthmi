.version 50 0 
.class public super [178] 
.super [180] 
.implements [182] 
.field private [183] [184] 
.field private final [185] [186] 
.field private final [187] [188] 
.field private final [189] [190] 
.field private final [191] [192] 

.method public [194] : [195] 
    .attribute [193] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload 4 
L7:     putfield [34] 
L10:    aload_0 
L11:    iconst_1 
L12:    anewarray [2] 
L15:    dup 
L16:    iconst_0 
L17:    aload_2 
L18:    aastore 
L19:    putfield [35] 
L22:    aload_0 
L23:    aload_3 
L24:    putfield [36] 
L27:    aload_0 
L28:    aload_1 
L29:    putfield [37] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [193] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload 4 
L7:     putfield [34] 
L10:    aload_0 
L11:    aload_2 
L12:    putfield [35] 
L15:    aload_0 
L16:    aload_3 
L17:    putfield [36] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [37] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [193] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    new [38] 
L17:    dup 
L18:    aload_0 
L19:    getfield [22] 
L22:    aload_0 
L23:    getfield [20] 
L26:    aload_0 
L27:    invokespecial [32] 
L30:    putfield [39] 
L33:    aload_0 
L34:    getfield [24] 
L37:    invokevirtual [25] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [193] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [6] 
L8:     aload_0 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [24] 
L17:    invokevirtual [26] 
L20:    aload_0 
L21:    aconst_null 
L22:    putfield [39] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [193] .code stack 3 locals 2 
L0:     new [40] 
L3:     dup 
L4:     invokespecial [33] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [8] 
L11:    invokevirtual [27] 
L14:    pop 
L15:    iconst_0 
L16:    istore_2 
L17:    iload_2 
L18:    aload_0 
L19:    getfield [20] 
L22:    arraylength 
L23:    if_icmpge L61 
L26:    aload_1 
L27:    aload_0 
L28:    getfield [20] 
L31:    iload_2 
L32:    aaload 
L33:    invokevirtual [27] 
L36:    pop 
L37:    iload_2 
L38:    aload_0 
L39:    getfield [20] 
L42:    arraylength 
L43:    iconst_1 
L44:    isub 
L45:    if_icmpge L55 
L48:    aload_1 
L49:    ldc [9] 
L51:    invokevirtual [27] 
L54:    pop 
L55:    iinc 2 1 
L58:    goto L17 
L61:    aload_1 
L62:    ldc [10] 
L64:    invokevirtual [27] 
L67:    pop 
L68:    aload_1 
L69:    ldc [11] 
L71:    invokevirtual [27] 
L74:    pop 
L75:    aload_1 
L76:    aload_0 
L77:    getfield [21] 
L80:    invokevirtual [28] 
L83:    pop 
L84:    aload_1 
L85:    invokevirtual [29] 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [193] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [12] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [21] 
L17:    aload_1 
L18:    invokeinterface [41] 0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [193] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [13] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [30] 
L13:    aload_0 
L14:    getfield [21] 
L17:    aload_1 
L18:    aload_2 
L19:    invokeinterface [42] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [193] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [14] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [30] 
L13:    aload_0 
L14:    getfield [21] 
L17:    aload_1 
L18:    aload_2 
L19:    invokeinterface [43] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = Int 1078071040 
.const [4] = String [45] 
.const [5] = Class [46] 
.const [6] = String [47] 
.const [7] = Class [48] 
.const [8] = String [49] 
.const [9] = String [50] 
.const [10] = String [51] 
.const [11] = String [52] 
.const [12] = String [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Class [58] 
.const [18] = Class [59] 
.const [19] = Field [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Field [96] [97] 
.const [38] = Class [98] 
.const [39] = Field [99] [100] 
.const [40] = Class [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = InterfaceMethod [104] [105] 
.const [43] = InterfaceMethod [106] [107] 
.const [44] = Utf8 java/lang/String 
.const [45] = Utf8 '[PhoneServiceTracker#openTracker] %1' 
.const [46] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [47] = Utf8 '[PhoneServiceTracker#closeTracker] %1' 
.const [48] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [49] = Utf8 'PhoneServiceTracker: trackedServices=[' 
.const [50] = Utf8 ', ' 
.const [51] = Utf8 ']' 
.const [52] = Utf8 ', customizer=' 
.const [53] = Utf8 '[PhoneServiceTracker#addingService] reference=%1' 
.const [54] = Utf8 '[PhoneServiceTracker#modifiedService] reference=%1, service=%2' 
.const [55] = Utf8 '[PhoneServiceTracker#removedService] reference=%1, service=%2' 
.const [56] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Class [111] 
.const [63] = NameAndType [112] [113] 
.const [64] = Class [114] 
.const [65] = NameAndType [115] [116] 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [99] = Class [165] 
.const [100] = NameAndType [166] [167] 
.const [101] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [102] = Class [168] 
.const [103] = NameAndType [169] [170] 
.const [104] = Class [171] 
.const [105] = NameAndType [172] [173] 
.const [106] = Class [174] 
.const [107] = NameAndType [175] [176] 
.const [108] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [109] = Utf8 log 
.const [110] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [111] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [112] = Utf8 trackedServices 
.const [113] = Utf8 [Ljava/lang/String; 
.const [114] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [115] = Utf8 customizer 
.const [116] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [117] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [118] = Utf8 bundleContext 
.const [119] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [123] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [124] = Utf8 tracker 
.const [125] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [126] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [127] = Utf8 'open' 
.const [128] = Utf8 ()V 
.const [129] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [130] = Utf8 close 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [135] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [138] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [139] = Utf8 toString 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 de/audi/atip/log/LogChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [144] = Utf8 java/lang/Object 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [150] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [154] = Utf8 log 
.const [155] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [157] = Utf8 trackedServices 
.const [158] = Utf8 [Ljava/lang/String; 
.const [159] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [160] = Utf8 customizer 
.const [161] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [162] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [163] = Utf8 bundleContext 
.const [164] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [165] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [166] = Utf8 tracker 
.const [167] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [168] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [169] = Utf8 addingService 
.const [170] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [171] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [172] = Utf8 modifiedService 
.const [173] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [174] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [175] = Utf8 removedService 
.const [176] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [177] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [178] = Class [177] 
.const [179] = Utf8 java/lang/Object 
.const [180] = Class [179] 
.const [181] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [182] = Class [181] 
.const [183] = Utf8 tracker 
.const [184] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [185] = Utf8 trackedServices 
.const [186] = Utf8 [Ljava/lang/String; 
.const [187] = Utf8 customizer 
.const [188] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [189] = Utf8 log 
.const [190] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [191] = Utf8 bundleContext 
.const [192] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [193] = Utf8 Code 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [198] = Utf8 openTracker 
.const [199] = Utf8 ()V 
.const [200] = Utf8 closeTracker 
.const [201] = Utf8 ()V 
.const [202] = Utf8 toString 
.const [203] = Utf8 ()Ljava/lang/String; 
.const [204] = Utf8 addingService 
.const [205] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [206] = Utf8 modifiedService 
.const [207] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [208] = Utf8 removedService 
.const [209] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
