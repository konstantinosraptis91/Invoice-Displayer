package invoice.displayer.client;

import invoice.displayer.model.Invoice;
import invoice.displayer.model.InvoiceList;
import invoice.displayer.util.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author konstantinos
 */
@Component
public class InvoiceClient {
    
    @Autowired
    private RestOperations restOperations;
    private final String URL;
        
    @Autowired
    public InvoiceClient(@Value("${invoice.service.url}") final String url) {
        this.URL = url;
    }
    
    public Invoice getInvoice(int id, Entity e) {
        return restOperations.getForObject(URL + "/{id}" + "?entity=" + e.getValue(), Invoice.class, id);
    }
        
    public InvoiceList getInvoices(Entity e) {
        return restOperations.getForObject(URL + "?entity=" + e.getValue(), InvoiceList.class);
    }
   
}
