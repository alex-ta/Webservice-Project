  

var x;

client = function(){

	var baseUrl = "http://localhost:8080/helloworld/rest/users"
		
	this.getAll = function() { 
		$.ajax({
			 url: baseUrl,
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
  		         "Accept": "application/json",
  		         "Content-Type": "application/json; charset=utf-8"
  		         }
	 }).then(function(data) {
		 x=data;
		 console.log(data);
	 });
	}

	this.get = function(id){
		$.ajax({
			 url: baseUrl+"/"+id,
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
 		         "Accept": "application/json",
 		         "Content-Type": "application/json; charset=utf-8"
			 	 }
	 }).then(function(data) {
		 x=data;
		 console.log(data);
	 });
	}
	
	this.delete = function(id){
		$.ajax({
			 url: baseUrl+"/"+id,
			 type: 'DELETE',
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
 		         "Accept": "application/json",
 		         "Content-Type": "application/json; charset=utf-8"
			     }
	 }).then(function(data) {
		 x=data;
		 console.log(data);
	 });
	}

	this.post = function(obj){
		$.ajax({
			 url: baseUrl,
			 type: 'POST',
			 data: JSON.stringify(obj),
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
 		         "Accept": "application/json",
 		         "Content-Type": "application/json; charset=utf-8"
			     }
	 }).then(function(data) {
		 x=data;
		 console.log(data);
	 });
	}
	
	this.put = function(obj){
		$.ajax({
			 url: baseUrl+"/"+id,
			 type: 'PUT',
			 data: JSON.stringify(obj),
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
 		         "Accept": "application/json",
 		         "Content-Type": "application/json; charset=utf-8"
			     }
	 }).then(function(data) {
		 x=data;
		 console.log(data);
	 });
	}
	
	this.head = function(){
		$.ajax({
			 url: baseUrl,
			 type: 'HEAD',
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
 		         "Accept": "application/json",
 		         "Content-Type": "application/json; charset=utf-8"
			     }
	 }).then(function(data) {
		 x=data;
		 console.log(data);
	 });
	}

	
}
