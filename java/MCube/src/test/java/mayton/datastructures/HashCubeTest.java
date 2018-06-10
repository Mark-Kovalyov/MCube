package mayton.datastructures;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import static org.junit.Assert.*;

public class HashCubeTest {

    static final String TEST_FILE = "OrderDetails.csv";
    static final int TEST_FILE_ROWS = 621884;

    static Logger logger = LoggerFactory.getLogger(HashCubeTest.class);

    static HashCube cnc;

    @Ignore
    @Test
    public void test() throws IOException {

        cnc = new HashCube("OrderId","ProductId","UnitPrice","Quantity","Discount");

        logger.info("Begin");

        URL url = Thread.currentThread().getContextClassLoader().getResource(TEST_FILE);

        CSVParser parser = CSVParser.parse(url.openStream(), StandardCharsets.UTF_8,
                CSVFormat.newFormat('|')
                        .withSkipHeaderRecord()
                        .withFirstRecordAsHeader());

        Iterator<CSVRecord> iterator = parser.iterator();

        int cnt = 0;

        while (iterator.hasNext()) {

            CSVRecord rec = iterator.next();

            String id        = rec.get("Id");
            String orderId   = rec.get("OrderId");
            String productId = rec.get("ProductId");
            String unitPrice = rec.get("UnitPrice");
            String quantity  = rec.get("Quantity");
            String discount  = rec.get("Discount");

            logger.trace("{}", rec.toString());

            cnc.set(orderId,productId,unitPrice,quantity,discount);

            cnt++;
        }

        logger.info("End");

        assertEquals("Should contains ~ 600 thousand rows without header",TEST_FILE_ROWS - 1, cnc.count());


        DictOptions quantityOptions = cnc.cardinalityMap.get("Quantity");

        assertNotNull("Quantity record exists", quantityOptions);

        assertNotNull("Quantity record field value2code exists", quantityOptions.value2code);

        assertNotNull("Quantity record field code2value exists", quantityOptions.code2value);

        assertTrue("Quantity field contains 12",             quantityOptions.value2code.containsKey("12"));
        assertEquals("Quantity field contains 12 -> 0", "0", quantityOptions.value2code.get(12));

        assertEquals("Quantity field reverse map contains 0 -> 12", "12", quantityOptions.code2value.containsKey("0"));



        assertTrue("Quantity field doesnt contains -1", quantityOptions.value2code.containsKey("-1"));

        assertFalse("Shouldnt contains ", cnc.check("","","","",""));

        //assertTrue("Should contains ", cnc.check("10248","11","14","12","0.0"));


    }


}
