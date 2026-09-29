.version 50 0 
.class public super [102] 
.super [104] 
.field private static [105] [106] 

.method public annotation [108] : [109] 
    .attribute [107] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static enum [110] : [111] 
    .attribute [107] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public static enum [112] : [113] 
    .attribute [107] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public static synchronized [114] : [115] 
    .attribute [107] .code stack 7 locals 6 
L0:     iload_2 
L1:     iload_3 
L2:     invokestatic [3] 
L5:     astore 5 
L7:     aconst_null 
L8:     astore 6 
L10:    aload 5 
L12:    ifnull L101 
L15:    getstatic [2] 
L18:    dup 
L19:    astore 7 
L21:    monitorenter 
L22:    aload_0 
L23:    invokevirtual [16] 
L26:    aconst_null 
L27:    invokevirtual [17] 
L30:    new [25] 
L33:    dup 
L34:    aload_0 
L35:    invokevirtual [18] 
L38:    ldc [5] 
L40:    aload 5 
L42:    aload_1 
L43:    aload_0 
L44:    invokespecial [23] 
L47:    astore 8 
L49:    aload 4 
L51:    aload 8 
L53:    ldc [6] 
L55:    iconst_0 
L56:    invokevirtual [19] 
L59:    pop 
        .catch [7] from L60 to L69 using L72 
        .catch [0] from L22 to L90 using L93 
L60:    getstatic [2] 
L63:    ldc_w [1] 
L66:    invokespecial [24] 
L69:    goto L78 
L72:    astore 9 
L74:    invokestatic [8] 
L77:    pop 
L78:    aload_0 
L79:    invokevirtual [16] 
L82:    invokevirtual [20] 
L85:    astore 6 
L87:    aload 7 
L89:    monitorexit 
L90:    goto L101 
        .catch [0] from L93 to L98 using L93 
L93:    astore 10 
L95:    aload 7 
L97:    monitorexit 
L98:    aload 10 
L100:   athrow 
L101:   aload 6 
L103:   areturn 
L104:   
    .end code 
.end method 

.method static synthetic [116] : [117] 
    .attribute [107] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [118] : [119] 
    .attribute [107] .code stack 2 locals 0 
L0:     new [26] 
L3:     dup 
L4:     invokespecial [22] 
L7:     putstatic [21] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [28] [29] 
.const [3] = Method [30] [31] 
.const [4] = Class [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = Class [35] 
.const [8] = Method [36] [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Class [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Field [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Class [63] 
.const [26] = Class [64] 
.const [27] = Int -2012020736 
.const [28] = Class [65] 
.const [29] = NameAndType [66] [67] 
.const [30] = Class [68] 
.const [31] = NameAndType [69] [70] 
.const [32] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils$1 
.const [33] = Utf8 ResolveGeoCoordsCall 
.const [34] = Utf8 'NaviADBOnlineUtils.resolveGeoCoords' 
.const [35] = Utf8 java/lang/InterruptedException 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils 
.const [40] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [41] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [42] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [43] = Utf8 de/audi/tghu/navi/app/call/CommandListCallManager 
.const [44] = Utf8 java/lang/Thread 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Class [86] 
.const [54] = NameAndType [87] [88] 
.const [55] = Class [89] 
.const [56] = NameAndType [90] [91] 
.const [57] = Class [92] 
.const [58] = NameAndType [93] [94] 
.const [59] = Class [95] 
.const [60] = NameAndType [96] [97] 
.const [61] = Class [98] 
.const [62] = NameAndType [99] [100] 
.const [63] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils$1 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils 
.const [66] = Utf8 resolveGeoCoordsMutex 
.const [67] = Utf8 Ljava/lang/Object; 
.const [68] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [69] = Utf8 getLocationFromGeoPos 
.const [70] = Utf8 (II)Lorg/dsi/ifc/global/NavLocation; 
.const [71] = Utf8 java/lang/Thread 
.const [72] = Utf8 interrupted 
.const [73] = Utf8 ()Z 
.const [74] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [75] = Utf8 getContainer 
.const [76] = Utf8 ()Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [77] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [78] = Utf8 setTransformedLocation 
.const [79] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [80] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [81] = Utf8 getCommandLogChannel 
.const [82] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [83] = Utf8 de/audi/tghu/navi/app/call/CommandListCallManager 
.const [84] = Utf8 executeCall 
.const [85] = Utf8 (Lde/audi/tghu/navi/app/call/INavCall;Ljava/lang/String;Z)Z 
.const [86] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [87] = Utf8 getTransformedLocation 
.const [88] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [89] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils 
.const [90] = Utf8 resolveGeoCoordsMutex 
.const [91] = Utf8 Ljava/lang/Object; 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils$1 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lorg/dsi/ifc/global/NavLocation;Lde/audi/tghu/navi/app/dsi/DSINavigationManager;Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 wait 
.const [100] = Utf8 (J)V 
.const [101] = Utf8 de/audi/tghu/navi/app/adb/NaviADBOnlineUtils 
.const [102] = Class [101] 
.const [103] = Utf8 java/lang/Object 
.const [104] = Class [103] 
.const [105] = Utf8 resolveGeoCoordsMutex 
.const [106] = Utf8 Ljava/lang/Object; 
.const [107] = Utf8 Code 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 tryBestMatchJumpToNDF 
.const [111] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;S)V 
.const [112] = Utf8 jumpToNDF 
.const [113] = Utf8 ([B)V 
.const [114] = Utf8 resolveGeoCoords 
.const [115] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/dsi/DSINavigationManager;IILde/audi/tghu/navi/app/call/CommandListCallManager;)Lorg/dsi/ifc/global/NavLocation; 
.const [116] = Utf8 access$000 
.const [117] = Utf8 ()Ljava/lang/Object; 
.const [118] = Utf8 <clinit> 
.const [119] = Utf8 ()V 
.end class 
