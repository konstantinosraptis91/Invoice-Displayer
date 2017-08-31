package invoice.displayer.client;

import invoice.displayer.entity.Invoice;
import invoice.displayer.entity.InvoiceList;
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
    
    public Invoice getInvoice(int id) {
        return restOperations.getForObject(URL + "/{id}", Invoice.class, id);
    }
        
    public InvoiceList getInvoices() {
        return restOperations.getForObject(URL, InvoiceList.class);
    }
   
}
