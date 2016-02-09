/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
// https://gist.github.com/lgarron/d1dee380f4ed9d825ca7

"use strict";

// polyfill 'for .. of' loops for browsers that don't have that (yet) (like Chrome)
NodeList.prototype[Symbol.iterator] = Array.prototype[Symbol.iterator];

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

var markCopied = function(element) {
    if (!element.classList.contains('copied')) {
        element.classList.add('copied');
    }
};

// DOMContentLoaded
window.addEventListener('DOMContentLoaded', function(e) {
    let preElements = document.querySelectorAll('.clipboard');

    for (let index in preElements) {
        let preElement = preElements[index];
        if (preElement && preElement.textContent) {
            preElement.addEventListener('click', function(event) {
                let value = preElement.textContent.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;');
                let alert = document.querySelector('#alert-container');
                let notice = notice1 + notice2 + '<span>' + value + '</span>' + notice3;
                let tmp = document.createElement('div');
                tmp.innerHTML = notice;

                copyToClipboard(preElement.textContent);
                alert.appendChild(tmp);
                markCopied(preElement);

                setTimeout(function() {
                    alert.removeChild(tmp);
                }, (1000));
            });
        }
    }

});
