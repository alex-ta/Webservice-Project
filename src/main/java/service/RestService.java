package service;

import javax.ws.rs.core.Response;


public abstract class RestService <I,O> {
	
	public Response postXML(O o){
		return Response.serverError().build();
	}
	public Response postJSON(O o){
		return Response.serverError().build();
	}
	public Response postFORM(O o){
		return Response.serverError().build();
	}
	
	public Response putXML(I i, O o){
		return Response.serverError().build();
	}
	
	public Response putJSON(O o, I i){
		return Response.serverError().build();
	}
	
	public Response putFORM(I i, O o){
		return Response.serverError().build();
	}
	
	public Response deleteXML(I o){
		return Response.serverError().build();
	}
	
	public Response deleteJSON(I o){
		return Response.serverError().build();
	}
	
	public Response deleteFORM(I o){
		return Response.serverError().build();
	}
	
	public Response getXML(I o){
		return Response.serverError().build();
	}
	public Response getJSON(I o){
		return Response.serverError().build();
	}
	public Response getFORM(I o){
		return Response.serverError().build();
	}
	
	public Response getXML(I o, I p){
		return Response.serverError().build();
	}
	public Response getJSON(I o, I p){
		return Response.serverError().build();
	}
	public Response getFORM(I o, I p){
		return Response.serverError().build();
	}
	
	public Response getAllXML(){
		return Response.serverError().build();
	}
	public Response getAllJSON(){
		return Response.serverError().build();
	}
	public Response getAllFORM(){
		return Response.serverError().build();
	}

	public Response getAllXML(I id){
		return Response.serverError().build();
	}
	public Response getAllJSON(I id){
		return Response.serverError().build();
	}
	public Response getAllFORM(I id){
		return Response.serverError().build();
	}
	
	public Response headXML(){
		return Response.serverError().build();
	}
	public Response headJSON(){
		return Response.serverError().build();
	}
	public Response headFORM(){
		return Response.serverError().build();
	}
	
}
