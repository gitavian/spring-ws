package com.mycompany.hr.ws;

import com.mycompany.hr.schemas.HolidayRequest;
import com.mycompany.hr.schemas.HolidayResponse;
import com.mycompany.hr.service.HumanResourceService;

import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by obalaban on 11/5/2014.
 */

@Endpoint
public class HolidayEndpoint {

    private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

    private XPath startDateExpression;
    private XPath endDateExpression;
    private XPath nameExpression;
    private HumanResourceService humanResourceService;

    @Autowired
    public HolidayEndpoint(HumanResourceService humanResourceService)
            throws JDOMException

    {
        this.humanResourceService = humanResourceService;
        Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

        startDateExpression = XPath.newInstance("//hr:StartDate");
        startDateExpression.addNamespace(namespace);

        endDateExpression = XPath.newInstance("//hr:EndDate");
        endDateExpression.addNamespace(namespace);

        nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
        nameExpression.addNamespace(namespace);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")
    public @ResponsePayload HolidayResponse holidayResponse (@RequestPayload HolidayRequest holidayRequest)
            throws Exception {

        HolidayResponse response = new HolidayResponse();
        System.out.println("-----> Entered in the payload");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date endDate = new Date();
        String name = "Name";

        humanResourceService.bookHoliday(startDate, endDate, name);

        return response;
    }
}
