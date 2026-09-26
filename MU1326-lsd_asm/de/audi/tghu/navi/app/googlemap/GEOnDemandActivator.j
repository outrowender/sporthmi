.version 50 0 
.class public super [127] 
.super [129] 

.method public annotation [131] : [132] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [130] .code stack 6 locals 5 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     aload_0 
L6:     invokevirtual [19] 
L9:     ldc [2] 
L11:    invokeinterface [29] 0 
L16:    astore_2 
L17:    aload_0 
L18:    invokevirtual [19] 
L21:    invokeinterface [30] 0 
L26:    astore_3 
L27:    aload_2 
L28:    ldc [3] 
L30:    ldc [4] 
L32:    invokevirtual [20] 
L35:    pop 
L36:    aload_3 
L37:    ifnull L160 
L40:    new [31] 
L43:    dup 
L44:    aload_3 
L45:    aload_2 
L46:    aload_0 
L47:    invokevirtual [19] 
L50:    sipush 900 
L53:    invokespecial [28] 
L56:    astore 4 
L58:    aload 4 
L60:    invokevirtual [21] 
L63:    aload_0 
L64:    getfield [22] 
L67:    sipush 479 
L70:    invokeinterface [32] 0 
L75:    iconst_1 
L76:    if_icmpne L83 
L79:    iconst_1 
L80:    goto L84 
L83:    iconst_0 
L84:    istore 5 
L86:    iload 5 
L88:    ifeq L148 
L91:    aload 4 
L93:    invokevirtual [23] 
L96:    invokevirtual [24] 
L99:    iconst_1 
L100:   if_icmpne L148 
L103:   aload_2 
L104:   ldc [6] 
L106:   ldc [7] 
L108:   invokevirtual [20] 
L111:   pop 
        .catch [8] from L112 to L128 using L131 
        .catch [8] from L17 to L169 using L172 
