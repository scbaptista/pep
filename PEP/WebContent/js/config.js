var doLogout = function(){
	sessionStorage.clear();
	window.location.href = warUrl;
}

var docHeigth =  $( document ).height();

var getModal = function(idModal){
    console.log('btn');
  // Get the modal
  var modal = document.getElementById(idModal);
  modal.style.display = "block";
  // When the user clicks on <span> (x), close the modal
  //span.onclick = function() {
    //  modal.style.display = "none";
  //}

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
      if (event.target == modal) {
          modal.style.display = "none";
      }
  }
}

var getCanselBtn = function(idModal){
  var modal = document.getElementById(idModal);
  modal.style.display = "none";
}

var Expand = function () {
  var tile = $('.strips__strip');
  var tileLink = $('.strips__strip > .strip__content');
  var tileText = tileLink.find('.strip__inner-text');
  var stripClose = $('.strip__close');

  var expanded = false;

  var open = function open() {

    var tile = $(this).parent();

    if (!expanded) {
      tile.addClass('strips__strip--expanded');
      // add delay to inner text
      tileText.css('transition', 'all .5s .3s cubic-bezier(0.23, 1, 0.32, 1)');
      stripClose.addClass('strip__close--show');
      stripClose.css('transition', 'all .6s 1s cubic-bezier(0.23, 1, 0.32, 1)');
      expanded = true;
    }
  };

  var close = function close() {
    if (expanded) {
      tile.removeClass('strips__strip--expanded');
      // remove delay from inner text
      tileText.css('transition', 'all 0.15s 0 cubic-bezier(0.23, 1, 0.32, 1)');
      stripClose.removeClass('strip__close--show');
      stripClose.css('transition', 'all 0.2s 0s cubic-bezier(0.23, 1, 0.32, 1)');
      expanded = false;
    }
  };

  var bindActions = function bindActions() {
    tileLink.on('click', open);
    stripClose.on('click', close);
  };

  var init = function init() {
    bindActions();
  };

  return {
    init: init };


}();

Expand.init();
      //# sourceURL=pen.js