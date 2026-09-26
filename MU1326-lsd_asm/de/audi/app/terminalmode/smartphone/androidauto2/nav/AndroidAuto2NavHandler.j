.version 50 0 
.class public super [180] 
.super [182] 
.implements [184] 
.field private static final [185] [186] 
.field private volatile [187] [188] 
.field private volatile [189] [190] 
.field private volatile [191] [192] 

.method public [194] : [195] 
    .attribute [193] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [37] 
L9:     aload_0 
L10:    getstatic [2] 
L13:    putfield [40] 
L16:    aload_0 
L17:    getstatic [2] 
L20:    putfield [41] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [193] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifeq L88 
L7:     aload_0 
L8:     getfield [25] 
L11:    aload_1 
L12:    invokevirtual [27] 
L15:    ifeq L189 
L18:    aload_0 
L19:    getfield [28] 
L22:    ldc [3] 
L24:    ldc [4] 
L26:    ldc [5] 
L28:    getstatic [6] 
L31:    aload_1 
L32:    invokevirtual [27] 
L35:    ifeq L43 
L38:    ldc [7] 
L40:    goto L45 
L43:    ldc [8] 
L45:    invokevirtual [29] 
L48:    aload_0 
L49:    getfield [30] 
L52:    getstatic [6] 
L55:    aload_1 
L56:    invokevirtual [27] 
L59:    ifeq L66 
L62:    iconst_2 
L63:    goto L67 
L66:    iconst_1 
L67:    iconst_0 
L68:    invokeinterface [43] 0 
L73:    aload_0 
L74:    iconst_0 
L75:    putfield [42] 
L78:    aload_0 
L79:    getstatic [2] 
L82:    putfield [41] 
L85:    goto L189 
L88:    aload_0 
L89:    getfield [24] 
L92:    aload_1 
L93:    invokevirtual [27] 
L96:    ifeq L118 
L99:    aload_0 
L100:   getfield [28] 
L103:   ldc [3] 
L105:   ldc [9] 
L107:   ldc [5] 
L109:   aload_0 
L110:   getfield [24] 
L113:   aload_1 
L114:   invokevirtual [31] 
L117:   return 
L118:   getstatic [6] 
L121:   aload_1 
L122:   invokevirtual [27] 
L125:   ifeq L160 
L128:   aload_0 
L129:   getfield [28] 
L132:   ldc [3] 
L134:   ldc [10] 
L136:   ldc [5] 
L138:   aload_0 
L139:   getfield [24] 
L142:   aload_1 
L143:   invokevirtual [31] 
L146:   aload_0 
L147:   getfield [30] 
L150:   iconst_2 
L151:   iconst_1 
L152:   invokeinterface [43] 0 
L157:   goto L189 
L160:   aload_0 
L161:   getfield [28] 
L164:   ldc [3] 
L166:   ldc [11] 
L168:   ldc [5] 
L170:   aload_0 
L171:   getfield [24] 
L174:   aload_1 
L175:   invokevirtual [31] 
L178:   aload_0 
L179:   getfield [30] 
L182:   iconst_1 
L183:   iconst_1 
L184:   invokeinterface [43] 0 
L189:   aload_0 
L190:   aload_1 
L191:   putfield [40] 
L194:   return 
L195:   nop 
L196:   
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [193] .code stack 6 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     invokevirtual [32] 
L5:     ifeq L83 
L8:     aload_0 
L9:     getfield [28] 
L12:    ldc [3] 
L14:    ldc [12] 
L16:    ldc [5] 
L18:    aload_0 
L19:    iload_1 
L20:    invokespecial [38] 
L23:    invokevirtual [29] 
L26:    iconst_1 
L27:    iload_1 
L28:    if_icmpne L56 
L31:    aload_0 
L32:    getstatic [13] 
L35:    getstatic [2] 
L38:    invokevirtual [33] 
L41:    aload_0 
L42:    iconst_1 
L43:    putfield [42] 
L46:    aload_0 
L47:    getstatic [2] 
L50:    putfield [41] 
L53:    goto L83 
L56:    iconst_2 
L57:    iload_1 
L58:    if_icmpne L83 
L61:    aload_0 
L62:    getstatic [13] 
L65:    getstatic [6] 
L68:    invokevirtual [33] 
L71:    aload_0 
L72:    iconst_1 
L73:    putfield [42] 
L76:    aload_0 
L77:    getstatic [6] 
L80:    putfield [41] 
L83:    return 
L84:    
    .end code 
