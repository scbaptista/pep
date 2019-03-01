sessionStorage

var warUrl = 'http://localhost:8080/PEP/';

var ajax = function(urlServler, token, op ){

    if(urlServler == null && op == null){
        return 'Erro ....';
    } else if (urlServler != null && op != null && token != null) {
        var url = warUrl+"serv/"+urlServler+"?op="+op+"&token="+token;
        console.log(url);
        var result;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
            
            result = {'val': 1, 'res': this.responseText};
            console.log('teste -> ',result);
            
          }else{
            result= 'Erro ....';
          }
        };
      
        xhttp.open("POST", url, false);
        xhttp.send();

        return result;

    } else if (urlServler != null && op != null && token == null) {
        var url = warUrl+"serv/"+urlServler+"?op="+op;

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            return this.responseText;
          }else{
              return 'Erro ....';
          }
        };
      
        xhttp.open("POST", url, false);
        xhttp.send();

    } else{
        return 'Erro ....';
    }

    
    
    
}