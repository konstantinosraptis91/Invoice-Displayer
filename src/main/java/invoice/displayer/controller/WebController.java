package invoice.displayer.controller;

import invoice.displayer.entity.Invoice;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import invoice.displayer.client.InvoiceClient;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author konstantinos
 */
@Controller
public class WebController {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WebController.class);
    
    @Autowired
    private InvoiceClient invoiceClient;
        
    @RequestMapping(value = "/")
    public ModelAndView showIndex(HttpServletResponse response) 
            throws IOException {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/viewXSLT")
    public ModelAndView viewXSLT(HttpServletRequest request,
            HttpServletResponse response) throws IOException, JAXBException {
        Invoice invoice = invoiceClient.getInvoice(1);
          
        // builds absolute path of the XML file
        String xmlFile = "resources/invoice.xml";
        String contextPath = request.getServletContext().getRealPath("");
        String xmlFilePath = contextPath + File.separator + xmlFile;  
        File f = new File(xmlFilePath);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(invoice, f);
                 
        Source source = new StreamSource(f);
 
        // adds the XML source file to the model so the XsltView can detect
        ModelAndView model = new ModelAndView("XSLTView");
        model.addObject("xmlSource", source);
        
        // LOGGER.info("viewXSLT", Constants.LOG_DATE_FORMAT.format(new Date()));
        
        return model;
    }
            
}
