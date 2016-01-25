// https://gist.github.com/lgarron/d1dee380f4ed9d825ca7

"use strict";

const notice1 = '<div class="alert-box notice">';
const notice2 = '<span class="alert-type">notice: </span>Clipboard now contains: ';
const notice3 = '</div>';

var copyToClipboard = (function() {
    var _dataString = null;

    document.addEventListener("copy", function(e) {
        if (_dataString !== null) {
            try {
                e.clipboardData.setData("text/plain", _dataString);
                e.preventDefault();
            } finally {
                _dataString = null;
            }
        }
    });

    return function(data) {
        _dataString = data;
        document.execCommand("copy");
    };
})();

// DOMContentLoaded
window.addEventListener('WebComponentsReady', function(e) {
    let preElements = document.querySelectorAll('pre');

    for (let index in preElements) {
        let preElement = preElements[index];
        if (preElement && preElement.textContent) {
            preElement.addEventListener('click', function(event) {
                let value = preElement.textContent.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;');
                let alert = document.querySelector('#alert-container');
                let notice = notice1 + notice2 + '<span>' + value + '</span>' + notice3;
                let tmp = document.createElement('div');
                tmp.innerHTML = notice;

                alert.appendChild(tmp)
                copyToClipboard(preElement.textContent)

                setTimeout(function() {
                    alert.removeChild(tmp);
                }, (1000));
            });
        }
    }

});
