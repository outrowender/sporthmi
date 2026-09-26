.version 50 0 
.class public super abstract [225] 
.super [227] 
.implements [229] 
.field private final [230] [231] 
.field private final [232] [233] 
.field protected final [234] [235] 
.field protected final [236] [237] 
.field protected final [238] [239] 

.method public [241] : [242] 
    .attribute [240] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     aload_0 
L6:     invokespecial [40] 
L9:     invokestatic [2] 
L12:    putfield [42] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [43] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [44] 
L25:    aload_0 
L26:    aload_3 
L27:    putfield [45] 
L30:    aload_0 
L31:    aload_2 
L32:    invokevirtual [27] 
L35:    putfield [46] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [240] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     ifne L14 
L7:     aload_0 
L8:     invokevirtual [30] 
L11:    ifeq L147 
L14:    aload_0 
L15:    getfield [24] 
L18:    ifnull L147 
L21:    aload_0 
L22:    getfield [24] 
L25:    invokeinterface [47] 0 
L30:    ifnull L147 
L33:    aload_0 
L34:    invokevirtual [30] 
L37:    ifeq L82 
L40:    aload_0 
L41:    getfield [28] 
L44:    invokevirtual [31] 
L47:    ifeq L66 
L50:    aload_0 
L51:    getfield [28] 
L54:    ldc [3] 
L56:    ldc [4] 
L58:    aload_0 
L59:    getfield [23] 
L62:    invokevirtual [32] 
L65:    pop 
L66:    aload_0 
L67:    getfield [24] 
L70:    invokeinterface [47] 0 
L75:    invokestatic [5] 
L78:    astore_1 
L79:    goto L121 
L82:    aload_0 
L83:    getfield [28] 
L86:    invokevirtual [31] 
L89:    ifeq L108 
L92:    aload_0 
L93:    getfield [28] 
L96:    ldc [3] 
L98:    ldc [6] 
L100:   aload_0 
L101:   getfield [23] 
L104:   invokevirtual [32] 
L107:   pop 
L108:   aload_0 
L109:   getfield [24] 
L112:   invokeinterface [47] 0 
L117:   invokestatic [7] 
L120:   astore_1 
L121:   new [48] 
L124:   dup 
L125:   invokespecial [41] 
L128:   astore_2 
L129:   aload_2 
L130:   aload_1 
L131:   invokevirtual [33] 
L134:   putfield [49] 
L137:   aload_2 
L138:   aload_1 
L139:   invokevirtual [34] 
L142:   putfield [50] 
L145:   aload_2 
L146:   areturn 
L147:   aload_0 
L148:   invokevirtual [35] 
L151:   ifeq L231 
L154:   aload_0 
L155:   getfield [28] 
L158:   invokevirtual [31] 
L161:   ifeq L180 
L164:   aload_0 
L165:   getfield [28] 
L168:   ldc [3] 
L170:   ldc [9] 
L172:   aload_0 
L173:   getfield [23] 
L176:   invokevirtual [32] 
L179:   pop 
L180:   aload_0 
L181:   getfield [25] 
L184:   invokevirtual [36] 
L187:   invokevirtual [37] 
L190:   astore_1 
L191:   aload_0 
L192:   getfield [25] 
L195:   invokevirtual [36] 
L198:   invokevirtual [38] 
L201:   iconst_5 
L202:   if_icmpne L215 
L205:   aload_0 
L206:   getfield [26] 
L209:   invokeinterface [51] 0 
L214:   areturn 
L215:   aload_1 
L216:   ifnull L221 
L219:   aload_1 
L220:   areturn 
L221:   aload_0 
L222:   getfield [26] 
L225:   invokeinterface [51] 0 
L230:   areturn 
L231:   aload_0 
L232:   getfield [28] 
L235:   invokevirtual [31] 
L238:   ifeq L257 
L241:   aload_0 
L242:   getfield [28] 
L245:   ldc [3] 
L247:   ldc [10] 
L249:   aload_0 
L250:   getfield [23] 
L253:   invokevirtual [32] 
L256:   pop 
L257:   aload_0 
L258:   getfield [26] 
L261:   ifnonnull L282 
L264:   aload_0 
L265:   getfield [28] 
L268:   ldc [11] 
L270:   ldc [12] 
L272:   aload_0 
L273:   getfield [23] 
L276:   invokevirtual [32] 
L279:   pop 
L280:   aconst_null 
L281:   areturn 
L282:   aload_0 
L283:   getfield [26] 
L286:   invokeinterface [51] 0 
L291:   areturn 
L292:   
    .end code 
.end method 

.method protected abstract [245] : [246] 
    .attribute [240] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [247] : [248] 
    .attribute [240] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [249] : [250] 
    .attribute [240] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [52] [53] 
