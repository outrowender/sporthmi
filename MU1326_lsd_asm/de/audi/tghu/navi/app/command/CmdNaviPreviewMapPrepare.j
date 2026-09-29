.version 50 0 
.class public super [210] 
.super [212] 
.field private final [213] [214] 
.field private [215] [216] 
.field private final [217] [218] 
.field private final [219] [220] 
.field private [221] [222] 

.method public [224] : [225] 
    .attribute [223] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [33] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [34] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [35] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [36] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [37] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [223] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [37] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [228] : [229] 
    .attribute [223] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [223] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     aload_0 
L3:     getfield [19] 
L6:     invokespecial [31] 
L9:     putfield [33] 
L12:    aload_0 
L13:    getfield [19] 
L16:    arraylength 
L17:    ifeq L27 
L20:    aload_0 
L21:    getfield [23] 
L24:    ifeq L66 
L27:    aload_0 
L28:    getfield [24] 
L31:    ldc [2] 
L33:    ldc [3] 
L35:    aload_0 
L36:    getfield [25] 
L39:    aload_0 
L40:    getfield [23] 
L43:    invokestatic [4] 
L46:    invokevirtual [26] 
L49:    aload_0 
L50:    getfield [20] 
L53:    invokeinterface [38] 0 
L58:    aload_0 
L59:    iconst_1 
L60:    putfield [37] 
L63:    goto L257 
L66:    aload_0 
L67:    getfield [21] 
L70:    ifnull L81 
L73:    aload_0 
L74:    getfield [22] 
L77:    iconst_1 
L78:    if_icmpne L116 
L81:    aload_0 
L82:    getfield [24] 
L85:    ldc [2] 
L87:    ldc [5] 
L89:    aload_0 
L90:    getfield [25] 
L93:    invokevirtual [27] 
L96:    pop 
L97:    aload_0 
L98:    getfield [20] 
L101:   aload_0 
L102:   getfield [19] 
L105:   iconst_1 
L106:   aconst_null 
L107:   aconst_null 
L108:   invokeinterface [39] 0 
L113:   goto L257 
L116:   aload_0 
L117:   getfield [22] 
L120:   iconst_4 
L121:   if_icmpeq L131 
L124:   aload_0 
L125:   getfield [22] 
L128:   ifne L170 
L131:   aload_0 
L132:   getfield [24] 
L135:   ldc [2] 
L137:   ldc [6] 
L139:   aload_0 
L140:   getfield [25] 
L143:   invokevirtual [27] 
L146:   pop 
L147:   aload_0 
L148:   getfield [20] 
L151:   aload_0 
L152:   getfield [19] 
L155:   aload_0 
L156:   getfield [21] 
L159:   iconst_1 
L160:   aconst_null 
L161:   aconst_null 
L162:   invokeinterface [40] 0 
L167:   goto L257 
L170:   aload_0 
L171:   getfield [22] 
L174:   iconst_2 
L175:   if_icmpeq L186 
L178:   aload_0 
L179:   getfield [22] 
L182:   iconst_3 
L183:   if_icmpne L225 
L186:   aload_0 
L187:   getfield [24] 
L190:   ldc [2] 
L192:   ldc [7] 
L194:   aload_0 
L195:   getfield [25] 
L198:   invokevirtual [27] 
L201:   pop 
L202:   aload_0 
L203:   getfield [20] 
L206:   aload_0 
L207:   getfield [19] 
L210:   aload_0 
L211:   getfield [21] 
L214:   iconst_1 
L215:   aconst_null 
L216:   aconst_null 
L217:   invokeinterface [41] 0 
L222:   goto L257 
L225:   aload_0 
L226:   getfield [24] 
L229:   ldc [2] 
L231:   ldc [8] 
L233:   aload_0 
L234:   getfield [25] 
L237:   invokevirtual [27] 
L240:   pop 
L241:   aload_0 
L242:   getfield [20] 
L245:   aload_0 
L246:   getfield [19] 
L249:   iconst_1 
L250:   aconst_null 
L251:   aconst_null 
L252:   invokeinterface [42] 0 
L257:   aload_0 
L258:   invokevirtual [28] 
L261:   invokeinterface [43] 0 
L266:   return 
L267:   nop 
L268:   
    .end code 
.end method 

.method private [232] : [233] 
    .attribute [223] .code stack 3 locals 2 
