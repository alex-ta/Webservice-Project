package example;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.Dao;
import dao.HobbyDao;
import data.*;
import service.RestService;

@Path("/users/{uid}/hobbies")
public class HobbyService extends RestService<String,Hobby>{
	private Dao<Hobby> dao = new HobbyDao();
    
	@Override
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response postJSON(Hobby o) {
		System.out.println("POST "+o);
		dao.save(o);
		return Response.ok().build();
	}

	@Override
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response putJSON(Hobby o, @PathParam("id") String id) {
		System.out.println("PUT "+id+" "+o);
		dao.save(o);
		return Response.ok().build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response deleteJSON(@PathParam("id") String id) {
		System.out.println("DELETE "+id);
		dao.delete(id);
		return Response.ok().build();
	}

	@Override
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response getJSON(@PathParam("uid") String uid, @PathParam("id") String id) {
		Hobby o;
		if(id.equals("null")){
			o = new Hobby(uid);
		} else {
			o = dao.get(uid, id);
		}
		return Response.ok().entity(o).build();
	}

	@Override
	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response getAllJSON(@PathParam("uid") String uid) {
		System.out.println("ALL "+dao.getAll(uid));
		return Response.ok().entity(dao.getAll(uid)).build();
	}
	
	@Override
	@HEAD
	@Path("/")
	public Response headJSON() {
		System.out.println("HEAD");
		return Response.ok().build();
	}
}
