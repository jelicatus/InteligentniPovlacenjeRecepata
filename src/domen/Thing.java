package domen;

import java.net.URI;

import thewebsemantic.Id;
import thewebsemantic.RdfProperty;
import util.Constants;


public class Thing {

	@Id
	private URI uri;
        
        @RdfProperty(Constants.SCHEMA+ "image")
        private URI slika;
        
        @RdfProperty(Constants.SCHEMA+ "url")
        private String urlRecepta;
	
	public URI getUri() {
		return uri;
	}
        
        

	public void setUri(URI uri) {
		this.uri = uri;
	}
   public URI getSlika() {
        return slika;
    }

    public void setSlika(URI slika) {
        this.slika = slika;
    }

    public String getUrlRecepta() {
        return urlRecepta;
    }

    public void setUrlRecepta(String urlRecepta) {
        this.urlRecepta = urlRecepta;
    }

   
    
    
        
        
        
        
}
