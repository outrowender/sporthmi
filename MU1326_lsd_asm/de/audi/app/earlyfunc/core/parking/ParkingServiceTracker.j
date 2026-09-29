.version 50 0 
.class public super [176] 
.super [178] 
.implements [180] 
.field private [181] [182] 
.field private final [183] [184] 
.field private final [185] [186] 
.field private final [187] [188] 
.field private final [189] [190] 

.method public [192] : [193] 
    .attribute [191] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    iconst_1 
L11:    anewarray [2] 
L14:    dup 
L15:    iconst_0 
L16:    aload_2 
L17:    aastore 
L18:    putfield [34] 
L21:    aload_0 
L22:    aload_3 
L23:    putfield [35] 
L26:    aload_0 
L27:    aload 4 
L29:    putfield [36] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [191] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [34] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [35] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [36] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [191] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [22] 
L12:    pop 
L13:    aload_0 
L14:    new [37] 
L17:    dup 
L18:    aload_0 
L19:    getfield [18] 
L22:    aload_0 
L23:    getfield [19] 
L26:    aload_0 
L27:    invokespecial [31] 
L30:    putfield [38] 
L33:    aload_0 
L34:    getfield [23] 
L37:    invokevirtual [24] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [191] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [6] 
L8:     aload_0 
L9:     invokevirtual [22] 
L12:    pop 
L13:    aload_0 
L14:    getfield [23] 
L17:    ifnull L32 
L20:    aload_0 
L21:    getfield [23] 
L24:    invokevirtual [25] 
L27:    aload_0 
L28:    aconst_null 
L29:    putfield [38] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [191] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     aload_1 
L9:     invokevirtual [22] 
L12:    pop 
L13:    aload_0 
L14:    getfield [20] 
L17:    aload_1 
L18:    invokeinterface [39] 0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [191] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [26] 
L13:    aload_0 
L14:    getfield [20] 
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

.method public [204] : [205] 
    .attribute [191] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [26] 
L13:    aload_0 
L14:    getfield [20] 
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

.method public [206] : [207] 
    .attribute [191] .code stack 3 locals 2 
L0:     new [42] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [10] 
L11:    invokevirtual [27] 
L14:    pop 
L15:    iconst_0 
L16:    istore_2 
L17:    iload_2 
L18:    aload_0 
L19:    getfield [19] 
L22:    arraylength 
L23:    if_icmpge L61 
L26:    aload_1 
L27:    aload_0 
L28:    getfield [19] 
L31:    iload_2 
L32:    aaload 
L33:    invokevirtual [27] 
L36:    pop 
L37:    iload_2 
L38:    aload_0 
L39:    getfield [19] 
L42:    arraylength 
L43:    iconst_1 
L44:    isub 
L45:    if_icmpge L55 
L48:    aload_1 
L49:    ldc [11] 
L51:    invokevirtual [27] 
L54:    pop 
L55:    iinc 2 1 
L58:    goto L17 
L61:    aload_1 
L62:    ldc [12] 
L64:    invokevirtual [27] 
L67:    pop 
L68:    aload_1 
L69:    ldc [13] 
L71:    invokevirtual [27] 
L74:    pop 
L75:    aload_1 
L76:    aload_0 
L77:    getfield [20] 
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
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = Int 1078071040 
.const [4] = String [44] 
.const [5] = Class [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = Class [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = String [52] 
.const [13] = String [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Field [58] [59] 
.const [19] = Field [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Field [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = Class [105] 
.const [43] = Utf8 java/lang/String 
.const [44] = Utf8 '[ParkingServiceTracker#openTracker] %1' 
.const [45] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [46] = Utf8 '[ParkingServiceTracker#closeTracker] %1' 
.const [47] = Utf8 '[ParkingServiceTracker#addingService] reference=%1' 
.const [48] = Utf8 '[ParkingServiceTracker#modifiedService] reference=%1, service=%2' 
.const [49] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [50] = Utf8 'ParkingServiceTracker: trackedServices=[' 
.const [51] = Utf8 ', ' 
.const [52] = Utf8 ']' 
.const [53] = Utf8 ', customizer=' 
.const [54] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [57] = Utf8 de/audi/atip/log/LogChannel 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Class [151] 
.const [89] = NameAndType [152] [153] 
.const [90] = Class [154] 
.const [91] = NameAndType [155] [156] 
.const [92] = Class [157] 
.const [93] = NameAndType [158] [159] 
.const [94] = Class [160] 
.const [95] = NameAndType [161] [162] 
.const [96] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [97] = Class [163] 
.const [98] = NameAndType [164] [165] 
.const [99] = Class [166] 
.const [100] = NameAndType [167] [168] 
.const [101] = Class [169] 
.const [102] = NameAndType [170] [171] 
.const [103] = Class [172] 
.const [104] = NameAndType [173] [174] 
.const [105] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [106] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [107] = Utf8 bundleContext 
.const [108] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [109] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [110] = Utf8 trackedServices 
.const [111] = Utf8 [Ljava/lang/String; 
.const [112] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [113] = Utf8 customizer 
.const [114] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [115] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [116] = Utf8 logChannel 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/audi/atip/log/LogChannel 
.const [119] = Utf8 log 
.const [120] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [121] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [122] = Utf8 tracker 
.const [123] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [124] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [125] = Utf8 'open' 
.const [126] = Utf8 ()V 
.const [127] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [128] = Utf8 close 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 log 
.const [132] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [136] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [139] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [140] = Utf8 toString 
.const [141] = Utf8 ()Ljava/lang/String; 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [148] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [152] = Utf8 bundleContext 
.const [153] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [154] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [155] = Utf8 trackedServices 
.const [156] = Utf8 [Ljava/lang/String; 
.const [157] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [158] = Utf8 customizer 
.const [159] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [160] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [161] = Utf8 logChannel 
.const [162] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [163] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [164] = Utf8 tracker 
.const [165] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [166] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [167] = Utf8 addingService 
.const [168] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [169] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [170] = Utf8 modifiedService 
.const [171] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [172] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [173] = Utf8 removedService 
.const [174] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [175] = Utf8 de/audi/app/earlyfunc/core/parking/ParkingServiceTracker 
.const [176] = Class [175] 
.const [177] = Utf8 java/lang/Object 
.const [178] = Class [177] 
.const [179] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [180] = Class [179] 
.const [181] = Utf8 tracker 
.const [182] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [183] = Utf8 bundleContext 
.const [184] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [185] = Utf8 trackedServices 
.const [186] = Utf8 [Ljava/lang/String; 
.const [187] = Utf8 customizer 
.const [188] = Utf8 Lorg/osgi/util/tracker/ServiceTrackerCustomizer; 
.const [189] = Utf8 logChannel 
.const [190] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [191] = Utf8 Code 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [196] = Utf8 openTracker 
.const [197] = Utf8 ()V 
.const [198] = Utf8 closeTracker 
.const [199] = Utf8 ()V 
.const [200] = Utf8 addingService 
.const [201] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [202] = Utf8 modifiedService 
.const [203] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [204] = Utf8 removedService 
.const [205] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [206] = Utf8 toString 
.const [207] = Utf8 ()Ljava/lang/String; 
.end class 
