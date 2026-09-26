.version 50 0 
.class public super [226] 
.super [228] 
.field private final [229] [230] 
.field private static final [231] [232] 
.field private static final [233] [234] 
.field private static final [235] [236] 
.field private static final [237] [238] 
.field private static final [239] [240] 
.field private static final [241] [242] 
.field private static final [243] [244] 
.field private static final [245] [246] 
.field private static final [247] [248] 

.method public [250] : [251] 
    .attribute [249] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iload 4 
L6:     invokespecial [43] 
L9:     aload_0 
L10:    iload 5 
L12:    putfield [47] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [249] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload 4 
L10:    aload_1 
L11:    lload_2 
L12:    invokevirtual [29] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [249] .code stack 7 locals 8 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     aload 4 
L10:    aload_1 
L11:    lload_2 
L12:    invokevirtual [29] 
L15:    aload_1 
L16:    invokestatic [5] 
L19:    ifeq L30 
L22:    aload_1 
L23:    invokevirtual [30] 
L26:    arraylength 
L27:    ifne L112 
L30:    aload_0 
L31:    getfield [31] 
L34:    invokeinterface [48] 0 
L39:    ldc [6] 
L41:    istore 6 
L43:    iload 6 
L45:    ifne L66 
L48:    aload_0 
L49:    getfield [32] 
L52:    ldc [7] 
L54:    invokevirtual [33] 
L57:    iconst_0 
L58:    invokeinterface [49] 0 
L63:    goto L111 
L66:    iload 6 
L68:    iconst_1 
L69:    if_icmpne L90 
L72:    aload_0 
L73:    getfield [32] 
L76:    ldc [7] 
L78:    invokevirtual [33] 
L81:    iconst_4 
L82:    invokeinterface [49] 0 
L87:    goto L111 
L90:    iload 6 
L92:    iconst_2 
L93:    if_icmpne L111 
L96:    aload_0 
L97:    getfield [32] 
L100:   ldc [7] 
L102:   invokevirtual [33] 
L105:   iconst_2 
L106:   invokeinterface [49] 0 
L111:   return 
L112:   aload_1 
L113:   invokevirtual [30] 
L116:   astore 6 
L118:   aload 6 
L120:   arraylength 
L121:   istore 7 
L123:   aload_0 
L124:   getfield [31] 
L127:   invokeinterface [50] 0 
L132:   istore 8 
L134:   aload_0 
L135:   getfield [28] 
L138:   ldc [2] 
L140:   ldc [8] 
L142:   iload 7 
L144:   i2l 
L145:   iload 8 
L147:   i2l 
L148:   invokevirtual [34] 
L151:   pop 
L152:   aload_0 
L153:   getfield [27] 
L156:   iload 8 
L158:   isub 
L159:   istore 9 
L161:   iload 9 
L163:   iload 7 
L165:   invokestatic [9] 
L168:   istore 10 
L170:   aload_0 
L171:   getfield [28] 
L174:   ldc [2] 
L176:   new [51] 
L179:   dup 
L180:   invokespecial [44] 
L183:   ldc [11] 
L185:   invokevirtual [35] 
L188:   iload 10 
L190:   invokevirtual [36] 
L193:   invokevirtual [37] 
L196:   invokevirtual [38] 
L199:   pop 
        .catch [12] from L200 to L270 using L273 
L200:   iconst_0 
L201:   istore 11 
L203:   iload 11 
L205:   iload 10 
L207:   if_icmpge L270 
L210:   aload 6 
L212:   iload 11 
L214:   aaload 
L215:   astore 12 
L217:   aload_0 
L218:   getfield [39] 
L221:   aload 12 
L223:   aload 12 
L225:   getfield [40] 
L228:   invokeinterface [52] 0 
L233:   astore 13 
L235:   aload_0 
L236:   getfield [31] 
L239:   iinc 8 1 
L242:   iload 8 
L244:   invokeinterface [53] 0 
L249:   aload_0 
L250:   getfield [31] 
L253:   iload 8 
L255:   iconst_1 
L256:   isub 
L257:   aload 13 
L259:   invokeinterface [54] 0 
L264:   iinc 11 1 
L267:   goto L203 
L270:   goto L314 
L273:   astore 11 
L275:   new [55] 
L278:   dup 
L279:   invokespecial [45] 
L282:   astore 12 
L284:   aload 11 
L286:   new [56] 
L289:   dup 
L290:   aload 12 
L292:   invokespecial [46] 
L295:   invokevirtual [41] 
L298:   aload_0 
L299:   getfield [28] 
L302:   sipush 10000 
L305:   ldc [15] 
L307:   aload 11 
L309:   aload 12 
L311:   invokevirtual [42] 
L314:   return 
L315:   nop 
L316:   
    .end code 
