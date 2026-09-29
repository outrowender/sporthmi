.version 50 0 
.class public super [209] 
.super [211] 
.field public static final [212] [213] 
.field private [214] [215] 
.field private [216] [217] 

.method public [219] : [220] 
    .attribute [218] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [38] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [39] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [218] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [38] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [39] 
L14:    aload_0 
L15:    iload_1 
L16:    putfield [39] 
L19:    aload_0 
L20:    iload_2 
L21:    putfield [38] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [218] .code stack 9 locals 7 
L0:     aload_2 
L1:     invokevirtual [22] 
L4:     istore_3 
L5:     aload_2 
L6:     invokevirtual [23] 
L9:     istore 4 
L11:    aload_0 
L12:    aload_1 
L13:    invokevirtual [24] 
L16:    astore 5 
L18:    aload 5 
L20:    ifnonnull L24 
L23:    return 
L24:    getstatic [2] 
L27:    ldc [3] 
L29:    ldc [4] 
L31:    aload 5 
L33:    invokeinterface [40] 0 
L38:    i2l 
L39:    iload 4 
L41:    i2l 
L42:    iload_3 
L43:    i2l 
L44:    invokevirtual [25] 
L47:    pop 
L48:    iload 4 
L50:    aload 5 
L52:    invokeinterface [41] 0 
L57:    imul 
L58:    istore 4 
L60:    aload 5 
L62:    invokeinterface [42] 0 
L67:    istore 6 
L69:    iload_3 
L70:    ifne L77 
L73:    iconst_1 
L74:    goto L78 
L77:    iconst_0 
L78:    istore 7 
L80:    aload_0 
L81:    getfield [20] 
L84:    ifeq L167 
L87:    iload 7 
L89:    ifeq L102 
L92:    aload 5 
L94:    invokeinterface [43] 0 
L99:    goto L109 
L102:   aload 5 
L104:   invokeinterface [44] 0 
L109:   istore 8 
L111:   iload 7 
L113:   ifeq L124 
L116:   iload 8 
L118:   iload 6 
L120:   isub 
L121:   goto L129 
L124:   iload 6 
L126:   iload 8 
L128:   isub 
L129:   istore 9 
L131:   iconst_0 
L132:   iload 9 
L134:   invokestatic [5] 
L137:   istore 9 
L139:   iload 9 
L141:   iload 4 
L143:   if_icmpge L167 
L146:   getstatic [2] 
L149:   ldc [6] 
L151:   ldc [7] 
L153:   iload 8 
L155:   i2l 
L156:   iload 9 
L158:   i2l 
L159:   invokevirtual [26] 
L162:   pop 
L163:   iload 9 
L165:   istore 4 
L167:   iload 4 
L169:   ifne L178 
L172:   aload_2 
L173:   iconst_0 
L174:   invokevirtual [27] 
L177:   return 
L178:   aload_1 
L179:   invokevirtual [28] 
L182:   invokevirtual [29] 
L185:   istore 8 
L187:   iload 7 
L189:   ifeq L228 
L192:   getstatic [2] 
L195:   ldc [6] 
L197:   ldc [8] 
L199:   aload 5 
L201:   invokeinterface [40] 0 
L206:   i2l 
L207:   iload 4 
L209:   i2l 
L210:   invokevirtual [26] 
L213:   pop 
L214:   aload 5 
L216:   iload 4 
L218:   iload 8 
L220:   invokeinterface [45] 0 
L225:   goto L261 
L228:   getstatic [2] 
L231:   ldc [6] 
L233:   ldc [9] 
L235:   aload 5 
L237:   invokeinterface [40] 0 
L242:   i2l 
L243:   iload 4 
L245:   i2l 
L246:   invokevirtual [26] 
L249:   pop 
L250:   aload 5 
L252:   iload 4 
L254:   iload 8 
L256:   invokeinterface [46] 0 
L261:   aload_2 
L262:   iconst_0 
L263:   invokevirtual [27] 
L266:   return 
L267:   nop 
L268:   
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [218] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifeq L13 
L7:     aload_0 
L8:     aload_1 
L9:     aload_2 
L10:    invokespecial [34] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [218] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifeq L13 
L7:     aload_0 
L8:     aload_1 
L9:     aload_2 
L10:    invokespecial [35] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [229] : [230] 
    .attribute [218] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [30] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L24 
L9:     getstatic [2] 
L12:    sipush 10000 
L15:    ldc [10] 
L17:    aload_1 
L18:    invokevirtual [31] 
L21:    pop 
L22:    aconst_null 
L23:    areturn 
L24:    aload_2 
L25:    instanceof [11] 
L28:    ifeq L36 
L31:    aload_2 
L32:    checkcast [11] 
L35:    areturn 
L36:    getstatic [2] 
L39:    sipush 10000 
L42:    ldc [12] 
L44:    aload_2 
L45:    aload_1 
L46:    invokevirtual [32] 
L49:    aconst_null 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public interface [231] : [232] 
    .attribute [218] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [233] : [234] 
    .attribute [218] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [235] : [236] 
    .attribute [218] .code stack 2 locals 0 
