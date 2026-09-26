.version 50 0 
.class public super [177] 
.super [179] 
.implements [181] 
.field private static [182] [183] 
.field private [184] [185] 
.field private [186] [187] 
.field static synthetic [188] [189] 

.method public [191] : [192] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [27] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [193] : [194] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [195] : [196] 
    .attribute [190] .code stack 6 locals 0 
L0:     aload_1 
L1:     putstatic [28] 
L4:     aload_0 
L5:     new [35] 
L8:     dup 
L9:     aload_0 
L10:    getfield [20] 
L13:    invokespecial [29] 
L16:    putfield [34] 
L19:    aload_0 
L20:    new [36] 
L23:    dup 
L24:    getstatic [6] 
L27:    getstatic [9] 
L30:    ifnonnull L45 
L33:    ldc [10] 
L35:    invokestatic [11] 
L38:    dup 
L39:    putstatic [30] 
L42:    goto L48 
L45:    getstatic [9] 
L48:    invokevirtual [21] 
L51:    aload_0 
L52:    invokespecial [31] 
L55:    putfield [37] 
L58:    aload_0 
L59:    getfield [22] 
L62:    invokevirtual [23] 
L65:    aload_0 
L66:    getfield [20] 
L69:    getstatic [9] 
L72:    ifnonnull L87 
L75:    ldc [10] 
L77:    invokestatic [11] 
L80:    dup 
L81:    putstatic [30] 
L84:    goto L90 
L87:    getstatic [9] 
L90:    invokevirtual [21] 
L93:    iconst_0 
L94:    invokeinterface [38] 0 
L99:    pop 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [22] 
L11:    invokevirtual [24] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [37] 
L19:    aload_0 
L20:    aload_1 
L21:    invokespecial [32] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [190] .code stack 2 locals 1 
L0:     getstatic [6] 
L3:     aload_1 
L4:     invokeinterface [39] 0 
L9:     astore_2 
L10:    aload_2 
L11:    instanceof [12] 
L14:    ifeq L31 
L17:    aload_0 
L18:    getfield [19] 
L21:    aload_2 
L22:    checkcast [12] 
L25:    invokevirtual [25] 
L28:    goto L33 
L31:    aconst_null 
L32:    areturn 
L33:    aload_1 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public enum [201] : [202] 
    .attribute [190] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     aconst_null 