.end method 

.method private [200] : [201] 
    .attribute [193] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L28 
            2 : L31 
            default : L34 

L28:    ldc [14] 
L30:    areturn 
L31:    ldc [15] 
L33:    areturn 
L34:    new [44] 
L37:    dup 
L38:    invokespecial [39] 
L41:    ldc [17] 
L43:    invokevirtual [34] 
L46:    iload_1 
L47:    invokevirtual [35] 
L50:    invokevirtual [36] 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method protected [202] : [203] 
    .attribute [193] .code stack 1 locals 0 
L0:     ldc [5] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [45] [46] 
.const [3] = Int 1078071040 
.const [4] = String [47] 
.const [5] = String [48] 
.const [6] = Field [49] [50] 
.const [7] = String [51] 
.const [8] = String [52] 
.const [9] = String [53] 
.const [10] = String [54] 
.const [11] = String [55] 
.const [12] = String [56] 
.const [13] = Field [57] [58] 
.const [14] = String [59] 
.const [15] = String [60] 
.const [16] = Class [61] 
.const [17] = String [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Class [66] 
.const [22] = Class [67] 
.const [23] = Class [68] 
.const [24] = Field [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Field [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Field [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Method [89] [90] 
.const [35] = Method [91] [92] 
.const [36] = Method [93] [94] 
.const [37] = Method [95] [96] 
.const [38] = Method [97] [98] 
.const [39] = Method [99] [100] 
.const [40] = Field [101] [102] 
.const [41] = Field [103] [104] 
.const [42] = Field [105] [106] 
.const [43] = InterfaceMethod [107] [108] 
.const [44] = Class [109] 
.const [45] = Class [110] 
.const [46] = NameAndType [111] [112] 
.const [47] = Utf8 '[%1.updateNavFocus] responding to requested navFocusNotification: %2' 
.const [48] = Utf8 AndroidAuto2NavHandler 
.const [49] = Class [113] 
.const [50] = NameAndType [114] [115] 
.const [51] = Utf8 PROJECTED 
.const [52] = Utf8 NATIVE 
.const [53] = Utf8 '[%1.updateNavFocus] %2 -> %3, do nothing' 
.const [54] = Utf8 '[%1.updateNavFocus] %2 -> %3, navFocusNotification: PROJECTED' 
.const [55] = Utf8 '[%1.updateNavFocus] %2 -> %3, navFocusNotification: NATIVE' 
.const [56] = Utf8 '<- [%1.navFocusRequestNotification] %2' 
.const [57] = Class [116] 
.const [58] = NameAndType [117] [118] 
.const [59] = Utf8 NAV_NATIVE 
.const [60] = Utf8 NAV_PROJECTED 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 'NAV_UNKNOWN ' 
.const [63] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [64] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [65] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [68] = Utf8 de/audi/app/terminalmode/statemachine/Application 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Class [128] 
.const [76] = NameAndType [129] [130] 
.const [77] = Class [131] 
.const [78] = NameAndType [132] [133] 
.const [79] = Class [134] 
.const [80] = NameAndType [135] [136] 
.const [81] = Class [137] 
.const [82] = NameAndType [138] [139] 
.const [83] = Class [140] 
.const [84] = NameAndType [141] [142] 
.const [85] = Class [143] 
.const [86] = NameAndType [144] [145] 
.const [87] = Class [146] 
.const [88] = NameAndType [147] [148] 
.const [89] = Class [149] 
.const [90] = NameAndType [150] [151] 
.const [91] = Class [152] 
.const [92] = NameAndType [153] [154] 
.const [93] = Class [155] 
.const [94] = NameAndType [156] [157] 
.const [95] = Class [158] 
.const [96] = NameAndType [159] [160] 
.const [97] = Class [161] 
.const [98] = NameAndType [162] [163] 
.const [99] = Class [164] 
.const [100] = NameAndType [165] [166] 
.const [101] = Class [167] 
.const [102] = NameAndType [168] [169] 
.const [103] = Class [170] 
.const [104] = NameAndType [171] [172] 
.const [105] = Class [173] 
.const [106] = NameAndType [174] [175] 
.const [107] = Class [176] 
.const [108] = NameAndType [177] [178] 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [111] = Utf8 NOBODY 
.const [112] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [113] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [114] = Utf8 DEVICE 
.const [115] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [116] = Utf8 de/audi/app/terminalmode/statemachine/Application 
.const [117] = Utf8 NAVI 
.const [118] = Utf8 Lde/audi/app/terminalmode/statemachine/Application; 
.const [119] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [120] = Utf8 appNaviOwnerCurrent 
.const [121] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [122] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [123] = Utf8 expectedAppNavOwner 
.const [124] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [125] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [126] = Utf8 hasNavFocusRequested 
.const [127] = Utf8 Z 
.const [128] = Utf8 de/audi/app/terminalmode/statemachine/ApplicationOwner 
.const [129] = Utf8 equals 
.const [130] = Utf8 (Ljava/lang/Object;)Z 
.const [131] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [132] = Utf8 logger 
.const [133] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [134] = Utf8 de/audi/atip/log/LogChannel 
.const [135] = Utf8 log 
.const [136] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [137] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [138] = Utf8 dsi 
.const [139] = Utf8 Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2; 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [143] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [144] = Utf8 isValid 
.const [145] = Utf8 (I)Z 
.const [146] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [147] = Utf8 requestDSIUpdate 
.const [148] = Utf8 (Lde/audi/app/terminalmode/statemachine/Application;Lde/audi/app/terminalmode/statemachine/ApplicationOwner;)V 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 append 
.const [151] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 append 
.const [154] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [155] = Utf8 java/lang/StringBuffer 
.const [156] = Utf8 toString 
.const [157] = Utf8 ()Ljava/lang/String; 
.const [158] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/app/terminalmode/statemachine/IStateHandler;Lde/audi/app/terminalmode/IContext;)V 
.const [161] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [162] = Utf8 getNavState 
.const [163] = Utf8 (I)Ljava/lang/String; 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [168] = Utf8 appNaviOwnerCurrent 
.const [169] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [170] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [171] = Utf8 expectedAppNavOwner 
.const [172] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [173] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [174] = Utf8 hasNavFocusRequested 
.const [175] = Utf8 Z 
.const [176] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [177] = Utf8 navFocusNotification 
.const [178] = Utf8 (IZ)V 
.const [179] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/AndroidAuto2NavHandler 
.const [180] = Class [179] 
.const [181] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AbstractAndroidAuto2Handler 
.const [182] = Class [181] 
.const [183] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/nav/IAndroidAuto2NavHandler 
.const [184] = Class [183] 
.const [185] = Utf8 LOGCLASS 
.const [186] = Utf8 Ljava/lang/String; 
.const [187] = Utf8 appNaviOwnerCurrent 
.const [188] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [189] = Utf8 hasNavFocusRequested 
.const [190] = Utf8 Z 
.const [191] = Utf8 expectedAppNavOwner 
.const [192] = Utf8 Lde/audi/app/terminalmode/statemachine/ApplicationOwner; 
.const [193] = Utf8 Code 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/app/terminalmode/statemachine/IStateHandler;Lde/audi/app/terminalmode/IContext;)V 
.const [196] = Utf8 updateNavFocus 
.const [197] = Utf8 (Lde/audi/app/terminalmode/statemachine/ApplicationOwner;)V 
.const [198] = Utf8 navFocusRequestNotification 
.const [199] = Utf8 (II)V 
.const [200] = Utf8 getNavState 
.const [201] = Utf8 (I)Ljava/lang/String; 
.const [202] = Utf8 getLogClass 
.const [203] = Utf8 ()Ljava/lang/String; 
.end class 