L0:     new [44] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_2 
L8:     iconst_0 
L9:     istore_3 
L10:    iload_3 
L11:    aload_1 
L12:    arraylength 
L13:    if_icmpge L41 
L16:    aload_1 
L17:    iload_3 
L18:    aaload 
L19:    invokevirtual [29] 
L22:    ifeq L35 
L25:    aload_2 
L26:    aload_1 
L27:    iload_3 
L28:    aaload 
L29:    invokeinterface [45] 0 
L34:    pop 
L35:    iinc 3 1 
L38:    goto L10 
L41:    aload_2 
L42:    aload_2 
L43:    invokeinterface [46] 0 
L48:    anewarray [10] 
L51:    invokeinterface [47] 0 
L56:    checkcast [11] 
L59:    checkcast [11] 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [48] 
.const [4] = Method [49] [50] 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = String [53] 
.const [8] = String [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = Class [57] 
.const [12] = Class [58] 
.const [13] = Class [59] 
.const [14] = Class [60] 
.const [15] = Class [61] 
.const [16] = Class [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Field [65] [66] 
.const [20] = Field [67] [68] 
.const [21] = Field [69] [70] 
.const [22] = Field [71] [72] 
.const [23] = Field [73] [74] 
.const [24] = Field [75] [76] 
.const [25] = Field [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Field [93] [94] 
.const [34] = Field [95] [96] 
.const [35] = Field [97] [98] 
.const [36] = Field [99] [100] 
.const [37] = Field [101] [102] 
.const [38] = InterfaceMethod [103] [104] 
.const [39] = InterfaceMethod [105] [106] 
.const [40] = InterfaceMethod [107] [108] 
.const [41] = InterfaceMethod [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = Class [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = Utf8 '%1#execute - previewMap.hidePreviewMap() - hidePreviewMap = %2' 
.const [49] = Class [122] 
.const [50] = NameAndType [123] [124] 
.const [51] = Utf8 '%1#execute - previewMap.previewPOIsAroundCCP(poiNavLocations)' 
.const [52] = Utf8 '%1#execute - previewMap.previewPOIsAroundReferencePoint(poiNavLocations, currentSearchLocation)' 
.const [53] = Utf8 '%1#execute - previewMap.previewPOIsAroundDestination(poiNavLocations, currentSearchLocation)' 
.const [54] = Utf8 '%1#execute - previewMap.previewPOIs(poiNavLocations);' 
.const [55] = Utf8 java/util/ArrayList 
.const [56] = Utf8 org/dsi/ifc/global/NavLocation 
.const [57] = Utf8 [Lorg/dsi/ifc/global/NavLocation; 
.const [58] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [59] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [60] = Utf8 java/lang/String 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [63] = Utf8 de/audi/tghu/command/ICommandList 
.const [64] = Utf8 java/util/List 
.const [65] = Class [125] 
.const [66] = NameAndType [126] [127] 
.const [67] = Class [128] 
.const [68] = NameAndType [129] [130] 
.const [69] = Class [131] 
.const [70] = NameAndType [132] [133] 
.const [71] = Class [134] 
.const [72] = NameAndType [135] [136] 
.const [73] = Class [137] 
.const [74] = NameAndType [138] [139] 
.const [75] = Class [140] 
.const [76] = NameAndType [141] [142] 
.const [77] = Class [143] 
.const [78] = NameAndType [144] [145] 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Class [149] 
.const [82] = NameAndType [150] [151] 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Class [158] 
.const [88] = NameAndType [159] [160] 
.const [89] = Class [161] 
.const [90] = NameAndType [162] [163] 
.const [91] = Class [164] 
.const [92] = NameAndType [165] [166] 
.const [93] = Class [167] 
.const [94] = NameAndType [168] [169] 
.const [95] = Class [170] 
.const [96] = NameAndType [171] [172] 
.const [97] = Class [173] 
.const [98] = NameAndType [174] [175] 
.const [99] = Class [176] 
.const [100] = NameAndType [177] [178] 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Class [194] 
.const [112] = NameAndType [195] [196] 
.const [113] = Class [197] 
.const [114] = NameAndType [198] [199] 
.const [115] = Utf8 java/util/ArrayList 
.const [116] = Class [200] 
.const [117] = NameAndType [201] [202] 
.const [118] = Class [203] 
.const [119] = NameAndType [204] [205] 
.const [120] = Class [206] 
.const [121] = NameAndType [207] [208] 
.const [122] = Utf8 java/lang/String 
.const [123] = Utf8 valueOf 
.const [124] = Utf8 (Z)Ljava/lang/String; 
.const [125] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [126] = Utf8 poiNavLocations 
.const [127] = Utf8 [Lorg/dsi/ifc/global/NavLocation; 
.const [128] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [129] = Utf8 previewMap 
.const [130] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap; 
.const [131] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [132] = Utf8 currentSearchLocation 
.const [133] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [134] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [135] = Utf8 searchContext 
.const [136] = Utf8 I 
.const [137] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [138] = Utf8 hidePreviewMap 
.const [139] = Utf8 Z 
.const [140] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [141] = Utf8 logger 
.const [142] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [144] = Utf8 CLASS_NAME 
.const [145] = Utf8 Ljava/lang/String; 
.const [146] = Utf8 de/audi/atip/log/LogChannel 
.const [147] = Utf8 log 
.const [148] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [152] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [153] = Utf8 getCommandList 
.const [154] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [155] = Utf8 org/dsi/ifc/global/NavLocation 
.const [156] = Utf8 isPositionValid 
.const [157] = Utf8 ()Z 
.const [158] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [162] = Utf8 removeInvalidLocations 
.const [163] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;)[Lorg/dsi/ifc/global/NavLocation; 
.const [164] = Utf8 java/util/ArrayList 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [168] = Utf8 poiNavLocations 
.const [169] = Utf8 [Lorg/dsi/ifc/global/NavLocation; 
.const [170] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [171] = Utf8 previewMap 
.const [172] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap; 
.const [173] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [174] = Utf8 currentSearchLocation 
.const [175] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [176] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [177] = Utf8 searchContext 
.const [178] = Utf8 I 
.const [179] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [180] = Utf8 hidePreviewMap 
.const [181] = Utf8 Z 
.const [182] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [183] = Utf8 hidePreviewMap 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [186] = Utf8 setPreviewPOIsOnboardAroundCCP 
.const [187] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;ILde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;)V 
.const [188] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [189] = Utf8 setPreviewPOIsOnboardAroundReferencePoint 
.const [190] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;Lorg/dsi/ifc/global/NavLocationWgs84;ILde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;)V 
.const [191] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [192] = Utf8 setPreviewPOIsOnboardAroundDestination 
.const [193] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;Lorg/dsi/ifc/global/NavLocationWgs84;ILde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;)V 
.const [194] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [195] = Utf8 setPreviewPOIsOnboard 
.const [196] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;ILde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;)V 
.const [197] = Utf8 de/audi/tghu/command/ICommandList 
.const [198] = Utf8 commandFinished 
.const [199] = Utf8 ()V 
.const [200] = Utf8 java/util/List 
.const [201] = Utf8 add 
.const [202] = Utf8 (Ljava/lang/Object;)Z 
.const [203] = Utf8 java/util/List 
.const [204] = Utf8 size 
.const [205] = Utf8 ()I 
.const [206] = Utf8 java/util/List 
.const [207] = Utf8 toArray 
.const [208] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [209] = Utf8 de/audi/tghu/navi/app/command/CmdNaviPreviewMapPrepare 
.const [210] = Class [209] 
.const [211] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [212] = Class [211] 
.const [213] = Utf8 previewMap 
.const [214] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap; 
.const [215] = Utf8 poiNavLocations 
.const [216] = Utf8 [Lorg/dsi/ifc/global/NavLocation; 
.const [217] = Utf8 currentSearchLocation 
.const [218] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [219] = Utf8 searchContext 
.const [220] = Utf8 I 
.const [221] = Utf8 hidePreviewMap 
.const [222] = Utf8 Z 
.const [223] = Utf8 Code 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap;[Lorg/dsi/ifc/global/NavLocation;Lorg/dsi/ifc/global/NavLocationWgs84;I)V 
.const [226] = Utf8 setHidePreviewMap 
.const [227] = Utf8 (Z)V 
.const [228] = Utf8 getHidePreviewMap 
.const [229] = Utf8 ()Z 
.const [230] = Utf8 execute 
.const [231] = Utf8 ()V 
.const [232] = Utf8 removeInvalidLocations 
.const [233] = Utf8 ([Lorg/dsi/ifc/global/NavLocation;)[Lorg/dsi/ifc/global/NavLocation; 
.end class 
