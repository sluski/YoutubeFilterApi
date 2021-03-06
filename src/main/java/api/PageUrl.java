package api;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import youtube.POJO.Video;
import youtube.VideoCreator;

/**
 * REST Web Service
 *
 * @author Sluski
 */
@Path("videos")
public class PageUrl {
    private String path;
    private VideoCreator videosFilter;

    @Context
    private UriInfo context;

    public PageUrl() {
    }

    public String getPath() {
        return path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getJson() throws IOException {
        videosFilter = new VideoCreator();
        return videosFilter.getVideos("https://www.youtube.com/results?search_query=onerepublic");
    }
}
