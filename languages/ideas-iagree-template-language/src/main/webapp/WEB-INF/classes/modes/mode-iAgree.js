ace.define('ace/mode/iAgree', ['require', 'exports', 'module' , 'ace/tokenizer', 'ace/mode/abap_highlight_rules', 'ace/mode/folding/coffee', 'ace/range', 'ace/mode/text', 'ace/lib/oop'], function(require, exports, module) {

var Tokenizer = require("../tokenizer").Tokenizer;
var Rules = require("./sintaxis_highlight_rules").AbapHighlightRules;
var FoldMode = require("./folding/coffee").FoldMode;
var Range = require("../range").Range;
var TextMode = require("./text").Mode;
var oop = require("../lib/oop");

function Mode() {
    this.HighlightRules = Rules;
    this.foldingRules = new FoldMode();
}

oop.inherits(Mode, TextMode);

(function() {
    
    this.getNextLineIndent = function(state, line, tab) {
        var indent = this.$getIndent(line);
        return indent;
    };
    
    this.toggleCommentLines = function(state, doc, startRow, endRow){
        var range = new Range(0, 0, 0, 0);
        for (var i = startRow; i <= endRow; ++i) {
            var line = doc.getLine(i);
            if (hereComment.test(line))
                continue;
                
            if (commentLine.test(line))
                line = line.replace(commentLine, '$1');
            else
                line = line.replace(indentation, '$&#');
    
            range.end.row = range.start.row = i;
            range.end.column = line.length + 1;
            doc.replace(range, line);
        }
    };
    
    this.$id = "ace/mode/sintaxis";
}).call(Mode.prototype);

exports.Mode = Mode;

});


ace.define('ace/mode/sintaxis_highlight_rules', ['require', 'exports', 'module' , 'ace/lib/oop', 'ace/mode/text_highlight_rules'],function(require, exports, module) {
"use strict";

var oop = require("../lib/oop");
var TextHighlightRules = require("./text_highlight_rules").TextHighlightRules;

var AbapHighlightRules = function() {

    var keywordMapper = this.createKeywordMapper({
        "token_Keyword.keyword": //keyword
            "Template EndTemplate AgreementOffer EndAgreementOffer AgreementTerms CreationConstraints",
        "variable.def": //def
            "Initiator Responder ServiceProvider ExpirationTime MonitorableProperties Service description Global GuaranteeTerms Constraints Service Metrics",
        "variable.def2": //def-2 
            "GMTZone DateFormat GlobalPeriod DefinedPeriod EndDefinedPeriod guarantees GlobalDescription global",
        "entity-name-tag.atom": //atom
            "belongs for of as measuredBy relatedTo availableAt valueOf is IMPLIES EQUAL",
        "entity-name-tag.atom2": //atom-2
            "except from during on AND OR NOT" ,
        "entity-name-tag.condition": //condition
            "all exactly one or more" ,
        "token_Keyword.actor": //actor
            "Provider Consumer" ,
        "entity-name-tag.attribute": //attribute
            "onlyIf upon" , //[\w\$_]:
        "entity-name-tag.type": //type
            "integer string enum set boolean" ,
        "entity-name-tag.true": //true
            "true" ,
        "entity-name-tag.flase": //false
            "false",
            
    }, "text", false, " ");
    
    var keyword = "\\b(Template|EndTemplate|AgreementOffer|EndAgreementOffer|AgreementTerms|CreationConstraints)\\b";
    var def = "\\b(Initiator|Responder|ServiceProvider|ExpirationTime|MonitorableProperties|Service|description|Global|GuaranteeTerms|Constraints|Service|Metrics)\\b";
    var def2 = "\\b(GMTZone|DateFormat|GlobalPeriod|DefinedPeriod|EndDefinedPeriod|guarantees|GlobalDescription|global)\\b";
    var atom = "\\b(belongs|for|of|as|measuredBy|relatedTo|availableAt|valueOf|is|IMPLIES|EQUAL)\\b";
    var atom2 = "(\\b(except|from|during|on|AND|OR|NOT)\\b)";
    var condition = "\\b(all|exactly|one|or|more)\\b";
    var actor = "\\b(Provider|Consumer)\\b";
    var attribute = "\\b(onlyIf|upon|[\w\$_]:)\\b";
    var type = "\\b(integer|string|enum|set|boolean|float)\\b";
    var True = "\\b(true)\\b";
    var False = "\\b(false)\\b";
    var subtle = "\\b((|)|[|])\\b";
    var otherVariables = "(\\b\\d+(\\.\\d+)?\\b)";
    var url = "((http://|https://|ftp://|www.|localhost/|localhost:)([^\\s])+)";
    
     
    this.$rules = {
        "start" : [
            {token : "token_Keyword.keyword", regex : keyword},
            {token : "variable.def", regex : def},
            {token : "variable.def2", regex : def2},
            {token : "entity-name-tag.atom", regex : atom},
            {token : "entity-name-tag.atom2", regex : atom2},
            {token : "string", regex : '"', next  : "pstring"},
			{token : "string", regex : "'", next  : "qstring"},
            {token : "entity-name-tag.condition", regex : condition},
            {token : "token_Keyword.actor", regex : actor},
            {token : "entity-name-tag.attribute", regex : attribute},
            {token : "entity-name-tag.type", regex : type},
            {token : "entity-name-tag.true", regex : True},
            {token : "entity-name-tag.false", regex : False},
//            {token : keywordMapper, regex : "\\b\\w+\\b"},
            {caseInsensitive: false}
        ],
        "pstring" : [
            {token : "constant.language.escape",   regex : '""'},
            {token : "string", regex : '"',     next  : "start"},
            {defaultToken : "string"}
        ],
		"qstring" : [
            {token : "constant.language.escape",   regex : "''"},
            {token : "string", regex : "'",     next  : "start"},
            {defaultToken : "string"}
        ]
    };
};
oop.inherits(AbapHighlightRules, TextHighlightRules);

exports.AbapHighlightRules = AbapHighlightRules;
});


