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
import dao.SkillDao;
import data.*;
import service.RestService;

@Path("/users/{uid}/skills")
public class SkillService extends RestService<String,Skill>{
	private Dao<Skill> dao = new SkillDao();
    
	@Override
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response postJSON(Skill o) {
		System.out.println("POST "+o);
		dao.save(o);
		return Response.ok().build();
	}

	@Override
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response putJSON(Skill o, @PathParam("id") String id) {
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
	public Response getJSON(@PathParam("id") String id) {
		System.out.println("SINGEL "+ dao.get(id));
		return Response.ok().entity(dao.get(id)).build();
	}

	@Override
	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response getAllJSON() {
		System.out.println("ALL "+dao.getAll());
		return Response.ok().entity(dao.getAll()).build();
	}
	
	@Override
	@HEAD
	@Path("/")
	public Response headJSON() {
		System.out.println("HEAD");
		return Response.ok().build();
	}
}
