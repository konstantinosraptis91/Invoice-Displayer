package invoice.displayer.controller;

import invoice.displayer.model.Invoice;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import invoice.displayer.client.InvoiceClient;
import invoice.displayer.util.Entity;
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

    @RequestMapping(value = "/view-invoice-xslt-for-customer")
    public ModelAndView viewInvoiceXSLTForCustomer(HttpServletRequest request,
            HttpServletResponse response) throws IOException, JAXBException {
        return getModelAndViewFor(1, Entity.CUSTOMER, request);
    }
       
    @RequestMapping(value = "/view-invoice-xslt-for-supplier")
    public ModelAndView viewInvoiceXSLTForSupplier(HttpServletRequest request,
            HttpServletResponse response) throws IOException, JAXBException {
        return getModelAndViewFor(1, Entity.SUPPLIER, request);
    }
    
    @RequestMapping(value = "/view-invoice-xslt-for-transportation-company")
    public ModelAndView viewInvoiceXSLTForTransportationCompany(HttpServletRequest request,
            HttpServletResponse response) throws IOException, JAXBException {
        return getModelAndViewFor(1, Entity.TRANSPORTATION_COMPANY, request);
    }
    
    private ModelAndView getModelAndViewFor(int id, Entity e, 
            HttpServletRequest request) throws IOException, JAXBException {
        Invoice invoice = invoiceClient.getInvoice(id, e);
          
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
