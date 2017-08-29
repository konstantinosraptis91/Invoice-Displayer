package invoice.displayer;

import invoice.displayer.client.InvoiceClient;
import invoice.displayer.entity.InvoiceList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author konstantinos
 */
@SpringBootApplication
public class Application {

//    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

//    @Autowired
//    private InvoiceClient invoiceClient;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner run() throws Exception {
//        return args -> {
//            InvoiceList invoices = invoiceClient.getInvoices();
//            
//            JAXBContext jaxbContext = JAXBContext.newInstance(InvoiceList.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(invoices, System.out);
//
//            LOGGER.info(invoices.getInvoice().toString() + "", Constants.LOG_DATE_FORMAT.format(new Date()));
//        };
//    }

}
