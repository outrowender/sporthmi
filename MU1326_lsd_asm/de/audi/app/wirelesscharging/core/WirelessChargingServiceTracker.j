.version 50 0 
.class public super [166] 
.super [168] 
.implements [170] 
.field private final [171] [172] 
.field private final [173] [174] 
.field private final [175] [176] 
.field private final [177] [178] 

.method public [180] : [181] 
    .attribute [179] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload 4 
L7:     putfield [33] 
L10:    aload_0 
L11:    iconst_1 
L12:    anewarray [2] 
L15:    dup 
L16:    iconst_0 
L17:    aload_2 
L18:    aastore 
L19:    putfield [34] 
L22:    aload_0 
L23:    aload_3 
L24:    putfield [35] 
L27:    aload_0 
L28:    new [36] 
L31:    dup 
L32:    aload_1 
L33:    aload_0 
L34:    getfield [20] 
L37:    aload_0 
L38:    invokespecial [31] 
L41:    putfield [37] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [182] : [183] 
    .attribute [179] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload 4 
L7:     putfield [33] 
L10:    aload_0 
L11:    aload_2 
L12:    putfield [34] 
L15:    aload_0 
L16:    aload_3 
L17:    putfield [35] 
L20:    aload_0 
L21:    new [36] 
L24:    dup 
L25:    aload_1 
L26:    aload_0 
L27:    getfield [20] 
L30:    aload_0 
L31:    invokespecial [31] 
L34:    putfield [37] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [179] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [22] 
L17:    invokevirtual [24] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [179] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [4] 
L6:     ldc [6] 
L8:     aload_0 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [22] 
L17:    invokevirtual [25] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [179] .code stack 3 locals 2 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [8] 
L11:    invokevirtual [26] 
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
L33:    invokevirtual [26] 
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
L51:    invokevirtual [26] 
L54:    pop 
L55:    iinc 2 1 
L58:    goto L17 
L61:    aload_1 
L62:    ldc [10] 
L64:    invokevirtual [26] 
L67:    pop 
L68:    aload_1 
L69:    ldc [11] 
L71:    invokevirtual [26] 
L74:    pop 
L75:    aload_1 
L76:    aload_0 
L77:    getfield [21] 
L80:    invokevirtual [27] 
L83:    pop 
L84:    aload_1 
L85:    invokevirtual [28] 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [179] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [4] 
L6:     ldc [12] 
L8:     aload_1 
L9:     invokevirtual [23] 
L12:    pop 
L13:    aload_0 
L14:    getfield [21] 
L17:    aload_1 
L18:    invokeinterface [39] 0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [192] : [193] 
    .attribute [179] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [4] 