L112:   aload_0 
L113:   invokevirtual [19] 
L116:   invokeinterface [33] 0 
L121:   bipush 14 
L123:   invokeinterface [34] 0 
L128:   goto L157 
L131:   astore 6 
L133:   aload_2 
L134:   sipush 10000 
L137:   ldc [9] 
L139:   aload 6 
L141:   invokevirtual [25] 
L144:   pop 
L145:   goto L157 
L148:   aload_2 
L149:   ldc [6] 
L151:   ldc [10] 
L153:   invokevirtual [20] 
L156:   pop 
L157:   goto L169 
L160:   aload_2 
L161:   ldc [3] 
L163:   ldc [11] 
L165:   invokevirtual [20] 
L168:   pop 
L169:   goto L183 
L172:   astore_3 
L173:   aload_2 
L174:   ldc [3] 
L176:   ldc [12] 
L178:   aload_3 
L179:   invokevirtual [25] 
L182:   pop 
L183:   return 
L184:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [35] 
.const [3] = Int -1601830656 
.const [4] = String [36] 
.const [5] = Class [37] 
.const [6] = Int 1078071040 
.const [7] = String [38] 
.const [8] = Class [39] 
.const [9] = String [40] 
.const [10] = String [41] 
.const [11] = String [42] 
.const [12] = String [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Class [48] 
.const [18] = Class [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Method [62] [63] 
.const [26] = Method [64] [65] 
.const [27] = Method [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = InterfaceMethod [70] [71] 
.const [30] = InterfaceMethod [72] [73] 
.const [31] = Class [74] 
.const [32] = InterfaceMethod [75] [76] 
.const [33] = InterfaceMethod [77] [78] 
.const [34] = InterfaceMethod [79] [80] 
.const [35] = Utf8 'App.Navi.GEOnDemand' 
.const [36] = Utf8 'GEOnDemandActivator: check if GoogleEarth Map is active' 
.const [37] = Utf8 de/audi/tghu/navi/app/map/context/State 
.const [38] = Utf8 'GEOnDemandActivator: request start of Google Earth now.' 
.const [39] = Utf8 java/lang/Exception 
.const [40] = Utf8 'GEOnDemandActivator: start Google Earth failed!' 
.const [41] = Utf8 'GEOnDemandActivator: Google Earth map not active, do nothing' 
.const [42] = Utf8 'GEOnDemandActivator: could not load persistent data, do nothing' 
.const [43] = Utf8 'GEOnDemandActivator: failed to start' 
.const [44] = Utf8 de/audi/tghu/navi/app/googlemap/GEOnDemandActivator 
.const [45] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [46] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 de/audi/tghu/navi/app/map/context/State$StateData 
.const [49] = Utf8 de/audi/atip/start/IStartupManager 
.const [50] = Class [81] 
.const [51] = NameAndType [82] [83] 
.const [52] = Class [84] 
.const [53] = NameAndType [85] [86] 
.const [54] = Class [87] 
.const [55] = NameAndType [88] [89] 
.const [56] = Class [90] 
.const [57] = NameAndType [91] [92] 
.const [58] = Class [93] 
.const [59] = NameAndType [94] [95] 
.const [60] = Class [96] 
.const [61] = NameAndType [97] [98] 
.const [62] = Class [99] 
.const [63] = NameAndType [100] [101] 
.const [64] = Class [102] 
.const [65] = NameAndType [103] [104] 
.const [66] = Class [105] 
.const [67] = NameAndType [106] [107] 
.const [68] = Class [108] 
.const [69] = NameAndType [109] [110] 
.const [70] = Class [111] 
.const [71] = NameAndType [112] [113] 
.const [72] = Class [114] 
.const [73] = NameAndType [115] [116] 
.const [74] = Utf8 de/audi/tghu/navi/app/map/context/State 
.const [75] = Class [117] 
.const [76] = NameAndType [118] [119] 
.const [77] = Class [120] 
.const [78] = NameAndType [121] [122] 
.const [79] = Class [123] 
.const [80] = NameAndType [124] [125] 
.const [81] = Utf8 de/audi/tghu/navi/app/googlemap/GEOnDemandActivator 
.const [82] = Utf8 getFramework 
.const [83] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [84] = Utf8 de/audi/atip/log/LogChannel 
.const [85] = Utf8 log 
.const [86] = Utf8 (ILjava/lang/String;)Z 
.const [87] = Utf8 de/audi/tghu/navi/app/map/context/State 
.const [88] = Utf8 readAndDeserialize 
.const [89] = Utf8 ()V 
.const [90] = Utf8 de/audi/tghu/navi/app/googlemap/GEOnDemandActivator 
.const [91] = Utf8 framework 
.const [92] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [93] = Utf8 de/audi/tghu/navi/app/map/context/State 
.const [94] = Utf8 getData 
.const [95] = Utf8 ()Lde/audi/tghu/navi/app/map/context/State$StateData; 
.const [96] = Utf8 de/audi/tghu/navi/app/map/context/State$StateData 
.const [97] = Utf8 getMapRepresentation 
.const [98] = Utf8 ()I 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 log 
.const [101] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [102] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [106] = Utf8 start 
.const [107] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [108] = Utf8 de/audi/tghu/navi/app/map/context/State 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;Lde/audi/atip/base/IFrameworkAccess;I)V 
.const [111] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [112] = Utf8 getLogChannel 
.const [113] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [114] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [115] = Utf8 getStorageMgr 
.const [116] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [117] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [118] = Utf8 getSysConst 
.const [119] = Utf8 (I)I 
.const [120] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [121] = Utf8 getStartupMgr 
.const [122] = Utf8 ()Lde/audi/atip/start/IStartupManager; 
.const [123] = Utf8 de/audi/atip/start/IStartupManager 
.const [124] = Utf8 requestAppStart 
.const [125] = Utf8 (I)V 
.const [126] = Utf8 de/audi/tghu/navi/app/googlemap/GEOnDemandActivator 
.const [127] = Class [126] 
.const [128] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [129] = Class [128] 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 start 
.const [134] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.end class 
