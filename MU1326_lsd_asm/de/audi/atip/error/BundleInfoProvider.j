.version 50 0 
.class public super [189] 
.super [191] 
.implements [193] 
.field private [194] [195] 

.method [197] : [198] 
    .attribute [196] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [44] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [196] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method [201] : [202] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokeinterface [45] 0 
L6:     lookupswitch 
            1 : L76 
            2 : L64 
            4 : L67 
            8 : L70 
            16 : L73 
            32 : L79 
            default : L82 

L64:    ldc [3] 
L66:    areturn 
L67:    ldc [4] 
L69:    areturn 
L70:    ldc [5] 
L72:    areturn 
L73:    ldc [6] 
L75:    areturn 
L76:    ldc [7] 
L78:    areturn 
L79:    ldc [8] 
L81:    areturn 
L82:    ldc [9] 
L84:    areturn 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [196] .code stack 4 locals 3 
L0:     aload_1 
L1:     invokeinterface [46] 0 
L6:     astore_3 
L7:     aconst_null 
L8:     astore 4 
L10:    aload_2 
L11:    new [47] 
L14:    dup 
L15:    invokespecial [43] 
L18:    ldc [11] 
L20:    invokevirtual [33] 
L23:    aload_3 
L24:    ldc [12] 
L26:    invokevirtual [34] 
L29:    invokevirtual [35] 
L32:    ldc [13] 
L34:    invokevirtual [33] 
L37:    invokevirtual [36] 
L40:    invokevirtual [37] 
L43:    aload_2 
L44:    new [47] 
L47:    dup 
L48:    invokespecial [43] 
L51:    ldc [14] 
L53:    invokevirtual [33] 
L56:    aload_1 
L57:    invokeinterface [48] 0 
L62:    invokevirtual [38] 
L65:    invokevirtual [36] 
L68:    invokevirtual [37] 
L71:    aload_2 
L72:    new [47] 
L75:    dup 
L76:    invokespecial [43] 
L79:    ldc [15] 
L81:    invokevirtual [33] 
L84:    aload_0 
L85:    aload_1 
L86:    invokevirtual [39] 
L89:    invokevirtual [33] 
L92:    invokevirtual [36] 
L95:    invokevirtual [37] 
L98:    aload_2 
L99:    new [47] 
L102:   dup 
L103:   invokespecial [43] 
L106:   ldc [16] 
L108:   invokevirtual [33] 
L111:   aload_3 
L112:   ldc [17] 
L114:   invokevirtual [34] 
L117:   invokevirtual [35] 
L120:   invokevirtual [36] 
L123:   invokevirtual [37] 
L126:   ldc [18] 
L128:   invokestatic [19] 
L131:   ifeq L266 
L134:   aload_2 
L135:   ldc [20] 
L137:   invokevirtual [37] 
L140:   aload_1 
L141:   invokeinterface [49] 0 
L146:   astore 4 
L148:   aload 4 
L150:   ifnull L200 
L153:   iconst_0 
L154:   istore 5 
L156:   iload 5 
L158:   aload 4 
L160:   arraylength 
L161:   if_icmpge L200 
L164:   aload_2 
L165:   new [47] 
L168:   dup 
L169:   invokespecial [43] 
L172:   ldc [21] 
L174:   invokevirtual [33] 
L177:   aload 4 
L179:   iload 5 
L181:   aaload 
L182:   invokevirtual [40] 
L185:   invokevirtual [33] 
L188:   invokevirtual [36] 
L191:   invokevirtual [37] 
L194:   iinc 5 1 
L197:   goto L156 
L200:   aload_2 
L201:   ldc [22] 
L203:   invokevirtual [37] 
L206:   aload_1 
L207:   invokeinterface [50] 0 
L212:   astore 4 
L214:   aload 4 
L216:   ifnull L266 
L219:   iconst_0 
L220:   istore 5 
L222:   iload 5 
L224:   aload 4 
L226:   arraylength 
L227:   if_icmpge L266 
L230:   aload_2 
L231:   new [47] 
L234:   dup 
L235:   invokespecial [43] 
L238:   ldc [23] 
L240:   invokevirtual [33] 
L243:   aload 4 
L245:   iload 5 
L247:   aaload 
L248:   invokevirtual [40] 
L251:   invokevirtual [33] 
L254:   invokevirtual [36] 
L257:   invokevirtual [37] 
L260:   iinc 5 1 
L263:   goto L222 
L266:   return 
L267:   nop 
L268:   
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [196] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokeinterface [51] 0 
L9:     invokeinterface [52] 0 
L14:    astore_3 
L15:    iconst_0 
L16:    istore 4 
L18:    iload 4 
L20:    aload_3 
L21:    arraylength 
L22:    if_icmpge L40 
L25:    aload_0 
L26:    aload_3 
L27:    iload 4 
L29:    aaload 
L30:    aload_1 
L31:    invokevirtual [41] 
L34:    iinc 4 1 
L37:    goto L18 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [53] 
.const [3] = String [54] 
.const [4] = String [55] 
.const [5] = String [56] 
.const [6] = String [57] 
.const [7] = String [58] 
.const [8] = String [59] 
.const [9] = String [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = String [63] 
.const [13] = String [64] 
.const [14] = String [65] 
.const [15] = String [66] 
.const [16] = String [67] 
.const [17] = String [68] 
.const [18] = String [69] 
.const [19] = Method [70] [71] 
.const [20] = String [72] 
.const [21] = String [73] 
.const [22] = String [74] 
.const [23] = String [75] 
.const [24] = Class [76] 
.const [25] = Class [77] 
.const [26] = Class [78] 
.const [27] = Class [79] 
.const [28] = Class [80] 
.const [29] = Class [81] 
.const [30] = Class [82] 
.const [31] = Class [83] 
.const [32] = Field [84] [85] 
.const [33] = Method [86] [87] 
.const [34] = Method [88] [89] 
.const [35] = Method [90] [91] 
.const [36] = Method [92] [93] 
.const [37] = Method [94] [95] 
.const [38] = Method [96] [97] 
.const [39] = Method [98] [99] 
.const [40] = Method [100] [101] 
.const [41] = Method [102] [103] 
.const [42] = Method [104] [105] 
.const [43] = Method [106] [107] 
.const [44] = Field [108] [109] 
.const [45] = InterfaceMethod [110] [111] 
.const [46] = InterfaceMethod [112] [113] 
.const [47] = Class [114] 
.const [48] = InterfaceMethod [115] [116] 
.const [49] = InterfaceMethod [117] [118] 
.const [50] = InterfaceMethod [119] [120] 
.const [51] = InterfaceMethod [121] [122] 
.const [52] = InterfaceMethod [123] [124] 
.const [53] = Utf8 BundleInfos 
.const [54] = Utf8 INSTALLED 
.const [55] = Utf8 RESOLVED 
.const [56] = Utf8 STARTING 
.const [57] = Utf8 STOPPING 
.const [58] = Utf8 UNINSTALLED 
.const [59] = Utf8 ACTIVE 
.const [60] = Utf8 '?' 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 '\n===== Bundle "' 
.const [63] = Utf8 Bundle-Name 
.const [64] = Utf8 '" =====' 
.const [65] = Utf8 '\tID: ' 
.const [66] = Utf8 '\tState: ' 
.const [67] = Utf8 '\tBundle-Activator:' 
.const [68] = Utf8 Bundle-Activator 
.const [69] = Utf8 DumpExtendedBundleInformation 
.const [70] = Class [125] 
.const [71] = NameAndType [126] [127] 
.const [72] = Utf8 '\tService References: ' 
.const [73] = Utf8 '\t\t<- ' 
.const [74] = Utf8 '\tServices In Use: ' 
.const [75] = Utf8 '\t\t-> ' 
.const [76] = Utf8 de/audi/atip/error/BundleInfoProvider 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 org/osgi/framework/Bundle 
.const [79] = Utf8 java/util/Dictionary 
.const [80] = Utf8 java/io/PrintStream 
.const [81] = Utf8 java/lang/Boolean 
.const [82] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [83] = Utf8 org/osgi/framework/BundleContext 
.const [84] = Class [128] 
.const [85] = NameAndType [129] [130] 
.const [86] = Class [131] 
.const [87] = NameAndType [132] [133] 
.const [88] = Class [134] 
.const [89] = NameAndType [135] [136] 
.const [90] = Class [137] 
.const [91] = NameAndType [138] [139] 
.const [92] = Class [140] 
.const [93] = NameAndType [141] [142] 
.const [94] = Class [143] 
.const [95] = NameAndType [144] [145] 
.const [96] = Class [146] 
.const [97] = NameAndType [147] [148] 
.const [98] = Class [149] 
.const [99] = NameAndType [150] [151] 
.const [100] = Class [152] 
.const [101] = NameAndType [153] [154] 
.const [102] = Class [155] 
.const [103] = NameAndType [156] [157] 
.const [104] = Class [158] 
.const [105] = NameAndType [159] [160] 
.const [106] = Class [161] 
.const [107] = NameAndType [162] [163] 
.const [108] = Class [164] 
.const [109] = NameAndType [165] [166] 
.const [110] = Class [167] 
.const [111] = NameAndType [168] [169] 
.const [112] = Class [170] 
.const [113] = NameAndType [171] [172] 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Class [173] 
.const [116] = NameAndType [174] [175] 
.const [117] = Class [176] 
.const [118] = NameAndType [177] [178] 
.const [119] = Class [179] 
.const [120] = NameAndType [180] [181] 
.const [121] = Class [182] 
.const [122] = NameAndType [183] [184] 
.const [123] = Class [185] 
.const [124] = NameAndType [186] [187] 
.const [125] = Utf8 java/lang/Boolean 
.const [126] = Utf8 getBoolean 
.const [127] = Utf8 (Ljava/lang/String;)Z 
.const [128] = Utf8 de/audi/atip/error/BundleInfoProvider 
.const [129] = Utf8 fw 
.const [130] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 append 
.const [133] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [134] = Utf8 java/util/Dictionary 
.const [135] = Utf8 get 
.const [136] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 append 
.const [139] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 toString 
.const [142] = Utf8 ()Ljava/lang/String; 
.const [143] = Utf8 java/io/PrintStream 
.const [144] = Utf8 println 
.const [145] = Utf8 (Ljava/lang/String;)V 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 append 
.const [148] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [149] = Utf8 de/audi/atip/error/BundleInfoProvider 
.const [150] = Utf8 getBundleState 
.const [151] = Utf8 (Lorg/osgi/framework/Bundle;)Ljava/lang/String; 
.const [152] = Utf8 java/lang/Object 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/audi/atip/error/BundleInfoProvider 
.const [156] = Utf8 printBundleInformation 
.const [157] = Utf8 (Lorg/osgi/framework/Bundle;Ljava/io/PrintStream;)V 
.const [158] = Utf8 java/lang/Object 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 java/lang/StringBuffer 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 de/audi/atip/error/BundleInfoProvider 
.const [165] = Utf8 fw 
.const [166] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [167] = Utf8 org/osgi/framework/Bundle 
.const [168] = Utf8 getState 
.const [169] = Utf8 ()I 
.const [170] = Utf8 org/osgi/framework/Bundle 
.const [171] = Utf8 getHeaders 
.const [172] = Utf8 ()Ljava/util/Dictionary; 
.const [173] = Utf8 org/osgi/framework/Bundle 
.const [174] = Utf8 getBundleId 
.const [175] = Utf8 ()J 
.const [176] = Utf8 org/osgi/framework/Bundle 
.const [177] = Utf8 getRegisteredServices 
.const [178] = Utf8 ()[Lorg/osgi/framework/ServiceReference; 
.const [179] = Utf8 org/osgi/framework/Bundle 
.const [180] = Utf8 getServicesInUse 
.const [181] = Utf8 ()[Lorg/osgi/framework/ServiceReference; 
.const [182] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [183] = Utf8 getBundleCxt 
.const [184] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [185] = Utf8 org/osgi/framework/BundleContext 
.const [186] = Utf8 getBundles 
.const [187] = Utf8 ()[Lorg/osgi/framework/Bundle; 
.const [188] = Utf8 de/audi/atip/error/BundleInfoProvider 
.const [189] = Class [188] 
.const [190] = Utf8 java/lang/Object 
.const [191] = Class [190] 
.const [192] = Utf8 de/esolutions/fw/util/commons/error/DumpInfoProvider 
.const [193] = Class [192] 
.const [194] = Utf8 fw 
.const [195] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [199] = Utf8 getName 
.const [200] = Utf8 ()Ljava/lang/String; 
.const [201] = Utf8 getBundleState 
.const [202] = Utf8 (Lorg/osgi/framework/Bundle;)Ljava/lang/String; 
.const [203] = Utf8 printBundleInformation 
.const [204] = Utf8 (Lorg/osgi/framework/Bundle;Ljava/io/PrintStream;)V 
.const [205] = Utf8 dump 
.const [206] = Utf8 (Ljava/io/PrintStream;Ljava/lang/String;)V 
.end class 
