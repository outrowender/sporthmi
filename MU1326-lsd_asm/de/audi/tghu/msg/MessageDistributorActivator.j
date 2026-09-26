.version 50 0 
.class public super [151] 
.super [153] 
.field private [154] [155] 
.field private [156] [157] 
.field static synthetic [158] [159] 

.method public [161] : [162] 
    .attribute [160] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [24] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [163] : [164] 
    .attribute [160] .code stack 8 locals 0 
L0:     aload_0 
L1:     new [32] 
L4:     dup 
L5:     aload_0 
L6:     getfield [15] 
L9:     invokespecial [25] 
L12:    putfield [30] 
L15:    aload_0 
L16:    new [33] 
L19:    dup 
L20:    aload_0 
L21:    invokevirtual [18] 
L24:    getstatic [8] 
L27:    ifnonnull L42 
L30:    ldc [9] 
L32:    invokestatic [10] 
L35:    dup 
L36:    putstatic [26] 
L39:    goto L45 
L42:    getstatic [8] 
L45:    invokevirtual [19] 
L48:    new [34] 
L51:    dup 
L52:    aload_0 
L53:    invokespecial [27] 
L56:    invokespecial [28] 
L59:    putfield [35] 
L62:    aload_0 
L63:    getfield [20] 
L66:    invokevirtual [21] 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [160] .code stack 2 locals 0 
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
L20:    aload_1 
L21:    invokespecial [29] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [167] : [168] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [169] : [170] 
    .attribute [160] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [31] 
L9:     dup 
L10:    invokespecial [23] 
L13:    aload_1 
L14:    invokevirtual [17] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [171] : [172] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [173] : [174] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [175] : [176] 
    .attribute [160] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Class [38] 
.const [4] = Class [39] 
.const [5] = String [40] 
.const [6] = Class [41] 
.const [7] = Class [42] 
.const [8] = Field [43] [44] 
.const [9] = String [45] 
.const [10] = Method [46] [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Field [52] [53] 
.const [16] = Field [54] [55] 
.const [17] = Method [56] [57] 
.const [18] = Method [58] [59] 
.const [19] = Method [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Field [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Class [84] 
.const [32] = Class [85] 
.const [33] = Class [86] 
.const [34] = Class [87] 
.const [35] = Field [88] [89] 
.const [36] = Class [90] 
.const [37] = NameAndType [91] [92] 
.const [38] = Utf8 java/lang/ClassNotFoundException 
.const [39] = Utf8 java/lang/NoClassDefFoundError 
.const [40] = Utf8 MessageDistributor 
.const [41] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [42] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [43] = Class [93] 
.const [44] = NameAndType [94] [95] 
.const [45] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [46] = Class [96] 
.const [47] = NameAndType [97] [98] 
.const [48] = Utf8 de/audi/tghu/msg/MessageDistributorActivator$1 
.const [49] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [50] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [51] = Utf8 java/lang/Class 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Utf8 java/lang/NoClassDefFoundError 
.const [85] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [86] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [87] = Utf8 de/audi/tghu/msg/MessageDistributorActivator$1 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Utf8 java/lang/Class 
.const [91] = Utf8 forName 
.const [92] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [93] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [94] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [95] = Utf8 Ljava/lang/Class; 
.const [96] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [97] = Utf8 class$ 
.const [98] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [99] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [100] = Utf8 framework 
.const [101] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [102] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [103] = Utf8 messageDistributor 
.const [104] = Utf8 Lde/audi/tghu/msg/MessageDistributorImpl; 
.const [105] = Utf8 java/lang/NoClassDefFoundError 
.const [106] = Utf8 initCause 
.const [107] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [108] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [109] = Utf8 getBundleContext 
.const [110] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [111] = Utf8 java/lang/Class 
.const [112] = Utf8 getName 
.const [113] = Utf8 ()Ljava/lang/String; 
.const [114] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [115] = Utf8 tracker 
.const [116] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [117] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [118] = Utf8 'open' 
.const [119] = Utf8 ()V 
.const [120] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [121] = Utf8 close 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/NoClassDefFoundError 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Ljava/lang/String;)V 
.const [129] = Utf8 de/audi/tghu/msg/MessageDistributorImpl 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [132] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [133] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [134] = Utf8 Ljava/lang/Class; 
.const [135] = Utf8 de/audi/tghu/msg/MessageDistributorActivator$1 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/tghu/msg/MessageDistributorActivator;)V 
.const [138] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [141] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [142] = Utf8 stop 
.const [143] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [144] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [145] = Utf8 messageDistributor 
.const [146] = Utf8 Lde/audi/tghu/msg/MessageDistributorImpl; 
.const [147] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [148] = Utf8 tracker 
.const [149] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [150] = Utf8 de/audi/tghu/msg/MessageDistributorActivator 
.const [151] = Class [150] 
.const [152] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [153] = Class [152] 
.const [154] = Utf8 messageDistributor 
.const [155] = Utf8 Lde/audi/tghu/msg/MessageDistributorImpl; 
.const [156] = Utf8 tracker 
.const [157] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [158] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [159] = Utf8 Ljava/lang/Class; 
.const [160] = Utf8 Code 
.const [161] = Utf8 <init> 
.const [162] = Utf8 ()V 
.const [163] = Utf8 startInternal 
.const [164] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [165] = Utf8 stop 
.const [166] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [167] = Utf8 getService 
.const [168] = Utf8 ()Lde/audi/tghu/msg/MessageDistributorImpl; 
.const [169] = Utf8 class$ 
.const [170] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [171] = Utf8 access$000 
.const [172] = Utf8 (Lde/audi/tghu/msg/MessageDistributorActivator;)Lde/audi/atip/base/IFrameworkAccess; 
.const [173] = Utf8 access$100 
.const [174] = Utf8 (Lde/audi/tghu/msg/MessageDistributorActivator;)Lde/audi/tghu/msg/MessageDistributorImpl; 
.const [175] = Utf8 access$200 
.const [176] = Utf8 (Lde/audi/tghu/msg/MessageDistributorActivator;)Lde/audi/atip/base/IFrameworkAccess; 
.end class 
