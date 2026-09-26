.version 50 0 
.class public super [217] 
.super [219] 
.field public static final [220] [221] 
.field public static final [222] [223] 
.field public static final [224] [225] 
.field private [226] [227] 
.field private [228] [229] 
.field private [230] [231] 

.method public [233] : [234] 
    .attribute [232] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [43] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [44] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [45] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [232] .code stack 6 locals 8 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokevirtual [29] 
L7:     invokeinterface [46] 0 
L12:    astore_1 
L13:    aload_1 
L14:    invokestatic [2] 
L17:    istore_2 
L18:    iload_2 
L19:    ifne L51 
L22:    ldc [3] 
L24:    astore_3 
L25:    aload_0 
L26:    getfield [30] 
L29:    ldc [4] 
L31:    ldc [5] 
L33:    aload_3 
L34:    invokevirtual [31] 
L37:    pop 
L38:    aload_0 
L39:    invokevirtual [32] 
L42:    aload_3 
L43:    invokeinterface [47] 0 
L48:    goto L290 
L51:    aload_0 
L52:    getfield [28] 
L55:    invokevirtual [33] 
L58:    invokeinterface [48] 0 
L63:    astore_3 
L64:    aload_1 
L65:    invokestatic [6] 
L68:    istore 4 
L70:    iload 4 
L72:    ifne L264 
L75:    aload_0 
L76:    getfield [28] 
L79:    invokevirtual [34] 
L82:    invokevirtual [35] 
L85:    iconst_1 
L86:    invokeinterface [49] 0 
L91:    iconst_0 
L92:    aaload 
L93:    astore 5 
L95:    aconst_null 
L96:    astore 6 
L98:    aload_0 
L99:    getfield [30] 
L102:   ldc [7] 
L104:   ldc [8] 
L106:   aload 5 
L108:   iload_2 
L109:   i2l 
L110:   invokevirtual [36] 
L113:   pop 
L114:   iload_2 
L115:   iconst_1 
L116:   if_icmpne L194 
L119:   aload_0 
L120:   getfield [25] 
L123:   iconst_1 
L124:   if_icmpeq L134 
L127:   aload_0 
L128:   getfield [25] 
L131:   ifne L194 
L134:   iconst_3 
L135:   anewarray [9] 
L138:   astore 7 
L140:   iconst_0 
L141:   istore 8 
L143:   iload 8 
L145:   aload 7 
L147:   arraylength 
L148:   if_icmpge L164 
L151:   aload 7 
L153:   iload 8 
L155:   aload 5 
L157:   aastore 
L158:   iinc 8 1 
L161:   goto L143 
L164:   aload_1 
L165:   aload 7 
L167:   invokestatic [10] 
L170:   astore 6 
L172:   aload_3 
L173:   new [50] 
L176:   dup 
L177:   aload 6 
L179:   iconst_3 
L180:   aload_0 
L181:   getfield [26] 
L184:   invokespecial [42] 
L187:   invokevirtual [37] 
L190:   pop 
L191:   goto L261 
L194:   aload_1 
L195:   iconst_1 
L196:   anewarray [9] 
L199:   dup 
L200:   iconst_0 
L201:   aload 5 
L203:   aastore 
L204:   invokestatic [10] 
L207:   astore 6 
L209:   aload_0 
L210:   getfield [27] 
L213:   ifeq L230 
L216:   aload_0 
L217:   getfield [38] 
L220:   invokevirtual [39] 
L223:   ifeq L230 
L226:   iconst_1 
L227:   goto L231 
L230:   iconst_0 
L231:   istore 7 
L233:   aload_3 
L234:   new [50] 
L237:   dup 
L238:   aload 6 
L240:   iload 7 
L242:   ifeq L249 
L245:   iconst_0 
L246:   goto L250 
L249:   iconst_1 
L250:   aload_0 
L251:   getfield [26] 
L254:   invokespecial [42] 
L257:   invokevirtual [37] 
L260:   pop 
L261:   goto L280 
L264:   aload_0 
L265:   getfield [30] 
L268:   sipush 10000 
L271:   ldc [12] 
L273:   iload 4 
L275:   i2l 
L276:   invokevirtual [40] 
L279:   pop 
L280:   aload_0 
L281:   invokevirtual [32] 
L284:   aload_3 
L285:   invokeinterface [51] 0 
L290:   return 
L291:   nop 
L292:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [52] [53] 
.const [3] = String [54] 
.const [4] = Int -1601830656 
.const [5] = String [55] 
.const [6] = Method [56] [57] 
.const [7] = Int -2137614336 
.const [8] = String [58] 
.const [9] = Class [59] 
.const [10] = Method [60] [61] 
.const [11] = Class [62] 
.const [12] = String [63] 
.const [13] = Class [64] 
.const [14] = Class [65] 
.const [15] = Class [66] 
.const [16] = Class [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Class [74] 
.const [24] = Class [75] 
.const [25] = Field [76] [77] 
.const [26] = Field [78] [79] 
.const [27] = Field [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Field [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Field [112] [113] 
.const [44] = Field [114] [115] 
.const [45] = Field [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = InterfaceMethod [124] [125] 
.const [50] = Class [126] 
.const [51] = InterfaceMethod [127] [128] 
.const [52] = Class [129] 
.const [53] = NameAndType [130] [131] 
.const [54] = Utf8 'current on-road route is null!' 
.const [55] = Utf8 'StartGuidanceCommand#execute() - %1 ' 
.const [56] = Class [132] 
.const [57] = NameAndType [133] [134] 
.const [58] = Utf8 'StartGuidanceCommand#execute() - configuredRouteOptions: %1, routeLength: %2' 
.const [59] = Utf8 org/dsi/ifc/navigation/RouteOptions 
.const [60] = Class [135] 
.const [61] = NameAndType [136] [137] 
.const [62] = Utf8 de/audi/tghu/navi/app/command/RGCalculateRoute 
.const [63] = Utf8 'StartGuidanceCommand#execute() - only ROUTEID_ONROAD supported, not %1 !' 
.const [64] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [65] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [66] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [67] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [68] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 de/audi/tghu/command/ICommandList 
.const [71] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [72] = Utf8 de/audi/tghu/navi/app/setup/RouteCriteriaManager 
.const [73] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [74] = Utf8 de/audi/tghu/command/CommandList 
.const [75] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Class [150] 
.const [85] = NameAndType [151] [152] 
.const [86] = Class [153] 
.const [87] = NameAndType [154] [155] 
.const [88] = Class [156] 
.const [89] = NameAndType [157] [158] 
.const [90] = Class [159] 
.const [91] = NameAndType [160] [161] 
.const [92] = Class [162] 
.const [93] = NameAndType [163] [164] 
.const [94] = Class [165] 
.const [95] = NameAndType [166] [167] 
.const [96] = Class [168] 
.const [97] = NameAndType [169] [170] 
.const [98] = Class [171] 
.const [99] = NameAndType [172] [173] 
.const [100] = Class [174] 
.const [101] = NameAndType [175] [176] 
.const [102] = Class [177] 
.const [103] = NameAndType [178] [179] 
.const [104] = Class [180] 
.const [105] = NameAndType [181] [182] 
.const [106] = Class [183] 
.const [107] = NameAndType [184] [185] 
.const [108] = Class [186] 
.const [109] = NameAndType [187] [188] 
.const [110] = Class [189] 
.const [111] = NameAndType [190] [191] 
.const [112] = Class [192] 
.const [113] = NameAndType [193] [194] 
.const [114] = Class [195] 
.const [115] = NameAndType [196] [197] 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Class [210] 
.const [125] = NameAndType [211] [212] 
.const [126] = Utf8 de/audi/tghu/navi/app/command/RGCalculateRoute 
.const [127] = Class [213] 
.const [128] = NameAndType [214] [215] 
.const [129] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [130] = Utf8 getRouteLength 
.const [131] = Utf8 (Lorg/dsi/ifc/navigation/Route;)I 
.const [132] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [133] = Utf8 getRouteID 
.const [134] = Utf8 (Lorg/dsi/ifc/navigation/Route;)I 
.const [135] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [136] = Utf8 cloneRoute 
.const [137] = Utf8 (Lorg/dsi/ifc/navigation/Route;[Lorg/dsi/ifc/navigation/RouteOptions;)Lorg/dsi/ifc/navigation/Route; 
.const [138] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [139] = Utf8 altRoutesState 
.const [140] = Utf8 I 
.const [141] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [142] = Utf8 prepareMap 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [145] = Utf8 tryResume 
.const [146] = Utf8 Z 
.const [147] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [148] = Utf8 navigation 
.const [149] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [150] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [151] = Utf8 getRouteManager 
.const [152] = Utf8 ()Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [153] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [154] = Utf8 logger 
.const [155] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [159] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [160] = Utf8 getCommandList 
.const [161] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [162] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [163] = Utf8 getCommandListFactory 
.const [164] = Utf8 ()Lde/audi/tghu/command/ICommandListFactory; 
.const [165] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [166] = Utf8 getRouteCriteriaManager 
.const [167] = Utf8 ()Lde/audi/tghu/navi/app/setup/RouteCriteriaManager; 
.const [168] = Utf8 de/audi/tghu/navi/app/setup/RouteCriteriaManager 
.const [169] = Utf8 getRouteCriteria 
.const [170] = Utf8 ()Lde/audi/tghu/navi/app/setup/IRouteCriteria; 
.const [171] = Utf8 de/audi/atip/log/LogChannel 
.const [172] = Utf8 log 
.const [173] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [174] = Utf8 de/audi/tghu/command/CommandList 
.const [175] = Utf8 add 
.const [176] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [177] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [178] = Utf8 dsiResponseContainer 
.const [179] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [180] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [181] = Utf8 isRouteResumePossible 
.const [182] = Utf8 ()Z 
.const [183] = Utf8 de/audi/atip/log/LogChannel 
.const [184] = Utf8 log 
.const [185] = Utf8 (ILjava/lang/String;J)Z 
.const [186] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/tghu/navi/app/command/RGCalculateRoute 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lorg/dsi/ifc/navigation/Route;IZ)V 
.const [192] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [193] = Utf8 altRoutesState 
.const [194] = Utf8 I 
.const [195] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [196] = Utf8 prepareMap 
.const [197] = Utf8 Z 
.const [198] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [199] = Utf8 tryResume 
.const [200] = Utf8 Z 
.const [201] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [202] = Utf8 getRoute 
.const [203] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [204] = Utf8 de/audi/tghu/command/ICommandList 
.const [205] = Utf8 commandAborted 
.const [206] = Utf8 (Ljava/lang/String;)V 
.const [207] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [208] = Utf8 createCommandList 
.const [209] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [210] = Utf8 de/audi/tghu/navi/app/setup/IRouteCriteria 
.const [211] = Utf8 getRouteOptions 
.const [212] = Utf8 (Z)[Lorg/dsi/ifc/navigation/RouteOptions; 
.const [213] = Utf8 de/audi/tghu/command/ICommandList 
.const [214] = Utf8 commandFinishedWithPostSequence 
.const [215] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [216] = Utf8 de/audi/tghu/navi/app/command/StartGuidanceCommand 
.const [217] = Class [216] 
.const [218] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [219] = Class [218] 
.const [220] = Utf8 ALT_ROUTES_ALLOW 
.const [221] = Utf8 I 
.const [222] = Utf8 ALT_ROUTES_ENABLE 
.const [223] = Utf8 I 
.const [224] = Utf8 ALT_ROUTES_DISABLE 
.const [225] = Utf8 I 
.const [226] = Utf8 altRoutesState 
.const [227] = Utf8 I 
.const [228] = Utf8 prepareMap 
.const [229] = Utf8 Z 
.const [230] = Utf8 tryResume 
.const [231] = Utf8 Z 
.const [232] = Utf8 Code 
.const [233] = Utf8 <init> 
.const [234] = Utf8 (IZZ)V 
.const [235] = Utf8 execute 
.const [236] = Utf8 ()V 
.end class 
