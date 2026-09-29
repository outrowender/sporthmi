.version 50 0 
.class public super [92] 
.super [94] 

.method public annotation [96] : [97] 
    .attribute [95] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [98] : [99] 
    .attribute [95] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [15] 
L7:     invokestatic [2] 
L10:    istore_1 
L11:    iconst_1 
L12:    iload_1 
L13:    if_icmpne L50 
L16:    aload_0 
L17:    invokevirtual [16] 
L20:    new [22] 
L23:    dup 
L24:    iconst_0 
L25:    newarray int 
L27:    invokespecial [21] 
L30:    invokeinterface [23] 0 
L35:    aload_0 
L36:    getfield [17] 
L39:    ldc [4] 
L41:    ldc [5] 
L43:    invokevirtual [18] 
L46:    pop 
L47:    goto L90 
L50:    iconst_2 
L51:    iload_1 
L52:    if_icmpne L90 
L55:    aload_0 
L56:    invokevirtual [16] 
L59:    new [22] 
L62:    dup 
L63:    iconst_1 
L64:    newarray int 
L66:    dup 
L67:    iconst_0 
L68:    iconst_1 
L69:    iastore 
L70:    invokespecial [21] 
L73:    invokeinterface [23] 0 
L78:    aload_0 
L79:    getfield [17] 
L82:    ldc [4] 
L84:    ldc [6] 
L86:    invokevirtual [18] 
L89:    pop 
L90:    aload_0 
L91:    invokevirtual [19] 
L94:    invokeinterface [24] 0 
L99:    return 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [25] [26] 
.const [3] = Class [27] 
.const [4] = Int -2137614336 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Class [36] 
.const [14] = Field [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Class [53] 
.const [23] = InterfaceMethod [54] [55] 
.const [24] = InterfaceMethod [56] [57] 
.const [25] = Class [58] 
.const [26] = NameAndType [59] [60] 
.const [27] = Utf8 org/dsi/ifc/navigation/NavPoiInfoConfiguration 
.const [28] = Utf8 'RgConfigurePoiInfoCommand#execute(), rgConfigurePoiInfo(int [])' 
.const [29] = Utf8 'RgConfigurePoiInfoCommand#execute(), rgConfigurePoiInfo(int [DSINavigation.NAVPOIINFOTYPE_CONTROLLEDACCESS])' 
.const [30] = Utf8 de/audi/tghu/navi/app/command/RgConfigurePoiInfoCommand 
.const [31] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [32] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [33] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [34] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [35] = Utf8 de/audi/atip/log/LogChannel 
.const [36] = Utf8 de/audi/tghu/command/ICommandList 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Utf8 org/dsi/ifc/navigation/NavPoiInfoConfiguration 
.const [54] = Class [85] 
.const [55] = NameAndType [86] [87] 
.const [56] = Class [88] 
.const [57] = NameAndType [89] [90] 
.const [58] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [59] = Utf8 getRouteInfoConfigMode 
.const [60] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)I 
.const [61] = Utf8 de/audi/tghu/navi/app/command/RgConfigurePoiInfoCommand 
.const [62] = Utf8 env 
.const [63] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [64] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [65] = Utf8 getFramework 
.const [66] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [67] = Utf8 de/audi/tghu/navi/app/command/RgConfigurePoiInfoCommand 
.const [68] = Utf8 getDSINavigation 
.const [69] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [70] = Utf8 de/audi/tghu/navi/app/command/RgConfigurePoiInfoCommand 
.const [71] = Utf8 logger 
.const [72] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;)Z 
.const [76] = Utf8 de/audi/tghu/navi/app/command/RgConfigurePoiInfoCommand 
.const [77] = Utf8 getCommandList 
.const [78] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [79] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 org/dsi/ifc/navigation/NavPoiInfoConfiguration 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ([I)V 
.const [85] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [86] = Utf8 rgConfigurePoiInfo 
.const [87] = Utf8 (Lorg/dsi/ifc/navigation/NavPoiInfoConfiguration;)V 
.const [88] = Utf8 de/audi/tghu/command/ICommandList 
.const [89] = Utf8 commandFinished 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/audi/tghu/navi/app/command/RgConfigurePoiInfoCommand 
.const [92] = Class [91] 
.const [93] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [94] = Class [93] 
.const [95] = Utf8 Code 
.const [96] = Utf8 <init> 
.const [97] = Utf8 ()V 
.const [98] = Utf8 execute 
.const [99] = Utf8 ()V 
.end class 
