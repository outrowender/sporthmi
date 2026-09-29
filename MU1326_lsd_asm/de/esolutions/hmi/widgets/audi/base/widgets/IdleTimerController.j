.version 50 0 
.class public super [243] 
.super [245] 
.field public static final [246] [247] 
.field public static final [248] [249] 
.field private [250] [251] 
.field private [252] [253] 
.field private [254] [255] 

.method public [257] : [258] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     invokespecial [40] 
L7:     aload_0 
L8:     sipush 10000 
L11:    putfield [44] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [45] 
L19:    aload_0 
L20:    sipush 335 
L23:    putfield [46] 
L26:    aload_0 
L27:    iconst_0 
L28:    putfield [47] 
L31:    return 
L32:    
    .end code 
.end method 

.method protected [259] : [260] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ifnull L14 
L7:     aload_0 
L8:     invokevirtual [24] 
L11:    goto L22 
L14:    aload_0 
L15:    aload_0 
L16:    getfield [20] 
L19:    putfield [48] 
L22:    aload_0 
L23:    invokespecial [41] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [261] : [262] 
    .attribute [256] .code stack 7 locals 2 
L0:     getstatic [3] 
L3:     aload_0 
L4:     getfield [22] 
L7:     invokeinterface [49] 0 
L12:    checkcast [4] 
L15:    astore_1 
L16:    aload_1 
L17:    ifnull L29 
L20:    aload_1 
L21:    invokeinterface [50] 0 
L26:    ifne L162 
L29:    aload_0 
L30:    getfield [23] 
L33:    ifnull L102 
L36:    aload_0 
L37:    getfield [21] 
L40:    ifne L102 
L43:    getstatic [2] 
L46:    ldc [5] 
L48:    ldc [6] 
L50:    aload_0 
L51:    getfield [23] 
L54:    aload_0 
L55:    getfield [26] 
L58:    i2l 
L59:    invokevirtual [27] 
L62:    pop 
L63:    aload_0 
L64:    getfield [23] 
L67:    checkcast [7] 
L70:    astore_2 
L71:    aload_2 
L72:    iconst_0 
L73:    aload_0 
L74:    getfield [28] 
L77:    invokevirtual [29] 
L80:    invokeinterface [51] 0 
L85:    aload_2 
L86:    iconst_0 
L87:    aload_0 
L88:    getfield [28] 
L91:    invokevirtual [29] 
L94:    invokeinterface [52] 0 
L99:    goto L162 
L102:   aload_0 
L103:   getfield [30] 
L106:   ifeq L151 
L109:   getstatic [2] 
L112:   ldc [5] 
L114:   ldc [8] 
L116:   aload_0 
L117:   getfield [28] 
L120:   invokevirtual [29] 
L123:   i2l 
L124:   aload_0 
L125:   getfield [30] 
L128:   i2l 
L129:   invokevirtual [31] 
L132:   pop 
L133:   aload_0 
L134:   aload_0 
L135:   getfield [28] 
L138:   invokevirtual [29] 
L141:   aload_0 
L142:   getfield [30] 
L145:   invokevirtual [32] 
L148:   goto L162 
L151:   getstatic [2] 
L154:   ldc [9] 
L156:   ldc [10] 
L158:   invokevirtual [33] 
L161:   pop 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [34] 
L4:     aload_0 
L5:     getfield [22] 
L8:     if_icmpne L26 
L11:    aload_1 
L12:    invokevirtual [35] 
L15:    iconst_1 
L16:    if_icmpne L34 
L19:    aload_0 
L20:    invokespecial [42] 
L23:    goto L34 
L26:    aload_0 
L27:    invokevirtual [24] 
L30:    aload_0 
L31:    invokespecial [43] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [265] : [266] 
    .attribute [256] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     instanceof [11] 
