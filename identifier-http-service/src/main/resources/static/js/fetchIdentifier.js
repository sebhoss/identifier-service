"use strict";

function refreshIdentifier(preElement, path) {
    let httpRequest = new XMLHttpRequest();

    if (!httpRequest) {
        alert('Giving up :( Cannot create an XMLHTTP instance');
        return false;
    }

    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState == XMLHttpRequest.DONE ) {
           if(httpRequest.status == 200){
               preElement.innerHTML = '<strong>' + httpRequest.responseText + '</strong>';
           }
           else if(httpRequest.status == 400) {
               alert('There was an error 400')
           }
           else {
               alert('something else other than 200 was returned')
           }
        }
    }

    httpRequest.open("GET", path, true);
    httpRequest.setRequestHeader('Accept', 'text/plain');
    httpRequest.send();
};

document.addEventListener("DOMContentLoaded", function(event) {
    let identifiers = document.querySelectorAll('.identifier-container');

    for (let index in identifiers) {
      let idContainer = identifiers[index];
      if (idContainer) {
        let path = idContainer.querySelector('a').href;
        let preElement = idContainer.querySelector('pre');
        let refreshButton = idContainer.querySelector('img');

        refreshButton.addEventListener('click', function(event) {
            refreshIdentifier(preElement, path);
        });
      }
    }

});
