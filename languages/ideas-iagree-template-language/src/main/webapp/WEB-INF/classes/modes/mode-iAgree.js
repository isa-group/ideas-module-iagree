/*
 * based on
 * " Vim SEDL Sintaxis file
 * "    Language: SEDL - Sintaxis
 * "    Revision: 2.1
 * "  Maintainer: GHR
 * " Last Change: 2012 Oct 23
 */

ace.define('ace/mode/SEDL4People', ['require', 'exports', 'module' , 'ace/tokenizer', 'ace/mode/abap_highlight_rules', 'ace/mode/folding/coffee', 'ace/range', 'ace/mode/text', 'ace/lib/oop'], function(require, exports, module) {

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
        "variable.language": "this",
        "token_Keyword.blockHeader": 
            "EXPERIMENT Constants Variables Hypothesis Desing Configuration",
        "entity-name-tag.EXPERIMENT.1": 
            "Object Population Accessible_Population Subjects Notes Annotations Responsible Colaborator",
        "entity-name-tag.Constants.1": 
            "Solver Termination_criterion RandomNumberGenerator NFeatures CTC CrossoverProb MutationProb PopulationSize Executions",
        "variable.Variables.1":
            "Factors NCFactors Outcomes Outcome Nuisancess",
        "entity-name-tag.Hypothesis.values":
            "Differential Descriptive Associational" ,
        "variable.Hypothesis.values":
            "Random RandomBlockAdhoc RandomBlock" ,
        "entity-name-tag.Design.1":
            "Sampling Groups Protocol Analyses Alignment Analyses_Spec Detailed_Design Assignment Bloking sizing Grouping" ,
        "entity-name-tag.Configuration.1":
            "Outputs Inputs Setting Experimental_Setting Experimental_Procedure Procedure Runtimes Libraries Command Treatment role format mapping" ,
        "variable.functions.1":
            "linear cuadratic Random Adhoc Pvalue Sthreshold freedom_degrees Mean Avg StdDev Range CI IQR Ranking Pearson ANOVA Friedman Tukey KruskalWalls TTest Wilcoxon Holms FactANOVAwRS Chi Square " +
            "SignTest Kolmogorov-Smirnov Lilliefors Shapiro-Wilk Levene T-student McNemar Aligned Friedman Iman & Davenport Quade Cochran Q Bonferroni-Dunn Hochberg Hommel Holland Rom Finner Li Shaffer Nemenyi" ,
        "entity-name-tag.types.1":
            "float integer enum ordered boolean" ,
        "entity-name-tag.inlineOperator.1":
            "version rep sizingrole format mapping as in size",
        "variable.Variables.inlineOperator.2":
            "(File)",
        "numeric.sets":
        	"N Z Q R I C",
        "correlation.Types":
        	"BivariateRegression Spearman Kendall CRAMER LogLinear"
            
    }, "text", true, " ");
    
    var headers = "\\b(EXPERIMENT|Constants|Variables|Hypothesis|Design|Configuration)\\b";
    var experiments = "\\b(Object|Population|Accessible_Population|Subjects|Responsible|Colaborator)\\b";
    var constants = "\\b(Solver|Termination_criterion|RandomNumberGenerator|NFeatures|CTC|CrossoverProb|MutationProb|PopulationSize|Executions)\\b";
    var variables = "\\b(Factors|NCFactors|Outcomes|Outcome|Nuisances)\\b";
    var hypothesis = "(\\b(Differential|Descriptive|Associational)\\b)|(\\b(Random|RandomBlockAdhoc|RandomBlock)\\b)";
    var desing = "\\b(Sampling|Groups|Protocol|Analyses|Alignment|Analyses_Spec|Detailed_Design|Assignment|Bloking|sizing|Grouping)\\b";
    var configuration = "\\b(Outputs|Inputs|Setting|Experimental_Setting|Experimental_Procedure|Procedure|Runtimes|Libraries|Command|Treatment|role|format|mapping)\\b";
    var global =  "(\\b(float|integer|enum|ordered|boolean)\\b)|(\\b(version|rep|sizingrole|format|mapping|as|in|size)\\b)" +
                    "(\\b(File)\\b)";
    var otherVariables = "(\\b\\d+(\\.\\d+)?\\b)";
    var url = "((http://|https://|ftp://|www.|localhost/|localhost:)([^\\s])+)";
    var comments = "(//.+)";
    var functions = "(\\b(linear|cuadratic|Random|Adhoc|Pvalue|Sthreshold|freedom_degrees|Mean|Avg|StdDev|Range|CI|IQR|Ranking|Pearson|ANOVA|Friedman|Tukey|KruskalWalls|TTest|Wilcoxon|Holms|FactANOVAwRS|File|Chi Square|" +
    		"SignTest|Kolmogorov-Smirnov|Lilliefors|Shapiro-Wilk|Levene|T-student|McNemar|Aligned Friedman|Iman & Davenport|Quade|Cochran Q|Bonferroni-Dunn|Hochberg|Hommel|Holland|Rom|Finner|Li|Shaffer|Nemenyi)\\b)";
    var numerics = "(\\b(N|Z|Q|R|I|C)\\b)";
    var correlation = "(\\b(BivariateRegression|Spearman|Kendall|CRAMER|LogLinear)\\b)";
     
    this.$rules = {
        "start" : [
            {token : "token_Keyword.blockHeader", regex : headers},
            {token : "entity-name-tag.inlineOperator.1", regex : global},
            {token : "variables", regex : otherVariables},
            {token : "url", regex : url},
            {token : "entity-name-tag.EXPERIMENT.1", regex : experiments},
            {token : "string", regex : "'", next  : "qstring"},
            {token : "entity-name-tag.Constants.1", regex : constants},
            {token : "variable.Variables.1", regex : variables},
            {token : "entity-name-tag.Hypothesis.values", regex : hypothesis},
            {token : "variable.Hypothesis.values", regex : hypothesis},
            {token : "entity-name-tag.Design.1", regex : desing},
            {token : "entity-name-tag.Configuration.1", regex : configuration},
            {token : "variable.functions.1", regex : global},
            {token : "entity-name-tag.types.1", regex : global},
            {token : "variable.Variables.inlineOperator.2", regex : global},
            {token : "comments", regex : comments},
            {token : "variable.functions.1", regex : functions},
            {token : "numeric.sets", regex : numerics},
            {token : "correlation.Types", regex : correlation},
            {token : keywordMapper, regex : "\\b\\w+\\b"},
            {token : "comment", regex : "\\/\\/.*$" },
            {token : "comment",  regex : "\\/\\*", next : "comment" },//multiline comment
            {caseInsensitive: true}
        ],
        "qstring" : [
            {token : "constant.language.escape",   regex : "''"},
            {token : "string", regex : "'",     next  : "start"},
            {defaultToken : "string"}
        ],
        "comment" : [
                     {token : "comment", regex : ".*?\\*\\/", next : "start"}, 
                     {token : "comment",regex : ".+"}
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