L7:     ifeq L41 
L10:    aload_0 
L11:    getfield [23] 
L14:    checkcast [11] 
L17:    invokevirtual [36] 
L20:    istore_1 
L21:    iload_1 
L22:    ifne L32 
L25:    aload_0 
L26:    invokevirtual [37] 
L29:    goto L41 
L32:    aload_0 
L33:    iconst_1 
L34:    invokevirtual [38] 
L37:    aload_0 
L38:    invokevirtual [39] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [267] : [268] 
    .attribute [256] .code stack 3 locals 1 
L0:     getstatic [3] 
L3:     aload_0 
L4:     getfield [22] 
L7:     invokeinterface [49] 0 
L12:    checkcast [4] 
L15:    astore_1 
L16:    aload_1 
L17:    ifnull L52 
L20:    aload_1 
L21:    invokeinterface [50] 0 
L26:    ifne L52 
L29:    getstatic [2] 
L32:    ldc [5] 
L34:    ldc [12] 
L36:    invokevirtual [33] 
L39:    pop 
L40:    aload_0 
L41:    iconst_1 
L42:    invokevirtual [38] 
L45:    aload_0 
L46:    invokevirtual [39] 
L49:    goto L56 
L52:    aload_0 
L53:    invokevirtual [37] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [256] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     instanceof [4] 
L7:     ifeq L74 
L10:    iconst_0 
L11:    istore_1 
L12:    aload_0 
L13:    getfield [23] 
L16:    checkcast [4] 
L19:    invokeinterface [50] 0 
L24:    istore_1 
L25:    iload_1 
L26:    ifne L40 
L29:    aload_0 
L30:    aload_0 
L31:    getfield [20] 
L34:    putfield [48] 
L37:    goto L45 
L40:    aload_0 
L41:    iload_1 
L42:    putfield [48] 
L45:    aload_0 
L46:    getfield [25] 
L49:    ifge L56 
L52:    aload_0 
L53:    invokevirtual [37] 
L56:    getstatic [2] 
L59:    ldc [5] 
L61:    ldc [13] 
L63:    iload_1 
L64:    i2l 
L65:    aload_0 
L66:    getfield [25] 
L69:    i2l 
L70:    invokevirtual [31] 
L73:    pop 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [45] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [275] : [276] 
    .attribute [256] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [46] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [53] [54] 
