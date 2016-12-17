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
import dao.TemplateDao;
import data.*;
import service.RestService;

@Path("/templates")
public class TemplateService extends RestService<String,Template>{
	private Dao<Template> dao = new TemplateDao();
    
	@Override
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response postJSON(Template o) {
		System.out.println("POST "+o);
		dao.save(o);
		return Response.ok().build();
	}

	@Override
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response putJSON(Template o, @PathParam("id") String id) {
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
