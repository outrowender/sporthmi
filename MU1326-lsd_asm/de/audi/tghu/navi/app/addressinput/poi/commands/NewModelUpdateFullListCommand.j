.version 50 0 
.class public super [189] 
.super [191] 
.field private final [192] [193] 
.field private final [194] [195] 
.field private final [196] [197] 
.field private static final [198] [199] 

.method public [201] : [202] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [38] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [39] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [200] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iconst_0 
L4:     invokespecial [34] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [200] .code stack 7 locals 3 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [20] 
L12:    i2l 
L13:    invokevirtual [22] 
L16:    pop 
L17:    iconst_0 
L18:    istore_1 
L19:    aload_0 
L20:    getfield [23] 
L23:    invokevirtual [24] 
L26:    astore_2 
L27:    aload_2 
L28:    ifnull L62 
L31:    aload_2 
L32:    invokevirtual [25] 
L35:    ifnull L62 
L38:    aload_2 
L39:    invokevirtual [25] 
L42:    arraylength 
L43:    istore_1 
L44:    iload_1 
L45:    ifle L62 
L48:    aload_2 
L49:    invokevirtual [25] 
L52:    iload_1 
L53:    iconst_1 
L54:    isub 
L55:    aaload 
L56:    invokevirtual [26] 
L59:    iconst_1 
L60:    iadd 
L61:    istore_1 
L62:    aload_0 
L63:    getfield [21] 
L66:    ldc [4] 
L68:    ldc [5] 
L70:    aload_0 
L71:    getfield [27] 
L74:    iload_1 
L75:    i2l 
L76:    invokevirtual [28] 
L79:    pop 
L80:    iload_1 
L81:    i2l 
L82:    aload_0 
L83:    getfield [23] 
L86:    invokevirtual [29] 
L89:    lcmp 
L90:    ifge L108 
L93:    aload_0 
L94:    getfield [20] 
L97:    ifle L152 
L100:   iload_1 
L101:   aload_0 
L102:   getfield [20] 
L105:   if_icmplt L152 
L108:   aload_0 
L109:   getfield [21] 
L112:   ldc [2] 
L114:   ldc [6] 
L116:   iload_1 
L117:   i2l 
L118:   aload_0 
L119:   getfield [23] 
L122:   invokevirtual [29] 
L125:   invokevirtual [30] 
L128:   pop 
L129:   aload_0 
L130:   invokevirtual [31] 
L133:   new [40] 
L136:   dup 
L137:   aload_0 
L138:   getfield [18] 
L141:   invokespecial [35] 
L144:   invokeinterface [41] 0 
L149:   goto L226 
L152:   aload_0 
L153:   getfield [19] 
L156:   invokeinterface [42] 0 
L161:   astore_3 
L162:   aload_3 
L163:   new [40] 
L166:   dup 
L167:   aload_0 
L168:   getfield [18] 
L171:   invokespecial [35] 
L174:   invokevirtual [32] 
L177:   pop 
L178:   aload_3 
L179:   new [43] 
L182:   dup 
L183:   iload_1 
L184:   iconst_1 
L185:   invokespecial [36] 
L188:   invokevirtual [32] 
L191:   pop 
L192:   aload_3 
L193:   new [44] 
L196:   dup 
L197:   aload_0 
L198:   getfield [18] 
L201:   aload_0 
L202:   getfield [19] 
L205:   aload_0 
L206:   getfield [20] 
L209:   invokespecial [34] 
L212:   invokevirtual [32] 
L215:   pop 
L216:   aload_0 
L217:   invokevirtual [31] 
L220:   aload_3 
L221:   invokeinterface [45] 0 
L226:   return 
L227:   nop 
L228:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [46] 
.const [4] = Int -2137614336 
.const [5] = String [47] 
.const [6] = String [48] 
.const [7] = Class [49] 
.const [8] = Class [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Field [60] [61] 
.const [19] = Field [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Field [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Field [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Field [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Field [98] [99] 
.const [38] = Field [100] [101] 
.const [39] = Field [102] [103] 
.const [40] = Class [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = Class [109] 
.const [44] = Class [110] 
.const [45] = InterfaceMethod [111] [112] 
.const [46] = Utf8 'NewModelUpdateFullListCommand#execute - maxResults: %1' 
.const [47] = Utf8 '%1#execute - valueListSize=%2' 
.const [48] = Utf8 'NewModelUpdateFullListCommand#execute - valueListSize: %1, rcCount: %2' 
.const [49] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateResultListCommand 
.const [50] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [51] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [52] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [55] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [56] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [57] = Utf8 de/audi/tghu/command/ICommandList 
.const [58] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [59] = Utf8 de/audi/tghu/command/CommandList 
.const [60] = Class [113] 
.const [61] = NameAndType [114] [115] 
.const [62] = Class [116] 
.const [63] = NameAndType [117] [118] 
.const [64] = Class [119] 
.const [65] = NameAndType [120] [121] 
.const [66] = Class [122] 
.const [67] = NameAndType [123] [124] 
.const [68] = Class [125] 
.const [69] = NameAndType [126] [127] 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Class [146] 
.const [83] = NameAndType [147] [148] 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Class [152] 
.const [87] = NameAndType [153] [154] 
.const [88] = Class [155] 
.const [89] = NameAndType [156] [157] 
.const [90] = Class [158] 
.const [91] = NameAndType [159] [160] 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateResultListCommand 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Class [182] 
.const [108] = NameAndType [183] [184] 
.const [109] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [110] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [111] = Class [185] 
.const [112] = NameAndType [186] [187] 
.const [113] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [114] = Utf8 modelAccess 
.const [115] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList; 
.const [116] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [117] = Utf8 commandListFactory 
.const [118] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [119] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [120] = Utf8 maximumResults 
.const [121] = Utf8 I 
.const [122] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [123] = Utf8 logger 
.const [124] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 de/audi/atip/log/LogChannel 
.const [126] = Utf8 log 
.const [127] = Utf8 (ILjava/lang/String;J)Z 
.const [128] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [129] = Utf8 dsiResponseContainer 
.const [130] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [131] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [132] = Utf8 getLispValueList 
.const [133] = Utf8 ()Lorg/dsi/ifc/navigation/LIValueList; 
.const [134] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [135] = Utf8 getList 
.const [136] = Utf8 ()[Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [137] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [138] = Utf8 getListIndex 
.const [139] = Utf8 ()I 
.const [140] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [141] = Utf8 CLASS_NAME 
.const [142] = Utf8 Ljava/lang/String; 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [146] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [147] = Utf8 getLispValueListCount 
.const [148] = Utf8 ()J 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;JJ)Z 
.const [152] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [153] = Utf8 getCommandList 
.const [154] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [155] = Utf8 de/audi/tghu/command/CommandList 
.const [156] = Utf8 add 
.const [157] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [158] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList;Lde/audi/tghu/command/ICommandListFactory;I)V 
.const [164] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateResultListCommand 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList;)V 
.const [167] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (IZ)V 
.const [170] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [171] = Utf8 modelAccess 
.const [172] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList; 
.const [173] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [174] = Utf8 commandListFactory 
.const [175] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [176] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [177] = Utf8 maximumResults 
.const [178] = Utf8 I 
.const [179] = Utf8 de/audi/tghu/command/ICommandList 
.const [180] = Utf8 commandFinishedWithPostCommand 
.const [181] = Utf8 (Lde/audi/tghu/command/Command;)V 
.const [182] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [183] = Utf8 createCommandList 
.const [184] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [185] = Utf8 de/audi/tghu/command/ICommandList 
.const [186] = Utf8 commandFinishedWithPostSequence 
.const [187] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [188] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/NewModelUpdateFullListCommand 
.const [189] = Class [188] 
.const [190] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [191] = Class [190] 
.const [192] = Utf8 modelAccess 
.const [193] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList; 
.const [194] = Utf8 commandListFactory 
.const [195] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [196] = Utf8 maximumResults 
.const [197] = Utf8 I 
.const [198] = Utf8 NO_MAX 
.const [199] = Utf8 I 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList;Lde/audi/tghu/command/ICommandListFactory;I)V 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/models/IPoiScreenUpdateResultList;Lde/audi/tghu/command/ICommandListFactory;)V 
.const [205] = Utf8 execute 
.const [206] = Utf8 ()V 
.end class 
