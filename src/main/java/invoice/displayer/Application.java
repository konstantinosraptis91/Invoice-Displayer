/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice.displayer;

import invoice.displayer.client.InvoiceClient;
import invoice.displayer.entity.EntityList;
import invoice.displayer.entity.Invoice;
import invoice.displayer.util.Constants;
import java.util.Date;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private InvoiceClient invoiceClient;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            //Invoice invoice = invoiceClient.getInvoice(1);
            EntityList<Invoice> invoices = invoiceClient.getInvoices();
            LOGGER.info(invoices.getItems().toString() + "", Constants.LOG_DATE_FORMAT.format(new Date()));
        };
    }

}
