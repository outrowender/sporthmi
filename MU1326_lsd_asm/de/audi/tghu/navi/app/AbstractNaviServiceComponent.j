.version 50 0 
.class public super abstract [126] 
.super [128] 
.implements [130] 
.implements [132] 
.field protected final [133] [134] 
.field protected volatile [135] [136] 
.field private volatile [137] [138] 

.method public [140] : [141] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [22] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [23] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [24] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [139] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [23] 
L5:     aload_0 
L6:     new [25] 
L9:     dup 
L10:    aload_1 
L11:    aload_0 
L12:    invokevirtual [12] 
L15:    aload_0 
L16:    invokespecial [21] 
L19:    putfield [22] 
L22:    aload_0 
L23:    getfield [9] 
L26:    invokevirtual [13] 
L29:    aload_0 
L30:    invokevirtual [14] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [9] 
L11:    invokevirtual [15] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [22] 
L19:    aload_0 
L20:    invokevirtual [16] 
L23:    aload_0 
L24:    aconst_null 
L25:    putfield [23] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [146] : [147] 
    .attribute [139] .code stack 3 locals 1 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     getfield [10] 
L6:     ifnull L53 
L9:     aload_0 
L10:    getfield [10] 
L13:    aload_1 
L14:    invokeinterface [26] 0 
L19:    astore_2 
L20:    aload_0 
L21:    aload_2 
L22:    invokevirtual [17] 
L25:    ifne L53 
L28:    aload_0 
L29:    getfield [10] 
L32:    aload_1 
L33:    invokeinterface [27] 0 
L38:    pop 
L39:    aload_0 
L40:    getfield [11] 
L43:    ldc [3] 
L45:    ldc [4] 
L47:    invokevirtual [18] 
L50:    pop 
L51:    aconst_null 
L52:    astore_2 
L53:    aload_2 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public enum [148] : [149] 
    .attribute [139] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifnull L18 
L7:     aload_0 
L8:     getfield [10] 
L11:    aload_1 
L12:    invokeinterface [27] 0 
L17:    pop 
L18:    aload_0 
L19:    aload_2 
L20:    invokevirtual [19] 
L23:    pop 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected abstract [152] : [153] 
    .attribute [139] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [154] : [155] 
    .attribute [139] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [156] : [157] 
    .attribute [139] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [158] : [159] 
    .attribute [139] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [160] : [161] 
    .attribute [139] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Int -1601830656 
.const [4] = String [29] 
.const [5] = Class [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Field [34] [35] 
.const [10] = Field [36] [37] 
.const [11] = Field [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Class [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [29] = Utf8 '[AbstractNaviServiceComponent] not adding unwanted service!' 
.const [30] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 org/osgi/framework/BundleContext 
.const [33] = Utf8 de/audi/atip/log/LogChannel 
.const [34] = Class [71] 
.const [35] = NameAndType [72] [73] 
.const [36] = Class [74] 
.const [37] = NameAndType [75] [76] 
.const [38] = Class [77] 
.const [39] = NameAndType [78] [79] 
.const [40] = Class [80] 
.const [41] = NameAndType [81] [82] 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Class [110] 
.const [61] = NameAndType [111] [112] 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Class [116] 
.const [65] = NameAndType [117] [118] 
.const [66] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [72] = Utf8 tracker 
.const [73] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [74] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [75] = Utf8 context 
.const [76] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [77] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [78] = Utf8 logChannel 
.const [79] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [80] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [81] = Utf8 getTrackedService 
.const [82] = Utf8 ()[Ljava/lang/String; 
.const [83] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [84] = Utf8 'open' 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [87] = Utf8 onStart 
.const [88] = Utf8 ()V 
.const [89] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [90] = Utf8 close 
.const [91] = Utf8 ()V 
.const [92] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [93] = Utf8 onStop 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [96] = Utf8 trackedServiceAdded 
.const [97] = Utf8 (Ljava/lang/Object;)Z 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (ILjava/lang/String;)Z 
.const [101] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [102] = Utf8 trackedServiceRemoved 
.const [103] = Utf8 (Ljava/lang/Object;)Z 
.const [104] = Utf8 java/lang/Object 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [110] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [111] = Utf8 tracker 
.const [112] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [113] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [114] = Utf8 context 
.const [115] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [116] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [117] = Utf8 logChannel 
.const [118] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [119] = Utf8 org/osgi/framework/BundleContext 
.const [120] = Utf8 getService 
.const [121] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [122] = Utf8 org/osgi/framework/BundleContext 
.const [123] = Utf8 ungetService 
.const [124] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [125] = Utf8 de/audi/tghu/navi/app/AbstractNaviServiceComponent 
.const [126] = Class [125] 
.const [127] = Utf8 java/lang/Object 
.const [128] = Class [127] 
.const [129] = Utf8 org/osgi/framework/BundleActivator 
.const [130] = Class [129] 
.const [131] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [132] = Class [131] 
.const [133] = Utf8 logChannel 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 tracker 
.const [136] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [137] = Utf8 context 
.const [138] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [139] = Utf8 Code 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [142] = Utf8 start 
.const [143] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [144] = Utf8 stop 
.const [145] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [146] = Utf8 addingService 
.const [147] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [148] = Utf8 modifiedService 
.const [149] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [150] = Utf8 removedService 
.const [151] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [152] = Utf8 getTrackedService 
.const [153] = Utf8 ()[Ljava/lang/String; 
.const [154] = Utf8 trackedServiceAdded 
.const [155] = Utf8 (Ljava/lang/Object;)Z 
.const [156] = Utf8 trackedServiceRemoved 
.const [157] = Utf8 (Ljava/lang/Object;)Z 
.const [158] = Utf8 onStart 
.const [159] = Utf8 ()V 
.const [160] = Utf8 onStop 
.const [161] = Utf8 ()V 
.end class 
