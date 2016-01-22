"use strict";

function copyToClipboard(preElement) {
    if (preElement) {
        let range = document.createRange();
        range.selectNode(preElement);
        window.getSelection().addRange(range);

        try {
            document.execCommand('copy');
        } catch(err) {
            console.log('Oops, unable to copy');
        }

        window.getSelection().removeAllRanges();
    }
};

const notice1 = '<div class="alert-box notice">';
const notice2 = '<span class="alert-type">notice: </span>Clipboard now contains: ';
const notice3 = '</div>';

document.addEventListener("DOMContentLoaded", function(event) {
    let identifiers = document.querySelectorAll('pre');

    for (let index in identifiers) {
      let id = identifiers[index];
      if (id && id.textContent) {
        id.addEventListener('click', function(event) {
          let alert = document.querySelector('#alert-container');
          let notice = notice1 + notice2 + '<span>' + id.textContent.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;') ; + '</span>' + notice3;
          let tmp = document.createElement('div');
          tmp.innerHTML = notice;

          alert.appendChild(tmp)

          copyToClipboard(id);

          setTimeout(function() {
              alert.removeChild(tmp);
          }, (1000));
        });
      }
    }

});