.const [3] = Field [55] [56] 
.const [4] = Class [57] 
.const [5] = Int -2137614336 
.const [6] = String [58] 
.const [7] = Class [59] 
.const [8] = String [60] 
.const [9] = Int 1078071040 
.const [10] = String [61] 
.const [11] = Class [62] 
.const [12] = String [63] 
.const [13] = String [64] 
.const [14] = Class [65] 
.const [15] = Class [66] 
.const [16] = Class [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Field [71] [72] 
.const [21] = Field [73] [74] 
.const [22] = Field [75] [76] 
.const [23] = Field [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Field [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Field [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Field [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Method [117] [118] 
.const [44] = Field [119] [120] 
.const [45] = Field [121] [122] 
.const [46] = Field [123] [124] 
.const [47] = Field [125] [126] 
.const [48] = Field [127] [128] 
.const [49] = InterfaceMethod [129] [130] 
.const [50] = InterfaceMethod [131] [132] 
.const [51] = InterfaceMethod [133] [134] 
.const [52] = InterfaceMethod [135] [136] 
.const [53] = Class [137] 
.const [54] = NameAndType [138] [139] 
.const [55] = Class [140] 
.const [56] = NameAndType [141] [142] 
.const [57] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [58] = Utf8 'IdleTimerController#fireTimer calling keyPressed/keyTyped at model modelID: %2, model: %1' 
.const [59] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelGUI 
.const [60] = Utf8 'IdleTimerController#fireTimer calling fireSMEvent on terminalID: %1, event: %2' 
.const [61] = Utf8 'IdleTimerController#fireTimer timer expired, but no model or event configured' 
.const [62] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [63] = Utf8 'IdleTimerController#handleSDSmodelUpdate SDS dialog finished - restarting idleTimer' 
.const [64] = Utf8 'IdleTimerController#updateValue read idleTime from model - modelIdleTimeout: %1, current real idle timeout: %2' 
.const [65] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractIdleTimerController 
.const [67] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/InitializationContext 
.const [70] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [71] = Class [143] 
.const [72] = NameAndType [144] [145] 
.const [73] = Class [146] 
.const [74] = NameAndType [147] [148] 
.const [75] = Class [149] 
.const [76] = NameAndType [150] [151] 
.const [77] = Class [152] 
.const [78] = NameAndType [153] [154] 
.const [79] = Class [155] 
.const [80] = NameAndType [156] [157] 
.const [81] = Class [158] 
.const [82] = NameAndType [159] [160] 
.const [83] = Class [161] 
.const [84] = NameAndType [162] [163] 
.const [85] = Class [164] 
.const [86] = NameAndType [165] [166] 
.const [87] = Class [167] 
.const [88] = NameAndType [168] [169] 
.const [89] = Class [170] 
.const [90] = NameAndType [171] [172] 
.const [91] = Class [173] 
.const [92] = NameAndType [174] [175] 
.const [93] = Class [176] 
.const [94] = NameAndType [177] [178] 
.const [95] = Class [179] 
.const [96] = NameAndType [180] [181] 
.const [97] = Class [182] 
.const [98] = NameAndType [183] [184] 
.const [99] = Class [185] 
.const [100] = NameAndType [186] [187] 
.const [101] = Class [188] 
.const [102] = NameAndType [189] [190] 
.const [103] = Class [191] 
.const [104] = NameAndType [192] [193] 
.const [105] = Class [194] 
.const [106] = NameAndType [195] [196] 
.const [107] = Class [197] 
.const [108] = NameAndType [198] [199] 
.const [109] = Class [200] 
.const [110] = NameAndType [201] [202] 
.const [111] = Class [203] 
.const [112] = NameAndType [204] [205] 
.const [113] = Class [206] 
.const [114] = NameAndType [207] [208] 
.const [115] = Class [209] 
.const [116] = NameAndType [210] [211] 
.const [117] = Class [212] 
.const [118] = NameAndType [213] [214] 
.const [119] = Class [215] 
.const [120] = NameAndType [216] [217] 
.const [121] = Class [218] 
.const [122] = NameAndType [219] [220] 
.const [123] = Class [221] 
.const [124] = NameAndType [222] [223] 
.const [125] = Class [224] 
.const [126] = NameAndType [225] [226] 
.const [127] = Class [227] 
.const [128] = NameAndType [228] [229] 
.const [129] = Class [230] 
.const [130] = NameAndType [231] [232] 
.const [131] = Class [233] 
.const [132] = NameAndType [234] [235] 
.const [133] = Class [236] 
.const [134] = NameAndType [237] [238] 
.const [135] = Class [239] 
.const [136] = NameAndType [240] [241] 
.const [137] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [138] = Utf8 screenLogChannel 
.const [139] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [140] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [141] = Utf8 hmiService 
.const [142] = Utf8 Lde/audi/tghu/hmi/evo/IHMIServiceEvo; 
.const [143] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [144] = Utf8 defaultIdleTime 
.const [145] = Utf8 I 
.const [146] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [147] = Utf8 triggerType 
.const [148] = Utf8 I 
.const [149] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [150] = Utf8 sdsStatusModelId 
.const [151] = Utf8 I 
.const [152] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [153] = Utf8 model 
.const [154] = Utf8 Ljava/lang/Object; 
.const [155] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [156] = Utf8 updateValue 
.const [157] = Utf8 ()V 
.const [158] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [159] = Utf8 idleTime 
.const [160] = Utf8 I 
.const [161] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [162] = Utf8 modelID 
.const [163] = Utf8 I 
.const [164] = Utf8 de/audi/atip/log/LogChannel 
.const [165] = Utf8 log 
.const [166] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [168] = Utf8 initContext 
.const [169] = Utf8 Lde/esolutions/hmi/widgets/audi/base/InitializationContext; 
.const [170] = Utf8 de/esolutions/hmi/widgets/audi/base/InitializationContext 
.const [171] = Utf8 getTerminalID 
.const [172] = Utf8 ()I 
.const [173] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [174] = Utf8 event 
.const [175] = Utf8 I 
.const [176] = Utf8 de/audi/atip/log/LogChannel 
.const [177] = Utf8 log 
.const [178] = Utf8 (ILjava/lang/String;JJ)Z 
.const [179] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [180] = Utf8 fireSMEvent 
.const [181] = Utf8 (II)V 
.const [182] = Utf8 de/audi/atip/log/LogChannel 
.const [183] = Utf8 log 
.const [184] = Utf8 (ILjava/lang/String;)Z 
.const [185] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [186] = Utf8 getModelId 
.const [187] = Utf8 ()I 
.const [188] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [189] = Utf8 getUpdateType 
.const [190] = Utf8 ()I 
.const [191] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [192] = Utf8 getStatus 
.const [193] = Utf8 ()I 
.const [194] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [195] = Utf8 cancelTimer 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [198] = Utf8 setActive 
.const [199] = Utf8 (Z)V 
.const [200] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [201] = Utf8 restartTimer 
.const [202] = Utf8 ()V 
.const [203] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractIdleTimerController 
.const [204] = Utf8 <init> 
.const [205] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractIdleTimerController 
.const [207] = Utf8 initializeWidget 
.const [208] = Utf8 ()V 
.const [209] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [210] = Utf8 handleSDSmodelUpdate 
.const [211] = Utf8 ()V 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [213] = Utf8 handleModelUpdate 
.const [214] = Utf8 ()V 
.const [215] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [216] = Utf8 defaultIdleTime 
.const [217] = Utf8 I 
.const [218] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [219] = Utf8 triggerType 
.const [220] = Utf8 I 
.const [221] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [222] = Utf8 sdsStatusModelId 
.const [223] = Utf8 I 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [225] = Utf8 startTimerAutomatically 
.const [226] = Utf8 Z 
.const [227] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [228] = Utf8 idleTime 
.const [229] = Utf8 I 
.const [230] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [231] = Utf8 getModel 
.const [232] = Utf8 (I)Lde/audi/atip/hmi/model/HMIModel; 
.const [233] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [234] = Utf8 getValue 
.const [235] = Utf8 ()I 
.const [236] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelGUI 
.const [237] = Utf8 keyPressed 
.const [238] = Utf8 (II)V 
.const [239] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelGUI 
.const [240] = Utf8 keyTyped 
.const [241] = Utf8 (II)V 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/IdleTimerController 
.const [243] = Class [242] 
.const [244] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractIdleTimerController 
.const [245] = Class [244] 
.const [246] = Utf8 TYPE_NOTIFY_APP 
.const [247] = Utf8 I 
.const [248] = Utf8 TYPE_FIRE_EVENT 
.const [249] = Utf8 I 
.const [250] = Utf8 defaultIdleTime 
.const [251] = Utf8 I 
.const [252] = Utf8 triggerType 
.const [253] = Utf8 I 
.const [254] = Utf8 sdsStatusModelId 
.const [255] = Utf8 I 
.const [256] = Utf8 Code 
.const [257] = Utf8 <init> 
.const [258] = Utf8 ()V 
.const [259] = Utf8 initializeWidget 
.const [260] = Utf8 ()V 
.const [261] = Utf8 timerFired 
.const [262] = Utf8 ()V 
.const [263] = Utf8 processModelUpdateEvent 
.const [264] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [265] = Utf8 handleModelUpdate 
.const [266] = Utf8 ()V 
.const [267] = Utf8 handleSDSmodelUpdate 
.const [268] = Utf8 ()V 
.const [269] = Utf8 setIdleTimeout 
.const [270] = Utf8 (I)V 
.const [271] = Utf8 updateValue 
.const [272] = Utf8 ()V 
.const [273] = Utf8 setTriggerType 
.const [274] = Utf8 (I)V 
.const [275] = Utf8 getTriggerType 
.const [276] = Utf8 ()I 
.const [277] = Utf8 setSdsStatusModelId 
.const [278] = Utf8 (I)V 
.end class 