ace.define('ace/mode/folding/coffee', ['require', 'exports', 'module' , 'ace/lib/oop', 'ace/mode/folding/fold_mode', 'ace/range'], function(require, exports, module) {


var oop = require("../../lib/oop");
var BaseFoldMode = require("./fold_mode").FoldMode;
var Range = require("../../range").Range;

var FoldMode = exports.FoldMode = function() {};
oop.inherits(FoldMode, BaseFoldMode);

(function() {

    this.getFoldWidgetRange = function(session, foldStyle, row) {
        var range = this.indentationBlock(session, row);
        if (range)
            return range;

        var re = /\S/;
        var line = session.getLine(row);
        var startLevel = line.search(re);
        if (startLevel == -1 || line[startLevel] != "#")
            return;

        var startColumn = line.length;
        var maxRow = session.getLength();
        var startRow = row;
        var endRow = row;

        while (++row < maxRow) {
            line = session.getLine(row);
            var level = line.search(re);

            if (level == -1)
                continue;

            if (line[level] != "#")
                break;

            endRow = row;
        }

        if (endRow > startRow) {
            var endColumn = session.getLine(endRow).length;
            return new Range(startRow, startColumn, endRow, endColumn);
        }
    };
    this.getFoldWidget = function(session, foldStyle, row) {
        var line = session.getLine(row);
        var indent = line.search(/\S/);
        var next = session.getLine(row + 1);
        var prev = session.getLine(row - 1);
        var prevIndent = prev.search(/\S/);
        var nextIndent = next.search(/\S/);

        if (indent == -1) {
            session.foldWidgets[row - 1] = prevIndent!= -1 && prevIndent < nextIndent ? "start" : "";
            return "";
        }
        if (prevIndent == -1) {
            if (indent == nextIndent && line[indent] == "#" && next[indent] == "#") {
                session.foldWidgets[row - 1] = "";
                session.foldWidgets[row + 1] = "";
                return "start";
            }
        } else if (prevIndent == indent && line[indent] == "#" && prev[indent] == "#") {
            if (session.getLine(row - 2).search(/\S/) == -1) {
                session.foldWidgets[row - 1] = "start";
                session.foldWidgets[row + 1] = "";
                return "";
            }
        }

        if (prevIndent!= -1 && prevIndent < indent)
            session.foldWidgets[row - 1] = "start";
        else
            session.foldWidgets[row - 1] = "";

        if (indent < nextIndent)
            return "start";
        else
            return "";
    };

}).call(FoldMode.prototype);

});