.end method 

.method public enum [256] : [257] 
    .attribute [249] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [57] 
.const [4] = String [58] 
.const [5] = Method [59] [60] 
.const [6] = Int -2028075520 
.const [7] = Int 723584512 
.const [8] = String [61] 
.const [9] = Method [62] [63] 
.const [10] = Class [64] 
.const [11] = String [65] 
.const [12] = Class [66] 
.const [13] = Class [67] 
.const [14] = Class [68] 
.const [15] = String [69] 
.const [16] = Class [70] 
.const [17] = Class [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Class [79] 
.const [26] = Class [80] 
.const [27] = Field [81] [82] 
.const [28] = Field [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Field [89] [90] 
.const [32] = Field [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Field [105] [106] 
.const [40] = Field [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Method [111] [112] 
.const [43] = Method [113] [114] 
.const [44] = Method [115] [116] 
.const [45] = Method [117] [118] 
.const [46] = Method [119] [120] 
.const [47] = Field [121] [122] 
.const [48] = InterfaceMethod [123] [124] 
.const [49] = InterfaceMethod [125] [126] 
.const [50] = InterfaceMethod [127] [128] 
.const [51] = Class [129] 
.const [52] = InterfaceMethod [130] [131] 
.const [53] = InterfaceMethod [132] [133] 
.const [54] = InterfaceMethod [134] [135] 
.const [55] = Class [136] 
.const [56] = Class [137] 
.const [57] = Utf8 'FuelWarningSequenceModelAccess#onUpdateResultList( %2, %3, %1) WAS CALLED BUT IGNORED' 
.const [58] = Utf8 'FuelWarningSequenceModelAccess#onUpdateResultList( %2, %3, %1)' 
.const [59] = Class [138] 
.const [60] = NameAndType [139] [140] 
.const [61] = Utf8 'FuelWarningSequenceModelAccess#onUpdateResultList - valueListLength: %1, currentListModelLength: %2' 
.const [62] = Class [141] 
.const [63] = NameAndType [142] [143] 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 'FuelWarningSequenceModelAccess#onUpdateResultList - previewlistlength: ' 
.const [66] = Utf8 java/lang/Exception 
.const [67] = Utf8 java/io/StringWriter 
.const [68] = Utf8 java/io/PrintWriter 
.const [69] = Utf8 "Exception caught in FuelWarningSequenceModelAccess: '%1', stacktrace: %2" 
.const [70] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [71] = Utf8 de/audi/tghu/navi/app/addressinput/poi/models/AbstractPoiBaseListModelAccess 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [74] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [75] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [76] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [77] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [78] = Utf8 java/lang/Math 
.const [79] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [80] = Utf8 de/audi/tghu/navi/app/addressinput/listbuilders/IEvoListRowBuilder 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Class [168] 
.const [98] = NameAndType [169] [170] 
.const [99] = Class [171] 
.const [100] = NameAndType [172] [173] 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Class [180] 
.const [106] = NameAndType [181] [182] 
.const [107] = Class [183] 
.const [108] = NameAndType [184] [185] 
.const [109] = Class [186] 
.const [110] = NameAndType [187] [188] 
.const [111] = Class [189] 
.const [112] = NameAndType [190] [191] 
.const [113] = Class [192] 
.const [114] = NameAndType [193] [194] 
.const [115] = Class [195] 
.const [116] = NameAndType [196] [197] 
.const [117] = Class [198] 
.const [118] = NameAndType [199] [200] 
.const [119] = Class [201] 
.const [120] = NameAndType [202] [203] 
.const [121] = Class [204] 
.const [122] = NameAndType [205] [206] 
.const [123] = Class [207] 
.const [124] = NameAndType [208] [209] 
.const [125] = Class [210] 
.const [126] = NameAndType [211] [212] 
.const [127] = Class [213] 
.const [128] = NameAndType [214] [215] 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Class [216] 
.const [131] = NameAndType [217] [218] 
.const [132] = Class [219] 
.const [133] = NameAndType [220] [221] 
.const [134] = Class [222] 
.const [135] = NameAndType [223] [224] 
.const [136] = Utf8 java/io/StringWriter 
.const [137] = Utf8 java/io/PrintWriter 
.const [138] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [139] = Utf8 isListValid 
.const [140] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;)Z 
.const [141] = Utf8 java/lang/Math 
.const [142] = Utf8 min 
.const [143] = Utf8 (II)I 
.const [144] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [145] = Utf8 maximumResults 
.const [146] = Utf8 I 
.const [147] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [148] = Utf8 logChannel 
.const [149] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [153] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [154] = Utf8 getList 
.const [155] = Utf8 ()[Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [156] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [157] = Utf8 previewListModel 
.const [158] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [159] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [160] = Utf8 env 
.const [161] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [162] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [163] = Utf8 getChoiceModel 
.const [164] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;JJ)Z 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 append 
.const [170] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 append 
.const [173] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [174] = Utf8 java/lang/StringBuffer 
.const [175] = Utf8 toString 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 de/audi/atip/log/LogChannel 
.const [178] = Utf8 log 
.const [179] = Utf8 (ILjava/lang/String;)Z 
.const [180] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [181] = Utf8 listRowBuilder 
.const [182] = Utf8 Lde/audi/tghu/navi/app/addressinput/listbuilders/IEvoListRowBuilder; 
.const [183] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [184] = Utf8 listIndex 
.const [185] = Utf8 I 
.const [186] = Utf8 java/lang/Exception 
.const [187] = Utf8 printStackTrace 
.const [188] = Utf8 (Ljava/io/PrintWriter;)V 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [192] = Utf8 de/audi/tghu/navi/app/addressinput/poi/models/AbstractPoiBaseListModelAccess 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/hmi/model/list/BaseListModelListener;Lde/audi/tghu/navi/app/addressinput/listbuilders/IEvoListRowBuilder;I)V 
.const [195] = Utf8 java/lang/StringBuffer 
.const [196] = Utf8 <init> 
.const [197] = Utf8 ()V 
.const [198] = Utf8 java/io/StringWriter 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ()V 
.const [201] = Utf8 java/io/PrintWriter 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Ljava/io/Writer;)V 
.const [204] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [205] = Utf8 maximumResults 
.const [206] = Utf8 I 
.const [207] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [208] = Utf8 removeAll 
.const [209] = Utf8 ()V 
.const [210] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [211] = Utf8 setValue 
.const [212] = Utf8 (I)V 
.const [213] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [214] = Utf8 getLength 
.const [215] = Utf8 ()I 
.const [216] = Utf8 de/audi/tghu/navi/app/addressinput/listbuilders/IEvoListRowBuilder 
.const [217] = Utf8 buildListRow 
.const [218] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;I)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [219] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [220] = Utf8 setLength 
.const [221] = Utf8 (I)V 
.const [222] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [223] = Utf8 setRow 
.const [224] = Utf8 (ILde/audi/atip/hmi/model/list/EvoListRow;)V 
.const [225] = Utf8 de/audi/app/navi/evo/addressinput/poi/fuelwarning/FuelWarningSequenceModelAccess 
.const [226] = Class [225] 
.const [227] = Utf8 de/audi/tghu/navi/app/addressinput/poi/models/AbstractPoiBaseListModelAccess 
.const [228] = Class [227] 
.const [229] = Utf8 maximumResults 
.const [230] = Utf8 I 
.const [231] = Utf8 NO_GAS_STATION_IN_VINCINITY_CHOICE 
.const [232] = Utf8 I 
.const [233] = Utf8 NO_GAS_STATION_ALONG_ROUTE_CHOICE 
.const [234] = Utf8 I 
.const [235] = Utf8 NO_DIESEL_STATION_IN_VINCINITY_CHOICE 
.const [236] = Utf8 I 
.const [237] = Utf8 NO_DIESEL_STATION_ALONG_ROUTE_CHOICE 
.const [238] = Utf8 I 
.const [239] = Utf8 NO_CNG_STATION_IN_VINCINITY_CHOICE 
.const [240] = Utf8 I 
.const [241] = Utf8 NO_CNG_STATION_ALONG_ROUTE_CHOICE 
.const [242] = Utf8 I 
.const [243] = Utf8 NO_FUEL_TYPE_CHOICE 
.const [244] = Utf8 I 
.const [245] = Utf8 FUEL_TYPE_CNG_CHOICE 
.const [246] = Utf8 I 
.const [247] = Utf8 FUEL_TYPE_DIESEL_CHOICE 
.const [248] = Utf8 I 
.const [249] = Utf8 Code 
.const [250] = Utf8 <init> 
.const [251] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/hmi/model/list/BaseListModelListener;Lde/audi/tghu/navi/app/addressinput/listbuilders/IEvoListRowBuilder;II)V 
.const [252] = Utf8 onUpdateResultList 
.const [253] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;JLjava/lang/String;ZII)V 
.const [254] = Utf8 onUpdateResultList 
.const [255] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;JLjava/lang/String;Z)V 
.const [256] = Utf8 onElementSelected 
.const [257] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;)V 
.end class 
