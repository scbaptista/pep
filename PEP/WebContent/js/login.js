$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

    if (e.type === 'keyup') {
      if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
      if( $this.val() === '' ) {
        label.removeClass('active highlight'); 
      } else {
        label.removeClass('highlight');   
      }   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
        label.removeClass('highlight'); 
      } 
      else if( $this.val() !== '' ) {
        label.addClass('highlight');
      }
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});


var dologin = function (){

  var email = document.getElementById('email_login').value;
  var pass = document.getElementById('pass_login').value;

  var json = {'email':email,'pass':pass};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
   console.log(this);
   
     if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      window.location.href="index.html";
    }
  
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/login?op=1&token="+token, false);
  xhttp.send();

}

var doregist = function(){
  var firstname = document.getElementById("firtname_regist").value;
  var lastname = document.getElementById("lastname_regist").value;
  var email = document.getElementById('email_regist').value;
  var pass = document.getElementById('pass_regist').value;

  var name = firstname + " " + lastname;


  var json = {'email':email,'pass':pass, 'nome':name};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      document.getElementById('msgResult').innerHTML = msg;
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/user?op=2&token="+token, false);
  xhttp.send();

}