L6:     ldc [13] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [29] 
L13:    aload_0 
L14:    getfield [21] 
L17:    aload_1 
L18:    aload_2 
L19:    invokeinterface [40] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [179] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [4] 
L6:     ldc [14] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [29] 
L13:    aload_0 
L14:    getfield [21] 
L17:    aload_1 
L18:    aload_2 
L19:    invokeinterface [41] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = Class [43] 
.const [4] = Int 1078071040 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = Class [46] 
.const [8] = String [47] 
.const [9] = String [48] 
.const [10] = String [49] 
.const [11] = String [50] 
.const [12] = String [51] 
.const [13] = String [52] 
.const [14] = String [53] 
.const [15] = Class [54] 
.const [16] = Class [55] 
.const [17] = Class [56] 
.const [18] = Class [57] 
.const [19] = Field [58] [59] 
.const [20] = Field [60] [61] 
.const [21] = Field [62] [63] 
.const [22] = Field [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Field [86] [87] 
.const [34] = Field [88] [89] 
.const [35] = Field [90] [91] 
.const [36] = Class [92] 
.const [37] = Field [93] [94] 
.const [38] = Class [95] 
.const [39] = InterfaceMethod [96] [97] 
.const [40] = InterfaceMethod [98] [99] 
.const [41] = InterfaceMethod [100] [101] 
.const [42] = Utf8 java/lang/String 
.const [43] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [44] = Utf8 '[WirelessChargingServiceTracker#openTracker] %1' 
.const [45] = Utf8 '[WirelessChargingServiceTracker#closeTracker] %1' 
.const [46] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [47] = Utf8 'WirelessChargingServiceTracker: trackedServices=[' 
.const [48] = Utf8 ', ' 
.const [49] = Utf8 ']' 
.const [50] = Utf8 ', customizer=c' 
.const [51] = Utf8 '[WirelessChargingServiceTracker#addingService] reference=%1' 
.const [52] = Utf8 '[WirelessChargingServiceTracker#modifiedService] reference=%1, service=%2' 
.const [53] = Utf8 '[WirelessChargingServiceTracker#removedService] reference=%1, service=%2' 
.const [54] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [57] = Utf8 de/audi/atip/log/LogChannel 
.const [58] = Class [102] 
.const [59] = NameAndType [103] [104] 
.const [60] = Class [105] 
.const [61] = NameAndType [106] [107] 
.const [62] = Class [108] 
.const [63] = NameAndType [109] [110] 
.const [64] = Class [111] 
.const [65] = NameAndType [112] [113] 
.const [66] = Class [114] 
.const [67] = NameAndType [115] [116] 
.const [68] = Class [117] 
.const [69] = NameAndType [118] [119] 
.const [70] = Class [120] 
.const [71] = NameAndType [121] [122] 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Class [126] 
.const [75] = NameAndType [127] [128] 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Class [132] 
.const [79] = NameAndType [133] [134] 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Class [138] 
.const [83] = NameAndType [139] [140] 
.const [84] = Class [141] 
.const [85] = NameAndType [142] [143] 
.const [86] = Class [144] 
.const [87] = NameAndType [145] [146] 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Class [150] 
.const [91] = NameAndType [151] [152] 
.const [92] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [93] = Class [153] 
.const [94] = NameAndType [154] [155] 
.const [95] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [96] = Class [156] 
.const [97] = NameAndType [157] [158] 
.const [98] = Class [159] 
.const [99] = NameAndType [160] [161] 
.const [100] = Class [162] 
.const [101] = NameAndType [163] [164] 
.const [102] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [103] = Utf8 log 
.const [104] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [105] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [106] = Utf8 trackedServices 
.const [107] = Utf8 [Ljava/lang/String; 
.const [108] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [109] = Utf8 customizer 
.const [110] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [111] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [112] = Utf8 tracker 
.const [113] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [117] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [118] = Utf8 'open' 
.const [119] = Utf8 ()V 
.const [120] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [121] = Utf8 close 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [124] = Utf8 append 
.const [125] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [126] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [127] = Utf8 append 
.const [128] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [129] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [130] = Utf8 toString 
.const [131] = Utf8 ()Ljava/lang/String; 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 log 
.const [134] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [145] = Utf8 log 
.const [146] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [147] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [148] = Utf8 trackedServices 
.const [149] = Utf8 [Ljava/lang/String; 
.const [150] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [151] = Utf8 customizer 
.const [152] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [153] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [154] = Utf8 tracker 
.const [155] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [156] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [157] = Utf8 addingService 
.const [158] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [159] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [160] = Utf8 modifiedService 
.const [161] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [162] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [163] = Utf8 removedService 
.const [164] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [165] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceTracker 
.const [166] = Class [165] 
.const [167] = Utf8 java/lang/Object 
.const [168] = Class [167] 
.const [169] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [170] = Class [169] 
.const [171] = Utf8 tracker 
.const [172] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [173] = Utf8 trackedServices 
.const [174] = Utf8 [Ljava/lang/String; 
.const [175] = Utf8 customizer 
.const [176] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [177] = Utf8 log 
.const [178] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [179] = Utf8 Code 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [184] = Utf8 openTracker 
.const [185] = Utf8 ()V 
.const [186] = Utf8 closeTracker 
.const [187] = Utf8 ()V 
.const [188] = Utf8 toString 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 addingService 
.const [191] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [192] = Utf8 modifiedService 
.const [193] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [194] = Utf8 removedService 
.const [195] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