L5:     invokevirtual [25] 
L8:     getstatic [6] 
L11:    aload_1 
L12:    invokeinterface [40] 0 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [205] : [206] 
    .attribute [190] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [33] 
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
.const [2] = Method [41] [42] 
.const [3] = Class [43] 
.const [4] = Class [44] 
.const [5] = String [45] 
.const [6] = Field [46] [47] 
.const [7] = Class [48] 
.const [8] = Class [49] 
.const [9] = Field [50] [51] 
.const [10] = String [52] 
.const [11] = Method [53] [54] 
.const [12] = Class [55] 
.const [13] = Class [56] 
.const [14] = Class [57] 
.const [15] = Class [58] 
.const [16] = Class [59] 
.const [17] = Class [60] 
.const [18] = Method [61] [62] 
.const [19] = Field [63] [64] 
.const [20] = Field [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Field [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Class [91] 
.const [34] = Field [92] [93] 
.const [35] = Class [94] 
.const [36] = Class [95] 
.const [37] = Field [96] [97] 
.const [38] = InterfaceMethod [98] [99] 
.const [39] = InterfaceMethod [100] [101] 
.const [40] = InterfaceMethod [102] [103] 
.const [41] = Class [104] 
.const [42] = NameAndType [105] [106] 
.const [43] = Utf8 java/lang/ClassNotFoundException 
.const [44] = Utf8 java/lang/NoClassDefFoundError 
.const [45] = Utf8 IrcActivator 
.const [46] = Class [107] 
.const [47] = NameAndType [108] [109] 
.const [48] = Utf8 de/audi/tghu/irc/InfotainmentrecorderImpl 
.const [49] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [50] = Class [110] 
.const [51] = NameAndType [111] [112] 
.const [52] = Utf8 'org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder' 
.const [53] = Class [113] 
.const [54] = NameAndType [114] [115] 
.const [55] = Utf8 org/dsi/ifc/infotainmentrecorder/DSIInfotainmentRecorder 
.const [56] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [57] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [58] = Utf8 java/lang/Class 
.const [59] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [60] = Utf8 org/osgi/framework/BundleContext 
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
.const [91] = Utf8 java/lang/NoClassDefFoundError 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Utf8 de/audi/tghu/irc/InfotainmentrecorderImpl 
.const [95] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [96] = Class [164] 
.const [97] = NameAndType [165] [166] 
.const [98] = Class [167] 
.const [99] = NameAndType [168] [169] 
.const [100] = Class [170] 
.const [101] = NameAndType [171] [172] 
.const [102] = Class [173] 
.const [103] = NameAndType [174] [175] 
.const [104] = Utf8 java/lang/Class 
.const [105] = Utf8 forName 
.const [106] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [107] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [108] = Utf8 bundleContext 
.const [109] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [110] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [111] = Utf8 class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder 
.const [112] = Utf8 Ljava/lang/Class; 
.const [113] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [114] = Utf8 class$ 
.const [115] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [116] = Utf8 java/lang/NoClassDefFoundError 
.const [117] = Utf8 initCause 
.const [118] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [119] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [120] = Utf8 irc 
.const [121] = Utf8 Lde/audi/tghu/irc/InfotainmentrecorderImpl; 
.const [122] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [123] = Utf8 framework 
.const [124] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [125] = Utf8 java/lang/Class 
.const [126] = Utf8 getName 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [129] = Utf8 dsiTracker 
.const [130] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [131] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [132] = Utf8 'open' 
.const [133] = Utf8 ()V 
.const [134] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [135] = Utf8 close 
.const [136] = Utf8 ()V 
.const [137] = Utf8 de/audi/tghu/irc/InfotainmentrecorderImpl 
.const [138] = Utf8 setDsi 
.const [139] = Utf8 (Lorg/dsi/ifc/infotainmentrecorder/DSIInfotainmentRecorder;)V 
.const [140] = Utf8 java/lang/NoClassDefFoundError 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (Ljava/lang/String;)V 
.const [146] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [147] = Utf8 bundleContext 
.const [148] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [149] = Utf8 de/audi/tghu/irc/InfotainmentrecorderImpl 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [152] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [153] = Utf8 class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder 
.const [154] = Utf8 Ljava/lang/Class; 
.const [155] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [158] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [159] = Utf8 stop 
.const [160] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [161] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [162] = Utf8 irc 
.const [163] = Utf8 Lde/audi/tghu/irc/InfotainmentrecorderImpl; 
.const [164] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [165] = Utf8 dsiTracker 
.const [166] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [167] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [168] = Utf8 startDSIService 
.const [169] = Utf8 (Ljava/lang/String;I)Z 
.const [170] = Utf8 org/osgi/framework/BundleContext 
.const [171] = Utf8 getService 
.const [172] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [173] = Utf8 org/osgi/framework/BundleContext 
.const [174] = Utf8 ungetService 
.const [175] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [176] = Utf8 de/audi/tghu/irc/IrcActivator 
.const [177] = Class [176] 
.const [178] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [179] = Class [178] 
.const [180] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [181] = Class [180] 
.const [182] = Utf8 bundleContext 
.const [183] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [184] = Utf8 dsiTracker 
.const [185] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [186] = Utf8 irc 
.const [187] = Utf8 Lde/audi/tghu/irc/InfotainmentrecorderImpl; 
.const [188] = Utf8 class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder 
.const [189] = Utf8 Ljava/lang/Class; 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 getService 
.const [194] = Utf8 ()Lde/audi/tghu/irc/InfotainmentrecorderImpl; 
.const [195] = Utf8 startInternal 
.const [196] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [197] = Utf8 stop 
.const [198] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [199] = Utf8 addingService 
.const [200] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [201] = Utf8 modifiedService 
.const [202] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [203] = Utf8 removedService 
.const [204] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [205] = Utf8 class$ 
.const [206] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