L0:     new [47] 
L3:     dup 
L4:     invokespecial [36] 
L7:     putstatic [37] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [48] [49] 
.const [3] = Int 1078071040 
.const [4] = String [50] 
.const [5] = Method [51] [52] 
.const [6] = Int -2137614336 
.const [7] = String [53] 
.const [8] = String [54] 
.const [9] = String [55] 
.const [10] = String [56] 
.const [11] = Class [57] 
.const [12] = String [58] 
.const [13] = Class [59] 
.const [14] = Class [60] 
.const [15] = Class [61] 
.const [16] = Class [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Class [65] 
.const [20] = Field [66] [67] 
.const [21] = Field [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Field [100] [101] 
.const [38] = Field [102] [103] 
.const [39] = Field [104] [105] 
.const [40] = InterfaceMethod [106] [107] 
.const [41] = InterfaceMethod [108] [109] 
.const [42] = InterfaceMethod [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = Class [120] 
.const [48] = Class [121] 
.const [49] = NameAndType [122] [123] 
.const [50] = Utf8 'RangeModelKeyHandler#keyTurned: modelID: %1, clickCount: %2, direction: %3' 
.const [51] = Class [124] 
.const [52] = NameAndType [125] [126] 
.const [53] = Utf8 'RangeModelKeyHandler#keyTurned range limit %1 reached. Reduce clickCount to: %2' 
.const [54] = Utf8 'RangeModelKeyHandler#keyTurned calling increment at rangeModel with id: %1 clickCount: %2' 
.const [55] = Utf8 'RangeModelKeyHandler#keyTurned calling decrement at rangeModel with id: %1 clickCount: %2' 
.const [56] = Utf8 'RangeModelKeyHandler#getModel: model is null. widget: %1' 
.const [57] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [58] = Utf8 'RangeModelKeyHandler#getModel: model is not a range model. model: %1, widget: %2' 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [60] = Utf8 de/esolutions/hmi/widgets/audi/evo/ButtonModelKeyHandler 
.const [61] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 java/lang/Math 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [65] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Class [172] 
.const [97] = NameAndType [173] [174] 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Class [196] 
.const [113] = NameAndType [197] [198] 
.const [114] = Class [199] 
.const [115] = NameAndType [200] [201] 
.const [116] = Class [202] 
.const [117] = NameAndType [203] [204] 
.const [118] = Class [205] 
.const [119] = NameAndType [206] [207] 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [122] = Utf8 menuItemLogCh 
.const [123] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [124] = Utf8 java/lang/Math 
.const [125] = Utf8 max 
.const [126] = Utf8 (II)I 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [128] = Utf8 checkRangeLimits 
.const [129] = Utf8 Z 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [131] = Utf8 handlePressReleaseEvents 
.const [132] = Utf8 Z 
.const [133] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [134] = Utf8 getDirection 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [137] = Utf8 getClickCount 
.const [138] = Utf8 ()I 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [140] = Utf8 getRangeModel 
.const [141] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)Lde/audi/atip/hmi/modelaccess/RangeModelGUI; 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [145] = Utf8 de/audi/atip/log/LogChannel 
.const [146] = Utf8 log 
.const [147] = Utf8 (ILjava/lang/String;JJ)Z 
.const [148] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [149] = Utf8 consume 
.const [150] = Utf8 (Z)V 
.const [151] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [152] = Utf8 getTerminalImpl 
.const [153] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl; 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [155] = Utf8 getTerminalID 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [158] = Utf8 getModel 
.const [159] = Utf8 ()Ljava/lang/Object; 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [163] = Utf8 de/audi/atip/log/LogChannel 
.const [164] = Utf8 log 
.const [165] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [166] = Utf8 de/esolutions/hmi/widgets/audi/evo/ButtonModelKeyHandler 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/evo/ButtonModelKeyHandler 
.const [170] = Utf8 keyPressed 
.const [171] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/ButtonModelKeyHandler 
.const [173] = Utf8 keyReleased 
.const [174] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [179] = Utf8 RANGE_MODEL_KEY_HANDLER_INSTANCE 
.const [180] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler; 
.const [181] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [182] = Utf8 checkRangeLimits 
.const [183] = Utf8 Z 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [185] = Utf8 handlePressReleaseEvents 
.const [186] = Utf8 Z 
.const [187] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [188] = Utf8 getID 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [191] = Utf8 getStep 
.const [192] = Utf8 ()I 
.const [193] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [194] = Utf8 getValue 
.const [195] = Utf8 ()I 
.const [196] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [197] = Utf8 getMaximum 
.const [198] = Utf8 ()I 
.const [199] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [200] = Utf8 getMinimum 
.const [201] = Utf8 ()I 
.const [202] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [203] = Utf8 increment 
.const [204] = Utf8 (II)V 
.const [205] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [206] = Utf8 decrement 
.const [207] = Utf8 (II)V 
.const [208] = Utf8 de/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler 
.const [209] = Class [208] 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/evo/ButtonModelKeyHandler 
.const [211] = Class [210] 
.const [212] = Utf8 RANGE_MODEL_KEY_HANDLER_INSTANCE 
.const [213] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/RangeModelKeyHandler; 
.const [214] = Utf8 checkRangeLimits 
.const [215] = Utf8 Z 
.const [216] = Utf8 handlePressReleaseEvents 
.const [217] = Utf8 Z 
.const [218] = Utf8 Code 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (ZZ)V 
.const [223] = Utf8 keyTurned 
.const [224] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/audi/atip/hmi/event/WheelButtonEvent;)V 
.const [225] = Utf8 keyPressed 
.const [226] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [227] = Utf8 keyReleased 
.const [228] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [229] = Utf8 getRangeModel 
.const [230] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)Lde/audi/atip/hmi/modelaccess/RangeModelGUI; 
.const [231] = Utf8 isCheckRangeLimits 
.const [232] = Utf8 ()Z 
.const [233] = Utf8 isHandlePressReleaseEvents 
.const [234] = Utf8 ()Z 
.const [235] = Utf8 <clinit> 
.const [236] = Utf8 ()V 
.end class 
