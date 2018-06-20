define(["jquery", "codemirror", "javascript", "scheme"], function($, CodeMirror, javascript, scheme) {
    $(function() {

        var ele = $("#tx1")[0];
        var editor = CodeMirror.fromTextArea(ele, {
            mode: "scheme",
            lineNumbers: true
        });

        var looksLikeScheme = function(code) {
            return !/^\s*\(\s*function\b/.test(code) && /^\s*[;\(]/.test(code);
        };

        var update = function() {
            editor.setOption("mode", looksLikeScheme(editor.getValue()) ? "scheme" : "javascript");
        };

        var pending;

        editor.on("change", function() {
            clearTimeout(pending);
            pending = setTimeout(update(), 400)
        });

    });

});