.const [3] = Int 14808325 
.const [4] = String [54] 
.const [5] = Method [55] [56] 
.const [6] = String [57] 
.const [7] = Method [58] [59] 
.const [8] = Class [60] 
.const [9] = String [61] 
.const [10] = String [62] 
.const [11] = Int -1601830656 
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
.const [23] = Field [74] [75] 
.const [24] = Field [76] [77] 
.const [25] = Field [78] [79] 
.const [26] = Field [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Field [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Field [112] [113] 
.const [43] = Field [114] [115] 
.const [44] = Field [116] [117] 
.const [45] = Field [118] [119] 
.const [46] = Field [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = Class [124] 
.const [49] = Field [125] [126] 
.const [50] = Field [127] [128] 
.const [51] = InterfaceMethod [129] [130] 
.const [52] = Class [131] 
.const [53] = NameAndType [132] [133] 
.const [54] = Utf8 '%1#getInitialPosition - calculating for destination vicinity' 
.const [55] = Class [134] 
.const [56] = NameAndType [135] [136] 
.const [57] = Utf8 '%1#getInitialPosition - calculating for stop over vicinity' 
.const [58] = Class [137] 
.const [59] = NameAndType [138] [139] 
.const [60] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [61] = Utf8 '%1#getInitialPosition - calculation for new city' 
.const [62] = Utf8 '%1#getInitialPosition getting vehicle position' 
.const [63] = Utf8 '%1#getInitialPosition vehicle is null, no position available, returning null' 
.const [64] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [67] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [68] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [71] = Utf8 org/dsi/ifc/global/NavLocation 
.const [72] = Utf8 de/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea 
.const [73] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Class [194] 
.const [111] = NameAndType [195] [196] 
.const [112] = Class [197] 
.const [113] = NameAndType [198] [199] 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Class [203] 
.const [117] = NameAndType [204] [205] 
.const [118] = Class [206] 
.const [119] = NameAndType [207] [208] 
.const [120] = Class [209] 
.const [121] = NameAndType [210] [211] 
.const [122] = Class [212] 
.const [123] = NameAndType [213] [214] 
.const [124] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [125] = Class [215] 
.const [126] = NameAndType [216] [217] 
.const [127] = Class [218] 
.const [128] = NameAndType [219] [220] 
.const [129] = Class [221] 
.const [130] = NameAndType [222] [223] 
.const [131] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [132] = Utf8 getClassNameFromPackageName 
.const [133] = Utf8 (Ljava/lang/Class;)Ljava/lang/String; 
.const [134] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [135] = Utf8 getFinalDestination 
.const [136] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Lorg/dsi/ifc/global/NavLocation; 
.const [137] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [138] = Utf8 getFirstDestination 
.const [139] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Lorg/dsi/ifc/global/NavLocation; 
.const [140] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [141] = Utf8 CLASS_NAME 
.const [142] = Utf8 Ljava/lang/String; 
.const [143] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [144] = Utf8 routeManager 
.const [145] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [146] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [147] = Utf8 env 
.const [148] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [149] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [150] = Utf8 vehicle 
.const [151] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [152] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [153] = Utf8 getPOILogChannel 
.const [154] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [155] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [156] = Utf8 logChannel 
.const [157] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [158] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [159] = Utf8 isStopOverVicinity 
.const [160] = Utf8 ()Z 
.const [161] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [162] = Utf8 isDestinationVicinity 
.const [163] = Utf8 ()Z 
.const [164] = Utf8 de/audi/atip/log/LogChannel 
.const [165] = Utf8 isDebug2 
.const [166] = Utf8 ()Z 
.const [167] = Utf8 de/audi/atip/log/LogChannel 
.const [168] = Utf8 log 
.const [169] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [170] = Utf8 org/dsi/ifc/global/NavLocation 
.const [171] = Utf8 getLatitude 
.const [172] = Utf8 ()I 
.const [173] = Utf8 org/dsi/ifc/global/NavLocation 
.const [174] = Utf8 getLongitude 
.const [175] = Utf8 ()I 
.const [176] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [177] = Utf8 isInNewCity 
.const [178] = Utf8 ()Z 
.const [179] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [180] = Utf8 getPoiSearchArea 
.const [181] = Utf8 ()Lde/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea; 
.const [182] = Utf8 de/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea 
.const [183] = Utf8 getLocationAsPosPosition 
.const [184] = Utf8 ()Lorg/dsi/ifc/navigation/PosPosition; 
.const [185] = Utf8 de/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea 
.const [186] = Utf8 getSearchContext 
.const [187] = Utf8 ()I 
.const [188] = Utf8 java/lang/Object 
.const [189] = Utf8 <init> 
.const [190] = Utf8 ()V 
.const [191] = Utf8 java/lang/Object 
.const [192] = Utf8 getClass 
.const [193] = Utf8 ()Ljava/lang/Class; 
.const [194] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [195] = Utf8 <init> 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [198] = Utf8 CLASS_NAME 
.const [199] = Utf8 Ljava/lang/String; 
.const [200] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [201] = Utf8 routeManager 
.const [202] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [203] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [204] = Utf8 env 
.const [205] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [206] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [207] = Utf8 vehicle 
.const [208] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [209] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [210] = Utf8 logChannel 
.const [211] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [212] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [213] = Utf8 getRoute 
.const [214] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [215] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [216] = Utf8 latitude 
.const [217] = Utf8 I 
.const [218] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [219] = Utf8 longitude 
.const [220] = Utf8 I 
.const [221] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [222] = Utf8 getPosition 
.const [223] = Utf8 ()Lorg/dsi/ifc/navigation/PosPosition; 
.const [224] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/AbstractRRDInitialPositionHandler 
.const [225] = Class [224] 
.const [226] = Utf8 java/lang/Object 
.const [227] = Class [226] 
.const [228] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/RRDInitialPositionHandler 
.const [229] = Class [228] 
.const [230] = Utf8 CLASS_NAME 
.const [231] = Utf8 Ljava/lang/String; 
.const [232] = Utf8 logChannel 
.const [233] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [234] = Utf8 routeManager 
.const [235] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [236] = Utf8 env 
.const [237] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [238] = Utf8 vehicle 
.const [239] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [240] = Utf8 Code 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/guidance/IVehicle;)V 
.const [243] = Utf8 getInitialPosition 
.const [244] = Utf8 ()Lorg/dsi/ifc/navigation/PosPosition; 
.const [245] = Utf8 isStopOverVicinity 
.const [246] = Utf8 ()Z 
.const [247] = Utf8 isDestinationVicinity 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 isInNewCity 
.const [250] = Utf8 ()Z 
.end class 
