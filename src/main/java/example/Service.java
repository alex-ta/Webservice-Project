package example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("/")
public class Service 
{
	
	public Service(){
		d.setId(10);
		d.setName("Serve");
		d.setText("This Service contains some content");
	}
	
	private Data d = new Data();
	
	
	
	@GET
	@Produces("text/html")
	public Response getStartingPagePLAIN()
	{
		return Response.ok().entity(d.toString()).build();
	}
	
	
	@GET
	@Produces("application/json")
	public Response getStartingPage()
	{
		return Response.ok().entity(d).build();
	}
	
}

class Data {
	
	public Data(){}
	
	private int id;
	private String name;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", text=" + text + "]";
	}
		
}
